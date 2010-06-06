
package Vista.InterfazMetre;

import ControladorPrincipal.IMetre;
import GestionStock.GestionProductos.Bebida;
import GestionStock.GestionProductos.Producto;
import Vista.DialogoConfirmacion;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.HashSet;
import java.util.Iterator;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import utilidades.ImageRenderer;

/**
 *
 * @author Daniel Guerrero Martinez y Jose David Dionisio Ruiz
 */
public class DialogoModificarBedidas extends java.awt.Dialog {

    private final String SUBTITULOPASO1 = "Seleccionar el bebida a modificar";
    private final String SUBTITULOPASO2 = "Cambiar los datos que se deseen";
    private final String PASO1 = "Paso 1/2";
    private final String PASO2 = "Paso 2/2";
    private int estado = 1;
    private ImageIcon imagen;
    //private IGestionarProducto gestorProducto;
    //private IProducto productos;
    private int bebidaSeleccionada;
    private IMetre metre;
    private HashSet<Producto> listaBebidas;
    private Bebida aModificar;

    /** Creates new form DialogoAnadirElemento */
    public DialogoModificarBedidas(java.awt.Frame parent,IMetre iMetre) {
        super(parent, true);
        initComponents();
        this.estado=1;
        /*this.gestorProducto = gestorProducto;
        this.productos = productos;*/
        this.metre = iMetre;
        this.listaBebidas = this.metre.obtenerBebidas();
        DefaultTableModel tableModel = new DefaultTableModel() {
            //Hace que las celdas sean no editables
            @Override
            public boolean isCellEditable(int x, int y) {
                return false;
            }
        };
        tableModel.addColumn(this.tTablaBebidasDisponibles.getColumnName(0));
        tableModel.addColumn(this.tTablaBebidasDisponibles.getColumnName(1));
        tableModel.addColumn(this.tTablaBebidasDisponibles.getColumnName(2));
        tableModel.setRowCount(listaBebidas.size());
        this.tTablaBebidasDisponibles.setModel(tableModel);
        this.tTablaBebidasDisponibles.getColumnModel().getColumn(2).setCellRenderer(new ImageRenderer());
        this.tTablaBebidasDisponibles.setRowHeight(50);
        Iterator iterador = listaBebidas.iterator();
        Producto p;
        int i = 0;
	while (iterador.hasNext()) {
            p = (Producto)iterador.next();
            this.tTablaBebidasDisponibles.setValueAt(p.getNombre(), i, 0);
            this.tTablaBebidasDisponibles.setValueAt(p.getCantidad(), i, 1);
            this.tTablaBebidasDisponibles.setValueAt(p.getImagen(), i, 2);
            ++i;
	}
        this.bAnterior.setEnabled(false);
        this.bSiguiente.setEnabled(false);
        this.imagen = null;
        this.dSelector.setFileFilter( new FileNameExtensionFilter("IMAGEN", "jpg","jpeg","png","gif"));
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

        dSelector = new javax.swing.JFileChooser();
        cuerpo = new javax.swing.JPanel();
        pPaso1 = new javax.swing.JPanel();
        pbebidasDisponibles = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tTablaBebidasDisponibles = new javax.swing.JTable();
        pPaso2 = new javax.swing.JPanel();
        pNombre = new javax.swing.JPanel();
        lNombre = new javax.swing.JLabel();
        tNombre = new javax.swing.JTextField();
        pMargen = new javax.swing.JPanel();
        pAtributoCantidad = new javax.swing.JPanel();
        lMaximo = new javax.swing.JLabel();
        tMaximo = new javax.swing.JFormattedTextField(new Float(0));
        lPorciones = new javax.swing.JLabel();
        lMinimo = new javax.swing.JLabel();
        tMinimo = new javax.swing.JFormattedTextField(new Float(0));
        lPorciones1 = new javax.swing.JLabel();
        lMaximo2 = new javax.swing.JLabel();
        tDisponible = new javax.swing.JFormattedTextField(new Float(0));
        lPorciones2 = new javax.swing.JLabel();
        pImagen = new javax.swing.JPanel();
        lImagen = new javax.swing.JLabel();
        lMuestraImagen = new javax.swing.JLabel();
        pMargen1 = new javax.swing.JPanel();
        pMargen2 = new javax.swing.JPanel();
        cabecera = new utilidades.PanelCabeceras();
        PanelIzq = new javax.swing.JPanel();
        lTitulo = new javax.swing.JLabel();
        lSubtitulo = new javax.swing.JLabel();
        PanelDer = new javax.swing.JPanel();
        lPaso = new javax.swing.JLabel();
        bCancelar = new javax.swing.JButton();
        pie = new javax.swing.JPanel();
        bSiguiente = new javax.swing.JButton();
        bAnterior = new javax.swing.JButton();

        dSelector.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

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

        pbebidasDisponibles.setBackground(new java.awt.Color(255, 255, 255));
        pbebidasDisponibles.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(211, 223, 253)), "Bebidas disponibles", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 18), new java.awt.Color(150, 172, 229))); // NOI18N
        pbebidasDisponibles.setForeground(new java.awt.Color(80, 98, 143));
        pbebidasDisponibles.setMinimumSize(new java.awt.Dimension(450, 500));
        pbebidasDisponibles.setOpaque(false);
        pbebidasDisponibles.setPreferredSize(new java.awt.Dimension(470, 500));
        pbebidasDisponibles.setLayout(new java.awt.BorderLayout());

        jScrollPane2.setOpaque(false);
        jScrollPane2.setPreferredSize(new java.awt.Dimension(200, 200));

        tTablaBebidasDisponibles.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tTablaBebidasDisponibles.setModel(new javax.swing.table.DefaultTableModel(
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
        tTablaBebidasDisponibles.setGridColor(new java.awt.Color(211, 223, 253));
        tTablaBebidasDisponibles.setMaximumSize(new java.awt.Dimension(2147483647, 2147483647));
        tTablaBebidasDisponibles.setMinimumSize(new java.awt.Dimension(450, 3000));
        tTablaBebidasDisponibles.setPreferredSize(new java.awt.Dimension(450, 3000));
        tTablaBebidasDisponibles.getTableHeader().setReorderingAllowed(false);
        tTablaBebidasDisponibles.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ValidarFormulario(evt);
            }
        });
        jScrollPane2.setViewportView(tTablaBebidasDisponibles);

        pbebidasDisponibles.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(20, 8, 8, 8);
        pPaso1.add(pbebidasDisponibles, gridBagConstraints);

        cuerpo.add(pPaso1, "Paso3");

        pPaso2.setBackground(new java.awt.Color(255, 255, 255));
        pPaso2.setForeground(new java.awt.Color(80, 98, 143));
        pPaso2.setMinimumSize(new java.awt.Dimension(500, 550));
        pPaso2.setPreferredSize(new java.awt.Dimension(500, 550));
        pPaso2.setLayout(new java.awt.BorderLayout(0, 10));

        pNombre.setOpaque(false);
        pNombre.setLayout(new java.awt.BorderLayout(10, 0));

        lNombre.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lNombre.setForeground(new java.awt.Color(80, 98, 143));
        lNombre.setText("Nombre");
        pNombre.add(lNombre, java.awt.BorderLayout.WEST);

        tNombre.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tNombre.setForeground(new java.awt.Color(80, 98, 143));
        tNombre.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(150, 172, 229), 3, true));
        tNombre.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                validarFormulario(evt);
            }
        });
        pNombre.add(tNombre, java.awt.BorderLayout.CENTER);

        pMargen.setOpaque(false);
        pNombre.add(pMargen, java.awt.BorderLayout.NORTH);

        pPaso2.add(pNombre, java.awt.BorderLayout.NORTH);

        pAtributoCantidad.setBackground(new java.awt.Color(255, 255, 255));
        pAtributoCantidad.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(211, 223, 253)), "Cantidades", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 14), new java.awt.Color(150, 172, 229))); // NOI18N
        pAtributoCantidad.setForeground(new java.awt.Color(80, 98, 143));
        pAtributoCantidad.setOpaque(false);
        pAtributoCantidad.setLayout(new java.awt.GridLayout(3, 3, 5, 10));

        lMaximo.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lMaximo.setForeground(new java.awt.Color(80, 98, 143));
        lMaximo.setText("Máximo posible");
        pAtributoCantidad.add(lMaximo);

        tMaximo.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(150, 172, 229), 3, true));
        tMaximo.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        tMaximo.setMinimumSize(new java.awt.Dimension(60, 10));
        tMaximo.setPreferredSize(new java.awt.Dimension(150, 10));
        tMaximo.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                validarFormulario(evt);
            }
        });
        pAtributoCantidad.add(tMaximo);

        lPorciones.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lPorciones.setForeground(new java.awt.Color(80, 98, 143));
        lPorciones.setText("Unidades");
        pAtributoCantidad.add(lPorciones);

        lMinimo.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lMinimo.setForeground(new java.awt.Color(80, 98, 143));
        lMinimo.setText("Mínimo aceptable");
        pAtributoCantidad.add(lMinimo);

        tMinimo.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(150, 172, 229), 3, true));
        tMinimo.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        tMinimo.setMinimumSize(new java.awt.Dimension(60, 10));
        tMinimo.setPreferredSize(new java.awt.Dimension(150, 10));
        tMinimo.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                validarFormulario(evt);
            }
        });
        pAtributoCantidad.add(tMinimo);

        lPorciones1.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lPorciones1.setForeground(new java.awt.Color(80, 98, 143));
        lPorciones1.setText("Unidades");
        pAtributoCantidad.add(lPorciones1);

        lMaximo2.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lMaximo2.setForeground(new java.awt.Color(80, 98, 143));
        lMaximo2.setText("<html><body>Disponible<br> actualmente</body></html>");
        pAtributoCantidad.add(lMaximo2);

        tDisponible.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(150, 172, 229), 3, true));
        tDisponible.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        tDisponible.setMinimumSize(new java.awt.Dimension(60, 10));
        tDisponible.setPreferredSize(new java.awt.Dimension(150, 10));
        tDisponible.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                validarFormulario(evt);
            }
        });
        pAtributoCantidad.add(tDisponible);

        lPorciones2.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lPorciones2.setForeground(new java.awt.Color(80, 98, 143));
        lPorciones2.setText("Unidades");
        pAtributoCantidad.add(lPorciones2);

        pPaso2.add(pAtributoCantidad, java.awt.BorderLayout.CENTER);

        pImagen.setOpaque(false);
        pImagen.setLayout(new java.awt.GridBagLayout());

        lImagen.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lImagen.setForeground(new java.awt.Color(80, 98, 143));
        lImagen.setText("Imagen");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(7, 7, 7, 7);
        pImagen.add(lImagen, gridBagConstraints);

        lMuestraImagen.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lMuestraImagen.setForeground(new java.awt.Color(80, 98, 143));
        lMuestraImagen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lMuestraImagen.setText("<html><center> <STRONG>Imagen no <br> disponible</STRONG> <br><i> (Pulse aqu&iacute; <br> para insertar una)</i></center> </html>");
        lMuestraImagen.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(150, 172, 229), 3, true));
        lMuestraImagen.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lMuestraImagen.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lMuestraImagen.setMaximumSize(new java.awt.Dimension(200, 200));
        lMuestraImagen.setMinimumSize(new java.awt.Dimension(200, 200));
        lMuestraImagen.setPreferredSize(new java.awt.Dimension(200, 200));
        lMuestraImagen.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lMuestraImagenSeleccionar(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.insets = new java.awt.Insets(7, 7, 7, 7);
        pImagen.add(lMuestraImagen, gridBagConstraints);

        pPaso2.add(pImagen, java.awt.BorderLayout.SOUTH);

        pMargen1.setOpaque(false);
        pPaso2.add(pMargen1, java.awt.BorderLayout.WEST);

        pMargen2.setOpaque(false);
        pPaso2.add(pMargen2, java.awt.BorderLayout.EAST);

        cuerpo.add(pPaso2, "card3");

        add(cuerpo, java.awt.BorderLayout.CENTER);

        cabecera.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(150, 172, 229), 2));
        cabecera.setMinimumSize(new java.awt.Dimension(150, 100));
        cabecera.setOpaque(false);
        cabecera.setPreferredSize(new java.awt.Dimension(150, 100));
        cabecera.setLayout(new java.awt.BorderLayout());

        PanelIzq.setOpaque(false);
        PanelIzq.setLayout(new java.awt.GridLayout(0, 1));

        lTitulo.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        lTitulo.setForeground(new java.awt.Color(80, 98, 143));
        lTitulo.setText("Modificar bebida        ");
        PanelIzq.add(lTitulo);

        lSubtitulo.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lSubtitulo.setForeground(new java.awt.Color(80, 98, 143));
        lSubtitulo.setText("Seleccionar la bebida a modificar");
        lSubtitulo.setPreferredSize(new java.awt.Dimension(175, 50));
        PanelIzq.add(lSubtitulo);

        cabecera.add(PanelIzq, java.awt.BorderLayout.CENTER);

        PanelDer.setOpaque(false);
        PanelDer.setLayout(new java.awt.GridLayout(0, 1));

        lPaso.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lPaso.setForeground(new java.awt.Color(80, 98, 143));
        lPaso.setText("Paso 1/2");
        PanelDer.add(lPaso);

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
        PanelDer.add(bCancelar);

        cabecera.add(PanelDer, java.awt.BorderLayout.EAST);

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
                Iterator iterador = listaBebidas.iterator();
                int i = 0;
                int select = this.tTablaBebidasDisponibles.getSelectedRow();
                boolean noencontrado = true;
                while (noencontrado) {
                    aModificar = (Bebida)iterador.next();
                    if(i == select){
                        noencontrado = false;
                    }
                    else ++i;
                }
                this.tNombre.setText(aModificar.getNombre());
                this.tMaximo.setValue(aModificar.getMaximo());
                this.tMinimo.setValue(aModificar.getMinimo());
                this.tDisponible.setValue(aModificar.getCantidad());
                this.lMuestraImagen.setIcon(aModificar.getImagen());
                this.imagen = aModificar.getImagen();
            break;
            case 2:
                String subtitulo = this.lSubtitulo.getText();
                String pregunta = "¿Confirma que desea modificar los siguientes datos de la bebida?";
                String texto = "Nombre: "+this.tNombre.getText()+
                               "\nCantidad Disponible: "+((Float)this.tDisponible.getValue())+" L."+
                               "\nCantidad Máxima: "+((Float)this.tMaximo.getValue())+" L."+
                               "\nCantidad Mínima: "+((Float)this.tMinimo.getValue())+" L.";
                DialogoConfirmacion confirmar = new DialogoConfirmacion(null, subtitulo, pregunta, texto);
                confirmar.setLocationRelativeTo(this);
                confirmar.setVisible(true);
                if(confirmar.isAceptado()){
            try {
                float cantidad = (Float) this.tDisponible.getValue();
                aModificar.actualizarCantidad(cantidad);
                aModificar.setNombre(this.tNombre.getText());
                aModificar.setMaximo((Float) this.tMaximo.getValue());
                aModificar.setMinimo((Float) this.tMinimo.getValue());
                aModificar.setFoto(imagen);
                this.metre.modificarProducto(aModificar);
            } catch (Exception ex) {
            }
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

    private void lMuestraImagenSeleccionar(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lMuestraImagenSeleccionar
        if(this.dSelector.showOpenDialog(this) == JFileChooser.APPROVE_OPTION){
            ImageIcon aux = new ImageIcon( this.dSelector.getSelectedFile().getPath() );
            imagen = new ImageIcon();
            imagen.setImage(new BufferedImage(200, 200, BufferedImage.TYPE_INT_RGB));
            imagen.getImage().getGraphics().drawImage(aux.getImage(), 0, 0, 200, 200, null);
            this.lMuestraImagen.setText("");
            this.lMuestraImagen.setIcon(imagen);
        }
}//GEN-LAST:event_lMuestraImagenSeleccionar

    private void ValidarFormulario(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ValidarFormulario
        this.bebidaSeleccionada = this.tTablaBebidasDisponibles.getSelectedRow();
        if (this.bebidaSeleccionada != -1) {
            this.bSiguiente.setEnabled(true);
        } else {
            this.bSiguiente.setEnabled(false);
        }
    }//GEN-LAST:event_ValidarFormulario

    private void validarFormulario(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_validarFormulario
        if( this.tNombre.getText().length() != 0 &&
          ((Float)this.tMaximo.getValue()) > 0 &&
          ((Float)this.tMinimo.getValue()) > 0 &&
          ((Float)this.tMaximo.getValue()) > ((Float)this.tMinimo.getValue()) &&
          ((Float)this.tDisponible.getValue()) >= 0 &&
          ((Float)this.tDisponible.getValue()) <= ((Float)this.tMaximo.getValue()))
        
                this.bSiguiente.setEnabled(true);
        else this.bSiguiente.setEnabled(false);
    }//GEN-LAST:event_validarFormulario




    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelDer;
    private javax.swing.JPanel PanelIzq;
    private javax.swing.JButton bAnterior;
    private javax.swing.JButton bCancelar;
    private javax.swing.JButton bSiguiente;
    private javax.swing.JPanel cabecera;
    private javax.swing.JPanel cuerpo;
    private javax.swing.JFileChooser dSelector;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lImagen;
    private javax.swing.JLabel lMaximo;
    private javax.swing.JLabel lMaximo2;
    private javax.swing.JLabel lMinimo;
    private javax.swing.JLabel lMuestraImagen;
    private javax.swing.JLabel lNombre;
    private javax.swing.JLabel lPaso;
    private javax.swing.JLabel lPorciones;
    private javax.swing.JLabel lPorciones1;
    private javax.swing.JLabel lPorciones2;
    private javax.swing.JLabel lSubtitulo;
    private javax.swing.JLabel lTitulo;
    private javax.swing.JPanel pAtributoCantidad;
    private javax.swing.JPanel pImagen;
    private javax.swing.JPanel pMargen;
    private javax.swing.JPanel pMargen1;
    private javax.swing.JPanel pMargen2;
    private javax.swing.JPanel pNombre;
    private javax.swing.JPanel pPaso1;
    private javax.swing.JPanel pPaso2;
    private javax.swing.JPanel pbebidasDisponibles;
    private javax.swing.JPanel pie;
    private javax.swing.JFormattedTextField tDisponible;
    private javax.swing.JFormattedTextField tMaximo;
    private javax.swing.JFormattedTextField tMinimo;
    private javax.swing.JTextField tNombre;
    private javax.swing.JTable tTablaBebidasDisponibles;
    // End of variables declaration//GEN-END:variables
    
}
