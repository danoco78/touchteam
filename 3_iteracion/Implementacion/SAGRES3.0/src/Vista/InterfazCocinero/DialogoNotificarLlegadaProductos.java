
package Vista.InterfazCocinero;

import ControladorPrincipal.ICocinero;
import GestionStock.GestionPedidoProveedor.PedidoProveedor;
import GestionStock.GestionProductos.Producto;
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
public class DialogoNotificarLlegadaProductos extends java.awt.Dialog {


    private ImageIcon imagen;
    private ICocinero gestorPedido;

    /** Creates new form DialogoAnadirElemento */
    public DialogoNotificarLlegadaProductos(java.awt.Frame parent,ICocinero GestorPedido) {
        super(parent, true);
        initComponents();
        this.gestorPedido = GestorPedido;
        PedidoProveedor pedido = this.gestorPedido.obtienePedidoProveedor();
        if(pedido != null){
            HashMap<Producto,Float> p = pedido.obtenerInfoPedido();
            DefaultTableModel modelo = new DefaultTableModel() {
                //Hace que las celdas sean no editables
                @Override
                public boolean isCellEditable(int x, int y) {
                    return false;
                }
            };
            modelo.addColumn(this.tTablaProductosRecibidos.getColumnName(0));
            modelo.addColumn(this.tTablaProductosRecibidos.getColumnName(1));
            modelo.setRowCount(p.size());
            Iterator<Entry<Producto,Float> > it = p.entrySet().iterator();
            int i = 0;
            while(it.hasNext()){
                Entry<Producto,Float> e = it.next();
                modelo.setValueAt(e.getKey().getNombre(), i, 0);
                modelo.setValueAt(e.getValue(), i, 1);
                i++;
            }
            this.tTablaProductosRecibidos.setModel(modelo);
            this.repaint();
        }else{
            this.dispose();
            JOptionPane.showMessageDialog(parent, "No hay ningun pedido por recibir");
        }
    }


    /*@Override
    public void paint(Graphics g) {
        super.paintComponents(g);
        Graphics2D g2 = (Graphics2D) g.create();
        Rectangle clip = g2.getClipBounds();
        g2.setPaint(new GradientPaint(0.0f, 0.0f, new Color(170, 192, 249) ,getWidth() ,0.0f, new Color(255, 255, 255) ));
        g2.fillRect(clip.x, clip.y, clip.width, clip.height);
        super.paint(g);
    }*/


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        cabecera = new utilidades.PanelCabeceras();
        lTitulo = new javax.swing.JLabel();
        lSubtitulo = new javax.swing.JLabel();
        pie = new javax.swing.JPanel();
        bAceptar = new javax.swing.JButton();
        bCancelar = new javax.swing.JButton();
        cuerpo = new javax.swing.JPanel();
        pProductosPedidos = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tTablaProductosRecibidos = new javax.swing.JTable();
        pPlatosHabilitados = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tPlatosHabilitados = new javax.swing.JTable();

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

        lTitulo.setFont(new java.awt.Font("Arial", 1, 24));
        lTitulo.setForeground(new java.awt.Color(80, 98, 143));
        lTitulo.setText("Notificación");
        cabecera.add(lTitulo);

        lSubtitulo.setFont(new java.awt.Font("Arial", 0, 18));
        lSubtitulo.setForeground(new java.awt.Color(80, 98, 143));
        lSubtitulo.setText("Llegada de producotos pedido");
        lSubtitulo.setPreferredSize(new java.awt.Dimension(175, 50));
        cabecera.add(lSubtitulo);

        add(cabecera, java.awt.BorderLayout.NORTH);

        pie.setBackground(new java.awt.Color(255, 255, 255));
        pie.setLayout(new java.awt.GridBagLayout());

        bAceptar.setFont(new java.awt.Font("Arial", 0, 24));
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

        bCancelar.setFont(new java.awt.Font("Arial", 0, 24));
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

        pProductosPedidos.setBackground(new java.awt.Color(255, 255, 255));
        pProductosPedidos.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(211, 223, 253)), "Se confirma la llegada de los siguientes productos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 18), new java.awt.Color(150, 172, 229))); // NOI18N
        pProductosPedidos.setForeground(new java.awt.Color(80, 98, 143));
        pProductosPedidos.setMinimumSize(new java.awt.Dimension(450, 250));
        pProductosPedidos.setOpaque(false);
        pProductosPedidos.setPreferredSize(new java.awt.Dimension(450, 250));
        pProductosPedidos.setLayout(new java.awt.BorderLayout());

        jScrollPane2.setOpaque(false);
        jScrollPane2.setPreferredSize(new java.awt.Dimension(200, 200));

        tTablaProductosRecibidos.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        tTablaProductosRecibidos.setForeground(new java.awt.Color(80, 98, 143));
        tTablaProductosRecibidos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"NO HAY PEDIDOS POR RECIBIR", null}
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
        tTablaProductosRecibidos.setGridColor(new java.awt.Color(211, 223, 253));
        tTablaProductosRecibidos.setMinimumSize(new java.awt.Dimension(450, 250));
        tTablaProductosRecibidos.setPreferredSize(new java.awt.Dimension(450, 250));
        tTablaProductosRecibidos.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tTablaProductosRecibidos);

        pProductosPedidos.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(20, 8, 8, 8);
        cuerpo.add(pProductosPedidos, gridBagConstraints);

        pPlatosHabilitados.setBackground(new java.awt.Color(255, 255, 255));
        pPlatosHabilitados.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(211, 223, 253)), "Se habilitarán los siguientes elementos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 18), new java.awt.Color(150, 172, 229))); // NOI18N
        pPlatosHabilitados.setForeground(new java.awt.Color(80, 98, 143));
        pPlatosHabilitados.setMinimumSize(new java.awt.Dimension(450, 250));
        pPlatosHabilitados.setOpaque(false);
        pPlatosHabilitados.setPreferredSize(new java.awt.Dimension(450, 250));
        pPlatosHabilitados.setLayout(new java.awt.BorderLayout());

        jScrollPane3.setOpaque(false);

        tPlatosHabilitados.setFont(new java.awt.Font("Arial", 0, 18));
        tPlatosHabilitados.setForeground(new java.awt.Color(80, 98, 143));
        tPlatosHabilitados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"NO HABILITADO", null}
            },
            new String [] {
                "Nombre", "Sección"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
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
        tPlatosHabilitados.setGridColor(new java.awt.Color(211, 223, 253));
        tPlatosHabilitados.setMinimumSize(new java.awt.Dimension(450, 250));
        tPlatosHabilitados.setPreferredSize(new java.awt.Dimension(450, 250));
        tPlatosHabilitados.getTableHeader().setResizingAllowed(false);
        tPlatosHabilitados.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(tPlatosHabilitados);

        pPlatosHabilitados.add(jScrollPane3, java.awt.BorderLayout.CENTER);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(13, 8, 11, 8);
        cuerpo.add(pPlatosHabilitados, gridBagConstraints);

        add(cuerpo, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void closeDialog(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_closeDialog
        setVisible(false);
        dispose();
    }//GEN-LAST:event_closeDialog

    private void Salir(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Salir
        this.setVisible(false);
        dispose();
    }//GEN-LAST:event_Salir

    private void Aceptar(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Aceptar
        try {
            PedidoProveedor pedidoProveedor = this.gestorPedido.obtienePedidoProveedor();
            if(pedidoProveedor != null)
                this.gestorPedido.notificaRecepcionPedido(pedidoProveedor);
            else{
                JOptionPane.showMessageDialog(this, "No hay ningun pedido por recibir");
            }
            this.dispose();
        dispose();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "No hay ningun pedido por recibir");
        }
    }//GEN-LAST:event_Aceptar



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bAceptar;
    private javax.swing.JButton bCancelar;
    private javax.swing.JPanel cabecera;
    private javax.swing.JPanel cuerpo;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lSubtitulo;
    private javax.swing.JLabel lTitulo;
    private javax.swing.JPanel pPlatosHabilitados;
    private javax.swing.JPanel pProductosPedidos;
    private javax.swing.JPanel pie;
    private javax.swing.JTable tPlatosHabilitados;
    private javax.swing.JTable tTablaProductosRecibidos;
    // End of variables declaration//GEN-END:variables
    
}
