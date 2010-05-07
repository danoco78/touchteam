/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package GestionStock.GestionPedidoProveedor;

import GestionStock.GestionProductos.Producto;
import java.util.HashMap;

/**
 *
 * @author Daniel
 */
public interface IPedidoProveedor {

    public abstract void imprimeListaProductosPedido( HashMap<Producto, Float> listaProductosCantidad );
    public abstract void NuevoPedidoProveedor( HashMap<Producto, Float> listaProductosCantidad );
    public abstract PedidoProveedor obtienePrimerPedidoPendiente();
    public abstract void pedidoRecibido(PedidoProveedor pedProveedor);

}
