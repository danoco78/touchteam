/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * InterfazCliente.java
 *
 * Created on 09-may-2010, 20:28:31
 */

package Vista.InterfazCliente;

import ControladorPrincipal.ICliente;
import java.awt.CardLayout;
import java.awt.Toolkit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import utilidades.PanelImagen;

/**
 *
 * @author Carlos
 */
public class InterfazCliente extends javax.swing.JFrame {

    private ICliente iCliente;
    private PanelGeneralCliente panelGeneralCliente;
    private PanelInicial panelInicial;

    /** Creates new form InterfazCliente */
    public InterfazCliente(ICliente icliente) {
        try {
            initComponents();
            this.iCliente = icliente;
            this.panelGeneralCliente = new PanelGeneralCliente(this,icliente);
            this.panelInicial = new PanelInicial(this);
            this.PanelPrincipal.add("PanelGeneralCliente", this.panelGeneralCliente);
            this.PanelPrincipal.add("PanelInicial", this.panelInicial);
            this.setSize(java.awt.Toolkit.getDefaultToolkit().getScreenSize().width,
                    java.awt.Toolkit.getDefaultToolkit().getScreenSize().height);
            ((CardLayout) this.PanelPrincipal.getLayout()).show(this.PanelPrincipal,"PanelInicial");
            this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        } catch (Exception ex) {
            Logger.getLogger(InterfazCliente.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelPrincipal = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        PanelPrincipal.setLayout(new java.awt.CardLayout(1, 1));
        getContentPane().add(PanelPrincipal, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelPrincipal;
    // End of variables declaration//GEN-END:variables

    public void empezar() {
        ((CardLayout) this.PanelPrincipal.getLayout()).show(this.PanelPrincipal,"PanelGeneralCliente");
    }

}
