
package GestionStock.GestionProductos;

import java.util.ArrayList;

/**
 *
 * @author Daniel
 */
public interface IProducto {

    public ArrayList<Bebida> obtenListaBebidas();
    public ArrayList<Ingrediente> obtenListaIngredientes();
    public ArrayList<Producto> obtenListaProductos();
    public ArrayList<Producto> obtenListaProductosBajoMinimos();
    
}
