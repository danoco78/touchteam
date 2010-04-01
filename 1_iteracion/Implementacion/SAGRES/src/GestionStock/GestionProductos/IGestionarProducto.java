
package GestionStock.GestionProductos;

import javax.swing.ImageIcon;

/**
 *
 * @author Daniel
 */
public interface IGestionarProducto {


    public abstract void actualizaCantidadProducto(Producto producto, float cantidad);

    public abstract void eliminaProducto( int codigoProducto );

    public abstract void modificarProducto(int codigoProducto, String nombre , float cantidad, float minimo, float maximo, ImageIcon imagen );

    public abstract void nuevaBebida( String nombre , float cantidad, float minimo, float maximo, ImageIcon imagen);

    public abstract void nuevoIngrediente( String nombre , float cantidad, float minimo, float maximo, ImageIcon imagen );

}
