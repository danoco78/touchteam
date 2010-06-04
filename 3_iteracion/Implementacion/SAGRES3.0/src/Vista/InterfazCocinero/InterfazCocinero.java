
package Vista.InterfazCocinero;

import ControladorPrincipal.ICocinero;
import java.awt.CardLayout;
import java.awt.Dialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import GestionCarta.ICarta;

/**
 *
 * @author Daniel Guerrero Martinez
 */
public class InterfazCocinero extends javax.swing.JFrame {

    public ICocinero icocinero;
    public ICarta iCarta;
    private IntPrincipalCocinero panelPrincipal = null;
    private IntGestionCarta panelCarta = null;
    private IntGestionIngrediente panelIngrediente = null;
    public IntColaCocinero panelColaCocinero;
    private menuEstadisticas panelEstadisticas;
    private balanceEconomico panelBalance;
    private platoMasVendido panelPlatoMasvendido;
    private platoMenosVendido panelPlatoMenosvendido;
    private platosNoServidos panelPlatosNoServidos;

    protected static final String PRINCIPAL = "Principal";
    protected static final String CARTA = "Carta";
    protected static final String INGREDIENTE = "Ingrediente";
    protected static final String COLA = "Cola";
    protected static final String ESTADISTICAS = "Estadisticas";
    protected static final String PLATOMASVENDIDO = "platoMasVendido";
    protected static final String PLATOMENOSVENDIDO = "platoMenosVendido";
    protected static final String PLATOSNOSERVIDOS = "platosNoServidos";
    protected static final String BALANCE = "balance";

    public InterfazCocinero( ICocinero iCocinero ,ICarta icarta) {
        initComponents();
        this.icocinero = iCocinero;
        this.iCarta = icarta;
        this.panelPrincipal = new IntPrincipalCocinero();
        this.panelCarta = new IntGestionCarta();
        this.panelIngrediente = new IntGestionIngrediente();
        this.panelColaCocinero = new IntColaCocinero(icocinero, this);
        this.panelEstadisticas = new menuEstadisticas();
        this.panelBalance = new balanceEconomico(icocinero);
        this.panelPlatoMasvendido = new platoMasVendido(icocinero,iCarta);
        this.panelPlatoMenosvendido = new platoMenosVendido(icocinero);
        this.panelPlatosNoServidos = new platosNoServidos(icocinero);
        this.getContentPane().add( this.panelColaCocinero, InterfazCocinero.COLA);
        this.getContentPane().add( this.panelPrincipal, InterfazCocinero.PRINCIPAL );
        this.getContentPane().add( this.panelCarta, InterfazCocinero.CARTA );
        this.getContentPane().add( this.panelIngrediente, InterfazCocinero.INGREDIENTE );
        this.getContentPane().add( this.panelEstadisticas, InterfazCocinero.ESTADISTICAS );
        this.getContentPane().add( this.panelBalance, InterfazCocinero.BALANCE );
        this.getContentPane().add( this.panelPlatoMasvendido, InterfazCocinero.PLATOMASVENDIDO );
        this.getContentPane().add( this.panelPlatoMenosvendido, InterfazCocinero.PLATOMENOSVENDIDO );
        this.getContentPane().add( this.panelPlatosNoServidos, InterfazCocinero.PLATOSNOSERVIDOS );
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.panelPrincipal.bSalir.addActionListener(new ManejaEventos(this, ManejaEventos.SALIR));
        this.panelPrincipal.bGestionCarta.addActionListener(new ManejaEventos(this, ManejaEventos.GESTIONARCARTA));
        this.panelPrincipal.bGestionIngredientes.addActionListener(new ManejaEventos(this, ManejaEventos.GESTIONARINGREDIENTES));
        this.panelPrincipal.bImprimirProductosaPedir.addActionListener(new ManejaEventos(this, ManejaEventos.IMPRIMIRLISTAPRODUCTOS));
        this.panelPrincipal.bEstaditicas.addActionListener(new ManejaEventos(this, ManejaEventos.MENUESTADISTICAS));
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
        this.panelColaCocinero.bGestionProductos.addActionListener(new ManejaEventos(this, ManejaEventos.GESTIONARPRODUCTOS));
        this.panelEstadisticas.bVolver.addActionListener(new ManejaEventos(this, ManejaEventos.VOLVER));
        this.panelEstadisticas.bBalance.addActionListener(new ManejaEventos(this, ManejaEventos.BALANCE));
        this.panelEstadisticas.bPlatosMasVendidos.addActionListener(new ManejaEventos(this, ManejaEventos.PLATOMASVENDIDO));
        this.panelEstadisticas.bPlatosMenosVendidos.addActionListener(new ManejaEventos(this, ManejaEventos.PLATOMENOSVENDIDO));
        this.panelEstadisticas.bPlatosNoServidos.addActionListener(new ManejaEventos(this, ManejaEventos.PLATOSNOSERVIDOS));
        this.panelBalance.bVolver.addActionListener(new ManejaEventos(this, ManejaEventos.VOLVERESTADISTICAS));
        this.panelPlatoMasvendido.bVolver.addActionListener(new ManejaEventos(this, ManejaEventos.VOLVERESTADISTICAS));
        this.panelPlatoMenosvendido.bVolver.addActionListener(new ManejaEventos(this, ManejaEventos.VOLVERESTADISTICAS));
        this.panelPlatosNoServidos.bVolver.addActionListener(new ManejaEventos(this, ManejaEventos.VOLVERESTADISTICAS));
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.CardLayout());

        pack();
    }// </editor-fold>//GEN-END:initComponents

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

        //Eventos para la segunda iteracion
        protected static final int GESTIONARPRODUCTOS = 13;
        protected static final int MENUESTADISTICAS = 14;
        protected static final int VOLVERESTADISTICAS = 15;
        protected static final int PLATOMASVENDIDO = 16;
        protected static final int PLATOMENOSVENDIDO = 17;
        protected static final int PLATOSNOSERVIDOS = 18;
        protected static final int BALANCE = 19;

        public ManejaEventos(JFrame Padre, int TipoEvento){
            this.padre = Padre;
            this.tipoEvento = TipoEvento;
        }

        public void actionPerformed(ActionEvent e) {
            Dialog dialogo = null;
            CardLayout layout = (CardLayout) padre.getContentPane().getLayout();
            switch (this.tipoEvento) {
                case ManejaEventos.SALIR:
                    //System.exit(0);
                    layout.show(padre.getContentPane(), InterfazCocinero.COLA);
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
                    break;
                case ManejaEventos.MENUESTADISTICAS:
                    layout.show(padre.getContentPane(), InterfazCocinero.ESTADISTICAS);
                    break;

                case ManejaEventos.VOLVERESTADISTICAS:
                    layout.show(padre.getContentPane(), InterfazCocinero.ESTADISTICAS);
                    break;
                case ManejaEventos.PLATOMASVENDIDO:
                    layout.show(padre.getContentPane(), InterfazCocinero.PLATOMASVENDIDO);
                    break;
                case ManejaEventos.PLATOMENOSVENDIDO:
                    layout.show(padre.getContentPane(), InterfazCocinero.PLATOMENOSVENDIDO);
                    break;
                case ManejaEventos.PLATOSNOSERVIDOS:
                    layout.show(padre.getContentPane(), InterfazCocinero.PLATOSNOSERVIDOS);
                    break;
                case ManejaEventos.BALANCE:
                    layout.show(padre.getContentPane(), InterfazCocinero.BALANCE);
                    break;
            }
            if (dialogo != null) {
                dialogo.setLocationRelativeTo(padre);
                dialogo.setVisible(true);
            }
        }

    }

    /*public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                javax.swing.JFrame dialog = new javax.swing.JFrame("Prueba ejecucion");
                dialog.setSize(Toolkit.getDefaultToolkit().getScreenSize());
                dialog.getContentPane().add(new IntColaCocinero(this), java.awt.BorderLayout.CENTER);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);

            }
        });
    }*/



    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

}
