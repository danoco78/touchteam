

package Vista.InterfazMetre;

import ControladorPrincipal.IMetre;
import java.awt.CardLayout;
import java.awt.Dialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

/**
 *
 * @author Daniel Guerrero Martinez
 * @author Samuel Guirado Navarro
 */
public class InterfazMetre extends javax.swing.JFrame {

    private IMetre imetre;
    private IntGestionBebidas panelBebida = null;
    private IntColaBar panelPrincipal = null;

    protected static final String PRINCIPAL = "Principal";
    protected static final String BEBIDA = "Bebida";

    public InterfazMetre(IMetre iMetre) {
        initComponents();
        this.imetre = iMetre;
        this.panelPrincipal = new IntColaBar();
        this.panelBebida = new IntGestionBebidas();
        getContentPane().add(this.panelPrincipal,InterfazMetre.PRINCIPAL);
        getContentPane().add(this.panelBebida,InterfazMetre.BEBIDA);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.panelBebida.bSalir.addActionListener(new ManejaEventos(this, ManejaEventos.SALIR));
        this.panelBebida.bAnadirBebida.addActionListener(new ManejaEventos(this, ManejaEventos.ANADIRBEBIDA));
        this.panelBebida.bEliminarBebida.addActionListener(new ManejaEventos(this, ManejaEventos.ELIMNARBEBIDA));
        this.panelBebida.bModificarBebida.addActionListener(new ManejaEventos(this, ManejaEventos.MODIFICARBEBIDA));
        this.panelBebida.bNotificcarIncidencia.addActionListener(new ManejaEventos(this, ManejaEventos.NOTIFICARINCIDENCIA));
        //TODO Añadir Manejador de eventos a las colas del panel de bar
    }


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
        protected static final int ANADIRBEBIDA = 1;
        protected static final int ELIMNARBEBIDA = 2;
        protected static final int MODIFICARBEBIDA = 3;
        protected static final int NOTIFICARINCIDENCIA = 4;
        protected static final int GESTIONARBEBIDAS = 5;
        // TODO Añadir variables para eventos de cola bar

        public ManejaEventos(JFrame Padre, int TipoEvento){
            this.padre = Padre;
            this.tipoEvento = TipoEvento;
        }

        public void actionPerformed(ActionEvent e) {
            Dialog dialogo= null;
            CardLayout layout = (CardLayout) padre.getContentPane().getLayout();
            switch (this.tipoEvento) {
                case ManejaEventos.SALIR:
                    layout.show(padre.getContentPane(), InterfazMetre.PRINCIPAL);
                    break;
                case ManejaEventos.GESTIONARBEBIDAS:
                    layout.show(padre.getContentPane(), InterfazMetre.BEBIDA);
                    break;
                case ManejaEventos.ANADIRBEBIDA:
                    dialogo = new DialogoAnadirBebida(padre, imetre);
                    break;
                case ManejaEventos.ELIMNARBEBIDA:
                    dialogo =new DialogoEliminarBebida(padre, imetre);
                    break;
                case ManejaEventos.MODIFICARBEBIDA:
                    dialogo =new DialogoModificarBedidas(padre,imetre);
                    break;
                case ManejaEventos.NOTIFICARINCIDENCIA:
                    dialogo =new DialogoNotificarIncidenciaBebida(padre, imetre);
                    break;
            }
            if(dialogo != null){
                dialogo.setLocationRelativeTo(padre);
                dialogo.setVisible(true);
            }
        }

    }


    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                javax.swing.JFrame dialog = new javax.swing.JFrame("Prueba ejecucion");
                dialog.setSize(800, 600);
                dialog.getContentPane().add(new IntColaBar(), java.awt.BorderLayout.CENTER);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);

            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

}
