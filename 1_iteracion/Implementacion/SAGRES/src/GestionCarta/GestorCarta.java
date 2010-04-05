package GestionCarta;


import GestionBaseDatos.IAlmacenamiento;
import GestionStock.GestionProductos.Bebida;
import GestionStock.GestionProductos.IProducto;
import GestionStock.GestionProductos.Ingrediente;
import GestionStock.GestionProductos.Producto;
import java.sql.Blob;
import java.util.ArrayList;
import utilidades.Imagen;
import java.util.Iterator;
import javax.swing.ImageIcon;
import javax.swing.table.TableModel;


/**
 *
 * @author Ángel Luis García y Carlos Salas
 */
public class GestorCarta implements IPreparaCarta, ICarta {

    ArrayList<Elemento> listaElementos;
    //ArrayList<ElementoBebida> listaElementosBebida;
    //ArrayList<ElementoPlato> listaElementosPlato;
    Carta carta;
    ArrayList<Seccion> listaSecciones;
    IAlmacenamiento almacen;
    IProducto producto;

    public GestorCarta(IAlmacenamiento iAlmacenamiento, IProducto iProducto) {
        TableModel tabla, tablaProductos;
        this.almacen = iAlmacenamiento;
        this.producto = iProducto;
        this.listaSecciones = new ArrayList<Seccion>();
        this.listaElementos = new ArrayList<Elemento>();
        // Construimos el objeto Carta
        tabla = this.almacen.realizaConsulta("SELECT ultima_modificacion FROM carta");
        this.carta = new Carta((java.sql.Date)tabla.getValueAt(0,0));
        
        // Construimos la lista de Secciones de Bebida
        tabla = this.almacen.realizaConsulta("SELECT seccion.seccion_id, seccion.nombre FROM seccion, seccionbebida WHERE seccion.seccion_id = seccionbebida.seccion_seccion_id");
        for (int i=0;i<tabla.getRowCount();i++) {
            SeccionBebida seccion = new SeccionBebida((String)tabla.getValueAt(i,1),this.carta);
            this.listaSecciones.add(seccion);
        }
        // Construimos la lista de Secciones de Comida
        tabla = this.almacen.realizaConsulta("SELECT seccion.seccion_id, seccion.nombre FROM seccion, seccioncomida WHERE seccion.seccion_id = seccioncomida.seccion_seccion_id");
        for (int i=0;i<tabla.getRowCount();i++) {
            SeccionComida seccion = new SeccionComida((String)tabla.getValueAt(i,1),this.carta);
            this.listaSecciones.add(seccion);
        }


        // Construimos la lista de Elementos con Bebidas
        tabla = this.almacen.realizaConsulta("SELECT elemento_id, nombre, descripcion, foto, precio, divi_max FROM elemento, elementobebida WHERE elemento.elemento_id = elementobebida.elemento_elemento_id");
        ArrayList<Bebida> listaBebida = this.producto.obtenerListaBebidas();
        Iterator itProducto = listaBebida.iterator();
        for (int i=0;i<tabla.getRowCount();i++) {
            ElementoBebida elementoBebida = new ElementoBebida((Integer)tabla.getValueAt(i,0), new ArrayList<Bebida>(),(String)tabla.getValueAt(i, 1), (String)tabla.getValueAt(i, 2),
                 (ImageIcon)Imagen.blobToImageIcon((byte [])tabla.getValueAt(i, 3)), (Float)tabla.getValueAt(i, 4), (Integer)tabla.getValueAt(i, 5));

            tablaProductos = almacen.realizaConsulta("SELECT * FROM tienebebida WHERE elementoBebida_elemento_elemento_id ="+elementoBebida.getCodigoElemento());
            for(int j=0;j<tablaProductos.getRowCount();j++) {
                while (itProducto.hasNext()) {
                    if ((Integer)tablaProductos.getValueAt(j,1) == ((Bebida)itProducto.next()).getCodPro())
                        elementoBebida.listaBebidas.add((Bebida)itProducto.next());
                }
            }
            this.listaElementos.add(elementoBebida);
        }
        // Construimos la lista de Elementos con Platos
        tabla = this.almacen.realizaConsulta("SELECT elemento_id, nombre, descripcion, foto, elementoplato.tiempo_elaboracion, precio, divi_max FROM elemento, elementoplato WHERE elemento.elemento_id = elementoplato.elemento_elemento_id");
        ArrayList<Ingrediente> listaIngredientes = this.producto.obtenerListaIngredientes();
        itProducto = listaIngredientes.iterator();
        for (int i=0;i<tabla.getRowCount();i++) {
            ElementoPlato elementoPlato = new ElementoPlato((Integer)tabla.getValueAt(i,0), new ArrayList<Ingrediente>(),(String)tabla.getValueAt(i, 1), (String)tabla.getValueAt(i, 2),
                 (ImageIcon)Imagen.blobToImageIcon((byte [])tabla.getValueAt(i, 3)),(Integer)tabla.getValueAt(i, 4), (Float)tabla.getValueAt(i, 5), (Integer)tabla.getValueAt(i, 6));
            tablaProductos = almacen.realizaConsulta("SELECT * FROM tieneingrediente WHERE elementoComida_elemento_elemento_id ="+elementoPlato.getCodigoElemento());
            for(int j=0;j<tablaProductos.getRowCount();j++) {
                while (itProducto.hasNext()) {
                    if ((Integer)tablaProductos.getValueAt(j,1) == ((Ingrediente)itProducto.next()).getCodPro())
                        elementoPlato.listaIngredientes.add((Ingrediente)itProducto.next());
                }
            }
            this.listaElementos.add(elementoPlato);
        }

        // Construimos la lista de ElementoBebida
        /*tabla = this.almacen.realizaConsulta("SELECT elemento_elemento_id FROM elementobebida");
        this.listaElementosBebida = this.convierteTablaABebida(tabla);*/

        // Construimos la lista de ElementoPlato
        /*tabla = this.almacen.realizaConsulta("SELECT elemento_elemento_id, tiempo_elaboracion FROM elementoplato");
        this.listaElementosPlato = this.convierteTablaAPlato(tabla);*/
        
    }

    /**
     * Método para
     * @param codigoElemento
     * @return
     */
    private Elemento buscaElemento (int codigoElemento) {
        Iterator iterador = listaElementos.iterator();
        Elemento elemento;
        while(iterador.hasNext()){
            elemento = (Elemento)iterador.next();
            if (elemento.getCodigoElemento()==codigoElemento)
                return elemento;
        }
        return null;
    }

    /**
     * Método que busca todos los elementos inválidos de la carta
     * 
     * @return Un ArrayList con los elementos inválidos.
     */
    private ArrayList<Elemento> buscaElementosInvalidados() {
        ArrayList<Elemento> elementosInvalidos = new ArrayList<Elemento>();
        Iterator iterador;
        Iterator iteradorProductos;
        boolean invalido = false;

        iterador = listaElementos.iterator();
        while(iterador.hasNext()){
            invalido = false;
            if (iterador.next() instanceof ElementoBebida) {
                iteradorProductos = ((ElementoBebida)iterador.next()).listaBebidas.iterator();

                while (iteradorProductos.hasNext() && !invalido){
                    if (((Producto)iteradorProductos.next()).getCantidad() == 0){
                        invalido = true;
                    }
                }
                if (invalido){
                    elementosInvalidos.add((ElementoBebida)iterador.next());
                }
            }
            else if(iterador.next() instanceof ElementoPlato) {
                iteradorProductos = ((ElementoPlato)iterador.next()).listaIngredientes.iterator();

                while (iteradorProductos.hasNext() && !invalido){
                    if (((Producto)iteradorProductos.next()).getCantidad() == 0){
                        invalido = true;
                    }
                }
                if (invalido){
                    elementosInvalidos.add((ElementoPlato)iterador.next());
                }
            }
        }
        return elementosInvalidos;
    }

    /*
     * Funcion que convierte una tabla en un objeto ElementoBebida
     * @param tabla Tabla con los datos de la BD
     * @return Un ElementoBebida
     */
    private ArrayList<ElementoBebida> convierteTablaABebida(TableModel tabla) {
        TableModel tablaBebida, tablaDatosElemento;
        String consulta;
        ArrayList<Bebida> listaBebidas = new ArrayList<Bebida>();
        ArrayList listaElementosB = new ArrayList<ElementoBebida>();
        ElementoBebida elementoBebida;
        for (int i=0;i<tabla.getRowCount();i++) {
            // Obtenemos de la BD todas las bebidas del elemento
            consulta = "SELECT producto.producto_id, producto.nombre, producto.foto, producto.minimo, producto.maximo, producto.cantidad FROM tieneBebida, producto WHERE" +
                    " tieneBebida.productoBebida_producto_producto_id" +
                    " = producto.producto_id AND tieneBebida.elementoBebida_elemento_elemento_id ='"+tabla.getValueAt(i,0)+"')";
            tablaBebida = almacen.realizaConsulta(consulta);
            // Para cada bebida obtenida de la BD, creamos su objeto e insertamos en multiobjeto
            for (int j=0;j<tablaBebida.getRowCount();j++) {
                Bebida bebida = new Bebida((Integer)tablaBebida.getValueAt(j, 0),(String)tablaBebida.getValueAt(j, 1),
                        (ImageIcon)Imagen.blobToImageIcon((byte [])tablaBebida.getValueAt(j, 2)),(Float)tablaBebida.getValueAt(j, 3),
                        (Float)tablaBebida.getValueAt(j, 4), (Float)tablaBebida.getValueAt(j, 5));
                listaBebidas.add(bebida);
            }
            // Obtenemos los datos del elementoBebida e insertamos en la lista de ElementoBebida
            consulta = "SELECT elemento_id, nombre, descripcion, foto, precio, divi_max FROM elemento WHERE elemento_id='"+tabla.getValueAt(i,0)+"'";
            tablaDatosElemento = almacen.realizaConsulta(consulta);
            elementoBebida = new ElementoBebida((Integer)tablaDatosElemento.getValueAt(0,0), listaBebidas, (String)tablaDatosElemento.getValueAt(0,1),
                    (String)tablaDatosElemento.getValueAt(0,2), (ImageIcon)Imagen.blobToImageIcon((byte [])tablaDatosElemento.getValueAt(0,3)),
                    (Float)tablaDatosElemento.getValueAt(0,4),(Integer)tablaDatosElemento.getValueAt(0,5));
            listaElementosB.add(elementoBebida);
        }
        
        return listaElementosB;
    }
    /*
     * Funcion que convierte una tabla en un objeto ElementoPlato
     * @param tabla Tabla con los datos de la BD
     * @return Un ElementoPlato
     */
    private ArrayList<ElementoPlato> convierteTablaAPlato(TableModel tabla) {
        TableModel tablaPlato, tablaDatosElemento;
        String consulta;
        ArrayList<Ingrediente> listaIngredientes = new ArrayList<Ingrediente>();
        ArrayList<ElementoPlato> listaElementoP = new ArrayList<ElementoPlato>();
        ElementoPlato elementoPlato;
        for (int i=0;i<tabla.getRowCount();i++) {
            // Obtenemos de la BD todos los ingredientes del elemento
            consulta = "SELECT producto.producto_id, producto.nombre, producto.cantidad, producto.maximo, producto.minimo, producto.foto FROM tieneIngrediente, producto WHERE " +
                    "tieneIngrediente.productoIngrediente_producto_producto_id" +
                    " = producto.producto_id AND tieneIngrediente.elementoComida_elemento_elemento_id ='"+tabla.getValueAt(i,0)+"')";
            tablaPlato = almacen.realizaConsulta(consulta);
            // Para cada ingrediente obtenido de la BD, creamos el objeto e insertamos en multiobjeto
            for (int j=0;j<tablaPlato.getRowCount();j++) {
                Ingrediente ingrediente = new Ingrediente((Integer)tablaPlato.getValueAt(j, 0),(String)tablaPlato.getValueAt(j, 1),
                        (Float)tablaPlato.getValueAt(j, 2),(Float)tablaPlato.getValueAt(j, 3),
                        (Float)tablaPlato.getValueAt(j, 5), (ImageIcon)Imagen.blobToImageIcon((byte [])tablaPlato.getValueAt(j, 5)));
                listaIngredientes.add(ingrediente);
            }
            // Obtenemos los datos del elemento
            consulta = "SELECT elemento_id, nombre, descripcion, foto, precio, divi_max FROM elemento WHERE elemento_id='"+tabla.getValueAt(i,0)+"'";
            tablaDatosElemento = almacen.realizaConsulta(consulta);
            // Creamos el objeto elementoPlato e insertamos en la lista de ElementoPlato
            elementoPlato = new ElementoPlato((Integer)tablaDatosElemento.getValueAt(0,0), listaIngredientes, (String)tablaDatosElemento.getValueAt(0,1),
                    (String)tablaDatosElemento.getValueAt(0,2), (ImageIcon)Imagen.blobToImageIcon((byte [])tablaDatosElemento.getValueAt(0,3)),
                    (Integer)tabla.getValueAt(i,1),(Float)tablaDatosElemento.getValueAt(0,5),(Integer)tablaDatosElemento.getValueAt(0,6));
            listaElementoP.add(elementoPlato);
        }
        return listaElementoP;
    }

    /**
     * Método para habilitar los elementos inválidos después de la llegada del pedido.
     *
     * @return Lista de elmentos arreglados.
     */
    public ArrayList<Elemento> corrigeElementosInvalidados() {
        return new ArrayList<Elemento>();
    }

    /**
     * Método que elimina un elemento de la carta
     * @param codigoElemento Código del elemento a eliminar
     * @throws Exception El elemento especificado no existe
     * @throws Exception No se pudo eliminar el elemento de la BD
     */
    public void eliminaElementoCarta(int codigoElemento) throws Exception {
        String consulta;
        Elemento elemento = null;
        elemento = this.buscaElemento(codigoElemento);
        if (elemento != null)
            listaElementos.remove(elemento);
        else
            throw new Exception("El elemento especificado no existe.");
      
        consulta = "DELETE FROM elemento WHERE elemento_id='"+codigoElemento+"'";
        almacen.consultaDeModificacion(consulta);
    }


    public ArrayList<Elemento> invalidaElementoCarta(Producto producto) {
        Iterator it = this.listaElementos.iterator();
        Iterator itProducto;
        while (it.hasNext()) {
            if (it.next() instanceof ElementoBebida) {
                itProducto = ((ElementoBebida)it.next()).getListaBebidas().iterator();
                while (itProducto.hasNext()) {
                    if (((Producto)itProducto.next()).getCodPro() == producto.getCodPro()) {
                        ((ElementoBebida)it.next()).setDisponible(false);
                        this.almacen.consultaDeModificacion("UPDATE elemento SET disponible = 0");
                    }
                }
            }
            else if (it.next() instanceof ElementoPlato) {
                itProducto = ((ElementoPlato)it.next()).getListaIngredientes().iterator();
                while (itProducto.hasNext()) {
                    if (((Producto)itProducto.next()).getCodPro() == producto.getCodPro()) {
                        ((ElementoPlato)it.next()).setDisponible(false);
                        this.almacen.consultaDeModificacion("UPDATE elemento SET disponible = 0");
                    }
                }
            }
        }
        return this.listaElementos;
    }

    public void modificaElementoBebida(int codigoElemento, String nombre, String descripcion, ImageIcon foto, float precio, int divisionesMaximas ) throws Exception {
        Elemento elemento;

        elemento = buscaElemento(codigoElemento);
        if ( elemento != null){
            ((ElementoBebida)elemento).modifica(nombre, descripcion, foto, precio, divisionesMaximas);
        }
        else{
            throw new Exception("El elemento especificado no existe.");
        }
    }

    public void modificaElementoPlato(int codigoElemento, String nombre, String descripcion, ImageIcon foto, int tiempoPreparacion, float precio, int divisionesMaximas) throws Exception {
        Elemento elemento;

        elemento = buscaElemento(codigoElemento);
        if ( elemento != null){
            ((ElementoPlato)elemento).modifica(nombre, descripcion, foto, tiempoPreparacion, precio, divisionesMaximas);
        }
        else{
            throw new Exception("El elemento especificado no existe.");
        }
    }

    /**
     * Método que crea en el sistema un nuevo elemento de tipo bebida
     * @param listaBebidas Lista de bebidas que contiene el elemento
     * @param seccion Sección a la que pertenece el elemento
     * @param nombre Nombre del elemento
     * @param descripcion Descripción del elemento
     * @param precio Precio del Elemento
     * @param foto Foto del elemento
     * @param divisionesMaximas Divisiones máximas que puede sufrir el elemento
     */
    public void nuevoElementoBebida(ArrayList<Bebida> listaBebidas,
            SeccionBebida seccion, String nombre, String descripcion, float precio,
            ImageIcon foto, int divisionesMaximas) {

            String consulta;
            TableModel tabla;
            // Inserción en la tabla elemento
            byte[] imagenByte = Imagen.imageIconToByteArray(foto); // Pasamos la foto a un array de bytes
            consulta = "INSERT INTO elemento(nombre,decripcion,disponible,foto,divi,divi_max,precio)"+
                    "VALUES ('"+nombre+"','"+descripcion+"',0,'?','"+divisionesMaximas+"','"+divisionesMaximas+"','"+precio+"')";
            almacen.consultaDeModificacionBlob(consulta, imagenByte);

             // Inserción en la tabla elementoBebida
            // Obtenemos el último id que se insertó
            consulta = "SELECT MAX(elemento_id) FROM elemento";
            tabla = almacen.realizaConsulta(consulta);
            // Sacamos el valor de la tabla y creamos un objeto ElementoBebida
            int id_elemento = (Integer)tabla.getValueAt(0,0);
            ElementoBebida elementoBebida = new ElementoBebida(id_elemento, listaBebidas, nombre, descripcion, foto, precio, divisionesMaximas);
            seccion.anadeElemento(elementoBebida);
            this.listaElementos.add(elementoBebida); // Quitarlo si se elimina
            //this.listaElementosBebida.add(elementoBebida);
            consulta = "INSERT INTO elementoBebida VALUES("+id_elemento+")";
            almacen.consultaDeModificacion(consulta);
            // Para cada Bebida, sacamos su idBebida e insertamos junto con idElemento en tieneBebida
            Iterator it = listaBebidas.iterator();
            while (it.hasNext()) {
                Bebida bebida = (Bebida)it.next();
                consulta = "INSERT INTO tieneBebida VALUES("+id_elemento+","+bebida.getCodPro()+")";
                almacen.consultaDeModificacion(consulta);
            }
            // Obtenemos elemento de la BD para insertarlo en el multiobjeto
            // consulta = "SELECT elemento_id, nombre, descripcion, foto, precio, divi_max FROM elemento WHERE elemento_id='"+id_elemento+"'";
            //tabla = almacen.realizaConsulta(consulta);
            //ElementoBebida elementoBebida = this.convierteTablaABebida(tabla);
            
            
            
    }

    /**
     * Método que crea en el sistema un nuevo elemento de tipo plato
     * @param listaIngredientes Lista de ingredientes que tiene el elemento
     * @param seccion Sección a la que pertenece el elemento
     * @param nombre Nombre del elemento
     * @param descripcion Descripción del elemento
     * @param precio Precio del elemento
     * @param foto Foto del elemento
     * @param tiempoElaboracion Tiempo de elaboración estimado del elemento
     * @param divisionesMaximas Divisiones máximas que puede sufrir el elemento
     */
    public void nuevoElementoPlato(ArrayList<Ingrediente> listaIngredientes,
            SeccionComida seccion, String nombre, String descripcion, float precio,
            ImageIcon foto, int tiempoElaboracion, int divisionesMaximas) {

            String consulta;
            TableModel tabla;
            // Inserción en la tabla elemento
            byte[] imagenByte = Imagen.imageIconToByteArray(foto); // Pasamos la foto a un array de bytes
            consulta = "INSERT INTO elemento(nombre,decripcion,disponible,foto,divi,divi_max,precio)"+
                    "VALUES ('"+nombre+"','"+descripcion+"',0,'?','"+divisionesMaximas+"','"+divisionesMaximas+"','"+precio+"')";
            almacen.consultaDeModificacionBlob(consulta, imagenByte);
            
             // Inserción en la tabla elementoPlato
            // Obtenemos el último id que se insertó
            consulta = "SELECT MAX(elemento_id) FROM elemento";
            tabla = almacen.realizaConsulta(consulta);
            // Sacamos el valor de la tabla y creamos un objeto ElementoPlato
            int id_elemento = (Integer)tabla.getValueAt(0,0);
            ElementoPlato elementoPlato = new ElementoPlato(id_elemento, listaIngredientes, nombre, descripcion, foto, tiempoElaboracion, precio, divisionesMaximas);
            seccion.anadeElemento(elementoPlato);
            this.listaElementos.add(elementoPlato); // Quitarlo si se elimina
            //this.listaElementosPlato.add(elementoPlato);
            consulta = "INSERT INTO elementoPlato VALUES('"+id_elemento+"','"+tiempoElaboracion+"')";
            almacen.consultaDeModificacion(consulta);
            // Para cada Ingrediente, sacamos su idIngrediente e insertamos junto con idElemento en tieneIngrediente
            Iterator it = listaIngredientes.iterator();
            while (it.hasNext()) {
                Ingrediente ingrediente = (Ingrediente)it.next();
                consulta = "INSERT INTO tieneIngrediente VALUES("+id_elemento+","+ingrediente.getCodPro()+")";
                almacen.consultaDeModificacion(consulta);
            }
            // Obtenemos elemento de la BD para insertarlo en el multiobjeto
            //consulta = "SELECT elemento.elemento_id, elemento.nombre, elemento.descripcion, elemento.foto, elementoPlato.tiempo_elaboracion, elemento.precio, elemento.divi_max FROM" +
            //        " elemento, elementoPlato WHERE elemento.elemento_id = elementoPlato.elemento_elemento_id AND elemento.elemento_id='"+id_elemento+"'";
            //tabla = almacen.realizaConsulta(consulta);
            //ElementoPlato elementoPlato = this.convierteTablaAPlato(tabla);
       
    }

    /**
     * Método que devuelve los elementos de una sección
     * @param seccion Sección de la cual queremos sus elementos
     * @return Lista de elementos de la sección especificada
     */
    public ArrayList obtenElementosDeSeccion(Seccion seccion) {
        if (seccion.getClass()==SeccionBebida.class)
            return ((SeccionBebida)seccion).getListaElementoBebida();
        else if (seccion.getClass()==SeccionBebida.class)
            return ((SeccionComida)seccion).getListaElementoPlato();
        return new ArrayList();
    }

    /**
     * Método que devuelve los productos de los que está compuesto un elemento
     * @param elemento Elemento del cual queremos obtener sus productos
     * @return Lista de productos del elemento especificado
     */
    public ArrayList obtenProductosDeElemento(Elemento elemento) {
       if (elemento instanceof ElementoBebida)
           return ((ElementoBebida)elemento).getListaBebidas();
       else
           return ((ElementoPlato)elemento).getListaIngredientes();
    }

    /**
     * Método que devuelve los productos existentes en una sección
     * @param seccion Sección de la cual queremos obtener los productos
     * @return Lista de productos existentes en una sección
     */
    public ArrayList obtenProductosDeSeccion(Seccion seccion) {
        ArrayList productos = new ArrayList();
        if (seccion instanceof SeccionBebida) {
            // Obtenemos la lista de Elementos de la SeccionBebida
            ArrayList<ElementoBebida> listaElementoBebida = ((SeccionBebida)seccion).getListaElementoBebida();
            Iterator it = listaElementoBebida.iterator();
            // Para cada uno de los elementos, obtenemos sus Bebidas
            while (it.hasNext()) {
                ElementoBebida elementoBebida = (ElementoBebida)it.next();
                ArrayList<Bebida> listaBebidas = elementoBebida.getListaBebidas();
                Iterator it2 = listaBebidas.iterator();
                // Cada bebida la guardamos en la lista de productos (producto == bebida)
                while (it2.hasNext()) {
                    Bebida bebida = (Bebida)it2.next();
                    productos.add(bebida);
                }
            }
        }
        else {
            // Obtenemos la lista de Elementos de la SeccionComida
            ArrayList<ElementoPlato> listaElementoPlato = ((SeccionComida)seccion).getListaElementoPlato();
            Iterator it = listaElementoPlato.iterator();
            // Para cada uno de los elementos, obtenemos sus Ingredientes
            while (it.hasNext()) {
                ElementoPlato elementoPlato = (ElementoPlato)it.next();
                ArrayList<Ingrediente> listaIngredientes = elementoPlato.getListaIngredientes();
                Iterator it2 = listaIngredientes.iterator();
                // Cada ingrediente lo guardamos en la lista de productos (producto == ingrediente)
                while (it2.hasNext()) {
                    Ingrediente ingrediente = (Ingrediente)it2.next();
                    productos.add(ingrediente);
                }
            }
        }
        return productos;
    }

    /**
     * Método que devuelve las secciones de la carta
     * @return Lista de secciones de la carta
     */
    public ArrayList<Seccion> obtenSecciones() {
        return listaSecciones;
    }

}
