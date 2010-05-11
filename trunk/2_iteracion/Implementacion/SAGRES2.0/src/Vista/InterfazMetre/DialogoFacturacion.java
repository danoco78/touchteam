/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * DialogoAnadirElemento.java
 *
 * Created on 31-mar-2010, 11:36:27
 */

package Vista.InterfazMetre;

import GestionPedidos.ElementoPedido;
import GestionPedidos.Factura;
import GestionPedidos.Pedido;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.ArrayList;

/**
 *
 * @author Daniel
 */
public class DialogoFacturacion extends java.awt.Dialog {

    InterfazMetre controlador = null;
    Factura fac;
    int codMesa;
    
    public static final boolean ACEPTAR = true;
    public static final boolean CANCELAR = false;

    private boolean estado = CANCELAR;

    /** Creates new form DialogoAnadirElemento */
    public DialogoFacturacion(java.awt.Frame parent,int codMesa) {
        super(parent, true);
        initComponents();

        controlador = (InterfazMetre) parent;
        this.codMesa = codMesa;
        fac = controlador.imetre.getFactura(codMesa);
        ArrayList<Pedido> pedidos = fac.getPedidos();
        ArrayList<ElementoPedido> elems;
        float total = 0;
        String datos = new String();
        String nombre;
        for (int i=0;i<pedidos.size();i++){
            elems = pedidos.get(i).obtieneElementos();
            for (int j=0;j<elems.size();j++){
                nombre = elems.get(j).getElemento().getNombre();
                datos += nombre;
                for (int z=0;z<50-nombre.length();z++)
                    datos += " ";
                datos += String.valueOf(elems.get(j).getElemento().getPrecio())+"€\n";
                total += elems.get(j).getElemento().getPrecio();
            }
        }
        this.ltotal.setText("Total: "+String.valueOf(total)+"€");
        this.tConfirma.setText(datos);
    }


    @Override
    public void paint(Graphics g) {
        super.paintComponents(g);
        Graphics2D g2 = (Graphics2D) g.create();
        Rectangle clip = g2.getClipBounds();
        g2.setPaint(new GradientPaint(0.0f, 0.0f, new Color(170, 192, 249) ,getWidth() ,0.0f, new Color(255, 255, 255) ));
        g2.fillRect(clip.x, clip.y, clip.width, clip.height);
        super.paint(g);
    }

    public boolean isAceptado(){
        return this.estado;
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        pie = new javax.swing.JPanel();
        bCancelar1 = new javax.swing.JButton();
        bImprimir = new javax.swing.JButton();
        bAceptar = new javax.swing.JButton();
        cabecera = new javax.swing.JPanel();
        lTitulo = new javax.swing.JLabel();
        lSubtitulo = new javax.swing.JLabel();
        cuerpo = new javax.swing.JPanel();
        margenIzq = new javax.swing.JPanel();
        margenDer = new javax.swing.JPanel();
        pCentral = new javax.swing.JPanel();
        lConfirma = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tConfirma = new javax.swing.JTextArea();
        ltotal = new javax.swing.JLabel();
        margenSup = new javax.swing.JPanel();
        margenInf = new javax.swing.JPanel();

        setLocationRelativeTo(null);
        setMinimumSize(new java.awt.Dimension(200, 200));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });

        pie.setBackground(new java.awt.Color(255, 255, 255));
        pie.setPreferredSize(new java.awt.Dimension(478, 85));
        pie.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 30, 5));

        bCancelar1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        bCancelar1.setForeground(new java.awt.Color(80, 98, 143));
        bCancelar1.setText("Cancelar");
        bCancelar1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        bCancelar1.setMargin(new java.awt.Insets(20, 20, 20, 20));
        bCancelar1.setMinimumSize(new java.awt.Dimension(100, 50));
        bCancelar1.setPreferredSize(new java.awt.Dimension(125, 75));
        bCancelar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCancelar1Salir(evt);
            }
        });
        pie.add(bCancelar1);

        bImprimir.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        bImprimir.setForeground(new java.awt.Color(80, 98, 143));
        bImprimir.setText("Imprimir");
        bImprimir.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        bImprimir.setMinimumSize(new java.awt.Dimension(100, 50));
        bImprimir.setPreferredSize(new java.awt.Dimension(125, 75));
        bImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bImprimir(evt);
            }
        });
        pie.add(bImprimir);

        bAceptar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        bAceptar.setForeground(new java.awt.Color(80, 98, 143));
        bAceptar.setText("Aceptar");
        bAceptar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        bAceptar.setMinimumSize(new java.awt.Dimension(100, 50));
        bAceptar.setPreferredSize(new java.awt.Dimension(125, 75));
        bAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Aceptar(evt);
            }
        });
        pie.add(bAceptar);

        add(pie, java.awt.BorderLayout.SOUTH);

        cabecera.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(150, 172, 229), 2));
        cabecera.setMinimumSize(new java.awt.Dimension(150, 100));
        cabecera.setOpaque(false);
        cabecera.setPreferredSize(new java.awt.Dimension(150, 100));
        cabecera.setLayout(new java.awt.GridBagLayout());

        lTitulo.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lTitulo.setForeground(new java.awt.Color(80, 98, 143));
        lTitulo.setText("Confirmación");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 355;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 6, 6, 6);
        cabecera.add(lTitulo, gridBagConstraints);

        lSubtitulo.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lSubtitulo.setForeground(new java.awt.Color(80, 98, 143));
        lSubtitulo.setText("Facturar pedido");
        lSubtitulo.setPreferredSize(new java.awt.Dimension(175, 50));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 15;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 6, 0, 6);
        cabecera.add(lSubtitulo, gridBagConstraints);

        add(cabecera, java.awt.BorderLayout.NORTH);

        cuerpo.setBackground(new java.awt.Color(255, 255, 255));
        cuerpo.setMinimumSize(new java.awt.Dimension(500, 550));
        cuerpo.setPreferredSize(new java.awt.Dimension(500, 550));
        cuerpo.setLayout(new java.awt.BorderLayout());

        margenIzq.setOpaque(false);
        cuerpo.add(margenIzq, java.awt.BorderLayout.EAST);

        margenDer.setOpaque(false);
        cuerpo.add(margenDer, java.awt.BorderLayout.WEST);

        pCentral.setLayout(new java.awt.BorderLayout());

        lConfirma.setBackground(new java.awt.Color(255, 255, 255));
        lConfirma.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lConfirma.setForeground(new java.awt.Color(80, 98, 143));
        lConfirma.setText("¿Desea marcar la factura como pagada?");
        lConfirma.setOpaque(true);
        lConfirma.setPreferredSize(new java.awt.Dimension(259, 30));
        pCentral.add(lConfirma, java.awt.BorderLayout.NORTH);

        jScrollPane1.setPreferredSize(new java.awt.Dimension(450, 480));

        tConfirma.setColumns(20);
        tConfirma.setRows(5);
        tConfirma.setPreferredSize(new java.awt.Dimension(164, 400));
        jScrollPane1.setViewportView(tConfirma);

        pCentral.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        ltotal.setBackground(new java.awt.Color(255, 255, 255));
        ltotal.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        ltotal.setForeground(new java.awt.Color(80, 98, 143));
        ltotal.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        ltotal.setText("Total:");
        ltotal.setOpaque(true);
        ltotal.setPreferredSize(new java.awt.Dimension(36, 30));
        pCentral.add(ltotal, java.awt.BorderLayout.SOUTH);

        cuerpo.add(pCentral, java.awt.BorderLayout.CENTER);

        margenSup.setOpaque(false);
        cuerpo.add(margenSup, java.awt.BorderLayout.NORTH);

        margenInf.setOpaque(false);
        cuerpo.add(margenInf, java.awt.BorderLayout.SOUTH);

        add(cuerpo, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void closeDialog(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_closeDialog
        setVisible(false);
        dispose();
    }//GEN-LAST:event_closeDialog

    private void bCancelar1Salir(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCancelar1Salir
        this.estado = DialogoFacturacion.CANCELAR;
        this.setVisible(false);
        this.dispose();
}//GEN-LAST:event_bCancelar1Salir

    private void Aceptar(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Aceptar
        this.estado = DialogoFacturacion.ACEPTAR;
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_Aceptar

    private void bImprimir(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bImprimir
        controlador.imetre.imprimeFactura(codMesa);
    }//GEN-LAST:event_bImprimir



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bAceptar;
    private javax.swing.JButton bCancelar1;
    private javax.swing.JButton bImprimir;
    private javax.swing.JPanel cabecera;
    private javax.swing.JPanel cuerpo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lConfirma;
    private javax.swing.JLabel lSubtitulo;
    private javax.swing.JLabel lTitulo;
    private javax.swing.JLabel ltotal;
    private javax.swing.JPanel margenDer;
    private javax.swing.JPanel margenInf;
    private javax.swing.JPanel margenIzq;
    private javax.swing.JPanel margenSup;
    private javax.swing.JPanel pCentral;
    private javax.swing.JPanel pie;
    private javax.swing.JTextArea tConfirma;
    // End of variables declaration//GEN-END:variables
    
}
