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
import utilidades.ConvertirFecha;
import com.mysql.jdbc.Statement;
import java.sql.Timestamp;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map.Entry;
import java.util.logging.Level;
import java.util.logging.Logger;
import utilidades.Pair;
import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.sql.rowset.serial.SerialBlob;
import javax.swing.ImageIcon;
import org.jfree.data.category.DefaultCategoryDataset;
import utilidades.Imagen;

/**
 *
 * @author Ángel Luis García, Carlos Salas, Daniel Guerrero y José David Dionisio
 */
public class GestorBaseDatos implements ICartaBD, IStockBD, IPedidosBD, IEstadisticasBD {

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
            p.actualizarCantidad(p.getCantidad()+cantidad);
            codigoProducto = p.getCodPro();
            java.sql.PreparedStatement actualizacion = null;
            try {
                actualizacion = this.Conexion.prepareStatement("update producto set cantidad=? where producto_id='" + codigoProducto + "'");
                actualizacion.setFloat(1, p.getCantidad());
                actualizacion.executeUpdate();//Actualizamos la cantidad en la base de datos
            } catch (SQLException ex) {
                Logger.getLogger(GestorBaseDatos.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    if(actualizacion != null) actualizacion.close();
                } catch (SQLException ex) {
                    Logger.getLogger(GestorBaseDatos.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

	}
    }

    public void deshabilitaElementos(HashSet<Elemento> listaElementos) {
        Iterator iterador = listaElementos.iterator();
        while(iterador.hasNext()){
            Elemento elemento = (Elemento)iterador.next();
            elemento.setDisponible(false);
            //Si hay que meter todo REVISAR
            java.sql.PreparedStatement actualizacion = null;
            try{
                actualizacion = this.Conexion.prepareStatement("UPDATE elemento SET disponible=? WHERE elemento_id='" + elemento.getCodigoElemento()+ "'");
                actualizacion.setInt(1, 0);
            } catch (SQLException ex) {
                Logger.getLogger(GestorBaseDatos.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    if(actualizacion != null) actualizacion.close();
                } catch (SQLException ex) {
                    Logger.getLogger(GestorBaseDatos.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public void eliminaElemento(Elemento elemento) {
        java.sql.PreparedStatement borrado = null;
        try {
            if (elemento instanceof ElementoBebida) {
                borrado = this.Conexion.prepareStatement("DELETE FROM elemento WHERE elemento_id=" + elemento.getCodigoElemento());
                borrado.executeUpdate();
                borrado = this.Conexion.prepareStatement("DELETE FROM elementoBebida WHERE elemento_elemento_id=" + elemento.getCodigoElemento());
                borrado.executeUpdate();
                borrado = this.Conexion.prepareStatement("DELETE FROM incluyeBebida WHERE elementoBebida_elemento_elemento_id=" + elemento.getCodigoElemento());
                borrado.executeUpdate();
                borrado = this.Conexion.prepareStatement("DELETE FROM tieneBebida WHERE elementoBebida_elemento_elemento_id=" + elemento.getCodigoElemento());
                borrado.executeUpdate();
            }
            else {
                borrado = this.Conexion.prepareStatement("DELETE FROM elemento WHERE elemento_id=" + elemento.getCodigoElemento());
                borrado.executeUpdate();
                borrado = this.Conexion.prepareStatement("DELETE FROM elementoPlato WHERE elemento_elemento_id=" + elemento.getCodigoElemento());
                borrado.executeUpdate();
                borrado = this.Conexion.prepareStatement("DELETE FROM incluyePlato WHERE elementoPlato_elemento_elemento_id=" + elemento.getCodigoElemento());
                borrado.executeUpdate();
                borrado = this.Conexion.prepareStatement("DELETE FROM tieneIngrediente WHERE elementoComida_elemento_elemento_id=" + elemento.getCodigoElemento());
                borrado.executeUpdate();
            }
        } catch (SQLException ex) {
            Logger.getLogger(GestorBaseDatos.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(borrado != null) borrado.close();
            } catch (SQLException ex) {
                Logger.getLogger(GestorBaseDatos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void habilitaElementos(HashSet<Elemento> listaElementos) {
        Iterator iterador = listaElementos.iterator();
        while(iterador.hasNext()){
            Elemento elemento = (Elemento)iterador.next();
            elemento.setDisponible(true);
            //Si hay que meter todo REVISAR
            java.sql.PreparedStatement actualizacion = null;
            try{
                actualizacion = this.Conexion.prepareStatement("UPDATE elemento SET disponible=? WHERE elemento_id='" + elemento.getCodigoElemento()+ "'");
                actualizacion.setInt(1, 1);
            } catch (SQLException ex) {
                Logger.getLogger(GestorBaseDatos.class.getName()).log(Level.SEVERE, null, ex);
            }finally {
                try {
                    if(actualizacion != null) actualizacion.close();
                } catch (SQLException ex) {
                    Logger.getLogger(GestorBaseDatos.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public void modificaElementoBebida(ElementoBebida elemento) {
        java.sql.PreparedStatement actualizacion = null;
        try {

            int codigoElemento = elemento.getCodigoElemento();
            
            actualizacion = this.Conexion.prepareStatement("UPDATE elemento SET nombre=?, descripcion=?, disponible=?, foto=?, divi=?, divi_max=?, precio=? where elemento_id='" + codigoElemento + "'");
            actualizacion.setString(1, elemento.getNombre());
            actualizacion.setString(2, elemento.getDescripcion());
            if (elemento.getDisponible()) {
                actualizacion.setInt(3, 1);
            } else {
                actualizacion.setInt(3, 0);
            }
            actualizacion.setBytes(4, Imagen.imageIconToByteArray(elemento.getFoto()));
            actualizacion.setInt(5, elemento.getDivisiones());
            actualizacion.setInt(6, elemento.getDivisionesMaximas());
            actualizacion.setFloat(7, elemento.getPrecio());

            actualizacion.executeUpdate();//Actualizamos el ElementoBebida
        } catch (SQLException ex) {
            Logger.getLogger(GestorBaseDatos.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            try {
                if(actualizacion != null) actualizacion.close();
            } catch (SQLException ex) {
                Logger.getLogger(GestorBaseDatos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void modificaElementoPlato(ElementoPlato elemento) {
        java.sql.PreparedStatement actualizacion = null;
        try {

            int codigoElemento = elemento.getCodigoElemento();

            actualizacion = this.Conexion.prepareStatement("UPDATE elemento SET nombre=?, descripcion=?, disponible=?, foto=?, divi=?, divi_max=?, precio=? where elemento_id='" + codigoElemento + "'");
            actualizacion.setString(1, elemento.getNombre());
            actualizacion.setString(2, elemento.getDescripcion());
            if (elemento.getDisponible()) {
                actualizacion.setInt(3, 1);
            } else {
                actualizacion.setInt(3, 0);
            }
            actualizacion.setBytes(4, Imagen.imageIconToByteArray(elemento.getFoto()));
            actualizacion.setInt(5, elemento.getDivisiones());
            actualizacion.setInt(6, elemento.getDivisionesMaximas());
            actualizacion.setFloat(7, elemento.getPrecio());

            actualizacion.executeUpdate();//Actualizamos el ElementoPlato

            actualizacion = this.Conexion.prepareStatement("UPDATE elementoPlato SET tiempo_elaboracion=? where elemento_elemento_id='" + codigoElemento + "'");
            actualizacion.setInt(1, elemento.getTiempoElaboracion());
            actualizacion.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(GestorBaseDatos.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            try {
                if(actualizacion != null) actualizacion.close();
            } catch (SQLException ex) {
                Logger.getLogger(GestorBaseDatos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void nuevoElementoBebida(ElementoBebida elemento, Seccion seccion) {
        ImageIcon defaultPhoto;
        boolean tieneSuficiente = true;
        java.sql.PreparedStatement inserccion = null;
        java.sql.PreparedStatement actualizacion = null;
        java.sql.PreparedStatement actualizacionDisponibilidad = null;
        try {
            // Insertamos el elemento
            inserccion = this.Conexion.prepareStatement("INSERT INTO elemento(nombre,descripcion,disponible,divi,divi_max,precio)"
                    + "VALUES (?,?,?,?,?,?)");
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
            actualizacion = this.Conexion.prepareStatement("UPDATE elemento SET foto=? WHERE elemento_id=" + id_elemento);
            if (elemento.getFoto() == null)
                defaultPhoto = new ImageIcon(getClass().getResource("/Imagenes/no_disponible.jpg"));
            else
                defaultPhoto = elemento.getFoto();
            actualizacion.setBytes(1, Imagen.imageIconToByteArray(defaultPhoto));
            actualizacion.executeUpdate();
            // Insertamos en elementoBebida
            inserccion = this.Conexion.prepareStatement("INSERT INTO elementoBebida(elemento_elemento_id) VALUES(?)");
            inserccion.setInt(1, id_elemento);
            inserccion.executeUpdate();
            // Para cada Bebida, sacamos su idBebida e insertamos junto con idElemento en tieneBebida

            Set set = elemento.getListaBebidas().entrySet();
            Iterator it = set.iterator();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                Producto bebida = (Producto) entry.getKey();
                Float cantidad = (Float) entry.getValue();
                inserccion = this.Conexion.prepareStatement("INSERT INTO tieneBebida(elementoBebida_elemento_elemento_id,productoBebida_producto_producto_id,cantidad) VALUES(?,?,?)");
                inserccion.setInt(1, id_elemento);
                inserccion.setInt(2, bebida.getCodPro());
                inserccion.setFloat(3, cantidad.floatValue());
                inserccion.executeUpdate();

                // Si hay menos cantidad de algun producto que el minimo posible
                if(bebida.getCantidad() < bebida.getMinimo()){
                    tieneSuficiente = false;
                }
            }
            // Insertamos el elemento en su sección
            inserccion = this.Conexion.prepareStatement("INSERT INTO incluyeBebida(seccionBebida_seccion_seccion_id,elementoBebida_elemento_elemento_id) VALUES (?, ?)");
            inserccion.setInt(1, seccion.getCodigoSeccion());
            inserccion.setInt(2, id_elemento);
            inserccion.executeUpdate();

            // Si hay suficiente de todos los productos
            if(tieneSuficiente){
                actualizacionDisponibilidad =
                        this.Conexion.prepareStatement("UPDATE elemento SET disponible=1 WHERE elemento_id=" + id_elemento);
                actualizacionDisponibilidad.executeUpdate();
            }
        } catch (SQLException ex) {
            Logger.getLogger(GestorBaseDatos.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            try {
                if(inserccion != null) inserccion.close();
                if(actualizacion != null) actualizacion.close();
                if(actualizacionDisponibilidad != null) actualizacionDisponibilidad.close();
            } catch (SQLException ex) {
                Logger.getLogger(GestorBaseDatos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void nuevoElementoPlato(ElementoPlato elemento, Seccion seccion) {
        ImageIcon defaultPhoto;
        boolean tieneSuficiente = true;
        java.sql.PreparedStatement inserccion = null;
        java.sql.PreparedStatement actualizacion = null;
        java.sql.PreparedStatement actualizacionDisponibilidad = null;
        try {
            // Insertamos el elemento
            inserccion = this.Conexion.prepareStatement("INSERT INTO elemento (nombre,descripcion,disponible,divi,divi_max,precio)"
                    + "VALUES (?,?,?,?,?,?)");
            inserccion.setString(1, elemento.getNombre());
            inserccion.setString(2, elemento.getDescripcion());
            inserccion.setInt(3, 0);// No disponible
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
            actualizacion = this.Conexion.prepareStatement("UPDATE elemento SET foto=? WHERE elemento_id=" + id_elemento);
                        if (elemento.getFoto() == null)
                defaultPhoto = new ImageIcon(getClass().getResource("/Imagenes/no_disponible.jpg"));
            else
                defaultPhoto = elemento.getFoto();
            actualizacion.setBytes(1, Imagen.imageIconToByteArray(defaultPhoto));
            actualizacion.executeUpdate();
            // Insertamos en elementoPlato
            inserccion = this.Conexion.prepareStatement("INSERT INTO elementoPlato(elemento_elemento_id, tiempo_elaboracion) VALUES(?, ?)");
            inserccion.setInt(1, id_elemento);
            inserccion.setInt(2, elemento.getTiempoElaboracion());
            inserccion.executeUpdate();
            // Para cada Ingrediente, sacamos su idIngrediente e insertamos junto con idElemento en tieneIngrediente

            Set set = elemento.getListaIngredientes().entrySet();
            Iterator it = set.iterator();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                Producto ingrediente = (Producto) entry.getKey();
                Float cantidad = (Float) entry.getValue();
                inserccion = this.Conexion.prepareStatement("INSERT INTO tieneIngrediente (elementoComida_elemento_elemento_id, productoIngrediente_producto_producto_id, cantidad)" +
                        " VALUES(?,?,?)");
                inserccion.setInt(1, id_elemento);
                inserccion.setInt(2, ingrediente.getCodPro());
                inserccion.setFloat(3, cantidad.floatValue());
                inserccion.executeUpdate();

                // Si hay menos cantidad de algun producto que el minimo posible
                if(ingrediente.getCantidad() < ingrediente.getMinimo()){
                    tieneSuficiente = false;
                }
            }
            // Insertamos el elemento en su sección
            inserccion = this.Conexion.prepareStatement("INSERT INTO incluyePlato (seccionComida_seccion_seccion_id, elementoPlato_elemento_elemento_id) VALUES (?,?)");
            inserccion.setInt(1, seccion.getCodigoSeccion());
            inserccion.setInt(2, id_elemento);
            inserccion.executeUpdate();

            // Si hay suficiente de todos los productos
            if(tieneSuficiente){
                actualizacionDisponibilidad =
                        this.Conexion.prepareStatement("UPDATE elemento SET disponible=1 WHERE elemento_id=" + id_elemento);
                actualizacionDisponibilidad.executeUpdate();
            }
        } catch (SQLException ex) {
            Logger.getLogger(GestorBaseDatos.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            try {
                if(inserccion != null) inserccion.close();
                if(actualizacion != null) actualizacion.close();
                if(actualizacionDisponibilidad != null) actualizacionDisponibilidad.close();
            } catch (SQLException ex) {
                Logger.getLogger(GestorBaseDatos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public HashSet<Elemento> obtieneElementos() {
        HashSet<Elemento> listaElementos = new HashSet<Elemento>();
        HashMap<Bebida, Float> listaBebida = null;
        HashMap<Ingrediente, Float> listaIngredientes = null;
        java.sql.Statement consulta = null;
        java.sql.PreparedStatement consulta2 = null;
        ResultSet datosIngredientes = null;
        ResultSet datosBebidas = null;
        try {
            // Obtenemos todas las bebidas
            consulta = this.Conexion.createStatement();
            ResultSet datosElementosBebida = consulta.executeQuery("SELECT elemento.elemento_id, elemento.nombre, elemento.descripcion, elemento.disponible, elemento.foto, elemento.divi, elemento.divi_max, elemento.precio FROM elemento, elementoBebida WHERE elemento.elemento_id = elementoBebida.elemento_elemento_id");
            while (datosElementosBebida.next()) {
                listaBebida = new HashMap<Bebida, Float>();
                consulta2 = this.Conexion.prepareStatement("SELECT producto.foto, producto.nombre, producto.minimo, producto.maximo, producto.cantidad, producto.producto_id, tieneBebida.cantidad FROM tieneBebida, producto WHERE "
                        + "tieneBebida.productoBebida_producto_producto_id"
                        + " = producto.producto_id AND tieneBebida.elementoBebida_elemento_elemento_id =" + datosElementosBebida.getInt(1));
                datosBebidas = consulta2.executeQuery();

                boolean disponible = true;
                while (datosBebidas.next()) {
                    Bebida bebida = new Bebida(datosBebidas.getInt(6), datosBebidas.getString(2), Imagen.blobToImageIcon(new SerialBlob(datosBebidas.getBlob(1)).getBytes(1, (int) datosBebidas.getBlob(1).length())), datosBebidas.getFloat(3), datosBebidas.getFloat(4), datosBebidas.getFloat(5));
                    Float cantidad = new Float(datosBebidas.getFloat(7));
                    listaBebida.put(bebida, cantidad);
                    // Si la cantidad es menor que el minimo
                    if( datosBebidas.getFloat(5) < datosBebidas.getFloat(3)){
                        disponible = false;
                    }
                }
                // Para obtener la imagen, primero sacamos el blob y con SerialBlob lo pasamos a byte[]
                ElementoBebida elemento = new ElementoBebida(datosElementosBebida.getInt(1), listaBebida, datosElementosBebida.getString(2), datosElementosBebida.getString(3), disponible, Imagen.blobToImageIcon(new SerialBlob(datosElementosBebida.getBlob(5)).getBytes(1, (int) datosElementosBebida.getBlob(5).length())), datosElementosBebida.getInt(8), datosElementosBebida.getInt(7));
                listaElementos.add(elemento);
            }

            // Obtenemos todos los platos
            consulta = this.Conexion.createStatement();
            ResultSet datosElementosPlato = consulta.executeQuery("SELECT elemento.elemento_id, elemento.nombre, elemento.descripcion, elemento.disponible, elemento.foto, elemento.divi, elemento.divi_max, elemento.precio, elementoPlato.tiempo_elaboracion FROM elemento, elementoPlato WHERE elemento.elemento_id = elementoPlato.elemento_elemento_id");
            while (datosElementosPlato.next()) {
                listaIngredientes = new HashMap<Ingrediente, Float>();
                consulta2 = this.Conexion.prepareStatement("SELECT producto.foto, producto.nombre, producto.minimo, producto.maximo, producto.cantidad, producto.producto_id, tieneIngrediente.cantidad FROM tieneIngrediente, producto WHERE "
                        + "tieneIngrediente.productoIngrediente_producto_producto_id"
                        + " = producto.producto_id AND tieneIngrediente.elementoComida_elemento_elemento_id =" + datosElementosPlato.getInt(1));
                datosIngredientes = consulta2.executeQuery();
                
                boolean disponible = true;
                while (datosIngredientes.next()) {
                    Ingrediente ingrediente = new Ingrediente(datosIngredientes.getInt(6), datosIngredientes.getString(2), datosIngredientes.getFloat(5), datosIngredientes.getFloat(3), datosIngredientes.getFloat(4), Imagen.blobToImageIcon(new SerialBlob(datosIngredientes.getBlob(1)).getBytes(1, (int) datosIngredientes.getBlob(1).length())));
                    Float cantidad = new Float(datosIngredientes.getFloat(7));
                    listaIngredientes.put(ingrediente, cantidad);
                    // Si la cantidad es menor que el minimo
                    if(datosIngredientes.getFloat(5) < datosIngredientes.getFloat(3)){
                        disponible = false;
                    }
                }
                // Para obtener la imagen, primero sacamos el blob y con SerialBlob lo pasamos a byte[]
                ElementoPlato elemento = new ElementoPlato(datosElementosPlato.getInt(1), listaIngredientes, datosElementosPlato.getString(2), datosElementosPlato.getString(3), disponible, Imagen.blobToImageIcon(new SerialBlob(datosElementosPlato.getBlob(5)).getBytes(1, (int) datosElementosPlato.getBlob(5).length())), datosElementosPlato.getInt(9), datosElementosPlato.getInt(8), datosElementosPlato.getInt(7));
                listaElementos.add(elemento);
            }
        } catch (SQLException ex) {
            Logger.getLogger(GestorBaseDatos.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            try {
                if(consulta != null) consulta.close();
                if(consulta2 != null) consulta2.close();
                if(datosBebidas != null) datosBebidas.close();
                if(datosIngredientes != null) datosIngredientes.close();
            } catch (SQLException ex) {
                Logger.getLogger(GestorBaseDatos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return listaElementos;
    }

    public HashSet<Elemento> obtieneElementosDeSeccion(Seccion seccion) {
        HashSet<Elemento> listaElementos = new HashSet<Elemento>();
        HashMap<Bebida, Float> listaBebida = null;
        HashMap<Ingrediente, Float> listaIngredientes = null;
        java.sql.Statement consulta = null;
        java.sql.PreparedStatement consulta2 = null;
        ResultSet datosIngredientes = null;
        ResultSet datosElementosPlato = null;
        ResultSet datosBebidas = null;
        ResultSet datosElementosBebida = null;
        try {
            if (seccion instanceof SeccionBebida) {
                // Si estamos en una SeccionBebida sacamos todos los elementos de la seccion
                consulta = this.Conexion.createStatement();
                datosElementosBebida = consulta.executeQuery("SELECT elemento.elemento_id, elemento.nombre, elemento.descripcion, elemento.disponible, elemento.foto, elemento.divi, elemento.divi_max, elemento.precio FROM elemento, incluyeBebida WHERE elemento.elemento_id = incluyeBebida.elementoBebida_elemento_elemento_id AND incluyeBebida.seccionBebida_seccion_seccion_id ="+seccion.getCodigoSeccion());
                while (datosElementosBebida.next()) {
                    // Obtenemos todas las bebidas
                    listaBebida = new HashMap<Bebida, Float>();
                    consulta2 = this.Conexion.prepareStatement("SELECT producto.foto, producto.nombre, producto.minimo, producto.maximo, producto.cantidad, producto.producto_id, tieneBebida.cantidad FROM tieneBebida, producto WHERE "
                            + "tieneBebida.productoBebida_producto_producto_id"
                            + " = producto.producto_id AND tieneBebida.elementoBebida_elemento_elemento_id =" + datosElementosBebida.getInt(1));
                    datosBebidas = consulta2.executeQuery();
                    boolean disponible = true;
                    while (datosBebidas.next()) {
                        Bebida bebida = new Bebida(datosBebidas.getInt(6), datosBebidas.getString(2), Imagen.blobToImageIcon(new SerialBlob(datosBebidas.getBlob(1)).getBytes(1, (int) datosBebidas.getBlob(1).length())), datosBebidas.getFloat(3), datosBebidas.getFloat(4), datosBebidas.getFloat(5));
                        Float cantidad = new Float(datosBebidas.getFloat(7));
                        listaBebida.put(bebida, cantidad);

                        // Si la cantidad es menor que el minimo
                        if( datosBebidas.getFloat(5) < datosBebidas.getFloat(3)){
                            disponible = false;
                        }
                    }
                    // Para obtener la imagen, primero sacamos el blob y con SerialBlob lo pasamos a byte[]
                    ElementoBebida elemento = new ElementoBebida(datosElementosBebida.getInt(1), listaBebida, datosElementosBebida.getString(2), datosElementosBebida.getString(3), disponible, Imagen.blobToImageIcon(new SerialBlob(datosElementosBebida.getBlob(5)).getBytes(1, (int) datosElementosBebida.getBlob(5).length())), datosElementosBebida.getInt(8), datosElementosBebida.getInt(7));
                    listaElementos.add(elemento);
                }
            }
            else if (seccion instanceof SeccionComida) {
            // Si estamos en una SeccionComida sacamos todos los elementos de la seccion
                consulta = this.Conexion.createStatement();
                datosElementosPlato = consulta.executeQuery("SELECT elemento.elemento_id, elemento.nombre, elemento.descripcion, elemento.disponible, elemento.foto, elemento.divi, elemento.divi_max, elemento.precio, elementoPlato.tiempo_elaboracion FROM elemento, elementoPlato , incluyePlato WHERE elemento.elemento_id = incluyePlato.elementoPlato_elemento_elemento_id AND " +
                        "elemento.elemento_id = elementoPlato.elemento_elemento_id AND incluyePlato.seccionComida_seccion_seccion_id ="+seccion.getCodigoSeccion());
                // Obtenemos todos los ingredientes
                while (datosElementosPlato.next()) {
                    listaIngredientes = new HashMap<Ingrediente, Float>();
                    consulta2 = this.Conexion.prepareStatement("SELECT producto.foto, producto.nombre, producto.minimo, producto.maximo, producto.cantidad, producto.producto_id, tieneIngrediente.cantidad FROM tieneIngrediente, producto WHERE "
                            + "tieneIngrediente.productoIngrediente_producto_producto_id"
                            + " = producto.producto_id AND tieneIngrediente.elementoComida_elemento_elemento_id =" + datosElementosPlato.getInt(1));
                    datosIngredientes = consulta2.executeQuery();
                    boolean disponible = true;
                    while (datosIngredientes.next()) {
                        Ingrediente ingrediente = new Ingrediente(datosIngredientes.getInt(6), datosIngredientes.getString(2), datosIngredientes.getFloat(5), datosIngredientes.getFloat(3), datosIngredientes.getFloat(4), Imagen.blobToImageIcon(new SerialBlob(datosIngredientes.getBlob(1)).getBytes(1, (int) datosIngredientes.getBlob(1).length())));
                        Float cantidad = new Float(datosIngredientes.getFloat(7));
                        listaIngredientes.put(ingrediente, cantidad);

                        // Si la cantidad es menor que el minimo
                        if(datosIngredientes.getFloat(5) < datosIngredientes.getFloat(3)){
                            disponible = false;
                        }
                    }
                    // Para obtener la imagen, primero sacamos el blob y con SerialBlob lo pasamos a byte[]
                    ElementoPlato elemento = new ElementoPlato(datosElementosPlato.getInt(1), listaIngredientes, datosElementosPlato.getString(2), datosElementosPlato.getString(3), disponible, Imagen.blobToImageIcon(new SerialBlob(datosElementosPlato.getBlob(5)).getBytes(1, (int) datosElementosPlato.getBlob(5).length())), datosElementosPlato.getInt(9), datosElementosPlato.getInt(8), datosElementosPlato.getInt(7));
                    listaElementos.add(elemento);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(GestorBaseDatos.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            try {
                if(consulta != null) consulta.close();
                if(consulta2 != null) consulta2.close();
                if(datosIngredientes != null) datosIngredientes.close();
                if(datosElementosPlato != null) datosElementosPlato.close();
                if(datosBebidas != null) datosBebidas.close();
                if(datosElementosBebida != null) datosElementosBebida.close();
            } catch (SQLException ex) {
                Logger.getLogger(GestorBaseDatos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return listaElementos;
    }

    public HashSet<Elemento> obtieneElementosConProducto(Producto producto) {
        HashSet<Elemento> listaElementos = new HashSet<Elemento>();
        HashMap<Bebida, Float> listaBebida = null;
        HashMap<Ingrediente, Float> listaIngredientes = null;
        java.sql.PreparedStatement consulta = null;
        java.sql.PreparedStatement consulta2 = null;
        ResultSet datosIngredientes = null;
        ResultSet datosElementosPlato = null;
        ResultSet datosBebidas = null;
        ResultSet datosElementosBebida = null;
        try {
            if (producto instanceof Bebida) {
                // Obtenemos los datos del elementoBebida con ese producto
                consulta = this.Conexion.prepareStatement("SELECT elemento.elemento_id, elemento.nombre, elemento.descripcion, elemento.disponible, elemento.foto, elemento.divi, elemento.divi_max, elemento.precio FROM elemento, tieneBebida WHERE elemento.elemento_id = tieneBebida.elementoBebida_elemento_elemento_id AND productoBebida_producto_producto_id =" + producto.getCodPro());
                datosElementosBebida = consulta.executeQuery();
                while (datosElementosBebida.next()) {
                    listaBebida = new HashMap<Bebida, Float>();
                    consulta2 = this.Conexion.prepareStatement("SELECT producto.foto, producto.nombre, producto.minimo, producto.maximo, producto.cantidad, producto.producto_id, tieneBebida.cantidad FROM tieneBebida, producto WHERE "
                            + "tieneBebida.productoBebida_producto_producto_id"
                            + " = producto.producto_id AND tieneBebida.elementoBebida_elemento_elemento_id =" + datosElementosBebida.getInt(1));
                    datosBebidas = consulta2.executeQuery();
                    boolean disponible = true;
                    while (datosBebidas.next()) {
                        Bebida bebida = new Bebida(datosBebidas.getInt(6), datosBebidas.getString(2), Imagen.blobToImageIcon(new SerialBlob(datosBebidas.getBlob(1)).getBytes(1, (int) datosBebidas.getBlob(1).length())), datosBebidas.getFloat(3), datosBebidas.getFloat(4), datosBebidas.getFloat(5));
                        Float cantidad = new Float(datosBebidas.getFloat(7));
                        listaBebida.put(bebida, cantidad);

                        // Si la cantidad es menor que el minimo
                        if( datosBebidas.getFloat(5) < datosBebidas.getFloat(3)){
                            disponible = false;
                        }
                    }
                    // Para obtener la imagen, primero sacamos el blob y con SerialBlob lo pasamos a byte[]
                    ElementoBebida elemento = new ElementoBebida(datosElementosBebida.getInt(1), listaBebida, datosElementosBebida.getString(2), datosElementosBebida.getString(3), disponible, Imagen.blobToImageIcon(new SerialBlob(datosElementosBebida.getBlob(5)).getBytes(1, (int) datosElementosBebida.getBlob(5).length())), datosElementosBebida.getInt(8), datosElementosBebida.getInt(7));
                    listaElementos.add(elemento);
                }
            } else {
                // Obtenemos los datos del elementoPlato con ese producto
                consulta = this.Conexion.prepareStatement("SELECT elemento.elemento_id, elemento.nombre, elemento.descripcion, elemento.disponible, elemento.foto, elemento.divi, elemento.divi_max, elemento.precio, elementoPlato.tiempo_elaboracion FROM elemento, elementoPlato, tieneIngrediente "
                        + "WHERE elemento.elemento_id = elementoPlato.elemento_elemento_id AND elemento.elemento_id = elementoComida_elemento_elemento_id AND productoIngrediente_producto_producto_id = " + producto.getCodPro());
                datosElementosPlato = consulta.executeQuery();
                while (datosElementosPlato.next()) {
                    listaIngredientes = new HashMap<Ingrediente, Float>();
                    consulta2 = this.Conexion.prepareStatement("SELECT producto.foto, producto.nombre, producto.minimo, producto.maximo, producto.cantidad, producto.producto_id, tieneIngrediente.cantidad FROM tieneIngrediente, producto WHERE "
                            + "tieneIngrediente.productoIngrediente_producto_producto_id"
                            + " = producto.producto_id AND tieneIngrediente.elementoComida_elemento_elemento_id =" + datosElementosPlato.getInt(1));
                    datosIngredientes = consulta2.executeQuery();

                    boolean disponible = true;
                    while (datosIngredientes.next()) {
                        Ingrediente ingrediente = new Ingrediente(datosIngredientes.getInt(6), datosIngredientes.getString(2), datosIngredientes.getFloat(5), datosIngredientes.getFloat(3), datosIngredientes.getFloat(4), Imagen.blobToImageIcon(new SerialBlob(datosIngredientes.getBlob(1)).getBytes(1, (int) datosIngredientes.getBlob(1).length())));
                        Float cantidad = new Float(datosIngredientes.getFloat(7));
                        listaIngredientes.put(ingrediente, cantidad);
                        
                        // Si la cantidad es menor que el minimo
                        if(datosIngredientes.getFloat(5) < datosIngredientes.getFloat(3)){
                            disponible = false;
                        }
                    }
                    // Para obtener la imagen, primero sacamos el blob y con SerialBlob lo pasamos a byte[]
                    ElementoPlato elemento = new ElementoPlato(datosElementosPlato.getInt(1), listaIngredientes, datosElementosPlato.getString(2), datosElementosPlato.getString(3), disponible, Imagen.blobToImageIcon(new SerialBlob(datosElementosPlato.getBlob(5)).getBytes(1, (int) datosElementosPlato.getBlob(5).length())), datosElementosPlato.getInt(9), datosElementosPlato.getInt(8), datosElementosPlato.getInt(7));
                    listaElementos.add(elemento);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(GestorBaseDatos.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            try {
                if(consulta != null) consulta.close();
                if(consulta2 != null) consulta2.close();
                if(datosIngredientes != null) datosIngredientes.close();
                if(datosElementosPlato != null) datosElementosPlato.close();
                if(datosBebidas != null) datosBebidas.close();
                if(datosElementosBebida != null) datosElementosBebida.close();
            } catch (SQLException ex) {
                Logger.getLogger(GestorBaseDatos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return listaElementos;
    }

    public HashSet<Elemento> obtieneElementosInvalidados() {
        HashSet<Elemento> elementosInvalidos = new HashSet<Elemento>();
        HashSet<Producto> productos = new HashSet<Producto>();
        java.sql.PreparedStatement consultaElementos = null, consultaProductos = null;
        ElementoBebida elementoBebida = null;
        ElementoPlato elementoPlato = null;
        ResultSet rsElementos = null, rsProductos = null;

        //1.- Obtengo la lista con todos los productos.
        //2.- Obtengo todos los elementos no disponibles.
        //3.- Para cada elemento obtengo los codigos de los productos q necesita y la cantidad de cada uno de ellos.
        //4.- Compruebo el codigo de los productos de los elementos con el codigo de los productos de la lista que acabo de crear.
        //5.- Si el codigo coincide meto el producto y la cantidad en la lista de productos del elemento.
        //6.- Devuelvo la lista de elementos.

        try {
            // 1.- Obtengo la lista con todos los productos, se obtiene aqui para despues ir introducciendo el producto
            // en el contenedor del elemento correspondiente, de esta forma los elementos comparten los mismos productos.
            // Primero obtengo las bebidas// luego los ingredientes
            consultaProductos = this.Conexion.prepareStatement("SELECT producto.producto_id, producto.nombre, producto.cantidad, producto.maximo, producto.minimo, producto.foto FROM producto, productoBebida WHERE producto.producto_id = productoBebida.producto_producto_id");
            rsProductos = consultaProductos.executeQuery();
            while (rsProductos.next()) {
                Bebida bebida = new Bebida(rsProductos.getInt(1), rsProductos.getString(2), Imagen.blobToImageIcon(new SerialBlob(rsProductos.getBlob(6)).getBytes(1, (int) rsProductos.getBlob(6).length())), rsProductos.getFloat(5), rsProductos.getFloat(4), rsProductos.getFloat(3));
                productos.add(bebida);
            }
            // luego los ingredientes
            consultaProductos = this.Conexion.prepareStatement("SELECT producto.producto_id, producto.nombre, producto.cantidad, producto.maximo, producto.minimo, producto.foto FROM producto, productoIngrediente WHERE producto.producto_id = productoIngrediente.producto_producto_id");
            rsProductos = consultaProductos.executeQuery();
            while (rsProductos.next()) {
                Ingrediente ingrediente = new Ingrediente(rsProductos.getInt(1), rsProductos.getString(2), rsProductos.getFloat(3), rsProductos.getFloat(4), rsProductos.getFloat(5), Imagen.blobToImageIcon(new SerialBlob(rsProductos.getBlob(6)).getBytes(1, (int) rsProductos.getBlob(6).length())) );
                productos.add(ingrediente);
            }

            //2.- Obtengo todos los elementos no disponibles
            //2.a.- Primero obtengo las bebidas no disponibles
            consultaElementos = this.Conexion.prepareStatement("SELECT elemento_id, nombre, descripcion, disponible, foto, divi, divi_max, precio FROM elemento, elementoBebida WHERE elemento.elemento_id = elementoBebida.elemento_elemento_id AND elemento.disponible = 0");
            rsElementos = consultaElementos.executeQuery();
            while (rsElementos.next()) {
                //3.a.- Para cada elemento obtengo los codigos de los productos que necesita
                HashMap<Bebida, Float> listaProductosElemento = new HashMap<Bebida, Float>();
                consultaProductos = this.Conexion.prepareStatement("SELECT producto.producto_id, tieneBebida.cantidad FROM tieneBebida, producto WHERE "
                        + "tieneBebida.productoBebida_producto_producto_id = producto.producto_id AND tieneBebida.elementoBebida_elemento_elemento_id =" + rsElementos.getInt(1));
                rsProductos = consultaProductos.executeQuery();
                while (rsProductos.next()) {
                    //4.a.- Compruebo el codigo de los productos de los elementos con el código de los productos de la lista que acabo de crear
                    Iterator<Producto> iterador = productos.iterator();
                    while (iterador.hasNext()) {
                        Producto bebida = (Producto) iterador.next();
                        if (bebida.getCodPro() == rsProductos.getInt(1)) {
                            //5.a.- Si el codigo coincide meto el producto y la cantidad en la lista de productos del elemento.
                            listaProductosElemento.put((Bebida) bebida, new Float(rsProductos.getFloat(2)));
                        }
                    }
                }

                elementoBebida = new ElementoBebida(rsElementos.getInt(1), listaProductosElemento, rsElementos.getString(2), rsElementos.getString(3), false, Imagen.blobToImageIcon(new SerialBlob(rsElementos.getBlob(5)).getBytes(1, (int) rsElementos.getBlob(5).length())), rsElementos.getFloat(8), rsElementos.getInt(7));
                elementoBebida.setDisponible(false);
                elementoBebida.setDivisiones(rsElementos.getInt(6));
            }
            //2.a.- ElementoBebida No Disponible
            elementosInvalidos.add(elementoBebida);

            //2.- Obtengo todos los elementos no disponibles
            //2.b.- Continuo con los platos no disponibles
            consultaElementos = this.Conexion.prepareStatement("SELECT elemento_id, nombre, descripcion, disponible, foto, divi, divi_max, precio, tiempo_elaboracion FROM elemento, elementoPlato WHERE elemento.elemento_id = elementoPlato.elemento_elemento_id AND elemento.disponible = 0");
            rsElementos = consultaElementos.executeQuery();
            while (rsElementos.next()) {
                //3.b.- Para cada elemento obtengo los codigos de los productos que necesita
                HashMap<Ingrediente, Float> listaProductosElemento = new HashMap<Ingrediente, Float>();
                consultaProductos = this.Conexion.prepareStatement("SELECT producto.producto_id, tieneIngrediente.cantidad FROM tieneIngrediente, producto WHERE "
                        + "tieneIngrediente.productoIngrediente_producto_producto_id = producto.producto_id AND tieneIngrediente.elementoComida_elemento_elemento_id =" + rsElementos.getInt(1));
                rsProductos = consultaProductos.executeQuery();
                while (rsProductos.next()) {
                    //4.b.- Compruebo el codigo de los productos de los elementos con el código de los productos de la lista que acabo de crear
                    Iterator<Producto> iterador = productos.iterator();
                    while (iterador.hasNext()) {
                        Producto ingrediente = (Producto) iterador.next();
                        if (ingrediente.getCodPro() == rsProductos.getInt(1)) {
                            //5.b.- Si el codigo coincide meto el producto y la cantidad en la lista de productos del elemento.
                            listaProductosElemento.put((Ingrediente)ingrediente, new Float(rsProductos.getFloat(2)));
                        }
                    }
                }
                elementoPlato = new ElementoPlato(rsElementos.getInt(1), listaProductosElemento, rsElementos.getString(2), rsElementos.getString(3), false, Imagen.blobToImageIcon(new SerialBlob(rsElementos.getBlob(5)).getBytes(1, (int) rsElementos.getBlob(5).length())), rsElementos.getInt(9), rsElementos.getFloat(8), rsElementos.getInt(7));
                elementoPlato.setDisponible(false);
                elementoPlato.setDivisiones(rsElementos.getInt(6));
            }
            //2.b.- ElementoPlato No Disponible
            elementosInvalidos.add(elementoPlato);

        } catch (SQLException ex) {
            Logger.getLogger(GestorBaseDatos.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            try {
                if(consultaElementos != null) consultaElementos.close();
                if(consultaProductos != null) consultaProductos.close();
                if(rsElementos != null) rsElementos.close();
                if(rsProductos != null) rsProductos.close();
            } catch (SQLException ex) {
                Logger.getLogger(GestorBaseDatos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        //6.- Devuelvo la lista de elementos.
        return elementosInvalidos;
    }

    public HashSet<Seccion> obtieneSecciones() {
        HashSet<Seccion> listaSecciones = new HashSet<Seccion>();
        HashSet<ElementoBebida> listaElementosB;
        HashSet<ElementoPlato> listaElementosP;
        HashMap<Bebida, Float> listaBebida = null;
        HashMap<Ingrediente, Float> listaIngredientes = null;
        java.sql.Statement consulta = null;
        java.sql.Statement consultaA = null;
        java.sql.PreparedStatement consulta2 = null;
        ResultSet datosCarta = null;
        ResultSet datosSeccion = null;
        ResultSet datosElementosBebida = null;
        ResultSet datosIngredientes = null;
        try {
            // Construimos el objeto Carta necesario para crear una Seccion
            consulta = (Statement) this.Conexion.createStatement();
            datosCarta = consulta.executeQuery("SELECT ultima_modificacion FROM carta");
            datosCarta.next();
            Carta carta = new Carta((Timestamp) datosCarta.getTimestamp(1));
            // Obtenemos todas las secciones de la carta, primero de comida y luego de bebida
            consulta = (Statement) this.Conexion.createStatement();
            // Para cada seccion obtenida, creamos su objeto e insertamos en el HashSet
            datosSeccion = consulta.executeQuery("SELECT seccion.seccion_id, seccion.nombre FROM seccion, seccionBebida WHERE seccion.seccion_id = seccionBebida.seccion_seccion_id");
            while (datosSeccion.next()) {
                listaElementosB = new HashSet<ElementoBebida>();
                // Si estamos en una SeccionBebida sacamos todos los elementos de la seccion
                consultaA = this.Conexion.createStatement();
                datosElementosBebida = consultaA.executeQuery("SELECT elemento.elemento_id, elemento.nombre, elemento.descripcion, elemento.disponible, elemento.foto, elemento.divi, elemento.divi_max, elemento.precio FROM elemento, incluyeBebida WHERE elemento.elemento_id = incluyeBebida.elementoBebida_elemento_elemento_id AND incluyeBebida.seccionBebida_seccion_seccion_id ="+datosSeccion.getInt(1));
                while (datosElementosBebida.next()) {
                    // Obtenemos todas las bebidas
                    listaBebida = new HashMap<Bebida, Float>();
                    consulta2 = this.Conexion.prepareStatement("SELECT producto.foto, producto.nombre, producto.minimo, producto.maximo, producto.cantidad, producto.producto_id, tieneBebida.cantidad FROM tieneBebida, producto WHERE "
                            + "tieneBebida.productoBebida_producto_producto_id"
                            + " = producto.producto_id AND tieneBebida.elementoBebida_elemento_elemento_id =" + datosElementosBebida.getInt(1));
                    ResultSet datosBebidas = consulta2.executeQuery();

                    boolean disponible = true;
                    while (datosBebidas.next()) {
                        Bebida bebida = new Bebida(datosBebidas.getInt(6), datosBebidas.getString(2), Imagen.blobToImageIcon(new SerialBlob(datosBebidas.getBlob(1)).getBytes(1, (int) datosBebidas.getBlob(1).length())), datosBebidas.getFloat(3), datosBebidas.getFloat(4), datosBebidas.getFloat(5));
                        Float cantidad = new Float(datosBebidas.getFloat(7));
                        listaBebida.put(bebida, cantidad);

                        // Si la cantidad es menor que el minimo
                        if( datosBebidas.getFloat(5) < datosBebidas.getFloat(3)){
                            disponible = false;
                        }
                    }
                    // Para obtener la imagen, primero sacamos el blob y con SerialBlob lo pasamos a byte[]
                    ElementoBebida elemento = new ElementoBebida(datosElementosBebida.getInt(1), listaBebida, datosElementosBebida.getString(2), datosElementosBebida.getString(3), disponible, Imagen.blobToImageIcon(new SerialBlob(datosElementosBebida.getBlob(5)).getBytes(1, (int) datosElementosBebida.getBlob(5).length())), datosElementosBebida.getInt(8), datosElementosBebida.getInt(7));
                    listaElementosB.add(elemento);
                }
                SeccionBebida seccion = new SeccionBebida(datosSeccion.getInt(1), datosSeccion.getString(2), carta, listaElementosB);
                listaSecciones.add(seccion);
                consultaA.close();
            }
            consulta.close();
            consulta = (Statement) this.Conexion.createStatement();
            // Para cada seccion obtenida, creamos su objeto e insertamos en el HashSet
            datosSeccion = consulta.executeQuery("SELECT seccion.seccion_id, seccion.nombre FROM seccion, seccionComida WHERE seccion.seccion_id = seccionComida.seccion_seccion_id");
            while (datosSeccion.next()) {
                // Si estamos en una SeccionComida sacamos todos los elementos de la seccion
                listaElementosP = new HashSet<ElementoPlato>();
                consultaA = this.Conexion.createStatement();
                ResultSet datosElementosPlato = consultaA.executeQuery("SELECT elemento.elemento_id, elemento.nombre, elemento.descripcion, elemento.disponible, elemento.foto, elemento.divi, elemento.divi_max, elemento.precio, elementoPlato.tiempo_elaboracion FROM elemento, elementoPlato , incluyePlato WHERE elemento.elemento_id = incluyePlato.elementoPlato_elemento_elemento_id AND " +
                        "elemento.elemento_id = elementoPlato.elemento_elemento_id AND incluyePlato.seccionComida_seccion_seccion_id ="+datosSeccion.getInt(1));
                // Obtenemos todos los ingredientes
                while (datosElementosPlato.next()) {
                    listaIngredientes = new HashMap<Ingrediente, Float>();
                    consulta2 = this.Conexion.prepareStatement("SELECT producto.foto, producto.nombre, producto.minimo, producto.maximo, producto.cantidad, producto.producto_id, tieneIngrediente.cantidad FROM tieneIngrediente, producto WHERE "
                            + "tieneIngrediente.productoIngrediente_producto_producto_id"
                            + " = producto.producto_id AND tieneIngrediente.elementoComida_elemento_elemento_id =" + datosElementosPlato.getInt(1));
                    datosIngredientes = consulta2.executeQuery();

                    boolean disponible = true;
                    while (datosIngredientes.next()) {
                        Ingrediente ingrediente = new Ingrediente(datosIngredientes.getInt(6), datosIngredientes.getString(2), datosIngredientes.getFloat(5), datosIngredientes.getFloat(3), datosIngredientes.getFloat(4), Imagen.blobToImageIcon(new SerialBlob(datosIngredientes.getBlob(1)).getBytes(1, (int) datosIngredientes.getBlob(1).length())));
                        Float cantidad = new Float(datosIngredientes.getFloat(7));
                        listaIngredientes.put(ingrediente, cantidad);

                        // Si la cantidad es menor que el minimo
                        if(datosIngredientes.getFloat(5) < datosIngredientes.getFloat(3)){
                            disponible = false;
                        }
                    }
                    // Para obtener la imagen, primero sacamos el blob y con SerialBlob lo pasamos a byte[]
                    ElementoPlato elemento = new ElementoPlato(datosElementosPlato.getInt(1), listaIngredientes, datosElementosPlato.getString(2), datosElementosPlato.getString(3), disponible, Imagen.blobToImageIcon(new SerialBlob(datosElementosPlato.getBlob(5)).getBytes(1, (int) datosElementosPlato.getBlob(5).length())), datosElementosPlato.getInt(9), datosElementosPlato.getInt(8), datosElementosPlato.getInt(7));
                    listaElementosP.add(elemento);
                }
                SeccionComida seccion = new SeccionComida(datosSeccion.getInt(1), datosSeccion.getString(2), carta, listaElementosP);
                listaSecciones.add(seccion);
            }
        } catch (SQLException ex) {
            Logger.getLogger(GestorBaseDatos.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            try {
                if(consulta != null) consulta.close();
                if(consultaA != null) consultaA.close();
                if(consulta2 != null) consulta2.close();
                if(datosCarta != null) datosCarta.close();
                if(datosSeccion != null) datosSeccion.close();
                if(datosElementosBebida != null) datosElementosBebida.close();
                if(datosIngredientes != null) datosIngredientes.close();
            } catch (SQLException ex) {
                Logger.getLogger(GestorBaseDatos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return listaSecciones;
    }

    public void eliminaProducto(Producto p) {
        java.sql.PreparedStatement borrado = null;
        java.sql.PreparedStatement borrado2 = null;
        try {
            int codPro = p.getCodPro();
            /*Preparamos la consulta de borrado del producto*/
            if (p instanceof Bebida) {
                borrado = this.Conexion.prepareStatement("delete from productoBebida where producto_producto_id='" + codPro + "'");
                borrado.executeUpdate();
            } else if (p instanceof Ingrediente) {
                borrado = this.Conexion.prepareStatement("delete from productoIngrediente where producto_producto_id='" + codPro + "'");
                borrado.executeUpdate();
            }
            borrado2 = this.Conexion.prepareStatement("delete from producto where producto_id='" + codPro + "'");
            borrado2.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(GestorBaseDatos.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            try {
                if(borrado != null) borrado.close();
                if(borrado2 != null) borrado2.close();
            } catch (SQLException ex) {
                Logger.getLogger(GestorBaseDatos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void modificarProducto(Producto p) {
         java.sql.PreparedStatement actualizacion = null;
        try {
            /*Preparamos la consulta de actualizacion del producto*/
            int codigoProducto = p.getCodPro();
            actualizacion = this.Conexion.prepareStatement("update producto set cantidad=?, maximo=?, minimo=?, nombre=?, foto=? where producto_id='" + codigoProducto + "'");
            actualizacion.setFloat(1, p.getCantidad());
            actualizacion.setFloat(2, p.getMaximo());
            actualizacion.setFloat(3, p.getMinimo());
            actualizacion.setString(4, p.getNombre());
            actualizacion.setBytes(5, Imagen.imageIconToByteArray(p.getImagen()));
            actualizacion.executeUpdate();//Insertamos la incidencia

        } catch (SQLException ex) {
            Logger.getLogger(GestorBaseDatos.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            try {
                if(actualizacion != null) actualizacion.close();
            } catch (SQLException ex) {
                Logger.getLogger(GestorBaseDatos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void nuevoProducto(Producto p) {
        java.sql.PreparedStatement inserccion = null;
        Statement ultimo = null;
        ResultSet id = null;
        java.sql.PreparedStatement relacion = null;
        try {
            /*Preparamos la consulta de inserccion del producto*/
            inserccion = this.Conexion.prepareStatement("insert into producto" + "(nombre,cantidad,maximo,minimo,foto)" + " values ( ?, ?, ?, ?, ?)");
            inserccion.setString(1, p.getNombre());
            inserccion.setFloat(2, p.getCantidad());
            inserccion.setFloat(3, p.getMaximo());
            inserccion.setFloat(4, p.getMinimo());
            inserccion.setBytes(5, Imagen.imageIconToByteArray(p.getImagen()));

            //Ejecutamos la inserccion
            ultimo = (Statement) this.Conexion.createStatement();
            inserccion.executeUpdate();//Insertamos la incidencia
            id = ultimo.executeQuery("select MAX(producto_id) from producto;"); // Sacamos su ID
            id.next();
            p.setCodPro(id.getInt(1));

            /*Actualizamos en la tabla de bebidas o de ingredientes segun corresponda*/
            if (p instanceof Bebida) {
                relacion = this.Conexion.prepareStatement("insert into productoBebida" + "(producto_producto_id) " + "values ( ? )");
                relacion.setInt(1, p.getCodPro());
                relacion.executeUpdate();
            } else if (p instanceof Ingrediente) {
                relacion = this.Conexion.prepareStatement("insert into productoIngrediente" + "(producto_producto_id) " + "values ( ? )");
                relacion.setInt(1, p.getCodPro());
                relacion.executeUpdate();
            }

        } catch (SQLException ex) {
            Logger.getLogger(GestorBaseDatos.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            try {
               if(inserccion != null) inserccion.close();
               if(ultimo != null) ultimo.close();
               if(id != null) id.close();
               if(relacion != null) relacion.close();
            } catch (SQLException ex) {
                Logger.getLogger(GestorBaseDatos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void nuevaIncidencia(Incidencia in) {
        java.sql.PreparedStatement inserccion = null;
        java.sql.PreparedStatement relacion = null;
        Statement ultimo = null;
        ResultSet id = null;
        try {
            /*Preparamos la consulta de inserccion de la incidencia*/
            inserccion = this.Conexion.prepareStatement("insert into incidencia" + "(descripcion,fecha,cantidad_afectada)" + " values ( ? , ?, ?)");
            inserccion.setString(1, in.getTipoIncidencia());
            Timestamp fechaSQL = new Timestamp(in.getFecha().getTime());
            inserccion.setTimestamp(2, fechaSQL);
            inserccion.setFloat(3, in.getCantidadAfectada());

            /*Preparamos la consulta de la incidencia y el producto afectado*/
            ultimo = (Statement) this.Conexion.createStatement();
            relacion = this.Conexion.prepareStatement("insert into tieneIncidencia"
                    + "(incidencia_incidencia_id,producto_producto_id) "
                    + "values ( ? , ? )");
            relacion.setInt(2, in.getProducto().getCodPro());

            //Ejecutamos las consultas
            inserccion.executeUpdate();//Insertamos la incidencia
            id = ultimo.executeQuery("select MAX(incidencia_id) from incidencia;"); // Sacamos su ID
            id.next();
            relacion.setInt(1, id.getInt(1)); // Metemeos el ID en la consulta de relacion
            relacion.executeUpdate();// insertamos la relacion.
            in.setCodigo(id.getInt(1));// Modificamos el codigo de la incidencia.

        } catch (SQLException ex) {
            Logger.getLogger(GestorBaseDatos.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            try {
               if(inserccion != null) inserccion.close();
               if(ultimo != null) ultimo.close();
               if(id != null) id.close();
               if(relacion != null) relacion.close();
            } catch (SQLException ex) {
                Logger.getLogger(GestorBaseDatos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void nuevoPedidoProveedor(PedidoProveedor pedProdveedor) {
        java.sql.PreparedStatement insercion = null;
        Statement ultimo = null;
        java.sql.PreparedStatement relacion = null;
        ResultSet id = null;
        try {
            /*Preparamos la consulta de inserccion del pedido*/
            insercion = this.Conexion.prepareStatement("insert into pedidoProveedor"
                    + "(fecha_pedido,recibido)"
                    + " values ( ? , ?)");
            insercion.setBoolean(2, pedProdveedor.fueRecibido());
            Timestamp fechaSQL = new Timestamp(pedProdveedor.getFechaPedido().getTime());
            insercion.setTimestamp(1, fechaSQL);

            /*Preparamos la relacion con los productos pedidos*/
            ultimo = (Statement) this.Conexion.createStatement();
            relacion = this.Conexion.prepareStatement("insert into tienePedido "
                    + "values (?,?,?)");
            Iterator it = pedProdveedor.obtenerInfoPedido().entrySet().iterator();

            //Ejecutamos las consultas
            insercion.executeUpdate();//Insertamos la incidencia
            id = ultimo.executeQuery("select MAX(pedido_proveedor_id) from pedidoProveedor"); // Sacamos su ID
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
        }finally {
            try {
               if(insercion != null) insercion.close();
               if(ultimo != null) ultimo.close();
               if(id != null) id.close();
               if(relacion != null) relacion.close();
            } catch (SQLException ex) {
                Logger.getLogger(GestorBaseDatos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public HashSet<Producto> obtieneBebidas() {
        int codigoBebida;
        HashSet<Producto> listaBebidas = new HashSet<Producto>();
        Statement consulta = null;
        ResultSet tablaproductos = null;
        Statement consultaBebidas = null;
        try {
            consulta = (Statement) this.Conexion.createStatement();
            ResultSet tablabebidas = consulta.executeQuery("select producto_producto_id FROM productoBebida");

            while (tablabebidas.next()) {
                codigoBebida = tablabebidas.getInt(1);
                consultaBebidas = (Statement) this.Conexion.createStatement();
                tablaproductos = consultaBebidas.executeQuery("select * from producto where producto_id='" + codigoBebida + "'");
                tablaproductos.next();
                Bebida bebida = new Bebida(tablaproductos.getInt(1), tablaproductos.getString(2), Imagen.blobToImageIcon(tablaproductos.getBytes(6)),
                        tablaproductos.getFloat(5), tablaproductos.getFloat(4), tablaproductos.getFloat(3));
                listaBebidas.add(bebida);
            }
        } catch (SQLException ex) {
            Logger.getLogger(GestorBaseDatos.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            try {
               if(consulta != null) consulta.close();
               if(tablaproductos != null) tablaproductos.close();
               if(consultaBebidas != null) consultaBebidas.close();
            } catch (SQLException ex) {
                Logger.getLogger(GestorBaseDatos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return listaBebidas;
    }

    public HashSet<Producto> obtieneIngredientes() {
        int codigoIngrediente;
        HashSet<Producto> listaIngredientes = new HashSet<Producto>();
        Statement consulta = null;
        ResultSet tablaingredientes = null;
        ResultSet tablaproductos = null;
        Statement consultaBebidas = null;
        try {
            consulta = (Statement) this.Conexion.createStatement();
            tablaingredientes = consulta.executeQuery("select producto_producto_id FROM productoIngrediente");

            while (tablaingredientes.next()) {
                codigoIngrediente = tablaingredientes.getInt(1);
                consultaBebidas = (Statement) this.Conexion.createStatement();
                tablaproductos = consultaBebidas.executeQuery("select * from producto where producto_id='" + codigoIngrediente + "'");
                tablaproductos.next();
                Ingrediente ingrediente = new Ingrediente(tablaproductos.getInt(1), tablaproductos.getString(2), tablaproductos.getFloat(3), tablaproductos.getFloat(4),
                        tablaproductos.getFloat(5), Imagen.blobToImageIcon(tablaproductos.getBytes(6)));
                listaIngredientes.add(ingrediente);
            }
        } catch (SQLException ex) {
            Logger.getLogger(GestorBaseDatos.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            try {
               if(consulta != null) consulta.close();
               if(tablaingredientes != null) tablaingredientes.close();
               if(tablaproductos != null) tablaproductos.close();
               if(consultaBebidas != null) consultaBebidas.close();
            } catch (SQLException ex) {
                Logger.getLogger(GestorBaseDatos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return listaIngredientes;
    }

    public PedidoProveedor obtienePrimerPedidoPendiente() {
        Statement pedido = null;
        ResultSet infoPedido = null;
        ResultSet tablaproductos = null;
        try {
            pedido = (Statement) this.Conexion.createStatement();
            infoPedido = pedido.executeQuery("select pedido_proveedor_id, fecha_pedido, recibido "
                    + " from pedidoProveedor n , (select  MIN(pedido_proveedor_id) min_id from pedidoProveedor where recibido = false) mini "
                    + " where n.pedido_proveedor_id = mini.min_id");

            if(infoPedido.next()){
                int id = infoPedido.getInt(1);
                Timestamp fecha = infoPedido.getTimestamp(2);
                Boolean recibido = ( infoPedido.getInt(3) != 0 );
                tablaproductos = pedido.executeQuery("select producto_id, nombre, producto.cantidad, maximo,minimo, foto, tienePedido.cantidad"
                        + " from producto, tienePedido"
                        + " where pedidoProveedor_pedido_proveedor_id = '" + id
                        + "' and producto_producto_id = producto_id");
                HashMap<Producto, Float> productosCantidad = new HashMap<Producto, Float>();
                while (tablaproductos.next()) {
                    Producto producto = new Producto(Imagen.blobToImageIcon(tablaproductos.getBytes(6)), tablaproductos.getString(2),
                            tablaproductos.getFloat(5), tablaproductos.getFloat(4), tablaproductos.getFloat(3), tablaproductos.getInt(1));
                    productosCantidad.put(producto, tablaproductos.getFloat(7));
                }
                return new PedidoProveedor(id, productosCantidad, fecha, recibido);
            }else
                return null;

        } catch (SQLException ex) {
            System.err.println("Error en obtenerPrimerPedidoPendiente");
        }finally {
            try {
               if(pedido != null) pedido.close();
               if(infoPedido != null) infoPedido.close();
               if(tablaproductos != null) tablaproductos.close();
            } catch (SQLException ex) {
                Logger.getLogger(GestorBaseDatos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }

    public HashMap<Producto, Float> obtieneProductosBajoMinimos() {
        HashMap<Producto, Float> listaProductos = new HashMap<Producto, Float>();
        Statement consultaProductos = null;
        ResultSet tablaproductos = null;
        try {
            consultaProductos = (Statement) this.Conexion.createStatement();
            tablaproductos = consultaProductos.executeQuery("select * from producto where producto.cantidad < producto.minimo");
            while (tablaproductos.next()) {
                Producto producto = new Producto(Imagen.blobToImageIcon(tablaproductos.getBytes(6)), tablaproductos.getString(2),
                        tablaproductos.getFloat(5), tablaproductos.getFloat(4), tablaproductos.getFloat(3), tablaproductos.getInt(1));
                listaProductos.put(producto, producto.getMaximo()- producto.getCantidad());
            }
        } catch (SQLException ex) {
            Logger.getLogger(GestorBaseDatos.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            try {
               if(consultaProductos != null) consultaProductos.close();
               if(tablaproductos != null) tablaproductos.close();
            } catch (SQLException ex) {
                Logger.getLogger(GestorBaseDatos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return listaProductos;
    }

    public void pedidoRecibido(PedidoProveedor pedProveedor) {
        Statement actualiza = null;
        try {
            actualiza = (Statement) this.Conexion.createStatement();
            actualiza.executeUpdate("update pedidoProveedor set recibido= '1' where pedido_proveedor_id = " + pedProveedor.getCodigo());
        } catch (SQLException ex) {
            Logger.getLogger(GestorBaseDatos.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            try {
               if(actualiza != null) actualiza.close();
            } catch (SQLException ex) {
                Logger.getLogger(GestorBaseDatos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void restarCantidadProducto(Pair<Producto, Float> prodCantidad) {
        java.sql.PreparedStatement actualizacion = null;
        try {
            /*Preparamos la consulta de actualizacion del producto*/
            int codigoProducto = prodCantidad.getFirst().getCodPro();
            actualizacion = this.Conexion.prepareStatement("update producto set cantidad=? where producto_id='" + codigoProducto + "'");
            float cantidad = prodCantidad.getFirst().getCantidad() - prodCantidad.getSecond();
            actualizacion.setFloat(1, cantidad);
            actualizacion.executeUpdate();//Insertamos la incidencia
            prodCantidad.getFirst().actualizarCantidad(-prodCantidad.getSecond());

        } catch (SQLException ex) {
            Logger.getLogger(GestorBaseDatos.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            try {
               if(actualizacion != null) actualizacion.close();
            } catch (SQLException ex) {
                Logger.getLogger(GestorBaseDatos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void restarCantidadProducto(Producto p, Float c) {
        java.sql.PreparedStatement actualizacion = null;
        try {
            /*Preparamos la consulta de actualizacion del producto*/
            int codigoProducto = p.getCodPro();
            actualizacion = this.Conexion.prepareStatement("update producto set cantidad=? where producto_id='" + codigoProducto + "'");
            float cantidad = p.getCantidad() - c;
            actualizacion.setFloat(1, cantidad);
            actualizacion.executeUpdate();//Insertamos la incidencia
            p.actualizarCantidad(-c);
        } catch (SQLException ex) {
            Logger.getLogger(GestorBaseDatos.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            try {
               if(actualizacion != null) actualizacion.close();
            } catch (SQLException ex) {
                Logger.getLogger(GestorBaseDatos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    public ArrayList<Pedido> obtienePedidosPreparandose(){
        ArrayList<Pedido> preparandose = new ArrayList<Pedido>();
        Pedido ped;
        ResultSet tablaPedidos = null;
        Statement consulta = null;
        Statement consulta2 = null;
        ResultSet tablaElementosPedido = null;
        ResultSet codigoElemento = null;
        Statement consulta3 = null;
        try {
            consulta = (Statement) this.Conexion.createStatement();
            // Obtengo los pedidos cuyo estado es distinto de Facturado y tiene elementosColaCocina en Cola
            tablaPedidos = consulta.executeQuery("SELECT pedido_id, mesa_id, pedido.estado, fecha " +
                                                            "FROM pedido, tieneElemento, elementoPedido, elementoColaCocina " +
                                                            "WHERE pedido.estado <> 2 AND elementoPedido.estado = 1 AND pedido_id = pedido_pedido_id " +
                                                            "AND tieneElemento.elementoPedido_elementoPedido_id = elementoPedido_id " +
                                                            "AND elementoPedido_id = elementoColaCocina.elementoPedido_elementoPedido_id "
                                                            + " GROUP BY pedido_id ORDER BY fecha;");

           HashSet<Elemento> elementosCarta = this.obtieneElementos();
           while (tablaPedidos.next()){

                // Obtengo los elementoPedido asociados al pedido
                ped = new Pedido(tablaPedidos.getInt(2),tablaPedidos.getInt(1),tablaPedidos.getInt(3),tablaPedidos.getTimestamp(4));
                consulta2 = (Statement) this.Conexion.createStatement();
                tablaElementosPedido = consulta2.executeQuery("SELECT elementoPedido_id,estado,comentario FROM tieneElemento,elementoPedido WHERE pedido_pedido_id = "+tablaPedidos.getInt(1)+" AND elementoPedido_elementoPedido_id = elementoPedido_id");
                ElementoColaBar eleCB;
                ElementoColaCocina eleCC;
                boolean encontrado;
                Iterator<Elemento> it;
                Elemento ele = null;
                consulta3 = (Statement) this.Conexion.createStatement();
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
                preparandose.add(ped);
            }
        } catch (SQLException ex) {
           // Logger.getLogger(GestorBaseDatos.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            try {
                if(tablaPedidos != null) tablaPedidos.close();
                if(consulta != null) consulta.close();
                if(consulta2 != null) consulta2.close();
                if(tablaElementosPedido != null) tablaElementosPedido.close();
                if(codigoElemento != null) codigoElemento.close();
                if(consulta3 != null) consulta3.close();
            } catch (SQLException ex) {
                Logger.getLogger(GestorBaseDatos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return preparandose;
    }

    public int getNumPlatosEnCola() {
        Statement consulta = null;
        ResultSet resultado = null;
        int numplatos=-1;
        try {
            consulta = (Statement) this.Conexion.createStatement();
            resultado = consulta.executeQuery("SELECT COUNT( elementoPedido_elementoPedido_id) " +
                                                        "FROM elementoPedido,elementoColaCocina WHERE elementoPedido_id = " +
                                                        "elementoPedido_elementoPedido_id AND estado = 0");
            resultado.next();
            numplatos = resultado.getInt(1);

        } catch (SQLException ex) {

            System.err.println("Error al obtener el numero de platos");
        }finally {
            try {
                if(resultado != null) resultado.close();
                if(consulta != null) consulta.close();
            } catch (SQLException ex) {
                Logger.getLogger(GestorBaseDatos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return numplatos;
    }

    public int getNumBebidasEnCola() {
        Statement consulta = null;
        ResultSet resultado = null;
        int numbebidas=-1;
        try {
            consulta = (Statement) this.Conexion.createStatement();
            resultado = consulta.executeQuery("SELECT COUNT( elementoPedido_elementoPedido_id) " +
                                                        "FROM elementoPedido,elementoColaBar WHERE elementoPedido_id = " +
                                                        "elementoPedido_elementoPedido_id AND estado = 0");
            resultado.next();
            numbebidas = resultado.getInt(1);

        } catch (SQLException ex) {
            Logger.getLogger(GestorBaseDatos.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            try {
                if(resultado != null) resultado.close();
                if(consulta != null) consulta.close();
            } catch (SQLException ex) {
                Logger.getLogger(GestorBaseDatos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return numbebidas;
    }

    /**
     *  Actualiza el estado y los comentarios del pedido y sus elementos
     *  @param p Pedido que es actualizado en la base de datos
     */
    public void actualizaPedido(Pedido p) {
        java.sql.PreparedStatement actPedido = null;
        java.sql.PreparedStatement elemPedBD = null;
        java.sql.PreparedStatement actElem = null;
        ResultSet elemPedEstado = null;
        try{
            actPedido = this.Conexion.prepareStatement("UPDATE pedido SET estado=? WHERE pedido_id='" + p.getCodPedido()+"'");
            actPedido.setInt(1, p.getEstado());
            actPedido.executeUpdate();
            actElem = this.Conexion.prepareStatement("UPDATE elementoPedido SET estado=?,comentario=? WHERE elementoPedido_id=?");
            ArrayList<ElementoPedido> elementos = p.obtieneElementos();
            Iterator ite = elementos.iterator();
            elemPedBD = this.Conexion.prepareStatement("SELECT estado, comentario FROM elementoPedido WHERE elementoPedido_id=?");
            while (ite.hasNext()){
                // Unicamente debe actualizar los que tengan mayor estado
                ElementoPedido eped = ((ElementoPedido)ite.next()); // Obtenemos el siguiete Elemento
                int id = eped.getCodElementoPedido();
                int est = eped.getEstado();
                String comment = eped.getComentario();

                // Obtenemos el mismo ElementoPedido de la base de datos y comprobamos quien tiene el mayor estado
                elemPedBD.setInt(1, id);
                elemPedEstado = elemPedBD.executeQuery();
                elemPedEstado.next();
                if(elemPedEstado.getInt(1) < est || // Si el estado de la base de datos es menor OR
                       (elemPedEstado.getInt(1) == est && // El estado es igual pero el comentario
                        !elemPedEstado.getString(2).equals(comment) )){// es distinto, se actualiza
                        actElem.setInt(1, est);
                        actElem.setString(2, comment);
                        actElem.setInt(3, id);
                        actElem.executeUpdate();
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(GestorBaseDatos.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            try {
                if (actPedido != null) {
                    actPedido.close();
                }
                if (elemPedBD != null) {
                    elemPedBD.close();
                }
                if (actElem != null) {
                    actElem.close();
                }
                if (elemPedEstado != null) {
                    elemPedEstado.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(GestorBaseDatos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    // TODO Por aqui
    public Factura getFactura(int codMesa){
        Factura fac = null;
        boolean hayFactura = false;
        Statement consulta = null;
        ResultSet factura = null;
        Statement consulta2 = null;
        ResultSet tablaElementosPedido = null;
        ResultSet codigoElemento = null;
        Statement consulta3 = null;
        try{
            consulta = (Statement) this.Conexion.createStatement();
            factura = consulta.executeQuery("SELECT factura_id,factura.estado,factura.fecha,pedido.pedido_id,pedido.mesa_id,pedido.estado,pedido.fecha FROM factura,facturaPedido,pedido WHERE factura_id = factura_factura_id AND pedido_pedido_id = pedido_id AND mesa_id = "+codMesa+" AND pedido.estado = 1");
            HashSet<Elemento> elementosCarta = this.obtieneElementos();
            Pedido ped = null;
            hayFactura = factura.next();
            if (hayFactura) {
                fac = new Factura(factura.getInt(1), factura.getInt(2), factura.getTimestamp(3),0);
                do {
                    // Obtengo los elementoPedido asociados al pedido
                    ped = new Pedido(factura.getInt(5), factura.getInt(4), factura.getInt(6), factura.getTimestamp(7));
                    consulta2 = (Statement) this.Conexion.createStatement();
                    tablaElementosPedido = consulta2.executeQuery("SELECT elementoPedido_id,estado,comentario FROM tieneElemento,elementoPedido WHERE pedido_pedido_id = " + factura.getInt(4) + " AND elementoPedido_elementoPedido_id = elementoPedido_id");
                    ElementoColaBar eleCB;
                    ElementoColaCocina eleCC;
                    boolean encontrado;
                    Iterator<Elemento> it;
                    Elemento ele = null;
                    consulta3 = (Statement) this.Conexion.createStatement();
                    while (tablaElementosPedido.next()) {
                        //Obtengo SOLO EL CODIGO del elemento de la carta asociado al elementoPedido. Comprueba si es un plato
                        codigoElemento = consulta3.executeQuery("SELECT elementoPlato_elemento_elemento_id FROM asociaPlato WHERE elementoColaCocina_elementoPedido_elementoPedido_id = " + tablaElementosPedido.getInt(1));
                        if (!codigoElemento.next()) {
                            // No es un plato es una bebida
                            codigoElemento = consulta3.executeQuery("SELECT elementoBebida_elemento_elemento_id FROM asociaBebida WHERE elementoColaBar_elementoPedido_elementoPedido_id = " + tablaElementosPedido.getInt(1));
                            codigoElemento.next();
                            eleCB = new ElementoColaBar(tablaElementosPedido.getInt(1), tablaElementosPedido.getInt(2), tablaElementosPedido.getString(3));
                            // Busco el objeto elemento de carta
                            encontrado = false;
                            for (it = elementosCarta.iterator(); it.hasNext() && !encontrado;) {
                                ele = it.next();
                                if (ele.getCodigoElemento() == codigoElemento.getInt(1)) {
                                    encontrado = true;
                                }
                            }
                            // Asocio el elemento de la Carta al elemento pedido
                            eleCB.asocia(ele);
                            //Asocio el elementoColaBar al pedido
                            ped.asocia(eleCB);
                        } else {
                            eleCC = new ElementoColaCocina(tablaElementosPedido.getInt(1), tablaElementosPedido.getInt(2), tablaElementosPedido.getString(3));
                            // Busco el objeto elemento de carta
                            encontrado = false;
                            for (it = elementosCarta.iterator(); it.hasNext() && !encontrado;) {
                                ele = it.next();
                                if (ele.getCodigoElemento() == codigoElemento.getInt(1)) {
                                    encontrado = true;
                                }
                            }
                            // Asocio el elemento de la Carta al elemento pedido
                            eleCC.asocia(ele);
                            // Asocio el elementoColaCocina al pedido
                            ped.asocia(eleCC);
                        }
                    }
                    fac.asocia(ped);
                } while (factura.next());
            }
        } catch (SQLException ex) {
            Logger.getLogger(GestorBaseDatos.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            try {
                if(consulta != null) consulta.close();
                if(factura != null) factura.close();
                if(consulta2 != null) consulta2.close();
                if(tablaElementosPedido != null) tablaElementosPedido.close();
                if(codigoElemento != null) codigoElemento.close();
                if(consulta3 != null) consulta3.close();
            } catch (SQLException ex) {
                Logger.getLogger(GestorBaseDatos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return fac;
    }

    public ArrayList<Pedido> getPedidosModificablesMesa(int codMesa){
        ArrayList<Pedido> pedidos = new ArrayList();
        Statement consultaPedidos = null;
        ResultSet resultado = null;
        Statement consultaElemPed = null;
        ResultSet resElemPed = null;
        ResultSet resElem = null;
        ResultSet resProds = null;
        Statement consultaIngredientes = null;
        Statement consultaBebidas = null;
        Statement consultaElem = null;
        try {
            consultaPedidos = (Statement) this.Conexion.createStatement();
            resultado = consultaPedidos.executeQuery(" select pedido_id,mesa_id,estado,fecha from pedido where estado = 0 AND mesa_id = " + codMesa);
            while (resultado.next()) {
                Pedido pedido = new Pedido(resultado.getInt(1), resultado.getInt(2), resultado.getInt(3), resultado.getTimestamp(4));
                consultaElemPed = (Statement) this.Conexion.createStatement();
                resElemPed = consultaElemPed.executeQuery(" select elementoPedido_id,estado,comentario from elementoPedido where elementoPedido_id IN " +
                        "(select elementoPedido_elementoPedido_id from tieneElemento where pedido_pedido_id = " + pedido.getCodPedido() + ")");
                while (resElemPed.next()) {
                    ElementoPedido elemPed = new ElementoPedido(resElemPed.getInt(1), resElemPed.getInt(2), resElemPed.getString(3));
                    Elemento elem;

                    //Comprobamos si es un PLATO
                    consultaElem = (Statement) this.Conexion.createStatement();
                    resElem = consultaElem.executeQuery(" SELECT elemento_id, nombre, descripcion, disponible, foto, divi, divi_max, precio FROM elemento WHERE elemento_id IN " + "(SELECT elementoPlato_elemento_elemento_id FROM asociaPlato WHERE elementoColaCocina_elementoPedido_elementoPedido_id = " + elemPed.getCodElementoPedido() + ")");

                    if(resElem.next()){
                        elem = new Elemento(resElem.getInt(1), resElem.getString(2), resElem.getString(3), resElem.getBoolean(4), Imagen.blobToImageIcon(new SerialBlob(resElem.getBlob(6)).getBytes(1, (int) resElem.getBlob(1).length())), resElem.getInt(6), resElem.getInt(7), resElem.getFloat(8));

                        //Asociamos los ingredientes
                        consultaIngredientes = (Statement) this.Conexion.createStatement();
                        resProds = consultaIngredientes.executeQuery("SELECT producto_id, nombre, cantidad, maximo, minimo, foto FROM producto WHERE producto_id IN " + "( SELECT productoIngrediente_producto_producto_id FROM tieneIngrediente WHERE elementoComida_elemento_elemento_id IN " + "(SELECT elemento_elemento_id FROM elementoPlato WHERE elemento_elemento_id = " + resElem.getInt(1) + ")) ");
                        HashMap<Ingrediente,Float> temp = new HashMap();
                        while (resProds.next()) {
                            Ingrediente ingrediente = new Ingrediente(resProds.getInt(1), resProds.getString(2), resProds.getFloat(3), resProds.getFloat(4), resProds.getFloat(5), Imagen.blobToImageIcon(new SerialBlob(resProds.getBlob(6)).getBytes(1, (int) resProds.getBlob(1).length())));
                            temp.put(ingrediente, new Float(0));
                        }
                        ElementoPlato elemComida = new ElementoPlato(elem.getCodigoElemento(), temp, elem.getNombre(), elem.getDescripcion(), false, elem.getFoto(), 0, elem.getPrecio(), elem.getDivisionesMaximas());
                        ElementoColaCocina elemColaCocina = new ElementoColaCocina(elemPed.getCodElementoPedido(), elemPed.getEstado(), elemPed.getComentario());
                        elemColaCocina.asocia(elemComida);
                        pedido.asocia(elemColaCocina);
                    }else{ //Es una BEBIDA
                        resElem = consultaElem.executeQuery(" SELECT elemento_id, nombre, descripcion, disponible, foto, divi, divi_max, precio FROM elemento WHERE elemento_id IN " +
                                "(SELECT elementoBebida_elemento_elemento_id FROM asociaBebida WHERE elementoColaBar_elementoPedido_elementoPedido_id = " + elemPed.getCodElementoPedido() + ")");
                        resElem.next();
                        elem = new Elemento(resElem.getInt(1), resElem.getString(2), resElem.getString(3), resElem.getBoolean(4), Imagen.blobToImageIcon(new SerialBlob(resElem.getBlob(6)).getBytes(1, (int) resElem.getBlob(1).length())), resElem.getInt(6), resElem.getInt(7), resElem.getFloat(8));
                        //Asociamos las bebidas
                        consultaBebidas = (Statement) this.Conexion.createStatement();
                        resProds = consultaBebidas.executeQuery("SELECT producto_id, nombre, cantidad, maximo, minimo, foto FROM producto WHERE producto_id IN " + "( SELECT productoBebida_producto_producto_id FROM tieneBebida WHERE elementoBebida_elemento_elemento_id IN " + "(SELECT elemento_elemento_id FROM elementoBebida WHERE elemento_elemento_id = " + resElem.getInt(1) + ")) ");
                        HashMap<Bebida,Float> temp = new HashMap();
                        while (resProds.next()) {
                            Bebida bebida = new Bebida(resProds.getInt(1), resProds.getString(2), Imagen.blobToImageIcon(new SerialBlob(resProds.getBlob(6)).getBytes(1, (int) resProds.getBlob(1).length())), resProds.getInt(3), resProds.getInt(4), resProds.getInt(5));
                            temp.put(bebida, new Float(0));
                        }
                        ElementoBebida elemBebida = new ElementoBebida(elem.getCodigoElemento(),temp,elem.getNombre(), elem.getDescripcion(), false, elem.getFoto(), elem.getPrecio(),elem.getDivisiones());

                        ElementoColaBar elemColaBar = new ElementoColaBar(elemPed.getCodElementoPedido(), elemPed.getEstado(), elemPed.getComentario());
                        elemColaBar.asocia(elemBebida);
                        pedido.asocia(elemColaBar);
                    }
                }
                pedidos.add(pedido);
            }
        } catch (SQLException ex) {
            Logger.getLogger(GestorBaseDatos.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            try {
                if(consultaPedidos != null) consultaPedidos.close();
                if(resultado != null) resultado.close();
                if(consultaElemPed != null) consultaElemPed.close();
                if(resElemPed != null) resElemPed.close();
                if(resElem != null) resElem.close();
                if(resProds != null) resProds.close();
                if(consultaIngredientes != null) consultaIngredientes.close();
                if(consultaBebidas != null) consultaBebidas.close();
                if(consultaElem != null) consultaElem.close();
            } catch (SQLException ex) {
                Logger.getLogger(GestorBaseDatos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return pedidos;
    }

    // Actualiza el estado de la factura
    public void actualizaFactura(Factura f){
        java.sql.PreparedStatement accion = null;
        try {
            accion = this.Conexion.prepareStatement("UPDATE factura SET estado=? WHERE factura_id='"+ f.getCodFactura()+"'");
            accion.setInt(1, f.getEstado());
            accion.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(GestorBaseDatos.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            try {
                if(accion != null) accion.close();
            } catch (SQLException ex) {
                Logger.getLogger(GestorBaseDatos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public boolean nuevoPedido(Pedido pedido) {
        boolean exito = false;
        java.sql.PreparedStatement insercionPedido = null;
        java.sql.PreparedStatement insercionTieneElemento = null;
        java.sql.PreparedStatement insercionElementoPedido = null;
        java.sql.PreparedStatement insercionColaCocina = null;
        java.sql.PreparedStatement insercionColaBar = null;
        java.sql.PreparedStatement insercionAsociaPlato = null;
        java.sql.PreparedStatement insercionAsociaBebida = null;
        try {
            // Inserción para pedido
            insercionPedido = this.Conexion.prepareStatement(
                    "INSERT INTO pedido(pedido_id,mesa_id,estado,fecha) VALUES (?,?,?,?)");
            // Inserción para tieneelemento
            insercionTieneElemento = this.Conexion.prepareStatement(
                    "INSERT INTO tieneElemento(elementoPedido_elementoPedido_id,pedido_pedido_id) VALUES(?,?)");
            //Inserción para elementopedido
            insercionElementoPedido = this.Conexion.prepareStatement(
                    "INSERT INTO elementoPedido(elementoPedido_id,estado,comentario) VALUES(?,?,?)");
            //Inserción para elementocolacocina
            insercionColaCocina = this.Conexion.prepareStatement(
                    "INSERT INTO elementoColaCocina VALUES(?)");
            //Inserción para elementocolabar
            insercionColaBar = this.Conexion.prepareStatement(
                    "INSERT INTO elementoColaBar VALUES(?)");
            //Inserción para asociaplato
            insercionAsociaPlato = this.Conexion.prepareStatement(
                    "INSERT INTO asociaPlato VALUES(?,?)");
            //Inserción para asociabebida
            insercionAsociaBebida = this.Conexion.prepareStatement(
                    "INSERT INTO asociaBebida VALUES(?,?)");

            //Insertamos el pedido
            insercionPedido.setInt(1, pedido.getCodPedido());
            insercionPedido.setInt(2, pedido.getCodMesa());
            insercionPedido.setInt(3, pedido.getEstado());
            Timestamp fecha = new Timestamp(System.currentTimeMillis());
            insercionPedido.setTimestamp(4, new Timestamp(fecha.getTime()));
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

            exito = true;
        } catch (SQLException ex) {
            Logger.getLogger(GestorBaseDatos.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            try {
                if(insercionPedido != null) insercionPedido.close();
                if(insercionTieneElemento != null) insercionTieneElemento.close();
                if(insercionElementoPedido != null) insercionElementoPedido.close();
                if(insercionColaCocina != null) insercionColaCocina.close();
                if(insercionColaBar != null) insercionColaBar.close();
                if(insercionAsociaPlato != null) insercionAsociaPlato.close();
                if(insercionAsociaBebida != null) insercionAsociaBebida.close();

            } catch (SQLException ex) {
                Logger.getLogger(GestorBaseDatos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return exito;
    }

    public Pedido getSiguientePedidoBar() {
        Pedido ped = null;
        Statement consulta = null;
        ResultSet tablaPedidos = null;
        ResultSet tablaElementosPedido = null;
        ResultSet codigoElemento = null;
        Statement consulta2 = null;
        Statement consulta3 = null;
        try {
            consulta = (Statement) this.Conexion.createStatement();
            // Obtengo los pedidos cuyo estado es distinto de Facturado y tiene elementosColaBar en Cola
            tablaPedidos = consulta.executeQuery("SELECT pedido_id, mesa_id, pedido.estado, fecha FROM pedido, tieneElemento, elementoPedido, elementoColaBar WHERE pedido.estado <> 2 AND pedido_id = pedido_pedido_id AND tieneElemento.elementoPedido_elementoPedido_id = elementoPedido_id AND elementoPedido_id = elementoColaBar.elementoPedido_elementoPedido_id AND elementoPedido.estado =0 GROUP BY pedido_id HAVING COUNT( elementoColaBar.elementoPedido_elementoPedido_id ) >0 ORDER BY fecha;");
            if (tablaPedidos.next()){
                HashSet<Elemento> elementosCarta = this.obtieneElementos();
                // Obtengo los elementoPedido asociados al pedido
                ped = new Pedido(tablaPedidos.getInt(2),tablaPedidos.getInt(1),tablaPedidos.getInt(3),tablaPedidos.getTimestamp(4));
                consulta2 = (Statement) this.Conexion.createStatement();
                tablaElementosPedido = consulta2.executeQuery("SELECT elementoPedido_id,estado,comentario FROM tieneElemento,elementoPedido WHERE pedido_pedido_id = "+tablaPedidos.getInt(1)+" AND elementoPedido_elementoPedido_id = elementoPedido_id");
                ElementoColaBar eleCB;
                ElementoColaCocina eleCC;
                boolean encontrado;
                Iterator<Elemento> it;
                Elemento ele = null;
                consulta3 = (Statement) this.Conexion.createStatement();
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
        }finally {
            try {
                if(consulta != null) consulta.close();
                if(tablaPedidos != null) tablaPedidos.close();
                if(tablaElementosPedido != null) tablaElementosPedido.close();
                if(codigoElemento != null) codigoElemento.close();
                if(consulta2 != null) consulta2.close();
                if(consulta3 != null) consulta3.close();
            } catch (SQLException ex) {
                Logger.getLogger(GestorBaseDatos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return ped;
    }

    public Pedido getSiguientePedidoCocina() {
        Pedido ped = null;
        Statement consulta = null;
        ResultSet tablaPedidos = null;
        Statement consulta2 = null;
        ResultSet tablaElementosPedido = null;
        ResultSet codigoElemento = null;
        Statement consulta3 = null;
        try {
            consulta = (Statement) this.Conexion.createStatement();
            // Obtengo los pedidos cuyo estado es distinto de Facturado y tiene elementosColaCocina en Cola
            tablaPedidos = consulta.executeQuery("SELECT pedido_id, mesa_id, pedido.estado, fecha " +
                                                            "FROM pedido, tieneElemento, elementoPedido, elementoColaCocina " +
                                                            "WHERE pedido.estado <> 2 AND pedido_id = pedido_pedido_id " +
                                                            "AND tieneElemento.elementoPedido_elementoPedido_id = elementoPedido_id " +
                                                            "AND elementoPedido_id = elementoColaCocina.elementoPedido_elementoPedido_id " +
                                                            "AND elementoPedido.estado =0 GROUP BY pedido_id " +
                                                            "HAVING COUNT( elementoColaCocina.elementoPedido_elementoPedido_id ) >0 ORDER BY fecha;");
            if (tablaPedidos.next()){
                HashSet<Elemento> elementosCarta = this.obtieneElementos();
                // Obtengo los elementoPedido asociados al pedido
                ped = new Pedido(tablaPedidos.getInt(2),tablaPedidos.getInt(1),tablaPedidos.getInt(3),tablaPedidos.getTimestamp(4));
                consulta2 = (Statement) this.Conexion.createStatement();
                tablaElementosPedido = consulta2.executeQuery("SELECT elementoPedido_id,estado,comentario FROM tieneElemento,elementoPedido WHERE pedido_pedido_id = "+tablaPedidos.getInt(1)+" AND elementoPedido_elementoPedido_id = elementoPedido_id");
                ElementoColaBar eleCB;
                ElementoColaCocina eleCC;
                boolean encontrado;
                Iterator<Elemento> it;
                Elemento ele = null;
                consulta3 = (Statement) this.Conexion.createStatement();
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
        }finally {
            try {
                if(consulta != null) consulta.close();
                if(tablaPedidos != null) tablaPedidos.close();
                if(tablaElementosPedido != null) tablaElementosPedido.close();
                if(codigoElemento != null) codigoElemento.close();
                if(consulta2 != null) consulta2.close();
                if(consulta3 != null) consulta3.close();
            } catch (SQLException ex) {
                Logger.getLogger(GestorBaseDatos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return ped;
    }

    public int getCodigoPedido(){
        int retorno = -1;
        java.sql.Statement consulta = null;
        ResultSet resultado = null;
        try {
            // Obtenemos el último id que se insertó
            consulta = this.Conexion.createStatement();
            resultado = consulta.executeQuery("SELECT MAX(pedido_id) FROM pedido");
            resultado.next();
            int codPedido = resultado.getInt(1)+1;
            retorno = codPedido;
        } catch (SQLException ex) {
            Logger.getLogger(GestorBaseDatos.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            try {
                if(consulta != null) consulta.close();
                if(resultado != null) resultado.close();
            } catch (SQLException ex) {
                Logger.getLogger(GestorBaseDatos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return retorno;
    }

    public int getCodigoElementoPedido(){
        int retorno = -1;
        java.sql.Statement consulta = null;
        ResultSet resultado = null;
        try {
            // Obtenemos el último id que se insertó
            consulta = this.Conexion.createStatement();
            resultado = consulta.executeQuery("SELECT MAX(elementoPedido_id) FROM elementoPedido");
            resultado.next();
            int codEP = resultado.getInt(1)+1;
            retorno = codEP;
        } catch (SQLException ex) {
            Logger.getLogger(GestorBaseDatos.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            try {
                if(consulta != null) consulta.close();
                if(resultado != null) resultado.close();
            } catch (SQLException ex) {
                Logger.getLogger(GestorBaseDatos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return retorno;
    }

    public boolean eliminaPedido(int codPedido){
        boolean exito = false;
        java.sql.PreparedStatement borrado = null;
        java.sql.Statement consulta = null;
        ResultSet resultado = null;
        try {
            //Obtenemos el id de cada elementoPedido
            consulta = this.Conexion.createStatement();
            resultado = consulta.executeQuery("SELECT elementoPedido_elementoPedido_id FROM tieneElemento WHERE pedido_pedido_id = "+codPedido);
            ArrayList<Integer> listaId = new ArrayList();

            while(resultado.next()){
                listaId.add(resultado.getInt(1));
            }

            //Borramos tienelemeneto
            borrado = this.Conexion.prepareStatement("DELETE tieneElemento FROM tieneElemento WHERE pedido_pedido_id = "+codPedido);
            borrado.executeUpdate();
            borrado.close();

            //Borramos asociaplato y asociabebida
            for(int i=0; i<listaId.size(); ++i){
                int codElementoPedido = listaId.get(i);

                borrado = this.Conexion.prepareStatement("DELETE asociaPlato FROM asociaPlato WHERE elementoColaCocina_elementoPedido_elementoPedido_id = "+codElementoPedido);
                borrado.executeUpdate();
                borrado.close();
                borrado = this.Conexion.prepareStatement("DELETE asociaBebida FROM asociaBebida WHERE elementoColaBar_elementoPedido_elementoPedido_id = "+codElementoPedido);
                borrado.executeUpdate();
                borrado.close();
            }

            resultado = consulta.executeQuery("SELECT elementoPedido_elementoPedido_id FROM tieneElemento WHERE pedido_pedido_id = "+codPedido);
            //Borramos elementocolacocina y elementocolabar
            for(int i=0; i<listaId.size(); ++i){
                int codElementoPedido = listaId.get(i);

                borrado = this.Conexion.prepareStatement("DELETE elementoColaCocina FROM elementoColaCocina WHERE elementoPedido_elementoPedido_id = "+codElementoPedido);
                borrado.executeUpdate();
                borrado.close();
                borrado = this.Conexion.prepareStatement("DELETE elementoColaBar FROM elementoColaBar WHERE elementoPedido_elementoPedido_id = "+codElementoPedido);
                borrado.executeUpdate();
                borrado.close();
            }

            resultado = consulta.executeQuery("SELECT elementoPedido_elementoPedido_id FROM tieneElemento WHERE pedido_pedido_id = "+codPedido);
            //Borramos elementopedido
            for(int i=0; i<listaId.size(); ++i){
                int codElementoPedido = listaId.get(i);

                borrado = this.Conexion.prepareStatement("DELETE elementoPedido FROM elementoPedido WHERE elementoPedido_id = "+codElementoPedido);
                borrado.executeUpdate();
                borrado.close();
            }

            //Borramos el pedido de la factura asociada
            borrado = this.Conexion.prepareStatement("DELETE facturaPedido FROM facturaPedido WHERE pedido_pedido_id = "+codPedido);
            borrado.executeUpdate();
            borrado.close();


            //Borramos el pedido
            borrado = this.Conexion.prepareStatement("DELETE pedido FROM pedido WHERE pedido_id = "+codPedido);
            borrado.executeUpdate();
            borrado.close();

            exito = true;
        } catch (SQLException ex) {
            Logger.getLogger(GestorBaseDatos.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            try {
                if(consulta != null) consulta.close();
                if(resultado != null) resultado.close();
                if(borrado != null) borrado.close();
            } catch (SQLException ex) {
                Logger.getLogger(GestorBaseDatos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return exito;

    }

    public ArrayList<Integer> getFacturasEnCola(){
        ArrayList<Integer> mesas = new ArrayList();
        ResultSet codigosMesas = null;
        java.sql.Statement consulta = null;
        try{
            consulta = this.Conexion.createStatement();
            codigosMesas = consulta.executeQuery("SELECT DISTINCT( pedido.mesa_id ) FROM factura,facturaPedido,pedido WHERE factura_id = factura_factura_id AND pedido_pedido_id = pedido_id AND factura.estado=0");
            while (codigosMesas.next())
                mesas.add(codigosMesas.getInt(1));
        }catch (SQLException ex) {
            Logger.getLogger(GestorBaseDatos.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            try {
                if(consulta != null) consulta.close();
                if(codigosMesas != null) codigosMesas.close();
            } catch (SQLException ex) {
                Logger.getLogger(GestorBaseDatos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return mesas;
    }

    public ArrayList<Integer> getFacturasImprimidas() {
        ArrayList<Integer> mesas = new ArrayList();
        java.sql.Statement consulta = null;
        ResultSet codigosMesas = null;
        try{
            consulta = this.Conexion.createStatement();
            codigosMesas = consulta.executeQuery("SELECT DISTINCT( pedido.mesa_id ) FROM factura,facturaPedido,pedido WHERE factura_id = factura_factura_id AND pedido_pedido_id = pedido_id AND factura.estado=1");
            while (codigosMesas.next())
                mesas.add(codigosMesas.getInt(1));
        }catch (SQLException ex) {
            Logger.getLogger(GestorBaseDatos.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            try {
                if(consulta != null) consulta.close();
                if(codigosMesas != null) codigosMesas.close();
            } catch (SQLException ex) {
                Logger.getLogger(GestorBaseDatos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return mesas;
    }

    public int getCodigoFactura(){
        int codigo = -1;
        java.sql.Statement consulta = null;
        ResultSet resultado = null;
        try {
            // Obtenemos el último id que se insertó
            consulta = this.Conexion.createStatement();
            resultado = consulta.executeQuery("SELECT MAX(factura_id) FROM factura");
            resultado.next();
            int codFactura = resultado.getInt(1)+1;
            codigo = codFactura;
        } catch (SQLException ex) {
            Logger.getLogger(GestorBaseDatos.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            try {
                if(consulta != null) consulta.close();
                if(resultado != null) resultado.close();
            } catch (SQLException ex) {
                Logger.getLogger(GestorBaseDatos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return codigo;
    }

    public Factura getFactNoPagada(int codMesa){
        Factura f = null;
        java.sql.Statement consultaFactura = null;
        ResultSet codigosMesas = null;
        try {
            consultaFactura = this.Conexion.createStatement();
            codigosMesas = consultaFactura.executeQuery("SELECT * FROM factura WHERE factura_id IN " + "(SELECT factura_factura_id FROM facturaPedido WHERE pedido_pedido_id IN " + "(SELECT pedido_id FROM pedido WHERE mesa_id = " + codMesa + "))");
        } catch (SQLException ex) {
            Logger.getLogger(GestorBaseDatos.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            try {
                if(consultaFactura != null) consultaFactura.close();
                if(codigosMesas != null) codigosMesas.close();
            } catch (SQLException ex) {
                Logger.getLogger(GestorBaseDatos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return f;
    }

    public boolean nuevaFactura(Factura f){
        java.sql.PreparedStatement insercionFactura = null;
        java.sql.PreparedStatement insercionFactura2 = null;
        try {
            //Actualizamos la tabla factura
            insercionFactura = this.Conexion.prepareStatement("INSERT INTO factura(factura_id,estado,fecha) VALUES (?,?,?)");
            insercionFactura.setInt(1, f.getCodFactura());
            insercionFactura.setInt(2, f.getEstado());
            insercionFactura.setTimestamp(3, new Timestamp(f.getFecha().getTime()));
            insercionFactura.executeUpdate();

            //Actualizamos la tabla facturapedido
            ArrayList<Pedido> listaPedidos = f.getPedidos();
            Iterator it = listaPedidos.iterator();
            while(it.hasNext()){
                Pedido pedido = (Pedido) it.next();
                insercionFactura2 = this.Conexion.prepareStatement("INSERT INTO facturaPedido(pedido_pedido_id,factura_factura_id) VALUES (?,?)");
                insercionFactura2.setInt(1,pedido.getCodPedido());
                insercionFactura2.setInt(2,f.getCodFactura());
                insercionFactura2.executeUpdate();
                insercionFactura.close();
            }
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(GestorBaseDatos.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }finally {
            try {
                if(insercionFactura != null) insercionFactura.close();
                if(insercionFactura2 != null) insercionFactura2.close();
            } catch (SQLException ex) {
                Logger.getLogger(GestorBaseDatos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public ArrayList<Pedido> obtienePedidosMesa(int codMesa){
        ArrayList<Pedido> pedidos = new ArrayList();
        Statement consultaPedidos = null;
        ResultSet resultado = null;
        Statement consultaElemPed = null;
        ResultSet resElemPed = null;
        ResultSet resElem = null;
        ResultSet resProds = null;
        Statement consultaIngredientes = null;
        Statement consultaBebidas = null;
        try {
            consultaPedidos = (Statement) this.Conexion.createStatement();
            resultado = consultaPedidos.executeQuery(" SELECT pedido_id,mesa_id,estado,fecha FROM pedido WHERE mesa_id = " + codMesa + " AND estado < 2");
            while (resultado.next()) {
                Pedido pedido = new Pedido(resultado.getInt(2), resultado.getInt(1), resultado.getInt(3), resultado.getTimestamp(4));
                consultaElemPed = (Statement) this.Conexion.createStatement();
                resElemPed = consultaElemPed.executeQuery(" select elementoPedido_id,estado,comentario from elementoPedido where elementoPedido_id IN " +
                        "(select elementoPedido_elementoPedido_id from tieneElemento where pedido_pedido_id = " + pedido.getCodPedido() + ")");
                while (resElemPed.next()) {
                    ElementoPedido elemPed = new ElementoPedido(resElemPed.getInt(1), resElemPed.getInt(2), resElemPed.getString(3));
                    Elemento elem;

                    //Comprobamos si es un PLATO
                    Statement consultaElem = (Statement) this.Conexion.createStatement();
                    resElem = consultaElem.executeQuery(" SELECT elemento_id, nombre, descripcion, disponible, foto, divi, divi_max, precio FROM elemento WHERE elemento_id IN " + "(SELECT elementoPlato_elemento_elemento_id FROM asociaPlato WHERE elementoColaCocina_elementoPedido_elementoPedido_id = " + elemPed.getCodElementoPedido() + ")");

                    if(resElem.next()){
                        elem = new Elemento(resElem.getInt(1), resElem.getString(2), resElem.getString(3), resElem.getBoolean(4), Imagen.blobToImageIcon(new SerialBlob(resElem.getBlob(6)).getBytes(1, (int) resElem.getBlob(1).length())), resElem.getInt(6), resElem.getInt(7), resElem.getFloat(8));

                        //Asociamos los ingredientes
                        consultaIngredientes = (Statement) this.Conexion.createStatement();
                        resProds = consultaIngredientes.executeQuery("SELECT producto_id, nombre, cantidad, maximo, minimo, foto FROM producto WHERE producto_id IN " + "( SELECT productoIngrediente_producto_producto_id FROM tieneIngrediente WHERE elementoComida_elemento_elemento_id IN " + "(SELECT elemento_elemento_id FROM elementoPlato WHERE elemento_elemento_id = " + resElem.getInt(1) + ")) ");
                        HashMap<Ingrediente,Float> temp = new HashMap();
                        while (resProds.next()) {
                            Ingrediente ingrediente = new Ingrediente(resProds.getInt(1), resProds.getString(2), resProds.getFloat(3), resProds.getFloat(4), resProds.getFloat(5), Imagen.blobToImageIcon(new SerialBlob(resProds.getBlob(6)).getBytes(1, (int) resProds.getBlob(1).length())));
                            temp.put(ingrediente, new Float(0));
                        }
                        ElementoPlato elemComida = new ElementoPlato(elem.getCodigoElemento(), temp, elem.getNombre(), elem.getDescripcion(), false, elem.getFoto(), 0, elem.getPrecio(), elem.getDivisionesMaximas());
                        ElementoColaCocina elemColaCocina = new ElementoColaCocina(elemPed.getCodElementoPedido(), elemPed.getEstado(), elemPed.getComentario());
                        elemColaCocina.asocia(elemComida);
                        pedido.asocia(elemColaCocina);
                    }else{ //Es una BEBIDA
                        resElem = consultaElem.executeQuery(" SELECT elemento_id, nombre, descripcion, disponible, foto, divi, divi_max, precio FROM elemento WHERE elemento_id IN " +
                                "(SELECT elementoBebida_elemento_elemento_id FROM asociaBebida WHERE elementoColaBar_elementoPedido_elementoPedido_id = " + elemPed.getCodElementoPedido() + ")");
                        resElem.next();
                        elem = new Elemento(resElem.getInt(1), resElem.getString(2), resElem.getString(3), resElem.getBoolean(4), Imagen.blobToImageIcon(new SerialBlob(resElem.getBlob(6)).getBytes(1, (int) resElem.getBlob(1).length())), resElem.getInt(6), resElem.getInt(7), resElem.getFloat(8));
                        //Asociamos las bebidas
                        consultaBebidas = (Statement) this.Conexion.createStatement();
                        resProds = consultaBebidas.executeQuery("SELECT producto_id, nombre, cantidad, maximo, minimo, foto FROM producto WHERE producto_id IN " + "( SELECT productoBebida_producto_producto_id FROM tieneBebida WHERE elementoBebida_elemento_elemento_id IN " + "(SELECT elemento_elemento_id FROM elementoBebida WHERE elemento_elemento_id = " + resElem.getInt(1) + ")) ");
                        HashMap<Bebida,Float> temp = new HashMap();
                        while (resProds.next()) {
                            Bebida bebida = new Bebida(resProds.getInt(1), resProds.getString(2), Imagen.blobToImageIcon(new SerialBlob(resProds.getBlob(6)).getBytes(1, (int) resProds.getBlob(1).length())), resProds.getInt(3), resProds.getInt(4), resProds.getInt(5));
                            temp.put(bebida, new Float(0));
                        }
                        ElementoBebida elemBebida = new ElementoBebida(elem.getCodigoElemento(),temp,elem.getNombre(), elem.getDescripcion(), false, elem.getFoto(), elem.getPrecio(),elem.getDivisiones());
                        ElementoColaBar elemColaBar = new ElementoColaBar(elemPed.getCodElementoPedido(), elemPed.getEstado(), elemPed.getComentario());
                        elemColaBar.asocia(elemBebida);
                        pedido.asocia(elemColaBar);
                    }
                }
                pedidos.add(pedido);
            }
        } catch (SQLException ex) {
            Logger.getLogger(GestorBaseDatos.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            try {
                if(consultaPedidos != null) consultaPedidos.close();
                if(resultado != null) resultado.close();
                if(consultaElemPed != null) consultaElemPed.close();
                if(resElemPed != null) resElemPed.close();
                if(resElem != null) resElem.close();
                if(resProds != null) resProds.close();
                if(consultaIngredientes != null) consultaIngredientes.close();
                if(consultaBebidas != null) consultaBebidas.close();
            } catch (SQLException ex) {
                Logger.getLogger(GestorBaseDatos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return pedidos;
    }

    public boolean eliminaFactura(int codMesa){
        boolean exito = false;
        Statement consulta = null;
        ResultSet resultado = null;
        java.sql.PreparedStatement borrado = null;
        try {
            //Obtenemos los pedidos de la mesa
            consulta = (Statement) this.Conexion.createStatement();
            resultado = consulta.executeQuery(" SELECT pedido_id FROM pedido WHERE mesa_id = "+ codMesa);

            //Para uno de los pedidos obtenemos su factura_id
            if(resultado.next()){
                int pedido_id = resultado.getInt(1);
                resultado = consulta.executeQuery("SELECT factura_factura_id FROM facturaPedido WHERE pedido_pedido_id = "+pedido_id);

                //Si existe la factura para esa mesa, la borramos
                if(resultado.next()){
                    int codFactura = resultado.getInt(1);
                    borrado = this.Conexion.prepareStatement("DELETE facturaPedido FROM facturaPedido WHERE factura_factura_id = "+codFactura);
                    borrado.executeUpdate();
                    borrado.close();
                    borrado = this.Conexion.prepareStatement("DELETE factura FROM factura WHERE factura_id = "+codFactura);
                    borrado.executeUpdate();
                    borrado.close();
                }
            }
            exito = true;
        } catch (SQLException ex) {
            Logger.getLogger(GestorBaseDatos.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            try {
                if(consulta != null) consulta.close();
                if(resultado != null) resultado.close();
                if(borrado != null) borrado.close();
            } catch (SQLException ex) {
                Logger.getLogger(GestorBaseDatos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return exito;
    }

    public int getCodigoMesa(){
        int codigo = -1;
        java.sql.Statement consulta = null;
        ResultSet resultado = null;
        try {
            // Obtenemos el último id que se insertó
            consulta = this.Conexion.createStatement();
            resultado = consulta.executeQuery("SELECT MAX(mesa_id) FROM pedido");
            resultado.next();
            int codMesa = resultado.getInt(1)+1;
            codigo = codMesa;
        } catch (SQLException ex) {
            Logger.getLogger(GestorBaseDatos.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            try {
                if(consulta != null) consulta.close();
                if(resultado != null) resultado.close();
            } catch (SQLException ex) {
                Logger.getLogger(GestorBaseDatos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return codigo;

    }

    public DefaultCategoryDataset elementosAfectadosFaltaProductos(Timestamp i, Timestamp f){
        DefaultCategoryDataset elementosAfectados = new DefaultCategoryDataset();
        Producto producto;
        HashSet<Elemento> listaElementos;
        int numeroElementos;
        Timestamp fecha = Timestamp.valueOf("0000-00-00 00:00:00");
        String fechaI;
        String fechaF;
        ConvertirFecha unafecha = new ConvertirFecha();
        java.sql.Statement consulta = null;
        ResultSet listaProductos = null;
        try {
         consulta = this.Conexion.createStatement();
         fechaI = unafecha.obtieneAnioMesDia(i);
         fechaF = unafecha.obtieneAnioMesDia(f);
         listaProductos = consulta.executeQuery("SELECT producto.producto_id, producto.cantidad,"+
                                                             " producto.foto, producto.maximo, producto.minimo,"+
                                                             " producto.nombre FROM producto, pedidoProveedor, tienePedido"+
                                                             " WHERE producto.producto_id = tienePedido.producto_producto_id"+
                                                             " AND tienePedido.pedidoProveedor_pedido_proveedor_id = pedidoProveedor.pedido_proveedor_id"+
                                                             " AND pedidoProveedor.fecha_pedido BETWEEN" +fechaI+" AND "+fechaF);
            //recorrer todos los productos seleccionados
            while(listaProductos.next()){
                producto = new Producto( Imagen.blobToImageIcon(listaProductos.getBytes(3)), listaProductos.getString(6), listaProductos.getFloat(5), listaProductos.getFloat(4), listaProductos.getFloat(2), listaProductos.getInt(1));
                listaElementos = obtieneElementosConProducto(producto);
                numeroElementos = listaElementos.size();
                elementosAfectados.setValue(numeroElementos,producto.getNombre(),producto.getNombre());
            }

        } catch (SQLException ex) {
            Logger.getLogger(GestorBaseDatos.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            try {
                if(consulta != null) consulta.close();
                if(listaProductos != null) listaProductos.close();
            } catch (SQLException ex) {
                Logger.getLogger(GestorBaseDatos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return elementosAfectados;
    }

    public DefaultCategoryDataset gananciasPorMes(Timestamp i, Timestamp f) {
        DefaultCategoryDataset ganancias = new DefaultCategoryDataset();
        Timestamp fecha = Timestamp.valueOf("0000-00-00 00:00:00");
        String fechaI;
        String fechaF;
        float totalFactura = 0;
        String mesAnio = "";
        ConvertirFecha unafecha = new ConvertirFecha();
        ResultSet tablaFacturas = null;
        java.sql.Statement consulta = null;
        try {
            consulta = this.Conexion.createStatement();
            fechaI = unafecha.obtieneAnioMesDia(i);
            fechaF = unafecha.obtieneAnioMesDia(f);
            
            tablaFacturas = consulta.executeQuery("SELECT factura_id, estado, fecha, totalFactura FROM factura WHERE fecha BETWEEN"+fechaI+" AND "+fechaF);
            Factura factura;

           
           // int fila = 0, col = 0;
            String mesAnt ="-1";
            String mesAct = " ";
            while(tablaFacturas.next())
            {   
                factura = new Factura(tablaFacturas.getInt(1), tablaFacturas.getInt(2), tablaFacturas.getTimestamp(3), tablaFacturas.getFloat(4));
                mesAct=unafecha.mes(factura.getFecha());
                
                if(mesAnt.equals("-1")){
                    totalFactura += factura.getTotalFactura();
                    mesAnt=mesAct;
                    mesAnio = unafecha.mesAnio(factura.getFecha());
                }
                else{
                    if(mesAnt.equals(mesAct)){
                        totalFactura += factura.getTotalFactura();
                        mesAnio = unafecha.mesAnio(factura.getFecha());
                }
                    else{
                        ganancias.setValue(totalFactura, mesAnio, mesAnio);
                        totalFactura = factura.getTotalFactura();
                        mesAnio = unafecha.mesAnio(factura.getFecha());
                        mesAnt = mesAct;
                    }
                }
                ganancias.setValue(totalFactura, mesAnio, mesAnio);
            }

        } catch (SQLException ex) {
            Logger.getLogger(GestorBaseDatos.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            try {
                if(consulta != null) consulta.close();
                if(tablaFacturas != null) tablaFacturas.close();
            } catch (SQLException ex) {
                Logger.getLogger(GestorBaseDatos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return ganancias;
    }

    public DefaultCategoryDataset obtieneListaPlatoMasPedido(Timestamp i, Timestamp f, Seccion s) {
        DefaultCategoryDataset listaPlatos = new DefaultCategoryDataset();
        Timestamp fecha = Timestamp.valueOf("0000-00-00 00:00:00");
        String fechaI;
        String fechaF;
        ConvertirFecha unafecha = new ConvertirFecha();
        ResultSet listaElementos = null;
        java.sql.Statement consulta = null;
        
        try {
            consulta = this.Conexion.createStatement();
            fechaI = unafecha.obtieneAnioMesDia(i);
            fechaF = unafecha.obtieneAnioMesDia(f);
            if (s == null && i == null && f == null) {
                listaElementos = consulta.executeQuery("SELECT elemento.nombre, COUNT(*) FROM pedido, tieneElemento,  asociaPlato, elemento, incluyePlato"
                        + " WHERE pedido.pedido_id =  tieneElemento.pedido_pedido_id AND tieneElemento.elementoPedido_elementoPedido_id"
                        + " = asociaPlato.elementoColaCocina_elementoPedido_elementoPedido_id AND asociaPlato.elementoPlato_elemento_elemento_id"
                        + " = elemento.elemento_id  AND elemento.elemento_id = incluyePlato.elementoPlato_elemento_elemento_id"
                        + " GROUP BY  (elemento.nombre) ORDER BY COUNT(*) DESC LIMIT 0,10");
            } else if (i == null && f == null) {
                listaElementos = consulta.executeQuery("SELECT elemento.nombre, COUNT(*) FROM pedido, tieneElemento,  asociaPlato, elemento, incluyePlato"
                        + " WHERE pedido.pedido_id =  tieneElemento.pedido_pedido_id AND tieneElemento.elementoPedido_elementoPedido_id"
                        + " = asociaPlato.elementoColaCocina_elementoPedido_elementoPedido_id AND asociaPlato.elementoPlato_elemento_elemento_id"
                        + " = elemento.elemento_id  AND elemento.elemento_id = incluyePlato.elementoPlato_elemento_elemento_id"
                        + " GROUP BY  (elemento.nombre) ORDER BY COUNT(*) DESC LIMIT 0,10");

            } else if (s == null) {
                listaElementos = consulta.executeQuery("SELECT elemento.nombre, COUNT(*) FROM pedido, tieneElemento,  asociaPlato, elemento, incluyePlato"
                        + " WHERE pedido.fecha BETWEEN" + fechaI + "AND " + fechaF + "AND pedido.pedido_id = tieneElemento.pedido_pedido_id"
                        + " AND  tieneElemento.elementoPedido_elementoPedido_id = asociaPlato.elementoColaCocina_elementoPedido_elementoPedido_id"
                        + " AND asociaPlato.elementoPlato_elemento_elemento_id = elemento.elemento_id  AND elemento.elemento_id = incluyePlato.elementoPlato_elemento_elemento_id"
                        + " GROUP BY  (elemento.nombre) ORDER BY COUNT(*) DESC LIMIT 0,10");
            } else {
                listaElementos = consulta.executeQuery("SELECT elemento.nombre, COUNT(*) FROM pedido, tieneElemento,  asociaPlato, elemento, incluyePlato"
                        + " WHERE incluyePlato.seccionComida_seccion_seccion_id = " + s.getCodigoSeccion() + " AND pedido.fecha BETWEEN" + fechaI + "AND " + fechaF + "AND pedido.pedido_id"
                        + " =  tieneElemento.pedido_pedido_id AND tieneElemento.elementoPedido_elementoPedido_id = asociaPlato.elementoColaCocina_elementoPedido_elementoPedido_id"
                        + " AND asociaPlato.elementoPlato_elemento_elemento_id = elemento.elemento_id  AND elemento.elemento_id = incluyePlato.elementoPlato_elemento_elemento_id"
                        + " GROUP BY  (elemento.nombre) ORDER BY COUNT(*) DESC LIMIT 0,10");
            }
            //recorrer todos los elementos seleccionados
            while (listaElementos.next()) {
                listaPlatos.setValue((double) listaElementos.getInt(2), listaElementos.getString(1), listaElementos.getString(1));
            }

        } catch (SQLException ex) {
            Logger.getLogger(GestorBaseDatos.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            try {
                if(consulta != null) consulta.close();
                if(listaElementos != null) listaElementos.close();
            } catch (SQLException ex) {
                Logger.getLogger(GestorBaseDatos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return listaPlatos;
    }

    public DefaultCategoryDataset obtieneListaPlatoMenosPedido(Timestamp i, Timestamp f, Seccion s) {
        DefaultCategoryDataset listaPlatos = new DefaultCategoryDataset();
        Timestamp fecha = Timestamp.valueOf("0000-00-00 00:00:00");
        String fechaI;
        String fechaF;
        ConvertirFecha unafecha = new ConvertirFecha();
        ResultSet listaElementos = null;
        java.sql.Statement consulta = null;
        try {
         consulta = this.Conexion.createStatement();
         fechaI = unafecha.obtieneAnioMesDia(i);
         fechaF = unafecha.obtieneAnioMesDia(f);
         
         if(s == null && i == null && f == null){
                  listaElementos   = consulta.executeQuery("SELECT elemento.nombre, COUNT(*) FROM pedido, tieneElemento,  asociaPlato, elemento, incluyePlato"+
                                                           " WHERE pedido.pedido_id =  tieneElemento.pedido_pedido_id AND tieneElemento.elementoPedido_elementoPedido_id = asociaPlato.elementoColaCocina_elementoPedido_elementoPedido_id"+
                                                           " AND asociaPlato.elementoPlato_elemento_elemento_id = elemento.elemento_id  AND elemento.elemento_id = incluyePlato.elementoPlato_elemento_elemento_id"+
                                                           " GROUP BY  (elemento.nombre) ORDER BY COUNT(*) ASC LIMIT 0,10");
         }
         else if(i == null && f == null){
                    listaElementos   = consulta.executeQuery("SELECT elemento.nombre, COUNT(*) FROM pedido, tieneElemento,  asociaPlato, elemento, incluyePlato"+
                                                             " WHERE  incluyePlato.seccionComida_seccion_seccion_id = "+s.getCodigoSeccion()+" AND pedido.pedido_id  = tieneElemento.pedido_pedido_id"+
                                                             " AND  tieneElemento.elementoPedido_elementoPedido_id = asociaPlato.elementoColaCocina_elementoPedido_elementoPedido_id"+
                                                             " AND asociaPlato.elementoPlato_elemento_elemento_id = elemento.elemento_id  AND elemento.elemento_id = incluyePlato.elementoPlato_elemento_elemento_id "+
                                                             "GROUP BY  (elemento.nombre) ORDER BY COUNT(*) ASC LIMIT 0,10");

         }
         else if(s == null){
                    listaElementos   = consulta.executeQuery("SELECT elemento.nombre, COUNT(*) FROM pedido, tieneElemento,  asociaPlato, elemento, incluyePlato"+
                                                             " WHERE pedido.fecha BETWEEN"+fechaI+"AND "+fechaF+"AND pedido.pedido_id = tieneElemento.pedido_pedido_id"+
                                                             " AND  tieneElemento.elementoPedido_elementoPedido_id = asociaPlato.elementoColaCocina_elementoPedido_elementoPedido_id"+
                                                             " AND asociaPlato.elementoPlato_elemento_elemento_id = elemento.elemento_id  AND elemento.elemento_id = incluyePlato.elementoPlato_elemento_elemento_id"+
                                                             " GROUP BY  (elemento.nombre) ORDER BY COUNT(*) ASC LIMIT 0,10");
         }
         else{
                    listaElementos   = consulta.executeQuery("SELECT elemento.nombre, COUNT(*) FROM pedido, tieneElemento,  asociaPlato, elemento, incluyePlato"+
                                                             " WHERE incluyePlato.seccionComida_seccion_seccion_id = "+s.getCodigoSeccion()+" AND pedido.fecha BETWEEN"+fechaI+"AND "+fechaF+
                                                             " AND pedido.pedido_id =  tieneElemento.pedido_pedido_id AND tieneElemento.elementoPedido_elementoPedido_id = asociaPlato.elementoColaCocina_elementoPedido_elementoPedido_id"+
                                                             " AND asociaPlato.elementoPlato_elemento_elemento_id = elemento.elemento_id  AND elemento.elemento_id = incluyePlato.elementoPlato_elemento_elemento_id"+
                                                             " GROUP BY  (elemento.nombre) ORDER BY COUNT(*) ASC LIMIT 0,10");
         }
            //recorrer todos los elemetos seleccionados
            while(listaElementos.next()){
                   listaPlatos.setValue((double)listaElementos.getInt(2),listaElementos.getString(1),listaElementos.getString(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(GestorBaseDatos.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            try {
                if(consulta != null) consulta.close();
                if(listaElementos != null) listaElementos.close();
            } catch (SQLException ex) {
                Logger.getLogger(GestorBaseDatos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return listaPlatos;
    }
}