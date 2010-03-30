
package GestionStock.GestionProductos;

import java.util.ArrayList;

/**
 *
 * @author Daniel
 */
public interface IProducto {

    public ArrayList<Bebida> obtenerListaBebidas();
    public ArrayList<Ingrediente> obtenerListaIngredientes();
    public ArrayList<Producto> obtenerListaProductos();
    public ArrayList<Producto> obtenerListaProductosBajoMinimos();
    
}
