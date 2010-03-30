package GestionCarta;


import GestionStock.GestionProductos.Bebida;
import GestionStock.GestionProductos.Ingrediente;
import GestionStock.GestionProductos.Producto;
import java.util.ArrayList;
import javax.swing.ImageIcon;


/**
 *
 * @author Ángel Luis García y Carlos Salas
 */
public class GestorCarta implements IPreparaCarta, ICarta {

    ArrayList<Elemento> elemento;
    Carta carta;

    public GestorCarta() {
        this.elemento = new ArrayList<Elemento>();
        this.carta = new Carta();
    }

    private ArrayList<Elemento>buscaElemento (int codigoElemento) {
        return new ArrayList<Elemento>();
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

    public void eliminaElementoCarta(int codigoElemento) {}

    public int generaCodigoElemento() {
        return 1;
    }

    public ArrayList<Elemento> invalidaElementoCarta(Producto producto) {
        return new ArrayList<Elemento>();
    }

    public void modificaElementoBebida(int codigoElemento, String nombre,
            String descripcion, ImageIcon foto, float precio, float divisionesMaximas ) {

    }

    public void modificaElementoPlato(int codigoElemento, String nombre,
            String descripcion, ImageIcon foto, float tiempoPreparacion,
            float precio, int divisionesMaximas) {}

    public void nuevoElementoBebida(ArrayList<Bebida> listaBebidas,
            String seccion, String nombre, String descripcion, float precio,
            ImageIcon foto, int divisionesMaximas) {}

    public void nuevoElementoPlato(ArrayList<Ingrediente> listaIngredientes,
            String seccion, String nombre, String descripcion, float precio,
            ImageIcon foto, float tiempoElaboracion, int divisionesMaximas) {}

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
