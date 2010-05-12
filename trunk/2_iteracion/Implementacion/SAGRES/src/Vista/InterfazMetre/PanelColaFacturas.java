/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * PanelColaFacturas.java
 *
 * Created on 06-may-2010, 14:24:16
 */

package Vista.InterfazMetre;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;


/**
 *
 * @author Samuel Guirado Navarro
 */
public class PanelColaFacturas extends javax.swing.JPanel {
    
    /** Creates new form PanelColaFacturas */
    public PanelColaFacturas() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */

    public void addMesa(int codigo){
        JButton boton = new JButton();

        boton.setBackground(new java.awt.Color(211, 223, 253));
        boton.setMaximumSize(new java.awt.Dimension(145, 50));
        boton.setMinimumSize(new java.awt.Dimension(145, 50));
        boton.setPreferredSize(new java.awt.Dimension(145, 50));
        boton.setForeground(new java.awt.Color(80, 98, 143));
        boton.setFont(new java.awt.Font("Arial", 0, 18));
        boton.setText("Mesa "+String.valueOf(codigo));
        boton.addActionListener(new ManejaEventos(boton));

        panel.add(boton);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scrollPane = new javax.swing.JScrollPane();
        panel = new javax.swing.JPanel();
        centro = new javax.swing.JPanel();
        jButton8 = new javax.swing.JButton();
        margenSup = new javax.swing.JPanel();
        margenInf = new javax.swing.JPanel();
        margenDer = new javax.swing.JPanel();
        MargenIzq = new javax.swing.JPanel();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(150, 172, 229)));
        setOpaque(false);
        setLayout(new java.awt.BorderLayout());

        scrollPane.setBackground(new java.awt.Color(255, 255, 255));
        scrollPane.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setOpaque(false);

        panel.setBackground(new java.awt.Color(255, 255, 255));
        panel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(150, 172, 229)));
        panel.setLayout(new java.awt.BorderLayout());

        centro.setOpaque(false);
        centro.setLayout(new javax.swing.BoxLayout(centro, javax.swing.BoxLayout.Y_AXIS));

        jButton8.setBackground(new java.awt.Color(211, 223, 253));
        jButton8.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jButton8.setForeground(new java.awt.Color(80, 98, 143));
        jButton8.setText("Mesa 5");
        jButton8.setMaximumSize(new java.awt.Dimension(3784524, 60));
        centro.add(jButton8);

        panel.add(centro, java.awt.BorderLayout.CENTER);

        margenSup.setOpaque(false);
        margenSup.setPreferredSize(new java.awt.Dimension(10, 5));
        panel.add(margenSup, java.awt.BorderLayout.PAGE_START);

        margenInf.setOpaque(false);
        margenInf.setPreferredSize(new java.awt.Dimension(10, 5));
        panel.add(margenInf, java.awt.BorderLayout.PAGE_END);

        margenDer.setOpaque(false);
        margenDer.setPreferredSize(new java.awt.Dimension(5, 10));
        panel.add(margenDer, java.awt.BorderLayout.LINE_END);

        MargenIzq.setOpaque(false);
        MargenIzq.setPreferredSize(new java.awt.Dimension(5, 10));
        panel.add(MargenIzq, java.awt.BorderLayout.LINE_START);

        scrollPane.setViewportView(panel);

        add(scrollPane, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel MargenIzq;
    private javax.swing.JPanel centro;
    private javax.swing.JButton jButton8;
    private javax.swing.JPanel margenDer;
    private javax.swing.JPanel margenInf;
    private javax.swing.JPanel margenSup;
    private javax.swing.JPanel panel;
    private javax.swing.JScrollPane scrollPane;
    // End of variables declaration//GEN-END:variables

    private class ManejaEventos implements ActionListener{

        JButton padre;

        public ManejaEventos(JButton b){
            padre = b;
        }

        public void actionPerformed(ActionEvent e) {
            panel.remove(padre);
        }
    }
}