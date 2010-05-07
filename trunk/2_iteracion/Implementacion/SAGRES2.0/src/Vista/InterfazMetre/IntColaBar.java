/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * IntColaBar.java
 *
 * Created on 06-may-2010, 11:40:36
 */

package Vista.InterfazMetre;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

/**
 *
 * @author Samuel Guirado Navarro
 */
public class IntColaBar extends javax.swing.JPanel {

    /** Creates new form IntColaBar */
    public IntColaBar() {
        initComponents();
    }

    @Override
    public void paint(Graphics g) {
        super.paintComponents(g);
        Graphics2D g2 = (Graphics2D) g.create();
        Rectangle clip = g2.getClipBounds();
        g2.setPaint(new GradientPaint(0.0f, 0.0f, new Color(170, 192, 249) ,getWidth() ,getHeight(), new Color(255, 255, 255) ));
        g2.fillRect(clip.x, clip.y, clip.width, clip.height);
        super.paint(g);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cabecera = new javax.swing.JPanel();
        pDer = new javax.swing.JPanel();
        pIzq = new javax.swing.JPanel();
        bGestBebidas = new javax.swing.JButton();
        pCentro = new javax.swing.JPanel();
        logo = new javax.swing.JLabel();
        cuerpo = new javax.swing.JPanel();

        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(800, 650));
        setOpaque(false);
        setPreferredSize(new java.awt.Dimension(660, 560));
        setLayout(new java.awt.BorderLayout());

        cabecera.setDoubleBuffered(true);
        cabecera.setMinimumSize(new java.awt.Dimension(50, 50));
        cabecera.setOpaque(false);
        cabecera.setPreferredSize(new java.awt.Dimension(500, 100));
        cabecera.setLayout(new java.awt.BorderLayout());

        pDer.setPreferredSize(new java.awt.Dimension(200, 100));

        javax.swing.GroupLayout pDerLayout = new javax.swing.GroupLayout(pDer);
        pDer.setLayout(pDerLayout);
        pDerLayout.setHorizontalGroup(
            pDerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 200, Short.MAX_VALUE)
        );
        pDerLayout.setVerticalGroup(
            pDerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        cabecera.add(pDer, java.awt.BorderLayout.EAST);

        pIzq.setMinimumSize(new java.awt.Dimension(35, 21));
        pIzq.setOpaque(false);
        pIzq.setPreferredSize(new java.awt.Dimension(200, 100));
        pIzq.setLayout(new java.awt.GridBagLayout());

        bGestBebidas.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        bGestBebidas.setForeground(new java.awt.Color(80, 98, 143));
        bGestBebidas.setText("Gestionar Bebidas");
        bGestBebidas.setActionCommand("GestProductos");
        bGestBebidas.setBorder(null);
        bGestBebidas.setPreferredSize(new java.awt.Dimension(170, 80));
        pIzq.add(bGestBebidas, new java.awt.GridBagConstraints());
        bGestBebidas.getAccessibleContext().setAccessibleName("GestProductos");

        cabecera.add(pIzq, java.awt.BorderLayout.WEST);

        pCentro.setLayout(new java.awt.GridBagLayout());

        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/InterfazMetre/imagenes/LogoSagres.png"))); // NOI18N
        pCentro.add(logo, new java.awt.GridBagConstraints());

        cabecera.add(pCentro, java.awt.BorderLayout.CENTER);

        add(cabecera, java.awt.BorderLayout.PAGE_START);

        javax.swing.GroupLayout cuerpoLayout = new javax.swing.GroupLayout(cuerpo);
        cuerpo.setLayout(cuerpoLayout);
        cuerpoLayout.setHorizontalGroup(
            cuerpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 800, Short.MAX_VALUE)
        );
        cuerpoLayout.setVerticalGroup(
            cuerpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 550, Short.MAX_VALUE)
        );

        add(cuerpo, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bGestBebidas;
    private javax.swing.JPanel cabecera;
    private javax.swing.JPanel cuerpo;
    private javax.swing.JLabel logo;
    private javax.swing.JPanel pCentro;
    private javax.swing.JPanel pDer;
    private javax.swing.JPanel pIzq;
    // End of variables declaration//GEN-END:variables

}
