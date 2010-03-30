
package GestionCarta;

import GestionStock.GestionProductos.Bebida;
import GestionStock.GestionProductos.Ingrediente;
import java.util.ArrayList;
import javax.swing.ImageIcon;

/**
 *
 * @author Ángel Luis García y Carlos Salas
 */
public interface IPreparaCarta {

    public void eliminaElementoCarta(int codigoElemento);

    public void modificaElementoBebida(int codigoElemento, String nombre,
            String descripcion, ImageIcon foto, float precio, int divisionesMaximas );

    public void modificaElementoPlato(int codigoElemento, String nombre,
            String descripcion, ImageIcon foto, int tiempoPreparacion,
            float precio, int divisionesMaximas);

    public void nuevoElementoBebida(ArrayList<Bebida> listaBebidas,
            Seccion seccion, String nombre, String descripcion, float precio,
            ImageIcon foto, int divisionesMaximas);

    public void nuevoElementoPlato(ArrayList<Ingrediente> listaIngredientes,
            Seccion seccion, String nombre, String descripcion, float precio,
            ImageIcon foto, int tiempoElaboracion, int divisionesMaximas);

}
