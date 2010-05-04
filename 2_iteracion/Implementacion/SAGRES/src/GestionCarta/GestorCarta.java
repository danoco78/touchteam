package GestionCarta;


import GestionBaseDatos.ICartaBD;
import GestionStock.GestionProductos.Bebida;
import GestionStock.GestionProductos.IProducto;
import GestionStock.GestionProductos.Ingrediente;
import GestionStock.GestionProductos.Producto;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import utilidades.Imagen;
import java.util.Iterator;
import javax.swing.ImageIcon;
import javax.swing.table.TableModel;


/**
 *
 * @author Ángel Luis García y Carlos Salas
 */
public class GestorCarta implements ICarta {

    ArrayList<Elemento> listaElementos;
    //ArrayList<ElementoBebida> listaElementosBebida;
    //ArrayList<ElementoPlato> listaElementosPlato;
    Carta carta;
    ArrayList<Seccion> listaSecciones;
    ArrayList<SeccionComida> listaSeccionComida;
    ArrayList<SeccionBebida> listaSeccionBebida;
    ICartaBD iCartaBD;
    IProducto producto;

    public GestorCarta(ICartaBD iCartaBD, IProducto iProducto) {
        TableModel tabla, tablaProductos;
        this.iCartaBD = iCartaBD;
        this.producto = iProducto;
        this.listaSecciones = new ArrayList<Seccion>();
        this.listaElementos = new ArrayList<Elemento>();
        // CONSTRUCTORES OBSOLETOS
        // Construimos el objeto Carta

        /*tabla = this.almacen.realizaConsulta("SELECT ultima_modificacion FROM carta");
        this.carta = new Carta((java.sql.Date)tabla.getValueAt(0,0));
        
        // Construimos la lista de Secciones de Bebida
        tabla = this.almacen.realizaConsulta("SELECT seccion.seccion_id, seccion.nombre FROM seccion, seccionbebida WHERE seccion.seccion_id = seccionbebida.seccion_seccion_id");
        for (int i=0;i<tabla.getRowCount();i++) {
            SeccionBebida seccion = new SeccionBebida((Integer)tabla.getValueAt(i,0),(String)tabla.getValueAt(i,1),this.carta);
            this.listaSecciones.add(seccion);
        }
        // Construimos la lista de Secciones de Comida
        tabla = this.almacen.realizaConsulta("SELECT seccion.seccion_id, seccion.nombre FROM seccion, seccioncomida WHERE seccion.seccion_id = seccioncomida.seccion_seccion_id");
        for (int i=0;i<tabla.getRowCount();i++) {
            SeccionComida seccion = new SeccionComida((Integer)tabla.getValueAt(i,0),(String)tabla.getValueAt(i,1),this.carta);
            this.listaSecciones.add(seccion);
        }*/

        
        // Construimos la lista de Elementos con Bebidas
        /*tabla = this.almacen.realizaConsulta("SELECT elemento_id, nombre, descripcion, foto, precio, divi_max FROM elemento, elementobebida WHERE elemento.elemento_id = elementobebida.elemento_elemento_id");
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
        }*/
        // Construimos la lista de Elementos con Platos
        /*tabla = this.almacen.realizaConsulta("SELECT elemento_id, nombre, descripcion, foto, elementoplato.tiempo_elaboracion, precio, divi_max FROM elemento, elementoplato WHERE elemento.elemento_id = elementoplato.elemento_elemento_id");
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
        }*/

        // Construimos la lista de ElementoBebida
        /*tabla = this.almacen.realizaConsulta("SELECT elemento_elemento_id FROM elementobebida");
        this.listaElementosBebida = this.convierteTablaABebida(tabla);*/

        // Construimos la lista de ElementoPlato
        /*tabla = this.almacen.realizaConsulta("SELECT elemento_elemento_id, tiempo_elaboracion FROM elementoplato");
        this.listaElementosPlato = this.convierteTablaAPlato(tabla);*/
        
    }

    public void actualizaDisponibilidadElementos() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public HashSet<Elemento> compruebaElementosInvalidados(HashMap<Producto, Float> listaProductosCantidades) {
        HashSet<Elemento> listaElementos;
        Elemento elemento;
        
        //Obtenemos la lista de elementos invalidados
        listaElementos = this.iCartaBD.obtieneElementosInvalidados();
        
        //Recorremos la lista de elementos
        


        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void deshabilitaElementos(HashSet<Elemento> listaElementos) {
        Iterator iterador = listaElementos.iterator();

        while (iterador.hasNext()){
            Elemento elemento = (Elemento)iterador.next();

            elemento.setDisponible(false);
            if (elemento instanceof ElementoBebida)
                this.iCartaBD.modificaElementoBebida((ElementoBebida)elemento);
            else
                this.iCartaBD.modificaElementoPlato((ElementoPlato)elemento);
        }
    }

    public void eliminaElemento(Elemento elemento) {
        this.iCartaBD.eliminaElemento(elemento);
    }

    public void modificaElemento(Elemento elemento) {
        if (elemento instanceof ElementoBebida)
            this.iCartaBD.modificaElementoBebida((ElementoBebida) elemento);
        else if (elemento instanceof ElementoPlato)
            this.iCartaBD.modificaElementoPlato((ElementoPlato) elemento);
    }

    /**
     * Método que crea en el sistema un nuevo elemento
     * @param elemento Elemento que queremos crear
     */
    public void nuevoElemento(Elemento elemento, Seccion seccion) {
        if (elemento instanceof ElementoBebida)
            this.iCartaBD.nuevoElementoBebida((ElementoBebida) elemento, seccion);
        else
            this.iCartaBD.nuevoElementoPlato((ElementoPlato) elemento, seccion);
    }

    public HashSet<Elemento> obtieneElementosConProducto(Producto producto) {
        return this.iCartaBD.obtieneElementosConProducto(producto);
    }

    public HashSet<Seccion> obtieneSecciones() {
        return this.iCartaBD.obtieneSecciones();
    }




    // MÉTODOS ANTIGUOS DE LA CLASE

    /**
     * Método para
     * @param codigoElemento
     * @return
     */
    /*private Elemento buscaElemento (int codigoElemento) {
        Iterator iterador = listaElementos.iterator();
        Elemento elemento;
        while(iterador.hasNext()){
            elemento = (Elemento)iterador.next();
            if (elemento.getCodigoElemento()==codigoElemento)
                return elemento;
        }
        return null;
    }*/

    /**
     * Método que busca todos los elementos inválidos de la carta
     *
     * @return Un ArrayList con los elementos inválidos.
     */
    /*private ArrayList<Elemento> buscaElementosInvalidados() {
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
    }*/

    /*
     * Funcion que convierte una tabla en un objeto ElementoBebida
     * @param tabla Tabla con los datos de la BD
     * @return Un ElementoBebida
     */
    /*private ArrayList<ElementoBebida> convierteTablaABebida(TableModel tabla) {
        TableModel tablaBebida, tablaDatosElemento;
        String consulta;
        ArrayList<Bebida> listaBebidas = new ArrayList<Bebida>();
        ArrayList listaElementosB = new ArrayList<ElementoBebida>();
        ElementoBebida elementoBebida;
        for (int i=0;i<tabla.getRowCount();i++) {
            // Obtenemos de la BD todas las bebidas del elemento
            consulta = "SELECT producto.producto_id, producto.nombre, producto.foto, producto.minimo, producto.maximo, producto.cantidad FROM tienebebida, producto WHERE" +
                    " tienebebida.productoBebida_producto_producto_id" +
                    " = producto.producto_id AND tienebebida.elementoBebida_elemento_elemento_id ='"+tabla.getValueAt(i,0)+"')";
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
    }*/
    /*
     * Funcion que convierte una tabla en un objeto ElementoPlato
     * @param tabla Tabla con los datos de la BD
     * @return Un ElementoPlato
     */
    /*private ArrayList<ElementoPlato> convierteTablaAPlato(TableModel tabla) {
        TableModel tablaPlato, tablaDatosElemento;
        String consulta;
        ArrayList<Ingrediente> listaIngredientes = new ArrayList<Ingrediente>();
        ArrayList<ElementoPlato> listaElementoP = new ArrayList<ElementoPlato>();
        ElementoPlato elementoPlato;
        for (int i=0;i<tabla.getRowCount();i++) {
            // Obtenemos de la BD todos los ingredientes del elemento
            consulta = "SELECT producto.producto_id, producto.nombre, producto.cantidad, producto.maximo, producto.minimo, producto.foto FROM tieneingrediente, producto WHERE " +
                    "tieneingrediente.productoIngrediente_producto_producto_id" +
                    " = producto.producto_id AND tieneingrediente.elementoComida_elemento_elemento_id ='"+tabla.getValueAt(i,0)+"')";
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
    }*/

    /**
     * Método para habilitar los elementos inválidos después de la llegada del pedido.
     *
     * @return Lista de elmentos arreglados.
     */
    /*public ArrayList<Elemento> corrigeElementosInvalidados() {
        return new ArrayList<Elemento>();
    }*/

    /**
     * Método que elimina un elemento de la carta
     * @param codigoElemento Código del elemento a eliminar
     * @throws Exception El elemento especificado no existe
     * @throws Exception No se pudo eliminar el elemento de la BD
     */
    /*public void eliminaElementoCarta(int codigoElemento) throws Exception {
        String consulta;
        Elemento elemento = null;
        elemento = this.buscaElemento(codigoElemento);
        if (elemento != null)
            listaElementos.remove(elemento);
        else
            throw new Exception("El elemento especificado no existe.");

        consulta = "DELETE FROM elemento WHERE elemento_id="+codigoElemento;
        this.almacen.consultaDeModificacion(consulta);
    }*/


    /*public ArrayList<Elemento> invalidaElementoCarta(Producto producto) {
        Iterator it = this.listaElementos.iterator();
        Iterator itProducto;

        while (it.hasNext()) {
            Elemento elemento = (Elemento)it.next();

            if (elemento instanceof ElementoBebida) {
                itProducto = ((ElementoBebida)elemento).getListaBebidas().iterator();
                while (itProducto.hasNext()) {
                    if (((Producto)itProducto.next()).getCodPro() == producto.getCodPro()) {
                        ((ElementoBebida)elemento).setDisponible(false);
                        this.almacen.consultaDeModificacion("UPDATE elemento SET disponible = 0");
                    }
                }
            }
            else if (elemento instanceof ElementoPlato) {
                itProducto = ((ElementoPlato)elemento).getListaIngredientes().iterator();
                while (itProducto.hasNext()) {
                    if (((Producto)itProducto.next()).getCodPro() == producto.getCodPro()) {
                        ((ElementoPlato)elemento).setDisponible(false);
                        this.almacen.consultaDeModificacion("UPDATE elemento SET disponible = 0");
                    }
                }
            }
        }
        return this.listaElementos;
    }*/

    /**
     * Modifica un Elemento Bebida.
     *
     * @param codigoElemento El código del elemento a modificar.
     * @param nombre El nuevo nombre del elemento.
     * @param descripcion La nueva descripción del elemento.
     * @param foto La nueva foto del elemento.
     * @param precio El nuevo precio del elemento.
     * @param divisionesMaximas Las nuevas divisiones máximas del elemento.
     * @throws Exception Cuando el elemento no existe.
     */
    /*public void modificaElementoBebida(int codigoElemento, String nombre, String descripcion, ImageIcon foto, float precio, int divisionesMaximas ) throws Exception {
        Elemento elemento;
        String consulta;

        elemento = buscaElemento(codigoElemento);
        if ( elemento != null){
            ((ElementoBebida)elemento).modifica(nombre, descripcion, foto, precio, divisionesMaximas);
            consulta = "UPDATE elemento SET nombre = '"+nombre+"', descripcion = '"+descripcion+"', precio = "+precio+", divi_max="+divisionesMaximas+" WHERE elemento.elemento_id = "+codigoElemento;
            this.almacen.consultaDeModificacion(consulta);
            consulta = "UPDATE elemento SET foto = ? WHERE elemento.elemento_id = "+codigoElemento;
            this.almacen.consultaDeModificacionBlob(consulta, Imagen.imageIconToByteArray(foto));
        }
        else{
            throw new Exception("El elemento especificado no existe.");
        }
    }*/

    /**
     * Modifica los datos de un elemento plato.
     *
     * @param codigoElemento El código del elemento que queremos modificar.
     * @param nombre El nuevo nombre del elemento.
     * @param descripcion La nueva descripción del elemento.
     * @param foto La nueva foto del elemento.
     * @param tiempoPreparacion El nuevo tiempo de preparación del elemento.
     * @param precio El nuevo precio del elemento.
     * @param divisionesMaximas Las nuevas divisiones másimas del elemento.
     * @throws Exception Cuando el elemento no existe.
     */
    /*public void modificaElementoPlato(int codigoElemento, String nombre, String descripcion, ImageIcon foto, int tiempoPreparacion, float precio, int divisionesMaximas) throws Exception {
        Elemento elemento;
        String consulta;

        elemento = buscaElemento(codigoElemento);
        if ( elemento != null){
            ((ElementoPlato)elemento).modifica(nombre, descripcion, foto, tiempoPreparacion, precio, divisionesMaximas);
            consulta = "UPDATE elemento SET nombre = '"+nombre+"', descripcion = '"+descripcion+"', precio = "+precio+", divi_max="+divisionesMaximas+" WHERE elemento.elemento_id = "+codigoElemento;
            this.almacen.consultaDeModificacion(consulta);
            consulta = "UPDATE elemento SET foto = ? WHERE elemento.elemento_id = "+codigoElemento;
            this.almacen.consultaDeModificacionBlob(consulta, Imagen.imageIconToByteArray(foto));
            consulta = "UPDATE elementoplato SET tiempo_eleboracion = "+tiempoPreparacion + " WHERE elementoplato.elemento_elemento_id = "+codigoElemento;
        }
        else{
            throw new Exception("El elemento especificado no existe.");
        }
    }*/

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
    /*public void nuevoElementoBebida(ArrayList<Bebida> listaBebidas,
            SeccionBebida seccion, String nombre, String descripcion, float precio,
            ImageIcon foto, int divisionesMaximas) {

            String consulta;
            TableModel tabla;
            // Inserción en la tabla elemento
            ImageIcon defaultPhoto;
            if (foto == null)
                defaultPhoto = new ImageIcon(getClass().getResource("/Imagenes/no_disponible.jpg"));
            else
                defaultPhoto = foto;
            byte[] imagenByte = Imagen.imageIconToByteArray(defaultPhoto); // Pasamos la foto a un array de bytes
            consulta = "INSERT INTO elemento(nombre,descripcion,disponible,divi,divi_max,precio)"+
                    "VALUES ('"+nombre+"','"+descripcion+"',0,'"+divisionesMaximas+"','"+divisionesMaximas+"','"+precio+"')";
            almacen.consultaDeModificacion(consulta);
            // Inserción en la tabla elementoBebida
            // Obtenemos el último id que se insertó
            consulta = "SELECT MAX(elemento_id) FROM elemento";
            tabla = almacen.realizaConsulta(consulta);
            // Sacamos el valor de la tabla y creamos un objeto ElementoBebida
            int id_elemento = (Integer)tabla.getValueAt(0,0);
            almacen.consultaDeModificacionBlob("UPDATE elemento SET foto=? WHERE elemento_id="+id_elemento,imagenByte);

            ElementoBebida elementoBebida = new ElementoBebida(id_elemento, listaBebidas, nombre, descripcion, foto, precio, divisionesMaximas);
            seccion.anadeElemento(elementoBebida);
            this.listaElementos.add(elementoBebida); // Quitarlo si se elimina
            //this.listaElementosBebida.add(elementoBebida);
            consulta = "INSERT INTO elementobebida VALUES("+id_elemento+")";
            almacen.consultaDeModificacion(consulta);
            // Para cada Bebida, sacamos su idBebida e insertamos junto con idElemento en tieneBebida
            Iterator it = listaBebidas.iterator();
            while (it.hasNext()) {
                Producto bebida = (Producto)it.next();
                consulta = "INSERT INTO tienebebida VALUES("+id_elemento+","+bebida.getCodPro()+")";
                almacen.consultaDeModificacion(consulta);
            }
            // Obtenemos elemento de la BD para insertarlo en el multiobjeto
            // consulta = "SELECT elemento_id, nombre, descripcion, foto, precio, divi_max FROM elemento WHERE elemento_id='"+id_elemento+"'";
            //tabla = almacen.realizaConsulta(consulta);
            //ElementoBebida elementoBebida = this.convierteTablaABebida(tabla);


    }*/

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
    /*public void nuevoElementoPlato(ArrayList<Ingrediente> listaIngredientes,
            SeccionComida seccion, String nombre, String descripcion, float precio,
            ImageIcon foto, int tiempoElaboracion, int divisionesMaximas) {

            String consulta;
            TableModel tabla;
            // Inserción en la tabla elemento
            ImageIcon defaultPhoto;
            if (foto == null)
                defaultPhoto = new ImageIcon(getClass().getResource("/Imagenes/no_disponible.jpg"));
            else
                defaultPhoto = foto;
            byte[] imagenByte = Imagen.imageIconToByteArray(defaultPhoto); // Pasamos la foto a un array de bytes
            consulta = "INSERT INTO elemento(nombre,descripcion,disponible,divi,divi_max,precio)"+
                    "VALUES ('"+nombre+"','"+descripcion+"',0,'"+divisionesMaximas+"','"+divisionesMaximas+"','"+precio+"')";
            almacen.consultaDeModificacion(consulta);
            // Inserción en la tabla elementoBebida
            // Obtenemos el último id que se insertó
            consulta = "SELECT MAX(elemento_id) FROM elemento";
            tabla = almacen.realizaConsulta(consulta);
            // Sacamos el valor de la tabla y creamos un objeto ElementoBebida
            int id_elemento = (Integer)tabla.getValueAt(0,0);
            almacen.consultaDeModificacionBlob("UPDATE elemento SET foto=? WHERE elemento_id="+id_elemento,imagenByte);

            ElementoPlato elementoPlato = new ElementoPlato(id_elemento, listaIngredientes, nombre, descripcion, foto, tiempoElaboracion, precio, divisionesMaximas);
            seccion.anadeElemento(elementoPlato);
            this.listaElementos.add(elementoPlato); // Quitarlo si se elimina
            //this.listaElementosPlato.add(elementoPlato);
            consulta = "INSERT INTO elementoplato VALUES('"+id_elemento+"','"+tiempoElaboracion+"')";
            almacen.consultaDeModificacion(consulta);
            // Para cada Ingrediente, sacamos su idIngrediente e insertamos junto con idElemento en tieneIngrediente
            Iterator it = listaIngredientes.iterator();
            while (it.hasNext()) {
                Producto ingrediente = (Producto)it.next();
                consulta = "INSERT INTO tieneingrediente VALUES("+id_elemento+","+ingrediente.getCodPro()+")";
                almacen.consultaDeModificacion(consulta);
            }
            // Obtenemos elemento de la BD para insertarlo en el multiobjeto
            //consulta = "SELECT elemento.elemento_id, elemento.nombre, elemento.descripcion, elemento.foto, elementoPlato.tiempo_elaboracion, elemento.precio, elemento.divi_max FROM" +
            //        " elemento, elementoPlato WHERE elemento.elemento_id = elementoPlato.elemento_elemento_id AND elemento.elemento_id='"+id_elemento+"'";
            //tabla = almacen.realizaConsulta(consulta);
            //ElementoPlato elementoPlato = this.convierteTablaAPlato(tabla);

    }*/

    /**
     * Método que devuelve los elementos de una sección
     * @param seccion Sección de la cual queremos sus elementos
     * @return Lista de elementos de la sección especificada
     */
   /* public ArrayList<Elemento> obtenElementosDeSeccion(Seccion seccion) {
        ArrayList<Elemento> listaElem = new ArrayList<Elemento>();
        TableModel tablaSeccion;
        tablaSeccion = almacen.realizaConsulta("SELECT seccionBebida_seccion_seccion_id, elementoBebida_elemento_elemento_id FROM incluyebebida WHERE seccionBebida_seccion_seccion_id = "+seccion.getCodigoSeccion());
        Iterator itElemento;
        Elemento elemento;
        if (tablaSeccion.getRowCount() > 0) {
            for(int i=0;i<tablaSeccion.getRowCount();i++) {
                itElemento = this.listaElementos.iterator();

                while(itElemento.hasNext()) {
                    elemento = (Elemento)itElemento.next();
                    if ((Integer)tablaSeccion.getValueAt(i,1) == elemento.getCodigoElemento())
                        listaElem.add(elemento);
                }
            }
        }
        tablaSeccion = almacen.realizaConsulta("SELECT seccionComida_seccion_seccion_id, elementoPlato_elemento_elemento_id FROM incluyeplato WHERE seccionComida_seccion_seccion_id = "+seccion.getCodigoSeccion());
        if (tablaSeccion.getRowCount() > 0) {
            for(int i=0;i<tablaSeccion.getRowCount();i++) {
                itElemento = this.listaElementos.iterator();
                while(itElemento.hasNext()) {
                    elemento = (Elemento)itElemento.next();
                    if ((Integer)tablaSeccion.getValueAt(i,1) == elemento.getCodigoElemento()) {
                        listaElem.add(elemento);
                    }
                }
            }
        }
        return listaElem;
    }*/

    /**
     * Método que devuelve los productos de los que está compuesto un elemento
     * @param elemento Elemento del cual queremos obtener sus productos
     * @return Lista de productos del elemento especificado
     */
    /*public ArrayList<Producto> obtenProductosDeElemento(Elemento elemento) {
       ArrayList<Producto> listaProd = new ArrayList<Producto>();
       TableModel tablaElemento;
       String consulta;
       Producto prod;
       // Obtenemos los productos que tiene el elemento si es un Ingrediente
       consulta = "SELECT producto.foto, producto.nombre, producto.minimo, producto.maximo, producto.cantidad, producto.producto_id FROM tieneingrediente, producto WHERE " +
                    "tieneingrediente.productoIngrediente_producto_producto_id" +
                    " = producto.producto_id AND tieneingrediente.elementoComida_elemento_elemento_id ='"+elemento.getCodigoElemento()+"'";
       tablaElemento = this.almacen.realizaConsulta(consulta);
       // Para cada uno de esos elementos lo insertamos en la lista
       if (tablaElemento.getRowCount() > 0) {
           for (int i=0;i<tablaElemento.getRowCount();i++) {
           prod = new Producto(Imagen.blobToImageIcon((byte [])tablaElemento.getValueAt(i,0)),(String)tablaElemento.getValueAt(i,1), (Float)tablaElemento.getValueAt(i,2),
                   (Float)tablaElemento.getValueAt(i,3), (Float)tablaElemento.getValueAt(i,4), (Integer)tablaElemento.getValueAt(i,5));
           listaProd.add(prod);
           }
       }
       // Obtenemos todos los productos que tiene el elemento  si es una bebida
       consulta = "SELECT producto.foto, producto.nombre, producto.minimo, producto.maximo, producto.cantidad, producto.producto_id FROM tienebebida, producto WHERE" +
                    " tienebebida.productoBebida_producto_producto_id" +
                    " = producto.producto_id AND tienebebida.elementoBebida_elemento_elemento_id ='"+elemento.getCodigoElemento()+"'";
       tablaElemento = this.almacen.realizaConsulta(consulta);
       // Para cada uno de esos elementos lo insertamos en la lista
       if (tablaElemento.getRowCount() > 0) {
           for (int i=0;i<tablaElemento.getRowCount();i++) {
           prod = new Producto(Imagen.blobToImageIcon((byte [])tablaElemento.getValueAt(i,0)),(String)tablaElemento.getValueAt(i,1), (Float)tablaElemento.getValueAt(i,2),
                   (Float)tablaElemento.getValueAt(i,3), (Float)tablaElemento.getValueAt(i,4), (Integer)tablaElemento.getValueAt(i,5));
           listaProd.add(prod);
           }
       }

       return listaProd;
    }*/

    /**
     * Método que devuelve los productos existentes en una sección
     * @param seccion Sección de la cual queremos obtener los productos
     * @return Lista de productos existentes en una sección
     */
    /*public ArrayList<Producto> obtenProductosDeSeccion(Seccion seccion) {
        ArrayList<Producto> listaProd = new ArrayList<Producto>();
        TableModel tabla, tablaCodProd, tablaProd;
        Producto prod;
        // Comprobamos si la seccion pertenece a una seccionBebida
        tabla = this.almacen.realizaConsulta("SELECT seccion_seccion_id FROM seccionbebida WHERE seccion_seccion_id ="+seccion.getCodigoSeccion());
        if (tabla.getRowCount() > 0) {
            // Obtenemos todos los productos pertenecientes a seccionBebida
            tablaCodProd = this.almacen.realizaConsulta("SELECT tienebebida.productoBebida_producto_producto_id  FROM incluyebebida, seccionbebida, tienebebida " +
                    "WHERE incluyebebida.seccionBebida_seccion_seccion_id = seccionbebida.seccion_seccion_id AND incluyebebida.elementoBebida_elemento_elemento_id = tienebebida.elementoBebida_elemento_elemento_id");
            // Para cada uno de los productos buscamos sus datos e insertamos en la lista
            for(int i=0;i<tablaCodProd.getRowCount();i++) {
                tablaProd = this.almacen.realizaConsulta("SELECT foto, nombre, minimo, maximo, cantidad, producto_id FROM producto WHERE producto_id ="+(Integer)tablaCodProd.getValueAt(i,0));
                prod = new Producto(Imagen.blobToImageIcon((byte [])tablaProd.getValueAt(0,0)), (String)tablaProd.getValueAt(0,1), (Float)tablaProd.getValueAt(0, 2),
                        (Float)tablaProd.getValueAt(0,3), (Float)tablaProd.getValueAt(0,4), (Integer)tablaProd.getValueAt(0,5));
                listaProd.add(prod);
            }
        }
        // Comprobamos si la seccion pertenece a una seccionComida
        tabla = this.almacen.realizaConsulta("SELECT seccion_seccion_id FROM seccioncomida WHERE seccion_seccion_id ="+seccion.getCodigoSeccion());
        if (tabla.getRowCount() > 0) {
            // Obtenemos todos los productos que pertenecen a seccionComida
            tablaCodProd = this.almacen.realizaConsulta("SELECT DISTINCT tieneingrediente.productoIngrediente_producto_producto_id  FROM incluyeplato, seccioncomida, tieneingrediente " +
                    "WHERE incluyeplato.seccionComida_seccion_seccion_id = seccionComida.seccion_seccion_id AND incluyeplato.elementoPlato_elemento_elemento_id = tieneingrediente.elementoComida_elemento_elemento_id");
           // Para cada uno de ellos obtenemos sus datos e insertamos en la lista
            for(int i=0;i<tablaCodProd.getRowCount();i++) {
                tablaProd = this.almacen.realizaConsulta("SELECT foto, nombre, minimo, maximo, cantidad, producto_id FROM producto WHERE producto_id ="+(Integer)tablaCodProd.getValueAt(i,0));
                prod = new Producto(Imagen.blobToImageIcon((byte [])tablaProd.getValueAt(0,0)), (String)tablaProd.getValueAt(0,1), (Float)tablaProd.getValueAt(0, 2),
                        (Float)tablaProd.getValueAt(0,3), (Float)tablaProd.getValueAt(0,4), (Integer)tablaProd.getValueAt(0,5));
                listaProd.add(prod);
            }
        }
        return listaProd;
    }*/

    /**
     * Método que devuelve las secciones de la carta
     * @return Lista de secciones de la carta
     */
    /*public ArrayList<Seccion> obtenSecciones() {
        return listaSecciones;
    }*/

}
