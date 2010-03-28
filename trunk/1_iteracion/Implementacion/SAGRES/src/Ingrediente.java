
import javax.swing.ImageIcon;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jose David Dionisio Ruiz
 */
public class Ingrediente extends Producto {

    public Ingrediente(int codPro, String nombre,int cantidad, int maximo, int minimo, ImageIcon imagen){
        super(imagen, nombre, minimo, maximo, cantidad, codPro);
    }

}
