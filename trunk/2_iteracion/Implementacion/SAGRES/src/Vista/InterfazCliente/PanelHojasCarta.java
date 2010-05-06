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
import GestionCarta.Seccion;
import java.util.HashSet;
import java.util.Iterator;

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
        PanelHojaDerecha = new javax.swing.JPanel();

        setLayout(new java.awt.GridLayout());

        javax.swing.GroupLayout PanelHojaIzquierdaLayout = new javax.swing.GroupLayout(PanelHojaIzquierda);
        PanelHojaIzquierda.setLayout(PanelHojaIzquierdaLayout);
        PanelHojaIzquierdaLayout.setHorizontalGroup(
            PanelHojaIzquierdaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 200, Short.MAX_VALUE)
        );
        PanelHojaIzquierdaLayout.setVerticalGroup(
            PanelHojaIzquierdaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        add(PanelHojaIzquierda);

        javax.swing.GroupLayout PanelHojaDerechaLayout = new javax.swing.GroupLayout(PanelHojaDerecha);
        PanelHojaDerecha.setLayout(PanelHojaDerechaLayout);
        PanelHojaDerechaLayout.setHorizontalGroup(
            PanelHojaDerechaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 200, Short.MAX_VALUE)
        );
        PanelHojaDerechaLayout.setVerticalGroup(
            PanelHojaDerechaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        add(PanelHojaDerecha);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelHojaDerecha;
    private javax.swing.JPanel PanelHojaIzquierda;
    // End of variables declaration//GEN-END:variables

    private void CargarCarta() throws Exception {
        HashSet<Seccion> listaSecciones = icliente.obtieneSecciones();
        
        Iterator iterador = listaSecciones.iterator();
        while (iterador.hasNext()){
            Seccion seccion = (Seccion)iterador.next();

            System.out.println(seccion.getCodigoSeccion());
            System.out.println(seccion.getNombre());
        }
        /*while (iterador.hasNext()){
            Elemento elemento = (Elemento)iterador.next();

            System.out.println(elemento.getCodigoElemento());
            System.out.println(elemento.getNombre());
            System.out.println(elemento.getDescripcion());
            System.out.println(elemento.getDisponible());
        }*/
    }

}
