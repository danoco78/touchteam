/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * PanelHojasCarta.java
 *
 * Created on 04-may-2010, 16:58:06
 */

package Vista.InterfazCliente;

import ControladorPrincipal.ICliente;
import GestionCarta.Elemento;
import Vista.InterfazCliente.PanelElementoCarta;
import java.awt.BorderLayout;

/**
 *
 * @author Carlos
 */
public class PanelHojasCarta extends javax.swing.JPanel {

    private ICliente icliente;

    /** Creates new form PanelHojasCarta */
    public PanelHojasCarta() throws Exception {
        initComponents();
        CargarCarta();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelHojaIzquierda = new javax.swing.JPanel();
        PanelElementoArriba = new javax.swing.JPanel();
        PanelElementoCentro = new javax.swing.JPanel();
        PanelElementoAbajo = new javax.swing.JPanel();
        PanelHojaDerecha = new javax.swing.JPanel();
        PanelElementoArriba1 = new javax.swing.JPanel();
        PanelElementoCentro1 = new javax.swing.JPanel();
        PanelElementoAbajo1 = new javax.swing.JPanel();

        setLayout(new java.awt.GridLayout(1, 0));

        PanelHojaIzquierda.setLayout(new java.awt.GridLayout(3, 0));

        PanelElementoArriba.setLayout(new java.awt.BorderLayout());
        PanelHojaIzquierda.add(PanelElementoArriba);

        PanelElementoCentro.setLayout(new java.awt.BorderLayout());
        PanelHojaIzquierda.add(PanelElementoCentro);

        PanelElementoAbajo.setLayout(new java.awt.BorderLayout());
        PanelHojaIzquierda.add(PanelElementoAbajo);

        add(PanelHojaIzquierda);

        PanelHojaDerecha.setLayout(new java.awt.GridLayout(3, 0));

        PanelElementoArriba1.setLayout(new java.awt.BorderLayout());
        PanelHojaDerecha.add(PanelElementoArriba1);

        PanelElementoCentro1.setLayout(new java.awt.BorderLayout());
        PanelHojaDerecha.add(PanelElementoCentro1);

        PanelElementoAbajo1.setLayout(new java.awt.BorderLayout());
        PanelHojaDerecha.add(PanelElementoAbajo1);

        add(PanelHojaDerecha);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelElementoAbajo;
    private javax.swing.JPanel PanelElementoAbajo1;
    private javax.swing.JPanel PanelElementoArriba;
    private javax.swing.JPanel PanelElementoArriba1;
    private javax.swing.JPanel PanelElementoCentro;
    private javax.swing.JPanel PanelElementoCentro1;
    private javax.swing.JPanel PanelHojaDerecha;
    private javax.swing.JPanel PanelHojaIzquierda;
    // End of variables declaration//GEN-END:variables

    private void CargarCarta() throws Exception {
        Elemento e1 = new Elemento(10, "Descripcion 1", 4, null, "Elemento 1", (float) 23.00);
        Elemento e2 = new Elemento(20, "Descripcion 2", 4, null, "Elemento 2", (float) 43.00);
        Elemento e3 = new Elemento(30, "Descripcion 3", 4, null, "Elemento 3", (float) 30.50);

        PanelElementoCarta PEC = new PanelElementoCarta(e1);
        PanelElementoArriba.add(PEC, BorderLayout.CENTER);
        PanelElementoCentro.add(new PanelElementoCarta(e2));
        PanelElementoAbajo.add(new PanelElementoCarta(e3));
        
    }

}