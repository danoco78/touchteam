package GestionCarta;

import GestionStock.GestionProductos.Ingrediente;
import java.util.ArrayList;
import javax.swing.ImageIcon;

/**
 *
 * @author Ángel Luis García
 */
public class ElementoPlato extends Elemento {

    ArrayList<Ingrediente> listaIngredientes;
    SeccionComida seccion;
    int tiempoElaboracion;

    public ElementoPlato(int codigo, ArrayList<Ingrediente> listaIngredientes, SeccionComida seccion, String nombre, String descripcion, ImageIcon foto, int tiempoElaboracion, float precio, int divisionesMaximas) {
        super(codigo, descripcion, divisionesMaximas, foto, nombre, precio);
        this.listaIngredientes = listaIngredientes;
        this.seccion = seccion;
        this.tiempoElaboracion = tiempoElaboracion;
    }


}