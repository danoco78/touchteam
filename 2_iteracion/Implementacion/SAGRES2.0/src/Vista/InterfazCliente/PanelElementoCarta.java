/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * PanelElementoCarta.java
 *
 * Created on 07-may-2010, 17:36:23
 */

package Vista.InterfazCliente;

import GestionCarta.Elemento;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.image.BufferedImage;
import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 *
 * @author Carlos
 */
public class PanelElementoCarta extends javax.swing.JPanel {
    private PanelGeneralCliente PGC;
    private Elemento elemento;
    private boolean seleccionado;
    
    /** Creates new form PanelElementoCarta */
    public PanelElementoCarta(Elemento elemento, PanelGeneralCliente PGC) {
        this.elemento=elemento;
        this.PGC=PGC;
        this.seleccionado=false;
        
        initComponents();

        this.LabelNombre.setText(elemento.getNombre());
        this.TextoDescripcion.setText(elemento.getDescripcion());
        this.LabelPrecio.setText(Double.toString(elemento.getPrecio())+"€");
        this.LabelFoto.setIcon(this.elemento.getFoto());
        
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelCentral = new javax.swing.JPanel();
        PanelDatos = new javax.swing.JPanel();
        LabelNombre = new javax.swing.JLabel();
        PanelDescripcion = new javax.swing.JPanel();
        ScrollDescripcion = new javax.swing.JScrollPane();
        TextoDescripcion = new javax.swing.JTextPane();
        PanelPrecio = new javax.swing.JPanel();
        LabelPrecio = new javax.swing.JLabel();
        PanelFoto = new javax.swing.JPanel();
        LabelFoto = new javax.swing.JLabel();
        PanelMargenArriba = new javax.swing.JPanel();
        PanelMargenAbajo = new javax.swing.JPanel();
        PanelMargenIzquierda = new javax.swing.JPanel();
        PanelMargenDerecha = new javax.swing.JPanel();

        setBackground(new java.awt.Color(255, 255, 255));
        setOpaque(false);
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                seleccionarElemento(evt);
            }
        });
        setLayout(new java.awt.BorderLayout());

        PanelCentral.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(150, 172, 229), 3));
        PanelCentral.setOpaque(false);
        PanelCentral.setLayout(new java.awt.BorderLayout());

        PanelDatos.setBackground(new java.awt.Color(255, 255, 255));
        PanelDatos.setLayout(new java.awt.BorderLayout());

        LabelNombre.setBackground(new java.awt.Color(255, 255, 255));
        LabelNombre.setFont(new java.awt.Font("Arial", 1, 16));
        LabelNombre.setText("jLabel1");
        PanelDatos.add(LabelNombre, java.awt.BorderLayout.NORTH);

        PanelDescripcion.setLayout(new java.awt.BorderLayout());

        ScrollDescripcion.setBorder(null);

        TextoDescripcion.setBorder(null);
        TextoDescripcion.setEditable(false);
        TextoDescripcion.setMaximumSize(new java.awt.Dimension(10, 10));
        TextoDescripcion.setMinimumSize(new java.awt.Dimension(10, 10));
        TextoDescripcion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                seleccionarElemento(evt);
            }
        });
        ScrollDescripcion.setViewportView(TextoDescripcion);

        PanelDescripcion.add(ScrollDescripcion, java.awt.BorderLayout.CENTER);

        PanelDatos.add(PanelDescripcion, java.awt.BorderLayout.CENTER);

        PanelPrecio.setBackground(new java.awt.Color(255, 255, 255));
        PanelPrecio.setOpaque(false);
        PanelPrecio.setLayout(new java.awt.BorderLayout());

        LabelPrecio.setText("jLabel1");
        PanelPrecio.add(LabelPrecio, java.awt.BorderLayout.EAST);

        PanelDatos.add(PanelPrecio, java.awt.BorderLayout.SOUTH);

        PanelCentral.add(PanelDatos, java.awt.BorderLayout.CENTER);

        PanelFoto.setLayout(new java.awt.BorderLayout());

        LabelFoto.setIcon((ImageIcon) this.elemento.getFoto());
        LabelFoto.setLabelFor(LabelFoto);
        LabelFoto.setBorder(new javax.swing.border.MatteBorder(null));
        LabelFoto.setOpaque(true);
        PanelFoto.add(LabelFoto, java.awt.BorderLayout.CENTER);

        PanelCentral.add(PanelFoto, java.awt.BorderLayout.EAST);

        add(PanelCentral, java.awt.BorderLayout.CENTER);

        PanelMargenArriba.setOpaque(false);
        PanelMargenArriba.setPreferredSize(new java.awt.Dimension(5, 5));
        PanelMargenArriba.setLayout(new java.awt.BorderLayout());
        add(PanelMargenArriba, java.awt.BorderLayout.NORTH);

        PanelMargenAbajo.setOpaque(false);
        PanelMargenAbajo.setPreferredSize(new java.awt.Dimension(5, 5));
        PanelMargenAbajo.setLayout(new java.awt.BorderLayout());
        add(PanelMargenAbajo, java.awt.BorderLayout.SOUTH);

        PanelMargenIzquierda.setBackground(new java.awt.Color(255, 255, 255));
        PanelMargenIzquierda.setOpaque(false);
        PanelMargenIzquierda.setPreferredSize(new java.awt.Dimension(5, 5));
        PanelMargenIzquierda.setLayout(new java.awt.BorderLayout());
        add(PanelMargenIzquierda, java.awt.BorderLayout.WEST);

        PanelMargenDerecha.setOpaque(false);
        PanelMargenDerecha.setPreferredSize(new java.awt.Dimension(5, 5));
        PanelMargenDerecha.setLayout(new java.awt.BorderLayout());
        add(PanelMargenDerecha, java.awt.BorderLayout.EAST);
    }// </editor-fold>//GEN-END:initComponents

    private void seleccionarElemento(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_seleccionarElemento
        if(PGC.pedidoRealizado){
            PGC.cambiarPanelEste();
            PGC.pedidoRealizado=false;
        }
        
        if(!this.seleccionado){
            PGC.marcarElemento(this);
        }else{
            PGC.desmarcarElemento();
            this.desmarcar();
        }
    }//GEN-LAST:event_seleccionarElemento


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LabelFoto;
    private javax.swing.JLabel LabelNombre;
    private javax.swing.JLabel LabelPrecio;
    private javax.swing.JPanel PanelCentral;
    private javax.swing.JPanel PanelDatos;
    private javax.swing.JPanel PanelDescripcion;
    private javax.swing.JPanel PanelFoto;
    private javax.swing.JPanel PanelMargenAbajo;
    private javax.swing.JPanel PanelMargenArriba;
    private javax.swing.JPanel PanelMargenDerecha;
    private javax.swing.JPanel PanelMargenIzquierda;
    private javax.swing.JPanel PanelPrecio;
    private javax.swing.JScrollPane ScrollDescripcion;
    private javax.swing.JTextPane TextoDescripcion;
    // End of variables declaration//GEN-END:variables

    public Elemento getElemento(){
        return this.elemento;
    }

    public void marcar(){
        this.seleccionado=true;
        this.PanelDatos.setBackground(new Color(153,204,255));
        this.TextoDescripcion.setBackground(new Color(153,204,255));
    }

    public void desmarcar(){
        this.seleccionado=false;
        this.PanelDatos.setBackground(new Color(255,255,255));
        this.TextoDescripcion.setBackground(new Color(255,255,255));
    }

    public Image iconToImage(Icon icon) {
          if (icon instanceof ImageIcon) {
              return ((ImageIcon)icon).getImage();
          } else {
              int w = icon.getIconWidth();
              int h = icon.getIconHeight();
              GraphicsEnvironment ge =
                GraphicsEnvironment.getLocalGraphicsEnvironment();
              GraphicsDevice gd = ge.getDefaultScreenDevice();
              GraphicsConfiguration gc = gd.getDefaultConfiguration();
              BufferedImage image = gc.createCompatibleImage(w, h);
              Graphics2D g = image.createGraphics();
              icon.paintIcon(null, g, 0, 0);
              g.dispose();
              return image;
          }
      }
}
