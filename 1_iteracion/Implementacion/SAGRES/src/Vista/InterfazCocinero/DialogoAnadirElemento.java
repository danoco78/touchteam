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

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

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

    /** Creates new form DialogoAnadirElemento */
    public DialogoAnadirElemento(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }


    @Override
    public void paint(Graphics g) {
        super.paintComponents(g);
        Graphics2D g2 = (Graphics2D) g.create();
        Rectangle clip = g2.getClipBounds();
        g2.setPaint(new GradientPaint(0.0f, 0.0f, new Color(170, 192, 249) ,getWidth() ,150.0f, new Color(255, 255, 255) ));
        g2.fillRect(clip.x, clip.y, clip.width, clip.height);
        super.paint(g);
    }


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        cuerpo = new javax.swing.JPanel();
        pPaso1 = new javax.swing.JPanel();
        lSeccion = new javax.swing.JLabel();
        bSeccion = new javax.swing.JComboBox();
        lTablaSeccion = new javax.swing.JLabel();
        scrollTabla = new javax.swing.JScrollPane();
        tProductoSeccion = new javax.swing.JTable();
        bSiguiente = new javax.swing.JButton();
        pPaso2 = new javax.swing.JPanel();
        bSiguientePaso2 = new javax.swing.JButton();
        lNombre = new javax.swing.JLabel();
        tNombre = new javax.swing.JTextField();
        lDescripción = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tDescripcion = new javax.swing.JTextArea();
        lImagen = new javax.swing.JLabel();
        TImgen = new javax.swing.JTextField();
        bImagen = new javax.swing.JButton();
        lPrecio = new javax.swing.JLabel();
        tPrecio = new javax.swing.JTextField();
        € = new javax.swing.JLabel();
        lTiempo = new javax.swing.JLabel();
        tTiempo = new javax.swing.JTextField();
        minutos = new javax.swing.JLabel();
        pAtributoPlato = new javax.swing.JPanel();
        lDivision = new javax.swing.JLabel();
        tDivisiones = new javax.swing.JTextField();
        lPorciones = new javax.swing.JLabel();
        lAyudaDivisiones = new javax.swing.JLabel();
        bAnteriorPaso2 = new javax.swing.JButton();
        pPaso3 = new javax.swing.JPanel();
        bSiguientePaso3 = new javax.swing.JButton();
        pProductosDisponibles = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        bAnteriorPaso3 = new javax.swing.JButton();
        pAtributoPlato2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        cabecera = new javax.swing.JPanel();
        lTitulo = new javax.swing.JLabel();
        lSubtitulo = new javax.swing.JLabel();
        lPaso = new javax.swing.JLabel();
        bCancelar = new javax.swing.JButton();

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
        pPaso1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(150, 172, 229), 2));
        pPaso1.setMinimumSize(new java.awt.Dimension(500, 650));
        pPaso1.setOpaque(false);
        pPaso1.setPreferredSize(new java.awt.Dimension(500, 650));
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

        bSiguiente.setFont(new java.awt.Font("Arial", 0, 14));
        bSiguiente.setForeground(new java.awt.Color(80, 98, 143));
        bSiguiente.setText("Siguiente");
        bSiguiente.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        bSiguiente.setMinimumSize(new java.awt.Dimension(100, 50));
        bSiguiente.setPreferredSize(new java.awt.Dimension(125, 75));
        bSiguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pasarAPaso2(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTHEAST;
        gridBagConstraints.insets = new java.awt.Insets(16, 10, 8, 8);
        pPaso1.add(bSiguiente, gridBagConstraints);

        cuerpo.add(pPaso1, "Paso1");

        pPaso2.setBackground(new java.awt.Color(255, 255, 255));
        pPaso2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(150, 172, 229), 2));
        pPaso2.setForeground(new java.awt.Color(80, 98, 143));
        pPaso2.setMinimumSize(new java.awt.Dimension(500, 650));
        pPaso2.setOpaque(false);
        pPaso2.setPreferredSize(new java.awt.Dimension(500, 650));
        pPaso2.setLayout(new java.awt.GridBagLayout());

        bSiguientePaso2.setFont(new java.awt.Font("Arial", 0, 14));
        bSiguientePaso2.setForeground(new java.awt.Color(80, 98, 143));
        bSiguientePaso2.setText("Siguiente");
        bSiguientePaso2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        bSiguientePaso2.setMinimumSize(new java.awt.Dimension(100, 50));
        bSiguientePaso2.setPreferredSize(new java.awt.Dimension(125, 75));
        bSiguientePaso2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pasarAPaso3(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTHEAST;
        gridBagConstraints.insets = new java.awt.Insets(21, 11, 8, 8);
        pPaso2.add(bSiguientePaso2, gridBagConstraints);

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

        TImgen.setFont(new java.awt.Font("Arial", 0, 14));
        TImgen.setForeground(new java.awt.Color(80, 98, 143));
        TImgen.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(150, 172, 229), 3, true));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(28, 11, 11, 11);
        pPaso2.add(TImgen, gridBagConstraints);

        bImagen.setFont(new java.awt.Font("Arial", 0, 14));
        bImagen.setForeground(new java.awt.Color(80, 98, 143));
        bImagen.setText("Examinar");
        bImagen.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(28, 11, 11, 11);
        pPaso2.add(bImagen, gridBagConstraints);

        lPrecio.setFont(new java.awt.Font("Arial", 0, 14));
        lPrecio.setForeground(new java.awt.Color(80, 98, 143));
        lPrecio.setText("Precio de venta");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(28, 11, 11, 11);
        pPaso2.add(lPrecio, gridBagConstraints);

        tPrecio.setFont(new java.awt.Font("Arial", 0, 14));
        tPrecio.setForeground(new java.awt.Color(80, 98, 143));
        tPrecio.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(150, 172, 229), 3, true));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 100;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(28, 11, 11, 11);
        pPaso2.add(tPrecio, gridBagConstraints);

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

        tTiempo.setFont(new java.awt.Font("Arial", 0, 14));
        tTiempo.setForeground(new java.awt.Color(80, 98, 143));
        tTiempo.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(150, 172, 229), 3, true));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 100;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(28, 11, 11, 11);
        pPaso2.add(tTiempo, gridBagConstraints);

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

        tDivisiones.setFont(new java.awt.Font("Arial", 0, 14));
        tDivisiones.setForeground(new java.awt.Color(80, 98, 143));
        tDivisiones.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(150, 172, 229), 3, true));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.ipadx = 45;
        gridBagConstraints.insets = new java.awt.Insets(7, 7, 7, 7);
        pAtributoPlato.add(tDivisiones, gridBagConstraints);

        lPorciones.setFont(new java.awt.Font("Arial", 0, 14));
        lPorciones.setForeground(new java.awt.Color(80, 98, 143));
        lPorciones.setText("porciones/raciones");
        gridBagConstraints = new java.awt.GridBagConstraints();
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

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipady = 47;
        gridBagConstraints.insets = new java.awt.Insets(28, 11, 11, 11);
        pPaso2.add(pAtributoPlato, gridBagConstraints);

        bAnteriorPaso2.setFont(new java.awt.Font("Arial", 0, 14));
        bAnteriorPaso2.setForeground(new java.awt.Color(80, 98, 143));
        bAnteriorPaso2.setText("Anterior");
        bAnteriorPaso2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        bAnteriorPaso2.setMinimumSize(new java.awt.Dimension(100, 50));
        bAnteriorPaso2.setPreferredSize(new java.awt.Dimension(125, 75));
        bAnteriorPaso2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pasarAPaso1(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(21, 11, 11, 11);
        pPaso2.add(bAnteriorPaso2, gridBagConstraints);

        cuerpo.add(pPaso2, "Paso2");

        pPaso3.setBackground(new java.awt.Color(255, 255, 255));
        pPaso3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(150, 172, 229), 2));
        pPaso3.setForeground(new java.awt.Color(80, 98, 143));
        pPaso3.setMinimumSize(new java.awt.Dimension(500, 650));
        pPaso3.setOpaque(false);
        pPaso3.setPreferredSize(new java.awt.Dimension(500, 650));
        pPaso3.setLayout(new java.awt.GridBagLayout());

        bSiguientePaso3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        bSiguientePaso3.setForeground(new java.awt.Color(80, 98, 143));
        bSiguientePaso3.setText("Siguiente");
        bSiguientePaso3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        bSiguientePaso3.setMinimumSize(new java.awt.Dimension(125, 75));
        bSiguientePaso3.setPreferredSize(new java.awt.Dimension(125, 75));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTHEAST;
        gridBagConstraints.insets = new java.awt.Insets(21, 11, 13, 8);
        pPaso3.add(bSiguientePaso3, gridBagConstraints);

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

        bAnteriorPaso3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        bAnteriorPaso3.setForeground(new java.awt.Color(80, 98, 143));
        bAnteriorPaso3.setText("Anterior");
        bAnteriorPaso3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        bAnteriorPaso3.setMinimumSize(new java.awt.Dimension(125, 75));
        bAnteriorPaso3.setPreferredSize(new java.awt.Dimension(125, 75));
        bAnteriorPaso3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pasarAPaso2(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(21, 11, 11, 11);
        pPaso3.add(bAnteriorPaso3, gridBagConstraints);

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

        bCancelar.setFont(new java.awt.Font("Arial", 0, 12));
        bCancelar.setForeground(new java.awt.Color(150, 172, 229));
        bCancelar.setText("Cancelar");
        bCancelar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        bCancelar.setMaximumSize(new java.awt.Dimension(100, 45));
        bCancelar.setMinimumSize(new java.awt.Dimension(100, 45));
        bCancelar.setPreferredSize(new java.awt.Dimension(100, 45));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridheight = 2;
        cabecera.add(bCancelar, gridBagConstraints);

        add(cabecera, java.awt.BorderLayout.NORTH);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void closeDialog(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_closeDialog
        setVisible(false);
        dispose();
    }//GEN-LAST:event_closeDialog

    private void pasarAPaso2(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pasarAPaso2
        CardLayout cl = (CardLayout)(this.cuerpo.getLayout());
        cl.show(this.cuerpo, "Paso2");
        this.lSubtitulo.setText(SUBTITULOPASO2);
        this.lPaso.setText(PASO2);
    }//GEN-LAST:event_pasarAPaso2

    private void pasarAPaso3(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pasarAPaso3
        CardLayout cl = (CardLayout)(this.cuerpo.getLayout());
        cl.show(this.cuerpo, "Paso3");
        this.lSubtitulo.setText(SUBTITULOPASO3);
        this.lPaso.setText(PASO3);
    }//GEN-LAST:event_pasarAPaso3

    private void pasarAPaso1(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pasarAPaso1
        CardLayout cl = (CardLayout)(this.cuerpo.getLayout());
        cl.show(this.cuerpo, "Paso1");
        this.lSubtitulo.setText(SUBTITULOPASO1);
        this.lPaso.setText(PASO1);
    }//GEN-LAST:event_pasarAPaso1

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DialogoAnadirElemento dialog = new DialogoAnadirElemento(new java.awt.Frame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField TImgen;
    private javax.swing.JButton bAnteriorPaso2;
    private javax.swing.JButton bAnteriorPaso3;
    private javax.swing.JButton bCancelar;
    private javax.swing.JButton bImagen;
    private javax.swing.JComboBox bSeccion;
    private javax.swing.JButton bSiguiente;
    private javax.swing.JButton bSiguientePaso2;
    private javax.swing.JButton bSiguientePaso3;
    private javax.swing.JPanel cabecera;
    private javax.swing.JPanel cuerpo;
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
    private javax.swing.JScrollPane scrollTabla;
    private javax.swing.JTextArea tDescripcion;
    private javax.swing.JTextField tDivisiones;
    private javax.swing.JTextField tNombre;
    private javax.swing.JTextField tPrecio;
    private javax.swing.JTable tProductoSeccion;
    private javax.swing.JTextField tTiempo;
    private javax.swing.JLabel €;
    // End of variables declaration//GEN-END:variables
    
}
