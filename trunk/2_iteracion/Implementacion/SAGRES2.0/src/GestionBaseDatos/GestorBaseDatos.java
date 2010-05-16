package GestionBaseDatos;

import GestionCarta.Carta;
import GestionCarta.Elemento;
import GestionCarta.ElementoBebida;
import GestionCarta.ElementoPlato;
import GestionCarta.Seccion;
import GestionCarta.SeccionBebida;
import GestionCarta.SeccionComida;
import GestionPedidos.ElementoColaBar;
import GestionPedidos.ElementoColaCocina;
import GestionPedidos.ElementoPedido;
import GestionPedidos.Factura;
import GestionPedidos.Pedido;
import GestionStock.GestionIncidencias.Incidencia;
import GestionStock.GestionPedidoProveedor.PedidoProveedor;
import GestionStock.GestionProductos.Bebida;
import GestionStock.GestionProductos.Ingrediente;
import GestionStock.GestionProductos.Producto;
import com.mysql.jdbc.Statement;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map.Entry;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import utilidades.Pair;
import com.mysql.jdbc.Connection;
import java.io.ByteArrayInputStream;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.sql.rowset.serial.SerialBlob;
import javax.swing.Icon;
import utilidades.Imagen;

/**
 *
 * @author Ángel Luis García, Carlos Salas, Daniel Guerrero y José David Dionisio
 */
public class GestorBaseDatos implements ICartaBD, IStockBD, IPedidosBD {

    Connection Conexion;

    public GestorBaseDatos(String host, String user, String pass) throws Exception {
        try {
            Conexion = (Connection) DriverManager.getConnection( "jdbc:mysql://"+host, user, pass);
        } catch (SQLException ex) {
            switch (ex.getErrorCode()) {
                case 1045:
                    throw new Exception("Error de Conexion: Usuario o contraseña incorrecta");
                case 1049:
                    throw new Exception("Error de Conexion: El host especificado no es correcto o la base de datos no esta");
                default:
                    throw ex;
            }
        }
    }

    public void actualizaCantidadesProductos(HashMap<Producto,Float> listaProductosCantidades){
        Iterator iterador = listaProductosCantidades.entrySet().iterator();
        Producto p;
        Float cantidad;
        int codigoProducto;
	while (iterador.hasNext()) {
            Map.Entry entrada = (Map.Entry)iterador.next();
            p = (Producto)entrada.getKey();
            cantidad = (Float)entrada.getValue();
            p.actualizarCantidad(cantidad);
            codigoProducto = p.getCodPro();
            java.sql.PreparedStatement actualizacion;
            try {
                actualizacion = this.Conexion.prepareStatement("update producto set cantidad=? where producto_id='" + codigoProducto + "'");
                actualizacion.setFloat(1, p.getCantidad());
                actualizacion.executeUpdate();//Actualizamos la cantidad en la base de datos
            } catch (SQLException ex) {
                Logger.getLogger(GestorBaseDatos.class.getName()).log(Level.SEVERE, null, ex);
            }
	}
    }

    public void deshabilitaElementos(HashSet<Elemento> listaElementos) {
        Iterator iterador = listaElementos.iterator();
        while(iterador.hasNext()){
            Elemento elemento = (Elemento)iterador.next();
            elemento.setDisponible(false);
            //Si hay que meter todo REVISAR
            try{
                java.sql.PreparedStatement actualizacion = this.Conexion.prepareStatement("UPDATE elemento SET disponible=? WHERE elemento_id='" + elemento.getCodigoElemento()+ "'");
                actualizacion.setInt(1, 0);
            } catch (SQLException ex) {
                Logger.getLogger(GestorBaseDatos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void eliminaElemento(Elemento elemento) {
        try {
            java.sql.PreparedStatement borrado = this.Conexion.prepareStatement("DELETE FROM elemento WHERE elemento_id=" + elemento.getCodigoElemento());
            borrado.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(GestorBaseDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void habilitaElementos(HashSet<Elemento> listaElementos) {
        Iterator iterador = listaElementos.iterator();
        while(iterador.hasNext()){
            Elemento elemento = (Elemento)iterador.next();
            elemento.setDisponible(true);
            //Si hay que meter todo REVISAR
            try{
                java.sql.PreparedStatement actualizacion = this.Conexion.prepareStatement("UPDATE elemento SET disponible=? WHERE elemento_id='" + elemento.getCodigoElemento()+ "'");
                actualizacion.setInt(1, 1);
            } catch (SQLException ex) {
                Logger.getLogger(GestorBaseDatos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void modificaElementoBebida(ElementoBebida elemento) {
        try {

            int codigoElemento = elemento.getCodigoElemento();
            
            java.sql.PreparedStatement actualizacion = this.Conexion.prepareStatement("UPDATE elemento SET nombre=?, descripcion=?, disponible=?, foto=?, divi=?, divi_max=?, precio=? where elemento_id='" + codigoElemento + "'");
            actualizacion.setString(1, elemento.getNombre());
            actualizacion.setString(2, elemento.getDescripcion());
            if (elemento.getDisponible()) {
                actualizacion.setInt(3, 1);
            } else {
                actualizacion.setInt(3, 0);
            }
            actualizacion.setBinaryStream(4, new ByteArrayInputStream(Imagen.imageIconToByteArray(elemento.getFoto())));
            actualizacion.setInt(5, elemento.getDivisiones());
            actualizacion.setInt(6, elemento.getDivisionesMaximas());
            actualizacion.setFloat(7, elemento.getPrecio());

            actualizacion.executeUpdate();//Actualizamos el ElementoBebida
        } catch (SQLException ex) {
            Logger.getLogger(GestorBaseDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void modificaElementoPlato(ElementoPlato elemento) {
        try {

            int codigoElemento = elemento.getCodigoElemento();

            java.sql.PreparedStatement actualizacion = this.Conexion.prepareStatement("UPDATE elemento SET nombre=?, descripcion=?, disponible=?, foto=?, divi=?, divi_max=?, precio=? where elemento_id='" + codigoElemento + "'");
            actualizacion.setString(1, elemento.getNombre());
            actualizacion.setString(2, elemento.getDescripcion());
            if (elemento.getDisponible()) {
                actualizacion.setInt(3, 1);
            } else {
                actualizacion.setInt(3, 0);
            }
            actualizacion.setBinaryStream(4, new ByteArrayInputStream(Imagen.imageIconToByteArray(elemento.getFoto())));
            actualizacion.setInt(5, elemento.getDivisiones());
            actualizacion.setInt(6, elemento.getDivisionesMaximas());
            actualizacion.setFloat(7, elemento.getPrecio());

            actualizacion.executeUpdate();//Actualizamos el ElementoPlato

            actualizacion = this.Conexion.prepareStatement("UPDATE elementoplato SET tiempo_elaboracion=? where elemento_elemento_id='" + codigoElemento + "'");
            actualizacion.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(GestorBaseDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void nuevoElementoBebida(ElementoBebida elemento, Seccion seccion) {
        try {
            // Insertamos el elemento
            java.sql.PreparedStatement inserccion = this.Conexion.prepareStatement("INSERT INTO elemento(nombre,descripcion,disponible,divi,divi_max,precio)"
                    + "VALUES ('?','?',?,'?','?','?')");
            inserccion.setString(1, elemento.getNombre());
            inserccion.setString(2, elemento.getDescripcion());
            inserccion.setInt(3, 0);
            inserccion.setInt(4, elemento.getDivisiones());
            inserccion.setInt(5, elemento.getDivisionesMaximas());
            inserccion.setFloat(6, elemento.getPrecio());
            inserccion.executeUpdate();
            // Obtenemos el último id que se insertó
            java.sql.Statement consulta = this.Conexion.createStatement();
            ResultSet idElemento = consulta.executeQuery("SELECT MAX(elemento_id) FROM elemento");
            idElemento.next();
            int id_elemento = idElemento.getInt(1);
            // Insertamos la imagen en la tabla
            java.sql.PreparedStatement actualizacion = this.Conexion.prepareStatement("UPDATE elemento SET foto=? WHERE elemento_id=" + id_elemento);
            actualizacion.setBinaryStream(1, new ByteArrayInputStream(Imagen.imageIconToByteArray(elemento.getFoto())));
            // Insertamos en elementoBebida
            inserccion = this.Conexion.prepareStatement("INSERT INTO elementobebida VALUES('?')");
            inserccion.setInt(1, id_elemento);
            inserccion.executeUpdate();
            // Para cada Bebida, sacamos su idBebida e insertamos junto con idElemento en tieneBebida

            Set set = elemento.getListaBebidas().entrySet();
            Iterator it = set.iterator();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                Producto bebida = (Producto) entry.getKey();
                Float cantidad = (Float) entry.getValue();
                inserccion = this.Conexion.prepareStatement("INSERT INTO tienebebida VALUES('?','?','?')");
                inserccion.setInt(1, id_elemento);
                inserccion.setInt(2, bebida.getCodPro());
                inserccion.setFloat(3, cantidad.floatValue());
                inserccion.executeUpdate();
            }
            // Insertamos el elemento en su sección
            inserccion = this.Conexion.prepareStatement("INSERT INTO incluyebebida VALUES ('?','?')");
            inserccion.setInt(1, seccion.getCodigoSeccion());
            inserccion.setInt(2, id_elemento);
            inserccion.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(GestorBaseDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void nuevoElementoPlato(ElementoPlato elemento, Seccion seccion) {
        try {
            // Insertamos el elemento
            java.sql.PreparedStatement inserccion = this.Conexion.prepareStatement("INSERT INTO elemento(nombre,descripcion,disponible,divi,divi_max,precio)"
                    + "VALUES ('?','?',?,'?','?','?')");
            inserccion.setString(1, elemento.getNombre());
            inserccion.setString(2, elemento.getDescripcion());
            inserccion.setInt(3, 0);
            inserccion.setInt(4, elemento.getDivisiones());
            inserccion.setInt(5, elemento.getDivisionesMaximas());
            inserccion.setFloat(6, elemento.getPrecio());
            inserccion.executeUpdate();
            // Obtenemos el último id que se insertó
            java.sql.Statement consulta = this.Conexion.createStatement();
            ResultSet idElemento = consulta.executeQuery("SELECT MAX(elemento_id) FROM elemento");
            idElemento.next();
            int id_elemento = idElemento.getInt(1);
            // Insertamos la imagen en la tabla
            java.sql.PreparedStatement actualizacion = this.Conexion.prepareStatement("UPDATE elemento SET foto=? WHERE elemento_id=" + id_elemento);
            actualizacion.setBinaryStream(1, new ByteArrayInputStream(Imagen.imageIconToByteArray(elemento.getFoto())));
            // Insertamos en elementoPlato
            inserccion = this.Conexion.prepareStatement("INSERT INTO elementoplato VALUES('?')");
            inserccion.setInt(1, id_elemento);
            inserccion.executeUpdate();
            // Para cada Ingrediente, sacamos su idIngrediente e insertamos junto con idElemento en tieneIngrediente

            Set set = elemento.getListaIngredientes().entrySet();
            Iterator it = set.iterator();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                Producto ingrediente = (Producto) entry.getKey();
                Float cantidad = (Float) entry.getValue();
                inserccion = this.Conexion.prepareStatement("INSERT INTO tieneingrediente VALUES('?','?','?')");
                inserccion.setInt(1, id_elemento);
                inserccion.setInt(2, ingrediente.getCodPro());
                inserccion.setFloat(3, cantidad.floatValue());
                inserccion.executeUpdate();
            }
            // Insertamos el elemento en su sección
            inserccion = this.Conexion.prepareStatement("INSERT INTO incluyeplato VALUES ('?','?')");
            inserccion.setInt(1, seccion.getCodigoSeccion());
            inserccion.setInt(2, id_elemento);
            inserccion.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(GestorBaseDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public HashSet<Elemento> obtieneElementos() {
        HashSet<Elemento> listaElementos = new HashSet<Elemento>();
        HashMap<Bebida, Float> listaBebida = null;
        HashMap<Ingrediente, Float> listaIngredientes = null;
        try {
            // Obtenemos todas las bebidas
            java.sql.Statement consulta = this.Conexion.createStatement();
            ResultSet datosElementosBebida = consulta.executeQuery("SELECT elemento.elemento_id, elemento.nombre, elemento.descripcion, elemento.disponible, elemento.foto, elemento.divi, elemento.divi_max, elemento.precio FROM elemento, elementobebida WHERE elemento.elemento_id = elementobebida.elemento_elemento_id");
            while (datosElementosBebida.next()) {
                listaBebida = new HashMap<Bebida, Float>();
                java.sql.PreparedStatement consulta2 = this.Conexion.prepareStatement("SELECT producto.foto, producto.nombre, producto.minimo, producto.maximo, producto.cantidad, producto.producto_id, tienebebida.cantidad FROM tienebebida, producto WHERE "
                        + "tienebebida.productoBebida_producto_producto_id"
                        + " = producto.producto_id AND tienebebida.elementoBebida_elemento_elemento_id =" + datosElementosBebida.getInt(1));
                ResultSet datosBebidas = consulta2.executeQuery();
                while (datosBebidas.next()) {
                    Bebida bebida = new Bebida(datosBebidas.getInt(6), datosBebidas.getString(2), Imagen.blobToImageIcon(new SerialBlob(datosBebidas.getBlob(1)).getBytes(1, (int) datosBebidas.getBlob(1).length())), datosBebidas.getFloat(3), datosBebidas.getFloat(4), datosBebidas.getFloat(5));
                    Float cantidad = new Float(datosBebidas.getFloat(7));
                    listaBebida.put(bebida, cantidad);
                }
                // Para obtener la imagen, primero sacamos el blob y con SerialBlob lo pasamos a byte[]
                ElementoBebida elemento = new ElementoBebida(datosElementosBebida.getInt(1), listaBebida, datosElementosBebida.getString(2), datosElementosBebida.getString(3), Imagen.blobToImageIcon(new SerialBlob(datosElementosBebida.getBlob(1)).getBytes(1, (int) datosElementosBebida.getBlob(1).length())), datosElementosBebida.getInt(8), datosElementosBebida.getInt(7));
                listaElementos.add(elemento);
            }

            // Obtenemos todos los platos
            consulta = this.Conexion.createStatement();
            ResultSet datosElementosPlato = consulta.executeQuery("SELECT elemento.elemento_id, elemento.nombre, elemento.descripcion, elemento.disponible, elemento.foto, elemento.divi, elemento.divi_max, elemento.precio, elementoplato.tiempo_elaboracion FROM elemento, elementoplato WHERE elemento.elemento_id = elementoplato.elemento_elemento_id");
            while (datosElementosPlato.next()) {
                listaIngredientes = new HashMap<Ingrediente, Float>();
                java.sql.PreparedStatement consulta2 = this.Conexion.prepareStatement("SELECT producto.foto, producto.nombre, producto.minimo, producto.maximo, producto.cantidad, producto.producto_id, tieneingrediente.cantidad FROM tieneingrediente, producto WHERE "
                        + "tieneingrediente.productoIngrediente_producto_producto_id"
                        + " = producto.producto_id AND tieneingrediente.elementoComida_elemento_elemento_id =" + datosElementosPlato.getInt(1));
                ResultSet datosIngredientes = consulta2.executeQuery();
                while (datosIngredientes.next()) {
                    Ingrediente ingrediente = new Ingrediente(datosIngredientes.getInt(6), datosIngredientes.getString(2), datosIngredientes.getFloat(5), datosIngredientes.getFloat(3), datosIngredientes.getFloat(4), Imagen.blobToImageIcon(new SerialBlob(datosIngredientes.getBlob(1)).getBytes(1, (int) datosIngredientes.getBlob(1).length())));
                    Float cantidad = new Float(datosIngredientes.getFloat(7));
                    listaIngredientes.put(ingrediente, cantidad);
                }
                // Para obtener la imagen, primero sacamos el blob y con SerialBlob lo pasamos a byte[]
                ElementoPlato elemento = new ElementoPlato(datosElementosPlato.getInt(1), listaIngredientes, datosElementosPlato.getString(2), datosElementosPlato.getString(3), Imagen.blobToImageIcon(new SerialBlob(datosElementosPlato.getBlob(1)).getBytes(1, (int) datosElementosPlato.getBlob(1).length())), datosElementosPlato.getInt(9), datosElementosPlato.getInt(8), datosElementosPlato.getInt(7));
                listaElementos.add(elemento);
            }
        } catch (SQLException ex) {
            Logger.getLogger(GestorBaseDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaElementos;
    }

    public HashSet<Elemento> obtieneElementosDeSeccion(Seccion seccion) {
        HashSet<Elemento> listaElementos = new HashSet<Elemento>();
        HashMap<Bebida, Float> listaBebida = null;
        HashMap<Ingrediente, Float> listaIngredientes = null;
        try {
            if (seccion instanceof SeccionBebida) {
                // Si estamos en una SeccionBebida sacamos todos los elementos de la seccion
                java.sql.Statement consulta = this.Conexion.createStatement();
                ResultSet datosElementosBebida = consulta.executeQuery("SELECT elemento.elemento_id, elemento.nombre, elemento.descripcion, elemento.disponible, elemento.foto, elemento.divi, elemento.divi_max, elemento.precio FROM elemento, incluyebebida WHERE elemento.elemento_id = incluyebebida.elementoBebida_elemento_elemento_id AND incluyebebida.seccionBebida_seccion_seccion_id ="+seccion.getCodigoSeccion());
                while (datosElementosBebida.next()) {
                    // Obtenemos todas las bebidas
                    listaBebida = new HashMap<Bebida, Float>();
                    java.sql.PreparedStatement consulta2 = this.Conexion.prepareStatement("SELECT producto.foto, producto.nombre, producto.minimo, producto.maximo, producto.cantidad, producto.producto_id, tienebebida.cantidad FROM tienebebida, producto WHERE "
                            + "tienebebida.productoBebida_producto_producto_id"
                            + " = producto.producto_id AND tienebebida.elementoBebida_elemento_elemento_id =" + datosElementosBebida.getInt(1));
                    ResultSet datosBebidas = consulta2.executeQuery();
                    while (datosBebidas.next()) {
                        Bebida bebida = new Bebida(datosBebidas.getInt(6), datosBebidas.getString(2), Imagen.blobToImageIcon(new SerialBlob(datosBebidas.getBlob(1)).getBytes(1, (int) datosBebidas.getBlob(1).length())), datosBebidas.getFloat(3), datosBebidas.getFloat(4), datosBebidas.getFloat(5));
                        Float cantidad = new Float(datosBebidas.getFloat(7));
                        listaBebida.put(bebida, cantidad);
                    }
                    // Para obtener la imagen, primero sacamos el blob y con SerialBlob lo pasamos a byte[]
                    ElementoBebida elemento = new ElementoBebida(datosElementosBebida.getInt(1), listaBebida, datosElementosBebida.getString(2), datosElementosBebida.getString(3), Imagen.blobToImageIcon(new SerialBlob(datosElementosBebida.getBlob(1)).getBytes(1, (int) datosElementosBebida.getBlob(1).length())), datosElementosBebida.getInt(8), datosElementosBebida.getInt(7));
                    listaElementos.add(elemento);
                }
            }
            else if (seccion instanceof SeccionComida) {
            // Si estamos en una SeccionComida sacamos todos los elementos de la seccion
                java.sql.Statement consulta = this.Conexion.createStatement();
                ResultSet datosElementosPlato = consulta.executeQuery("SELECT elemento.elemento_id, elemento.nombre, elemento.descripcion, elemento.disponible, elemento.foto, elemento.divi, elemento.divi_max, elemento.precio, elementoplato.tiempo_elaboracion FROM elemento, elementoplato , incluyeplato WHERE elemento.elemento_id = incluyeplato.elementoPlato_elemento_elemento_id AND " +
                        "elemento.elemento_id = elementoplato.elemento_elemento_id AND incluyeplato.seccionComida_seccion_seccion_id ="+seccion.getCodigoSeccion());
                // Obtenemos todos los ingredientes
                while (datosElementosPlato.next()) {
                    listaIngredientes = new HashMap<Ingrediente, Float>();
                    java.sql.PreparedStatement consulta2 = this.Conexion.prepareStatement("SELECT producto.foto, producto.nombre, producto.minimo, producto.maximo, producto.cantidad, producto.producto_id, tieneingrediente.cantidad FROM tieneingrediente, producto WHERE "
                            + "tieneingrediente.productoIngrediente_producto_producto_id"
                            + " = producto.producto_id AND tieneingrediente.elementoComida_elemento_elemento_id =" + datosElementosPlato.getInt(1));
                    ResultSet datosIngredientes = consulta2.executeQuery();
                    while (datosIngredientes.next()) {
                        Ingrediente ingrediente = new Ingrediente(datosIngredientes.getInt(6), datosIngredientes.getString(2), datosIngredientes.getFloat(5), datosIngredientes.getFloat(3), datosIngredientes.getFloat(4), Imagen.blobToImageIcon(new SerialBlob(datosIngredientes.getBlob(1)).getBytes(1, (int) datosIngredientes.getBlob(1).length())));
                        Float cantidad = new Float(datosIngredientes.getFloat(7));
                        listaIngredientes.put(ingrediente, cantidad);
                    }
                    // Para obtener la imagen, primero sacamos el blob y con SerialBlob lo pasamos a byte[]
                    ElementoPlato elemento = new ElementoPlato(datosElementosPlato.getInt(1), listaIngredientes, datosElementosPlato.getString(2), datosElementosPlato.getString(3), Imagen.blobToImageIcon(new SerialBlob(datosElementosPlato.getBlob(1)).getBytes(1, (int) datosElementosPlato.getBlob(1).length())), datosElementosPlato.getInt(9), datosElementosPlato.getInt(8), datosElementosPlato.getInt(7));
                    listaElementos.add(elemento);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(GestorBaseDatos.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listaElementos;
    }

    public HashSet<Elemento> obtieneElementosConProducto(Producto producto) {
        HashSet<Elemento> listaElementos = new HashSet<Elemento>();
        HashMap<Bebida, Float> listaBebida = null;
        HashMap<Ingrediente, Float> listaIngredientes = null;
        try {
            if (producto instanceof Bebida) {
                // Obtenemos los datos del elementoBebida con ese producto
                java.sql.PreparedStatement consulta = this.Conexion.prepareStatement("SELECT elemento.elemento_id, elemento.nombre, elemento.descripcion, elemento.disponible, elemento.foto, elemento.divi, elemento.divi_max, elemento.precio FROM elemento, tienebebida WHERE elemento.elemento_id = tienebebida.elementoBebida_elemento_elemento_id AND productoBebida_producto_producto_id =" + producto.getCodPro());
                ResultSet datosElementosBebida = consulta.executeQuery();
                while (datosElementosBebida.next()) {
                    listaBebida = new HashMap<Bebida, Float>();
                    java.sql.PreparedStatement consulta2 = this.Conexion.prepareStatement("SELECT producto.foto, producto.nombre, producto.minimo, producto.maximo, producto.cantidad, producto.producto_id, tienebebida.cantidad FROM tienebebida, producto WHERE "
                            + "tienebebida.productoBebida_producto_producto_id"
                            + " = producto.producto_id AND tienebebida.elementoBebida_elemento_elemento_id =" + datosElementosBebida.getInt(1));
                    ResultSet datosBebidas = consulta2.executeQuery();
                    while (datosBebidas.next()) {
                        Bebida bebida = new Bebida(datosBebidas.getInt(6), datosBebidas.getString(2), Imagen.blobToImageIcon(new SerialBlob(datosBebidas.getBlob(1)).getBytes(1, (int) datosBebidas.getBlob(1).length())), datosBebidas.getFloat(3), datosBebidas.getFloat(4), datosBebidas.getFloat(5));
                        Float cantidad = new Float(datosBebidas.getFloat(7));
                        listaBebida.put(bebida, cantidad);
                    }
                    // Para obtener la imagen, primero sacamos el blob y con SerialBlob lo pasamos a byte[]
                    ElementoBebida elemento = new ElementoBebida(datosElementosBebida.getInt(1), listaBebida, datosElementosBebida.getString(2), datosElementosBebida.getString(3), Imagen.blobToImageIcon(new SerialBlob(datosElementosBebida.getBlob(1)).getBytes(1, (int) datosElementosBebida.getBlob(1).length())), datosElementosBebida.getInt(8), datosElementosBebida.getInt(7));
                    listaElementos.add(elemento);
                }
            } else {
                // Obtenemos los datos del elementoPlato con ese producto
                java.sql.PreparedStatement consulta = this.Conexion.prepareStatement("SELECT elemento.elemento_id, elemento.nombre, elemento.descripcion, elemento.disponible, elemento.foto, elemento.divi, elemento.divi_max, elemento.precio, elementoplato.tiempo_elaboracion FROM elemento, elementoplato, tieneingrediente "
                        + "WHERE elemento.elemento_id = elementoplato.elemento_elemento_id AND elemento.elemento_id = elementoComida_elemento_elemento_id AND productoIngrediente_producto_producto_id = " + producto.getCodPro());
                ResultSet datosElementosPlato = consulta.executeQuery();
                while (datosElementosPlato.next()) {
                    listaIngredientes = new HashMap<Ingrediente, Float>();
                    java.sql.PreparedStatement consulta2 = this.Conexion.prepareStatement("SELECT producto.foto, producto.nombre, producto.minimo, producto.maximo, producto.cantidad, producto.producto_id, tieneingrediente.cantidad FROM tieneingrediente, producto WHERE "
                            + "tieneingrediente.productoIngrediente_producto_producto_id"
                            + " = producto.producto_id AND tieneingrediente.elementoComida_elemento_elemento_id =" + datosElementosPlato.getInt(1));
                    ResultSet datosIngredientes = consulta2.executeQuery();
                    while (datosIngredientes.next()) {
                        Ingrediente ingrediente = new Ingrediente(datosIngredientes.getInt(6), datosIngredientes.getString(2), datosIngredientes.getFloat(5), datosIngredientes.getFloat(3), datosIngredientes.getFloat(4), Imagen.blobToImageIcon(new SerialBlob(datosIngredientes.getBlob(1)).getBytes(1, (int) datosIngredientes.getBlob(1).length())));
                        Float cantidad = new Float(datosIngredientes.getFloat(7));
                        listaIngredientes.put(ingrediente, cantidad);
                    }
                    // Para obtener la imagen, primero sacamos el blob y con SerialBlob lo pasamos a byte[]
                    ElementoPlato elemento = new ElementoPlato(datosElementosPlato.getInt(1), listaIngredientes, datosElementosPlato.getString(2), datosElementosPlato.getString(3), Imagen.blobToImageIcon(new SerialBlob(datosElementosPlato.getBlob(1)).getBytes(1, (int) datosElementosPlato.getBlob(1).length())), datosElementosPlato.getInt(9), datosElementosPlato.getInt(8), datosElementosPlato.getInt(7));
                    listaElementos.add(elemento);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(GestorBaseDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaElementos;
    }

    public HashSet<Elemento> obtieneElementosInvalidados() {
        HashSet<Elemento> elementosInvalidos = new HashSet<Elemento>();
        HashSet<Producto> productos = new HashSet<Producto>();
        java.sql.PreparedStatement consultaElementos, consultaProductos;
        ElementoBebida elementoBebida = null;
        ElementoPlato elementoPlato = null;
        ResultSet rsElementos, rsProductos;

        //1.- Obtengo la lista con todos los productos.
        //2.- Obtengo todos los elementos no disponibles.
        //3.- Para cada elemento obtengo los codigos de los productos q necesita y la cantidad de cada uno de ellos.
        //4.- Compruebo el codigo de los productos de los elementos con el codigo de los productos de la lista que acabo de crear.
        //5.- Si el codigo coincide meto el producto y la cantidad en la lista de productos del elemento.
        //6.- Devuelvo la lista de elementos.


        try {

            // 1.- Obtengo la lista con todos los productos, se obtiene aqui para despues ir introducciendo el producto
            // en el contenedor del elemento correspondiente, de esta forma los elementos comparten los mismos productos.
            consultaProductos = this.Conexion.prepareStatement("SELECT producto.producto_id, producto.nombre, producto.cantidad, producto.maximo, producto.minimo, producto.foto FROM producto");
            rsProductos = consultaProductos.executeQuery();
            while (rsProductos.next()) {
                Producto producto = new Producto(Imagen.blobToImageIcon(new SerialBlob(rsProductos.getBlob(6)).getBytes(1, (int) rsProductos.getBlob(6).length())), rsProductos.getString(2), rsProductos.getInt(5), rsProductos.getInt(4), rsProductos.getInt(3), rsProductos.getInt(1));
                productos.add(producto);
            }

            //2.- Obtengo todos los elementos no disponibles
            //2.a.- Primero obtengo las bebidas no disponibles
            consultaElementos = this.Conexion.prepareStatement("SELECT elemento_id, nombre, descripcion, disponible, foto, divi, divi_max, precio FROM elemento, elementobebida WHERE elemento.elemento_id = elementobebida.elemento_elemento_id AND elemento.disponible = 0");
            rsElementos = consultaElementos.executeQuery();
            while (rsElementos.next()) {
                //3.a.- Para cada elemento obtengo los codigos de los productos que necesita
                HashMap<Bebida, Float> listaProductosElemento = new HashMap<Bebida, Float>();
                consultaProductos = this.Conexion.prepareStatement("SELECT producto.producto_id, tienebebida.cantidad FROM tienebebida, producto WHERE "
                        + "tienebebida.productoBebida_producto_producto_id = producto.producto_id AND tienebebida.elementoBebida_elemento_elemento_id =" + rsElementos.getInt(1));
                rsProductos = consultaProductos.executeQuery();
                while (rsProductos.next()) {
                    //4.a.- Compruebo el codigo de los productos de los elementos con el código de los productos de la lista que acabo de crear
                    Iterator iterador = productos.iterator();
                    while (iterador.hasNext()) {
                        Bebida bebida = (Bebida) iterador.next();
                        if (bebida.getCodPro() == rsProductos.getInt(1)) {
                            //5.a.- Si el codigo coincide meto el producto y la cantidad en la lista de productos del elemento.
                            listaProductosElemento.put(bebida, new Float(rsProductos.getFloat(2)));
                        }
                    }
                }

                elementoBebida = new ElementoBebida(rsElementos.getInt(1), listaProductosElemento, rsElementos.getString(2), rsElementos.getString(3), Imagen.blobToImageIcon(new SerialBlob(rsElementos.getBlob(5)).getBytes(1, (int) rsElementos.getBlob(5).length())), rsElementos.getFloat(8), rsElementos.getInt(7));
                elementoBebida.setDisponible(false);
                elementoBebida.setDivisiones(rsElementos.getInt(6));
            }
            //2.a.- ElementoBebida No Disponible
            elementosInvalidos.add(elementoBebida);

            //2.- Obtengo todos los elementos no disponibles
            //2.b.- Continuo con los platos no disponibles
            consultaElementos = this.Conexion.prepareStatement("SELECT elemento_id, nombre, descripcion, disponible, foto, divi, divi_max, precio, tiempo_elaboracion FROM elemento, elementoplato WHERE elemento.elemento_id = elementoplato.elemento_elemento_id AND elemento.disponible = 0");
            rsElementos = consultaElementos.executeQuery();
            while (rsElementos.next()) {
                //3.b.- Para cada elemento obtengo los codigos de los productos que necesita
                HashMap<Ingrediente, Float> listaProductosElemento = new HashMap<Ingrediente, Float>();
                consultaProductos = this.Conexion.prepareStatement("SELECT producto.producto_id, tieneingrediente.cantidad FROM tieneingrediente, producto WHERE "
                        + "tieneingrediente.productoIngrediente_producto_producto_id = producto.producto_id AND tieneingrediente.elementoComida_elemento_elemento_id =" + rsElementos.getInt(1));
                rsProductos = consultaProductos.executeQuery();
                while (rsProductos.next()) {
                    //4.b.- Compruebo el codigo de los productos de los elementos con el código de los productos de la lista que acabo de crear
                    Iterator iterador = productos.iterator();
                    while (iterador.hasNext()) {
                        Ingrediente ingrediente = (Ingrediente) iterador.next();
                        if (ingrediente.getCodPro() == rsProductos.getInt(1)) {
                            //5.b.- Si el codigo coincide meto el producto y la cantidad en la lista de productos del elemento.
                            listaProductosElemento.put(ingrediente, new Float(rsProductos.getFloat(2)));
                        }
                    }
                }
                elementoPlato = new ElementoPlato(rsElementos.getInt(1), listaProductosElemento, rsElementos.getString(2), rsElementos.getString(3), Imagen.blobToImageIcon(new SerialBlob(rsElementos.getBlob(5)).getBytes(1, (int) rsElementos.getBlob(5).length())), rsElementos.getInt(9), rsElementos.getFloat(8), rsElementos.getInt(7));
                elementoPlato.setDisponible(false);
                elementoPlato.setDivisiones(rsElementos.getInt(6));
            }
            //2.b.- ElementoPlato No Disponible
            elementosInvalidos.add(elementoPlato);

        } catch (SQLException ex) {
            Logger.getLogger(GestorBaseDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
        //6.- Devuelvo la lista de elementos.
        return elementosInvalidos;
    }

    public HashSet<Seccion> obtieneSecciones() {
        HashSet<Seccion> listaSecciones = new HashSet<Seccion>();
        HashSet<ElementoBebida> listaElementosB = new HashSet<ElementoBebida>();
        HashSet<ElementoPlato> listaElementosP = new HashSet<ElementoPlato>();
        HashMap<Bebida, Float> listaBebida = null;
        HashMap<Ingrediente, Float> listaIngredientes = null;
        try {
            // Construimos el objeto Carta necesario para crear una Seccion
            java.sql.Statement consulta = (Statement) this.Conexion.createStatement();
            ResultSet datosCarta = consulta.executeQuery("SELECT ultima_modificacion FROM carta");
            datosCarta.next();
            Carta carta = new Carta((java.sql.Date) datosCarta.getDate(1));
            // Obtenemos todas las secciones de la carta, primero de comida y luego de bebida
            consulta = (Statement) this.Conexion.createStatement();
            // Para cada seccion obtenida, creamos su objeto e insertamos en el HashSet
            ResultSet datosSeccion = consulta.executeQuery("SELECT seccion.seccion_id, seccion.nombre FROM seccion, seccionbebida WHERE seccion.seccion_id = seccionbebida.seccion_seccion_id");
            while (datosSeccion.next()) {
                // Si estamos en una SeccionBebida sacamos todos los elementos de la seccion
                consulta = this.Conexion.createStatement();
                ResultSet datosElementosBebida = consulta.executeQuery("SELECT elemento.elemento_id, elemento.nombre, elemento.descripcion, elemento.disponible, elemento.foto, elemento.divi, elemento.divi_max, elemento.precio FROM elemento, incluyebebida WHERE elemento.elemento_id = incluyebebida.elementoBebida_elemento_elemento_id AND incluyebebida.seccionBebida_seccion_seccion_id ="+datosSeccion.getInt(1));
                while (datosElementosBebida.next()) {
                    // Obtenemos todas las bebidas
                    listaBebida = new HashMap<Bebida, Float>();
                    java.sql.PreparedStatement consulta2 = this.Conexion.prepareStatement("SELECT producto.foto, producto.nombre, producto.minimo, producto.maximo, producto.cantidad, producto.producto_id, tienebebida.cantidad FROM tienebebida, producto WHERE "
                            + "tienebebida.productoBebida_producto_producto_id"
                            + " = producto.producto_id AND tienebebida.elementoBebida_elemento_elemento_id =" + datosElementosBebida.getInt(1));
                    ResultSet datosBebidas = consulta2.executeQuery();
                    while (datosBebidas.next()) {
                        Bebida bebida = new Bebida(datosBebidas.getInt(6), datosBebidas.getString(2), Imagen.blobToImageIcon(new SerialBlob(datosBebidas.getBlob(1)).getBytes(1, (int) datosBebidas.getBlob(1).length())), datosBebidas.getFloat(3), datosBebidas.getFloat(4), datosBebidas.getFloat(5));
                        Float cantidad = new Float(datosBebidas.getFloat(7));
                        listaBebida.put(bebida, cantidad);
                    }
                    // Para obtener la imagen, primero sacamos el blob y con SerialBlob lo pasamos a byte[]
                    ElementoBebida elemento = new ElementoBebida(datosElementosBebida.getInt(1), listaBebida, datosElementosBebida.getString(2), datosElementosBebida.getString(3), Imagen.blobToImageIcon(new SerialBlob(datosElementosBebida.getBlob(1)).getBytes(1, (int) datosElementosBebida.getBlob(1).length())), datosElementosBebida.getInt(8), datosElementosBebida.getInt(7));
                    listaElementosB.add(elemento);
                }
                SeccionBebida seccion = new SeccionBebida(datosSeccion.getInt(1), datosSeccion.getString(2), carta, listaElementosB);
                listaSecciones.add(seccion);
            }
            consulta = (Statement) this.Conexion.createStatement();
            // Para cada seccion obtenida, creamos su objeto e insertamos en el HashSet
            datosSeccion = consulta.executeQuery("SELECT seccion.seccion_id, seccion.nombre FROM seccion, seccioncomida WHERE seccion.seccion_id = seccioncomida.seccion_seccion_id");
            while (datosSeccion.next()) {
                // Si estamos en una SeccionComida sacamos todos los elementos de la seccion
                consulta = this.Conexion.createStatement();
                ResultSet datosElementosPlato = consulta.executeQuery("SELECT elemento.elemento_id, elemento.nombre, elemento.descripcion, elemento.disponible, elemento.foto, elemento.divi, elemento.divi_max, elemento.precio, elementoplato.tiempo_elaboracion FROM elemento, elementoplato , incluyeplato WHERE elemento.elemento_id = incluyeplato.elementoPlato_elemento_elemento_id AND " +
                        "elemento.elemento_id = elementoplato.elemento_elemento_id AND incluyeplato.seccionComida_seccion_seccion_id ="+datosSeccion.getInt(1));
                // Obtenemos todos los ingredientes
                while (datosElementosPlato.next()) {
                    listaIngredientes = new HashMap<Ingrediente, Float>();
                    java.sql.PreparedStatement consulta2 = this.Conexion.prepareStatement("SELECT producto.foto, producto.nombre, producto.minimo, producto.maximo, producto.cantidad, producto.producto_id, tieneingrediente.cantidad FROM tieneingrediente, producto WHERE "
                            + "tieneingrediente.productoIngrediente_producto_producto_id"
                            + " = producto.producto_id AND tieneingrediente.elementoComida_elemento_elemento_id =" + datosElementosPlato.getInt(1));
                    ResultSet datosIngredientes = consulta2.executeQuery();
                    while (datosIngredientes.next()) {
                        Ingrediente ingrediente = new Ingrediente(datosIngredientes.getInt(6), datosIngredientes.getString(2), datosIngredientes.getFloat(5), datosIngredientes.getFloat(3), datosIngredientes.getFloat(4), Imagen.blobToImageIcon(new SerialBlob(datosIngredientes.getBlob(1)).getBytes(1, (int) datosIngredientes.getBlob(1).length())));
                        Float cantidad = new Float(datosIngredientes.getFloat(7));
                        listaIngredientes.put(ingrediente, cantidad);
                    }
                    // Para obtener la imagen, primero sacamos el blob y con SerialBlob lo pasamos a byte[]
                    ElementoPlato elemento = new ElementoPlato(datosElementosPlato.getInt(1), listaIngredientes, datosElementosPlato.getString(2), datosElementosPlato.getString(3), Imagen.blobToImageIcon(new SerialBlob(datosElementosPlato.getBlob(1)).getBytes(1, (int) datosElementosPlato.getBlob(1).length())), datosElementosPlato.getInt(9), datosElementosPlato.getInt(8), datosElementosPlato.getInt(7));
                    listaElementosP.add(elemento);
                }
                SeccionComida seccion = new SeccionComida(datosSeccion.getInt(1), datosSeccion.getString(2), carta, listaElementosP);
                listaSecciones.add(seccion);
            }
        } catch (SQLException ex) {
            Logger.getLogger(GestorBaseDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaSecciones;
    }

    public void eliminaProducto(Producto p) {
        try {
            int codPro = p.getCodPro();
            java.sql.PreparedStatement borrado;
            /*Preparamos la consulta de borrado del producto*/
            if (p instanceof Bebida) {
                borrado = this.Conexion.prepareStatement("delete from productobebida where producto_producto_id='" + codPro + "'");
                borrado.executeUpdate();
            } else if (p instanceof Ingrediente) {
                borrado = this.Conexion.prepareStatement("delete from productoingrediente where producto_producto_id='" + codPro + "'");
                borrado.executeUpdate();
            }
            java.sql.PreparedStatement borrado2 = this.Conexion.prepareStatement("delete from producto where producto_id='" + codPro + "'");
            borrado2.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(GestorBaseDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void modificarProducto(Producto p) {
        try {
            /*Preparamos la consulta de actualizacion del producto*/
            int codigoProducto = p.getCodPro();
            java.sql.PreparedStatement actualizacion = this.Conexion.prepareStatement("update producto set cantidad=?, maximo=?, minimo=?, nombre=?, foto=? where producto_id='" + codigoProducto + "'");
            actualizacion.setFloat(1, p.getCantidad());
            actualizacion.setFloat(2, p.getMaximo());
            actualizacion.setFloat(3, p.getMinimo());
            actualizacion.setString(4, p.getNombre());
            actualizacion.setBinaryStream(1, new ByteArrayInputStream(Imagen.imageIconToByteArray(p.getImagen())));
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
            inserccion.setBinaryStream(1, new ByteArrayInputStream(Imagen.imageIconToByteArray(p.getImagen())));

            //Ejecutamos la inserccion
            Statement ultimo = (Statement) this.Conexion.createStatement();
            inserccion.executeUpdate();//Insertamos la incidencia
            ResultSet id = ultimo.executeQuery("select MAX(producto_id) from producto;"); // Sacamos su ID
            id.next();
            p.setCodPro(id.getInt(1));

            /*Actualizamos en la tabla de bebidas o de ingredientes segun corresponda*/
            java.sql.PreparedStatement relacion;
            if (p instanceof Bebida) {
                relacion = this.Conexion.prepareStatement("insert into productobebida" + "(producto_producto_id) " + "values ( ? )");
                relacion.setInt(1, p.getCodPro());
                relacion.executeUpdate();
            } else if (p instanceof Ingrediente) {
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
            java.sql.PreparedStatement relacion = this.Conexion.prepareStatement("insert into tieneincidencia"
                    + "(incidencia_incidencia_id,producto_producto_id) "
                    + "values ( ? , ? )");
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
        try {
            /*Preparamos la consulta de inserccion del pedido*/
            java.sql.PreparedStatement insercion = this.Conexion.prepareStatement("insert into pedidoproveedor"
                    + "(fecha_pedido,recibido)"
                    + " values ( ? , ?)");
            insercion.setBoolean(2, pedProdveedor.fueRecibido());
            insercion.setDate(1, (Date) pedProdveedor.getFechaPedido());

            /*Preparamos la relacion con los productos pedidos*/
            Statement ultimo = (Statement) this.Conexion.createStatement();
            java.sql.PreparedStatement relacion = this.Conexion.prepareStatement("insert into tienepedido "
                    + "values (?,?,?)");
            Iterator it = pedProdveedor.obtenerInfoPedido().entrySet().iterator();

            //Ejecutamos las consultas
            insercion.executeUpdate();//Insertamos la incidencia
            ResultSet id = ultimo.executeQuery("select MAX(pedido_proveedor_id) from pedidoproveedor"); // Sacamos su ID
            id.next();
            pedProdveedor.setCodigo(id.getInt(1));
            relacion.setInt(1, pedProdveedor.getCodigo()); // Metemeos el ID en la consulta de relacion
            while (it.hasNext()) {
                Map.Entry data = (Entry) it.next();
                relacion.setInt(2, ((Producto) data.getKey()).getCodPro());
                relacion.setFloat(3, (Float) data.getValue());
                relacion.executeUpdate();// insertamos la relacion.
            }
        } catch (SQLException ex) {
            Logger.getLogger(GestorBaseDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public HashSet<Producto> obtieneBebidas() {
        int codigoBebida;
        HashSet<Producto> listaBebidas = new HashSet<Producto>();
        Statement consulta;
        try {
            consulta = (Statement) this.Conexion.createStatement();
            ResultSet tablabebidas = consulta.executeQuery("select producto_producto_id FROM productobebida");

            while (tablabebidas.next()) {
                codigoBebida = tablabebidas.getInt(1);
                Statement consultaBebidas = (Statement) this.Conexion.createStatement();
                ResultSet tablaproductos = consultaBebidas.executeQuery("select * from producto where producto_id='" + codigoBebida + "'");
                tablaproductos.next();
                Bebida bebida = new Bebida(tablaproductos.getInt(1), tablaproductos.getString(2), Imagen.blobToImageIcon(tablaproductos.getBytes(6)),
                        tablaproductos.getFloat(5), tablaproductos.getFloat(4), tablaproductos.getFloat(3));
                listaBebidas.add(bebida);
            }
        } catch (SQLException ex) {
            Logger.getLogger(GestorBaseDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaBebidas;
    }

    public HashSet<Producto> obtieneIngredientes() {
        int codigoIngrediente;
        HashSet<Producto> listaIngredientes = new HashSet<Producto>();
        Statement consulta;
        try {
            consulta = (Statement) this.Conexion.createStatement();
            ResultSet tablaingredientes = consulta.executeQuery("select producto_producto_id FROM productoingrediente");

            while (tablaingredientes.next()) {
                codigoIngrediente = tablaingredientes.getInt(1);
                Statement consultaBebidas = (Statement) this.Conexion.createStatement();
                ResultSet tablaproductos = consultaBebidas.executeQuery("select * from producto where producto_id='" + codigoIngrediente + "'");
                tablaproductos.next();
                Ingrediente ingrediente = new Ingrediente(tablaproductos.getInt(1), tablaproductos.getString(2), tablaproductos.getFloat(3), tablaproductos.getFloat(4),
                        tablaproductos.getFloat(5), Imagen.blobToImageIcon(tablaproductos.getBytes(6)));
                listaIngredientes.add(ingrediente);
            }
        } catch (SQLException ex) {
            Logger.getLogger(GestorBaseDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaIngredientes;
    }

    public PedidoProveedor obtienePrimerPedidoPendiente() {
        try {
            Statement pedido = (Statement) this.Conexion.createStatement();
            ResultSet infoPedido = pedido.executeQuery("select pedido_proveedor_id, fecha_pedido, recibido "
                    + "from pedidoproveedor n , (select  MIN(pedido_proveedor_id) min_id from pedidoproveedor where recibido = false) mini "
                    + "where n.pedido_proveedor_id = mini.min_id;");
            infoPedido.next();
            ResultSet tablaproductos = pedido.executeQuery("select producto_id, nombre, producto.cantidad, maximo,minimo, foto, tienepedido.cantidad"
                    + "from producto, tienepedido"
                    + " where pedidoProveedor_pedido_proveedor_id = '" + infoPedido.getInt(1)
                    + "' and producto_producto_id = producto_id;");
            HashMap<Producto, Float> productosCantidad = new HashMap<Producto, Float>();
            while (tablaproductos.next()) {
                Producto producto = new Producto(Imagen.blobToImageIcon(tablaproductos.getBytes(6)), tablaproductos.getString(2),
                        tablaproductos.getFloat(5), tablaproductos.getFloat(4), tablaproductos.getFloat(3), tablaproductos.getInt(1));
                productosCantidad.put(producto, tablaproductos.getFloat(7));
            }
            return new PedidoProveedor(infoPedido.getInt(1), productosCantidad, infoPedido.getDate(2), infoPedido.getBoolean(3));
        } catch (SQLException ex) {
            Logger.getLogger(GestorBaseDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public HashMap<Producto, Float> obtieneProductosBajoMinimos() {
        HashMap<Producto, Float> listaProductos = new HashMap<Producto, Float>();
        try {
            Statement consultaProductos = (Statement) this.Conexion.createStatement();
            ResultSet tablaproductos = consultaProductos.executeQuery("select * from producto where producto.cantidad < producto.minimo");
            while (tablaproductos.next()) {
                Producto producto = new Producto(Imagen.blobToImageIcon(tablaproductos.getBytes(6)), tablaproductos.getString(2),
                        tablaproductos.getFloat(5), tablaproductos.getFloat(4), tablaproductos.getFloat(3), tablaproductos.getInt(1));
                listaProductos.put(producto, producto.getCantidad());
            }
        } catch (SQLException ex) {
            Logger.getLogger(GestorBaseDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaProductos;
    }

    public void pedidoRecibido(PedidoProveedor pedProveedor) {
        try {
            Statement actualiza = (Statement) this.Conexion.createStatement();
            actualiza.executeUpdate("update pedidoproveedor set recibido= '1' where pedido_proveedor_id = " + pedProveedor.getCodigo());
        } catch (SQLException ex) {
            Logger.getLogger(GestorBaseDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void restarCantidadProducto(Producto p, Float c) {
        try {
            /*Preparamos la consulta de actualizacion del producto*/
            int codigoProducto = p.getCodPro();
            java.sql.PreparedStatement actualizacion = this.Conexion.prepareStatement("update producto set cantidad=? where producto_id='" + codigoProducto + "'");
            float cantidad = p.getCantidad() - c;
            actualizacion.setFloat(1, cantidad);
            actualizacion.executeUpdate();//Insertamos la incidencia
            p.actualizarCantidad(-c);
        } catch (SQLException ex) {
            Logger.getLogger(GestorBaseDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public ArrayList<Pedido> obtienePedidosNoFacturados(){
        ArrayList<Pedido> noFacturados = new ArrayList<Pedido>();

        ElementoPedido elemPed = null;
        try {
            Statement consulta = (Statement) this.Conexion.createStatement();
            ResultSet resultado = consulta.executeQuery("SELECT pedido_id, mesa_id, estado, fecha FROM pedido WHERE estado <> 2");
 
            while (resultado.next()) {
                System.out.println("Aqui entro 1.");
                Pedido p = new Pedido(resultado.getInt(1), resultado.getInt(2),
                        resultado.getInt(3),resultado.getDate(4));
                Statement consulta2 = (Statement) this.Conexion.createStatement();
                ResultSet resElemPed = consulta2.executeQuery("SELECT elementoPedido_id, estado, " +
                        "comentario FROM elementopedido WHERE elementoPedido_id IN (SELECT elementoPedido_elementoPedido_id " +
                        "FROM tieneelemento WHERE pedido_pedido_id = "+p.getCodPedido()+")");

                while(resElemPed.next()){

                    elemPed = new ElementoPedido(resElemPed.getInt(1),resElemPed.getInt(2),
                            resElemPed.getString(3));
                    System.out.println("Creo un elementoPedido con  codigo: " +
                            elemPed.getCodElementoPedido() + " , estado = " +
                            elemPed.getEstado() + " comentario: " +
                            elemPed.getComentario());
                    ResultSet resElem = consulta.executeQuery("SELECT elemento_id, nombre, descripcion, disponible, " +
                            "foto, divi, divi_max, precio,tiempo_elaboracion FROM elemento, elementoplato " +
                            "WHERE elemento_elemento_id = elemento_id AND elemento_id IN " +
                            "( SELECT elemento_elemento_id FROM elementoplato WHERE elemento_elemento_id IN " +
                            "( SELECT elementoPedido_elementoPedido_id FROM elementocolacocina " +
                            "WHERE elementoPedido_elementoPedido_id IN " +
                            "( SELECT elementoPedido_id FROM elementoPedido)))");
                    if(resElem.next()){
                        ElementoPlato elemento = new ElementoPlato(resElem.getInt(1), resElem.getString(2),
                                resElem.getString(3), resElem.getBoolean(4),Imagen.blobToImageIcon(new SerialBlob(resElem.getBlob(5)).getBytes(1, (int)resElem.getBlob(5).length()))
                                ,resElem.getInt(6), resElem.getInt(7),resElem.getFloat(8),resElem.getInt(9));

                        ResultSet  resProds = consulta.executeQuery( "SELECT producto_id," +
                                " nombre, cantidad, maximo, minimo, foto FROM producto WHERE producto_id IN " +
                                "( SELECT productoIngrediente_producto_producto_id " +
                                "FROM tieneingrediente WHERE elementoComida_elemento_elemento_id IN " +
                                "(SELECT elemento_elemento_id FROM elementoplato WHERE elemento_elemento_id = "+elemento.getCodigoElemento()+ ") ) ");
    
                        while(resProds.next()){
   
                            Ingrediente prod = new Ingrediente(resProds.getInt(1),resProds.getString(2),
                                    resProds.getInt(3),resProds.getInt(4),resProds.getInt(5),
                                    Imagen.blobToImageIcon(new SerialBlob(resProds.getBlob(6)).getBytes(1, (int)resProds.getBlob(6).length())));

                           ResultSet resCantidad = consulta.executeQuery("Select cantidad FROM tieneingrediente " +
                                    "WHERE elementoComida_elemento_elemento_id = " + elemento.getCodigoElemento() +
                                    " AND productoIngrediente_producto_producto_id = " + prod.getCodPro());

                            resCantidad.next();
                            elemento.asocia(prod, resCantidad.getFloat(1));
                        }
                        elemPed.asocia(elemento);
                     }
        
                }
                    if(elemPed instanceof ElementoColaCocina) //Si es ColaCocina
                         p.asocia((ElementoColaCocina)elemPed);
            }

        } catch (SQLException ex) {
            //System.err.println("Error al obtener los pedidos no facturados");

        }

        return noFacturados;
    }

    public int getNumPlatosEnCola() {
        Statement consulta;
        int numplatos=-1;
        try {
            consulta = (Statement) this.Conexion.createStatement();
            ResultSet resultado = consulta.executeQuery("SELECT COUNT( elementoPedido_elementoPedido_id) " +
                                                        "FROM elementoPedido,elementoColaCocina WHERE elementoPedido_id = " +
                                                        "elementoPedido_elementoPedido_id AND estado = 0");
            resultado.next();
            numplatos = resultado.getInt(1);

        } catch (SQLException ex) {

            System.err.println("Error al obtener el numero de platos");
        }

        return numplatos;
    }

    public int getNumBebidasEnCola() {
        Statement consulta;
        int numbebidas=-1;
        try {
            consulta = (Statement) this.Conexion.createStatement();
            ResultSet resultado = consulta.executeQuery("SELECT COUNT( elementoPedido_elementoPedido_id) " +
                                                        "FROM elementoPedido,elementoColaBar WHERE elementoPedido_id = " +
                                                        "elementoPedido_elementoPedido_id AND estado = 0");
            resultado.next();
            numbebidas = resultado.getInt(1);

        } catch (SQLException ex) {
            Logger.getLogger(GestorBaseDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return numbebidas;
    }

    // Actualiza el estado del pedido
    public void actualizaPedido(Pedido p) {
        try{
            java.sql.PreparedStatement actPedido = this.Conexion.prepareStatement("UPDATE pedido SET estado=? WHERE pedido_id='" + p.getCodPedido()+"'");
            actPedido.setInt(1, p.getEstado());
            actPedido.executeUpdate();
            java.sql.PreparedStatement actElem = this.Conexion.prepareStatement("UPDATE elementopedido SET estado=?,comentario=? WHERE elementoPedido_id=?");
            ArrayList<ElementoPedido> elementos = p.obtieneElementos();
            Iterator ite = elementos.iterator();
            while (ite.hasNext()){
                ElementoPedido eped = ((ElementoPedido)ite.next());
                int est = eped.getEstado();
                String comment = eped.getComentario();
                int id = eped.getCodElementoPedido();
                actElem.setInt(1, est);
                actElem.setString(2, comment);
                actElem.setInt(3, id);
                actElem.executeUpdate();
            }
        } catch (SQLException ex) {
            Logger.getLogger(GestorBaseDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Factura getFactura(int codMesa){
        Factura fac = null;
        try{
            Statement consulta = (Statement) this.Conexion.createStatement();
            ResultSet factura = consulta.executeQuery("SELECT factura_id,estado,fecha FROM factura,facturapedido,pedido WHERE factura_id = factura_factura_id AND pedido_pedido_id = pedido_id AND mesa_id = "+codMesa+" AND estado = 1");
            factura.next();
            fac = new Factura(factura.getInt(1),factura.getInt(2),factura.getDate(3));
            ArrayList<Pedido> pedidos = this.getPedidosModificablesMesa(codMesa);
            for (int i=0;i<pedidos.size();i++)
                fac.asocia(pedidos.get(i));
        } catch (SQLException ex) {
            Logger.getLogger(GestorBaseDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return fac;
    }

    public ArrayList<Pedido> getPedidosModificablesMesa(int codMesa){
        ArrayList<Pedido> pedidos = new ArrayList();
        try {
            Statement consultaPedidos = (Statement) this.Conexion.createStatement();
            ResultSet resultado = consultaPedidos.executeQuery(" select pedido_id,mesa_id,estado,fecha from pedido where estado = 0 AND mesa_id = " + codMesa);
            while (resultado.next()) {
                Pedido pedido = new Pedido(resultado.getInt(1), resultado.getInt(2), resultado.getInt(3), resultado.getDate(4));
                Statement consultaElemPed = (Statement) this.Conexion.createStatement();
                ResultSet resElemPed = consultaElemPed.executeQuery(" select elementoPedido_id,estado,comentario from elementopedido where elementoPedido_id IN " +
                        "(select elementoPedido_elementoPedido_id from tieneelemento where pedido_pedido_id = " + pedido.getCodPedido() + ")");
                while (resElemPed.next()) {
                    ElementoPedido elemPed = new ElementoPedido(resElemPed.getInt(1), resElemPed.getInt(2), resElemPed.getString(3));
                    ResultSet resElem;
                    ResultSet resProds;
                    Elemento elem;
                    
                    //Comprobamos si es un PLATO
                    Statement consultaElem = (Statement) this.Conexion.createStatement();
                    resElem = consultaElem.executeQuery(" SELECT elemento_id, nombre, descripcion, disponible, foto, divi, divi_max, precio FROM elemento WHERE elemento_id IN " + "(SELECT elementoPlato_elemento_elemento_id FROM asociaplato WHERE elementoColaCocina_elementoPedido_elementoPedido_id = " + elemPed.getCodElementoPedido() + ")");

                    if(resElem.next()){
                        elem = new Elemento(resElem.getInt(1), resElem.getString(2), resElem.getString(3), resElem.getBoolean(4), Imagen.blobToImageIcon(new SerialBlob(resElem.getBlob(6)).getBytes(1, (int) resElem.getBlob(1).length())), resElem.getInt(6), resElem.getInt(7), resElem.getFloat(8));
                        ElementoPlato elemPlato = new ElementoPlato(elem,0);

                        //Asociamos los ingredientes
                        Statement consultaIngredientes = (Statement) this.Conexion.createStatement();
                        resProds = consultaIngredientes.executeQuery("SELECT producto_id, nombre, cantidad, maximo, minimo, foto FROM producto WHERE producto_id IN " + "( SELECT productoIngrediente_producto_producto_id FROM tieneingrediente WHERE elementoComida_elemento_elemento_id IN " + "(SELECT elemento_elemento_id FROM elementoplato WHERE elemento_elemento_id = " + resElem.getInt(1) + ")) ");
                        HashMap<Ingrediente,Float> temp = new HashMap();
                        while (resProds.next()) {
                            Ingrediente ingrediente = new Ingrediente(resProds.getInt(1), resProds.getString(2), resProds.getFloat(3), resProds.getFloat(4), resProds.getFloat(5), Imagen.blobToImageIcon(new SerialBlob(resProds.getBlob(6)).getBytes(1, (int) resProds.getBlob(1).length())));
                            temp.put(ingrediente, new Float(0));
                        }
                        ElementoPlato elemComida = new ElementoPlato(elem.getCodigoElemento(), temp, elem.getNombre(), elem.getDescripcion(), elem.getFoto(), 0, elem.getPrecio(), elem.getDivisionesMaximas());
                        ElementoColaCocina elemColaCocina = new ElementoColaCocina(elemPed.getCodElementoPedido(), elemPed.getEstado(), elemPed.getComentario());
                        elemColaCocina.asocia(elemComida);
                        pedido.asocia(elemColaCocina);
                    }else{ //Es una BEBIDA
                        resElem = consultaElem.executeQuery(" SELECT elemento_id, nombre, descripcion, disponible, foto, divi, divi_max, precio FROM elemento WHERE elemento_id IN " +
                                "(SELECT elementoBebida_elemento_elemento_id FROM asociabebida WHERE elementoColaBar_elementoPedido_elementoPedido_id = " + elemPed.getCodElementoPedido() + ")");
                        resElem.next();
                        elem = new Elemento(resElem.getInt(1), resElem.getString(2), resElem.getString(3), resElem.getBoolean(4), Imagen.blobToImageIcon(new SerialBlob(resElem.getBlob(6)).getBytes(1, (int) resElem.getBlob(1).length())), resElem.getInt(6), resElem.getInt(7), resElem.getFloat(8));
                        //Asociamos las bebidas
                        Statement consultaBebidas = (Statement) this.Conexion.createStatement();
                        resProds = consultaBebidas.executeQuery("SELECT producto_id, nombre, cantidad, maximo, minimo, foto FROM producto WHERE producto_id IN " + "( SELECT productoBebida_producto_producto_id FROM tienebebida WHERE elementoBebida_elemento_elemento_id IN " + "(SELECT elemento_elemento_id FROM elementobebida WHERE elemento_elemento_id = " + resElem.getInt(1) + ")) ");
                        HashMap<Bebida,Float> temp = new HashMap();
                        while (resProds.next()) {
                            Bebida bebida = new Bebida(resProds.getInt(1), resProds.getString(2), Imagen.blobToImageIcon(new SerialBlob(resProds.getBlob(6)).getBytes(1, (int) resProds.getBlob(1).length())), resProds.getInt(3), resProds.getInt(4), resProds.getInt(5));
                            temp.put(bebida, new Float(0));
                        }
                        ElementoBebida elemBebida = new ElementoBebida(elem.getCodigoElemento(),temp,elem.getNombre(), elem.getDescripcion(), elem.getFoto(), elem.getPrecio(),elem.getDivisiones());

                        ElementoColaBar elemColaBar = new ElementoColaBar(elemPed.getCodElementoPedido(), elemPed.getEstado(), elemPed.getComentario());
                        elemColaBar.asocia(elemBebida);
                        pedido.asocia(elemColaBar);
                    }
                }
                pedidos.add(pedido);
            }
        } catch (SQLException ex) {
            Logger.getLogger(GestorBaseDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return pedidos;
    }

    // Actualiza el estado de la factura
    public void actualizaFactura(Factura f){
        try {
            java.sql.PreparedStatement accion = this.Conexion.prepareStatement("UPDATE factura SET estado=? WHERE factura_id='"+ f.getCodFactura()+"'");
            accion.setInt(1, f.getEstado());
            accion.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(GestorBaseDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean nuevoPedido(Pedido pedido) {
        try {
            // Inserción para pedido
            java.sql.PreparedStatement insercionPedido = this.Conexion.prepareStatement(
                    "INSERT INTO pedido(pedido_id,mesa_id,estado,fecha) VALUES (?,?,?,?)");
            // Inserción para tieneelemento
            java.sql.PreparedStatement insercionTieneElemento = this.Conexion.prepareStatement(
                    "INSERT INTO tieneelemento(elementoPedido_elementoPedido_id,pedido_pedido_id) VALUES(?,?)");
            //Inserción para elementopedido
            java.sql.PreparedStatement insercionElementoPedido = this.Conexion.prepareStatement(
                    "INSERT INTO elementopedido(elementoPedido_id,estado,comentario) VALUES(?,?,?)");
            //Inserción para elementocolacocina
            java.sql.PreparedStatement insercionColaCocina = this.Conexion.prepareStatement(
                    "INSERT INTO elementocolacocina VALUES(?)");
            //Inserción para elementocolabar
            java.sql.PreparedStatement insercionColaBar = this.Conexion.prepareStatement(
                    "INSERT INTO elementocolabar VALUES(?)");
            //Inserción para asociaplato
            java.sql.PreparedStatement insercionAsociaPlato = this.Conexion.prepareStatement(
                    "INSERT INTO asociaplato VALUES(?,?)");
            //Inserción para asociabebida
            java.sql.PreparedStatement insercionAsociaBebida = this.Conexion.prepareStatement(
                    "INSERT INTO asociabebida VALUES(?,?)");

            //Insertamos el pedido
            insercionPedido.setInt(1, pedido.getCodPedido());
            insercionPedido.setInt(2, pedido.getCodMesa());
            insercionPedido.setInt(3, pedido.getEstado());
            java.util.Date fecha = new java.util.Date();
            insercionPedido.setDate(4, new Date(fecha.getTime()));
            insercionPedido.executeUpdate();

            ArrayList<ElementoPedido> elementos = pedido.getElementos();

            Iterator it = elementos.iterator();
            while(it.hasNext()){
                ElementoPedido elem = (ElementoPedido) it.next();
                
                //Insertamos elemento pedido
                insercionElementoPedido.setInt(1, elem.getCodElementoPedido());
                insercionElementoPedido.setInt(2, elem.getEstado());
                insercionElementoPedido.setString(3, elem.getComentario());
                insercionElementoPedido.executeUpdate();

                //Insertamos  la relacion pedido elementopedido
                insercionTieneElemento.setInt(1, elem.getCodElementoPedido());
                insercionTieneElemento.setInt(2, pedido.getCodPedido());
                insercionTieneElemento.executeUpdate();

                if(elem instanceof ElementoColaCocina){
                    //Insertamos el elementoColaCocina
                    insercionColaCocina.setInt(1, elem.getCodElementoPedido());
                    insercionColaCocina.executeUpdate();
                    //Insertamos la relacion elementopedido elem
                    insercionAsociaPlato.setInt(1, elem.getCodElementoPedido());
                    insercionAsociaPlato.setInt(2, elem.getElemento().getCodigoElemento());
                    insercionAsociaPlato.executeUpdate();
                }else{
                    //Insertamos el elementoColaBar
                    insercionColaBar.setInt(1, elem.getCodElementoPedido());
                    insercionColaBar.executeUpdate();
                    //Insertamos la relacion elementopedido elem
                    insercionAsociaBebida.setInt(1, elem.getCodElementoPedido());
                    insercionAsociaBebida.setInt(2, elem.getElemento().getCodigoElemento());
                    insercionAsociaBebida.executeUpdate();
                }


            }
            
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(GestorBaseDatos.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    //TODO Este método no está reflejado en el diseño
    public Pedido getSiguientePedidoBar() {
        Pedido ped = null;
        try {
            Statement consulta = (Statement) this.Conexion.createStatement();
            // Obtengo los pedidos cuyo estado es distinto de Facturado y tiene elementosColaBar en Cola
            ResultSet tablaPedidos = consulta.executeQuery("SELECT pedido_id, mesa_id, pedido.estado, fecha " +
                                                            "FROM pedido, tieneElemento, elementoPedido, elementoColaBar " +
                                                            "WHERE pedido.estado <> 2 AND pedido_id = pedido_pedido_id " +
                                                            "AND tieneElemento.elementoPedido_elementoPedido_id = elementoPedido_id " +
                                                            "AND elementoPedido_id = elementoColaBar.elementoPedido_elementoPedido_id " +
                                                            "AND elementoPedido.estado =0 GROUP BY pedido_id " +
                                                            "HAVING COUNT( elementoColaBar.elementoPedido_elementoPedido_id ) >0");
            if (tablaPedidos.next()){
                HashSet<Elemento> elementosCarta = this.obtieneElementos(); // TODO Arreglar la consulta. Los objetos de los productos no son iguales.
                // Obtengo los elementoPedido asociados al pedido
                ped = new Pedido(tablaPedidos.getInt(2),tablaPedidos.getInt(1),tablaPedidos.getInt(3),tablaPedidos.getDate(4));
                Statement consulta2 = (Statement) this.Conexion.createStatement();
                ResultSet tablaElementosPedido = consulta2.executeQuery("SELECT elementoPedido_id,estado,comentario FROM tieneElemento,elementoPedido WHERE pedido_pedido_id = "+tablaPedidos.getInt(1)+" AND elementoPedido_elementoPedido_id = elementoPedido_id");
                ResultSet codigoElemento;
                ElementoColaBar eleCB;
                ElementoColaCocina eleCC;
                boolean encontrado;
                Iterator<Elemento> it;
                Elemento ele = null;
                Statement consulta3 = (Statement) this.Conexion.createStatement();
                while (tablaElementosPedido.next()){
                    //Obtengo SOLO EL CODIGO del elemento de la carta asociado al elementoPedido. Comprueba si es un plato
                    codigoElemento = consulta3.executeQuery("SELECT elementoPlato_elemento_elemento_id FROM asociaPlato WHERE elementoColaCocina_elementoPedido_elementoPedido_id = "+tablaElementosPedido.getInt(1));
                    if (!codigoElemento.next()){
                        // No es un plato es una bebida
                        codigoElemento = consulta3.executeQuery("SELECT elementoBebida_elemento_elemento_id FROM asociaBebida WHERE elementoColaBar_elementoPedido_elementoPedido_id = "+tablaElementosPedido.getInt(1));
                        codigoElemento.next();
                        eleCB = new ElementoColaBar(tablaElementosPedido.getInt(1),tablaElementosPedido.getInt(2),tablaElementosPedido.getString(3));
                        // Busco el objeto elemento de carta
                        encontrado = false;
                        for (it = elementosCarta.iterator();it.hasNext() && !encontrado;){
                            ele = it.next();
                            if (ele.getCodigoElemento() == codigoElemento.getInt(1))
                                encontrado = true;
                        }
                        // Asocio el elemento de la Carta al elemento pedido
                        eleCB.asocia(ele);
                        //Asocio el elementoColaBar al pedido
                        ped.asocia(eleCB);
                    }
                    else{
                        eleCC = new ElementoColaCocina(tablaElementosPedido.getInt(1),tablaElementosPedido.getInt(2),tablaElementosPedido.getString(3));
                        // Busco el objeto elemento de carta
                        encontrado = false;
                        for (it = elementosCarta.iterator();it.hasNext() && !encontrado;){
                            ele = it.next();
                            if (ele.getCodigoElemento() == codigoElemento.getInt(1))
                                encontrado = true;
                        }
                        // Asocio el elemento de la Carta al elemento pedido
                        eleCC.asocia(ele);
                        // Asocio el elementoColaCocina al pedido
                        ped.asocia(eleCC);
                    }
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(GestorBaseDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return ped;
    }

    public Pedido getSiguientePedidoCocina() {
        Pedido ped = null;
        try {
            Statement consulta = (Statement) this.Conexion.createStatement();
            // Obtengo los pedidos cuyo estado es distinto de Facturado y tiene elementosColaCocina en Cola
            ResultSet tablaPedidos = consulta.executeQuery("SELECT pedido_id, mesa_id, pedido.estado, fecha " +
                                                            "FROM pedido, tieneElemento, elementoPedido, elementoColaCocina " +
                                                            "WHERE pedido.estado <> 2 AND pedido_id = pedido_pedido_id " +
                                                            "AND tieneElemento.elementoPedido_elementoPedido_id = elementoPedido_id " +
                                                            "AND elementoPedido_id = elementoColaCocina.elementoPedido_elementoPedido_id " +
                                                            "AND elementoPedido.estado =0 GROUP BY pedido_id " +
                                                            "HAVING COUNT( elementoColaCocina.elementoPedido_elementoPedido_id ) >0");
            if (tablaPedidos.next()){
                HashSet<Elemento> elementosCarta = this.obtieneElementos(); // TODO Arreglar la consulta. Los objetos de los productos no son iguales.
                // Obtengo los elementoPedido asociados al pedido
                ped = new Pedido(tablaPedidos.getInt(2),tablaPedidos.getInt(1),tablaPedidos.getInt(3),tablaPedidos.getDate(4));
                Statement consulta2 = (Statement) this.Conexion.createStatement();
                ResultSet tablaElementosPedido = consulta2.executeQuery("SELECT elementoPedido_id,estado,comentario FROM tieneElemento,elementoPedido WHERE pedido_pedido_id = "+tablaPedidos.getInt(1)+" AND elementoPedido_elementoPedido_id = elementoPedido_id");
                ResultSet codigoElemento;
                ElementoColaBar eleCB;
                ElementoColaCocina eleCC;
                boolean encontrado;
                Iterator<Elemento> it;
                Elemento ele = null;
                Statement consulta3 = (Statement) this.Conexion.createStatement();
                while (tablaElementosPedido.next()){
                    //Obtengo SOLO EL CODIGO del elemento de la carta asociado al elementoPedido. Comprueba si es un plato
                    codigoElemento = consulta3.executeQuery("SELECT elementoPlato_elemento_elemento_id FROM asociaPlato WHERE elementoColaCocina_elementoPedido_elementoPedido_id = "+tablaElementosPedido.getInt(1));
                    if (!codigoElemento.next()){
                        // No es un plato es una bebida
                        codigoElemento = consulta3.executeQuery("SELECT elementoBebida_elemento_elemento_id FROM asociaBebida WHERE elementoColaBar_elementoPedido_elementoPedido_id = "+tablaElementosPedido.getInt(1));
                        codigoElemento.next();
                        eleCB = new ElementoColaBar(tablaElementosPedido.getInt(1),tablaElementosPedido.getInt(2),tablaElementosPedido.getString(3));
                        // Busco el objeto elemento de carta
                        encontrado = false;
                        for (it = elementosCarta.iterator();it.hasNext() && !encontrado;){
                            ele = it.next();
                            if (ele.getCodigoElemento() == codigoElemento.getInt(1))
                                encontrado = true;
                        }
                        // Asocio el elemento de la Carta al elemento pedido
                        eleCB.asocia(ele);
                        //Asocio el elementoColaBar al pedido
                        ped.asocia(eleCB);
                    }
                    else{
                        eleCC = new ElementoColaCocina(tablaElementosPedido.getInt(1),tablaElementosPedido.getInt(2),tablaElementosPedido.getString(3));
                        // Busco el objeto elemento de carta
                        encontrado = false;
                        for (it = elementosCarta.iterator();it.hasNext() && !encontrado;){
                            ele = it.next();
                            if (ele.getCodigoElemento() == codigoElemento.getInt(1))
                                encontrado = true;
                        }
                        // Asocio el elemento de la Carta al elemento pedido
                        eleCC.asocia(ele);
                        // Asocio el elementoColaCocina al pedido
                        ped.asocia(eleCC);
                    }
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(GestorBaseDatos.class.getName()).log(Level.SEVERE, null, ex);
        }

        return ped;
    }

    public int getCodigoPedido(){
        try {
            // Obtenemos el último id que se insertó
            java.sql.Statement consulta = this.Conexion.createStatement();
            ResultSet resultado = consulta.executeQuery("SELECT MAX(pedido_id) FROM pedido");
            resultado.next();
            int codPedido = resultado.getInt(1)+1;
            return codPedido;
        } catch (SQLException ex) {
            Logger.getLogger(GestorBaseDatos.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        }
    }

    public int getCodigoElementoPedido(){
        try {
            // Obtenemos el último id que se insertó
            java.sql.Statement consulta = this.Conexion.createStatement();
            ResultSet resultado = consulta.executeQuery("SELECT MAX(elementoPedido_id) FROM elementopedido");
            resultado.next();
            int codEP = resultado.getInt(1)+1;
            return codEP;
        } catch (SQLException ex) {
            Logger.getLogger(GestorBaseDatos.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        }
    }

    public boolean eliminaPedido(int codPedido){
        try {
            java.sql.PreparedStatement borrado;

            //Obtenemos el id de cada elementoPedido
            java.sql.Statement consulta = this.Conexion.createStatement();
            ResultSet resultado;
            resultado = consulta.executeQuery("SELECT elementoPedido_elementoPedido_id FROM tieneelemento WHERE pedido_pedido_id = "+codPedido);
            ArrayList<Integer> listaId = new ArrayList();
            
            while(resultado.next()){
                listaId.add(resultado.getInt(1));
            }

            //Borramos tienelemeneto
            borrado = this.Conexion.prepareStatement("DELETE tieneelemento FROM tieneelemento WHERE pedido_pedido_id = "+codPedido);
            borrado.executeUpdate();

            //Borramos asociaplato y asociabebida
            for(int i=0; i<listaId.size(); ++i){
                int codElementoPedido = listaId.get(i);

                borrado = this.Conexion.prepareStatement("DELETE asociaplato FROM asociaplato WHERE elementoColaCocina_elementoPedido_elementoPedido_id = "+codElementoPedido);
                borrado.executeUpdate();
                borrado = this.Conexion.prepareStatement("DELETE asociabebida FROM asociabebida WHERE elementoColaBar_elementoPedido_elementoPedido_id = "+codElementoPedido);
                borrado.executeUpdate();
            }

            resultado = consulta.executeQuery("SELECT elementoPedido_elementoPedido_id FROM tieneelemento WHERE pedido_pedido_id = "+codPedido);
            //Borramos elementocolacocina y elementocolabar
            for(int i=0; i<listaId.size(); ++i){
                int codElementoPedido = listaId.get(i);

                borrado = this.Conexion.prepareStatement("DELETE elementocolacocina FROM elementocolacocina WHERE elementoPedido_elementoPedido_id = "+codElementoPedido);
                borrado.executeUpdate();
                borrado = this.Conexion.prepareStatement("DELETE elementocolabar FROM elementocolabar WHERE elementoPedido_elementoPedido_id = "+codElementoPedido);
                borrado.executeUpdate();
            }

            resultado = consulta.executeQuery("SELECT elementoPedido_elementoPedido_id FROM tieneelemento WHERE pedido_pedido_id = "+codPedido);
            //Borramos elementopedido
            for(int i=0; i<listaId.size(); ++i){
                int codElementoPedido = listaId.get(i);

                borrado = this.Conexion.prepareStatement("DELETE elementopedido FROM elementopedido WHERE elementoPedido_id = "+codElementoPedido);
                borrado.executeUpdate();
            }

            //Borramos el pedido
            borrado = this.Conexion.prepareStatement("DELETE pedido FROM pedido WHERE pedido_id = "+codPedido);
            borrado.executeUpdate();
            
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(GestorBaseDatos.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }
    
    public ArrayList<Integer> getFacturasEnCola(){
        ArrayList<Integer> mesas = new ArrayList();
        try{
            java.sql.Statement consulta = this.Conexion.createStatement();
            ResultSet codigosMesas = consulta.executeQuery("SELECT DISTINCT( pedido.mesa_id ) FROM factura,facturaPedido,pedido WHERE factura_id = factura_factura_id AND pedido_pedido_id = pedido_id AND factura.estado=0");
            while (codigosMesas.next())
                mesas.add(codigosMesas.getInt(1));
        }catch (SQLException ex) {
            Logger.getLogger(GestorBaseDatos.class.getName()).log(Level.SEVERE, null, ex);
        }

        return mesas;
    }

    public ArrayList<Integer> getFacturasImprimidas() {
        ArrayList<Integer> mesas = new ArrayList();
        try{
            java.sql.Statement consulta = this.Conexion.createStatement();
            ResultSet codigosMesas = consulta.executeQuery("SELECT DISTINCT( pedido.mesa_id ) FROM factura,facturaPedido,pedido WHERE factura_id = factura_factura_id AND pedido_pedido_id = pedido_id AND factura.estado=1");
            while (codigosMesas.next())
                mesas.add(codigosMesas.getInt(1));
        }catch (SQLException ex) {
            Logger.getLogger(GestorBaseDatos.class.getName()).log(Level.SEVERE, null, ex);
        }

        return mesas;
    }

    public int getCodigoFactura(){
        try {
            // Obtenemos el último id que se insertó
            java.sql.Statement consulta = this.Conexion.createStatement();
            ResultSet resultado = consulta.executeQuery("SELECT MAX(factura_id) FROM factura");
            resultado.next();
            int codEP = resultado.getInt(1)+1;
            return codEP;
        } catch (SQLException ex) {
            Logger.getLogger(GestorBaseDatos.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        }
    }

    public Factura getFactNoPagada(int codMesa){
        Factura f = null;
        try {
            java.sql.Statement consultaFactura = this.Conexion.createStatement();
            ResultSet codigosMesas = consultaFactura.executeQuery("SELECT * FROM factura WHERE factura_id IN " + "(SELECT factura_factura_id FROM facturapedido WHERE pedido_pedido_id IN " + "(SELECT pedido_id FROM pedido WHERE mesa_id = " + codMesa + "))");
        } catch (SQLException ex) {
            Logger.getLogger(GestorBaseDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return f;
    }

    public boolean nuevaFactura(Factura f){
        try {
            //Actualizamos la tabla factura
            java.sql.PreparedStatement insercionFactura;
            insercionFactura = this.Conexion.prepareStatement("INSERT INTO factura(factura_id,estado,fecha) VALUES (?,?,?)");
            insercionFactura.setInt(1, f.getCodFactura());
            insercionFactura.setInt(2, f.getEstado());
            insercionFactura.setDate(3, new Date(f.getFecha().getTime()));
            insercionFactura.executeUpdate();

            //Actualizamos la tabla facturapedido
            ArrayList<Pedido> listaPedidos = f.getPedidos();
            Iterator it = listaPedidos.iterator();
            while(it.hasNext()){
                Pedido pedido = (Pedido) it.next();
                insercionFactura = this.Conexion.prepareStatement("INSERT INTO facturapedido(pedido_pedido_id,factura_factura_id) VALUES (?,?)");
                insercionFactura.setInt(1,pedido.getCodPedido());
                insercionFactura.setInt(2,f.getCodFactura());
                insercionFactura.executeUpdate();
            }
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(GestorBaseDatos.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public ArrayList<Pedido> obtienePedidosMesa(int codMesa){
        ArrayList<Pedido> pedidos = new ArrayList();
        try {
            Statement consultaPedidos = (Statement) this.Conexion.createStatement();
            ResultSet resultado = consultaPedidos.executeQuery(" select pedido_id,mesa_id,estado,fecha from pedido where mesa_id = " + codMesa);
            while (resultado.next()) {
                Pedido pedido = new Pedido(resultado.getInt(2), resultado.getInt(1), resultado.getInt(3), resultado.getDate(4));
                Statement consultaElemPed = (Statement) this.Conexion.createStatement();
                ResultSet resElemPed = consultaElemPed.executeQuery(" select elementoPedido_id,estado,comentario from elementopedido where elementoPedido_id IN " +
                        "(select elementoPedido_elementoPedido_id from tieneelemento where pedido_pedido_id = " + pedido.getCodPedido() + ")");
                while (resElemPed.next()) {
                    ElementoPedido elemPed = new ElementoPedido(resElemPed.getInt(1), resElemPed.getInt(2), resElemPed.getString(3));
                    ResultSet resElem;
                    ResultSet resProds;
                    Elemento elem;

                    //Comprobamos si es un PLATO
                    Statement consultaElem = (Statement) this.Conexion.createStatement();
                    resElem = consultaElem.executeQuery(" SELECT elemento_id, nombre, descripcion, disponible, foto, divi, divi_max, precio FROM elemento WHERE elemento_id IN " + "(SELECT elementoPlato_elemento_elemento_id FROM asociaplato WHERE elementoColaCocina_elementoPedido_elementoPedido_id = " + elemPed.getCodElementoPedido() + ")");

                    if(resElem.next()){
                        elem = new Elemento(resElem.getInt(1), resElem.getString(2), resElem.getString(3), resElem.getBoolean(4), Imagen.blobToImageIcon(new SerialBlob(resElem.getBlob(6)).getBytes(1, (int) resElem.getBlob(1).length())), resElem.getInt(6), resElem.getInt(7), resElem.getFloat(8));
                        ElementoPlato elemPlato = new ElementoPlato(elem,0);

                        //Asociamos los ingredientes
                        Statement consultaIngredientes = (Statement) this.Conexion.createStatement();
                        resProds = consultaIngredientes.executeQuery("SELECT producto_id, nombre, cantidad, maximo, minimo, foto FROM producto WHERE producto_id IN " + "( SELECT productoIngrediente_producto_producto_id FROM tieneingrediente WHERE elementoComida_elemento_elemento_id IN " + "(SELECT elemento_elemento_id FROM elementoplato WHERE elemento_elemento_id = " + resElem.getInt(1) + ")) ");
                        HashMap<Ingrediente,Float> temp = new HashMap();
                        while (resProds.next()) {
                            Ingrediente ingrediente = new Ingrediente(resProds.getInt(1), resProds.getString(2), resProds.getFloat(3), resProds.getFloat(4), resProds.getFloat(5), Imagen.blobToImageIcon(new SerialBlob(resProds.getBlob(6)).getBytes(1, (int) resProds.getBlob(1).length())));
                            temp.put(ingrediente, new Float(0));
                        }
                        ElementoPlato elemComida = new ElementoPlato(elem.getCodigoElemento(), temp, elem.getNombre(), elem.getDescripcion(), elem.getFoto(), 0, elem.getPrecio(), elem.getDivisionesMaximas());
                        ElementoColaCocina elemColaCocina = new ElementoColaCocina(elemPed.getCodElementoPedido(), elemPed.getEstado(), elemPed.getComentario());
                        elemColaCocina.asocia(elemComida);
                        pedido.asocia(elemColaCocina);
                    }else{ //Es una BEBIDA
                        resElem = consultaElem.executeQuery(" SELECT elemento_id, nombre, descripcion, disponible, foto, divi, divi_max, precio FROM elemento WHERE elemento_id IN " +
                                "(SELECT elementoBebida_elemento_elemento_id FROM asociabebida WHERE elementoColaBar_elementoPedido_elementoPedido_id = " + elemPed.getCodElementoPedido() + ")");
                        resElem.next();
                        elem = new Elemento(resElem.getInt(1), resElem.getString(2), resElem.getString(3), resElem.getBoolean(4), Imagen.blobToImageIcon(new SerialBlob(resElem.getBlob(6)).getBytes(1, (int) resElem.getBlob(1).length())), resElem.getInt(6), resElem.getInt(7), resElem.getFloat(8));
                        //Asociamos las bebidas
                        Statement consultaBebidas = (Statement) this.Conexion.createStatement();
                        resProds = consultaBebidas.executeQuery("SELECT producto_id, nombre, cantidad, maximo, minimo, foto FROM producto WHERE producto_id IN " + "( SELECT productoBebida_producto_producto_id FROM tienebebida WHERE elementoBebida_elemento_elemento_id IN " + "(SELECT elemento_elemento_id FROM elementobebida WHERE elemento_elemento_id = " + resElem.getInt(1) + ")) ");
                        HashMap<Bebida,Float> temp = new HashMap();
                        while (resProds.next()) {
                            Bebida bebida = new Bebida(resProds.getInt(1), resProds.getString(2), Imagen.blobToImageIcon(new SerialBlob(resProds.getBlob(6)).getBytes(1, (int) resProds.getBlob(1).length())), resProds.getInt(3), resProds.getInt(4), resProds.getInt(5));
                            temp.put(bebida, new Float(0));
                        }
                        ElementoBebida elemBebida = new ElementoBebida(elem.getCodigoElemento(),temp,elem.getNombre(), elem.getDescripcion(), elem.getFoto(), elem.getPrecio(),elem.getDivisiones());

                        ElementoColaBar elemColaBar = new ElementoColaBar(elemPed.getCodElementoPedido(), elemPed.getEstado(), elemPed.getComentario());
                        elemColaBar.asocia(elemBebida);
                        pedido.asocia(elemColaBar);
                    }
                }
                pedidos.add(pedido);
            }
        } catch (SQLException ex) {
            Logger.getLogger(GestorBaseDatos.class.getName()).log(Level.SEVERE, null, ex);
        }

        return pedidos;
    }

    public boolean eliminaFactura(int codMesa){
        try {
            //Obtenemos los pedidos de la mesa
            Statement consulta = (Statement) this.Conexion.createStatement();
            ResultSet resultado = consulta.executeQuery(" SELECT pedido_id FROM pedido WHERE mesa_id = "+ codMesa);

            //Para uno de los pedidos obtenemos su factura_id
            if(resultado.next()){
                int pedido_id = resultado.getInt(1);
                resultado = consulta.executeQuery("SELECT factura_factura_id FROM facturapedido WHERE pedido_pedido_id = "+pedido_id);
                //Si existe la factura para esa mesa, la borramos
                if(resultado.next()){
                    int codFactura = resultado.getInt(1);
                    java.sql.PreparedStatement borrado;
                    borrado = this.Conexion.prepareStatement("DELETE facturapedido FROM facturapedido WHERE factura_factura_id = "+codFactura);
                    borrado.executeUpdate();
                    borrado = this.Conexion.prepareStatement("DELETE factura FROM factura WHERE factura_id = "+codFactura);
                    borrado.executeUpdate();

                }
            }
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(GestorBaseDatos.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
}

