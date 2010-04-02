/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package GestionStock.GestionProductos;
import GestionBaseDatos.IAlmacenamiento;
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
    IAlmacenamiento interfazAlmacenamiento;

    /**
     * Construye un objeto GestorProducto
     */
    public GestorProducto(IAlmacenamiento iAlmacenamiento){
        this.listaProductos = new ArrayList<Producto>();
        this.interfazAlmacenamiento = iAlmacenamiento;
        TableModel consulta = this.interfazAlmacenamiento.realizaConsulta("select * from producto");
        for(int i=0;i<consulta.getRowCount();++i){
             Producto producto = new Producto((ImageIcon)consulta.getValueAt(i,5),(String)consulta.getValueAt(i,1),
                                              (Float)consulta.getValueAt(i,4),(Float)consulta.getValueAt(i,3),
                                              (Float)consulta.getValueAt(i,2),(Integer)consulta.getValueAt(i,0));
             this.listaProductos.add(producto);
         }
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
            if (p.getCodPro() == producto.getCodPro()){
                p.actualizarCantidad(cantidad - p.getCantidad());
                this.interfazAlmacenamiento.consultaDeModificacion
                        ("update producto set cantidad="+Float.toString(cantidad)+"where producto_id="+Integer.toString( producto.getCodPro()));
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
        if(p != null){
            this.listaProductos.remove(p);
            this.interfazAlmacenamiento.consultaDeModificacion("delete from producto where producto_id="+ Integer.toString(codPro));
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
            p.actualizarCantidad(cantidad - p.getCantidad());
            this.interfazAlmacenamiento.consultaDeModificacion
                        ("update producto set "+"cantidad="+Float.toString(cantidad)+", maximo="+Float.toString(maximo)+
                         ", minimo="+Float.toString(minimo)+", nombre="+nombre+" where producto_id="+Integer.toString(p.getCodPro()));
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
        int codPro = (Integer)this.interfazAlmacenamiento.realizaConsulta("select MAX(producto_id) from producto").getValueAt(0,0)+1;
        Bebida b = new Bebida(codPro, nombre, foto, minimo, maximo, cantidad);
        this.listaProductos.add(b);
        this.interfazAlmacenamiento.consultaDeModificacion("Insertar nueva bebiba en tabla de producto y de bebida");
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
        int codPro = (Integer)this.interfazAlmacenamiento.realizaConsulta("select MAX(producto_id) from producto").getValueAt(0,0)+1;
        Ingrediente i = new Ingrediente(codPro, nombre, cantidad, maximo, minimo, foto);
        this.listaProductos.add(i);
        this.interfazAlmacenamiento.consultaDeModificacion("Insertar nueva bebiba en tabla de producto y de ingrediente");
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