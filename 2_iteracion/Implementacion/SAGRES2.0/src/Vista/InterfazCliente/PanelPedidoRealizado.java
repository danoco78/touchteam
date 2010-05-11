/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * PanelPedidoRealizado.java
 *
 * Created on 09-may-2010, 17:33:28
 */

package Vista.InterfazCliente;

/**
 *
 * @author Carlos
 */
public class PanelPedidoRealizado extends javax.swing.JPanel {

    /** Creates new form PanelPedidoRealizado */
    public PanelPedidoRealizado() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelPedidoComida = new javax.swing.JPanel();
        PanelListaComida = new javax.swing.JPanel();
        ScrollListaComida = new javax.swing.JScrollPane();
        TextoListaComida = new javax.swing.JTextPane();
        Modificar = new javax.swing.JButton();
        BotonVerFactura = new javax.swing.JButton();

        setLayout(new java.awt.BorderLayout());

        PanelPedidoComida.setOpaque(false);
        PanelPedidoComida.setLayout(new java.awt.BorderLayout(0, 5));

        PanelListaComida.setLayout(new java.awt.BorderLayout());

        TextoListaComida.setEditable(false);
        ScrollListaComida.setViewportView(TextoListaComida);

        PanelListaComida.add(ScrollListaComida, java.awt.BorderLayout.CENTER);

        PanelPedidoComida.add(PanelListaComida, java.awt.BorderLayout.CENTER);

        Modificar.setFont(new java.awt.Font("Arial", 1, 16));
        Modificar.setForeground(new java.awt.Color(80, 98, 143));
        Modificar.setText("Modificar");
        Modificar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(150, 172, 229), 1, true));
        PanelPedidoComida.add(Modificar, java.awt.BorderLayout.SOUTH);

        add(PanelPedidoComida, java.awt.BorderLayout.CENTER);

        BotonVerFactura.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        BotonVerFactura.setForeground(new java.awt.Color(80, 98, 143));
        BotonVerFactura.setText("Ver Factura");
        BotonVerFactura.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(150, 172, 229), 1, true));
        BotonVerFactura.setPreferredSize(new java.awt.Dimension(89, 50));
        add(BotonVerFactura, java.awt.BorderLayout.SOUTH);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotonVerFactura;
    private javax.swing.JButton Modificar;
    private javax.swing.JPanel PanelListaComida;
    private javax.swing.JPanel PanelPedidoComida;
    private javax.swing.JScrollPane ScrollListaComida;
    private javax.swing.JTextPane TextoListaComida;
    // End of variables declaration//GEN-END:variables

    public void anadirElemento(String nomElemento) {
        TextoListaComida.setText(TextoListaComida.getText()+"\n- "+nomElemento);
    }

}