/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package GestionPedidos;

import java.util.ArrayList;
import GestionCarta.*;
import GestionBaseDatos.IPedidosBD;
import GestionStock.GestionProductos.IProducto;
import GestionStock.GestionProductos.Producto;
import java.util.Collection;
import java.util.Iterator;
import java.util.Date;
import java.util.HashMap;
import utilidades.Pair;

/**
 *
 * @author Gaspar
 */
public class GestorPedidos implements IGestorPedidos {

    IPedidosBD iPedidosBD;
    IProducto iProducto;

    //TODO implementar todos los diagramas de colaboracion
    public void confirmaPagoFactura(Integer codMesa){
        ArrayList<Pedido> ped;
        ArrayList<ElementoPedido> elemPed;
        ArrayList<Elemento> elementos;
    }

    public ArrayList<String> getInfoRest(){
        return new ArrayList<String>(); //Para quitar errores
    }

    public Pedido getSiguientePedidoBar()throws Exception{
        ArrayList<Pedido> noFacturados;
        ArrayList<ElementoPedido> elementos;
        noFacturados = iPedidosBD.obtienePedidosNoFacturados();

        Pedido pedido = null;

        Iterator iterador = noFacturados.iterator();
        Integer estado=-1;
        boolean encontrado = false;
        Date fecha=null, fechaPedido=null;
        while(iterador.hasNext()){
            encontrado = false;
            elementos = ((Pedido)iterador.next()).obtieneElementos();
            Iterator ite2 = elementos.iterator();
            while (ite2.hasNext()){
                if(ite2.next() instanceof ElementoColaBar){
                    estado = ((ElementoColaBar)ite2.next()).getEstado();
                    if(estado == ElementoColaBar.ENCOLA)
                        encontrado = true;
                }
            }
            if(encontrado){
                fecha = ((Pedido)iterador.next()).getFecha();
            }
            if( encontrado && pedido != null){
                fechaPedido = pedido.getFecha();
            }
            if(ite2.next() instanceof ElementoColaCocina && encontrado &&
                    (pedido == null || fecha.before(fechaPedido))){
                pedido = ((Pedido)iterador.next());
            }
        }
        if(pedido == null)
                 throw new Exception("No hay siguiente pedido en cola de bar");
        return pedido;
    }

    public Pedido getSiguientePedidoCocinaEncola()throws Exception{
         ArrayList<Pedido> noFacturados;
        ArrayList<ElementoPedido> elementos;
        noFacturados = iPedidosBD.obtienePedidosNoFacturados();

        Pedido pedido = null;

        Iterator iterador = noFacturados.iterator();
        Integer estado=-1;
        boolean encontrado = false;
        Date fecha=null, fechaPedido=null;
        while(iterador.hasNext()){
            elementos = ((Pedido)iterador.next()).obtieneElementos();
            Iterator ite2 = elementos.iterator();
            while (ite2.hasNext() && !encontrado){
                if(ite2.next() instanceof ElementoColaCocina){
                    estado = ((ElementoColaCocina)ite2.next()).getEstado();
                    if(estado == ElementoColaCocina.ENCOLA)
                        encontrado = true;
                }
            }
            if(encontrado){
                fecha = ((Pedido)iterador.next()).getFecha();
            }
            if( encontrado && pedido != null){
                fechaPedido = pedido.getFecha();
            }
            if(ite2.next() instanceof ElementoColaCocina && encontrado &&
                    (pedido == null || fecha.before(fechaPedido))){
                pedido = ((Pedido)iterador.next());
            }
        }
        if(pedido == null)
                 throw new Exception("No hay siguiente pedido en cola de cocina");
        return pedido;
    }

    public Pedido getSiguientePedidoCocinaPreparandose(){
        return new Pedido(); //Para quitar errores
    }

    public void imprimeFactura(Integer codMesa){

    }

    public ArrayList<Pedido> iniciaModificaPedido(Integer codMesa){
        return new ArrayList<Pedido>(); //Para quitar errores
    }

    public boolean modificaPedido(Integer codPedido, ArrayList<ElementoPedido> elems){
        return true;
    }

    public boolean nuevoPedido(Integer codMesa, ArrayList<ElementoPedido> elems){
        return true;
    }

    public ArrayList<ElementoPedido> obtieneElementos(Integer codPedido){
        return new ArrayList<ElementoPedido>(); //Para quitar errores
    }

    public boolean seleccionaBebida(Pedido p, ElementoBebida bebida){
        return true;
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
        Iterator ite = noFacturados.iterator();
        Boolean romper = false;
        int estado;

        while(ite.hasNext()){
            romper = false;
            elementos = ((Pedido)ite.next()).obtieneElementos();
            Iterator ite2 = elementos.iterator();
            while(ite2.hasNext() && !romper){
                ElementoColaCocina temp = new ElementoColaCocina();
                if(((ElementoPedido)ite.next()).getClass().getName().compareTo(temp.getClass().getName()) == 0 ){ //Si es ColaCocina
                     estado = ((ElementoColaCocina)ite.next()).getEstado();
                     if(estado == ElementoColaCocina.PREPARADO ) romper = true;
                }
            }
            if(romper){
                pedidos.add(((Pedido)ite.next()));
            }
        }
        if(pedidos.isEmpty())
            throw new Exception("No hay pedidos preparándose en la cola de cocina");
        return pedidos;
    }

    public boolean seleccionPlato(Pedido p, ElementoColaCocina ele) throws Exception {
        boolean exito=false, existe = false;
        int estado;

        ArrayList<ElementoPedido> elementos = p.obtieneElementos();
        Elemento elem;
        HashMap<Producto,Float> prods;

        if(elementos.contains(ele)) existe = true;
        if(existe){
            estado = ele.getEstado();
            if(estado == ElementoColaCocina.ENCOLA){
               p.setEstado(Pedido.BLOQUEADO); //Cambiamos los estados
               ele.setEstado(ElementoColaCocina.PREPARANDOSE);
               this.iPedidosBD.actualizaPedido(p);
               elem = ele.getElemento();
               prods = elem.getProductos();
               Collection c = (Collection)prods;
               Iterator ite = c.iterator();
               while(ite.hasNext()){ //Restamos las cantidades de todos los productos
                   this.iProducto.restarCantidadProducto(((Pair<Producto,Float>)ite.next()));
               }
            }
            else if(estado == ElementoColaCocina.PREPARADO){
                ele.setEstado(ElementoColaCocina.PREPARANDOSE);
            }
        }
        else{
            throw new Exception("El plato no existe en ese pedido.");
        }
        return exito;
    }
}

