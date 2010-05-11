
package GestionStock.GestionProductos;

import java.util.HashMap;
import java.util.HashSet;
import utilidades.Pair;

/**
 *
 * @author Daniel
 */
public interface IProducto {

    public void actualizaCantidadesProductos(HashMap<Producto,Float> listaProductosCantidades);
    public void eliminaProducto(Producto p);
    public void modificaProducto(Producto p);
    public void nuevoProducto(Producto p);
    public HashSet<Producto> obtieneBebidas();
    public HashSet<Producto> obtieneIngredientes();
    public  HashMap<Producto, Float> obtieneProductosBajoMinimos();
    public void restarCantidadProducto(Producto p, Float c);
    
}
