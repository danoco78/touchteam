
package Vista.InterfazCocinero;

import ControladorPrincipal.ICocinero;
import GestionCarta.Elemento;
import GestionCarta.ElementoBebida;
import GestionCarta.ElementoPlato;
import GestionCarta.Seccion;
import GestionCarta.SeccionBebida;
import GestionCarta.SeccionComida;
import GestionStock.GestionProductos.Producto;
import Vista.DialogoConfirmacion;
import java.awt.CardLayout;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import utilidades.ImageRenderer;

/**
 *
 * @author Daniel Guerrero Martinez
 */
public class DialogoModificarElemento extends java.awt.Dialog {

    private final String SUBTITULOPASO1 = "Sección a la que pertenece";
    private final String SUBTITULOPASO2 = "Rellenar los datos del nuevo elemento";
    private final String SUBTITULOPASO3 = "Asociar productos";
    private final String PASO1 = "Paso 1/3";
    private final String PASO2 = "Paso 2/3";
    private final String PASO3 = "Paso 3/3";
    private int estado = 1;
    /*private ICarta gestorCarta;
    private IPreparaCarta carta;
    private IProducto gestorProducto;*/
    private ICocinero icocinero;
    private ArrayList disponibles;
    private ArrayList seleccionados;
    private ImageIcon imagen;
    private Elemento elemento;
    private ArrayList<Seccion> listaSecciones;
    // Si tipo es 0, se muestra el campo de porciones
    // Si tipo es 1, no se muestra el campo de porciones
    private int tipoSeccion;

    /** Creates new form DialogoAnadirElemento */
    public DialogoModificarElemento(java.awt.Frame parent,/* ICarta GestorCarta, IPreparaCarta Carta, IProducto GestorProducto*/ ICocinero iCocinero) {
        super(parent, true);
        initComponents();
       /* this.gestorCarta = GestorCarta;
        this.carta = Carta;
        this.gestorProducto = GestorProducto;*/
        this.icocinero = iCocinero;
        this.estado = 1;
        listaSecciones = new ArrayList<Seccion>(this.icocinero.obtieneSecciones());
        Collections.sort(listaSecciones);
        for (int i = 0; i < listaSecciones.size(); i++) {
            this.bSeccion.addItem(listaSecciones.get(i).getNombre());
        }
        this.bAnterior.setEnabled(false);
        this.bSiguiente.setEnabled(false);
        this.dSelector.setFileFilter(new FileNameExtensionFilter("IMAGEN", "jpg", "jpeg", "png", "gif"));
    }

    /*@Override
    public void paint(Graphics g) {
        super.paintComponents(g);
        Graphics2D g2 = (Graphics2D) g.create();
        Rectangle clip = g2.getClipBounds();
        g2.setPaint(new GradientPaint(0.0f, 0.0f, new Color(170, 192, 249), getWidth(), 0.0f, new Color(255, 255, 255)));
        g2.fillRect(clip.x, clip.y, clip.width, clip.height);
        super.paint(g);
    }*/

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
        pCentro2 = new javax.swing.JPanel();
        pIzq2 = new javax.swing.JPanel();
        lNombre = new javax.swing.JLabel();
        lDescripción = new javax.swing.JLabel();
        lImagen = new javax.swing.JLabel();
        lPrecio = new javax.swing.JLabel();
        lTiempo = new javax.swing.JLabel();
        pDer2 = new javax.swing.JPanel();
        tNombre = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tDescripcion = new javax.swing.JTextArea();
        pImagen = new javax.swing.JPanel();
        TImgen = new javax.swing.JTextField();
        bImagen = new javax.swing.JButton();
        pPrecio = new javax.swing.JPanel();
        € = new javax.swing.JLabel();
        tPrecio = new javax.swing.JFormattedTextField(new Float(0));
        pTiempo = new javax.swing.JPanel();
        tTiempo = new javax.swing.JFormattedTextField(new Integer(0));
        minutos = new javax.swing.JLabel();
        pSur2 = new javax.swing.JPanel();
        pAtributos = new javax.swing.JPanel();
        pAtributoPlato = new javax.swing.JPanel();
        lAyudaDivisiones = new javax.swing.JLabel();
        pArriba = new javax.swing.JPanel();
        lPorciones = new javax.swing.JLabel();
        tPorciones = new javax.swing.JFormattedTextField(new Integer(0));
        lDivision = new javax.swing.JLabel();
        pVacio = new javax.swing.JPanel();
        pMargen = new javax.swing.JPanel();
        pMargen1 = new javax.swing.JPanel();
        pMargen2 = new javax.swing.JPanel();
        pMargen3 = new javax.swing.JPanel();
        pPaso3 = new javax.swing.JPanel();
        pProductosDisponibles = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tProductosDisponibles = new javax.swing.JTable();
        pAtributoPlato2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tProductosAsociados = new javax.swing.JTable();
        cabecera = new javax.swing.JPanel();
        pIzq1 = new javax.swing.JPanel();
        lTitulo = new javax.swing.JLabel();
        lSubtitulo = new javax.swing.JLabel();
        pDer1 = new javax.swing.JPanel();
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

        lSeccion.setFont(new java.awt.Font("Arial", 0, 18));
        lSeccion.setForeground(new java.awt.Color(80, 98, 143));
        lSeccion.setText("Elija una sección");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        pPaso1.add(lSeccion, gridBagConstraints);

        bSeccion.setFont(new java.awt.Font("Arial", 0, 18));
        bSeccion.setForeground(new java.awt.Color(80, 98, 143));
        bSeccion.setMaximumRowCount(10);
        bSeccion.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(150, 172, 229), 2, true));
        bSeccion.setOpaque(false);
        bSeccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seleccionarSeccion(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        pPaso1.add(bSeccion, gridBagConstraints);

        lTablaSeccion.setFont(new java.awt.Font("Arial", 0, 18));
        lTablaSeccion.setForeground(new java.awt.Color(80, 98, 143));
        lTablaSeccion.setText("Elementos ya asociados a la sección");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(21, 10, 0, 10);
        pPaso1.add(lTablaSeccion, gridBagConstraints);

        scrollTabla.setOpaque(false);

        tProductoSeccion.setFont(new java.awt.Font("Arial", 0, 18));
        tProductoSeccion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Descripción", "Precio"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Float.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tProductoSeccion.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        tProductoSeccion.setGridColor(new java.awt.Color(211, 223, 253));
        tProductoSeccion.setMaximumSize(new java.awt.Dimension(2147483647, 2134212));
        tProductoSeccion.setMinimumSize(new java.awt.Dimension(300, 400));
        tProductoSeccion.setOpaque(false);
        tProductoSeccion.setPreferredSize(new java.awt.Dimension(300, 400));
        tProductoSeccion.getTableHeader().setReorderingAllowed(false);
        tProductoSeccion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                seleccionarElemento(evt);
            }
        });
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
        pPaso2.setLayout(new java.awt.BorderLayout());

        pCentro2.setOpaque(false);
        pCentro2.setLayout(new java.awt.BorderLayout());

        pIzq2.setOpaque(false);
        pIzq2.setLayout(new java.awt.GridLayout(0, 1, 0, 10));

        lNombre.setFont(new java.awt.Font("Arial", 0, 18));
        lNombre.setForeground(new java.awt.Color(80, 98, 143));
        lNombre.setText("Nombre");
        pIzq2.add(lNombre);

        lDescripción.setFont(new java.awt.Font("Arial", 0, 18));
        lDescripción.setForeground(new java.awt.Color(80, 98, 143));
        lDescripción.setText("Descripción");
        pIzq2.add(lDescripción);

        lImagen.setFont(new java.awt.Font("Arial", 0, 18));
        lImagen.setForeground(new java.awt.Color(80, 98, 143));
        lImagen.setText("Imagen");
        pIzq2.add(lImagen);

        lPrecio.setFont(new java.awt.Font("Arial", 0, 18));
        lPrecio.setForeground(new java.awt.Color(80, 98, 143));
        lPrecio.setText("Precio de venta");
        pIzq2.add(lPrecio);

        lTiempo.setFont(new java.awt.Font("Arial", 0, 18));
        lTiempo.setForeground(new java.awt.Color(80, 98, 143));
        lTiempo.setText("<html><body>Tiempo <span style=\"font-weight:bold\">medio</span><br> de elaboración</body></html>");
        pIzq2.add(lTiempo);

        pCentro2.add(pIzq2, java.awt.BorderLayout.WEST);

        pDer2.setOpaque(false);
        pDer2.setLayout(new java.awt.GridLayout(0, 1, 0, 10));

        tNombre.setFont(new java.awt.Font("Arial", 0, 18));
        tNombre.setForeground(new java.awt.Color(80, 98, 143));
        tNombre.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(150, 172, 229), 3, true));
        tNombre.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                validarFormulario(evt);
            }
        });
        pDer2.add(tNombre);

        tDescripcion.setColumns(20);
        tDescripcion.setFont(new java.awt.Font("Arial", 0, 18));
        tDescripcion.setForeground(new java.awt.Color(80, 98, 143));
        tDescripcion.setRows(2);
        tDescripcion.setAutoscrolls(false);
        tDescripcion.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(150, 172, 229), 3, true));
        tDescripcion.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                validarFormulario(evt);
            }
        });
        jScrollPane1.setViewportView(tDescripcion);

        pDer2.add(jScrollPane1);

        pImagen.setOpaque(false);
        pImagen.setLayout(new java.awt.BorderLayout(5, 0));

        TImgen.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        TImgen.setForeground(new java.awt.Color(80, 98, 143));
        TImgen.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(150, 172, 229), 3, true));
        TImgen.setEnabled(false);
        pImagen.add(TImgen, java.awt.BorderLayout.CENTER);

        bImagen.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        bImagen.setForeground(new java.awt.Color(80, 98, 143));
        bImagen.setText("Examinar");
        bImagen.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        bImagen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                examinar(evt);
            }
        });
        pImagen.add(bImagen, java.awt.BorderLayout.EAST);

        pDer2.add(pImagen);

        pPrecio.setOpaque(false);
        pPrecio.setLayout(new java.awt.BorderLayout(5, 0));

        €.setFont(new java.awt.Font("Arial", 0, 18));
        €.setForeground(new java.awt.Color(80, 98, 143));
        €.setText("€");
        pPrecio.add(€, java.awt.BorderLayout.EAST);

        tPrecio.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(150, 172, 229), 3, true));
        tPrecio.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        tPrecio.setFont(new java.awt.Font("Tahoma", 0, 18));
        tPrecio.setMinimumSize(new java.awt.Dimension(150, 20));
        tPrecio.setPreferredSize(new java.awt.Dimension(150, 20));
        tPrecio.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                validarFormulario(evt);
            }
        });
        pPrecio.add(tPrecio, java.awt.BorderLayout.CENTER);

        pDer2.add(pPrecio);

        pTiempo.setOpaque(false);
        pTiempo.setLayout(new java.awt.BorderLayout(5, 0));

        tTiempo.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(150, 172, 229), 3, true));
        tTiempo.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        tTiempo.setFont(new java.awt.Font("Tahoma", 0, 18));
        tTiempo.setMinimumSize(new java.awt.Dimension(150, 20));
        tTiempo.setPreferredSize(new java.awt.Dimension(150, 20));
        tTiempo.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                validarFormulario(evt);
            }
        });
        pTiempo.add(tTiempo, java.awt.BorderLayout.CENTER);

        minutos.setFont(new java.awt.Font("Arial", 0, 18));
        minutos.setForeground(new java.awt.Color(80, 98, 143));
        minutos.setText("minutos");
        pTiempo.add(minutos, java.awt.BorderLayout.EAST);

        pDer2.add(pTiempo);

        pCentro2.add(pDer2, java.awt.BorderLayout.CENTER);

        pSur2.setOpaque(false);
        pSur2.setLayout(new java.awt.BorderLayout());

        pAtributos.setBackground(new java.awt.Color(255, 255, 255));
        pAtributos.setForeground(new java.awt.Color(80, 98, 143));
        pAtributos.setOpaque(false);
        pAtributos.setLayout(new java.awt.CardLayout());

        pAtributoPlato.setBackground(new java.awt.Color(255, 255, 255));
        pAtributoPlato.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(211, 223, 253)), "Atributos del plato", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 18), new java.awt.Color(150, 172, 229))); // NOI18N
        pAtributoPlato.setForeground(new java.awt.Color(80, 98, 143));
        pAtributoPlato.setOpaque(false);
        pAtributoPlato.setLayout(new java.awt.BorderLayout());

        lAyudaDivisiones.setFont(new java.awt.Font("Arial", 0, 18));
        lAyudaDivisiones.setForeground(new java.awt.Color(80, 98, 143));
        lAyudaDivisiones.setText("(indique 0 o vacio para hacerlo indivisible)");
        pAtributoPlato.add(lAyudaDivisiones, java.awt.BorderLayout.SOUTH);

        pArriba.setOpaque(false);
        pArriba.setLayout(new java.awt.BorderLayout(5, 0));

        lPorciones.setFont(new java.awt.Font("Arial", 0, 18));
        lPorciones.setForeground(new java.awt.Color(80, 98, 143));
        lPorciones.setText("porciones/raciones");
        pArriba.add(lPorciones, java.awt.BorderLayout.EAST);

        tPorciones.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(150, 172, 229), 3, true));
        tPorciones.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        tPorciones.setFont(new java.awt.Font("Tahoma", 0, 18));
        tPorciones.setMinimumSize(new java.awt.Dimension(60, 20));
        tPorciones.setPreferredSize(new java.awt.Dimension(150, 20));
        tPorciones.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                validarFormulario(evt);
            }
        });
        pArriba.add(tPorciones, java.awt.BorderLayout.CENTER);

        lDivision.setFont(new java.awt.Font("Arial", 0, 18));
        lDivision.setForeground(new java.awt.Color(80, 98, 143));
        lDivision.setText("<html><body>El elemento se<br> puede dividir en</body></html>");
        pArriba.add(lDivision, java.awt.BorderLayout.WEST);

        pAtributoPlato.add(pArriba, java.awt.BorderLayout.CENTER);

        pAtributos.add(pAtributoPlato, "Atributos");

        pVacio.setBackground(new java.awt.Color(255, 255, 255));
        pAtributos.add(pVacio, "Vacio");

        pSur2.add(pAtributos, java.awt.BorderLayout.CENTER);

        pCentro2.add(pSur2, java.awt.BorderLayout.SOUTH);

        pPaso2.add(pCentro2, java.awt.BorderLayout.CENTER);

        pMargen.setOpaque(false);
        pPaso2.add(pMargen, java.awt.BorderLayout.NORTH);

        pMargen1.setOpaque(false);
        pPaso2.add(pMargen1, java.awt.BorderLayout.SOUTH);

        pMargen2.setOpaque(false);
        pPaso2.add(pMargen2, java.awt.BorderLayout.WEST);

        pMargen3.setOpaque(false);
        pPaso2.add(pMargen3, java.awt.BorderLayout.EAST);

        cuerpo.add(pPaso2, "Paso2");

        pPaso3.setBackground(new java.awt.Color(255, 255, 255));
        pPaso3.setForeground(new java.awt.Color(80, 98, 143));
        pPaso3.setMinimumSize(new java.awt.Dimension(500, 550));
        pPaso3.setOpaque(false);
        pPaso3.setPreferredSize(new java.awt.Dimension(500, 550));
        pPaso3.setLayout(new java.awt.GridBagLayout());

        pProductosDisponibles.setBackground(new java.awt.Color(255, 255, 255));
        pProductosDisponibles.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(211, 223, 253)), "Productos disponibles", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 18), new java.awt.Color(150, 172, 229))); // NOI18N
        pProductosDisponibles.setForeground(new java.awt.Color(80, 98, 143));
        pProductosDisponibles.setMinimumSize(new java.awt.Dimension(450, 250));
        pProductosDisponibles.setOpaque(false);
        pProductosDisponibles.setPreferredSize(new java.awt.Dimension(450, 250));
        pProductosDisponibles.setLayout(new java.awt.BorderLayout());

        jScrollPane2.setOpaque(false);
        jScrollPane2.setPreferredSize(new java.awt.Dimension(200, 200));

        tProductosDisponibles.setFont(new java.awt.Font("Tahoma", 0, 18));
        tProductosDisponibles.setModel(new javax.swing.table.DefaultTableModel(
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
        tProductosDisponibles.setGridColor(new java.awt.Color(211, 223, 253));
        tProductosDisponibles.setMinimumSize(new java.awt.Dimension(450, 250));
        tProductosDisponibles.setPreferredSize(new java.awt.Dimension(450, 250));
        tProductosDisponibles.getTableHeader().setReorderingAllowed(false);
        tProductosDisponibles.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                seleccionaProducto(evt);
            }
        });
        jScrollPane2.setViewportView(tProductosDisponibles);

        pProductosDisponibles.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(20, 8, 8, 8);
        pPaso3.add(pProductosDisponibles, gridBagConstraints);

        pAtributoPlato2.setBackground(new java.awt.Color(255, 255, 255));
        pAtributoPlato2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(211, 223, 253)), "Productos asociados", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 18), new java.awt.Color(150, 172, 229))); // NOI18N
        pAtributoPlato2.setForeground(new java.awt.Color(80, 98, 143));
        pAtributoPlato2.setMinimumSize(new java.awt.Dimension(450, 250));
        pAtributoPlato2.setOpaque(false);
        pAtributoPlato2.setPreferredSize(new java.awt.Dimension(450, 250));
        pAtributoPlato2.setLayout(new java.awt.BorderLayout());

        jScrollPane3.setOpaque(false);

        tProductosAsociados.setFont(new java.awt.Font("Tahoma", 0, 18));
        tProductosAsociados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Eliminar", "Nombre", "cantidad"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Float.class
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
        tProductosAsociados.setGridColor(new java.awt.Color(211, 223, 253));
        tProductosAsociados.setMinimumSize(new java.awt.Dimension(450, 250));
        tProductosAsociados.setPreferredSize(new java.awt.Dimension(450, 250));
        tProductosAsociados.getTableHeader().setResizingAllowed(false);
        tProductosAsociados.getTableHeader().setReorderingAllowed(false);
        tProductosAsociados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                quitarAsociados(evt);
            }
        });
        jScrollPane3.setViewportView(tProductosAsociados);

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
        cabecera.setLayout(new java.awt.BorderLayout());

        pIzq1.setOpaque(false);
        pIzq1.setLayout(new java.awt.GridLayout(0, 1));

        lTitulo.setFont(new java.awt.Font("Arial", 1, 24));
        lTitulo.setForeground(new java.awt.Color(80, 98, 143));
        lTitulo.setText("Modificar elemento de carta");
        pIzq1.add(lTitulo);

        lSubtitulo.setFont(new java.awt.Font("Arial", 0, 18));
        lSubtitulo.setForeground(new java.awt.Color(80, 98, 143));
        lSubtitulo.setText("Sección a la que pertenece");
        lSubtitulo.setPreferredSize(new java.awt.Dimension(175, 50));
        pIzq1.add(lSubtitulo);

        cabecera.add(pIzq1, java.awt.BorderLayout.CENTER);

        pDer1.setOpaque(false);
        pDer1.setLayout(new java.awt.GridLayout(0, 1));

        lPaso.setFont(new java.awt.Font("Arial", 0, 18));
        lPaso.setForeground(new java.awt.Color(80, 98, 143));
        lPaso.setText("Paso 1/3");
        pDer1.add(lPaso);

        bCancelar.setFont(new java.awt.Font("Arial", 0, 18));
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
        pDer1.add(bCancelar);

        cabecera.add(pDer1, java.awt.BorderLayout.EAST);

        add(cabecera, java.awt.BorderLayout.NORTH);

        pie.setBackground(new java.awt.Color(255, 255, 255));
        pie.setLayout(new java.awt.GridBagLayout());

        bSiguiente.setFont(new java.awt.Font("Arial", 0, 24));
        bSiguiente.setForeground(new java.awt.Color(80, 98, 143));
        bSiguiente.setText("Siguiente");
        bSiguiente.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        bSiguiente.setEnabled(false);
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

        bAnterior.setFont(new java.awt.Font("Arial", 0, 24));
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
        CardLayout cl = (CardLayout) (this.cuerpo.getLayout());
        switch (this.estado) {
            case 1:
                //Validar Datos
                this.lSubtitulo.setText(SUBTITULOPASO2);
                this.lPaso.setText(PASO2);
                this.bAnterior.setEnabled(true);
                // Evitamos la pantalla de asociar productos, que no se debe encontrar habilitada para la edición de elementos.
                this.estado+=2;
                //this.estado++;
                cl.next(this.cuerpo);
                this.validarFormulario(null);
                CardLayout cAtrib = (CardLayout)pAtributos.getLayout();
                if (this.tipoSeccion == 0) 
                    cAtrib.show(pAtributos, "Vacio");
                else
                    cAtrib.show(pAtributos, "Atributos");
                break;
            case 2:
                //validar Datos
                this.lSubtitulo.setText(SUBTITULOPASO3);
                this.lPaso.setText(PASO3);
                this.bSiguiente.setText("Finalizar");
                this.estado++;
                cl.next(this.cuerpo);
                break;
            case 3:
                String subtitulo = this.lSubtitulo.getText();
                String pregunta = "¿Confirma que desea modificar el siguiente Elemento?";
                /*String texto = "Nombre: " + this.tNombre.getText() +"\n"
                        + "Descripción: " + this.tDescripcion.getText() + "\n"
                        + "Precio: " + ((Float) this.tPrecio.getValue()) + " €" + "\n"
                        + "Porciones: " + ((Integer) this.tPorciones.getValue()) + "\n"
                        + "Tiempo de elaboración: " + ((Integer) this.tTiempo.getValue()) + "\n"
                        + "Esta compuesto por los ingredientes: " + "\n";
                for (int i = 0; i < seleccionados.size(); i++) {
                    Producto producto = (Producto) seleccionados.get(i);
                    texto += "\n - Nombre: " + producto.getNombre() + ", Cantidad: " + producto.getCantidad();
                }*/
                //System.out.println(texto);
                String texto = "<font face=\"Arial\">Nombre: <strong>" + this.tNombre.getText() +"</strong></font><br />"
                        + "<font face=\"Arial\">Descripción: <strong>" + this.tDescripcion.getText() + "</strong><br />"
                        + "<font face=\"Arial\">Precio: <strong>" + ((Float) this.tPrecio.getValue()) + " €" + "</strong><br />"
                        + "<font face=\"Arial\">Porciones: <strong>" + ((Integer) this.tPorciones.getValue()) + "</strong><br />"
                        + "<font face=\"Arial\">Tiempo de elaboración: <strong>" + ((Integer) this.tTiempo.getValue()) + "</strong><br />"
                        + "<font face=\"Arial\">Esta compuesto por los ingredientes: " + "<br /><br />";
                for (int i = 0; i < seleccionados.size(); i++) {
                    Producto producto = (Producto) seleccionados.get(i);
                    texto += "<font face=\"Arial\">&nbsp;- Nombre: <strong>" + producto.getNombre() + "</strong>, Cantidad: <strong>" + producto.getCantidad()+ "</strong> gr./l<br />";
                }
                DialogoConfirmacion confirmar = new DialogoConfirmacion(null, subtitulo, pregunta, texto);
                confirmar.setLocationRelativeTo(this);
                confirmar.setVisible(true);
                if (confirmar.isAceptado()) {
                    //ArrayList<Seccion> listaSecciones = new ArrayList<Seccion>(this.icocinero.obtieneSecciones());
                    Seccion seccion = listaSecciones.get(this.bSeccion.getSelectedIndex());
                    if (seccion.getClass() == SeccionComida.class) {
                        try {
                             ElementoPlato plato = new ElementoPlato(elemento.getCodigoElemento(), null, this.tNombre.getText(), this.tDescripcion.getText(), false,
                                    this.imagen, (Integer) this.tTiempo.getValue(), (Float) this.tPrecio.getValue(), (Integer) this.tPorciones.getValue());
                            this.icocinero.modificaElemento(plato);
                        } catch (Exception ex) {
                            JOptionPane.showMessageDialog(lTiempo, ex.getMessage());
                        }
                    } else {
                        try {
                            ElementoBebida bebida = new ElementoBebida(elemento.getCodigoElemento(), null, this.tNombre.getText(), this.tDescripcion.getText(), false,
                                    this.imagen, (Float) this.tPrecio.getValue(), (Integer) this.tPorciones.getValue());
                            this.icocinero.modificaElemento(bebida);
                        } catch (Exception ex) {
                            JOptionPane.showMessageDialog(lTiempo, ex.getMessage());
                        }
                    }
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
            case 3:
                this.lSubtitulo.setText(SUBTITULOPASO2);
                this.lPaso.setText(PASO2);
                this.bSiguiente.setText("Siguiente");
                this.estado -= 2;
                //this.estado--;
                this.validarFormulario(null);
                cl.previous(this.cuerpo);
                break;
        }
    }//GEN-LAST:event_anterior

    private void Salir(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Salir
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_Salir

    private void seleccionaProducto(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_seleccionaProducto
        int select = this.tProductosDisponibles.getSelectedRow();
        if (select != -1) {
            Producto productoSeleccionado = (Producto) this.disponibles.get(select);
            this.disponibles.remove(select);
            ((DefaultTableModel) this.tProductosDisponibles.getModel()).removeRow(select);
            this.seleccionados.add(productoSeleccionado);
            Object[] obj = new Object[3];
            JButton eliminar = new JButton("Quitar");
            eliminar.addActionListener(bSeccion);
            obj[0] = "Quitar";
            obj[1] = productoSeleccionado.getNombre();
            obj[2] = 0.0;
            ((DefaultTableModel) this.tProductosAsociados.getModel()).addRow(obj);
        }
    }//GEN-LAST:event_seleccionaProducto

    private void seleccionarElemento(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_seleccionarElemento
        int select = this.tProductoSeccion.getSelectedRow();
        if (select != -1) {
            this.bSiguiente.setEnabled(true);
            //ArrayList<Seccion> listaSecciones = new ArrayList<Seccion>(this.icocinero.obtieneSecciones());
            Seccion seccion = this.listaSecciones.get(this.bSeccion.getSelectedIndex());
            ArrayList<Elemento> listaElementos;
            if (seccion instanceof SeccionBebida)
                listaElementos = new ArrayList<Elemento>(((SeccionBebida)seccion).getListaElementoBebida());
            else
                listaElementos = new ArrayList<Elemento>(((SeccionComida)seccion).getListaElementoPlato());
            this.elemento = listaElementos.get(select);
            this.tNombre.setText(elemento.getNombre());
            this.tDescripcion.setText(elemento.getDescripcion());
            this.tPorciones.setValue(elemento.getDivisionesMaximas());
            this.tPrecio.setValue(elemento.getPrecio());
            this.TImgen.setText("Imagen Actual");
            this.imagen = elemento.getFoto();
            ArrayList<Producto> listaProductos = new ArrayList<Producto>(this.icocinero.obtieneIngredientes());
            disponibles = listaProductos;
            DefaultTableModel modelo = new DefaultTableModel() {
                @Override
                public boolean isCellEditable(int x, int y) {
                    return false;
                }
            };
            modelo.addColumn(this.tProductosDisponibles.getColumnName(0));
            modelo.addColumn(this.tProductosDisponibles.getColumnName(1));
            modelo.addColumn(this.tProductosDisponibles.getColumnName(2));
            modelo.setRowCount(listaProductos.size());
            this.tProductosDisponibles.setModel(modelo);
            this.tProductosDisponibles.getColumnModel().getColumn(2).setCellRenderer(new ImageRenderer());
            this.tProductosDisponibles.setRowHeight(50);
            for (int i = 0; i < listaProductos.size(); i++) {
                this.tProductosDisponibles.setValueAt(listaProductos.get(i).getNombre(), i, 0);
                this.tProductosDisponibles.setValueAt(listaProductos.get(i).getCantidad(), i, 1);
                this.tProductosDisponibles.setValueAt(listaProductos.get(i).getImagen(), i, 2);
            }
            
            if (elemento instanceof ElementoBebida)
                seleccionados = new ArrayList(((ElementoBebida)elemento).getListaBebidas().keySet());
            else
                seleccionados = new ArrayList(((ElementoPlato)elemento).getListaIngredientes().keySet());
            
            for (int i = 0; i < seleccionados.size(); i++) {
                Producto producto = (Producto) seleccionados.get(i);
                Object[] obj = new Object[3];
                JButton eliminar = new JButton("Quitar");
                eliminar.addActionListener(bSeccion);
                obj[0] = "Quitar";
                obj[1] = producto.getNombre();
                obj[2] = producto.getCantidad();
                ((DefaultTableModel) this.tProductosAsociados.getModel()).addRow(obj);
                disponibles.remove(producto);
            }

        } else {
            this.bSiguiente.setEnabled(false);
        }
    }//GEN-LAST:event_seleccionarElemento

    private void seleccionarSeccion(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seleccionarSeccion
        if (this.bSeccion.getSelectedIndex() != -1) {
            //ArrayList<Seccion> listaSecciones = new ArrayList<Seccion>(this.icocinero.obtieneSecciones());
            Seccion seccion =  listaSecciones.get(this.bSeccion.getSelectedIndex());
            ArrayList<Elemento> lista;
            if (seccion instanceof SeccionBebida) {
                this.tipoSeccion = 0;
                lista = new ArrayList<Elemento>(((SeccionBebida)seccion).getListaElementoBebida());
            }
            else {
                this.tipoSeccion = 1;
                lista = new ArrayList<Elemento>(((SeccionComida)seccion).getListaElementoPlato());
            }
            DefaultTableModel modelo = new DefaultTableModel() {
                @Override
                public boolean isCellEditable(int x, int y) {
                    return false;
                }
            };
            modelo.addColumn(this.tProductoSeccion.getColumnName(0));
            modelo.addColumn(this.tProductoSeccion.getColumnName(1));
            modelo.addColumn(this.tProductoSeccion.getColumnName(2));
            modelo.setRowCount(lista.size());
            this.tProductoSeccion.setModel(modelo);
            for (int i = 0; i < lista.size(); i++) {
                this.tProductoSeccion.setValueAt(lista.get(i).getNombre(), i, 0);
                this.tProductoSeccion.setValueAt(lista.get(i).getDescripcion(), i, 1);
                this.tProductoSeccion.setValueAt(lista.get(i).getPrecio(), i, 2);
            }
            //this.bSiguiente.setEnabled(true);
        }
    }//GEN-LAST:event_seleccionarSeccion

    private void quitarAsociados(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_quitarAsociados
        if (this.tProductosAsociados.getSelectedColumn() == 0) {
            int select = this.tProductosAsociados.getSelectedRow();
            Producto productoSeleccionado = (Producto) this.seleccionados.get(select);
            this.seleccionados.remove(select);
            ((DefaultTableModel) this.tProductosAsociados.getModel()).removeRow(select);
            this.disponibles.add(productoSeleccionado);
            Object[] obj = new Object[3];
            obj[0] = productoSeleccionado.getNombre();
            obj[1] = productoSeleccionado.getCantidad();
            obj[2] = productoSeleccionado.getImagen();
            ((DefaultTableModel) this.tProductosDisponibles.getModel()).addRow(obj);
        }
    }//GEN-LAST:event_quitarAsociados

    private void validarFormulario(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_validarFormulario
        if (this.tNombre.getText().length() != 0 && this.tDescripcion.getText().length() != 0
                && ((Float) this.tPrecio.getValue()) != 0) {
            this.bSiguiente.setEnabled(true);
        } else {
            this.bSiguiente.setEnabled(false);
        }
}//GEN-LAST:event_validarFormulario

    private void examinar(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_examinar
        if (this.dSelector.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            this.TImgen.setText(this.dSelector.getSelectedFile().getAbsolutePath());
            File f = new File(this.TImgen.getText());
            if (f.exists()) {
                imagen = new ImageIcon(f.getPath());
            } else {
                this.TImgen.setText("Imagen no valida");
            }
        }
}//GEN-LAST:event_examinar

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
    private javax.swing.JPanel pArriba;
    private javax.swing.JPanel pAtributoPlato;
    private javax.swing.JPanel pAtributoPlato2;
    private javax.swing.JPanel pAtributos;
    private javax.swing.JPanel pCentro2;
    private javax.swing.JPanel pDer1;
    private javax.swing.JPanel pDer2;
    private javax.swing.JPanel pImagen;
    private javax.swing.JPanel pIzq1;
    private javax.swing.JPanel pIzq2;
    private javax.swing.JPanel pMargen;
    private javax.swing.JPanel pMargen1;
    private javax.swing.JPanel pMargen2;
    private javax.swing.JPanel pMargen3;
    private javax.swing.JPanel pPaso1;
    private javax.swing.JPanel pPaso2;
    private javax.swing.JPanel pPaso3;
    private javax.swing.JPanel pPrecio;
    private javax.swing.JPanel pProductosDisponibles;
    private javax.swing.JPanel pSur2;
    private javax.swing.JPanel pTiempo;
    private javax.swing.JPanel pVacio;
    private javax.swing.JPanel pie;
    private javax.swing.JScrollPane scrollTabla;
    private javax.swing.JTextArea tDescripcion;
    private javax.swing.JTextField tNombre;
    private javax.swing.JFormattedTextField tPorciones;
    private javax.swing.JFormattedTextField tPrecio;
    private javax.swing.JTable tProductoSeccion;
    private javax.swing.JTable tProductosAsociados;
    private javax.swing.JTable tProductosDisponibles;
    private javax.swing.JFormattedTextField tTiempo;
    private javax.swing.JLabel €;
    // End of variables declaration//GEN-END:variables
}
