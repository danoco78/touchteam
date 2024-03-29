/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * PanelElementoPedido.java
 *
 * Created on 10-may-2010, 20:34:41
 */

package Vista.InterfazCliente;

import GestionCarta.Elemento;
import GestionPedidos.ElementoPedido;

/**
 *
 * @author Carlos
 */
public class PanelElementoPedido extends javax.swing.JPanel {

    PanelRealizarPedido panelRealizarPedido;
    ElementoPedido elementoPedido;
    Elemento elemento;

    /** Creates new form PanelElementoPedido */
    public PanelElementoPedido(ElementoPedido elementoPedido, Elemento elemento, PanelRealizarPedido panelRealizarPedido) {
        initComponents();
        this.LabelNombreElemento.setText(elemento.getNombre());
        this.panelRealizarPedido=panelRealizarPedido;
        this.elementoPedido=elementoPedido;
        this.elemento=elemento;
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        LabelNombreElemento = new javax.swing.JLabel();
        BotonQuitarElemento = new javax.swing.JButton();

        setLayout(new java.awt.BorderLayout());

        LabelNombreElemento.setText("jLabel1");
        LabelNombreElemento.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        add(LabelNombreElemento, java.awt.BorderLayout.CENTER);

        BotonQuitarElemento.setFont(new java.awt.Font("Arial", 1, 40)); // NOI18N
        BotonQuitarElemento.setText("X");
        BotonQuitarElemento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quitarElemento(evt);
            }
        });
        add(BotonQuitarElemento, java.awt.BorderLayout.EAST);
    }// </editor-fold>//GEN-END:initComponents

    private void quitarElemento(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quitarElemento
        panelRealizarPedido.quitarElemento(this);
    }//GEN-LAST:event_quitarElemento


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotonQuitarElemento;
    private javax.swing.JLabel LabelNombreElemento;
    // End of variables declaration//GEN-END:variables

}
