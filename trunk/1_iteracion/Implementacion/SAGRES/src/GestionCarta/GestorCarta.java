package GestionCarta;


import java.util.ArrayList;
import javax.swing.ImageIcon;


/**
 *
 * @author Ángel Luis Garcia y Carlos Salas
 */
public class GestorCarta {

    ArrayList<Elemento> elemento;

    public GestorCarta() {
        this.elemento = new ArrayList<Elemento>();
    }

    private ArrayList<Elemento> buscaElementosInvalidados() {}

    public ArrayList<Elemento> corrigeElementosInvalidados() {}

    public void eliminaElementoCarta(int codigoElemento) {}

    public ArrayList<Elemento> invalidaElementoCarta(Producto producto) {}

    public void modificaElementoBebida(int codigoElemento, String nombre,
            String descripcion, ImageIcon foto, float precio, float diviMax ) {}

    public void modificaElementoPlato(int codigoElemento, String nombre,
            String descripcion, ImageIcon foto, float tiempoPreparacion,
            float precio, int diviMax) {}

    public void nuevoElementoBebida(ArrayList<ElementoBebida> listaBebidas,
            String seccion, String nombre, String descripcion, float precio,
            ImageIcon foto, int diviMax) {}

    public void nuevoElementoPlato(ArrayList<Ingrediente> listaIngredientes,
            String seccion, String nombre, String descripcion, float precio,
            ImageIcon foto, float tiempoElaboracion, int diviMax) {}

    public ArrayList<Elemento> obtenElementosDeSeccion(Seccion seccion) {}

    public ArrayList<Producto> obtenProductosDeElemento(Elemento elemento) {}

    public ArrayList<Producto> obtenProductosDeSeccion(Seccion seccion) {}

    public ArrayList<Seccion> obtenSecciones() {}

}
