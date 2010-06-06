/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package utilidades;

import GestionCarta.Elemento;
import GestionCarta.ElementoPlato;
import GestionPedidos.ElementoPedido;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

/**
 *
 * @author Sergio
 */
public class BotonElementoPedidoComentario extends javax.swing.JButton {
    ElementoPedido elem;
    double porcentaje;
    int maxtics;
    private final long tickIni;

    public BotonElementoPedidoComentario(ElementoPedido ele, long tickIni){
        this.elem = ele;
        porcentaje = 0;
        this.tickIni = tickIni;
        if(ele.getElemento() instanceof ElementoPlato){
            this.maxtics = ((ElementoPlato) ele.getElemento()).getTiempoElaboracion()*60;
        }else
            this.maxtics = -1;
        Elemento el = ele.getElemento();
        setBackground(new java.awt.Color(211, 223, 253));
        setFont(new java.awt.Font("Arial", 0, 18));
        setForeground(new java.awt.Color(80, 98, 143));
        setText("<html><body>"+ el.getNombre() +"<br><font color=\"#000000\">" +
                ele.getComentario() +"</font><br></body></html>");
        setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        this.setFocusPainted(false);
        this.setOpaque(false);

    }

    public void repintar(long tick){
        if(this.maxtics >= 0){
            this.porcentaje = ((double)(tick-tickIni))/(double)this.maxtics;
            if(porcentaje > 1)
                porcentaje = 1;
            this.repaint();
        }
    }

    @Override
    public void paint(Graphics g){
        Graphics2D g2 = (Graphics2D) g.create();
        //Rectangle clip1 = g2.getClipBounds();
        Rectangle clip1 = this.getBounds();
        g2.setColor(this.getBackground());
        g2.fillRect(0, 0, clip1.width, clip1.height);

        if(this.maxtics >= 0){
            clip1.width = (int)(((double)clip1.width) * porcentaje);
            int rc = this.getBackground().getRed() - 20,
                    gc = this.getBackground().getGreen() -20,
                    bc = this.getBackground().getBlue() - 15;
            if(rc < 0) rc = 0;
            if(gc < 0) gc = 0;
            if(bc < 0) bc = 0;
            g2.setColor(new Color(rc, gc, bc));
            g2.fillRect(0, 0, clip1.width, clip1.height);
        }

        super.paint(g);
    }
    
    public ElementoPedido getAsociado(){
        return elem;
    }
}
