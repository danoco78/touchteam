/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * PanelMesaPedido.java
 *
 * Created on 05-may-2010, 19:04:58
 */

package Vista.InterfazCocinero;

import GestionPedidos.Pedido;
import javax.swing.JButton;
import utilidades.PanelEspacioVertical;
import utilidades.PanelPedidoPorMesa;

/**
 *
 * @author Samuel Guirado Navarro
 */
public class PreparandosePanel extends javax.swing.JPanel {

    Pedido pedActual = null;
    java.awt.Dimension oldTama;
    
    /** Creates new form PanelMesaPedido */
    public PreparandosePanel() {
        initComponents();
        oldTama = this.getSize();

        this.pPanelesPedido.add(new PanelEspacioVertical());
        for(int i=0; i<5; ++i){
            this.pPanelesPedido.add(new PanelPedidoPorMesa());
            this.pPanelesPedido.add(new PanelEspacioVertical());
        }
        
    }

    /**
     * Modifica el mensaje de texto de la base. Es necesario decirle la cantidad por parametros,
     * puesto que se obtiene de una consulta
     * @param mensaje Texto a mostrar. <br>Siempre sigue el formato [num] platos pendientes, para el caso de platos.
     */
    public void setMensaje(String mensaje){
        pendientes.setText(mensaje);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pInf = new javax.swing.JPanel();
        pendientes = new javax.swing.JLabel();
        scroll = new javax.swing.JScrollPane();
        pCentral = new javax.swing.JPanel();
        margenDer = new javax.swing.JPanel();
        margenIzq = new javax.swing.JPanel();
        pPanelesPedido = new javax.swing.JPanel();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, new java.awt.Color(150, 172, 229), new java.awt.Color(150, 172, 229), new java.awt.Color(150, 172, 229), new java.awt.Color(170, 172, 229)));
        setLayout(new java.awt.BorderLayout());

        pInf.setBackground(new java.awt.Color(255, 255, 255));
        pInf.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(150, 172, 229)));
        pInf.setPreferredSize(new java.awt.Dimension(396, 50));
        pInf.setLayout(new java.awt.BorderLayout());

        pendientes.setFont(new java.awt.Font("Arial", 0, 18));
        pendientes.setForeground(new java.awt.Color(80, 98, 143));
        pendientes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pendientes.setText("7 bebidas pendientes ");
        pInf.add(pendientes, java.awt.BorderLayout.CENTER);

        add(pInf, java.awt.BorderLayout.SOUTH);

        scroll.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        pCentral.setBackground(new java.awt.Color(255, 255, 255));
        pCentral.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(150, 172, 229)));
        pCentral.setLayout(new java.awt.BorderLayout());

        margenDer.setOpaque(false);
        margenDer.setPreferredSize(new java.awt.Dimension(5, 139));

        javax.swing.GroupLayout margenDerLayout = new javax.swing.GroupLayout(margenDer);
        margenDer.setLayout(margenDerLayout);
        margenDerLayout.setHorizontalGroup(
            margenDerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );
        margenDerLayout.setVerticalGroup(
            margenDerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 242, Short.MAX_VALUE)
        );

        pCentral.add(margenDer, java.awt.BorderLayout.EAST);

        margenIzq.setOpaque(false);
        margenIzq.setPreferredSize(new java.awt.Dimension(5, 139));

        javax.swing.GroupLayout margenIzqLayout = new javax.swing.GroupLayout(margenIzq);
        margenIzq.setLayout(margenIzqLayout);
        margenIzqLayout.setHorizontalGroup(
            margenIzqLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );
        margenIzqLayout.setVerticalGroup(
            margenIzqLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 242, Short.MAX_VALUE)
        );

        pCentral.add(margenIzq, java.awt.BorderLayout.WEST);

        pPanelesPedido.setOpaque(false);
        pPanelesPedido.setLayout(new javax.swing.BoxLayout(pPanelesPedido, javax.swing.BoxLayout.Y_AXIS));
        pCentral.add(pPanelesPedido, java.awt.BorderLayout.CENTER);

        scroll.setViewportView(pCentral);

        add(scroll, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel margenDer;
    private javax.swing.JPanel margenIzq;
    private javax.swing.JPanel pCentral;
    private javax.swing.JPanel pInf;
    private javax.swing.JPanel pPanelesPedido;
    private javax.swing.JLabel pendientes;
    private javax.swing.JScrollPane scroll;
    // End of variables declaration//GEN-END:variables

}
