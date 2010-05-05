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
public class Ingrediente extends Producto {

    /**
     * Construye un objeto Ingrediente con el estado especificado con los parametros.
     * @param codPro Codigo identificador del ingrediente
     * @param nombre Nombre del ingrediente
     * @param cantidad Cantidad inicial en stock
     * @param minimo Minimo de unidades que debe haber en stock del ingrediente
     * @param maximo Maximo de unidades que debe haber en stock del ingrediente
     * @param imagen Imagen del ingrediente que queremos añadir
     */
    public Ingrediente(int codPro, String nombre,float cantidad, float maximo, float minimo, ImageIcon imagen){
        super(imagen, nombre, minimo, maximo, cantidad, codPro);
    }

}
