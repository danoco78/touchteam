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
import java.util.HashSet;
import java.util.Iterator;

/**
 *
 * @author Carlos
 */
public class PanelHojasCarta extends javax.swing.JPanel {

    private ICliente icliente;

    /** Creates new form PanelHojasCarta */
    public PanelHojasCarta(HashSet<Elemento> listaElementos) throws Exception {
        initComponents();

        Iterator it = listaElementos.iterator();

        Elemento e;

        if(it.hasNext()){
            e = (Elemento) it.next();
            PanelElementoArribaI.add(new PanelElementoCarta(e));

            if(it.hasNext()){
                e = (Elemento) it.next();
                PanelElementoCentroI.add(new PanelElementoCarta(e));

                if(it.hasNext()){
                    e = (Elemento) it.next();
                    PanelElementoAbajoI.add(new PanelElementoCarta(e));

                    if(it.hasNext()){
                        e = (Elemento) it.next();
                        PanelElementoArribaD.add(new PanelElementoCarta(e));

                        if(it.hasNext()){
                            e = (Elemento) it.next();
                            PanelElementoCentroD.add(new PanelElementoCarta(e));

                            if(it.hasNext()){
                                e = (Elemento) it.next();
                                PanelElementoAbajoD.add(new PanelElementoCarta(e));
                            }
                        }
                    }
                }
            }
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

        PanelCentral = new javax.swing.JPanel();
        PanelHojaIzquierda = new javax.swing.JPanel();
        PanelElementoArribaI = new javax.swing.JPanel();
        PanelElementoCentroI = new javax.swing.JPanel();
        PanelElementoAbajoI = new javax.swing.JPanel();
        PanelHojaDerecha = new javax.swing.JPanel();
        PanelElementoArribaD = new javax.swing.JPanel();
        PanelElementoCentroD = new javax.swing.JPanel();
        PanelElementoAbajoD = new javax.swing.JPanel();
        PanelMargenArriba = new javax.swing.JPanel();
        PanelMargenAbajo = new javax.swing.JPanel();
        PanelMargenIzquierda = new javax.swing.JPanel();
        PanelMargenDerecha = new javax.swing.JPanel();

        setOpaque(false);
        setPreferredSize(new java.awt.Dimension(200, 200));
        setLayout(new java.awt.BorderLayout());

        PanelCentral.setOpaque(false);
        PanelCentral.setLayout(new java.awt.GridLayout(1, 0, 10, 5));

        PanelHojaIzquierda.setBackground(new java.awt.Color(255, 255, 255));
        PanelHojaIzquierda.setPreferredSize(new java.awt.Dimension(50, 150));
        PanelHojaIzquierda.setLayout(new java.awt.GridLayout(3, 0, 5, 5));

        PanelElementoArribaI.setBackground(new java.awt.Color(255, 255, 255));
        PanelElementoArribaI.setLayout(new java.awt.BorderLayout());
        PanelHojaIzquierda.add(PanelElementoArribaI);

        PanelElementoCentroI.setBackground(new java.awt.Color(255, 255, 255));
        PanelElementoCentroI.setLayout(new java.awt.BorderLayout());
        PanelHojaIzquierda.add(PanelElementoCentroI);

        PanelElementoAbajoI.setBackground(new java.awt.Color(255, 255, 255));
        PanelElementoAbajoI.setLayout(new java.awt.BorderLayout());
        PanelHojaIzquierda.add(PanelElementoAbajoI);

        PanelCentral.add(PanelHojaIzquierda);

        PanelHojaDerecha.setBackground(new java.awt.Color(255, 255, 255));
        PanelHojaDerecha.setPreferredSize(new java.awt.Dimension(50, 150));
        PanelHojaDerecha.setLayout(new java.awt.GridLayout(3, 0, 5, 5));

        PanelElementoArribaD.setBackground(new java.awt.Color(255, 255, 255));
        PanelElementoArribaD.setLayout(new java.awt.BorderLayout());
        PanelHojaDerecha.add(PanelElementoArribaD);

        PanelElementoCentroD.setBackground(new java.awt.Color(255, 255, 255));
        PanelElementoCentroD.setLayout(new java.awt.BorderLayout());
        PanelHojaDerecha.add(PanelElementoCentroD);

        PanelElementoAbajoD.setBackground(new java.awt.Color(255, 255, 255));
        PanelElementoAbajoD.setLayout(new java.awt.BorderLayout());
        PanelHojaDerecha.add(PanelElementoAbajoD);

        PanelCentral.add(PanelHojaDerecha);

        add(PanelCentral, java.awt.BorderLayout.CENTER);

        PanelMargenArriba.setOpaque(false);
        add(PanelMargenArriba, java.awt.BorderLayout.NORTH);

        PanelMargenAbajo.setOpaque(false);
        add(PanelMargenAbajo, java.awt.BorderLayout.SOUTH);

        PanelMargenIzquierda.setOpaque(false);
        add(PanelMargenIzquierda, java.awt.BorderLayout.WEST);

        PanelMargenDerecha.setOpaque(false);
        add(PanelMargenDerecha, java.awt.BorderLayout.EAST);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelCentral;
    private javax.swing.JPanel PanelElementoAbajoD;
    private javax.swing.JPanel PanelElementoAbajoI;
    private javax.swing.JPanel PanelElementoArribaD;
    private javax.swing.JPanel PanelElementoArribaI;
    private javax.swing.JPanel PanelElementoCentroD;
    private javax.swing.JPanel PanelElementoCentroI;
    private javax.swing.JPanel PanelHojaDerecha;
    private javax.swing.JPanel PanelHojaIzquierda;
    private javax.swing.JPanel PanelMargenAbajo;
    private javax.swing.JPanel PanelMargenArriba;
    private javax.swing.JPanel PanelMargenDerecha;
    private javax.swing.JPanel PanelMargenIzquierda;
    // End of variables declaration//GEN-END:variables

}
