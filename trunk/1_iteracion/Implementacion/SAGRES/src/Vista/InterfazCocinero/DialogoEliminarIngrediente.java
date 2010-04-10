
package Vista.InterfazCocinero;

import GestionStock.GestionProductos.IGestionarProducto;
import GestionStock.GestionProductos.IProducto;
import GestionStock.GestionProductos.Ingrediente;
import Vista.DialogoComfirmacion;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Daniel Guerrero Martinez
 */
public class DialogoEliminarIngrediente extends java.awt.Dialog {


    private ImageIcon imagen;
    private IProducto almacenProductos;
    private IGestionarProducto gestorProductos;


    /** Creates new form DialogoAnadirElemento */
    public DialogoEliminarIngrediente(java.awt.Frame parent, IProducto AlmacenProductos, IGestionarProducto GestorProductos ) {
        super(parent, true);
        initComponents();
        this.gestorProductos = GestorProductos;
        this.almacenProductos = AlmacenProductos;
        ArrayList<Ingrediente> listaIngredientes = this.almacenProductos.obtenerListaIngredientes();
        this.bAceptar.setEnabled(false);
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn(this.tTablaIngredientes.getColumnName(0));
        modelo.addColumn(this.tTablaIngredientes.getColumnName(1));
        modelo.setRowCount(listaIngredientes.size());
        this.tTablaIngredientes.setModel(modelo);
        for (int i = 0; i < listaIngredientes.size(); i++) {
            this.tTablaIngredientes.setValueAt(listaIngredientes.get(i).getNombre(), i, 0);
            this.tTablaIngredientes.setValueAt(listaIngredientes.get(i).getCantidad(), i, 1);
        }
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
        pProductosDisponibles = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tTablaIngredientes = new javax.swing.JTable();
        pAtributoPlato2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tTablaDeshabilitados = new javax.swing.JTable();

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
        cabecera.setLayout(new java.awt.GridBagLayout());

        lTitulo.setFont(new java.awt.Font("Arial", 1, 14));
        lTitulo.setForeground(new java.awt.Color(80, 98, 143));
        lTitulo.setText("Eliminar Ingrediente");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 307;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 6, 6, 6);
        cabecera.add(lTitulo, gridBagConstraints);

        lSubtitulo.setFont(new java.awt.Font("Arial", 0, 14));
        lSubtitulo.setForeground(new java.awt.Color(80, 98, 143));
        lSubtitulo.setText("Seleccionar el ingrediente a eliminar");
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

        pie.setBackground(new java.awt.Color(255, 255, 255));
        pie.setLayout(new java.awt.GridBagLayout());

        bAceptar.setFont(new java.awt.Font("Arial", 0, 14));
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

        bCancelar.setFont(new java.awt.Font("Arial", 0, 14));
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

        pProductosDisponibles.setBackground(new java.awt.Color(255, 255, 255));
        pProductosDisponibles.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(211, 223, 253)), "Ingredienete a eliminar", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 14), new java.awt.Color(150, 172, 229))); // NOI18N
        pProductosDisponibles.setForeground(new java.awt.Color(80, 98, 143));
        pProductosDisponibles.setMinimumSize(new java.awt.Dimension(450, 250));
        pProductosDisponibles.setOpaque(false);
        pProductosDisponibles.setPreferredSize(new java.awt.Dimension(450, 250));
        pProductosDisponibles.setLayout(new java.awt.BorderLayout());

        jScrollPane2.setOpaque(false);
        jScrollPane2.setPreferredSize(new java.awt.Dimension(200, 200));

        tTablaIngredientes.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tTablaIngredientes.setForeground(new java.awt.Color(80, 98, 143));
        tTablaIngredientes.setModel(new javax.swing.table.DefaultTableModel(
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
        tTablaIngredientes.setGridColor(new java.awt.Color(211, 223, 253));
        tTablaIngredientes.setMinimumSize(new java.awt.Dimension(450, 3000));
        tTablaIngredientes.setPreferredSize(new java.awt.Dimension(450, 3000));
        tTablaIngredientes.getTableHeader().setReorderingAllowed(false);
        tTablaIngredientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                seleccionarIngrediente(evt);
            }
        });
        jScrollPane2.setViewportView(tTablaIngredientes);

        pProductosDisponibles.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(20, 8, 8, 8);
        cuerpo.add(pProductosDisponibles, gridBagConstraints);
        pProductosDisponibles.getAccessibleContext().setAccessibleName("Ingrediente a eliminar");

        pAtributoPlato2.setBackground(new java.awt.Color(255, 255, 255));
        pAtributoPlato2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(211, 223, 253)), "Se deshabilitarán los siguientes elementos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 14), new java.awt.Color(150, 172, 229))); // NOI18N
        pAtributoPlato2.setForeground(new java.awt.Color(80, 98, 143));
        pAtributoPlato2.setMinimumSize(new java.awt.Dimension(450, 250));
        pAtributoPlato2.setOpaque(false);
        pAtributoPlato2.setPreferredSize(new java.awt.Dimension(450, 250));
        pAtributoPlato2.setLayout(new java.awt.BorderLayout());

        jScrollPane3.setOpaque(false);

        tTablaDeshabilitados.setFont(new java.awt.Font("Arial", 0, 14));
        tTablaDeshabilitados.setForeground(new java.awt.Color(80, 98, 143));
        tTablaDeshabilitados.setModel(new javax.swing.table.DefaultTableModel(
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
        tTablaDeshabilitados.setGridColor(new java.awt.Color(211, 223, 253));
        tTablaDeshabilitados.setMinimumSize(new java.awt.Dimension(450, 250));
        tTablaDeshabilitados.setPreferredSize(new java.awt.Dimension(450, 250));
        tTablaDeshabilitados.getTableHeader().setResizingAllowed(false);
        tTablaDeshabilitados.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(tTablaDeshabilitados);

        pAtributoPlato2.add(jScrollPane3, java.awt.BorderLayout.CENTER);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(13, 8, 11, 8);
        cuerpo.add(pAtributoPlato2, gridBagConstraints);

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
        String subtitulo = this.lSubtitulo.getText();
        String pregunta = "¿Confirma que desea Elimnar el siguiente ingrediente?";
        int select = this.tTablaIngredientes.getSelectedRow();
        String texto = "Nombre: "+(String)this.tTablaIngredientes.getValueAt(select, 0)+
                "\nCantidad Disponible: "+((Float)this.tTablaIngredientes.getValueAt(select, 1));
        DialogoComfirmacion confirmar = new DialogoComfirmacion(null, subtitulo, pregunta, texto);
        confirmar.setLocationRelativeTo(this);
        confirmar.setVisible(true);
        if(confirmar.isAceptado()){
            try {
                this.gestorProductos.eliminarProducto(this.almacenProductos.obtenerListaIngredientes().get(select).getCodPro());
            } catch (Exception ex) {
            }
            setVisible(false);
            dispose();
        }
    }//GEN-LAST:event_Aceptar

    private void seleccionarIngrediente(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_seleccionarIngrediente
        if(this.tTablaIngredientes.getSelectedRow() != -1){
            this.bAceptar.setEnabled(true);
        }else{
            this.bAceptar.setEnabled(false);
        }
    }//GEN-LAST:event_seleccionarIngrediente



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bAceptar;
    private javax.swing.JButton bCancelar;
    private javax.swing.JPanel cabecera;
    private javax.swing.JPanel cuerpo;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lSubtitulo;
    private javax.swing.JLabel lTitulo;
    private javax.swing.JPanel pAtributoPlato2;
    private javax.swing.JPanel pProductosDisponibles;
    private javax.swing.JPanel pie;
    private javax.swing.JTable tTablaDeshabilitados;
    private javax.swing.JTable tTablaIngredientes;
    // End of variables declaration//GEN-END:variables
    
}