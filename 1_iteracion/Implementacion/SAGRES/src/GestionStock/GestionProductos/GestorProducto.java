/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package GestionStock.GestionProductos;
import GestionBaseDatos.IAlmacenamiento;
import GestionCarta.ICarta;
import java.sql.Blob;
import javax.swing.ImageIcon;
import java.util.ArrayList;
import java.util.Iterator;
import utilidades.Imagen;
import javax.swing.table.TableModel;
/**
 *
 * @author Jose David Dionisio Ruiz
 */
public class GestorProducto implements IGestionarProducto,IProducto{

    ArrayList<Bebida> listaBebidas;
    ArrayList<Ingrediente> listaIngredientes;
    IAlmacenamiento interfazAlmacenamiento;
    ICarta carta;

    /**
     * Construye un objeto GestorProducto
     */
    public GestorProducto(IAlmacenamiento iAlmacenamiento, ICarta carta){
        this.listaBebidas = new ArrayList<Bebida>();
        this.listaIngredientes = new ArrayList<Ingrediente>();
        this.interfazAlmacenamiento = iAlmacenamiento;
        this.carta = carta;
        TableModel consultaBebidas = this.interfazAlmacenamiento.realizaConsulta("select * from productoBebida");
        this.listaBebidas = this.convertirTablaAbebida(consultaBebidas);
        TableModel consultaIngredientes = this.interfazAlmacenamiento.realizaConsulta("select * from productoIngrediente");
        this.listaIngredientes = this.convertirTablaAingrediente(consultaIngredientes);
    }

    /**
     * Actualiza la cantidad de un producto que se le pasa como parametro
     * @param producto Producto que queremos actualizar
     * @param cantidad Nueva cantidad del producto en stock
     */
    public void actualizaCantidadProducto(Producto producto, float cantidad){
        Iterator it = listaBebidas.iterator();
        Bebida b;
        Ingrediente i;
        boolean actualizado = false;
        while(it.hasNext() && !actualizado){
            b = (Bebida) it.next();
            if (b.getCodPro() == producto.getCodPro()){
                b.actualizarCantidad(cantidad - b.getCantidad());
                this.interfazAlmacenamiento.consultaDeModificacion("update producto set cantidad='"+cantidad+"' where producto_id='"+producto.getCodPro()+"'");
            }
        }
        it = listaIngredientes.iterator();
        while(it.hasNext() && !actualizado){
            i = (Ingrediente) it.next();
            if (i.getCodPro() == producto.getCodPro()){
                i.actualizarCantidad(cantidad - i.getCantidad());
                this.interfazAlmacenamiento.consultaDeModificacion("update producto set cantidad='"+cantidad+"' where producto_id='"+producto.getCodPro()+"'");
            }
        }
    }

    /**
     * Busca el producto con el codigo que se le pasa como parametro a la funcion
     * @param codPro Codigo del producto que queremos buscar
     */
    private Producto buscarProducto(int codPro){
        Iterator it = listaBebidas.iterator();
        Bebida b;
        Ingrediente i;
        while(it.hasNext()){
            b = (Bebida) it.next();
            if (b.getCodPro() == codPro){
                return b;
            }
        }
        it = listaIngredientes.iterator();
        while(it.hasNext()){
            i = (Ingrediente) it.next();
            if (i.getCodPro() == codPro){
                return i;
            }
        }
        return null;
    }

    /**
     * Convierte un TableModel en una lista de objetos de tipo Bebida
     * @param t TableModel a convertir
     */
    private ArrayList<Bebida> convertirTablaAbebida(TableModel t){
        ArrayList<Bebida> listaB = new ArrayList<Bebida>();
        Bebida bebida;
        int codigoBebida;
        for(int i=0;i<t.getRowCount();++i){
            codigoBebida = (Integer) t.getValueAt(i,0);
            TableModel consultaProducto = this.interfazAlmacenamiento.realizaConsulta("select * from producto where producto_id='"+codigoBebida+"'");
            if(consultaProducto.getRowCount() != 0){
            bebida = new Bebida((Integer)consultaProducto.getValueAt(i,0),(String)consultaProducto.getValueAt(i,1),
                    (ImageIcon)Imagen.blobToImageIcon((Blob)consultaProducto.getValueAt(i,5)),(Float)consultaProducto.getValueAt(i,4),
                    (Float)consultaProducto.getValueAt(i,3),(Float)consultaProducto.getValueAt(i,2));
            listaB.add(bebida);
            }
        }

        return listaB;
    }

    /**
     * Convierte un TableModel en una lista de objetos de tipo Bebida
     * @param t TableModel a convertir
     */
    private ArrayList<Ingrediente> convertirTablaAingrediente(TableModel t){
        ArrayList<Ingrediente> listaI = new ArrayList<Ingrediente>();
        Ingrediente ingrediente;
        int codigoIngrediente;
        for(int i=0;i<t.getRowCount();++i){
            codigoIngrediente = (Integer) t.getValueAt(i,0);
            TableModel consultaProducto = this.interfazAlmacenamiento.realizaConsulta("select * from producto where producto_id='"+codigoIngrediente+"'");
            if(consultaProducto.getRowCount() != 0){
            ingrediente = new Ingrediente((Integer)consultaProducto.getValueAt(i,0),(String)consultaProducto.getValueAt(i,1),
                    (Float)consultaProducto.getValueAt(i,4),(Float)consultaProducto.getValueAt(i,3),
                    (Float)consultaProducto.getValueAt(i,2),(ImageIcon)Imagen.blobToImageIcon((Blob)consultaProducto.getValueAt(i,5)));
            listaI.add(ingrediente);
            }
        }

        return listaI;
    }


    /**
     * Elimina el producto con el codigo que se le pasa como parametro a la funcion
     * @param codPro Codigo del producto que queremos eliminar
     */
    public void eliminarProducto(int codPro){
        Iterator it = listaBebidas.iterator();
        Bebida b;
        Ingrediente i;
        boolean eliminado = false;
        while(it.hasNext() && !eliminado){
            b = (Bebida) it.next();
            if (b.getCodPro() == codPro){
                this.carta.invalidaElementoCarta(b);
                this.interfazAlmacenamiento.consultaDeModificacion("delete from productoBebida where producto_producto_id='"+codPro+"'");
                this.interfazAlmacenamiento.consultaDeModificacion("delete from producto where producto_id='"+codPro+"'");
                this.listaBebidas.remove(b);
            }
        }
        it = listaIngredientes.iterator();
        while(it.hasNext() && !eliminado){
            i = (Ingrediente) it.next();
            if (i.getCodPro() == codPro){
                this.carta.invalidaElementoCarta(i);
                this.interfazAlmacenamiento.consultaDeModificacion("delete from productoIngrediente where producto_producto_id='"+codPro+"'");
                this.interfazAlmacenamiento.consultaDeModificacion("delete from producto where producto_id='"+codPro+"'");
                this.listaIngredientes.remove(i);
            }
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
    public void modificarProducto(int codigoProducto, String nombre , float cantidad, float minimo, float maximo, ImageIcon imagen ){
        boolean modificado = false;
        for(int i=0;i<this.listaBebidas.size() && !modificado;++i){
            if(this.listaBebidas.get(i).getCodPro() == codigoProducto){
                this.listaBebidas.get(i).setNombre(nombre);
                this.listaBebidas.get(i).setMaximo(maximo);
                this.listaBebidas.get(i).setMinimo(minimo);
                this.listaBebidas.get(i).setFoto(imagen);
                this.listaBebidas.get(i).actualizarCantidad(cantidad - this.listaBebidas.get(i).getCantidad());
                this.interfazAlmacenamiento.consultaDeModificacion
                        ("update producto set "+"cantidad='"+cantidad+"', maximo='"+maximo+
                         "', minimo='"+minimo+"', nombre='"+nombre+"', foto='"+Imagen.imageIconToByteArray(imagen)+"' where producto_id='"+codigoProducto+"'");
                modificado = true;
            }
        }
        for(int i=0;i<this.listaIngredientes.size() && !modificado;++i){
            if(this.listaIngredientes.get(i).getCodPro() == codigoProducto){
                this.listaIngredientes.get(i).setNombre(nombre);
                this.listaIngredientes.get(i).setMaximo(maximo);
                this.listaIngredientes.get(i).setMinimo(minimo);
                this.listaIngredientes.get(i).setFoto(imagen);
                this.listaIngredientes.get(i).actualizarCantidad(cantidad - this.listaIngredientes.get(i).getCantidad());
                this.interfazAlmacenamiento.consultaDeModificacion
                        ("update producto set "+"cantidad='"+cantidad+"', maximo='"+maximo+
                         "', minimo='"+minimo+"', nombre='"+nombre+"', foto='"+Imagen.imageIconToByteArray(imagen)+"' where producto_id='"+codigoProducto+"'");
                modificado = true;
            }
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
        this.interfazAlmacenamiento.consultaDeModificacionBlob("insert into producto(nombre,cantidad,maximo,minimo,foto) values " +
                "('"+nombre+"','"+cantidad+"','"+maximo+"','"+minimo+"')",Imagen.imageIconToByteArray(foto));
        int codPro = (Integer)this.interfazAlmacenamiento.realizaConsulta("select MAX(producto_id) from producto").getValueAt(0,0)+1;
        this.interfazAlmacenamiento.consultaDeModificacion("insert into productoBebida values('"+codPro+"')");
        Bebida b = new Bebida(codPro, nombre, foto, minimo, maximo, cantidad);
        this.listaBebidas.add(b);
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
        this.interfazAlmacenamiento.consultaDeModificacionBlob("insert into producto(nombre,cantidad,maximo,minimo,foto) values " +
                "('"+nombre+"','"+cantidad+"','"+maximo+"','"+minimo+"')",Imagen.imageIconToByteArray(foto));
        int codPro = (Integer)this.interfazAlmacenamiento.realizaConsulta("select MAX(producto_id) from producto").getValueAt(0,0)+1;
        this.interfazAlmacenamiento.consultaDeModificacion("insert into productoIngrediente values('"+codPro+"')");
        Ingrediente i = new Ingrediente(codPro, nombre, cantidad, maximo, minimo, foto);
        this.listaIngredientes.add(i);
    }

    /**
     * Permite obtener una lista de las bebidas que pertenecen a la lista de productos
     */
    public ArrayList<Bebida> obtenerListaBebidas(){
        return this.listaBebidas;
    }

    /**
     * Permite obtener una lista de los ingredientes que pertenecen a la lista de productos
     */
    public ArrayList<Ingrediente> obtenerListaIngredientes(){
        return this.listaIngredientes;
    }

    /**
     * Permite obtener una lista de los productos existentes
     */
    public ArrayList<Producto> obtenerListaProductos(){
        ArrayList<Producto> listaProductos = new ArrayList<Producto>();
        listaProductos.addAll(this.listaBebidas);
        listaProductos.addAll(this.listaIngredientes);
        return listaProductos;
    }

    /**
     * Permite obtener una lista de los productos bajo minimos dentro de nuestro stock
     */
    public ArrayList<Producto> obtenerProductosBajoMinimos(){
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
    }

}