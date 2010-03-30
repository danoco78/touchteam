package GestionCarta;


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

    private ArrayList<Elemento> buscaElementosInvalidados() {
        return new ArrayList<Elemento>();
    }

    public ArrayList<Elemento> corrigeElementosInvalidados() {
        return new ArrayList<Elemento>();
    }

    public void eliminaElementoCarta(int codigoElemento) {}

    public ArrayList<Elemento> invalidaElementoCarta(Producto producto) {
        return new ArrayList<Elemento>();
    }

    public void modificaElementoBebida(int codigoElemento, String nombre,
            String descripcion, ImageIcon foto, float precio, float diviMax ) {}

    public void modificaElementoPlato(int codigoElemento, String nombre,
            String descripcion, ImageIcon foto, float tiempoPreparacion,
            float precio, int diviMax) {}

    public void nuevoElementoBebida(ArrayList<Bebida> listaBebidas,
            String seccion, String nombre, String descripcion, float precio,
            ImageIcon foto, int diviMax) {}

    public void nuevoElementoPlato(ArrayList<Ingrediente> listaIngredientes,
            String seccion, String nombre, String descripcion, float precio,
            ImageIcon foto, float tiempoElaboracion, int diviMax) {}

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
