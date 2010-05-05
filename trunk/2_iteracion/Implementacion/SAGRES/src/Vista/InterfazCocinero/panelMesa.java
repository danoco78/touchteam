/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * panelMesa.java
 *
 * Created on 05-may-2010, 0:59:04
 */

package Vista.InterfazCocinero;
import java.awt.*;

/**
 *
 * @author Gaspar
 */
public class panelMesa extends javax.swing.JPanel {

    /** Creates new form panelMesa */
    public panelMesa() {
        initComponents();
    }
    public panelMesa(Pedido p) {
        initComponents();
        String sMesa = crearLabel(p.getCodMesa(), p.getCodPedido());
        this.labelMesa.setText(sMesa);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelMesa = new javax.swing.JLabel();

        labelMesa.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        labelMesa.setForeground(new java.awt.Color(80, 98, 143));
        labelMesa.setText("jLabel1");

        setBackground(new java.awt.Color(245, 245, 255));
        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(150, 172, 229), 5));
        setLayout(new java.awt.GridBagLayout());
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel labelMesa;
    // End of variables declaration//GEN-END:variables


    private String crearLabel(int nmesa, int npedido){
        String text = "Mesa " + String.valueOf(nmesa) + ", pedido " + String.valueOf(npedido);
        return text;
    }
}