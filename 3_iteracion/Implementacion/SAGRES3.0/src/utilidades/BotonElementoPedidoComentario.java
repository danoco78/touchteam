/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package utilidades;

import GestionCarta.Elemento;
import GestionPedidos.ElementoPedido;

/**
 *
 * @author Sergio
 */
public class BotonElementoPedidoComentario extends javax.swing.JButton {
    public PanelPedidoPorMesa pedidoPorMesa = null;
    ElementoPedido elem;

    public BotonElementoPedidoComentario(ElementoPedido ele, final PanelPedidoPorMesa padre){
        this.elem = ele;
        this.pedidoPorMesa = padre;
        Elemento el = ele.getElemento();
        setBackground(new java.awt.Color(211, 223, 253));
        setFont(new java.awt.Font("Arial", 0, 16));
        setForeground(new java.awt.Color(80, 98, 143));
        setText("<html><body>"+ el.getNombre() +"<br><font color=\"#000000\">" +
                ele.getComentario() +"</font></body></html>");
        setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        this.setFocusPainted(false);
    }
    public ElementoPedido getAsociado(){
        return elem;
    }
}
