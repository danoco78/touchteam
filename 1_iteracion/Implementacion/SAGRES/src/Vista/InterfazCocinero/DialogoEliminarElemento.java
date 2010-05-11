
package Vista.InterfazCocinero;

import ControladorPrincipal.ICocinero;
import GestionCarta.Elemento;
import GestionCarta.Seccion;
import GestionCarta.SeccionBebida;
import GestionCarta.SeccionComida;
import Vista.DialogoComfirmacion;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Daniel Guerrero Martinez
 */
public class DialogoEliminarElemento extends javax.swing.JDialog {

    //private ICarta gestorCarta;
    //private IPreparaCarta carta;
    private ICocinero icocinero;
    ArrayList<Seccion> listaSecciones;

    /** Creates new form DialogoAnadirElemento */
    public DialogoEliminarElemento(java.awt.Frame parent, /*ICarta GestorCarta, IPreparaCarta Carta*/ ICocinero iCocinero) {
        super(parent, true);
        initComponents();
        //this.gestorCarta = GestorCarta;
        //this.carta = Carta;
        this.icocinero = iCocinero;
        listaSecciones = new ArrayList<Seccion>(this.icocinero.obtieneSecciones());
        Collections.sort(listaSecciones);
        for (int i = 0; i < listaSecciones.size(); i++) {
            this.bSeccion.addItem(listaSecciones.get(i).getNombre());
        }
        this.bAceptar.setEnabled(false);
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

        pie = new javax.swing.JPanel();
        bAceptar = new javax.swing.JButton();
        bCancelar1 = new javax.swing.JButton();
        cabecera = new javax.swing.JPanel();
        lTitulo = new javax.swing.JLabel();
        lSubtitulo = new javax.swing.JLabel();
        cuerpo = new javax.swing.JPanel();
        lSeccion = new javax.swing.JLabel();
        bSeccion = new javax.swing.JComboBox();
        lTablaSeccion = new javax.swing.JLabel();
        scrollTabla = new javax.swing.JScrollPane();
        tProductoSeccion = new javax.swing.JTable();

        setMinimumSize(new java.awt.Dimension(200, 200));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });

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

        bCancelar1.setFont(new java.awt.Font("Arial", 0, 14));
        bCancelar1.setForeground(new java.awt.Color(80, 98, 143));
        bCancelar1.setText("Cancelar");
        bCancelar1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        bCancelar1.setMargin(new java.awt.Insets(20, 20, 20, 20));
        bCancelar1.setMinimumSize(new java.awt.Dimension(100, 50));
        bCancelar1.setPreferredSize(new java.awt.Dimension(125, 75));
        bCancelar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCancelar1Salir(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 25;
        gridBagConstraints.ipady = 25;
        gridBagConstraints.insets = new java.awt.Insets(9, 9, 9, 80);
        pie.add(bCancelar1, gridBagConstraints);

        getContentPane().add(pie, java.awt.BorderLayout.SOUTH);

        cabecera.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(150, 172, 229), 2));
        cabecera.setMinimumSize(new java.awt.Dimension(150, 100));
        cabecera.setOpaque(false);
        cabecera.setPreferredSize(new java.awt.Dimension(150, 100));
        cabecera.setLayout(new java.awt.GridBagLayout());

        lTitulo.setFont(new java.awt.Font("Arial", 1, 14));
        lTitulo.setForeground(new java.awt.Color(80, 98, 143));
        lTitulo.setText("Eliminar elemento de carta");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 255;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 6, 6, 6);
        cabecera.add(lTitulo, gridBagConstraints);

        lSubtitulo.setFont(new java.awt.Font("Arial", 0, 14));
        lSubtitulo.setForeground(new java.awt.Color(80, 98, 143));
        lSubtitulo.setText("Seleccionar elemento");
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

        getContentPane().add(cabecera, java.awt.BorderLayout.NORTH);

        cuerpo.setBackground(new java.awt.Color(255, 255, 255));
        cuerpo.setMinimumSize(new java.awt.Dimension(500, 550));
        cuerpo.setPreferredSize(new java.awt.Dimension(500, 550));
        cuerpo.setLayout(new java.awt.GridBagLayout());

        lSeccion.setFont(new java.awt.Font("Arial", 0, 14));
        lSeccion.setForeground(new java.awt.Color(80, 98, 143));
        lSeccion.setText("Elija una sección");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        cuerpo.add(lSeccion, gridBagConstraints);

        bSeccion.setFont(new java.awt.Font("Arial", 0, 14));
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
        cuerpo.add(bSeccion, gridBagConstraints);

        lTablaSeccion.setFont(new java.awt.Font("Arial", 0, 14));
        lTablaSeccion.setForeground(new java.awt.Color(80, 98, 143));
        lTablaSeccion.setText("Productos ya asociados a la sección");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(21, 10, 0, 10);
        cuerpo.add(lTablaSeccion, gridBagConstraints);

        scrollTabla.setOpaque(false);

        tProductoSeccion.setFont(new java.awt.Font("Arial", 0, 14));
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
        tProductoSeccion.getTableHeader().setReorderingAllowed(false);
        tProductoSeccion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                seleccionarProductos(evt);
            }
        });
        scrollTabla.setViewportView(tProductoSeccion);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 10, 10);
        cuerpo.add(scrollTabla, gridBagConstraints);

        getContentPane().add(cuerpo, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void closeDialog(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_closeDialog
        setVisible(false);
        dispose();
    }//GEN-LAST:event_closeDialog

    private void bCancelar1Salir(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCancelar1Salir
        this.setVisible(false);
        dispose();
}//GEN-LAST:event_bCancelar1Salir

    private void seleccionarProductos(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_seleccionarProductos
        if (this.tProductoSeccion.getSelectedRow() != -1) {
            this.bAceptar.setEnabled(true);
        } else {
            this.bAceptar.setEnabled(false);
        }
    }//GEN-LAST:event_seleccionarProductos

    private void Aceptar(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Aceptar
        ArrayList<Elemento> listaElementos;
        //ArrayList<Seccion> listaSecciones = new ArrayList<Seccion>(this.icocinero.obtieneSecciones());
        Seccion seccion = listaSecciones.get(this.bSeccion.getSelectedIndex());
        if (seccion instanceof SeccionBebida)
            listaElementos = new ArrayList<Elemento>(((SeccionBebida)seccion).getListaElementoBebida());
        else
            listaElementos = new ArrayList<Elemento>(((SeccionComida)seccion).getListaElementoPlato());

        Elemento aEliminar = listaElementos.get(
                this.tProductoSeccion.getSelectedRow() );
        String subtitulo = this.lSubtitulo.getText();
        String pregunta = "¿Confirma que desea eliminar el siguiente Elemento?";
        String texto = "Nombre: " + aEliminar.getNombre()
                + "\nDescripción: " + aEliminar.getDescripcion()
                + "\nPrecio: " + aEliminar.getPrecio()
                + "\nPorciones: " + aEliminar.getDivisionesMaximas();
        DialogoComfirmacion confirmar = new DialogoComfirmacion(null, subtitulo, pregunta, texto);
        confirmar.setLocationRelativeTo(this);
        confirmar.setVisible(true);
        if (confirmar.isAceptado()) {
            try {
                this.icocinero.eliminaElemento(aEliminar);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }
            setVisible(false);
            dispose();
        }
    }//GEN-LAST:event_Aceptar

    private void seleccionarSeccion(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seleccionarSeccion
        if (this.bSeccion.getSelectedIndex() != -1) {
            //ArrayList<Seccion> listaSecciones = new ArrayList<Seccion>(this.icocinero.obtieneSecciones());
            ArrayList<Elemento> lista;
            Seccion seccion = listaSecciones.get(this.bSeccion.getSelectedIndex());
            if (seccion instanceof SeccionBebida)
                lista = new ArrayList<Elemento>(((SeccionBebida)seccion).getListaElementoBebida());
            else
                lista = new ArrayList<Elemento>(((SeccionComida)seccion).getListaElementoPlato());
            DefaultTableModel modelo = new DefaultTableModel();
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
            this.bAceptar.setEnabled(true);
        }        // TODO add your handling code here:
    }//GEN-LAST:event_seleccionarSeccion

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bAceptar;
    private javax.swing.JButton bCancelar1;
    private javax.swing.JComboBox bSeccion;
    private javax.swing.JPanel cabecera;
    private javax.swing.JPanel cuerpo;
    private javax.swing.JLabel lSeccion;
    private javax.swing.JLabel lSubtitulo;
    private javax.swing.JLabel lTablaSeccion;
    private javax.swing.JLabel lTitulo;
    private javax.swing.JPanel pie;
    private javax.swing.JScrollPane scrollTabla;
    private javax.swing.JTable tProductoSeccion;
    // End of variables declaration//GEN-END:variables
}
