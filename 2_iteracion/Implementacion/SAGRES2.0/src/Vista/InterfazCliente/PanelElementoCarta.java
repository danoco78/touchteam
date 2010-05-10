/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * PanelElementoCarta.java
 *
 * Created on 07-may-2010, 17:36:23
 */

package Vista.InterfazCliente;

import GestionCarta.Elemento;

/**
 *
 * @author Carlos
 */
public class PanelElementoCarta extends javax.swing.JPanel {
    PanelGeneralCliente PGC;
    
    /** Creates new form PanelElementoCarta */
    public PanelElementoCarta(Elemento e, PanelGeneralCliente PGC) {
        initComponents();

        this.PGC=PGC;

        LabelNombre.setText(e.getNombre());
        TextoDescripcion.setText(e.getDescripcion());
        LabelPrecio.setText(Double.toString(e.getPrecio()));
        TextoDescripcion.setSize(500, 400);

    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelCentral = new javax.swing.JPanel();
        PanelDatos = new javax.swing.JPanel();
        LabelNombre = new javax.swing.JLabel();
        PanelDescripcion = new javax.swing.JPanel();
        ScrollDescripcion = new javax.swing.JScrollPane();
        TextoDescripcion = new javax.swing.JTextPane();
        PanelPrecio = new javax.swing.JPanel();
        LabelPrecio = new javax.swing.JLabel();
        PanelFoto = new javax.swing.JPanel();
        PanelMargenArriba = new javax.swing.JPanel();
        PanelMargenAbajo = new javax.swing.JPanel();
        PanelMargenIzquierda = new javax.swing.JPanel();
        PanelMargenDerecha = new javax.swing.JPanel();

        setBackground(new java.awt.Color(255, 255, 255));
        setOpaque(false);
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                seleccionarElemento(evt);
            }
        });
        setLayout(new java.awt.BorderLayout());

        PanelCentral.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(150, 172, 229), 3));
        PanelCentral.setOpaque(false);
        PanelCentral.setLayout(new java.awt.BorderLayout());

        PanelDatos.setBackground(new java.awt.Color(255, 255, 255));
        PanelDatos.setLayout(new java.awt.BorderLayout());

        LabelNombre.setBackground(new java.awt.Color(255, 255, 255));
        LabelNombre.setFont(new java.awt.Font("Arial", 1, 16));
        LabelNombre.setText("jLabel1");
        PanelDatos.add(LabelNombre, java.awt.BorderLayout.NORTH);

        PanelDescripcion.setLayout(new java.awt.BorderLayout());

        ScrollDescripcion.setBorder(null);

        TextoDescripcion.setBorder(null);
        TextoDescripcion.setEditable(false);
        TextoDescripcion.setMaximumSize(new java.awt.Dimension(10, 10));
        TextoDescripcion.setMinimumSize(new java.awt.Dimension(10, 10));
        ScrollDescripcion.setViewportView(TextoDescripcion);

        PanelDescripcion.add(ScrollDescripcion, java.awt.BorderLayout.CENTER);

        PanelDatos.add(PanelDescripcion, java.awt.BorderLayout.CENTER);

        PanelPrecio.setBackground(new java.awt.Color(255, 255, 255));
        PanelPrecio.setOpaque(false);
        PanelPrecio.setLayout(new java.awt.BorderLayout());

        LabelPrecio.setText("jLabel1");
        PanelPrecio.add(LabelPrecio, java.awt.BorderLayout.EAST);

        PanelDatos.add(PanelPrecio, java.awt.BorderLayout.SOUTH);

        PanelCentral.add(PanelDatos, java.awt.BorderLayout.CENTER);

        PanelFoto.setBackground(new java.awt.Color(255, 255, 255));
        PanelFoto.setPreferredSize(new java.awt.Dimension(150, 150));

        javax.swing.GroupLayout PanelFotoLayout = new javax.swing.GroupLayout(PanelFoto);
        PanelFoto.setLayout(PanelFotoLayout);
        PanelFotoLayout.setHorizontalGroup(
            PanelFotoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 150, Short.MAX_VALUE)
        );
        PanelFotoLayout.setVerticalGroup(
            PanelFotoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 134, Short.MAX_VALUE)
        );

        PanelCentral.add(PanelFoto, java.awt.BorderLayout.EAST);

        add(PanelCentral, java.awt.BorderLayout.CENTER);

        PanelMargenArriba.setOpaque(false);
        PanelMargenArriba.setPreferredSize(new java.awt.Dimension(5, 5));
        PanelMargenArriba.setLayout(new java.awt.BorderLayout());
        add(PanelMargenArriba, java.awt.BorderLayout.NORTH);

        PanelMargenAbajo.setOpaque(false);
        PanelMargenAbajo.setPreferredSize(new java.awt.Dimension(5, 5));
        PanelMargenAbajo.setLayout(new java.awt.BorderLayout());
        add(PanelMargenAbajo, java.awt.BorderLayout.SOUTH);

        PanelMargenIzquierda.setBackground(new java.awt.Color(255, 255, 255));
        PanelMargenIzquierda.setOpaque(false);
        PanelMargenIzquierda.setPreferredSize(new java.awt.Dimension(5, 5));
        PanelMargenIzquierda.setLayout(new java.awt.BorderLayout());
        add(PanelMargenIzquierda, java.awt.BorderLayout.WEST);

        PanelMargenDerecha.setOpaque(false);
        PanelMargenDerecha.setPreferredSize(new java.awt.Dimension(5, 5));
        PanelMargenDerecha.setLayout(new java.awt.BorderLayout());
        add(PanelMargenDerecha, java.awt.BorderLayout.EAST);
    }// </editor-fold>//GEN-END:initComponents

    private void seleccionarElemento(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_seleccionarElemento
        PGC.anadirElementoAPedido(this.LabelNombre.getText());
    }//GEN-LAST:event_seleccionarElemento


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LabelNombre;
    private javax.swing.JLabel LabelPrecio;
    private javax.swing.JPanel PanelCentral;
    private javax.swing.JPanel PanelDatos;
    private javax.swing.JPanel PanelDescripcion;
    private javax.swing.JPanel PanelFoto;
    private javax.swing.JPanel PanelMargenAbajo;
    private javax.swing.JPanel PanelMargenArriba;
    private javax.swing.JPanel PanelMargenDerecha;
    private javax.swing.JPanel PanelMargenIzquierda;
    private javax.swing.JPanel PanelPrecio;
    private javax.swing.JScrollPane ScrollDescripcion;
    private javax.swing.JTextPane TextoDescripcion;
    // End of variables declaration//GEN-END:variables

}