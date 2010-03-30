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
    ArrayList<Seccion> listaSecciones;

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

    public ArrayList<Elemento> corrigeElementosInvalidados() {
        return new ArrayList<Elemento>();
    }

    public void eliminaElementoCarta(int codigoElemento) throws Exception {

        Elemento elemento = null;
        elemento = this.buscaElemento(codigoElemento);
        if (elemento != null)
            listaElementos.remove(elemento);
        else
            throw new Exception("El elemento especificado no existe.");
        
        // Eliminar de la BD

    }

    public int generaCodigoElemento() {
        return 1;
    }

    public ArrayList<Elemento> invalidaElementoCarta(Producto producto) {
        return new ArrayList<Elemento>();
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

    public void nuevoElementoBebida(ArrayList<Bebida> listaBebidas,
            SeccionBebida seccion, String nombre, String descripcion, float precio,
            ImageIcon foto, int divisionesMaximas) {

            int codigoElemento = this.generaCodigoElemento();
            ElementoBebida elementoBebida = new ElementoBebida(codigoElemento,
                    listaBebidas, nombre, descripcion,foto, precio, divisionesMaximas);
            listaElementos.add(elementoBebida);
            seccion.anadeElemento(elementoBebida);

            // Acceso a BD para insertar el elemento
    }

    public void nuevoElementoPlato(ArrayList<Ingrediente> listaIngredientes,
            SeccionComida seccion, String nombre, String descripcion, float precio,
            ImageIcon foto, int tiempoElaboracion, int divisionesMaximas) {

            int codigoElemento = this.generaCodigoElemento();
            ElementoPlato elementoPlato = new ElementoPlato(codigoElemento,
                    listaIngredientes,  nombre, descripcion, foto,
                    tiempoElaboracion, precio, divisionesMaximas);
            listaElementos.add(elementoPlato);
            seccion.anadeElemento(elementoPlato);
           
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
