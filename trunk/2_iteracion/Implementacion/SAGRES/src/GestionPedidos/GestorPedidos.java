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

/**
 *
 * @author Gaspar
 */
public class GestorPedidos implements IGestorPedidos {

    IPedidosBD iPedidosBD;

    //TODO implementar todos los diagramas de colaboracion
    public void confirmaPagoFactura(Integer codMesa){

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

        Pedido pedido = new Pedido();

        Iterator iterador = noFacturados.iterator();
        Integer estado=-1;
        Date fecha, fechaPedido;
        while(iterador.hasNext()){
            elementos = ((Pedido)iterador.next()).obtieneElementos();
            Iterator ite2 = elementos.iterator();
            while (ite2.hasNext()){
                if(ite2.next() instanceof ElementoColaCocina)
                    estado = ((ElementoColaCocina)ite2.next()).getEstado();
            }
            if(estado == 0)
                fecha = ((Pedido)iterador.next()).getFecha();
            
        }
        return new Pedido(); //Para quitar errores
    }

    public Pedido getSiguientePedidoCocinaPreparandose(){
        return new Pedido(); //Para quitar errores
    }

    public void imprimeFactura(Integer codMesa){

    }

    public void imprimeFacturas(){

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
