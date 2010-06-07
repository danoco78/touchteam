
package Vista.InterfazCocinero;

import ControladorPrincipal.ICocinero;
import GestionCarta.Elemento;
import GestionCarta.ElementoBebida;
import GestionCarta.ElementoPlato;
import GestionCarta.Seccion;
import GestionCarta.SeccionBebida;
import GestionCarta.SeccionComida;
import GestionStock.GestionProductos.Bebida;
import GestionStock.GestionProductos.Ingrediente;
import GestionStock.GestionProductos.Producto;
import Vista.DialogoConfirmacion;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import utilidades.ImageRenderer;

/**
 *
 * @author Daniel Guerrero Martinez
 */
public class DialogoAnadirElemento extends java.awt.Dialog {

    private final String SUBTITULOPASO1 = "Sección a la que pertenece";
    private final String SUBTITULOPASO2 = "Rellenar los datos del nuevo elemento";
    private final String SUBTITULOPASO3 = "Asociar productos";
    private final String PASO1 = "Paso 1/3";
    private final String PASO2 = "Paso 2/3";
    private final String PASO3 = "Paso 3/3";
    private int estado = 1;
    /*private ICarta gestorCarta;
    private IPreparaCarta carta;*/
    private ICocinero icocinero;
    private ArrayList<Producto> disponibles;
    private ArrayList seleccionados;
    private ArrayList<Seccion> listaSecciones;


    /** Creates new form DialogoAnadirElemento */
    public DialogoAnadirElemento(java.awt.Frame parent,/* ICarta GestorCarta, IPreparaCarta Carta*/ ICocinero iCocinero ) {
        super(parent, true);
        initComponents();

        /*this.gestorCarta = GestorCarta;
        this.carta = Carta;*/
        this.icocinero = iCocinero;
        this.estado = 1;
        //HashSet<Seccion> lSeccionesLocal = this.icocinero.obtieneSecciones();
        listaSecciones = new ArrayList<Seccion>(this.icocinero.obtieneSecciones());
        java.util.Collections.sort(listaSecciones);

        Iterator<Seccion> iterador = listaSecciones.iterator();

        while(iterador.hasNext()){
            this.bSeccion.addItem(iterador.next().getNombre());
        }
        seleccionados = new ArrayList<Producto>();
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
        pMargenDer1 = new javax.swing.JPanel();
        pMargenIzq = new javax.swing.JPanel();
        pCentro1 = new javax.swing.JPanel();
        pNorte1 = new javax.swing.JPanel();
        lSeccion = new javax.swing.JLabel();
        bSeccion = new javax.swing.JComboBox();
        pSur1 = new javax.swing.JPanel();
        scrollTabla = new javax.swing.JScrollPane();
        tProductoSeccion = new javax.swing.JTable();
        lTablaSeccion = new javax.swing.JLabel();
        pMargenSup1 = new javax.swing.JPanel();
        pPaso2 = new javax.swing.JPanel();
        pMargenDer2 = new javax.swing.JPanel();
        pMargenSup2 = new javax.swing.JPanel();
        pMargenIzq1 = new javax.swing.JPanel();
        pCentro2 = new javax.swing.JPanel();
        pCentroIzq = new javax.swing.JPanel();
        lNombre = new javax.swing.JLabel();
        lDescripción = new javax.swing.JLabel();
        lImagen = new javax.swing.JLabel();
        lPrecio = new javax.swing.JLabel();
        lTiempo = new javax.swing.JLabel();
        pCentroDer = new javax.swing.JPanel();
        tNombre = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tDescripcion = new javax.swing.JTextArea();
        pImagen = new javax.swing.JPanel();
        TImgen = new javax.swing.JTextField();
        bImagen = new javax.swing.JButton();
        pPrecio = new javax.swing.JPanel();
        tPrecio = new javax.swing.JFormattedTextField(new Float(0));
        € = new javax.swing.JLabel();
        pTiempo = new javax.swing.JPanel();
        tTiempo = new javax.swing.JFormattedTextField(new Integer(0));
        minutos = new javax.swing.JLabel();
        pCentroSur = new javax.swing.JPanel();
        pAtributoPlato = new javax.swing.JPanel();
        lAyudaDivisiones = new javax.swing.JLabel();
        pSur3 = new javax.swing.JPanel();
        lDivision = new javax.swing.JLabel();
        tPorciones = new javax.swing.JFormattedTextField(new Integer(0));
        lPorciones = new javax.swing.JLabel();
        pPaso3 = new javax.swing.JPanel();
        pCentro3 = new javax.swing.JPanel();
        pProductosDisponibles = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tProductosDisponibles = new javax.swing.JTable();
        pAtributoPlato2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tProductosAsociados = new javax.swing.JTable();
        pMargenDer3 = new javax.swing.JPanel();
        pMargenSup3 = new javax.swing.JPanel();
        pMargenIzq2 = new javax.swing.JPanel();
        cabecera = new javax.swing.JPanel();
        pIzq = new javax.swing.JPanel();
        lTitulo = new javax.swing.JLabel();
        lSubtitulo = new javax.swing.JLabel();
        pDer = new javax.swing.JPanel();
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
        pPaso1.setLayout(new java.awt.BorderLayout());

        pMargenDer1.setOpaque(false);
        pPaso1.add(pMargenDer1, java.awt.BorderLayout.EAST);

        pMargenIzq.setOpaque(false);
        pPaso1.add(pMargenIzq, java.awt.BorderLayout.WEST);

        pCentro1.setOpaque(false);
        pCentro1.setLayout(new java.awt.BorderLayout(0, 20));

        pNorte1.setOpaque(false);
        pNorte1.setLayout(new java.awt.BorderLayout(10, 0));

        lSeccion.setFont(new java.awt.Font("Arial", 0, 18));
        lSeccion.setForeground(new java.awt.Color(80, 98, 143));
        lSeccion.setText("Elija una sección");
        pNorte1.add(lSeccion, java.awt.BorderLayout.WEST);

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
        pNorte1.add(bSeccion, java.awt.BorderLayout.CENTER);

        pCentro1.add(pNorte1, java.awt.BorderLayout.NORTH);

        pSur1.setOpaque(false);
        pSur1.setLayout(new java.awt.BorderLayout());

        scrollTabla.setOpaque(false);

        tProductoSeccion.setFont(new java.awt.Font("Arial", 0, 18));
        tProductoSeccion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Descripción", "Precio (€)"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Float.class
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
        tProductoSeccion.setGridColor(new java.awt.Color(211, 223, 253));
        tProductoSeccion.setMinimumSize(new java.awt.Dimension(300, 400));
        tProductoSeccion.setOpaque(false);
        tProductoSeccion.setPreferredSize(new java.awt.Dimension(300, 400));
        tProductoSeccion.setRowHeight(20);
        tProductoSeccion.getTableHeader().setReorderingAllowed(false);
        scrollTabla.setViewportView(tProductoSeccion);

        pSur1.add(scrollTabla, java.awt.BorderLayout.CENTER);

        lTablaSeccion.setFont(new java.awt.Font("Arial", 0, 14));
        lTablaSeccion.setForeground(new java.awt.Color(80, 98, 143));
        lTablaSeccion.setText("Elementos ya asociados a la sección");
        pSur1.add(lTablaSeccion, java.awt.BorderLayout.NORTH);

        pCentro1.add(pSur1, java.awt.BorderLayout.CENTER);

        pPaso1.add(pCentro1, java.awt.BorderLayout.CENTER);

        pMargenSup1.setOpaque(false);
        pPaso1.add(pMargenSup1, java.awt.BorderLayout.NORTH);

        cuerpo.add(pPaso1, "Paso1");

        pPaso2.setBackground(new java.awt.Color(255, 255, 255));
        pPaso2.setForeground(new java.awt.Color(80, 98, 143));
        pPaso2.setMinimumSize(new java.awt.Dimension(500, 550));
        pPaso2.setOpaque(false);
        pPaso2.setPreferredSize(new java.awt.Dimension(500, 550));
        pPaso2.setLayout(new java.awt.BorderLayout());

        pMargenDer2.setOpaque(false);
        pPaso2.add(pMargenDer2, java.awt.BorderLayout.EAST);

        pMargenSup2.setOpaque(false);
        pPaso2.add(pMargenSup2, java.awt.BorderLayout.NORTH);

        pMargenIzq1.setOpaque(false);
        pPaso2.add(pMargenIzq1, java.awt.BorderLayout.WEST);

        pCentro2.setOpaque(false);
        pCentro2.setLayout(new java.awt.BorderLayout(0, 20));

        pCentroIzq.setOpaque(false);
        pCentroIzq.setLayout(new java.awt.GridLayout(0, 1));

        lNombre.setFont(new java.awt.Font("Arial", 0, 18));
        lNombre.setForeground(new java.awt.Color(80, 98, 143));
        lNombre.setText("Nombre");
        pCentroIzq.add(lNombre);

        lDescripción.setFont(new java.awt.Font("Arial", 0, 18));
        lDescripción.setForeground(new java.awt.Color(80, 98, 143));
        lDescripción.setText("Descripción");
        pCentroIzq.add(lDescripción);

        lImagen.setFont(new java.awt.Font("Arial", 0, 18));
        lImagen.setForeground(new java.awt.Color(80, 98, 143));
        lImagen.setText("Imagen");
        pCentroIzq.add(lImagen);

        lPrecio.setFont(new java.awt.Font("Arial", 0, 18));
        lPrecio.setForeground(new java.awt.Color(80, 98, 143));
        lPrecio.setText("Precio de venta");
        pCentroIzq.add(lPrecio);

        lTiempo.setFont(new java.awt.Font("Arial", 0, 18));
        lTiempo.setForeground(new java.awt.Color(80, 98, 143));
        lTiempo.setText("<html><body>Tiempo Medio<br>de elaboraci&oacute;n</body></html>");
        pCentroIzq.add(lTiempo);

        pCentro2.add(pCentroIzq, java.awt.BorderLayout.WEST);

        pCentroDer.setOpaque(false);
        pCentroDer.setLayout(new java.awt.GridLayout(0, 1, 0, 10));

        tNombre.setFont(new java.awt.Font("Arial", 0, 24));
        tNombre.setForeground(new java.awt.Color(80, 98, 143));
        tNombre.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(150, 172, 229), 3, true));
        tNombre.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tNombreFocusGained(evt);
            }
        });
        tNombre.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                validarFormulario(evt);
            }
        });
        pCentroDer.add(tNombre);

        tDescripcion.setColumns(20);
        tDescripcion.setFont(new java.awt.Font("Arial", 0, 18));
        tDescripcion.setForeground(new java.awt.Color(80, 98, 143));
        tDescripcion.setRows(2);
        tDescripcion.setAutoscrolls(false);
        tDescripcion.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(150, 172, 229), 3, true));
        tDescripcion.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tDescripcionFocusGained(evt);
            }
        });
        tDescripcion.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                validarFormulario(evt);
            }
        });
        jScrollPane1.setViewportView(tDescripcion);

        pCentroDer.add(jScrollPane1);

        pImagen.setOpaque(false);
        pImagen.setLayout(new java.awt.BorderLayout(10, 0));

        TImgen.setFont(new java.awt.Font("Arial", 0, 18));
        TImgen.setForeground(new java.awt.Color(80, 98, 143));
        TImgen.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(150, 172, 229), 3, true));
        TImgen.setEnabled(false);
        TImgen.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TImgenMouseClicked(evt);
            }
        });
        pImagen.add(TImgen, java.awt.BorderLayout.CENTER);

        bImagen.setFont(new java.awt.Font("Arial", 0, 18));
        bImagen.setForeground(new java.awt.Color(80, 98, 143));
        bImagen.setText("Examinar");
        bImagen.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        bImagen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                examinar(evt);
            }
        });
        pImagen.add(bImagen, java.awt.BorderLayout.EAST);

        pCentroDer.add(pImagen);

        pPrecio.setOpaque(false);
        pPrecio.setLayout(new java.awt.BorderLayout(5, 0));

        tPrecio.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(150, 172, 229), 3, true));
        tPrecio.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        tPrecio.setFont(new java.awt.Font("Tahoma", 0, 18));
        tPrecio.setMinimumSize(new java.awt.Dimension(150, 20));
        tPrecio.setPreferredSize(new java.awt.Dimension(150, 20));
        tPrecio.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tPrecioFocusGained(evt);
            }
        });
        tPrecio.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                validarFormulario(evt);
            }
        });
        pPrecio.add(tPrecio, java.awt.BorderLayout.CENTER);

        €.setFont(new java.awt.Font("Arial", 0, 18));
        €.setForeground(new java.awt.Color(80, 98, 143));
        €.setText("€");
        pPrecio.add(€, java.awt.BorderLayout.EAST);

        pCentroDer.add(pPrecio);

        pTiempo.setOpaque(false);
        pTiempo.setLayout(new java.awt.BorderLayout(5, 0));

        tTiempo.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(150, 172, 229), 3, true));
        tTiempo.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        tTiempo.setFont(new java.awt.Font("Tahoma", 0, 18));
        tTiempo.setMinimumSize(new java.awt.Dimension(150, 20));
        tTiempo.setPreferredSize(new java.awt.Dimension(150, 20));
        tTiempo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tTiempoFocusGained(evt);
            }
        });
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

        pCentroDer.add(pTiempo);

        pCentro2.add(pCentroDer, java.awt.BorderLayout.CENTER);

        pCentroSur.setOpaque(false);
        pCentroSur.setLayout(new java.awt.BorderLayout());

        pAtributoPlato.setBackground(new java.awt.Color(255, 255, 255));
        pAtributoPlato.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(211, 223, 253)), "Atributos del elemento", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 18), new java.awt.Color(150, 172, 229))); // NOI18N
        pAtributoPlato.setForeground(new java.awt.Color(80, 98, 143));
        pAtributoPlato.setOpaque(false);
        pAtributoPlato.setLayout(new java.awt.BorderLayout(0, 5));

        lAyudaDivisiones.setFont(new java.awt.Font("Arial", 0, 18));
        lAyudaDivisiones.setForeground(new java.awt.Color(80, 98, 143));
        lAyudaDivisiones.setText("(indique 0 o vacio para hacerlo indivisible)");
        pAtributoPlato.add(lAyudaDivisiones, java.awt.BorderLayout.SOUTH);

        pSur3.setOpaque(false);
        pSur3.setLayout(new java.awt.GridLayout(0, 3, 5, 0));

        lDivision.setFont(new java.awt.Font("Arial", 0, 18));
        lDivision.setForeground(new java.awt.Color(80, 98, 143));
        lDivision.setText("<html><body>El elemento se<br> puede dividir en</body></html>");
        pSur3.add(lDivision);

        tPorciones.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(150, 172, 229), 3, true));
        tPorciones.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        tPorciones.setFont(new java.awt.Font("Tahoma", 0, 18));
        tPorciones.setMinimumSize(new java.awt.Dimension(60, 20));
        tPorciones.setPreferredSize(new java.awt.Dimension(150, 20));
        tPorciones.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tPorcionesFocusGained(evt);
            }
        });
        tPorciones.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                validarFormulario(evt);
            }
        });
        pSur3.add(tPorciones);

        lPorciones.setFont(new java.awt.Font("Arial", 0, 18));
        lPorciones.setForeground(new java.awt.Color(80, 98, 143));
        lPorciones.setText("porciones/raciones");
        pSur3.add(lPorciones);

        pAtributoPlato.add(pSur3, java.awt.BorderLayout.CENTER);

        pCentroSur.add(pAtributoPlato, java.awt.BorderLayout.CENTER);

        pCentro2.add(pCentroSur, java.awt.BorderLayout.SOUTH);

        pPaso2.add(pCentro2, java.awt.BorderLayout.CENTER);

        cuerpo.add(pPaso2, "Paso2");

        pPaso3.setBackground(new java.awt.Color(255, 255, 255));
        pPaso3.setForeground(new java.awt.Color(80, 98, 143));
        pPaso3.setMinimumSize(new java.awt.Dimension(500, 550));
        pPaso3.setOpaque(false);
        pPaso3.setPreferredSize(new java.awt.Dimension(500, 550));
        pPaso3.setLayout(new java.awt.BorderLayout());

        pCentro3.setOpaque(false);
        pCentro3.setLayout(new java.awt.BorderLayout(0, 10));

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
        tProductosDisponibles.setMinimumSize(new java.awt.Dimension(450, 3000));
        tProductosDisponibles.setPreferredSize(new java.awt.Dimension(450, 3000));
        tProductosDisponibles.getTableHeader().setReorderingAllowed(false);
        tProductosDisponibles.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                seleccionaProducto(evt);
            }
        });
        jScrollPane2.setViewportView(tProductosDisponibles);

        pProductosDisponibles.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        pCentro3.add(pProductosDisponibles, java.awt.BorderLayout.CENTER);

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
                "Quitar", "Nombre", "Cantidad (gr/l)"
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
                BorrarAsociados(evt);
            }
        });
        jScrollPane3.setViewportView(tProductosAsociados);

        pAtributoPlato2.add(jScrollPane3, java.awt.BorderLayout.CENTER);

        pCentro3.add(pAtributoPlato2, java.awt.BorderLayout.SOUTH);

        pPaso3.add(pCentro3, java.awt.BorderLayout.CENTER);

        pMargenDer3.setOpaque(false);
        pPaso3.add(pMargenDer3, java.awt.BorderLayout.EAST);

        pMargenSup3.setOpaque(false);
        pPaso3.add(pMargenSup3, java.awt.BorderLayout.NORTH);

        pMargenIzq2.setOpaque(false);
        pPaso3.add(pMargenIzq2, java.awt.BorderLayout.WEST);

        cuerpo.add(pPaso3, "Paso3");

        add(cuerpo, java.awt.BorderLayout.CENTER);

        cabecera.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(150, 172, 229), 2));
        cabecera.setMinimumSize(new java.awt.Dimension(150, 100));
        cabecera.setOpaque(false);
        cabecera.setPreferredSize(new java.awt.Dimension(150, 100));
        cabecera.setLayout(new java.awt.BorderLayout());

        pIzq.setOpaque(false);
        pIzq.setLayout(new java.awt.BorderLayout());

        lTitulo.setFont(new java.awt.Font("Arial", 1, 24));
        lTitulo.setForeground(new java.awt.Color(80, 98, 143));
        lTitulo.setText("Añadir nuevo elemento a carta");
        pIzq.add(lTitulo, java.awt.BorderLayout.CENTER);

        lSubtitulo.setFont(new java.awt.Font("Arial", 0, 18));
        lSubtitulo.setForeground(new java.awt.Color(80, 98, 143));
        lSubtitulo.setText("Sección a la que pertenece");
        lSubtitulo.setPreferredSize(new java.awt.Dimension(175, 50));
        pIzq.add(lSubtitulo, java.awt.BorderLayout.SOUTH);

        cabecera.add(pIzq, java.awt.BorderLayout.CENTER);

        pDer.setOpaque(false);
        pDer.setLayout(new java.awt.BorderLayout());

        lPaso.setFont(new java.awt.Font("Arial", 0, 18));
        lPaso.setForeground(new java.awt.Color(80, 98, 143));
        lPaso.setText("Paso 1/3");
        pDer.add(lPaso, java.awt.BorderLayout.NORTH);

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
        pDer.add(bCancelar, java.awt.BorderLayout.CENTER);

        cabecera.add(pDer, java.awt.BorderLayout.EAST);

        add(cabecera, java.awt.BorderLayout.NORTH);

        pie.setBackground(new java.awt.Color(255, 255, 255));
        pie.setLayout(new java.awt.GridBagLayout());

        bSiguiente.setFont(new java.awt.Font("Arial", 0, 24));
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
                this.estado++;
                cl.next(this.cuerpo);
                this.validarFormulario(null);
                if (this.bSeccion.getSelectedIndex() == 4 || this.bSeccion.getSelectedIndex() == 5){
                    this.tTiempo.setVisible(false);
                    this.lTiempo.setVisible(false);
                    this.minutos.setVisible(false);
                }else{
                    this.tTiempo.setVisible(true);
                    this.lTiempo.setVisible(true);
                    this.minutos.setVisible(true);
                }
                break;
            case 2:
                //validar Datos
                this.lSubtitulo.setText(SUBTITULOPASO3);
                this.lPaso.setText(PASO3);
                this.bSiguiente.setText("Finalizar");
                this.estado++;
                Iterator<Seccion> it = this.listaSecciones.iterator();
                for(int i = 0; i< this.bSeccion.getSelectedIndex(); i++ ) it.next();
                Seccion sec = it.next();
                HashSet<Producto> listaProductos = this.icocinero.obtieneProductosSeccion(sec);
                Iterator<Producto> itpro = listaProductos.iterator();
                disponibles = new ArrayList<Producto>(listaProductos);
                DefaultTableModel modelo = new DefaultTableModel(){
                     //Hace que las celdas sean no editables
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
                for (int i = 0; i < disponibles.size(); i++) {
                    this.tProductosDisponibles.setValueAt(disponibles.get(i).getNombre(), i, 0);
                    this.tProductosDisponibles.setValueAt(disponibles.get(i).getCantidad(), i, 1);
                    this.tProductosDisponibles.setValueAt(disponibles.get(i).getImagen(), i, 2);
                }
                cl.next(this.cuerpo);
                break;
            case 3:
                String subtitulo = this.lSubtitulo.getText();
                String pregunta = "¿Confirma que desea añadir el siguiente Elemento?";
                String texto = "<font face=\"Arial\">Nombre: <strong>" + this.tNombre.getText() + "</strong><br />"
                        + "<font face=\"Arial\">Descripción: <strong>" + this.tDescripcion.getText() + "</strong><br />"
                        + "<font face=\"Arial\">Precio: <strong>" + ((Float) this.tPrecio.getValue()) + "</strong> €<br />"
                        + "<font face=\"Arial\">Porciones: <strong>" + ((Integer) this.tPorciones.getValue()) + "</strong><br />"
                        + "<font face=\"Arial\">Tiempo de elaboración: <strong>" + ((Integer) this.tTiempo.getValue()) + "</strong><br />";
                texto += "<font face=\"Arial\">Está compuesto por los ingredientes: " + "<br /><br />";
                for (int i = 0; i < seleccionados.size(); i++) {
                    Producto producto = (Producto) seleccionados.get(i);
                    texto += "<font face=\"Arial\">&nbsp;- Nombre: <strong>" + producto.getNombre() + "</strong>, Cantidad: <strong>" + (Float) this.tProductosAsociados.getModel().getValueAt(i, 2) + "</strong>";
                    if (producto instanceof Ingrediente)
                        texto += " gr.<br />";
                    else
                        texto += " l.<br />";
                }

                DialogoConfirmacion confirmar = new DialogoConfirmacion(null, subtitulo, pregunta, texto);
                confirmar.setLocationRelativeTo(this);
                confirmar.setVisible(true);
                File f = new File(this.TImgen.getText());
                ImageIcon imagen;
                if(f.exists()){
                    imagen = new ImageIcon(f.getPath());
                }else{
                    imagen = null;
                }
                if (confirmar.isAceptado()) {
                    //listaSecciones = new ArrayList<Seccion>(this.icocinero.obtieneSecciones());
                    Seccion seccion = listaSecciones.get(this.bSeccion.getSelectedIndex());
                    if (seccion instanceof SeccionComida) {
                        HashMap<Ingrediente, Float> listaIngredientes = new HashMap<Ingrediente, Float>();
                        for(int i = 0;i < this.seleccionados.size();i++){
                            listaIngredientes.put( (Ingrediente) this.seleccionados.get(i), (Float) this.tProductosAsociados.getModel().getValueAt(i, 2));
                        }
                        ElementoPlato plato = new ElementoPlato(0, listaIngredientes, this.tNombre.getText(), this.tDescripcion.getText()
                                , false, imagen,(Integer) this.tTiempo.getValue(),(Float) this.tPrecio.getValue(),(Integer)this.tPorciones.getValue());
                        this.icocinero.nuevoElemento(plato, seccion);
                    } else {
                        HashMap<Bebida, Float> listaBebidas = new HashMap<Bebida, Float>();
                        for(int i = 0;i < this.seleccionados.size();i++){
                            listaBebidas.put( (Bebida) this.seleccionados.get(i), (Float) this.tProductosAsociados.getModel().getValueAt(i, 2));
                        }
                        ElementoBebida bebida = new ElementoBebida(0, listaBebidas, this.tNombre.getText(), this.tDescripcion.getText()
                                , false, imagen,(Float) this.tPrecio.getValue(),(Integer)this.tPorciones.getValue());
                        this.icocinero.nuevoElemento(bebida, seccion);
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
                this.bSiguiente.setEnabled(true);
                break;
            case 3:
                this.lSubtitulo.setText(SUBTITULOPASO2);
                this.lPaso.setText(PASO2);
                this.bSiguiente.setText("Siguiente");
                this.estado--;
                this.validarFormulario(null);
                cl.previous(this.cuerpo);
                break;
        }
    }//GEN-LAST:event_anterior

    private void examinar(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_examinar
        if (this.dSelector.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            this.TImgen.setText(this.dSelector.getSelectedFile().getAbsolutePath());
        }
    }//GEN-LAST:event_examinar

    private void Salir(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Salir
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_Salir

    private void validarFormulario(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_validarFormulario
        if (this.tNombre.getText().length() != 0 && this.tDescripcion.getText().length() != 0
                && ((Float) this.tPrecio.getValue()) != 0) {
            this.bSiguiente.setEnabled(true);
        } else {
            this.bSiguiente.setEnabled(false);
        }
    }//GEN-LAST:event_validarFormulario

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
            obj[2] = new Float(0.0);
            ((DefaultTableModel) this.tProductosAsociados.getModel()).addRow(obj);
        }
    }//GEN-LAST:event_seleccionaProducto

    private void seleccionarSeccion(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seleccionarSeccion
        if (this.bSeccion.getSelectedIndex() != -1) {
            //ArrayList<Seccion> lSeccionesLocal = new ArrayList<Seccion>(this.icocinero.obtieneSecciones());

            Seccion seccion = listaSecciones.get(this.bSeccion.getSelectedIndex());
            ArrayList<Elemento> lista;
            if (seccion instanceof SeccionBebida)
                lista = new ArrayList<Elemento>(((SeccionBebida)seccion).getListaElementoBebida());
            else
                lista = new ArrayList<Elemento>(((SeccionComida)seccion).getListaElementoPlato());
            DefaultTableModel modelo = new DefaultTableModel(){
                //Hace que las celdas sean no editables
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
            this.bSiguiente.setEnabled(true);
        }
    }//GEN-LAST:event_seleccionarSeccion

    private void BorrarAsociados(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BorrarAsociados
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
    }//GEN-LAST:event_BorrarAsociados

    private void TImgenMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TImgenMouseClicked
        if (this.dSelector.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            this.TImgen.setText(this.dSelector.getSelectedFile().getAbsolutePath());
        }
    }//GEN-LAST:event_TImgenMouseClicked

    private void tPorcionesFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tPorcionesFocusGained
        this.tPorciones.selectAll();
    }//GEN-LAST:event_tPorcionesFocusGained

    private void tTiempoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tTiempoFocusGained
        this.tTiempo.selectAll();
    }//GEN-LAST:event_tTiempoFocusGained

    private void tPrecioFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tPrecioFocusGained
        this.tPrecio.selectAll();
    }//GEN-LAST:event_tPrecioFocusGained

    private void tDescripcionFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tDescripcionFocusGained
        this.tDescripcion.selectAll();
    }//GEN-LAST:event_tDescripcionFocusGained

    private void tNombreFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tNombreFocusGained
        this.tNombre.selectAll();
    }//GEN-LAST:event_tNombreFocusGained

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
    private javax.swing.JPanel pAtributoPlato;
    private javax.swing.JPanel pAtributoPlato2;
    private javax.swing.JPanel pCentro1;
    private javax.swing.JPanel pCentro2;
    private javax.swing.JPanel pCentro3;
    private javax.swing.JPanel pCentroDer;
    private javax.swing.JPanel pCentroIzq;
    private javax.swing.JPanel pCentroSur;
    private javax.swing.JPanel pDer;
    private javax.swing.JPanel pImagen;
    private javax.swing.JPanel pIzq;
    private javax.swing.JPanel pMargenDer1;
    private javax.swing.JPanel pMargenDer2;
    private javax.swing.JPanel pMargenDer3;
    private javax.swing.JPanel pMargenIzq;
    private javax.swing.JPanel pMargenIzq1;
    private javax.swing.JPanel pMargenIzq2;
    private javax.swing.JPanel pMargenSup1;
    private javax.swing.JPanel pMargenSup2;
    private javax.swing.JPanel pMargenSup3;
    private javax.swing.JPanel pNorte1;
    private javax.swing.JPanel pPaso1;
    private javax.swing.JPanel pPaso2;
    private javax.swing.JPanel pPaso3;
    private javax.swing.JPanel pPrecio;
    private javax.swing.JPanel pProductosDisponibles;
    private javax.swing.JPanel pSur1;
    private javax.swing.JPanel pSur3;
    private javax.swing.JPanel pTiempo;
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
