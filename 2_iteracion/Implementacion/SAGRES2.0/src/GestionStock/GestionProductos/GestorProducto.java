/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package GestionStock.GestionProductos;
import GestionBaseDatos.IStockBD;
import java.util.HashMap;
import java.util.HashSet;
import utilidades.Pair;
/**
 *
 * @author Jose David Dionisio Ruiz
 */
public class GestorProducto implements IProducto{

    IStockBD iStockBD;

    /**
     * Construye un objeto GestorProducto
     */
    public GestorProducto( IStockBD almacen){
        this.iStockBD = almacen;
    }

    public void actualizaCantidadesProductos(HashMap<Producto,Float> listaProductosCantidades){
        this.iStockBD.actualizaCantidadesProductos(listaProductosCantidades);
    }

    /**
     * Elimina el producto que se le pasa como parametro a la funcion
     * @param p Producto que queremos eliminar
     */
    public void eliminaProducto(Producto p){
        this.iStockBD.eliminaProducto(p);
    }

    /**
     * Modifica el producto con el codigo del producto que se le pasa como parametro, actualizandolo con los parametros del objeto que se le pasa
     * @param p Producto que queremos modificar
     */
    public void modificaProducto(Producto p){
        this.iStockBD.modificarProducto(p);
    }

    /**
     * Crea una nueva bebida con los parametros que se le pasan y los introduce en la Base de datos
     * @param nombre Nombre de la bebida
     * @param cantidad Cantidad disponible actualmente
     * @param minimo Minimo permitido para la bebida
     * @param maximo Maximo permitido para la bebida
     * @param foto Imagen de la bebida
     */
    public void nuevoProducto(Producto p){
        this.iStockBD.nuevoProducto(p);
    }

    /**
     * Permite obtener una lista de las bebidas que pertenecen a la lista de productos
     */
    public HashSet<Producto> obtieneBebidas(){
        return this.iStockBD.obtieneBebidas();
    }

    /**
     * Permite obtener una lista de los ingredientes que pertenecen a la lista de productos
     */
    public HashSet<Producto> obtieneIngredientes(){
        return this.iStockBD.obtieneIngredientes();
    }

    /**
     * Permite obtener una lista de los productos bajo minimos dentro de nuestro stock
     */
    public HashMap<Producto, Float> obtieneProductosBajoMinimos(){
        return this.iStockBD.obtieneProductosBajoMinimos();
        /*
        ArrayList<Producto> listaProductosBajoMinimos = new ArrayList<Producto>();
        Iterator it = this.listaBebidas.iterator();
        Producto p;
        while(it.hasNext()){
            p = (Producto) it.next();
            if(p.getCantidad()<p.getMinimo())
                listaProductosBajoMinimos.add(p);
            }
        it = this.listaIngredientes.iterator();
        while(it.hasNext()){
            p = (Producto) it.next();
            if(p.getCantidad()<p.getMinimo())
                listaProductosBajoMinimos.add(p);
            }
        return listaProductosBajoMinimos;
         *
         */
    }

    public void restarCantidadProducto(Producto p, Float c) {
        this.iStockBD.restarCantidadProducto(p,c);
    }

}