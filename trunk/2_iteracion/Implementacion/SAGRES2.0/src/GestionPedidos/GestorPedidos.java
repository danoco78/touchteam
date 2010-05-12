/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package GestionPedidos;

import ControladorImpresora.IImpresion;
import java.util.ArrayList;
import GestionCarta.*;
import GestionBaseDatos.IPedidosBD;
import GestionStock.GestionProductos.IProducto;
import GestionStock.GestionProductos.Producto;
import java.util.Collection;
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

        // TODO Esta implementación no está reflejada en el diseño
        return this.iPedidosBD.getSiguientePedidoBar();




        /*ArrayList<Pedido> noFacturados;
        ArrayList<ElementoPedido> elementos;
        noFacturados = iPedidosBD.obtienePedidosNoFacturados();

        Pedido pedido = null;
        ElementoPedido elemP = null;
        Pedido ped;
        
        Iterator<Pedido> iterador = noFacturados.iterator();
        Integer estado=-1;
        boolean encontrado = false;
        Date fecha=null, fechaPedido=null;
        while(iterador.hasNext()){
            encontrado = false;
            ped = ((Pedido)iterador.next());
            elementos = ped.obtieneElementos();
            Iterator<ElementoPedido> ite2 = elementos.iterator();
            while (ite2.hasNext() && !encontrado){
                elemP = ite2.next();
                if(elemP instanceof ElementoColaBar){
                    estado = ((ElementoColaBar)elemP).getEstado();
                    if(estado == ElementoColaBar.ENCOLA)
                        encontrado = true;
                }
            }
            if(encontrado){
                fecha = ped.getFecha();
                if (pedido != null){
                    fechaPedido = pedido.getFecha();
                    pedido = ped;
                }
                else{
                    if (fecha.before(fechaPedido)){
                        pedido = ped;
                    }
                }
            }
        }
        if(pedido == null)
                 throw new Exception("No hay siguiente pedido en cola de bar");
        return pedido;*/
    }

    public Pedido getSiguientePedidoCocinaEncola()throws Exception{
        ArrayList<Pedido> noFacturados;
        ArrayList<ElementoPedido> elementos;
        noFacturados = iPedidosBD.obtienePedidosNoFacturados();
        ElementoPedido elemP = null;

        Pedido pedido = null;

        Iterator iterador = noFacturados.iterator();
        Integer estado=-1;
        boolean encontrado = false;
        Date fecha=null, fechaPedido=null;
        while(iterador.hasNext()){
            Pedido ped = ((Pedido)iterador.next());
            elementos = ped.obtieneElementos();
            Iterator ite2 = elementos.iterator();
            while (ite2.hasNext() && !encontrado){
                elemP = (ElementoPedido)ite2.next();
                if(elemP instanceof ElementoColaCocina){
                    estado = elemP.getEstado();
                    if(estado == ElementoColaCocina.ENCOLA)
                        encontrado = true;
                }
            }
            if(encontrado){
                fecha = ped.getFecha();
            }
            if( encontrado && pedido != null){
                fechaPedido = pedido.getFecha();
            }
            if(ite2.next() instanceof ElementoColaCocina && encontrado &&
                    (pedido == null || fecha.before(fechaPedido))){
                pedido = ped;
            }
        }
        if(pedido == null)
                 throw new Exception("No hay siguiente pedido en cola de cocina");
        return pedido;
    }

    public void imprimeFactura(Integer codMesa){
        Factura f = this.iPedidosBD.getFactura(codMesa);
        f.modificaEstado(Factura.IMPRIMIDO);
        this.iPedidosBD.actualizaFactura(f);
        this.iImpresion.imprimeFactura(f);
    }

    public ArrayList<Pedido> iniciaModificaPedido(Integer codMesa){
        return new ArrayList<Pedido>(); //Para quitar errores
    }

    public boolean modificaPedido(Integer codPedido, ArrayList<ElementoPedido> elems){
        return true;
    }

    public boolean nuevoPedido(Integer codMesa, ArrayList<ElementoPedido> elems){
        return this.iPedidosBD.nuevoPedido(codMesa, elems);
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
        ArrayList<Pedido> noFacturados = this.iPedidosBD.obtienePedidosNoFacturados();
        ArrayList<Pedido> pedidos = new ArrayList<Pedido>();
        ArrayList<ElementoPedido> elementos = new ArrayList<ElementoPedido>();
        Iterator<Pedido> ite = noFacturados.iterator();
        Boolean romper = false;
        int estado;

        while(ite.hasNext()){
            romper = false;
            Pedido p = ((Pedido)ite.next());
            elementos = p.obtieneElementos();
            Iterator ite2 = elementos.iterator();
            while(ite2.hasNext() && !romper){
                ElementoPedido ep = (ElementoPedido)ite2.next();
                if(ep instanceof ElementoColaCocina ){ //Si es ColaCocina
                     estado = ep.getEstado();
                     if(estado == ElementoColaCocina.PREPARADO ) romper = true;
                }
            }
            if(romper){
                pedidos.add(p);
            }
        }
        if(pedidos.isEmpty())
            throw new Exception("No hay pedidos preparándose en la cola de cocina");
        return pedidos;
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
            if(estado == ElementoColaBar.ENCOLA){
                p.setEstado(Pedido.BLOQUEADO); //Cambiamos los estados
                ele.setEstado(ElementoColaBar.PREPARADO);
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

    public ArrayList<Pedido> getPedidos(int codMesa){
        return this.iPedidosBD.getPedidos(codMesa);
    }
}

