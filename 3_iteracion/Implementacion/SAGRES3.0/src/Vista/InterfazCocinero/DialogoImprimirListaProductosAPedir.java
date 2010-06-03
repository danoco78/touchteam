

package Vista.InterfazCocinero;

import ControladorPrincipal.ICocinero;
import GestionStock.GestionPedidoProveedor.IPedidoProveedor;
import GestionStock.GestionProductos.IProducto;
import GestionStock.GestionProductos.Producto;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Daniel Guerrero Martinez
 */
public class DialogoImprimirListaProductosAPedir extends java.awt.Dialog {


    private ImageIcon imagen;
    private ICocinero icocinero;


    /** Creates new form DialogoAnadirElemento */
    public DialogoImprimirListaProductosAPedir(java.awt.Frame parent, ICocinero iCocinero) {
        super(parent, true);
        initComponents();
        this.icocinero = iCocinero;
        DefaultTableModel modelo = (DefaultTableModel)this.tTablaProductos.getModel();
        HashMap<Producto, Float> lista = this.icocinero.obtieneProductosBajoMinimos();
        Iterator<Entry<Producto,Float> > it = lista.entrySet().iterator();
        for (int i = 0; it.hasNext(); i++) {
            Entry<Producto,Float> aux = it.next();
            Object [] obj = new Object[2];
            obj[0] = aux.getKey().getNombre();
            obj[1] = aux.getValue();
            modelo.addRow(obj);
        }
        if(modelo.getRowCount() == 0)
            this.bAceptar.setEnabled(false);
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


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        cabecera = new javax.swing.JPanel();
        lTitulo = new javax.swing.JLabel();
        lSubtitulo = new javax.swing.JLabel();
        pie = new javax.swing.JPanel();
        bAceptar = new javax.swing.JButton();
        bCancelar = new javax.swing.JButton();
        cuerpo = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tTablaProductos = new javax.swing.JTable();
        lProductosAPedir = new javax.swing.JLabel();

        setLocationRelativeTo(null);
        setMinimumSize(new java.awt.Dimension(200, 200));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });

        cabecera.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(150, 172, 229), 2));
        cabecera.setMinimumSize(new java.awt.Dimension(150, 100));
        cabecera.setOpaque(false);
        cabecera.setPreferredSize(new java.awt.Dimension(150, 100));
        cabecera.setLayout(new java.awt.GridLayout(0, 1));

        lTitulo.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        lTitulo.setForeground(new java.awt.Color(80, 98, 143));
        lTitulo.setText("Notificación");
        cabecera.add(lTitulo);

        lSubtitulo.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lSubtitulo.setForeground(new java.awt.Color(80, 98, 143));
        lSubtitulo.setText("Listar productos a pedir");
        lSubtitulo.setPreferredSize(new java.awt.Dimension(175, 50));
        cabecera.add(lSubtitulo);

        add(cabecera, java.awt.BorderLayout.NORTH);

        pie.setBackground(new java.awt.Color(255, 255, 255));
        pie.setLayout(new java.awt.GridBagLayout());

        bAceptar.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
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
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 25;
        gridBagConstraints.ipady = 25;
        gridBagConstraints.insets = new java.awt.Insets(9, 80, 9, 9);
        pie.add(bAceptar, gridBagConstraints);

        bCancelar.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        bCancelar.setForeground(new java.awt.Color(80, 98, 143));
        bCancelar.setText("Cancelar");
        bCancelar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        bCancelar.setMargin(new java.awt.Insets(20, 20, 20, 20));
        bCancelar.setMinimumSize(new java.awt.Dimension(100, 50));
        bCancelar.setPreferredSize(new java.awt.Dimension(125, 75));
        bCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Salir(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 25;
        gridBagConstraints.ipady = 25;
        gridBagConstraints.insets = new java.awt.Insets(9, 9, 9, 80);
        pie.add(bCancelar, gridBagConstraints);

        add(pie, java.awt.BorderLayout.SOUTH);

        cuerpo.setBackground(new java.awt.Color(255, 255, 255));
        cuerpo.setForeground(new java.awt.Color(80, 98, 143));
        cuerpo.setMinimumSize(new java.awt.Dimension(500, 550));
        cuerpo.setPreferredSize(new java.awt.Dimension(500, 550));
        cuerpo.setLayout(new java.awt.GridBagLayout());

        jScrollPane2.setOpaque(false);
        jScrollPane2.setPreferredSize(new java.awt.Dimension(200, 200));

        tTablaProductos.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        tTablaProductos.setForeground(new java.awt.Color(80, 98, 143));
        tTablaProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Cantidad"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Float.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tTablaProductos.setEnabled(false);
        tTablaProductos.setGridColor(new java.awt.Color(211, 223, 253));
        tTablaProductos.setMinimumSize(new java.awt.Dimension(450, 550));
        tTablaProductos.setPreferredSize(new java.awt.Dimension(450, 550));
        tTablaProductos.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tTablaProductos);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipady = 280;
        cuerpo.add(jScrollPane2, gridBagConstraints);

        lProductosAPedir.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lProductosAPedir.setForeground(new java.awt.Color(80, 98, 143));
        lProductosAPedir.setText("Se van a pedir los siguientes productos");
        lProductosAPedir.setPreferredSize(new java.awt.Dimension(175, 50));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 263;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        cuerpo.add(lProductosAPedir, gridBagConstraints);

        add(cuerpo, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void closeDialog(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_closeDialog
        setVisible(false);
        dispose();
    }//GEN-LAST:event_closeDialog

    private void Salir(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Salir
        this.setVisible(false);
    }//GEN-LAST:event_Salir

    private void Aceptar(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Aceptar
        try {
            this.icocinero.imprimeListaProductosaPedir();
            setVisible(false);
            dispose();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }//GEN-LAST:event_Aceptar



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bAceptar;
    private javax.swing.JButton bCancelar;
    private javax.swing.JPanel cabecera;
    private javax.swing.JPanel cuerpo;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lProductosAPedir;
    private javax.swing.JLabel lSubtitulo;
    private javax.swing.JLabel lTitulo;
    private javax.swing.JPanel pie;
    private javax.swing.JTable tTablaProductos;
    // End of variables declaration//GEN-END:variables
    
}
