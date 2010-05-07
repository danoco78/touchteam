

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
 */
public class InterfazMetre extends javax.swing.JFrame {

    private IMetre imetre;
    private IntGestionBebidas panelPrincipal = null;
    private IntColaBar panelColaBar = null;

    protected static final String BEBIDA = "Bebida";
    protected static final String COLA = "Cola";

    public InterfazMetre(IMetre iMetre) {
        initComponents();
        this.imetre = iMetre;
        this.panelPrincipal = new IntGestionBebidas();
        this.panelColaBar = new IntColaBar();
        getContentPane().add(this.panelColaBar,InterfazMetre.COLA);
        getContentPane().add(this.panelPrincipal,InterfazMetre.BEBIDA);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.panelPrincipal.bSalir.addActionListener(new ManejaEventos(this, ManejaEventos.SALIR));
        this.panelPrincipal.bAnadirBebida.addActionListener(new ManejaEventos(this, ManejaEventos.ANADIRBEBIDA));
        this.panelPrincipal.bEliminarBebida.addActionListener(new ManejaEventos(this, ManejaEventos.ELIMNARBEBIDA));
        this.panelPrincipal.bModificarBebida.addActionListener(new ManejaEventos(this, ManejaEventos.MODIFICARBEBIDA));
        this.panelPrincipal.bNotificcarIncidencia.addActionListener(new ManejaEventos(this, ManejaEventos.NOTIFICARINCIDENCIA));
        this.panelColaBar.bGestBebidas.addActionListener(new ManejaEventos(this, ManejaEventos.GESTBEBIDAS));
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
        protected static final int GESTBEBIDAS = 5;

        public ManejaEventos(JFrame Padre, int TipoEvento){
            this.padre = Padre;
            this.tipoEvento = TipoEvento;
        }

        public void actionPerformed(ActionEvent e) {
            Dialog dialogo= null;
            CardLayout layout = (CardLayout) padre.getContentPane().getLayout();
            switch (this.tipoEvento) {
                case ManejaEventos.SALIR:
                    //System.exit(0);
                    layout.show(padre.getContentPane(), InterfazMetre.COLA);
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
                case ManejaEventos.GESTBEBIDAS:
                    layout.show(padre.getContentPane(), InterfazMetre.BEBIDA);
                    break;
            }
            if(dialogo != null){
                dialogo.setLocationRelativeTo(padre);
                dialogo.setVisible(true);
            }
        }

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

}
