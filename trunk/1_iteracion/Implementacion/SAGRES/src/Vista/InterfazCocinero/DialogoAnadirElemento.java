
/*
 * DialogoAnadirElemento.java
 *
 * Created on 31-mar-2010, 11:36:27
 */

package Vista.InterfazCocinero;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Daniel
 */
public class DialogoAnadirElemento extends java.awt.Dialog {

    private final String SUBTITULOPASO1 = "Sección a la que pertenece";
    private final String SUBTITULOPASO2 = "Rellenar los datos del nuevo elemento";
    private final String SUBTITULOPASO3 = "Asociar productos";
    private final String PASO1 = "Paso 1/3";
    private final String PASO2 = "Paso 2/3";
    private final String PASO3 = "Paso 3/3";
    private int estado = 1;

    /** Creates new form DialogoAnadirElemento */
    public DialogoAnadirElemento(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.estado=1;
        this.bAnterior.setEnabled(false);
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
        lSeccion = new javax.swing.JLabel();
        bSeccion = new javax.swing.JComboBox();
        lTablaSeccion = new javax.swing.JLabel();
        scrollTabla = new javax.swing.JScrollPane();
        tProductoSeccion = new javax.swing.JTable();
        pPaso2 = new javax.swing.JPanel();
        lNombre = new javax.swing.JLabel();
        tNombre = new javax.swing.JTextField();
        lDescripción = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tDescripcion = new javax.swing.JTextArea();
        lImagen = new javax.swing.JLabel();
        TImgen = new javax.swing.JTextField();
        bImagen = new javax.swing.JButton();
        lPrecio = new javax.swing.JLabel();
        € = new javax.swing.JLabel();
        lTiempo = new javax.swing.JLabel();
        minutos = new javax.swing.JLabel();
        pAtributoPlato = new javax.swing.JPanel();
        lDivision = new javax.swing.JLabel();
        lPorciones = new javax.swing.JLabel();
        lAyudaDivisiones = new javax.swing.JLabel();
        tPorciones = new javax.swing.JFormattedTextField(new Integer(0));
        tPrecio = new javax.swing.JFormattedTextField(new Float(0));
        tTiempo = new javax.swing.JFormattedTextField(new Integer(0));
        pPaso3 = new javax.swing.JPanel();
        pProductosDisponibles = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        pAtributoPlato2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        cabecera = new javax.swing.JPanel();
        lTitulo = new javax.swing.JLabel();
        lSubtitulo = new javax.swing.JLabel();
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
        pPaso1.setMinimumSize(new java.awt.Dimension(500, 550));
        pPaso1.setOpaque(false);
        pPaso1.setPreferredSize(new java.awt.Dimension(500, 550));
        pPaso1.setLayout(new java.awt.GridBagLayout());

        lSeccion.setFont(new java.awt.Font("Arial", 0, 14));
        lSeccion.setForeground(new java.awt.Color(80, 98, 143));
        lSeccion.setText("Elija una sección");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        pPaso1.add(lSeccion, gridBagConstraints);

        bSeccion.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        bSeccion.setForeground(new java.awt.Color(80, 98, 143));
        bSeccion.setMaximumRowCount(10);
        bSeccion.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(150, 172, 229), 2, true));
        bSeccion.setOpaque(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        pPaso1.add(bSeccion, gridBagConstraints);

        lTablaSeccion.setFont(new java.awt.Font("Arial", 0, 14));
        lTablaSeccion.setForeground(new java.awt.Color(80, 98, 143));
        lTablaSeccion.setText("Productos ya asociados a la sección");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(21, 10, 0, 10);
        pPaso1.add(lTablaSeccion, gridBagConstraints);

        scrollTabla.setOpaque(false);

        tProductoSeccion.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tProductoSeccion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Descripción", "Precio", "Duración"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Float.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tProductoSeccion.setGridColor(new java.awt.Color(211, 223, 253));
        tProductoSeccion.setMinimumSize(new java.awt.Dimension(300, 400));
        tProductoSeccion.setOpaque(false);
        tProductoSeccion.setPreferredSize(new java.awt.Dimension(300, 400));
        tProductoSeccion.getTableHeader().setReorderingAllowed(false);
        scrollTabla.setViewportView(tProductoSeccion);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 10, 10);
        pPaso1.add(scrollTabla, gridBagConstraints);

        cuerpo.add(pPaso1, "Paso1");

        pPaso2.setBackground(new java.awt.Color(255, 255, 255));
        pPaso2.setForeground(new java.awt.Color(80, 98, 143));
        pPaso2.setMinimumSize(new java.awt.Dimension(500, 550));
        pPaso2.setOpaque(false);
        pPaso2.setPreferredSize(new java.awt.Dimension(500, 550));
        pPaso2.setLayout(new java.awt.GridBagLayout());

        lNombre.setFont(new java.awt.Font("Arial", 0, 14));
        lNombre.setForeground(new java.awt.Color(80, 98, 143));
        lNombre.setText("Nombre");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(12, 11, 11, 11);
        pPaso2.add(lNombre, gridBagConstraints);

        tNombre.setFont(new java.awt.Font("Arial", 0, 14));
        tNombre.setForeground(new java.awt.Color(80, 98, 143));
        tNombre.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(150, 172, 229), 3, true));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 100;
        gridBagConstraints.insets = new java.awt.Insets(12, 11, 11, 11);
        pPaso2.add(tNombre, gridBagConstraints);

        lDescripción.setFont(new java.awt.Font("Arial", 0, 14));
        lDescripción.setForeground(new java.awt.Color(80, 98, 143));
        lDescripción.setText("Descripción");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.insets = new java.awt.Insets(28, 11, 11, 11);
        pPaso2.add(lDescripción, gridBagConstraints);

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

        lImagen.setFont(new java.awt.Font("Arial", 0, 14));
        lImagen.setForeground(new java.awt.Color(80, 98, 143));
        lImagen.setText("Imagen");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(28, 11, 11, 11);
        pPaso2.add(lImagen, gridBagConstraints);

        TImgen.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        TImgen.setForeground(new java.awt.Color(80, 98, 143));
        TImgen.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(150, 172, 229), 3, true));
        TImgen.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(28, 11, 11, 11);
        pPaso2.add(TImgen, gridBagConstraints);

        bImagen.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        bImagen.setForeground(new java.awt.Color(80, 98, 143));
        bImagen.setText("Examinar");
        bImagen.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        bImagen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                examinar(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(28, 11, 11, 11);
        pPaso2.add(bImagen, gridBagConstraints);

        lPrecio.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lPrecio.setForeground(new java.awt.Color(80, 98, 143));
        lPrecio.setText("Precio de venta");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(28, 11, 11, 11);
        pPaso2.add(lPrecio, gridBagConstraints);

        €.setFont(new java.awt.Font("Arial", 0, 14));
        €.setForeground(new java.awt.Color(80, 98, 143));
        €.setText("€");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(28, 11, 11, 11);
        pPaso2.add(€, gridBagConstraints);

        lTiempo.setFont(new java.awt.Font("Arial", 0, 14));
        lTiempo.setForeground(new java.awt.Color(80, 98, 143));
        lTiempo.setText("Tiempo Medio de elaboración");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(28, 11, 11, 11);
        pPaso2.add(lTiempo, gridBagConstraints);

        minutos.setFont(new java.awt.Font("Arial", 0, 14));
        minutos.setForeground(new java.awt.Color(80, 98, 143));
        minutos.setText("minutos");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(28, 11, 11, 11);
        pPaso2.add(minutos, gridBagConstraints);

        pAtributoPlato.setBackground(new java.awt.Color(255, 255, 255));
        pAtributoPlato.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(211, 223, 253)), "Atributos del plato", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 14), new java.awt.Color(150, 172, 229))); // NOI18N
        pAtributoPlato.setForeground(new java.awt.Color(80, 98, 143));
        pAtributoPlato.setOpaque(false);
        pAtributoPlato.setLayout(new java.awt.GridBagLayout());

        lDivision.setFont(new java.awt.Font("Arial", 0, 14));
        lDivision.setForeground(new java.awt.Color(80, 98, 143));
        lDivision.setText("El elemento se puede dividir en");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(7, 7, 7, 7);
        pAtributoPlato.add(lDivision, gridBagConstraints);

        lPorciones.setFont(new java.awt.Font("Arial", 0, 14));
        lPorciones.setForeground(new java.awt.Color(80, 98, 143));
        lPorciones.setText("porciones/raciones");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(7, 7, 7, 7);
        pAtributoPlato.add(lPorciones, gridBagConstraints);

        lAyudaDivisiones.setFont(new java.awt.Font("Arial", 0, 14));
        lAyudaDivisiones.setForeground(new java.awt.Color(80, 98, 143));
        lAyudaDivisiones.setText("* indique 0 o vacio para hacerlo indivisible");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        pAtributoPlato.add(lAyudaDivisiones, gridBagConstraints);

        tPorciones.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(150, 172, 229), 3, true));
        tPorciones.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        tPorciones.setMinimumSize(new java.awt.Dimension(60, 20));
        tPorciones.setPreferredSize(new java.awt.Dimension(150, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(7, 7, 7, 7);
        pAtributoPlato.add(tPorciones, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipady = 47;
        gridBagConstraints.insets = new java.awt.Insets(28, 11, 11, 11);
        pPaso2.add(pAtributoPlato, gridBagConstraints);

        tPrecio.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(150, 172, 229), 3, true));
        tPrecio.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        tPrecio.setMinimumSize(new java.awt.Dimension(150, 20));
        tPrecio.setPreferredSize(new java.awt.Dimension(150, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.insets = new java.awt.Insets(28, 11, 11, 11);
        pPaso2.add(tPrecio, gridBagConstraints);

        tTiempo.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(150, 172, 229), 3, true));
        tTiempo.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        tTiempo.setMinimumSize(new java.awt.Dimension(150, 20));
        tTiempo.setPreferredSize(new java.awt.Dimension(150, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.insets = new java.awt.Insets(28, 11, 11, 11);
        pPaso2.add(tTiempo, gridBagConstraints);

        cuerpo.add(pPaso2, "Paso2");

        pPaso3.setBackground(new java.awt.Color(255, 255, 255));
        pPaso3.setForeground(new java.awt.Color(80, 98, 143));
        pPaso3.setMinimumSize(new java.awt.Dimension(500, 550));
        pPaso3.setOpaque(false);
        pPaso3.setPreferredSize(new java.awt.Dimension(500, 550));
        pPaso3.setLayout(new java.awt.GridBagLayout());

        pProductosDisponibles.setBackground(new java.awt.Color(255, 255, 255));
        pProductosDisponibles.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(211, 223, 253)), "Productos disponibles", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 14), new java.awt.Color(150, 172, 229))); // NOI18N
        pProductosDisponibles.setForeground(new java.awt.Color(80, 98, 143));
        pProductosDisponibles.setMinimumSize(new java.awt.Dimension(450, 250));
        pProductosDisponibles.setOpaque(false);
        pProductosDisponibles.setPreferredSize(new java.awt.Dimension(450, 250));
        pProductosDisponibles.setLayout(new java.awt.BorderLayout());

        jScrollPane2.setOpaque(false);
        jScrollPane2.setPreferredSize(new java.awt.Dimension(200, 200));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jTable1.setGridColor(new java.awt.Color(211, 223, 253));
        jTable1.setMinimumSize(new java.awt.Dimension(450, 250));
        jTable1.setPreferredSize(new java.awt.Dimension(450, 250));
        jTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(jTable1);

        pProductosDisponibles.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(20, 8, 8, 8);
        pPaso3.add(pProductosDisponibles, gridBagConstraints);

        pAtributoPlato2.setBackground(new java.awt.Color(255, 255, 255));
        pAtributoPlato2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(211, 223, 253)), "Productos asociados", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 14), new java.awt.Color(150, 172, 229))); // NOI18N
        pAtributoPlato2.setForeground(new java.awt.Color(80, 98, 143));
        pAtributoPlato2.setMinimumSize(new java.awt.Dimension(450, 250));
        pAtributoPlato2.setOpaque(false);
        pAtributoPlato2.setPreferredSize(new java.awt.Dimension(450, 250));
        pAtributoPlato2.setLayout(new java.awt.BorderLayout());

        jScrollPane3.setOpaque(false);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Eliminar", "Nombre", "cantidad"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.Float.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable2.setGridColor(new java.awt.Color(211, 223, 253));
        jTable2.setMinimumSize(new java.awt.Dimension(450, 250));
        jTable2.setPreferredSize(new java.awt.Dimension(450, 250));
        jTable2.getTableHeader().setResizingAllowed(false);
        jTable2.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(jTable2);

        pAtributoPlato2.add(jScrollPane3, java.awt.BorderLayout.CENTER);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(13, 8, 11, 8);
        pPaso3.add(pAtributoPlato2, gridBagConstraints);

        cuerpo.add(pPaso3, "Paso3");

        add(cuerpo, java.awt.BorderLayout.CENTER);

        cabecera.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(150, 172, 229), 2));
        cabecera.setMinimumSize(new java.awt.Dimension(150, 100));
        cabecera.setOpaque(false);
        cabecera.setPreferredSize(new java.awt.Dimension(150, 100));
        cabecera.setLayout(new java.awt.GridBagLayout());

        lTitulo.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lTitulo.setForeground(new java.awt.Color(80, 98, 143));
        lTitulo.setText("Añadir nuevo elemento a carta");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 130;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 6, 6, 6);
        cabecera.add(lTitulo, gridBagConstraints);

        lSubtitulo.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lSubtitulo.setForeground(new java.awt.Color(80, 98, 143));
        lSubtitulo.setText("Sección a la que pertenece");
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
        lPaso.setText("Paso 1/3");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 9;
        gridBagConstraints.insets = new java.awt.Insets(6, 11, 6, 11);
        cabecera.add(lPaso, gridBagConstraints);

        bCancelar.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
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

        add(cabecera, java.awt.BorderLayout.NORTH);

        pie.setBackground(new java.awt.Color(255, 255, 255));
        pie.setLayout(new java.awt.GridBagLayout());

        bSiguiente.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
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

        bAnterior.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
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
                //Validar Datos
                this.lSubtitulo.setText(SUBTITULOPASO2);
                this.lPaso.setText(PASO2);
                this.bAnterior.setEnabled(true);
                this.estado++;
                cl.next(this.cuerpo);
            break;
            case 2:
                //validar Datos
                this.lSubtitulo.setText(SUBTITULOPASO3);
                this.lPaso.setText(PASO3);
                this.bSiguiente.setText("Finalizar");
                this.estado++;
                cl.next(this.cuerpo);
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
            break;
            case 3:
                this.lSubtitulo.setText(SUBTITULOPASO2);
                this.lPaso.setText(PASO2);
                this.bSiguiente.setText("Siguiente");
                this.estado--;
                cl.previous(this.cuerpo);
            break;
        }
    }//GEN-LAST:event_anterior

    private void examinar(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_examinar
        if(this.dSelector.showOpenDialog(this) == JFileChooser.APPROVE_OPTION){
            this.TImgen.setText( this.dSelector.getSelectedFile().getAbsolutePath() );
        }
    }//GEN-LAST:event_examinar

    private void Salir(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Salir
        this.setVisible(false);
    }//GEN-LAST:event_Salir

    


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField TImgen;
    private javax.swing.JButton bAnterior;
    private javax.swing.JButton bCancelar;
    private javax.swing.JButton bImagen;
    private javax.swing.JComboBox bSeccion;
    private javax.swing.JButton bSiguiente;
    private javax.swing.JPanel cabecera;
    private javax.swing.JPanel cuerpo;
    private javax.swing.JFileChooser dSelector;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JLabel lAyudaDivisiones;
    private javax.swing.JLabel lDescripción;
    private javax.swing.JLabel lDivision;
    private javax.swing.JLabel lImagen;
    private javax.swing.JLabel lNombre;
    private javax.swing.JLabel lPaso;
    private javax.swing.JLabel lPorciones;
    private javax.swing.JLabel lPrecio;
    private javax.swing.JLabel lSeccion;
    private javax.swing.JLabel lSubtitulo;
    private javax.swing.JLabel lTablaSeccion;
    private javax.swing.JLabel lTiempo;
    private javax.swing.JLabel lTitulo;
    private javax.swing.JLabel minutos;
    private javax.swing.JPanel pAtributoPlato;
    private javax.swing.JPanel pAtributoPlato2;
    private javax.swing.JPanel pPaso1;
    private javax.swing.JPanel pPaso2;
    private javax.swing.JPanel pPaso3;
    private javax.swing.JPanel pProductosDisponibles;
    private javax.swing.JPanel pie;
    private javax.swing.JScrollPane scrollTabla;
    private javax.swing.JTextArea tDescripcion;
    private javax.swing.JTextField tNombre;
    private javax.swing.JFormattedTextField tPorciones;
    private javax.swing.JFormattedTextField tPrecio;
    private javax.swing.JTable tProductoSeccion;
    private javax.swing.JFormattedTextField tTiempo;
    private javax.swing.JLabel €;
    // End of variables declaration//GEN-END:variables
    
}