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

    public ElementoColaBar(String comentario){
        super(comentario);
    }
}
