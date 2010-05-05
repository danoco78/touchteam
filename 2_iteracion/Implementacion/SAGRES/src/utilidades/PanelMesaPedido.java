/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * PanelMesaPedido.java
 *
 * Created on 05-may-2010, 19:04:58
 */

package utilidades;

import GestionPedidos.Pedido;
import javax.swing.JComponent;

/**
 *
 * @author redder
 */
public class PanelMesaPedido extends javax.swing.JPanel {

    Integer filtro;
    Pedido pedido;

    /** Creates new form PanelMesaPedido */
    public PanelMesaPedido(Pedido pedido, Integer estado) {
        initComponents();
        this.filtro = estado;
        this.pedido = pedido;

        // TODO Obtener la mesa del pedido
        //this.tMesa_Pedido.setText("Mesa "+pedido.getCodMesa()+", pedido "+pedido.getCodPedido());

        // TODO Obtener los ElementoPedido de pedido y añadir solo los que tengan estado == filtro
        // Bucle FOR añadiendo
    }


    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pCuerpo = new javax.swing.JPanel();
        pSuperior = new javax.swing.JPanel();
        tMesa_Pedido = new javax.swing.JLabel();
        pCentral = new javax.swing.JPanel();
        pInferior = new javax.swing.JPanel();
        parriba = new javax.swing.JPanel();
        pabajo = new javax.swing.JPanel();
        pizquierda = new javax.swing.JPanel();
        pderecha = new javax.swing.JPanel();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(new javax.swing.border.LineBorder(new java.awt.Color(150, 172, 229), 3, true));
        setLayout(new java.awt.BorderLayout(5, 5));

        pCuerpo.setOpaque(false);
        pCuerpo.setLayout(new java.awt.BorderLayout());

        pSuperior.setOpaque(false);
        pSuperior.setLayout(new java.awt.BorderLayout(5, 5));

        tMesa_Pedido.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tMesa_Pedido.setForeground(new java.awt.Color(80, 98, 143));
        tMesa_Pedido.setText("Mesa X, Pedido YYYYYY");
        pSuperior.add(tMesa_Pedido, java.awt.BorderLayout.CENTER);

        pCuerpo.add(pSuperior, java.awt.BorderLayout.NORTH);

        pCentral.setOpaque(false);

        javax.swing.GroupLayout pCentralLayout = new javax.swing.GroupLayout(pCentral);
        pCentral.setLayout(pCentralLayout);
        pCentralLayout.setHorizontalGroup(
            pCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 384, Short.MAX_VALUE)
        );
        pCentralLayout.setVerticalGroup(
            pCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 167, Short.MAX_VALUE)
        );

        pCuerpo.add(pCentral, java.awt.BorderLayout.CENTER);

        pInferior.setOpaque(false);

        javax.swing.GroupLayout pInferiorLayout = new javax.swing.GroupLayout(pInferior);
        pInferior.setLayout(pInferiorLayout);
        pInferiorLayout.setHorizontalGroup(
            pInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 384, Short.MAX_VALUE)
        );
        pInferiorLayout.setVerticalGroup(
            pInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        pCuerpo.add(pInferior, java.awt.BorderLayout.SOUTH);

        add(pCuerpo, java.awt.BorderLayout.CENTER);

        parriba.setOpaque(false);
        parriba.setPreferredSize(new java.awt.Dimension(0, 0));

        javax.swing.GroupLayout parribaLayout = new javax.swing.GroupLayout(parriba);
        parriba.setLayout(parribaLayout);
        parribaLayout.setHorizontalGroup(
            parribaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 394, Short.MAX_VALUE)
        );
        parribaLayout.setVerticalGroup(
            parribaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        add(parriba, java.awt.BorderLayout.NORTH);

        pabajo.setOpaque(false);

        javax.swing.GroupLayout pabajoLayout = new javax.swing.GroupLayout(pabajo);
        pabajo.setLayout(pabajoLayout);
        pabajoLayout.setHorizontalGroup(
            pabajoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 394, Short.MAX_VALUE)
        );
        pabajoLayout.setVerticalGroup(
            pabajoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        add(pabajo, java.awt.BorderLayout.SOUTH);

        pizquierda.setOpaque(false);

        javax.swing.GroupLayout pizquierdaLayout = new javax.swing.GroupLayout(pizquierda);
        pizquierda.setLayout(pizquierdaLayout);
        pizquierdaLayout.setHorizontalGroup(
            pizquierdaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        pizquierdaLayout.setVerticalGroup(
            pizquierdaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 284, Short.MAX_VALUE)
        );

        add(pizquierda, java.awt.BorderLayout.WEST);

        pderecha.setOpaque(false);

        javax.swing.GroupLayout pderechaLayout = new javax.swing.GroupLayout(pderecha);
        pderecha.setLayout(pderechaLayout);
        pderechaLayout.setHorizontalGroup(
            pderechaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        pderechaLayout.setVerticalGroup(
            pderechaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 284, Short.MAX_VALUE)
        );

        add(pderecha, java.awt.BorderLayout.EAST);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel pCentral;
    private javax.swing.JPanel pCuerpo;
    private javax.swing.JPanel pInferior;
    private javax.swing.JPanel pSuperior;
    private javax.swing.JPanel pabajo;
    private javax.swing.JPanel parriba;
    private javax.swing.JPanel pderecha;
    private javax.swing.JPanel pizquierda;
    private javax.swing.JLabel tMesa_Pedido;
    // End of variables declaration//GEN-END:variables

}
