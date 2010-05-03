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
import com.mysql.jdbc.Statement;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map.Entry;
import java.util.logging.Level;
import java.util.logging.Logger;
import utilidades.Pair;
import com.mysql.jdbc.Connection;
import java.io.ByteArrayInputStream;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import javax.sql.rowset.serial.SerialBlob;
import utilidades.Imagen;

/**
 *
 * @author Ángel Luis García, Carlos Salas, Daniel Guerrero y José David Dionisio
 */
public class GestorBaseDatos implements ICartaBD, IStockBD {

    Connection Conexion;

    public void deshabilitaElementos(HashSet<Elemento> listaElementos) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void eliminaElemento(Elemento elemento) {
        try {
            java.sql.PreparedStatement borrado = this.Conexion.prepareStatement("DELETE FROM elemento WHERE elemento_id=" + elemento.getCodigoElemento());
            borrado.executeUpdate();
        }
        catch (SQLException ex) {
            Logger.getLogger(GestorBaseDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
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

    public void nuevoElementoBebida(ElementoBebida elemento, Seccion seccion) {
        try {
            // Insertamos el elemento
            java.sql.PreparedStatement inserccion = this.Conexion.prepareStatement("INSERT INTO elemento(nombre,descripcion,disponible,divi,divi_max,precio)"+
                    "VALUES ('?','?',?,'?','?','?')");
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
            java.sql.PreparedStatement actualizacion = this.Conexion.prepareStatement("UPDATE elemento SET foto=? WHERE elemento_id="+id_elemento);
            actualizacion.setBinaryStream(1, new ByteArrayInputStream(Imagen.imageIconToByteArray(elemento.getFoto())));
            // Insertamos en elementoBebida
            inserccion = this.Conexion.prepareStatement("INSERT INTO elementobebida VALUES('?')");
            inserccion.setInt(1, id_elemento);
            inserccion.executeUpdate();
            // Para cada Bebida, sacamos su idBebida e insertamos junto con idElemento en tieneBebida
            Iterator it = elemento.getListaBebidas().iterator();
            while (it.hasNext()) {
                Producto bebida = (Producto)it.next();
                inserccion = this.Conexion.prepareStatement("INSERT INTO tienebebida VALUES('?','?')");
                inserccion.setInt(1, id_elemento);
                inserccion.setInt(2, bebida.getCodPro());
                inserccion.executeUpdate();
            }
            // Insertamos el elemento en su sección
            inserccion = this.Conexion.prepareStatement("INSERT INTO incluyebebida VALUES ('?','?')");
            inserccion.setInt(1, seccion.getCodigoSeccion());
            inserccion.setInt(2, id_elemento);
            inserccion.executeUpdate();
        }catch (SQLException ex) {
            Logger.getLogger(GestorBaseDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void nuevoElementoPlato(ElementoPlato elemento, Seccion seccion) {
        try {
            // Insertamos el elemento
            java.sql.PreparedStatement inserccion = this.Conexion.prepareStatement("INSERT INTO elemento(nombre,descripcion,disponible,divi,divi_max,precio)"+
                    "VALUES ('?','?',?,'?','?','?')");
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
            java.sql.PreparedStatement actualizacion = this.Conexion.prepareStatement("UPDATE elemento SET foto=? WHERE elemento_id="+id_elemento);
            actualizacion.setBinaryStream(1, new ByteArrayInputStream(Imagen.imageIconToByteArray(elemento.getFoto())));
            // Insertamos en elementoPlato
            inserccion = this.Conexion.prepareStatement("INSERT INTO elementoplato VALUES('?')");
            inserccion.setInt(1, id_elemento);
            inserccion.executeUpdate();
            // Para cada Ingrediente, sacamos su idIngrediente e insertamos junto con idElemento en tieneIngrediente
            Iterator it = elemento.getListaIngredientes().iterator();
            while (it.hasNext()) {
                Producto ingrediente = (Producto)it.next();
                inserccion = this.Conexion.prepareStatement("INSERT INTO tieneingrediente VALUES('?','?')");
                inserccion.setInt(1, id_elemento);
                inserccion.setInt(2, ingrediente.getCodPro());
                inserccion.executeUpdate();
            }
            // Insertamos el elemento en su sección
            inserccion = this.Conexion.prepareStatement("INSERT INTO incluyeplato VALUES ('?','?')");
            inserccion.setInt(1, seccion.getCodigoSeccion());
            inserccion.setInt(2, id_elemento);
            inserccion.executeUpdate();
        }catch (SQLException ex) {
            Logger.getLogger(GestorBaseDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public HashSet<Elemento> obtieneElementos() {
       HashSet<Elemento> listaElementos = new HashSet<Elemento>();
       ArrayList<Bebida> listaBebida = new ArrayList<Bebida>();
       ArrayList<Ingrediente> listaIngredientes = new ArrayList<Ingrediente>();
       try {
           // Obtenemos todas las bebidas
           java.sql.Statement consulta = this.Conexion.createStatement();
           ResultSet datosElementosBebida = consulta.executeQuery("SELECT elemento.elemento_id, elemento.nombre, elemento.descripcion, elemento.disponible, elemento.foto, elemento.divi, elemento.divi_max, elemento.precio FROM elemento, elementobebida WHERE elemento.elemento_id = elementobebida.elemento_elemento_id");
           while (datosElementosBebida.next()) {
               java.sql.PreparedStatement consulta2 = this.Conexion.prepareStatement("SELECT producto.foto, producto.nombre, producto.minimo, producto.maximo, producto.cantidad, producto.producto_id FROM tienebebida, producto WHERE " +
                    "tienebebida.productoBebida_producto_producto_id" +
                    " = producto.producto_id AND tienebebida.elementoBebida_elemento_elemento_id ="+datosElementosBebida.getInt(1));
               ResultSet datosBebidas = consulta2.executeQuery();
               while (datosBebidas.next()) {
                    Bebida bebida = new Bebida(datosBebidas.getInt(6), datosBebidas.getString(2), Imagen.blobToImageIcon(new SerialBlob(datosBebidas.getBlob(1)).getBytes(1,(int)datosBebidas.getBlob(1).length())), datosBebidas.getFloat(3), datosBebidas.getFloat(4), datosBebidas.getFloat(5));

                    listaBebida.add(bebida);
               }
               // Para obtener la imagen, primero sacamos el blob y con SerialBlob lo pasamos a byte[]
               ElementoBebida elemento = new ElementoBebida(datosElementosBebida.getInt(1), listaBebida, datosElementosBebida.getString(2), datosElementosBebida.getString(3), Imagen.blobToImageIcon(new SerialBlob(datosElementosBebida.getBlob(1)).getBytes(1,(int)datosElementosBebida.getBlob(1).length())), datosElementosBebida.getInt(8), datosElementosBebida.getInt(7));
               listaElementos.add(elemento);
           }

           // Obtenemos todos los platos
           consulta = this.Conexion.createStatement();
           ResultSet datosElementosPlato = consulta.executeQuery("SELECT elemento.elemento_id, elemento.nombre, elemento.descripcion, elemento.disponible, elemento.foto, elemento.divi, elemento.divi_max, elemento.precio, elementoplato.tiempo_elaboracion FROM elemento, elementoplato HERE elemento.elemento_id = elementoplato.elemento_elemento_id");
           while (datosElementosPlato.next()) {
               java.sql.PreparedStatement consulta2 = this.Conexion.prepareStatement("SELECT producto.foto, producto.nombre, producto.minimo, producto.maximo, producto.cantidad, producto.producto_id FROM tieneingrediente, producto WHERE " +
                    "tieneingrediente.productoIngrediente_producto_producto_id" +
                    " = producto.producto_id AND tieneingrediente.elementoComida_elemento_elemento_id ="+datosElementosPlato.getInt(1));
               ResultSet datosIngredientes = consulta2.executeQuery();
               while (datosIngredientes.next()) {
                    Ingrediente ingrediente = new Ingrediente(datosIngredientes.getInt(6), datosIngredientes.getString(2), datosIngredientes.getFloat(5), datosIngredientes.getFloat(3), datosIngredientes.getFloat(4), Imagen.blobToImageIcon(new SerialBlob(datosIngredientes.getBlob(1)).getBytes(1,(int)datosIngredientes.getBlob(1).length())) );
                    listaIngredientes.add(ingrediente);
               }
               // Para obtener la imagen, primero sacamos el blob y con SerialBlob lo pasamos a byte[]
               ElementoPlato elemento = new ElementoPlato(datosElementosPlato.getInt(1), listaIngredientes, datosElementosPlato.getString(2), datosElementosPlato.getString(3), Imagen.blobToImageIcon(new SerialBlob(datosElementosPlato.getBlob(1)).getBytes(1,(int)datosElementosPlato.getBlob(1).length())), datosElementosPlato.getInt(9), datosElementosPlato.getInt(8), datosElementosPlato.getInt(7));
               listaElementos.add(elemento);
           }
       } catch (SQLException ex) {
            Logger.getLogger(GestorBaseDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
       return listaElementos;
    }

     public HashSet<Elemento> obtieneElementosConProducto(Producto producto) {
        HashSet<Elemento> listaElementos = new HashSet<Elemento>();
        ArrayList<Bebida> listaBebida = new ArrayList<Bebida>();
        ArrayList<Ingrediente> listaIngredientes = new ArrayList<Ingrediente>();
        try {
            if (producto instanceof Bebida) {
                // Obtenemos los datos del elementoBebida con ese producto
                java.sql.PreparedStatement consulta = this.Conexion.prepareStatement("SELECT elemento.elemento_id, elemento.nombre, elemento.descripcion, elemento.disponible, elemento.foto, elemento.divi, elemento.divi_max, elemento.precio FROM elemento, tienebebida WHERE elemento.elemento_id = tienebebida.elementoBebida_elemento_elemento_id AND productoBebida_producto_producto_id ="+producto.getCodPro());
                ResultSet datosElementosBebida = consulta.executeQuery();
                while (datosElementosBebida.next()) {
                    java.sql.PreparedStatement consulta2 = this.Conexion.prepareStatement("SELECT producto.foto, producto.nombre, producto.minimo, producto.maximo, producto.cantidad, producto.producto_id FROM tienebebida, producto WHERE " +
                    "tienebebida.productoBebida_producto_producto_id" +
                    " = producto.producto_id AND tienebebida.elementoBebida_elemento_elemento_id ="+datosElementosBebida.getInt(1));
                   ResultSet datosBebidas = consulta2.executeQuery();
                   while (datosBebidas.next()) {
                        Bebida bebida = new Bebida(datosBebidas.getInt(6), datosBebidas.getString(2), Imagen.blobToImageIcon(new SerialBlob(datosBebidas.getBlob(1)).getBytes(1,(int)datosBebidas.getBlob(1).length())), datosBebidas.getFloat(3), datosBebidas.getFloat(4), datosBebidas.getFloat(5));
                        listaBebida.add(bebida);
                   }
                   // Para obtener la imagen, primero sacamos el blob y con SerialBlob lo pasamos a byte[]
                   ElementoBebida elemento = new ElementoBebida(datosElementosBebida.getInt(1), listaBebida, datosElementosBebida.getString(2), datosElementosBebida.getString(3), Imagen.blobToImageIcon(new SerialBlob(datosElementosBebida.getBlob(1)).getBytes(1,(int)datosElementosBebida.getBlob(1).length())), datosElementosBebida.getInt(8), datosElementosBebida.getInt(7));
                   listaElementos.add(elemento);
                }
            }
            else {
                // Obtenemos los datos del elementoPlato con ese producto
                java.sql.PreparedStatement consulta = this.Conexion.prepareStatement("SELECT elemento.elemento_id, elemento.nombre, elemento.descripcion, elemento.disponible, elemento.foto, elemento.divi, elemento.divi_max, elemento.precio, elementoplato.tiempo_elaboracion FROM elemento, elementoplato, tieneingrediente " +
                        "WHERE elemento.elemento_id = elementoplato.elemento_elemento_id AND elemento.elemento_id = elementoComida_elemento_elemento_id AND productoIngrediente_producto_producto_id = "+producto.getCodPro());
                ResultSet datosElementosPlato = consulta.executeQuery();
                while (datosElementosPlato.next()) {
                    java.sql.PreparedStatement consulta2 = this.Conexion.prepareStatement("SELECT producto.foto, producto.nombre, producto.minimo, producto.maximo, producto.cantidad, producto.producto_id FROM tieneingrediente, producto WHERE " +
                    "tieneingrediente.productoIngrediente_producto_producto_id" +
                    " = producto.producto_id AND tieneingrediente.elementoComida_elemento_elemento_id ="+datosElementosPlato.getInt(1));
                    ResultSet datosIngredientes = consulta2.executeQuery();
                    while (datosIngredientes.next()) {
                        Ingrediente ingrediente = new Ingrediente(datosIngredientes.getInt(6), datosIngredientes.getString(2), datosIngredientes.getFloat(5), datosIngredientes.getFloat(3), datosIngredientes.getFloat(4), Imagen.blobToImageIcon(new SerialBlob(datosIngredientes.getBlob(1)).getBytes(1,(int)datosIngredientes.getBlob(1).length())) );
                        listaIngredientes.add(ingrediente);
                    }
                // Para obtener la imagen, primero sacamos el blob y con SerialBlob lo pasamos a byte[]
                    ElementoPlato elemento = new ElementoPlato(datosElementosPlato.getInt(1), listaIngredientes, datosElementosPlato.getString(2), datosElementosPlato.getString(3), Imagen.blobToImageIcon(new SerialBlob(datosElementosPlato.getBlob(1)).getBytes(1,(int)datosElementosPlato.getBlob(1).length())), datosElementosPlato.getInt(9), datosElementosPlato.getInt(8), datosElementosPlato.getInt(7));
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

        String consulta;

        //Primero vemos las bebidas invalidadas
        //SELECT elemento_id, nombre, descripcion, foto, precio, divi_max FROM elemento, elementobebida WHERE elemento.elemento_id = elementobebida.elemento_elemento_id"
        consulta = "SELECT elemento_id, nombre, descripcion, disponible, foto, divi, divi_max, precio FROM elemento, elementobebida WHERE elemento.elemento_id = elementobebida.elemento_elemento_id AND elemento.disponible = 0";
        return elementosInvalidos;
    }

    public HashSet<Seccion> obtieneSecciones() {
        HashSet<Seccion> listaSecciones = new HashSet<Seccion>();
        try {
            // Construimos el objeto Carta necesario para crear una Seccion
            java.sql.Statement consulta = (Statement)this.Conexion.createStatement();
            ResultSet datosCarta = consulta.executeQuery("SELECT ultima_modificacion FROM carta");
            datosCarta.next();
            Carta carta = new Carta((java.sql.Date) datosCarta.getDate(1));
            // Obtenemos todas las secciones de la carta
            consulta = (Statement)this.Conexion.createStatement();
            // Para cada seccion obtenida, creamos su objeto e insertamos en el HashSet
            ResultSet datosSeccion = consulta.executeQuery("SELECT seccion_id, nombre FROM seccion");
            while (datosSeccion.next()) {
                Seccion seccion = new Seccion(datosSeccion.getInt(1), datosSeccion.getString(2), carta);
                listaSecciones.add(seccion);
                
            }
        }
        catch (SQLException ex) {
            Logger.getLogger(GestorBaseDatos.class.getName()).log(Level.SEVERE, null, ex);
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
                try {
            /*Preparamos la consulta de inserccion del pedido*/
            java.sql.PreparedStatement insercion = this.Conexion.prepareStatement( "insert into pedidoproveedor" +
                    "(fecha_pedido,recibido)" +
                    " values ( ? , ?)");
            insercion.setBoolean(2, pedProdveedor.fueRecibido());
            insercion.setDate(1, (Date) pedProdveedor.getFechaPedido());

            /*Preparamos la relacion con los productos pedidos*/
            Statement ultimo = (Statement) this.Conexion.createStatement();
            java.sql.PreparedStatement relacion = this.Conexion.prepareStatement("insert into tienepedido " +
                    "values (?,?,?)");
            Iterator it = pedProdveedor.obtenerInfoPedido().entrySet().iterator();

            //Ejecutamos las consultas
            insercion.executeUpdate();//Insertamos la incidencia
            ResultSet id = ultimo.executeQuery("select MAX(pedido_proveedor_id) from pedidoproveedor"); // Sacamos su ID
            id.next();
            pedProdveedor.setCodigo(id.getInt(1));
            relacion.setInt(1, pedProdveedor.getCodigo()); // Metemeos el ID en la consulta de relacion
            while(it.hasNext()){
                Map.Entry data = (Entry) it.next();
                relacion.setInt(2,((Producto) data.getKey()).getCodPro());
                relacion.setFloat(3,(Float) data.getValue() );
                relacion.executeUpdate();// insertamos la relacion.
            }
        } catch (SQLException ex) {
            Logger.getLogger(GestorBaseDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            Statement pedido = (Statement) this.Conexion.createStatement();
            ResultSet infoPedido = pedido.executeQuery("select pedido_proveedor_id, fecha_pedido, recibido " +
                    "from pedidoproveedor n , (select  MIN(pedido_proveedor_id) min_id from pedidoproveedor where recibido = false) mini " +
                    "where n.pedido_proveedor_id = mini.min_id;");
            infoPedido.next();
            ResultSet tablaproductos = pedido.executeQuery("select producto_id, nombre, producto.cantidad, maximo,minimo, foto, tienepedido.cantidad"+
                    "from producto, tienepedido" +
                    " where pedidoProveedor_pedido_proveedor_id = '" + infoPedido.getInt(1) +
                    "' and producto_producto_id = producto_id;");
            HashMap<Producto,Float> productosCantidad = new HashMap<Producto, Float>();
            while(tablaproductos.next()){
                    Producto producto = new Producto(Imagen.blobToImageIcon(tablaproductos.getBytes(6)),tablaproductos.getString(2),
                    tablaproductos.getFloat(5),tablaproductos.getFloat(4),tablaproductos.getFloat(3),tablaproductos.getInt(1));
                    productosCantidad.put( producto, tablaproductos.getFloat(7) );
            }
            return new PedidoProveedor( infoPedido.getInt(1), productosCantidad, infoPedido.getDate(2), infoPedido.getBoolean(3) );
        } catch (SQLException ex) {
            Logger.getLogger(GestorBaseDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
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
        try {
            Statement actualiza = (Statement) this.Conexion.createStatement();
            actualiza.executeUpdate("update pedidoproveedor set recibido= '1' where pedido_proveedor_id = "+pedProveedor.getCodigo() );
        } catch (SQLException ex) {
            Logger.getLogger(GestorBaseDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void restarCantidadProducto(Pair<Producto, Float> prodCantidad) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}

