
package Vista.InterfazMetre;

import ControladorPrincipal.IMetre;
import GestionStock.GestionIncidencias.Incidencia;
import GestionStock.GestionProductos.Bebida;
import GestionStock.GestionProductos.Producto;
import Vista.DialogoConfirmacion;
import java.awt.CardLayout;
import java.util.HashSet;
import java.util.Iterator;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Daniel Guerrero Martinez y Jose David Dionisio Ruiz
 */
public class DialogoNotificarIncidenciaBebida extends java.awt.Dialog {

    private final String SUBTITULOPASO1 = "Seleccionar el bebida afectada";
    private final String SUBTITULOPASO2 = "detallar el problema ocurrido";
    private final String PASO1 = "Paso 1/2";
    private final String PASO2 = "Paso 2/2";
    private int estado = 1;
    private int bebidaSeleccionada;
    private IMetre metre;
    private HashSet<Producto> listaBebidas;
    private Bebida accidentado;

    /** Creates new form DialogoAnadirElemento */
    public DialogoNotificarIncidenciaBebida(java.awt.Frame parent,IMetre iMetre) {
        super(parent, true);
        initComponents();
        this.estado=1;
        this.metre = iMetre;
        this.listaBebidas = this.metre.obtenerBebidas();
        DefaultTableModel tableModel = new DefaultTableModel() {
            //Hace que las celdas sean no editables
            @Override
            public boolean isCellEditable(int x, int y) {
                return false;
            }
        };
        tableModel.addColumn(this.tTablaIngredientesDisponibles.getColumnName(0));
        tableModel.addColumn(this.tTablaIngredientesDisponibles.getColumnName(1));
        tableModel.setRowCount(listaBebidas.size());
        this.tTablaIngredientesDisponibles.setModel(tableModel);
        Iterator iterador = listaBebidas.iterator();
        Producto p;
        int i = 0;
	while (iterador.hasNext()) {
            p = (Producto)iterador.next();
            this.tTablaIngredientesDisponibles.setValueAt(p.getNombre(), i, 0);
            this.tTablaIngredientesDisponibles.setValueAt(p.getCantidad(), i, 1);
            //this.tTablaIngredientesDisponibles.setValueAt(p.getImagen(), i, 2);
            ++i;
	}
        this.bSiguiente.setEnabled(false);
        this.bAnterior.setEnabled(false);
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

        cuerpo = new javax.swing.JPanel();
        pPaso1 = new javax.swing.JPanel();
        pIngredientesDisponibles = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tTablaIngredientesDisponibles = new javax.swing.JTable();
        pPaso2 = new javax.swing.JPanel();
        pCentro = new javax.swing.JPanel();
        lNombre = new javax.swing.JLabel();
        pDescripcion = new javax.swing.JPanel();
        lDescripción = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tDescripcion = new javax.swing.JTextArea();
        pCantidad = new javax.swing.JPanel();
        lPrecio = new javax.swing.JLabel();
        tCantidadAfectada = new javax.swing.JFormattedTextField(new Float(0));
        € = new javax.swing.JLabel();
        pAlertas = new javax.swing.JPanel();
        lAlertas = new javax.swing.JLabel();
        pMargen = new javax.swing.JPanel();
        pMargen1 = new javax.swing.JPanel();
        pMargen2 = new javax.swing.JPanel();
        pMargen3 = new javax.swing.JPanel();
        cabecera = new utilidades.PanelCabeceras();
        pIzq = new javax.swing.JPanel();
        lTitulo = new javax.swing.JLabel();
        lSubtitulo = new javax.swing.JLabel();
        pDer = new javax.swing.JPanel();
        lPaso = new javax.swing.JLabel();
        bCancelar = new javax.swing.JButton();
        pie = new javax.swing.JPanel();
        bSiguiente = new javax.swing.JButton();
        bAnterior = new javax.swing.JButton();

        setLocationRelativeTo(null);
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
        pIngredientesDisponibles.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(211, 223, 253)), "Bebidas disponibles", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 18), new java.awt.Color(150, 172, 229))); // NOI18N
        pIngredientesDisponibles.setForeground(new java.awt.Color(80, 98, 143));
        pIngredientesDisponibles.setMinimumSize(new java.awt.Dimension(450, 500));
        pIngredientesDisponibles.setOpaque(false);
        pIngredientesDisponibles.setPreferredSize(new java.awt.Dimension(470, 500));
        pIngredientesDisponibles.setLayout(new java.awt.BorderLayout());

        jScrollPane2.setOpaque(false);
        jScrollPane2.setPreferredSize(new java.awt.Dimension(200, 200));

        tTablaIngredientesDisponibles.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tTablaIngredientesDisponibles.setModel(new javax.swing.table.DefaultTableModel(
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
        tTablaIngredientesDisponibles.setGridColor(new java.awt.Color(211, 223, 253));
        tTablaIngredientesDisponibles.setMinimumSize(new java.awt.Dimension(450, 500));
        tTablaIngredientesDisponibles.setPreferredSize(new java.awt.Dimension(450, 500));
        tTablaIngredientesDisponibles.getTableHeader().setReorderingAllowed(false);
        tTablaIngredientesDisponibles.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                validarFormulario(evt);
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
        pPaso2.setLayout(new java.awt.BorderLayout());

        pCentro.setOpaque(false);
        pCentro.setLayout(new java.awt.GridLayout(0, 1, 0, 10));

        lNombre.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        lNombre.setForeground(new java.awt.Color(80, 98, 143));
        lNombre.setText("[Nombre Producto]");
        pCentro.add(lNombre);

        pDescripcion.setOpaque(false);
        pDescripcion.setLayout(new java.awt.BorderLayout(10, 0));

        lDescripción.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lDescripción.setForeground(new java.awt.Color(80, 98, 143));
        lDescripción.setText("Descripción breve");
        lDescripción.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        lDescripción.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        pDescripcion.add(lDescripción, java.awt.BorderLayout.WEST);

        tDescripcion.setColumns(20);
        tDescripcion.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        tDescripcion.setForeground(new java.awt.Color(80, 98, 143));
        tDescripcion.setRows(2);
        tDescripcion.setAutoscrolls(false);
        tDescripcion.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(150, 172, 229), 3, true));
        jScrollPane1.setViewportView(tDescripcion);

        pDescripcion.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        pCentro.add(pDescripcion);

        pCantidad.setOpaque(false);
        pCantidad.setLayout(new java.awt.BorderLayout(10, 0));

        lPrecio.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lPrecio.setForeground(new java.awt.Color(80, 98, 143));
        lPrecio.setText("Cantidad afectada");
        pCantidad.add(lPrecio, java.awt.BorderLayout.WEST);

        tCantidadAfectada.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(150, 172, 229), 3, true));
        tCantidadAfectada.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        tCantidadAfectada.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tCantidadAfectada.setMinimumSize(new java.awt.Dimension(150, 20));
        tCantidadAfectada.setPreferredSize(new java.awt.Dimension(150, 20));
        pCantidad.add(tCantidadAfectada, java.awt.BorderLayout.CENTER);

        €.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        €.setForeground(new java.awt.Color(80, 98, 143));
        €.setText("(gr/litros/...)");
        pCantidad.add(€, java.awt.BorderLayout.EAST);

        pCentro.add(pCantidad);

        pAlertas.setBackground(new java.awt.Color(255, 255, 255));
        pAlertas.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(211, 223, 253)), "Alerta", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 18), new java.awt.Color(150, 172, 229))); // NOI18N
        pAlertas.setForeground(new java.awt.Color(80, 98, 143));
        pAlertas.setOpaque(false);
        pAlertas.setPreferredSize(new java.awt.Dimension(114, 150));
        pAlertas.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        lAlertas.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lAlertas.setForeground(new java.awt.Color(80, 98, 143));
        lAlertas.setText("Sin Incidencias");
        pAlertas.add(lAlertas);

        pCentro.add(pAlertas);

        pPaso2.add(pCentro, java.awt.BorderLayout.CENTER);

        pMargen.setOpaque(false);
        pPaso2.add(pMargen, java.awt.BorderLayout.WEST);

        pMargen1.setOpaque(false);
        pPaso2.add(pMargen1, java.awt.BorderLayout.EAST);

        pMargen2.setOpaque(false);
        pPaso2.add(pMargen2, java.awt.BorderLayout.NORTH);

        pMargen3.setOpaque(false);
        pPaso2.add(pMargen3, java.awt.BorderLayout.SOUTH);

        cuerpo.add(pPaso2, "Paso2");

        add(cuerpo, java.awt.BorderLayout.CENTER);

        cabecera.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(150, 172, 229), 2));
        cabecera.setMinimumSize(new java.awt.Dimension(150, 100));
        cabecera.setOpaque(false);
        cabecera.setPreferredSize(new java.awt.Dimension(150, 100));
        cabecera.setLayout(new java.awt.BorderLayout());

        pIzq.setOpaque(false);
        pIzq.setLayout(new java.awt.GridLayout(0, 1));

        lTitulo.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        lTitulo.setForeground(new java.awt.Color(80, 98, 143));
        lTitulo.setText("<html><body>Notificar incidencia con<br> bebidas   </body></html>");
        pIzq.add(lTitulo);

        lSubtitulo.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lSubtitulo.setForeground(new java.awt.Color(80, 98, 143));
        lSubtitulo.setText("Seleccionar la bebida afectada");
        lSubtitulo.setPreferredSize(new java.awt.Dimension(175, 50));
        pIzq.add(lSubtitulo);

        cabecera.add(pIzq, java.awt.BorderLayout.CENTER);

        pDer.setOpaque(false);
        pDer.setLayout(new java.awt.GridLayout(0, 1));

        lPaso.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lPaso.setForeground(new java.awt.Color(80, 98, 143));
        lPaso.setText("Paso 1/2");
        pDer.add(lPaso);

        bCancelar.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
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
        pDer.add(bCancelar);

        cabecera.add(pDer, java.awt.BorderLayout.EAST);

        add(cabecera, java.awt.BorderLayout.NORTH);

        pie.setBackground(new java.awt.Color(255, 255, 255));
        pie.setLayout(new java.awt.GridBagLayout());

        bSiguiente.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
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

        bAnterior.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
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

        add(pie, java.awt.BorderLayout.SOUTH);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void closeDialog(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_closeDialog
        setVisible(false);
        dispose();
    }//GEN-LAST:event_closeDialog

    private void siguiente(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_siguiente
        CardLayout cl = (CardLayout)(this.cuerpo.getLayout());
        switch(this.estado){
            case 1:
                this.lSubtitulo.setText(SUBTITULOPASO2);
                this.lPaso.setText(PASO2);
                this.bAnterior.setEnabled(true);
                this.estado++;
                cl.next(this.cuerpo);
                this.bSiguiente.setText("Finalizar");
                this.lNombre.setText((String) this.tTablaIngredientesDisponibles.getValueAt(this.tTablaIngredientesDisponibles.getSelectedRow(), 0));
            break;
            case 2:
                String subtitulo = this.lSubtitulo.getText();
                String pregunta = "¿Confirma que desea notificar la siguiente incidencia con la bebia?";
                String texto = "Bebida afectada: "+this.lNombre.getText()+
                               "\nCantidad afectada: "+(Float)this.tCantidadAfectada.getValue()+" L."+
                               "\nDescripción de la incidencia: "+this.tDescripcion.getText();
                DialogoConfirmacion confirmar = new DialogoConfirmacion(null, subtitulo, pregunta, texto);
                confirmar.setLocationRelativeTo(this);
                confirmar.setVisible(true);
                if (confirmar.isAceptado()) {
                Iterator iterador = listaBebidas.iterator();
                int i = 0;
                int select = this.tTablaIngredientesDisponibles.getSelectedRow();
                boolean noencontrado = true;
                    while (noencontrado) {
                        accidentado = (Bebida)iterador.next();
                        if(i == select){
                            noencontrado = false;
                        }
                        else ++i;
                    }
                    this.metre.nuevaIncidencia(new Incidencia( accidentado,(Float) this.tCantidadAfectada.getValue(), this.tDescripcion.getText()) );
                    setVisible(false);
                    dispose();
                }
                break;
        }

    }//GEN-LAST:event_siguiente

    private void anterior(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_anterior
        CardLayout cl = (CardLayout)(this.cuerpo.getLayout());
        switch(this.estado){
            case 2:
                this.lSubtitulo.setText(SUBTITULOPASO1);
                this.lPaso.setText(PASO1);
                this.bAnterior.setEnabled(false);
                this.estado--;
                cl.previous(this.cuerpo);
                this.bSiguiente.setText("Siguiente");
            break;
        }
    }//GEN-LAST:event_anterior

    private void Salir(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Salir
        this.setVisible(false);
    }//GEN-LAST:event_Salir

    private void validarFormulario(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_validarFormulario
        this.bebidaSeleccionada = this.tTablaIngredientesDisponibles.getSelectedRow();
        if (this.bebidaSeleccionada != -1) {
            this.bSiguiente.setEnabled(true);
        } else {
            this.bSiguiente.setEnabled(false);
        }
    }//GEN-LAST:event_validarFormulario



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bAnterior;
    private javax.swing.JButton bCancelar;
    private javax.swing.JButton bSiguiente;
    private javax.swing.JPanel cabecera;
    private javax.swing.JPanel cuerpo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lAlertas;
    private javax.swing.JLabel lDescripción;
    private javax.swing.JLabel lNombre;
    private javax.swing.JLabel lPaso;
    private javax.swing.JLabel lPrecio;
    private javax.swing.JLabel lSubtitulo;
    private javax.swing.JLabel lTitulo;
    private javax.swing.JPanel pAlertas;
    private javax.swing.JPanel pCantidad;
    private javax.swing.JPanel pCentro;
    private javax.swing.JPanel pDer;
    private javax.swing.JPanel pDescripcion;
    private javax.swing.JPanel pIngredientesDisponibles;
    private javax.swing.JPanel pIzq;
    private javax.swing.JPanel pMargen;
    private javax.swing.JPanel pMargen1;
    private javax.swing.JPanel pMargen2;
    private javax.swing.JPanel pMargen3;
    private javax.swing.JPanel pPaso1;
    private javax.swing.JPanel pPaso2;
    private javax.swing.JPanel pie;
    private javax.swing.JFormattedTextField tCantidadAfectada;
    private javax.swing.JTextArea tDescripcion;
    private javax.swing.JTable tTablaIngredientesDisponibles;
    private javax.swing.JLabel €;
    // End of variables declaration//GEN-END:variables
    
}
