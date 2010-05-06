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

import utilidades.PanelRelojFecha;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import utilidades.PanelMesaPedido;

/**
 *
 * @author Samuel Guirado Navarro
 */
public class IntColaBar extends javax.swing.JPanel {

    PanelMesaPedido pmp = new PanelMesaPedido();
    
    /** Creates new form IntColaBar */
    public IntColaBar() {
        initComponents();

        pDer.add(new PanelRelojFecha(), new java.awt.GridBagConstraints());
        pmp.setBackground(new java.awt.Color(255, 255, 255));
        pIzq2.add(pmp, java.awt.BorderLayout.CENTER);
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
        pIzq2 = new javax.swing.JPanel();
        margenSup = new javax.swing.JPanel();
        margenInf = new javax.swing.JPanel();
        margenDer = new javax.swing.JPanel();
        margenIzq = new javax.swing.JPanel();
        pDer2 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();

        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(800, 650));
        setOpaque(false);
        setPreferredSize(new java.awt.Dimension(800, 600));
        setLayout(new java.awt.BorderLayout());

        cabecera.setMinimumSize(new java.awt.Dimension(50, 50));
        cabecera.setOpaque(false);
        cabecera.setPreferredSize(new java.awt.Dimension(500, 100));
        cabecera.setLayout(new java.awt.BorderLayout());

        pDer.setMaximumSize(new java.awt.Dimension(230, 100));
        pDer.setMinimumSize(new java.awt.Dimension(230, 100));
        pDer.setOpaque(false);
        pDer.setPreferredSize(new java.awt.Dimension(230, 100));
        pDer.setLayout(new java.awt.GridBagLayout());
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
        bGestBebidas.setMaximumSize(new java.awt.Dimension(170, 80));
        bGestBebidas.setMinimumSize(new java.awt.Dimension(170, 80));
        bGestBebidas.setPreferredSize(new java.awt.Dimension(170, 80));
        pIzq.add(bGestBebidas, new java.awt.GridBagConstraints());
        bGestBebidas.getAccessibleContext().setAccessibleName("GestProductos");

        cabecera.add(pIzq, java.awt.BorderLayout.WEST);

        pCentro.setOpaque(false);
        pCentro.setLayout(new java.awt.GridBagLayout());

        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/InterfazMetre/imagenes/LogoSagres.png"))); // NOI18N
        pCentro.add(logo, new java.awt.GridBagConstraints());

        cabecera.add(pCentro, java.awt.BorderLayout.CENTER);

        add(cabecera, java.awt.BorderLayout.PAGE_START);

        cuerpo.setOpaque(false);
        cuerpo.setLayout(new java.awt.GridLayout(1, 2));

        pIzq2.setOpaque(false);
        pIzq2.setLayout(new java.awt.BorderLayout());

        margenSup.setOpaque(false);
        margenSup.setPreferredSize(new java.awt.Dimension(400, 20));

        javax.swing.GroupLayout margenSupLayout = new javax.swing.GroupLayout(margenSup);
        margenSup.setLayout(margenSupLayout);
        margenSupLayout.setHorizontalGroup(
            margenSupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        margenSupLayout.setVerticalGroup(
            margenSupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );

        pIzq2.add(margenSup, java.awt.BorderLayout.PAGE_START);

        margenInf.setOpaque(false);
        margenInf.setPreferredSize(new java.awt.Dimension(400, 30));

        javax.swing.GroupLayout margenInfLayout = new javax.swing.GroupLayout(margenInf);
        margenInf.setLayout(margenInfLayout);
        margenInfLayout.setHorizontalGroup(
            margenInfLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        margenInfLayout.setVerticalGroup(
            margenInfLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        pIzq2.add(margenInf, java.awt.BorderLayout.PAGE_END);

        margenDer.setOpaque(false);
        margenDer.setPreferredSize(new java.awt.Dimension(50, 500));

        javax.swing.GroupLayout margenDerLayout = new javax.swing.GroupLayout(margenDer);
        margenDer.setLayout(margenDerLayout);
        margenDerLayout.setHorizontalGroup(
            margenDerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );
        margenDerLayout.setVerticalGroup(
            margenDerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );

        pIzq2.add(margenDer, java.awt.BorderLayout.LINE_END);

        margenIzq.setOpaque(false);
        margenIzq.setPreferredSize(new java.awt.Dimension(20, 350));

        javax.swing.GroupLayout margenIzqLayout = new javax.swing.GroupLayout(margenIzq);
        margenIzq.setLayout(margenIzqLayout);
        margenIzqLayout.setHorizontalGroup(
            margenIzqLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );
        margenIzqLayout.setVerticalGroup(
            margenIzqLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );

        pIzq2.add(margenIzq, java.awt.BorderLayout.LINE_START);

        cuerpo.add(pIzq2);

        pDer2.setOpaque(false);
        pDer2.setLayout(new java.awt.GridLayout(1, 2, 20, 0));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 190, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 550, Short.MAX_VALUE)
        );

        pDer2.add(jPanel2);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 190, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 550, Short.MAX_VALUE)
        );

        pDer2.add(jPanel3);

        cuerpo.add(pDer2);

        add(cuerpo, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bGestBebidas;
    private javax.swing.JPanel cabecera;
    private javax.swing.JPanel cuerpo;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel logo;
    private javax.swing.JPanel margenDer;
    private javax.swing.JPanel margenInf;
    private javax.swing.JPanel margenIzq;
    private javax.swing.JPanel margenSup;
    private javax.swing.JPanel pCentro;
    private javax.swing.JPanel pDer;
    private javax.swing.JPanel pDer2;
    private javax.swing.JPanel pIzq;
    private javax.swing.JPanel pIzq2;
    // End of variables declaration//GEN-END:variables

}
