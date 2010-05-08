/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package GestionPedidos;

/**
 *
 * @author Gaspar
 */
public class ElementoColaBar extends ElementoPedido{
     /**
     * La variable estado de un ElementoColaBar puede ser
     * 0 = En cola
     * 1 = Preparado
     */
    public static Integer ENCOLA = 0;
    public static Integer PREPARADO = 1;

     /**
     * Constructor por defecto de la clase ElementoColaBar. Crea un elemento con una cadena vacía
     */
    public ElementoColaBar(){
        super("");
    }
     /**
     * Constructor con parámetros de la clase ElementoColaBar. Crea un objeto con un comentario determinado
     *
     * @param comentario
     */
    public ElementoColaBar(String comentario){
        super(comentario);
    }
}
