/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package GestionStock.GestionProductos;
import javax.swing.ImageIcon;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.table.TableModel;

/**
 *
 * @author Jose David Dionisio Ruiz
 */
public class GestorProducto implements IGestionarProducto,IProducto{

    ArrayList<Producto> listaProductos;

    /**
     * Construye un objeto GestorProducto
     */
    public GestorProducto(){
        this.listaProductos = new ArrayList<Producto>();
    }

    /**
     * Actualiza la cantidad de un producto que se le pasa como parametro
     * @param producto Producto que queremos actualizar
     * @param cantidad Nueva cantidad del producto en stock
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

    /**
     * Busca el producto con el codigo que se le pasa como parametro a la funcion
     * @param codPro Codigo del producto que queremos buscar
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
     * Convierte un TableModel en una lista de objetos de tipo Bebida
     * @param t TableModel a convertir
     */
    private ArrayList<Bebida> convertirTablaAbebida(TableModel t){
        ArrayList<Bebida> listaBebidas = new ArrayList<Bebida>();
        return listaBebidas;
    }

    /**
     * Convierte un TableModel en una lista de objetos de tipo Bebida
     * @param t TableModel a convertir
     */
    private ArrayList<Ingrediente> convertirTablaAingrediente(TableModel t){
        ArrayList<Ingrediente> listaIngredientes = new ArrayList<Ingrediente>();
        return listaIngredientes;
    }


    /**
     * Elimina el producto con el codigo que se le pasa como parametro a la funcion
     * @param codPro Codigo del producto que queremos eliminar
     */
    public void eliminarProducto(int codPro){
	Producto p = this.buscarProducto(codPro);
        if(p != null)
            this.listaProductos.remove(p);
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
     * @param codPro
     * @param nombre
     * @param cantidad
     * @param minimo
     * @param maximo
     * @param foto
     * @param cantidadPorEnvase
     */
    public void nuevaBebida(String nombre, float cantidad, float minimo, float maximo, ImageIcon foto){
        int codPro=0;
        Bebida b = new Bebida(codPro, nombre, foto, minimo, maximo, cantidad);
        this.listaProductos.add(b);
    }

    /**
     * Añade un nuevo ingrediente a la lista de productos
     * @param codPro
     * @param nombre
     * @param cantidad
     * @param minimo
     * @param maximo
     * @param foto
     */
    public void nuevoIngrediente(String nombre, float cantidad, float minimo, float maximo, ImageIcon foto){
        int codPro=0;
        Ingrediente i = new Ingrediente(codPro, nombre, cantidad, maximo, minimo, foto);
        this.listaProductos.add(i);
    }

    /**
     * Permite obtener una lista de las bebidas que pertenecen a la lista de productos
     */
    public ArrayList<Bebida> obtenerListaBebidas(){
        ArrayList<Bebida> listaBebidas = new ArrayList<Bebida>();
        Iterator it = listaProductos.iterator();
        Producto p;
        while(it.hasNext()){
            p = (Producto) it.next();
            if(p instanceof Bebida)
                listaBebidas.add((Bebida)p);
            }
        return listaBebidas;
    }

    /**
     * Permite obtener una lista de los ingredientes que pertenecen a la lista de productos
     */
    public ArrayList<Ingrediente> obtenerListaIngredientes(){
        ArrayList<Ingrediente> listaIngredientes = new ArrayList<Ingrediente>();
        Iterator it = listaProductos.iterator();
        Producto p;
        while(it.hasNext()){
            p = (Producto) it.next();
            if(p instanceof Ingrediente)
                listaIngredientes.add((Ingrediente)p);
            }
        return listaIngredientes;
    }

    /**
     * Permite obtener una lista de los productos existentes
     */
    public ArrayList<Producto> obtenerListaProductos(){
        return this.listaProductos;
    }

    /**
     * Permite obtener una lista de los productos bajo minimos dentro de nuestro stock
     */
    public ArrayList<Producto> obtenerProductosBajoMinimos(){
        ArrayList<Producto> listaProductosBajoMinimos = new ArrayList<Producto>();
        Iterator it = listaProductos.iterator();
        Producto p;
        while(it.hasNext()){
            p = (Producto) it.next();
            if(p.getCantidad()<p.getMinimo())
                listaProductosBajoMinimos.add(p);
            }
        return listaProductosBajoMinimos;
    }

}