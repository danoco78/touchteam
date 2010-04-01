/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * InterfazMetre.java
 *
 * Created on 01-abr-2010, 13:32:37
 */

package Vista.InterfazCocinero;

import GestionCarta.ICarta;
import GestionCarta.IPreparaCarta;
import Vista.InterfazMetre.*;
import GestionStock.GestionIncidencias.IIncidencia;
import GestionStock.GestionPedidoProveedor.IPedidoProveedor;
import GestionStock.GestionProductos.IGestionarProducto;
import GestionStock.GestionProductos.IProducto;
import java.awt.CardLayout;
import java.awt.Dialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

/**
 *
 * @author Daniel
 */
public class InterfazCocinero extends javax.swing.JFrame {

    private IIncidencia iIncidencia;
    private IProducto iProducto;
    private IGestionarProducto iGestorProducto;
    private IPedidoProveedor iPedidoProveedor;
    private ICarta iCarta;
    private IPreparaCarta iPreparaCarta;
    private IntPrincipalCocinero panelPrincipal = null;
    private IntGestionCarta panelCarta = null;
    private IntGestionIngrediente panelIngrediente = null;

    protected static final String PRINCIPAL = "Principal";
    protected static final String CARTA = "Carta";
    protected static final String INGREDIENTE = "Ingrediente";


    public InterfazCocinero(IIncidencia iIncidencia, IProducto iProducto,
            IGestionarProducto iGestorProducto ,IPedidoProveedor iPedidoProveedor,
            ICarta iCarta, IPreparaCarta iPreparaCarta ) {
        initComponents();
        this.iIncidencia = iIncidencia;
        this.iProducto = iProducto;
        this.iGestorProducto = iGestorProducto;
        this.iPedidoProveedor = iPedidoProveedor;
        this.iCarta = iCarta;
        this.iPreparaCarta = iPreparaCarta;
        this.panelPrincipal = new IntPrincipalCocinero();
        this.panelCarta = new IntGestionCarta();
        this.panelIngrediente = new IntGestionIngrediente();
        this.getContentPane().add( this.panelPrincipal, InterfazCocinero.PRINCIPAL );
        this.getContentPane().add( this.panelCarta, InterfazCocinero.CARTA );
        this.getContentPane().add( this.panelIngrediente, InterfazCocinero.INGREDIENTE );
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.panelPrincipal.bSalir.addActionListener(new ManejaEventos(this, ManejaEventos.SALIR));
        this.panelPrincipal.bGestionCarta.addActionListener(new ManejaEventos(this, ManejaEventos.GESTIONARCARTA));
        this.panelPrincipal.bGestionIngredientes.addActionListener(new ManejaEventos(this, ManejaEventos.GESTIONARINGREDIENTES));
        this.panelPrincipal.bImprimirProductosaPedir.addActionListener(new ManejaEventos(this, ManejaEventos.IMPRIMIRLISTAPRODUCTOS));
        this.panelPrincipal.bNotificcarPedido.addActionListener(new ManejaEventos(this, ManejaEventos.NOTIFICARRECEPCION));
        this.panelCarta.bAnadirElemento.addActionListener(new ManejaEventos(this, ManejaEventos.ANADIRELEMENTO));
        this.panelCarta.bEleminarElemento.addActionListener(new ManejaEventos(this, ManejaEventos.ELIMINARELEMENTO));
        this.panelCarta.bModificarElemento.addActionListener(new ManejaEventos(this, ManejaEventos.MODIFICARELEMENTO));
        this.panelIngrediente.bAnadirIngrediente.addActionListener(new ManejaEventos(this, ManejaEventos.ANADIRINGREDIENTE));
        this.panelIngrediente.bEleminarIngrediente.addActionListener(new ManejaEventos(this, ManejaEventos.ELIMINARINGREDIENTE));
        this.panelIngrediente.bModificarIngrediente.addActionListener(new ManejaEventos(this, ManejaEventos.MODIFICARINGREDIENTE));
        this.panelIngrediente.bNotificarIncidente.addActionListener(new ManejaEventos(this, ManejaEventos.NOTIFICARINCIDENCIA));
        this.panelCarta.bVolver.addActionListener(new ManejaEventos(this, ManejaEventos.VOLVER));
        this.panelIngrediente.bVolver.addActionListener(new ManejaEventos(this, ManejaEventos.VOLVER));
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.CardLayout());

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InterfazCocinero(null,null,null,null,null,null).setVisible(true);
            }
        });
    }

    private class ManejaEventos implements ActionListener {

        private int tipoEvento;
        private JFrame padre;
        protected static final int SALIR = 0;
        protected static final int ANADIRELEMENTO = 1;
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

        public ManejaEventos(JFrame Padre, int TipoEvento){
            this.padre = Padre;
            this.tipoEvento = TipoEvento;
        }

        public void actionPerformed(ActionEvent e) {
            Dialog dialogo = null;
            CardLayout layout = (CardLayout) padre.getContentPane().getLayout();
            switch (this.tipoEvento) {
                case ManejaEventos.SALIR:
                    System.exit(0);
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
                    dialogo = new DialogoImprimirListaProductosAPedir(padre, true);
                    break;
                case ManejaEventos.NOTIFICARRECEPCION:
                    dialogo = new DialogoNotificarLlegadaProductos(padre, true);
                    break;
                case ManejaEventos.ANADIRINGREDIENTE:
                    dialogo = new DialogoAnadirIngrediente(padre, true);
                    break;
                case ManejaEventos.ELIMINARINGREDIENTE:
                    dialogo = new DialogoEliminarIngrediente(padre, true);
                    break;
                case ManejaEventos.MODIFICARINGREDIENTE:
                    dialogo = new DialogoModificarIngrediente(padre, true);
                    break;
                case ManejaEventos.ANADIRELEMENTO:
                    dialogo = new DialogoAnadirElemento(padre, true);
                    break;
                case ManejaEventos.ELIMINARELEMENTO:
                    dialogo = new DialogoEliminarElemento(padre, true);
                    break;
                case ManejaEventos.MODIFICARELEMENTO:
                    dialogo = new DialogoAnadirElemento(padre, true);
                    break;
                case ManejaEventos.NOTIFICARINCIDENCIA:
                    dialogo = new DialogoNotificarIncidencia(padre, true);
                    break;
            }
            if (dialogo != null) {
                dialogo.setLocationRelativeTo(padre);
                dialogo.setVisible(true);
            }
        }

    }





    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

}
