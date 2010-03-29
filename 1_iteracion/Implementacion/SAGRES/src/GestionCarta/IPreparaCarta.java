
package GestionCarta;

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
            String descripcion, ImageIcon foto, float precio, float diviMax );

    public void modificaElementoPlato(int codigoElemento, String nombre,
            String descripcion, ImageIcon foto, float tiempoPreparacion,
            float precio, int diviMax);

    public void nuevoElementoBebida(ArrayList<ElementoBebida> listaBebidas,
            String seccion, String nombre, String descripcion, float precio,
            ImageIcon foto, int diviMax);

    public void nuevoElementoPlato(ArrayList<Ingrediente> listaIngredientes,
            String seccion, String nombre, String descripcion, float precio,
            ImageIcon foto, float tiempoElaboracion, int diviMax);

}
