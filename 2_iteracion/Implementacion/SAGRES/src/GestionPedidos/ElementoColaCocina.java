/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package GestionPedidos;

/**
 *
 * @author Gaspar
 */
public class ElementoColaCocina extends ElementoPedido{
     /**
     * La variable estado de un ElementoColaCocina puede ser
     * 0 = En cola
     * 1 = Preparánodse
     * 2 = Preparado
     */
    public static Integer ENCOLA = 0;
    public static Integer PREPARANDOSE = 1;
    public static Integer PREPARADO = 2;
    
    public ElementoColaCocina(){
        super("");
    }
    public ElementoColaCocina(String comentario){
        super(comentario);
    }
}
