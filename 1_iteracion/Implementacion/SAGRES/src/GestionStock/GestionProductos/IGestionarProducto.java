
package GestionStock.GestionProductos;

import javax.swing.ImageIcon;

/**
 *
 * @author Daniel
 */
public interface IGestionarProducto {


    public abstract void actualizarCantidadProdcuto(Producto producto, float cantidad);

    public abstract void eliminarProdcuto( int codigoProducto );

    public abstract void modificarProdcuto(int codigoProducto, String nombre , float cantidad, float minimo, float maximo, ImageIcon imagen );

    public abstract void nuevaBebida(String nombre , float cantidad, float minimo, float maximo, ImageIcon imagen );

    public abstract void nuevoIngrediente( String nombre , float cantidad, float minimo, float maximo, ImageIcon imagen );

}
