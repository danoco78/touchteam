package GestionStock.GestionProductos;


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

    /**
     * Construye un objeto Bebida con el estado especificado con los parametros.
     * @param codPro Codigo identificador de la bebida
     * @param nombre Nombre de la bebida
     * @param imagen Imagen de la bebida que queremos añadir
     * @param minimo Minimo de unidades que debe haber en stock de la bebida
     * @param maximo Maximo de unidades que debe haber en stock de la bebida
     * @param cantidad Cantidad inicial en stock
     */
    public Bebida(int codPro, String nombre, ImageIcon imagen, float minimo, float maximo, float cantidad){
        super(imagen, nombre, minimo, maximo, cantidad, codPro);
    }
}
