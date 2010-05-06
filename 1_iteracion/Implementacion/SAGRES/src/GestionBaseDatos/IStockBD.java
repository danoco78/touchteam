/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package GestionBaseDatos;

import GestionStock.GestionIncidencias.Incidencia;
import GestionStock.GestionPedidoProveedor.PedidoProveedor;
import GestionStock.GestionProductos.Bebida;
import GestionStock.GestionProductos.Ingrediente;
import GestionStock.GestionProductos.Producto;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import utilidades.Pair;

/**
 *
 * @author Daniel
 */
public interface IStockBD {

    public abstract void actualizaCantidadesProductos(HashMap<Producto,Float> listaProductosCantidades);
    public abstract void eliminaProducto(Producto p);
    public abstract void modificarProducto(Producto p);
    public abstract void nuevoProducto( Producto p );
    public abstract void nuevaIncidencia(Incidencia in);
    public abstract void nuevoPedidoProveedor( PedidoProveedor pedProdveedor);
    public abstract HashSet<Producto> obtieneBebidas();
    public abstract HashSet<Producto> obtieneIngredientes();
    public abstract PedidoProveedor obtienePrimerPedidoPendiente();
    public abstract HashMap<Producto, Float> obtieneProductosBajoMinimos();
    public abstract void pedidoRecibido(PedidoProveedor pedProveedor);
    public abstract void restarCantidadProducto( Pair<Producto,Float> prodCantidad);

}
