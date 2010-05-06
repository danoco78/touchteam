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

        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(150, 360));
        setMinimumSize(new java.awt.Dimension(150, 360));
        setOpaque(false);
        setPreferredSize(new java.awt.Dimension(150, 360));
        setLayout(new java.awt.BorderLayout());

        scrollPane.setBackground(new java.awt.Color(255, 255, 255));
        scrollPane.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        panel.setBackground(new java.awt.Color(255, 255, 255));
        panel.setMinimumSize(new java.awt.Dimension(150, 50));
        panel.setOpaque(false);
        panel.setPreferredSize(new java.awt.Dimension(150, 360));
        panel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 5));
        scrollPane.setViewportView(panel);

        add(scrollPane, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
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
