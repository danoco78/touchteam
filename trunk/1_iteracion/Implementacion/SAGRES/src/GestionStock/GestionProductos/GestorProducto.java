/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package GestionStock.GestionProductos;
import javax.swing.ImageIcon;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Jose David Dionisio Ruiz
 */
public class GestorProducto implements IGestionarProducto {

    ArrayList<Producto> listaProductos;
    
    public GestorProducto(){
        this.listaProductos = new ArrayList<Producto>();
    }

    /**
     *
     * @param codPro
     */
    private Producto buscarProducto(int codPro){
        Iterator it = listaProductos.iterator();
        Producto p;
        while(it.hasNext()){
            p = (Producto) it.next();
            if (p.getCodPro() == codPro){
                return p;
            }
        }
        return null;
    }

    /**
     * ¿¿??
     * @param cantidadPorEnvase
     * @param foto
     */
    public void actualizaCantidadProducto(Producto producto, float cantidad){
        Iterator it = listaProductos.iterator();
        Producto p;
        while(it.hasNext()){
            p = (Producto) it.next();
            if (p == producto){
                if(cantidad < p.getCantidad())
                    p.restarCantidad(p.getCantidad() - cantidad);
                else if(cantidad > p.getCantidad())
                    p.sumarCantidad(cantidad - p.getCantidad());
            }
        }
    }

    public boolean comprobarHayIngrediente(){
        return false;
    }

    /**
     *
     * @param codPro
     */
    public void eliminaProducto(int codPro){
	Producto p = this.buscarProducto(codPro);
        if(p != null)
            this.listaProductos.remove(p);
    }

    /**
     *
     * @param codPro
     */
    public boolean existeProducto(int codPro){
	Producto p = this.buscarProducto(codPro);
        if(p != null)
            return true;
        else
            return false;
    }

    private int generarCodigoProducto(){
	return 0;
    }

    /**
     *
     * @param nombre
     * @param cantidad
     * @param minimo
     * @param maximo
     * @param foto
     * @param cantidadPorEnvase
     */
    public void modificarBebida(int codigoProducto, String nombre , float cantidad, float minimo, float maximo, ImageIcon imagen ){
	Bebida b = (Bebida)this.buscarProducto(codigoProducto);
        if(b != null){
            b.setNombre(nombre);
            b.setMaximo(maximo);
            b.setMinimo(minimo);
            b.setFoto(imagen);
            if(cantidad < b.getCantidad())
                b.restarCantidad(b.getCantidad() - cantidad);
            else if(cantidad > b.getCantidad())
                b.sumarCantidad(cantidad - b.getCantidad());
        }
    }

    /**
     *
     * @param nombre
     * @param cantidad
     * @param minimo
     * @param maximo
     * @param foto
     * @param cantidadPorEnvase
     */
    public void modificarProducto(int codigoProducto, String nombre , float cantidad, float minimo, float maximo, ImageIcon imagen ){
	Producto p = this.buscarProducto(codigoProducto);
        if(p != null){
            p.setNombre(nombre);
            p.setMaximo(maximo);
            p.setMinimo(minimo);
            p.setFoto(imagen);
            if(cantidad < p.getCantidad())
                p.restarCantidad(p.getCantidad() - cantidad);
            else if(cantidad > p.getCantidad())
                p.sumarCantidad(cantidad - p.getCantidad());
        }
    }

    /**
     *
     * @param nombre
     * @param cantidad
     * @param minimo
     * @param maximo
     * @param foto
     */
    public void modificarIngrediente(int codigoProducto, String nombre , float cantidad, float minimo, float maximo, ImageIcon imagen ){
	Ingrediente i = (Ingrediente) this.buscarProducto(codigoProducto);
        if(i != null){
            i.setNombre(nombre);
            i.setMaximo(maximo);
            i.setMinimo(minimo);
            i.setFoto(imagen);
            if(cantidad < i.getCantidad())
                i.restarCantidad(i.getCantidad() - cantidad);
            else if(cantidad > i.getCantidad())
                i.sumarCantidad(cantidad - i.getCantidad());
        }
    }

    /**
     *
     * @param codPro
     * @param nombre
     * @param cantidad
     * @param minimo
     * @param maximo
     * @param foto
     * @param cantidadPorEnvase
     */
    public void nuevaBebida(String nombre, float cantidad, float minimo, float maximo, ImageIcon foto){
        Bebida b = new Bebida(this.generarCodigoProducto(), nombre, foto, minimo, maximo, cantidad);
        this.listaProductos.add(b);
    }

    /**
     *
     * @param codPro
     * @param nombre
     * @param cantidad
     * @param minimo
     * @param maximo
     * @param foto
     */
    public void nuevoIngrediente(String nombre, float cantidad, float minimo, float maximo, ImageIcon foto){
        Ingrediente i = new Ingrediente(this.generarCodigoProducto(), nombre, cantidad, maximo, minimo, foto);
        this.listaProductos.add(i);
    }

    public String obtenerListaProductos(){
        String productos = "";
        Iterator it = listaProductos.iterator();
        Producto p;
        while(it.hasNext()){
            p = (Producto) it.next();
            productos += (p.getNombre()+",");
            }
        return productos;
    }
}