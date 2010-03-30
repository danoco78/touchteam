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
    int tiempoElaboracion;

    public ElementoPlato(int codigo, ArrayList<Ingrediente> listaIngredientes, String nombre, String descripcion, ImageIcon foto, int tiempoElaboracion, float precio, int divisionesMaximas) {
        super(codigo, descripcion, divisionesMaximas, foto, nombre, precio);
        this.listaIngredientes = listaIngredientes;
        this.tiempoElaboracion = tiempoElaboracion;
    }

    public void modifica(String nombre, String descripcion, ImageIcon foto, int tiempo, float precio, int divisionesMaximas){
        this.setNombre(nombre);
        this.setDescripcion(descripcion);
        this.setFoto(foto);
        this.setTiempoElaboracion(tiempo);
        this.setPrecio(precio);
        this.setDivisionesMaximas(divisionesMaximas);
    }

    public int getTiempoElaboracion() {
        return tiempoElaboracion;
    }

    public void setTiempoElaboracion(int tiempoElaboracion) {
        this.tiempoElaboracion = tiempoElaboracion;
    }



}
