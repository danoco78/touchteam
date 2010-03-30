package GestionCarta;


import GestionStock.GestionProductos.Bebida;
import GestionStock.GestionProductos.Ingrediente;
import GestionStock.GestionProductos.Producto;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.ImageIcon;


/**
 *
 * @author Ángel Luis García y Carlos Salas
 */
public class GestorCarta implements IPreparaCarta, ICarta {

    ArrayList<Elemento> listaElementos;
    Carta carta;

    public GestorCarta() {
        this.listaElementos = new ArrayList<Elemento>();
        this.carta = new Carta();
    }

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
    private ArrayList<Elemento> buscaElementosInvalidados() {
        return new ArrayList<Elemento>();
    }

    private boolean compruebaDatosBebida(String nombre, String descripcion,
            float precio, ImageIcon foto, int divisionesMaximas) {
            return true;
    }

    private boolean compruebaDatosPlato(String nombre, String descripcion,
            float precio, float tiempoElaboracion, ImageIcon foto,
            int divisionesMaximas) {
            return true;
    }

    public ArrayList<Elemento> corrigeElementosInvalidados() {
        return new ArrayList<Elemento>();
    }

    public void eliminaElementoCarta(int codigoElemento) {

        boolean encontrado = false;
        Elemento elemento = null;
        Iterator it = listaElementos.iterator();
        // Mientras haya elementos y no encontremos el que buscamos
        while (it.hasNext() && !encontrado) {
            elemento = (Elemento)it.next();
            /* Comprobamos si el código del elemento extraido se corresponde
             * con el código recibido como parámetro. Si es así salimos del bucle
             */
            if (elemento.getCodigoElemento() == codigoElemento)
                encontrado = true;
        }
        if (encontrado == true)
            listaElementos.remove(elemento);
        /* else
             Lanzar excepción no existe elemento */

        // Eliminar de la BD

    }

    public int generaCodigoElemento() {
        return 1;
    }

    public ArrayList<Elemento> invalidaElementoCarta(Producto producto) {
        return new ArrayList<Elemento>();
    }

    public void modificaElementoBebida(int codigoElemento, String nombre, String descripcion, ImageIcon foto, float precio, int divisionesMaximas ) {
        Elemento elemento;

        elemento = buscaElemento(codigoElemento);
        if ( elemento != null){
            elemento.modifica(nombre, descripcion, foto, precio, divisionesMaximas);
        }
        /*else{
            Lanzar Execpcion
        }*/
    }

    public void modificaElementoPlato(int codigoElemento, String nombre,
            String descripcion, ImageIcon foto, int tiempoPreparacion,
            float precio, int divisionesMaximas) {}

    public void nuevoElementoBebida(ArrayList<Bebida> listaBebidas,
            Seccion seccion, String nombre, String descripcion, float precio,
            ImageIcon foto, int divisionesMaximas) {

        // Comprobación que el elemento es correcto

            int codigoElemento = this.generaCodigoElemento();
            ElementoBebida elementoBebida = new ElementoBebida(codigoElemento,
                    listaBebidas, nombre, descripcion,foto, precio, divisionesMaximas);
            listaElementos.add(elementoBebida);

            // Acceso a BD para insertar el elemento
    }

    public void nuevoElementoPlato(ArrayList<Ingrediente> listaIngredientes,
            Seccion seccion, String nombre, String descripcion, float precio,
            ImageIcon foto, int tiempoElaboracion, int divisionesMaximas) {

            // Comprobación que el elemento es correcto
            int codigoElemento = this.generaCodigoElemento();
            ElementoPlato elementoPlato = new ElementoPlato(codigoElemento,
                    listaIngredientes,  nombre, descripcion, foto,
                    tiempoElaboracion, precio, divisionesMaximas);
            listaElementos.add(elementoPlato);

            // Acceso a BD para insertar elemento
    }

    public ArrayList<Elemento> obtenElementosDeSeccion(Seccion seccion) {
        return new ArrayList<Elemento>();
    }

    public ArrayList<Producto> obtenProductosDeElemento(Elemento elemento) {
        return new ArrayList<Producto>();
    }

    public ArrayList<Producto> obtenProductosDeSeccion(Seccion seccion) {
        return new ArrayList<Producto>();
    }

    public ArrayList<Seccion> obtenSecciones() {
        return new ArrayList<Seccion>();
    }

}
