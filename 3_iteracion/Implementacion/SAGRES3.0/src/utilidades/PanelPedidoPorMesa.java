/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * PanelPedidoPorMesa.java
 *
 * Created on 08-may-2010, 18:11:19
 */

package utilidades;

import GestionPedidos.ElementoColaCocina;
import GestionPedidos.ElementoPedido;
import GestionPedidos.Pedido;
import Vista.DialogoConfirmacion;
import Vista.InterfazCocinero.InterfazCocinero;
import Vista.InterfazCocinero.PreparandosePanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author redder
 */
public class PanelPedidoPorMesa extends javax.swing.JPanel {

    Pedido ped;
    public PreparandosePanel prepPanel;

    /** Creates new form PanelPedidoPorMesa */
    public PanelPedidoPorMesa(Pedido ped, PreparandosePanel padre) {
        this.prepPanel = padre;
        this.ped = ped;
        initComponents();
        
        this.tPedido.setText("    Mesa "+ped.getCodMesa()+", pedido "+ped.getCodPedido());
        this.autoCompletar();
    }

    public void autoCompletar() {
        this.pPedidos.removeAll();
        ArrayList<ElementoPedido> lista = ped.obtieneElementos();
        for (int i = 0; i < lista.size(); ++i) {
            if (lista.get(i) instanceof ElementoColaCocina && lista.get(i).getEstado() == ElementoColaCocina.PREPARANDOSE) {
                BotonElementoPedidoComentario b = new BotonElementoPedidoComentario(lista.get(i), this);
                b.addActionListener(new ManejaEventos(this, b));
                pPedidos.add(b);
                this.pPedidos.add(new PanelEspacioVertical());
            }
        }
    }

    /**
     * Obtiene el pedido que trata el panel
     * @return El pedido que se muestra en el panel
     */
    public Pedido getPedido(){
        return ped;
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pTexto = new javax.swing.JPanel();
        tPedido = new javax.swing.JLabel();
        pPedidos = new javax.swing.JPanel();
        pEspacioIzq = new javax.swing.JPanel();
        pEspacioDer = new javax.swing.JPanel();

        setBackground(new java.awt.Color(235, 235, 255));
        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(150, 172, 229), 3));
        setLayout(new java.awt.BorderLayout());

        pTexto.setOpaque(false);
        pTexto.setLayout(new java.awt.BorderLayout());

        tPedido.setFont(new java.awt.Font("Arial", 1, 11));
        tPedido.setForeground(new java.awt.Color(80, 98, 143));
        tPedido.setText("     Mesa 5, Pedido 2");
        tPedido.setPreferredSize(new java.awt.Dimension(92, 35));
        pTexto.add(tPedido, java.awt.BorderLayout.CENTER);

        add(pTexto, java.awt.BorderLayout.NORTH);

        pPedidos.setOpaque(false);
        pPedidos.setLayout(new javax.swing.BoxLayout(pPedidos, javax.swing.BoxLayout.Y_AXIS));
        add(pPedidos, java.awt.BorderLayout.CENTER);

        pEspacioIzq.setMaximumSize(new java.awt.Dimension(5, 0));
        pEspacioIzq.setMinimumSize(new java.awt.Dimension(5, 0));
        pEspacioIzq.setOpaque(false);
        pEspacioIzq.setPreferredSize(new java.awt.Dimension(5, 0));

        javax.swing.GroupLayout pEspacioIzqLayout = new javax.swing.GroupLayout(pEspacioIzq);
        pEspacioIzq.setLayout(pEspacioIzqLayout);
        pEspacioIzqLayout.setHorizontalGroup(
            pEspacioIzqLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );
        pEspacioIzqLayout.setVerticalGroup(
            pEspacioIzqLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 259, Short.MAX_VALUE)
        );

        add(pEspacioIzq, java.awt.BorderLayout.WEST);

        pEspacioDer.setMaximumSize(new java.awt.Dimension(5, 0));
        pEspacioDer.setMinimumSize(new java.awt.Dimension(5, 0));
        pEspacioDer.setOpaque(false);
        pEspacioDer.setPreferredSize(new java.awt.Dimension(5, 0));

        javax.swing.GroupLayout pEspacioDerLayout = new javax.swing.GroupLayout(pEspacioDer);
        pEspacioDer.setLayout(pEspacioDerLayout);
        pEspacioDerLayout.setHorizontalGroup(
            pEspacioDerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );
        pEspacioDerLayout.setVerticalGroup(
            pEspacioDerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 259, Short.MAX_VALUE)
        );

        add(pEspacioDer, java.awt.BorderLayout.EAST);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel pEspacioDer;
    private javax.swing.JPanel pEspacioIzq;
    private javax.swing.JPanel pPedidos;
    private javax.swing.JPanel pTexto;
    private javax.swing.JLabel tPedido;
    // End of variables declaration//GEN-END:variables

    private class ManejaEventos implements ActionListener {
        private final PanelPedidoPorMesa padre;
        private final BotonElementoPedidoComentario boton;

        public ManejaEventos(PanelPedidoPorMesa padre, BotonElementoPedidoComentario boton) {
            this.padre = padre;
            this.boton = boton;
        }

        public void actionPerformed(ActionEvent e) {

            int codElem = boton.getAsociado().getCodElementoPedido(); //Obtenemos el codigo del Elemento
            //int num = getNumElemento(p, codElem);

            if (hayMasPreparandose(padre.getPedido(), codElem)) { //Hay mas preparandose

            } else { //Es el ultimo
                if (cerrarPedido(padre.getPedido(), padre.prepPanel.ventana)) {
                    /*pPedidos.remove(boton);
                    c.panelColaCocinero.pmpder.decPreparandose();
                    padre.remove(este);
                    padre.repaint();
                    padre.revalidate();*/
                    try {
                        padre.prepPanel.icocinero.seleccionaPlato(padre.getPedido(),
                                (ElementoColaCocina) boton.getAsociado());
                        padre.prepPanel.actualizar();
                    } catch (Exception ex) {
                        Logger.getLogger(PanelPedidoPorMesa.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }

        }

        public boolean cerrarPedido(Pedido p, InterfazCocinero c) {

            String texto = new String();
            ArrayList<ElementoPedido> elems = p.obtieneElementos();
            for (int i = 0; i < elems.size(); i++) {
                if (elems.get(i) instanceof ElementoColaCocina) {
                    texto += elems.get(i).getElemento().getNombre() + "\n";
                }
            }
            DialogoConfirmacion confirmar = new DialogoConfirmacion(c, "Cerrar pedido de cocina", "¿Está seguro de que desea cerrar los platos de este pedido?", texto);
            confirmar.setLocationRelativeTo(c);
            confirmar.setVisible(true);
            if (confirmar.isAceptado()) {
                return true;
            } else {
                return false;
            }
        }

        private boolean hayMasPreparandose(Pedido p, int codElem) {
            ArrayList<ElementoPedido> elementos = p.obtieneElementos();
            for (int i = 0; i < elementos.size(); i++) {
                if (elementos.get(i).getCodElementoPedido() != codElem // No comprobar el elemento que se esta cambiando de estado
                        && elementos.get(i) instanceof ElementoColaCocina
                        && elementos.get(i).getEstado() != ElementoColaCocina.PREPARADO) {
                    return true;
                }
            }
            return false;
        }
    }
}
