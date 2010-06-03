
package Vista.InterfazCocinero;

import ControladorPrincipal.ICocinero;
import GestionCarta.Elemento;
import GestionStock.GestionProductos.Ingrediente;
import GestionStock.GestionProductos.Producto;
import Vista.DialogoConfirmacion;
import java.util.HashSet;
import java.util.Iterator;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Daniel Guerrero Martinez
 */
public class DialogoEliminarIngrediente extends java.awt.Dialog {


    private ImageIcon imagen;
    /*private IProducto almacenProductos;
    private IGestionarProducto gestorProductos;*/
    private ICocinero cocina;
    private HashSet<Producto> listaIngredientes;
    private Ingrediente aEliminar;

    /** Creates new form DialogoAnadirElemento */
    public DialogoEliminarIngrediente(java.awt.Frame parent, /*IProducto AlmacenProductos, IGestionarProducto GestorProductos*/ ICocinero iCocinero) {
        super(parent, true);
        initComponents();
        //this.gestorProductos = GestorProductos;
        //this.almacenProductos = AlmacenProductos;
        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.addColumn(this.tTablaDeshabilitados.getColumnName(0));
        tableModel.addColumn(this.tTablaDeshabilitados.getColumnName(1));
        tableModel.setRowCount(0);
        this.tTablaDeshabilitados.setModel(tableModel);
        this.cocina = iCocinero;
        listaIngredientes = this.cocina.obtieneIngredientes();
        this.bAceptar.setEnabled(false);
        DefaultTableModel modelo = new DefaultTableModel() {
                @Override
                public boolean isCellEditable(int x, int y) {
                    return false;
                }
            };
        modelo.addColumn(this.tTablaIngredientes.getColumnName(0));
        modelo.addColumn(this.tTablaIngredientes.getColumnName(1));
        modelo.setRowCount(listaIngredientes.size());
        this.tTablaIngredientes.setModel(modelo);
        Iterator iterador = listaIngredientes.iterator();
        Producto p;
        int i = 0;
	while (iterador.hasNext()) {
            p = (Producto)iterador.next();
            this.tTablaIngredientes.setValueAt(p.getNombre(), i, 0);
            this.tTablaIngredientes.setValueAt(p.getCantidad(), i, 1);
            ++i;
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
        pCentro = new javax.swing.JPanel();
        pProductosDisponibles = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tTablaIngredientes = new javax.swing.JTable();
        pAtributoPlato2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tTablaDeshabilitados = new javax.swing.JTable();
        pMargenIzq = new javax.swing.JPanel();
        pMargenSup = new javax.swing.JPanel();
        pMargenDer = new javax.swing.JPanel();

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
        lTitulo.setText("Eliminar Ingrediente");
        cabecera.add(lTitulo);

        lSubtitulo.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lSubtitulo.setForeground(new java.awt.Color(80, 98, 143));
        lSubtitulo.setText("Seleccionar el ingrediente a eliminar");
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
        cuerpo.setLayout(new java.awt.BorderLayout());

        pCentro.setOpaque(false);
        pCentro.setLayout(new java.awt.GridLayout(0, 1, 0, 20));

        pProductosDisponibles.setBackground(new java.awt.Color(255, 255, 255));
        pProductosDisponibles.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(211, 223, 253)), "Ingredienete a eliminar", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 18), new java.awt.Color(150, 172, 229))); // NOI18N
        pProductosDisponibles.setForeground(new java.awt.Color(80, 98, 143));
        pProductosDisponibles.setMinimumSize(new java.awt.Dimension(450, 250));
        pProductosDisponibles.setOpaque(false);
        pProductosDisponibles.setPreferredSize(new java.awt.Dimension(450, 250));
        pProductosDisponibles.setLayout(new java.awt.BorderLayout());

        jScrollPane2.setOpaque(false);
        jScrollPane2.setPreferredSize(new java.awt.Dimension(200, 200));

        tTablaIngredientes.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
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

        pCentro.add(pProductosDisponibles);
        pProductosDisponibles.getAccessibleContext().setAccessibleName("Ingrediente a eliminar");

        pAtributoPlato2.setBackground(new java.awt.Color(255, 255, 255));
        pAtributoPlato2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(211, 223, 253)), "Se deshabilitarán los siguientes elementos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 18), new java.awt.Color(150, 172, 229))); // NOI18N
        pAtributoPlato2.setForeground(new java.awt.Color(80, 98, 143));
        pAtributoPlato2.setMinimumSize(new java.awt.Dimension(450, 250));
        pAtributoPlato2.setOpaque(false);
        pAtributoPlato2.setPreferredSize(new java.awt.Dimension(450, 250));
        pAtributoPlato2.setLayout(new java.awt.BorderLayout());

        jScrollPane3.setOpaque(false);

        tTablaDeshabilitados.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
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
        tTablaDeshabilitados.setFocusable(false);
        tTablaDeshabilitados.setGridColor(new java.awt.Color(211, 223, 253));
        tTablaDeshabilitados.setMinimumSize(new java.awt.Dimension(450, 250));
        tTablaDeshabilitados.setPreferredSize(new java.awt.Dimension(450, 250));
        tTablaDeshabilitados.getTableHeader().setResizingAllowed(false);
        tTablaDeshabilitados.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(tTablaDeshabilitados);

        pAtributoPlato2.add(jScrollPane3, java.awt.BorderLayout.CENTER);

        pCentro.add(pAtributoPlato2);

        cuerpo.add(pCentro, java.awt.BorderLayout.CENTER);

        pMargenIzq.setOpaque(false);
        cuerpo.add(pMargenIzq, java.awt.BorderLayout.WEST);

        pMargenSup.setOpaque(false);
        cuerpo.add(pMargenSup, java.awt.BorderLayout.NORTH);

        pMargenDer.setOpaque(false);
        cuerpo.add(pMargenDer, java.awt.BorderLayout.EAST);

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
        String pregunta = "¿Confirma que desea Eliminar el siguiente ingrediente?";
        int select = this.tTablaIngredientes.getSelectedRow();
        String texto = "Nombre: "+(String)this.tTablaIngredientes.getValueAt(select, 0)+
                "\nCantidad Disponible: "+((Float)this.tTablaIngredientes.getValueAt(select, 1))+" gr.";
        DialogoConfirmacion confirmar = new DialogoConfirmacion(null, subtitulo, pregunta, texto);
        confirmar.setLocationRelativeTo(this);
        confirmar.setVisible(true);
        if(confirmar.isAceptado()){
            try {
                this.cocina.eliminaProducto(aEliminar);
            } catch (Exception ex) {
            }
            setVisible(false);
            dispose();
        }
    }//GEN-LAST:event_Aceptar

    private void seleccionarIngrediente(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_seleccionarIngrediente
        int select = this.tTablaIngredientes.getSelectedRow();
        Iterator iterador = listaIngredientes.iterator();
        int i = 0;
        boolean noeliminado = true;
        this.tTablaDeshabilitados.removeAll();
        while (noeliminado) {
            aEliminar = (Ingrediente)iterador.next();
            if(i == select) noeliminado = false;
            else ++i;
        }
        HashSet<Elemento> listaElementos = this.cocina.obtieneElementosConProducto(aEliminar);
        Iterator iterador2 = listaElementos.iterator();
        Elemento e;
        int j=0;
        DefaultTableModel tableModel = new DefaultTableModel() {
                @Override
                public boolean isCellEditable(int x, int y) {
                    return false;
                }
            };
        tableModel.addColumn(this.tTablaDeshabilitados.getColumnName(0));
        tableModel.addColumn(this.tTablaDeshabilitados.getColumnName(1));
        tableModel.setRowCount(listaElementos.size());
        this.tTablaDeshabilitados.setModel(tableModel);
        while (iterador2.hasNext()){
            e = (Elemento)iterador2.next();
            this.tTablaDeshabilitados.getModel().setValueAt(e.getNombre(), j, 0);
            ++j;
        }
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
    private javax.swing.JPanel pCentro;
    private javax.swing.JPanel pMargenDer;
    private javax.swing.JPanel pMargenIzq;
    private javax.swing.JPanel pMargenSup;
    private javax.swing.JPanel pProductosDisponibles;
    private javax.swing.JPanel pie;
    private javax.swing.JTable tTablaDeshabilitados;
    private javax.swing.JTable tTablaIngredientes;
    // End of variables declaration//GEN-END:variables
    
}
