/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * imagePanel.java
 *
 * Created on 14-feb-2009, 20:31:05
 */

package utilidades;

import java.awt.image.BufferedImage;

/**
 *
 * @author Boba Fett
 */
public class PanelImagen extends javax.swing.JPanel {

    BufferedImage img;

    public PanelImagen(String imagepath){

        try {
            img = javax.imageio.ImageIO.read(getClass().getResource(imagepath));
            this.setSize(img.getWidth(), img.getHeight());
        } catch (java.io.IOException ex) {
            System.err.println("Imagen no encontrada: " + imagepath);
            this.setSize(0,0);
        }
        this.setPreferredSize(this.getSize());

    }

    @Override
    public void paint(java.awt.Graphics g){
           super.paint(g);
           g.drawImage(img, 0, 0, this);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setOpaque(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

}
