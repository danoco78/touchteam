/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package GestionPedidos;

import java.util.ArrayList;
import GestionCarta.*;
import GestionBaseDatos.IPedidosBD;
import java.util.Iterator;
import java.util.Date;
import java.lang.Exception;

/**
 *
 * @author Gaspar
 */
public class GestorPedidos implements IGestorPedidos {

    IPedidosBD iPedidosBD;

    //TODO implementar todos los diagramas de colaboracion
    public void confirmaPagoFactura(Integer codMesa){
        ArrayList<Pedido> ped;
        ArrayList<ElementoPedido> elemPed;
        ArrayList<Elemento> elementos;
    }

    public ArrayList<String> getInfoRest(){
        return new ArrayList<String>(); //Para quitar errores
    }

    public Pedido getSiguientePedidoBar(){
        return new Pedido(); //Para quitar errores
    }

    public Pedido getSiguientePedidoCocinaEncola(){
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
                    if(estado == 0)
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
            else if(pedido == null)
                 throw new Exception("comentario");

        }
        return pedido; //Para quitar errores
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

    public boolean seleccionaPlato(Pedido p, ElementoPlato plato){
        return true;
    }
}
