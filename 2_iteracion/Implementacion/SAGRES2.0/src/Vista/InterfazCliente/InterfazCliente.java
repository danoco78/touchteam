/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * InterfazCliente.java
 *
 * Created on 09-may-2010, 20:28:31
 */

package Vista.InterfazCliente;

import ControladorPrincipal.ICliente;
import java.awt.CardLayout;
import java.awt.Dialog;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/**
 *
 * @author Carlos
 */
public class InterfazCliente extends javax.swing.JFrame {

    ICliente icliente;
    PanelGeneralCliente panelGeneralCliente;

    /** Creates new form InterfazCliente */
    public InterfazCliente(ICliente icliente) {
        try {
            initComponents();
            this.icliente = icliente;
            this.panelGeneralCliente = new PanelGeneralCliente();
            this.getContentPane().add(this.panelGeneralCliente, java.awt.BorderLayout.CENTER);
            this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        } catch (Exception ex) {
            Logger.getLogger(InterfazCliente.class.getName()).log(Level.SEVERE, null, ex);
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private class ManejaEventos implements ActionListener {

        private int tipoEvento;
        private JFrame padre;
        protected static final int SALIR = 0;
        /*protected static final int ANADIRELEMENTO = 1;
        protected static final int ELIMINARELEMENTO = 2;
        protected static final int MODIFICARELEMENTO = 3;
        protected static final int ANADIRINGREDIENTE = 4;
        protected static final int ELIMINARINGREDIENTE = 5;
        protected static final int MODIFICARINGREDIENTE = 6;
        protected static final int NOTIFICARINCIDENCIA = 7;
        protected static final int GESTIONARCARTA = 8;
        protected static final int GESTIONARINGREDIENTES = 9;
        protected static final int IMPRIMIRLISTAPRODUCTOS = 10;
        protected static final int NOTIFICARRECEPCION = 11;
        protected static final int VOLVER = 12;
        protected static final int GESTIONARPRODUCTOS = 13;*/

        public ManejaEventos(JFrame Padre, int TipoEvento){
            this.padre = Padre;
            this.tipoEvento = TipoEvento;
        }

        public void actionPerformed(ActionEvent e) {
            Dialog dialogo = null;
            CardLayout layout = (CardLayout) padre.getContentPane().getLayout();
            switch (this.tipoEvento) {
                /*case ManejaEventos.SALIR:
                    //System.exit(0);
                    layout.show(padre.getContentPane(), InterfazCliente.COLA);
                    break;
                case ManejaEventos.GESTIONARCARTA:
                    layout.show(padre.getContentPane(), InterfazCocinero.CARTA);
                    break;
                case ManejaEventos.GESTIONARINGREDIENTES:
                    layout.show(padre.getContentPane(), InterfazCocinero.INGREDIENTE);
                    break;
                case ManejaEventos.VOLVER:
                    layout.show(padre.getContentPane(), InterfazCocinero.PRINCIPAL);
                    break;
                case ManejaEventos.IMPRIMIRLISTAPRODUCTOS:
                    dialogo = new DialogoImprimirListaProductosAPedir(padre, icocinero);
                    break;
                case ManejaEventos.NOTIFICARRECEPCION:
                    dialogo = new DialogoNotificarLlegadaProductos(padre, icocinero);
                    break;
                case ManejaEventos.ANADIRINGREDIENTE:
                    dialogo = new DialogoAnadirIngrediente(padre, icocinero);
                    break;
                case ManejaEventos.ELIMINARINGREDIENTE:
                    dialogo = new DialogoEliminarIngrediente(padre, icocinero);
                    break;
                case ManejaEventos.MODIFICARINGREDIENTE:
                    dialogo = new DialogoModificarIngrediente(padre, icocinero);
                    break;
                case ManejaEventos.ANADIRELEMENTO:
                    dialogo = new DialogoAnadirElemento(padre, icocinero);
                    break;
                case ManejaEventos.ELIMINARELEMENTO:
                    dialogo = new DialogoEliminarElemento(padre, icocinero);
                    break;
                case ManejaEventos.MODIFICARELEMENTO:
                    dialogo = new DialogoModificarElemento(padre, icocinero);
                    break;
                case ManejaEventos.NOTIFICARINCIDENCIA:
                    dialogo = new DialogoNotificarIncidencia(padre, icocinero);
                    break;
                case ManejaEventos.GESTIONARPRODUCTOS:
                    layout.show(padre.getContentPane(), InterfazCocinero.PRINCIPAL);
                    break;*/
            }
            if (dialogo != null) {
                dialogo.setLocationRelativeTo(padre);
                dialogo.setVisible(true);
            }
        }

    }

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    javax.swing.JFrame dialog = new javax.swing.JFrame("Prueba ejecucion");
                    dialog.setSize(Toolkit.getDefaultToolkit().getScreenSize());
                    dialog.getContentPane().add(new PanelGeneralCliente(), java.awt.BorderLayout.CENTER);
                    dialog.addWindowListener(new java.awt.event.WindowAdapter() {

                        @Override
                        public void windowClosing(java.awt.event.WindowEvent e) {
                            System.exit(0);
                        }
                    });
                    dialog.setVisible(true);
                } catch (Exception ex) {
                    Logger.getLogger(InterfazCliente.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

}
