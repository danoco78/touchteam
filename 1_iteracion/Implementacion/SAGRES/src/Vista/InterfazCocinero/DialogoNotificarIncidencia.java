/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * DialogoAnadirElemento.java
 *
 * Created on 31-mar-2010, 11:36:27
 */
package Vista.InterfazCocinero;

import GestionStock.GestionIncidencias.IIncidencia;
import GestionStock.GestionProductos.IProducto;
import GestionStock.GestionProductos.Ingrediente;
import Vista.DialogoComfirmacion;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.ArrayList;
import utilidades.ImageRenderer;
import javax.swing.ImageIcon;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Daniel
 */
public class DialogoNotificarIncidencia extends javax.swing.JDialog {

    private final String SUBTITULOPASO1 = "Seleccionar el ingrediente afectado";
    private final String SUBTITULOPASO2 = "detallar el problema ocurrido";
    private final String PASO1 = "Paso 1/2";
    private final String PASO2 = "Paso 2/2";
    private int estado = 1;
    private ImageIcon imagen;
    private IProducto almacenProductos;
    private IIncidencia gestorIncidencias;

    /** Creates new form DialogoAnadirElemento */
    public DialogoNotificarIncidencia(java.awt.Frame parent, IProducto AlmacenProductos, IIncidencia GestorIncidencias) {
        super(parent, true);
        initComponents();
        this.gestorIncidencias = GestorIncidencias;
        this.almacenProductos = AlmacenProductos;
        ArrayList<Ingrediente> listaIngredientes = this.almacenProductos.obtenerListaIngredientes();
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn(this.tTablaIngredientesDisponibles.getColumnName(0));
        modelo.addColumn(this.tTablaIngredientesDisponibles.getColumnName(1));
        modelo.addColumn(this.tTablaIngredientesDisponibles.getColumnName(2));
        modelo.setRowCount(listaIngredientes.size());
        this.tTablaIngredientesDisponibles.setModel(modelo);
        this.tTablaIngredientesDisponibles.getColumnModel().getColumn(2).setCellRenderer(new ImageRenderer());
        this.tTablaIngredientesDisponibles.setRowHeight(50);
        for (int i = 0; i < listaIngredientes.size(); i++) {
            this.tTablaIngredientesDisponibles.setValueAt(listaIngredientes.get(i).getNombre(), i, 0);
            this.tTablaIngredientesDisponibles.setValueAt(listaIngredientes.get(i).getCantidad(), i, 1);
            this.tTablaIngredientesDisponibles.setValueAt(listaIngredientes.get(i).getImagen(), i, 2);
        }
        this.bSiguiente.setEnabled(false);
        this.estado = 1;
        this.bAnterior.setEnabled(false);
        this.dSelector.setFileFilter(new FileNameExtensionFilter("IMAGEN", "jpg", "jpeg", "png", "gif"));
    }

    @Override
    public void paint(Graphics g) {
        super.paintComponents(g);
        Graphics2D g2 = (Graphics2D) g.create();
        Rectangle clip = g2.getClipBounds();
        g2.setPaint(new GradientPaint(0.0f, 0.0f, new Color(170, 192, 249), getWidth(), 0.0f, new Color(255, 255, 255)));
        g2.fillRect(clip.x, clip.y, clip.width, clip.height);
        super.paint(g);
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        dSelector = new javax.swing.JFileChooser();
        cuerpo = new javax.swing.JPanel();
        pPaso1 = new javax.swing.JPanel();
        pIngredientesDisponibles = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tTablaIngredientesDisponibles = new javax.swing.JTable();
        pPaso2 = new javax.swing.JPanel();
        lNombre = new javax.swing.JLabel();
        lDescripcion = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tDescripcion = new javax.swing.JTextArea();
        lPrecio = new javax.swing.JLabel();
        € = new javax.swing.JLabel();
        pAlertas = new javax.swing.JPanel();
        lAlertas = new javax.swing.JLabel();
        tCantidadAfectada = new javax.swing.JFormattedTextField(new Float(0));
        cabecera = new javax.swing.JPanel();
        lTitulo = new javax.swing.JLabel();
        lSubtitulo = new javax.swing.JLabel();
        lPaso = new javax.swing.JLabel();
        bCancelar = new javax.swing.JButton();
        pie = new javax.swing.JPanel();
        bSiguiente = new javax.swing.JButton();
        bAnterior = new javax.swing.JButton();

        dSelector.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        setMinimumSize(new java.awt.Dimension(200, 200));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });

        cuerpo.setBackground(new java.awt.Color(255, 255, 255));
        cuerpo.setLayout(new java.awt.CardLayout());

        pPaso1.setBackground(new java.awt.Color(255, 255, 255));
        pPaso1.setForeground(new java.awt.Color(80, 98, 143));
        pPaso1.setMinimumSize(new java.awt.Dimension(500, 550));
        pPaso1.setOpaque(false);
        pPaso1.setPreferredSize(new java.awt.Dimension(500, 550));
        pPaso1.setLayout(new java.awt.GridBagLayout());

        pIngredientesDisponibles.setBackground(new java.awt.Color(255, 255, 255));
        pIngredientesDisponibles.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(211, 223, 253)), "Ingredientes disponibles", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 14), new java.awt.Color(150, 172, 229))); // NOI18N
        pIngredientesDisponibles.setForeground(new java.awt.Color(80, 98, 143));
        pIngredientesDisponibles.setMinimumSize(new java.awt.Dimension(450, 500));
        pIngredientesDisponibles.setOpaque(false);
        pIngredientesDisponibles.setPreferredSize(new java.awt.Dimension(470, 500));
        pIngredientesDisponibles.setLayout(new java.awt.BorderLayout());

        jScrollPane2.setOpaque(false);
        jScrollPane2.setPreferredSize(new java.awt.Dimension(200, 200));

        tTablaIngredientesDisponibles.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Cantidad", "Imagen"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Float.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tTablaIngredientesDisponibles.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        tTablaIngredientesDisponibles.setGridColor(new java.awt.Color(211, 223, 253));
        tTablaIngredientesDisponibles.setMinimumSize(new java.awt.Dimension(450, 500));
        tTablaIngredientesDisponibles.setPreferredSize(new java.awt.Dimension(450, 500));
        tTablaIngredientesDisponibles.getTableHeader().setReorderingAllowed(false);
        tTablaIngredientesDisponibles.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                seleccionarIngrediente(evt);
            }
        });
        jScrollPane2.setViewportView(tTablaIngredientesDisponibles);

        pIngredientesDisponibles.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(20, 8, 8, 8);
        pPaso1.add(pIngredientesDisponibles, gridBagConstraints);

        cuerpo.add(pPaso1, "Paso3");

        pPaso2.setBackground(new java.awt.Color(255, 255, 255));
        pPaso2.setForeground(new java.awt.Color(80, 98, 143));
        pPaso2.setMinimumSize(new java.awt.Dimension(500, 550));
        pPaso2.setOpaque(false);
        pPaso2.setPreferredSize(new java.awt.Dimension(500, 550));
        pPaso2.setLayout(new java.awt.GridBagLayout());

        lNombre.setFont(new java.awt.Font("Arial", 0, 14));
        lNombre.setForeground(new java.awt.Color(80, 98, 143));
        lNombre.setText("[Nombre Producto]");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(12, 11, 11, 11);
        pPaso2.add(lNombre, gridBagConstraints);

        lDescripcion.setFont(new java.awt.Font("Arial", 0, 14));
        lDescripcion.setForeground(new java.awt.Color(80, 98, 143));
        lDescripcion.setText("Descripción breve");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.insets = new java.awt.Insets(28, 11, 11, 11);
        pPaso2.add(lDescripcion, gridBagConstraints);

        tDescripcion.setColumns(20);
        tDescripcion.setFont(new java.awt.Font("Arial", 0, 14));
        tDescripcion.setForeground(new java.awt.Color(80, 98, 143));
        tDescripcion.setRows(2);
        tDescripcion.setAutoscrolls(false);
        tDescripcion.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(150, 172, 229), 3, true));
        jScrollPane1.setViewportView(tDescripcion);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 100;
        gridBagConstraints.ipady = 57;
        gridBagConstraints.insets = new java.awt.Insets(28, 11, 11, 11);
        pPaso2.add(jScrollPane1, gridBagConstraints);

        lPrecio.setFont(new java.awt.Font("Arial", 0, 14));
        lPrecio.setForeground(new java.awt.Color(80, 98, 143));
        lPrecio.setText("Cantidad afectada");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(28, 11, 11, 11);
        pPaso2.add(lPrecio, gridBagConstraints);

        €.setFont(new java.awt.Font("Arial", 0, 14));
        €.setForeground(new java.awt.Color(80, 98, 143));
        €.setText("(gr/litros/...)");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(28, 11, 11, 11);
        pPaso2.add(€, gridBagConstraints);

        pAlertas.setBackground(new java.awt.Color(255, 255, 255));
        pAlertas.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(211, 223, 253)), "Alerta", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 14), new java.awt.Color(150, 172, 229))); // NOI18N
        pAlertas.setForeground(new java.awt.Color(80, 98, 143));
        pAlertas.setOpaque(false);
        pAlertas.setPreferredSize(new java.awt.Dimension(114, 150));
        pAlertas.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        lAlertas.setFont(new java.awt.Font("Arial", 0, 14));
        lAlertas.setForeground(new java.awt.Color(80, 98, 143));
        lAlertas.setText("No habilitado");
        pAlertas.add(lAlertas);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipady = 47;
        gridBagConstraints.insets = new java.awt.Insets(28, 11, 11, 11);
        pPaso2.add(pAlertas, gridBagConstraints);

        tCantidadAfectada.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(150, 172, 229), 3, true));
        tCantidadAfectada.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        tCantidadAfectada.setMinimumSize(new java.awt.Dimension(150, 20));
        tCantidadAfectada.setPreferredSize(new java.awt.Dimension(150, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.insets = new java.awt.Insets(28, 11, 11, 11);
        pPaso2.add(tCantidadAfectada, gridBagConstraints);

        cuerpo.add(pPaso2, "Paso2");

        getContentPane().add(cuerpo, java.awt.BorderLayout.CENTER);

        cabecera.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(150, 172, 229), 2));
        cabecera.setMinimumSize(new java.awt.Dimension(150, 100));
        cabecera.setOpaque(false);
        cabecera.setPreferredSize(new java.awt.Dimension(150, 100));
        cabecera.setLayout(new java.awt.GridBagLayout());

        lTitulo.setFont(new java.awt.Font("Arial", 1, 14));
        lTitulo.setForeground(new java.awt.Color(80, 98, 143));
        lTitulo.setText("Notificar incidencia con ingrediente");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 120;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 6, 6, 6);
        cabecera.add(lTitulo, gridBagConstraints);

        lSubtitulo.setFont(new java.awt.Font("Arial", 0, 14));
        lSubtitulo.setForeground(new java.awt.Color(80, 98, 143));
        lSubtitulo.setText("Seleccionar el ingrediente afectado");
        lSubtitulo.setPreferredSize(new java.awt.Dimension(175, 50));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 6, 0, 6);
        cabecera.add(lSubtitulo, gridBagConstraints);

        lPaso.setFont(new java.awt.Font("Arial", 0, 14));
        lPaso.setForeground(new java.awt.Color(80, 98, 143));
        lPaso.setText("Paso 1/2");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 9;
        gridBagConstraints.insets = new java.awt.Insets(6, 11, 6, 11);
        cabecera.add(lPaso, gridBagConstraints);

        bCancelar.setFont(new java.awt.Font("Arial", 0, 12));
        bCancelar.setForeground(new java.awt.Color(150, 172, 229));
        bCancelar.setText("Cancelar");
        bCancelar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        bCancelar.setMaximumSize(new java.awt.Dimension(100, 45));
        bCancelar.setMinimumSize(new java.awt.Dimension(100, 45));
        bCancelar.setPreferredSize(new java.awt.Dimension(100, 45));
        bCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Salir(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridheight = 2;
        cabecera.add(bCancelar, gridBagConstraints);

        getContentPane().add(cabecera, java.awt.BorderLayout.NORTH);

        pie.setBackground(new java.awt.Color(255, 255, 255));
        pie.setLayout(new java.awt.GridBagLayout());

        bSiguiente.setFont(new java.awt.Font("Arial", 0, 14));
        bSiguiente.setForeground(new java.awt.Color(80, 98, 143));
        bSiguiente.setText("Siguiente");
        bSiguiente.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        bSiguiente.setMinimumSize(new java.awt.Dimension(100, 50));
        bSiguiente.setPreferredSize(new java.awt.Dimension(125, 75));
        bSiguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                siguiente(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 25;
        gridBagConstraints.ipady = 25;
        gridBagConstraints.insets = new java.awt.Insets(9, 80, 9, 9);
        pie.add(bSiguiente, gridBagConstraints);

        bAnterior.setFont(new java.awt.Font("Arial", 0, 14));
        bAnterior.setForeground(new java.awt.Color(80, 98, 143));
        bAnterior.setText("Anterior");
        bAnterior.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        bAnterior.setMargin(new java.awt.Insets(20, 20, 20, 20));
        bAnterior.setMinimumSize(new java.awt.Dimension(100, 50));
        bAnterior.setPreferredSize(new java.awt.Dimension(125, 75));
        bAnterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                anterior(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 25;
        gridBagConstraints.ipady = 25;
        gridBagConstraints.insets = new java.awt.Insets(9, 9, 9, 80);
        pie.add(bAnterior, gridBagConstraints);

        getContentPane().add(pie, java.awt.BorderLayout.SOUTH);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void closeDialog(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_closeDialog
        setVisible(false);
        dispose();
    }//GEN-LAST:event_closeDialog

    private void siguiente(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_siguiente
        CardLayout cl = (CardLayout) (this.cuerpo.getLayout());
        switch (this.estado) {
            case 1:
                //Validar Datos
                this.lSubtitulo.setText(SUBTITULOPASO2);
                this.lPaso.setText(PASO2);
                this.bAnterior.setEnabled(true);
                this.estado++;
                this.lNombre.setText((String) this.tTablaIngredientesDisponibles.getValueAt(this.tTablaIngredientesDisponibles.getSelectedRow(), 0));
                cl.next(this.cuerpo);
                break;
            case 2:
                String subtitulo = this.lSubtitulo.getText();
                String pregunta = "¿Confirma que desea Notificar la incidencia?";
                String texto = "Nombre: " + this.lNombre.getText()
                        + "\nDescripción: " + this.tDescripcion.getText()
                        + "\nCantidad Afectada: " + (Float) this.tCantidadAfectada.getValue();
                DialogoComfirmacion confirmar = new DialogoComfirmacion(null, subtitulo, pregunta, texto);
                confirmar.setLocationRelativeTo(this);
                confirmar.setVisible(true);
                if (confirmar.isAceptado()) {
                    this.gestorIncidencias.nuevaIncidencia(this.tDescripcion.getText(), (Float) this.tCantidadAfectada.getValue(), this.almacenProductos.obtenerListaIngredientes().get(this.tTablaIngredientesDisponibles.getSelectedRow()));
                    setVisible(false);
                    dispose();
                }
                break;
        }

    }//GEN-LAST:event_siguiente

    private void anterior(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_anterior
        CardLayout cl = (CardLayout) (this.cuerpo.getLayout());
        switch (this.estado) {
            case 2:
                this.lSubtitulo.setText(SUBTITULOPASO1);
                this.lPaso.setText(PASO1);
                this.bAnterior.setEnabled(false);
                this.estado--;
                cl.previous(this.cuerpo);
                break;
        }
    }//GEN-LAST:event_anterior

    private void Salir(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Salir
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_Salir

    private void seleccionarIngrediente(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_seleccionarIngrediente
        if (this.tTablaIngredientesDisponibles.getSelectedRow() != -1) {
            this.bSiguiente.setEnabled(true);
        } else {
            this.bSiguiente.setEnabled(false);
        }
    }//GEN-LAST:event_seleccionarIngrediente
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bAnterior;
    private javax.swing.JButton bCancelar;
    private javax.swing.JButton bSiguiente;
    private javax.swing.JPanel cabecera;
    private javax.swing.JPanel cuerpo;
    private javax.swing.JFileChooser dSelector;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lAlertas;
    private javax.swing.JLabel lDescripcion;
    private javax.swing.JLabel lNombre;
    private javax.swing.JLabel lPaso;
    private javax.swing.JLabel lPrecio;
    private javax.swing.JLabel lSubtitulo;
    private javax.swing.JLabel lTitulo;
    private javax.swing.JPanel pAlertas;
    private javax.swing.JPanel pIngredientesDisponibles;
    private javax.swing.JPanel pPaso1;
    private javax.swing.JPanel pPaso2;
    private javax.swing.JPanel pie;
    private javax.swing.JFormattedTextField tCantidadAfectada;
    private javax.swing.JTextArea tDescripcion;
    private javax.swing.JTable tTablaIngredientesDisponibles;
    private javax.swing.JLabel €;
    // End of variables declaration//GEN-END:variables
}
