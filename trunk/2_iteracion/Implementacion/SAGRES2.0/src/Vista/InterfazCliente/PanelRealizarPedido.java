/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * PanelRealizarPedido.java
 *
 * Created on 10-may-2010, 20:12:12
 */

package Vista.InterfazCliente;

import GestionCarta.Elemento;

/**
 *
 * @author Carlos
 */
public class PanelRealizarPedido extends javax.swing.JPanel {

    PanelGeneralCliente panelGeneralCliente;

    /** Creates new form PanelRealizarPedido */
    public PanelRealizarPedido(PanelGeneralCliente panelGeneralCliente) {
        initComponents();
        this.panelGeneralCliente=panelGeneralCliente;
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelElementosPedido = new javax.swing.JPanel();
        BotonVerFactura = new javax.swing.JButton();

        setLayout(new java.awt.BorderLayout());

        PanelElementosPedido.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(150, 172, 229), 3));
        PanelElementosPedido.setLayout(new java.awt.GridLayout(10, 0));
        add(PanelElementosPedido, java.awt.BorderLayout.CENTER);

        BotonVerFactura.setFont(new java.awt.Font("Arial", 1, 16));
        BotonVerFactura.setForeground(new java.awt.Color(80, 98, 143));
        BotonVerFactura.setText("Realizar Pedido");
        BotonVerFactura.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(150, 172, 229), 1, true));
        BotonVerFactura.setPreferredSize(new java.awt.Dimension(89, 50));
        BotonVerFactura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                realizarPedido(evt);
            }
        });
        add(BotonVerFactura, java.awt.BorderLayout.SOUTH);
    }// </editor-fold>//GEN-END:initComponents

    private void realizarPedido(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_realizarPedido
        this.panelGeneralCliente.realizarPedido();
    }//GEN-LAST:event_realizarPedido


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotonVerFactura;
    public javax.swing.JPanel PanelElementosPedido;
    // End of variables declaration//GEN-END:variables

    public void anadirElemento(Elemento elementoMarcado) {
        PanelElementosPedido.add(new PanelElementoPedido(elementoMarcado,this));
    }

    public void quitarElemento(PanelElementoPedido panelElementoPedido) {
        PanelElementosPedido.remove(panelElementoPedido);
    }

}
