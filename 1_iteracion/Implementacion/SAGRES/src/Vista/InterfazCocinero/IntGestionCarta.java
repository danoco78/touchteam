/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * IntGestionCarta.java
 *
 * Created on 28-mar-2010, 17:14:59
 */

package Vista.InterfazCocinero;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

/**
 *
 * @author Daniel
 */
public class IntGestionCarta extends javax.swing.JPanel {

    /** Creates new form IntGestionCarta */
    public IntGestionCarta() {
        initComponents();
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        Rectangle clip = g2.getClipBounds();
        g2.setPaint(new GradientPaint(0.0f, 0.0f, new Color(170, 192, 249) ,0.0f ,getHeight(), new Color(255, 255, 255) ));
        g2.fillRect(clip.x, clip.y, clip.width, clip.height);
    }



    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 51, 51));
        setLayout(new java.awt.BorderLayout());

        jPanel1.setMinimumSize(new java.awt.Dimension(50, 50));
        jPanel1.setOpaque(false);
        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel3.setOpaque(false);
        jPanel3.setPreferredSize(new java.awt.Dimension(200, 100));
        jPanel3.setLayout(new java.awt.GridBagLayout());
        jPanel1.add(jPanel3, java.awt.BorderLayout.EAST);

        jPanel4.setOpaque(false);
        jPanel4.setPreferredSize(new java.awt.Dimension(200, 100));
        jPanel4.setLayout(new java.awt.GridBagLayout());

        jButton1.setText("jButton1");
        jPanel4.add(jButton1, new java.awt.GridBagConstraints());

        jPanel1.add(jPanel4, java.awt.BorderLayout.WEST);

        add(jPanel1, java.awt.BorderLayout.PAGE_START);

        jPanel2.setMinimumSize(new java.awt.Dimension(800, 600));
        jPanel2.setOpaque(false);
        jPanel2.setLayout(new java.awt.GridBagLayout());

        jButton3.setText("jButton3");
        jButton3.setMaximumSize(new java.awt.Dimension(300, 200));
        jButton3.setMinimumSize(new java.awt.Dimension(300, 200));
        jButton3.setPreferredSize(new java.awt.Dimension(300, 200));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(15, 15, 15, 15);
        jPanel2.add(jButton3, gridBagConstraints);

        jButton4.setText("jButton4");
        jButton4.setMaximumSize(new java.awt.Dimension(300, 200));
        jButton4.setMinimumSize(new java.awt.Dimension(300, 200));
        jButton4.setPreferredSize(new java.awt.Dimension(300, 200));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.insets = new java.awt.Insets(15, 15, 15, 15);
        jPanel2.add(jButton4, gridBagConstraints);

        jButton5.setText("jButton5");
        jButton5.setMaximumSize(new java.awt.Dimension(300, 200));
        jButton5.setMinimumSize(new java.awt.Dimension(300, 200));
        jButton5.setPreferredSize(new java.awt.Dimension(300, 200));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(15, 15, 15, 15);
        jPanel2.add(jButton5, gridBagConstraints);

        add(jPanel2, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    // End of variables declaration//GEN-END:variables

}
