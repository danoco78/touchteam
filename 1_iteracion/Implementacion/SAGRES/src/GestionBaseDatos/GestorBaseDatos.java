package GestionBaseDatos;

import GestionCarta.Carta;
import GestionCarta.Elemento;
import GestionCarta.ElementoBebida;
import GestionCarta.ElementoPlato;
import GestionCarta.Seccion;
import GestionStock.GestionIncidencias.Incidencia;
import GestionStock.GestionPedidoProveedor.PedidoProveedor;
import GestionStock.GestionProductos.Bebida;
import GestionStock.GestionProductos.Ingrediente;
import GestionStock.GestionProductos.Producto;
import com.mysql.jdbc.Blob;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.TableModel;
import utilidades.Imagen;
import utilidades.Pair;
import com.mysql.jdbc.Connection;
import java.util.HashSet;
import java.util.Iterator;
import javax.swing.table.TableModel;
import utilidades.Imagen;

/**
 *
 * @author Ángel Luis García, Carlos Salas, Daniel Guerrero y José David Dionisio
 */
public class GestorBaseDatos implements ICartaBD, IStockBD {

    Connection Conexion;
    IAlmacenamiento almacen;

    public GestorBaseDatos(IAlmacenamiento iAlmacenamiento) {
        this.almacen = iAlmacenamiento;
    }

    public void deshabilitaElementos(HashSet<Elemento> listaElementos) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void eliminaElemento(Elemento elemento) {
        this.almacen.consultaDeModificacion("DELETE FROM elemento WHERE elemento_id=" + elemento.getCodigoElemento());
    }

    public void habilitaElementos(HashSet<Elemento> listaElementos) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void modificaElementoBebida(ElementoBebida elemento) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void modificaElementoPlato(ElementoPlato elemento) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void nuevoElementoBebida(ElementoBebida elemento) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void nuevoElementoPlato(ElementoPlato elemento) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public HashSet<Elemento> obtieneElementos() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public HashSet<Elemento> obtieneElementosInvalidados() {
        HashSet<Elemento> elementosInvalidos = new HashSet<Elemento>();

        String consulta;

        //Primero vemos las bebidas invalidadas
        //SELECT elemento_id, nombre, descripcion, foto, precio, divi_max FROM elemento, elementobebida WHERE elemento.elemento_id = elementobebida.elemento_elemento_id"
        consulta = "SELECT elemento_id, nombre, descripcion, disponible, foto, divi, divi_max, precio FROM elemento, elementobebida WHERE elemento.elemento_id = elementobebida.elemento_elemento_id AND elemento.disponible = 0";
        return elementosInvalidos;
    }

    public HashSet<Seccion> obtieneSecciones() {
        HashSet<Seccion> listaSecciones = null;
        TableModel tabla;
        // Construimos el objeto Carta necesario para crear una Seccion
        tabla = this.almacen.realizaConsulta("SELECT ultima_modificacion FROM carta");
        Carta carta = new Carta((java.sql.Date) tabla.getValueAt(0, 0));
        // Obtenemos todas las secciones de la carta
        tabla = this.almacen.realizaConsulta("SELECT seccion_id, nombre FROM seccion");
        // Para cada seccion obtenida, creamos su objeto e insertamos en el HashSet
        for (int i = 0; i < tabla.getRowCount(); i++) {
            Seccion seccion = new Seccion((Integer) tabla.getValueAt(i, 0), (String) tabla.getValueAt(i, 1), carta);
            listaSecciones.add(seccion);
        }
        return listaSecciones;
    }

    public void eliminaProducto(Producto p) {
        try {
            int codPro = p.getCodPro();
            java.sql.PreparedStatement borrado;
            /*Preparamos la consulta de borrado del producto*/
            if(p instanceof Bebida){
            borrado = this.Conexion.prepareStatement("delete from productobebida where producto_producto_id='"+codPro+"'");
            borrado.executeUpdate();
            }
            else if(p instanceof Ingrediente){
            borrado = this.Conexion.prepareStatement("delete from productoingrediente where producto_producto_id='"+codPro+"'");
            borrado.executeUpdate();
            }
            java.sql.PreparedStatement borrado2 = this.Conexion.prepareStatement("delete from producto where producto_id='"+codPro+"'");
            borrado2.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(GestorBaseDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void modificarProducto(Producto p) {
        try {
            /*Preparamos la consulta de actualizacion del producto*/
            int codigoProducto = p.getCodPro();
            java.sql.PreparedStatement actualizacion = this.Conexion.prepareStatement("update producto set cantidad=?, maximo=?, minimo=?, nombre=?, foto=? where producto_id='"+codigoProducto+"'");
            actualizacion.setFloat(1, p.getCantidad());
            actualizacion.setFloat(2, p.getMaximo());
            actualizacion.setFloat(3, p.getMinimo());
            actualizacion.setString(4, p.getNombre());
            //actualizacion.setBlob(5, (Blob) Imagen.imageIconToByteArray(p.getImagen()));
            actualizacion.executeUpdate();//Insertamos la incidencia

        } catch (SQLException ex) {
            Logger.getLogger(GestorBaseDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void nuevoProducto(Producto p) {
        try {
            /*Preparamos la consulta de inserccion del producto*/
            java.sql.PreparedStatement inserccion = this.Conexion.prepareStatement("insert into producto" + "(nombre,cantidad,maximo,minimo,foto)" + " values ( ?, ?, ?, ?, ?)");
            inserccion.setString(1, p.getNombre());
            inserccion.setFloat(2, p.getCantidad());
            inserccion.setFloat(3, p.getMaximo());
            inserccion.setFloat(4, p.getMinimo());
            //inserccion.setBlob(5, (Blob) Imagen.imageIconToByteArray(p.getImagen()));

            //Ejecutamos la inserccion
            Statement ultimo = (Statement) this.Conexion.createStatement();
            inserccion.executeUpdate();//Insertamos la incidencia
            ResultSet id = ultimo.executeQuery("select MAX(producto_id) from producto;"); // Sacamos su ID
            id.next();
            p.setCodPro(id.getInt(1));

            /*Actualizamos en la tabla de bebidas o de ingredientes segun corresponda*/
            java.sql.PreparedStatement relacion;
            if(p instanceof Bebida){
            relacion = this.Conexion.prepareStatement("insert into productobebida" + "(producto_producto_id) " + "values ( ? )");
            relacion.setInt(1, p.getCodPro());
            relacion.executeUpdate();
            }
            else if(p instanceof Ingrediente){
            relacion = this.Conexion.prepareStatement("insert into productoingrediente" + "(producto_producto_id) " + "values ( ? )");
            relacion.setInt(1, p.getCodPro());
            relacion.executeUpdate();
            }

        } catch (SQLException ex) {
            Logger.getLogger(GestorBaseDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void nuevaIncidencia(Incidencia in) {
        try {
            /*Preparamos la consulta de inserccion de la incidencia*/
            java.sql.PreparedStatement inserccion = this.Conexion.prepareStatement("insert into incidencia" + "(descripcion,fecha,cantidad_afectada)" + " values ( ? , ?, ?)");
            inserccion.setString(1, in.getTipoIncidencia());
            inserccion.setDate(2, (Date) in.getFecha());
            inserccion.setFloat(3, in.getCantidadAfectada());
            
            /*Preparamos la consulta de la incidencia y el producto afectado*/
            Statement ultimo = (Statement) this.Conexion.createStatement();
            java.sql.PreparedStatement relacion = this.Conexion.prepareStatement("insert into tieneincidencia" +
                    "(incidencia_incidencia_id,producto_producto_id) " +
                    "values ( ? , ? )");
            relacion.setInt(2, in.getProducto().getCodPro());

            //Ejecutamos las consultas
            inserccion.executeUpdate();//Insertamos la incidencia
            ResultSet id = ultimo.executeQuery("select MAX(incidencia_id) from incidencia;"); // Sacamos su ID
            id.next();
            relacion.setInt(1, id.getInt(1)); // Metemeos el ID en la consulta de relacion
            relacion.executeUpdate();// insertamos la relacion.
            in.setCodigo(id.getInt(1));// Modificamos el codigo de la incidencia.
            
        } catch (SQLException ex) {
            Logger.getLogger(GestorBaseDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void nuevoPedidoProveedor(PedidoProveedor pedProdveedor) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public HashSet<Bebida> obtieneBebidas() {
        int codigoBebida;
        HashSet<Bebida> listaBebidas = new HashSet<Bebida>();
        Statement consulta;
        try {
        consulta = (Statement) this.Conexion.createStatement();
        ResultSet tablabebidas = consulta.executeQuery("select producto_producto_id FROM productobebida");

        while(tablabebidas.next()){
            codigoBebida = tablabebidas.getInt(1);
            Statement consultaBebidas = (Statement) this.Conexion.createStatement();
            ResultSet tablaproductos = consultaBebidas.executeQuery("select * from producto where producto_id='"+codigoBebida+"'");
            tablaproductos.next();
            Bebida bebida = new Bebida(tablaproductos.getInt(1),tablaproductos.getString(2),Imagen.blobToImageIcon(tablaproductos.getBytes(6)),
                    tablaproductos.getFloat(5),tablaproductos.getFloat(4),tablaproductos.getFloat(3));
            listaBebidas.add(bebida);
        }
        } catch (SQLException ex) {
            Logger.getLogger(GestorBaseDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaBebidas;
    }

    public HashSet<Ingrediente> obtieneIngredientes() {
        int codigoIngrediente;
        HashSet<Ingrediente> listaIngredientes = new HashSet<Ingrediente>();
        Statement consulta;
        try {
        consulta = (Statement) this.Conexion.createStatement();
        ResultSet tablaingredientes = consulta.executeQuery("select producto_producto_id FROM productoingrediente");

        while(tablaingredientes.next()){
            codigoIngrediente = tablaingredientes.getInt(1);
            Statement consultaBebidas = (Statement) this.Conexion.createStatement();
            ResultSet tablaproductos = consultaBebidas.executeQuery("select * from producto where producto_id='"+codigoIngrediente+"'");
            tablaproductos.next();
            Ingrediente ingrediente = new Ingrediente(tablaproductos.getInt(1),tablaproductos.getString(2),tablaproductos.getFloat(3),tablaproductos.getFloat(4),
                    tablaproductos.getFloat(5),Imagen.blobToImageIcon(tablaproductos.getBytes(6)));
            listaIngredientes.add(ingrediente);
        }
        } catch (SQLException ex) {
            Logger.getLogger(GestorBaseDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaIngredientes;
    }

    public PedidoProveedor obtienePrimerPedidoPendiente() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public HashSet<Producto> obtieneProductosBajoMinimos() {
        HashSet<Producto> listaProductos = new HashSet<Producto>();
        try {
            Statement consultaProductos = (Statement) this.Conexion.createStatement();
            ResultSet tablaproductos = consultaProductos.executeQuery("select * from producto where producto.cantidad < producto.minimo");
            while(tablaproductos.next()){
            Producto producto = new Producto(Imagen.blobToImageIcon(tablaproductos.getBytes(6)),tablaproductos.getString(2),
                    tablaproductos.getFloat(5),tablaproductos.getFloat(4),tablaproductos.getFloat(3),tablaproductos.getInt(1));
            listaProductos.add(producto);
            }
        } catch (SQLException ex) {
            Logger.getLogger(GestorBaseDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaProductos;
    }

    public void pedidoRecibido(PedidoProveedor pedProveedor) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void restarCantidadProducto(Pair<Producto, Float> prodCantidad) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}

