package GestionCarta;

import GestionStock.GestionProductos.Bebida;
import java.util.ArrayList;
import javax.swing.ImageIcon;


/**
 *
 * @author Ángel Luis García
 */
public class ElementoBebida extends Elemento{
    public ArrayList<Bebida> listaBebidas;

    public ElementoBebida(int codigo, ArrayList<Bebida> listaBebidas, String nombre, String descripcion, ImageIcon foto, float precio, int divisionesMaximas) {
        super(codigo, descripcion, divisionesMaximas, foto, nombre, precio);
        this.listaBebidas = listaBebidas;
    }

     public void modifica(String nombre, String descripcion, ImageIcon foto, float precio, int divisionesMaximas){
        this.setNombre(nombre);
        this.setDescripcion(descripcion);
        this.setFoto(foto);
        this.setPrecio(precio);
        this.setDivisionesMaximas(divisionesMaximas);
    }
}
