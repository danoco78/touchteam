/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package GestionStock.GestionPedidoProveedor;

import GestionCarta.Elemento;
import GestionStock.GestionProductos.Producto;
import java.util.ArrayList;
import java.util.HashMap;
import utilidades.Pair;

/**
 *
 * @author Daniel
 */
public interface IPedidoProveedor {

    public abstract HashMap<Producto, Float> imprimeListaProductosPedido() throws Exception;
    public abstract Pair< HashMap<Producto, Float>, ArrayList<Elemento> > notificaRecepcionPedido() throws Exception;

}
