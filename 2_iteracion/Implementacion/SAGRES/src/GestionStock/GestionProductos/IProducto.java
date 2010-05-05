
package GestionStock.GestionProductos;

import java.util.HashMap;
import java.util.HashSet;
import utilidades.Pair;

/**
 *
 * @author Daniel
 */
public interface IProducto {

    //public void actualizaCantidadesProductos(HashMap<Producto,Float> listaProductosCantidades);
    public void eliminaProducto(Producto p);
    public void modificaProducto(Producto p);
    public void nuevoProducto(Producto p);
    public HashSet<Bebida> obtieneBebidas();
    public HashSet<Ingrediente> obtieneIngredientes();
    public HashSet<Producto> obtieneProductosBajoMinimos();
    public void restarCantidadProducto(Pair<Producto,Float> prodCantidad);
    
}
