/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package GestionPedidos;

import ControladorImpresora.IImpresion;
import java.util.ArrayList;
import GestionCarta.*;
import GestionBaseDatos.IPedidosBD;
import GestionCarta.ElementoPlato;
import GestionStock.GestionProductos.IProducto;
import GestionStock.GestionProductos.Producto;
import java.util.Iterator;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import utilidades.Pair;

/**
 *
 * @author Gaspar
 */
public class GestorPedidos implements IGestorPedidos {

    IPedidosBD iPedidosBD;
    IProducto iProducto;
    IImpresion iImpresion;

    public GestorPedidos(IPedidosBD iPedidosBD, IProducto iProducto, IImpresion iImpresion){
        this.iPedidosBD = iPedidosBD;
        this.iProducto = iProducto;
        this.iImpresion = iImpresion;
    }

    //TODO implementar todos los diagramas de colaboracion
    public void confirmaPagoFactura(Integer codMesa){
        Factura f = this.iPedidosBD.getFactura(codMesa);
        ArrayList<Pedido> pedidos = f.getPedidos();
        Pedido p;
        for (int i=0;i<pedidos.size();i++){
            p = pedidos.get(i);
            p.setEstado(Pedido.FACTURADO);
            this.iPedidosBD.actualizaPedido(p);
        }
        f.modificaEstado(Factura.PAGADO);
        this.iPedidosBD.actualizaFactura(f);
    }

    public ArrayList<String> getInfoRest(){
        return new ArrayList<String>(); //Para quitar errores
    }

    public Pedido getSiguientePedidoBar()throws Exception{

        return this.iPedidosBD.getSiguientePedidoBar();

    }

    public Pedido getSiguientePedidoCocinaEncola()throws Exception{
        ArrayList<Pedido> noFacturados;
        ArrayList<ElementoPedido> elementos;
        noFacturados = iPedidosBD.obtienePedidosPreparandose();
        ElementoPedido elemP = null;

        Pedido pedido = null;

        Iterator iterador = noFacturados.iterator();
        Integer estado=-1;
        boolean encontrado = false;
        Date fecha=null, fechaPedido=null;
        while(iterador.hasNext()){ //Iteramos sobre los pedidos no facturados aun
            Pedido ped = ((Pedido)iterador.next());
            elementos = ped.obtieneElementos(); //Obtenemos los ElementosPedidos de un pedido
            Iterator ite2 = elementos.iterator();
            while (ite2.hasNext() && !encontrado){ //Iteramos sobre ellos
                elemP = (ElementoPedido)ite2.next(); //Obtenemos el siguiente
                if(elemP instanceof ElementoColaCocina){ //Si es de tipo ColaCocina
                    estado = elemP.getEstado();
                    if(estado == ElementoColaCocina.ENCOLA) // Y el estado es en cola, ponemos una señal a true
                        encontrado = true;
                }
            }
            if(encontrado){ //Obtenemos su fecha del pedido actual
                fecha = ped.getFecha();
            }
            if( encontrado && pedido != null){
                fechaPedido = pedido.getFecha(); //Obtenemos la fecha del pedido guardado por ahora
            }
            if(ite2.next() instanceof ElementoColaCocina && encontrado &&
                    (pedido == null || fecha.before(fechaPedido))){  //Comparamos y si es mas reciente, asignamos
                pedido = ped;
            }
        }
        if(pedido == null)
                 throw new Exception("No hay siguiente pedido en cola de cocina");
        return pedido;
    }

    public void imprimeFactura(Integer codMesa){
        Factura f = this.getFactura(codMesa);
        f.modificaEstado(Factura.IMPRIMIDO);
        this.iPedidosBD.actualizaFactura(f);
        this.iImpresion.imprimeFactura(f);
    }

    public ArrayList<Pedido> iniciaModificaPedido(Integer codMesa){
        return new ArrayList<Pedido>(); //Para quitar errores
    }

    public boolean modificaPedido(Integer codPedido, Integer codMesa, ArrayList<Pair<Elemento, String> > elementosPedido){
        if(this.eliminaPedido(codPedido)){
            return this.nuevoPedido(codMesa, elementosPedido);
        }
        return false;
    }

    public boolean nuevoPedido(Integer codMesa, ArrayList<Pair<Elemento,String> > elementosPedido){
        int codPedido = this.iPedidosBD.getCodigoPedido();
        Pedido pedido = new Pedido(codMesa, codPedido, 0, new java.util.Date());

        Iterator it = elementosPedido.iterator();
        int codEP = this.iPedidosBD.getCodigoElementoPedido();
        while(it.hasNext()){
            Pair<Elemento,String> temp = (Pair<Elemento, String>) it.next();
            Elemento elem = temp.getFirst();

            ElementoPedido elemPedido;
            if(elem instanceof ElementoPlato){
                elemPedido = new ElementoColaCocina(codEP, 0, temp.getSecond());
                elemPedido.asocia(elem);
                pedido.asocia((ElementoColaCocina) elemPedido);
            }else{
                elemPedido = new ElementoColaBar(codEP, 0, temp.getSecond());
                elemPedido.asocia(elem);
                pedido.asocia((ElementoColaBar) elemPedido);
            }
            codEP++;
        }

        return this.iPedidosBD.nuevoPedido(pedido);
    }

    public ArrayList<ElementoPedido> obtieneElementos(Integer codPedido){
        return new ArrayList<ElementoPedido>(); //Para quitar errores
    }

    public int getNumPlatosEnCola() {
        return this.iPedidosBD.getNumPlatosEnCola();
    }
    public int getNumBebidasEnCola(){
        return this.iPedidosBD.getNumBebidasEnCola();
    }

    public ArrayList<Pedido> getPedidosCocinaPreparandose() throws Exception{
        return this.iPedidosBD.obtienePedidosPreparandose();
    }

    public boolean seleccionaPlato(Pedido p, ElementoColaCocina ele) throws Exception {
        boolean exito=true, existe = false;
        int estado;
        ElementoPlato elem;
        HashMap<Producto,Float> prods;

        ArrayList<ElementoPedido> elementos = p.obtieneElementos();
        existe = elementos.contains(ele); // Comprobar si funciona el equals

        if(existe){
            estado = ele.getEstado();
            if(estado == ElementoColaCocina.ENCOLA){
                p.setEstado(Pedido.BLOQUEADO); //Cambiamos los estados
                ele.setEstado(ElementoColaCocina.PREPARANDOSE);
                this.iPedidosBD.actualizaPedido(p);
                elem = (ElementoPlato) ele.getElemento();
                prods = elem.getProductos();
                Iterator ite = prods.entrySet().iterator();
                Producto prod;
                Float cantidad;
                Map.Entry entrada;
                while (ite.hasNext()) { //Restamos las cantidades de todos los productos
                    entrada = (Map.Entry)ite.next();
                    prod = (Producto) entrada.getKey();
                    cantidad = (Float)entrada.getValue();
                    this.iProducto.restarCantidadProducto(prod,cantidad);
                }
            }
            else if(estado == ElementoColaCocina.PREPARANDOSE){
                ele.setEstado(ElementoColaCocina.PREPARADO);
                this.iPedidosBD.actualizaPedido(p);
            }
            else{
                exito = false;
            }
        }
        else{
            throw new Exception("El plato no existe en ese pedido");
        }
        return exito;
    }

    public boolean seleccionaBebida(Pedido p, ElementoColaBar ele) throws Exception {
        boolean exito=true, existe = false;
        int estado;
        ElementoBebida elem;
        HashMap<Producto,Float> prods;

        ArrayList<ElementoPedido> elementos = p.obtieneElementos();
        existe = elementos.contains(ele); // Comprobar si funciona el equals
        
        if(existe){
            estado = ele.getEstado();
            if(estado == ElementoColaBar.ENCOLA){
                p.setEstado(Pedido.BLOQUEADO); //Cambiamos los estados
                ele.setEstado(ElementoColaBar.PREPARADO);
                this.iPedidosBD.actualizaPedido(p);
                elem = (ElementoBebida) ele.getElemento();
                prods = elem.getProductos();
                Iterator ite = prods.entrySet().iterator();
                Producto prod;
                Float cantidad;
                Map.Entry entrada;
                while (ite.hasNext()) { //Restamos las cantidades de todos los productos
                    entrada = (Map.Entry)ite.next();
                    prod = (Producto) entrada.getKey();
                    cantidad = (Float)entrada.getValue();
                    this.iProducto.restarCantidadProducto(prod,cantidad);
                }
            }
            else{
                exito = false;
            }
        }
        else{
            throw new Exception("La bebida no existe en ese pedido.");
        }
        return exito;
    }

    public Factura getFactura(int codMesa){
        return this.iPedidosBD.getFactura(codMesa);
    }

    public ArrayList<Pedido> getPedidosModificablesMesa(int codMesa){
        return this.iPedidosBD.getPedidosModificablesMesa(codMesa);
    }
    
    public ArrayList<Integer> getFacturasEnCola(){
        return this.iPedidosBD.getFacturasEnCola();
    }

    public ArrayList<Integer> getFacturasImprimidas(){
        return this.iPedidosBD.getFacturasImprimidas();
    }

    public boolean eliminaPedido(int codPedido){
        return this.iPedidosBD.eliminaPedido(codPedido);
    }

    public Pedido getSiguientePedidoCocina(){
        return iPedidosBD.getSiguientePedidoCocina();
    }

    public Factura pideFactura(int codMesa){
        //Eliminamos la anterior factura asociada a la mesa
        this.iPedidosBD.eliminaFactura(codMesa);

        //Creamos una nueva factura
        Factura f = new Factura(this.iPedidosBD.getCodigoFactura(), 0, new Date()); // TODO new Timestamp

        //Asociamos los pedidos correspondientes
        ArrayList<Pedido> listaPedidos = this.iPedidosBD.obtienePedidosMesa(codMesa);
        Iterator it = listaPedidos.iterator();
        while(it.hasNext()){
            Pedido pedido = (Pedido) it.next();
            f.asocia(pedido);
        }

        this.iPedidosBD.nuevaFactura(f);

        return f;
    }

    public ArrayList<Pedido> obtienePedidosMesa(int codMesa){
        return this.iPedidosBD.obtienePedidosMesa(codMesa);
    }
}

