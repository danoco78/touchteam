/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * InterfazMetre.java
 *
 * Created on 01-abr-2010, 13:32:37
 */

package Vista.InterfazMetre;

import GestionStock.GestionIncidencias.IIncidencia;
import GestionStock.GestionProductos.IGestionarProducto;
import GestionStock.GestionProductos.IProducto;
import java.awt.Dialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

/**
 *
 * @author Daniel
 */
public class InterfazMetre extends javax.swing.JFrame {

    private IIncidencia iIncidencia;
    private IProducto iProducto;
    private IGestionarProducto iGestorProducto;
    private IntPrincipalMetre panelPrincipal = null;


    public InterfazMetre(IIncidencia iIncidencia, IProducto iProducto, IGestionarProducto iGestorProducto) {
        initComponents();
        this.iIncidencia = iIncidencia;
        this.iProducto = iProducto;
        this.iGestorProducto = iGestorProducto;
        this.panelPrincipal = new IntPrincipalMetre();
        getContentPane().add(this.panelPrincipal,java.awt.BorderLayout.CENTER);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.panelPrincipal.bSalir.addActionListener(new ManejaEventos(this, ManejaEventos.SALIR));
        this.panelPrincipal.bAnadirBebida.addActionListener(new ManejaEventos(this, ManejaEventos.ANADIRBEBIDA));
        this.panelPrincipal.bEliminarBebida.addActionListener(new ManejaEventos(this, ManejaEventos.ELIMNARBEBIDA));
        this.panelPrincipal.bModificarBebida.addActionListener(new ManejaEventos(this, ManejaEventos.MODIFICARBEBIDA));
        this.panelPrincipal.bNotificcarIncidencia.addActionListener(new ManejaEventos(this, ManejaEventos.NOTIFICARINCIDENCIA));
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

        public ManejaEventos(JFrame Padre, int TipoEvento){
            this.padre = Padre;
            this.tipoEvento = TipoEvento;
        }

        public void actionPerformed(ActionEvent e) {
            Dialog dialogo= null;
            switch (this.tipoEvento) {
                case ManejaEventos.SALIR:
                    System.exit(0);
                    break;
                case ManejaEventos.ANADIRBEBIDA:
                    dialogo = new DialogoAnadirBebida(padre, true, iGestorProducto);
                    break;
                case ManejaEventos.ELIMNARBEBIDA:
                    dialogo =new DialogoEliminarBebida(padre, true, iGestorProducto, iProducto);
                    break;
                case ManejaEventos.MODIFICARBEBIDA:
                    dialogo =new DialogoModificarBedidas(padre,true, iGestorProducto, iProducto);
                    break;
                case ManejaEventos.NOTIFICARINCIDENCIA:
                    dialogo =new DialogoNotificarIncidenciaBebida(padre, true, iProducto, iIncidencia);
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
