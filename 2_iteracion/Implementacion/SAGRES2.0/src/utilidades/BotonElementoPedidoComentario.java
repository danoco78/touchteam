/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package utilidades;

import GestionCarta.Elemento;
import GestionPedidos.ElementoPedido;

/**
 *
 * @author redder
 */
public class BotonElementoPedidoComentario extends javax.swing.JButton {

    public BotonElementoPedidoComentario(ElementoPedido ele){
        Elemento el = ele.getElemento();
        setBackground(new java.awt.Color(211, 223, 253));
        setFont(new java.awt.Font("Arial", 0, 10));
        setForeground(new java.awt.Color(80, 98, 143));
        setText("<html>\n<body> \n"+ el.getNombre() +" \n</br>\n<br></br>\n<font color=\"#000000\">" +
                ele.getComentario() +"</font>\n</body>\n</html>\n");
        setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
    }

}
