

package Vista.InterfazCocinero;

import ControladorPrincipal.ICocinero;
import GestionStock.GestionProductos.Ingrediente;
import Vista.DialogoConfirmacion;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Daniel Guerrero Martinez
 */
public class DialogoAnadirIngrediente extends javax.swing.JDialog {


    private ImageIcon imagen;
    //private IGestionarProducto gestorProducto;
    private ICocinero cocina;

    /** Creates new form DialogoAnadirElemento */
    public DialogoAnadirIngrediente(java.awt.Frame parent, /*IGestionarProducto GestorProducto*/ ICocinero iCocinero) {
        super(parent, true);
        initComponents();
        this.dSelector.setFileFilter( new FileNameExtensionFilter("IMAGEN", "jpg","jpeg","png","gif"));
        //gestorProducto = GestorProducto;
        imagen = null;
        this.cocina = iCocinero;
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
        cabecera = new utilidades.PanelCabeceras();
        lTitulo = new javax.swing.JLabel();
        lSubtitulo = new javax.swing.JLabel();
        pie = new javax.swing.JPanel();
        bAceptar = new javax.swing.JButton();
        bCancelar = new javax.swing.JButton();
        cuerpo = new javax.swing.JPanel();
        pCentro1 = new javax.swing.JPanel();
        pNombre = new javax.swing.JPanel();
        lNombre = new javax.swing.JLabel();
        tNombre = new javax.swing.JTextField();
        pCentro = new javax.swing.JPanel();
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
        pImagen2 = new javax.swing.JPanel();
        lMuestraImagen = new javax.swing.JLabel();
        pMargenIzq = new javax.swing.JPanel();
        pMargenIzq1 = new javax.swing.JPanel();
        pMargenIzq2 = new javax.swing.JPanel();

        dSelector.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

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
        lTitulo.setText("Añadir Ingrediente");
        cabecera.add(lTitulo);

        lSubtitulo.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lSubtitulo.setForeground(new java.awt.Color(80, 98, 143));
        lSubtitulo.setText("Introducir todo los datos necesarios");
        lSubtitulo.setPreferredSize(new java.awt.Dimension(175, 50));
        cabecera.add(lSubtitulo);

        getContentPane().add(cabecera, java.awt.BorderLayout.NORTH);

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

        getContentPane().add(pie, java.awt.BorderLayout.SOUTH);

        cuerpo.setBackground(new java.awt.Color(255, 255, 255));
        cuerpo.setForeground(new java.awt.Color(80, 98, 143));
        cuerpo.setMinimumSize(new java.awt.Dimension(500, 550));
        cuerpo.setPreferredSize(new java.awt.Dimension(500, 550));
        cuerpo.setLayout(new java.awt.BorderLayout(0, 5));

        pCentro1.setOpaque(false);
        pCentro1.setLayout(new java.awt.BorderLayout(0, 10));

        pNombre.setOpaque(false);
        pNombre.setLayout(new java.awt.BorderLayout(10, 0));

        lNombre.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lNombre.setForeground(new java.awt.Color(80, 98, 143));
        lNombre.setText("Nombre");
        pNombre.add(lNombre, java.awt.BorderLayout.WEST);

        tNombre.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        tNombre.setForeground(new java.awt.Color(80, 98, 143));
        tNombre.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(150, 172, 229), 3, true));
        tNombre.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                ValidarFormulario(evt);
            }
        });
        pNombre.add(tNombre, java.awt.BorderLayout.CENTER);

        pCentro1.add(pNombre, java.awt.BorderLayout.NORTH);

        pCentro.setOpaque(false);
        pCentro.setLayout(new java.awt.GridLayout(2, 1, 0, 10));

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
        tMaximo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tMaximo.setMinimumSize(new java.awt.Dimension(60, 10));
        tMaximo.setPreferredSize(new java.awt.Dimension(150, 10));
        tMaximo.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                ValidarFormulario(evt);
            }
        });
        pAtributoCantidad.add(tMaximo);

        lPorciones.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lPorciones.setForeground(new java.awt.Color(80, 98, 143));
        lPorciones.setText("gramos (gr)");
        pAtributoCantidad.add(lPorciones);

        lMinimo.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lMinimo.setForeground(new java.awt.Color(80, 98, 143));
        lMinimo.setText("Mínimo aceptable");
        pAtributoCantidad.add(lMinimo);

        tMinimo.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(150, 172, 229), 3, true));
        tMinimo.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        tMinimo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tMinimo.setMinimumSize(new java.awt.Dimension(60, 10));
        tMinimo.setPreferredSize(new java.awt.Dimension(150, 10));
        tMinimo.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                ValidarFormulario(evt);
            }
        });
        pAtributoCantidad.add(tMinimo);

        lPorciones1.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lPorciones1.setForeground(new java.awt.Color(80, 98, 143));
        lPorciones1.setText("gramos (gr)");
        pAtributoCantidad.add(lPorciones1);

        lMaximo2.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lMaximo2.setForeground(new java.awt.Color(80, 98, 143));
        lMaximo2.setText("<html><body>Disponible<br>actualmente</body></html>");
        pAtributoCantidad.add(lMaximo2);

        tDisponible.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(150, 172, 229), 3, true));
        tDisponible.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        tDisponible.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tDisponible.setMinimumSize(new java.awt.Dimension(60, 10));
        tDisponible.setPreferredSize(new java.awt.Dimension(150, 10));
        tDisponible.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                ValidarFormulario(evt);
            }
        });
        pAtributoCantidad.add(tDisponible);

        lPorciones2.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lPorciones2.setForeground(new java.awt.Color(80, 98, 143));
        lPorciones2.setText("gramos (gr)");
        pAtributoCantidad.add(lPorciones2);

        pCentro.add(pAtributoCantidad);

        pImagen.setOpaque(false);
        pImagen.setLayout(new java.awt.BorderLayout());

        lImagen.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lImagen.setForeground(new java.awt.Color(80, 98, 143));
        lImagen.setText("Imagen");
        pImagen.add(lImagen, java.awt.BorderLayout.NORTH);

        pImagen2.setOpaque(false);
        pImagen2.setLayout(new java.awt.GridBagLayout());

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
                Seleccionar(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.insets = new java.awt.Insets(7, 7, 7, 7);
        pImagen2.add(lMuestraImagen, gridBagConstraints);

        pImagen.add(pImagen2, java.awt.BorderLayout.CENTER);

        pCentro.add(pImagen);

        pCentro1.add(pCentro, java.awt.BorderLayout.CENTER);

        cuerpo.add(pCentro1, java.awt.BorderLayout.CENTER);

        pMargenIzq.setOpaque(false);
        cuerpo.add(pMargenIzq, java.awt.BorderLayout.WEST);

        pMargenIzq1.setOpaque(false);
        cuerpo.add(pMargenIzq1, java.awt.BorderLayout.EAST);

        pMargenIzq2.setOpaque(false);
        cuerpo.add(pMargenIzq2, java.awt.BorderLayout.NORTH);

        getContentPane().add(cuerpo, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void closeDialog(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_closeDialog
        setVisible(false);
        dispose();
    }//GEN-LAST:event_closeDialog

    private void Salir(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Salir
        setVisible(false);
        dispose();
    }//GEN-LAST:event_Salir

    private void Seleccionar(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Seleccionar
        if(this.dSelector.showOpenDialog(this) == JFileChooser.APPROVE_OPTION){
            ImageIcon aux = new ImageIcon( this.dSelector.getSelectedFile().getPath() );
            imagen = new ImageIcon();
            imagen.setImage(new BufferedImage(200, 200, BufferedImage.TYPE_INT_RGB));
            imagen.getImage().getGraphics().drawImage(aux.getImage(), 0, 0, 200, 200, null);
            this.lMuestraImagen.setText("");
            this.lMuestraImagen.setIcon(imagen);
        }
    }//GEN-LAST:event_Seleccionar

    private void Aceptar(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Aceptar
        String subtitulo = this.lSubtitulo.getText();
        String pregunta = "¿Confirma que desea añadir el siguiente ingrediente?";
        String texto = "Nombre: "+this.tNombre.getText()+"\n"+
                "Cantidad Disponible: "+((Float)this.tDisponible.getValue())+" gr.\n"+
                "Cantidad Máxima: "+((Float)this.tMaximo.getValue())+" gr.\n"+
                "Cantidad Mínima: "+((Float)this.tMinimo.getValue())+" gr.\n";
        DialogoConfirmacion confirmar = new DialogoConfirmacion(null, subtitulo, pregunta, texto);
        confirmar.setLocationRelativeTo(this);
        confirmar.setVisible(true);
        if(confirmar.isAceptado()){
            Ingrediente i = new Ingrediente(0, this.tNombre.getText(),((Float)this.tDisponible.getValue()), ((Float)this.tMaximo.getValue()), ((Float)this.tMinimo.getValue()), imagen);
            this.cocina.nuevoProducto(i);
            setVisible(false);
            dispose();
        }
    }//GEN-LAST:event_Aceptar

    private void ValidarFormulario(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_ValidarFormulario
        if( this.tNombre.getText().length() != 0 &&
          ((Float)this.tMaximo.getValue()) > 0 &&
          ((Float)this.tMinimo.getValue()) > 0 &&
          ((Float)this.tMaximo.getValue()) >= ((Float)this.tMinimo.getValue()) &&
          ((Float)this.tDisponible.getValue()) >= 0 &&
          ((Float)this.tDisponible.getValue()) <= ((Float)this.tMaximo.getValue()))
        {
            this.bAceptar.setEnabled(true);
        }else{
            this.bAceptar.setEnabled(false);
        }
    }//GEN-LAST:event_ValidarFormulario



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bAceptar;
    private javax.swing.JButton bCancelar;
    private javax.swing.JPanel cabecera;
    private javax.swing.JPanel cuerpo;
    private javax.swing.JFileChooser dSelector;
    private javax.swing.JLabel lImagen;
    private javax.swing.JLabel lMaximo;
    private javax.swing.JLabel lMaximo2;
    private javax.swing.JLabel lMinimo;
    private javax.swing.JLabel lMuestraImagen;
    private javax.swing.JLabel lNombre;
    private javax.swing.JLabel lPorciones;
    private javax.swing.JLabel lPorciones1;
    private javax.swing.JLabel lPorciones2;
    private javax.swing.JLabel lSubtitulo;
    private javax.swing.JLabel lTitulo;
    private javax.swing.JPanel pAtributoCantidad;
    private javax.swing.JPanel pCentro;
    private javax.swing.JPanel pCentro1;
    private javax.swing.JPanel pImagen;
    private javax.swing.JPanel pImagen2;
    private javax.swing.JPanel pMargenIzq;
    private javax.swing.JPanel pMargenIzq1;
    private javax.swing.JPanel pMargenIzq2;
    private javax.swing.JPanel pNombre;
    private javax.swing.JPanel pie;
    private javax.swing.JFormattedTextField tDisponible;
    private javax.swing.JFormattedTextField tMaximo;
    private javax.swing.JFormattedTextField tMinimo;
    private javax.swing.JTextField tNombre;
    // End of variables declaration//GEN-END:variables
    
}