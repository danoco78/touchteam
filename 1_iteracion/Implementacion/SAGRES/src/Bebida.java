
import javax.swing.ImageIcon;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jose David Dionisio Ruiz
 */
public class Bebida extends Producto{
    private int cantidadPorEnvase;

    public Bebida(int codPro, String nombre, ImageIcon imagen, int minimo, int maximo, int cantidad,int cantidadPorEnvase){
        super(imagen, nombre, minimo, maximo, cantidad, codPro);
        this.cantidadPorEnvase = cantidadPorEnvase;
    }
    public int getCantidadPorEnvase(){
        return this.cantidadPorEnvase;
    }
}
