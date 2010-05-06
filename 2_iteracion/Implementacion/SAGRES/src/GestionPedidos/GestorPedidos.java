/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package GestionPedidos;

import java.util.ArrayList;
import GestionCarta.*;
import GestionBaseDatos.IPedidosBD;

/**
 *
 * @author Gaspar
 */
public class GestorPedidos implements IGestorPedidos {

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
        noFacturados = obtienePedidosNoFacturados();

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
