
package Vista.InterfazMetre;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

/**
 *
 * @author Daniel Guerrero Martinez
 */
public class IntGestionBebidas extends javax.swing.JPanel {

    /** Creates new form IntGestionCarta */
    public IntGestionBebidas() {
        initComponents();
    }

    @Override
    public void paint(Graphics g) {
        super.paintComponents(g);
        Graphics2D g2 = (Graphics2D) g.create();
        Rectangle clip = g2.getClipBounds();
        g2.setPaint(new GradientPaint(0.0f, 0.0f, new Color(170, 192, 249) ,getWidth() ,getHeight(), new Color(255, 255, 255) ));
        g2.fillRect(clip.x, clip.y, clip.width, clip.height);
        super.paint(g);
    }



    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        cabecera = new javax.swing.JPanel();
        contenedorDer = new javax.swing.JPanel();
        contenedorIzq = new javax.swing.JPanel();
        bSalir = new javax.swing.JButton();
        contenedorCentral = new javax.swing.JPanel();
        logo = new javax.swing.JLabel();
        cuerpo = new javax.swing.JPanel();
        bAnadirBebida = new javax.swing.JButton();
        bNotificcarIncidencia = new javax.swing.JButton();
        bEliminarBebida = new javax.swing.JButton();
        bModificarBebida = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setOpaque(false);
        setLayout(new java.awt.BorderLayout());

        cabecera.setMinimumSize(new java.awt.Dimension(50, 50));
        cabecera.setOpaque(false);
        cabecera.setLayout(new java.awt.BorderLayout());

        contenedorDer.setOpaque(false);
        contenedorDer.setPreferredSize(new java.awt.Dimension(200, 100));
        contenedorDer.setLayout(new java.awt.GridBagLayout());
        cabecera.add(contenedorDer, java.awt.BorderLayout.EAST);

        contenedorIzq.setOpaque(false);
        contenedorIzq.setPreferredSize(new java.awt.Dimension(200, 100));
        contenedorIzq.setLayout(new java.awt.GridBagLayout());

        bSalir.setFont(new java.awt.Font("Arial", 1, 14));
        bSalir.setForeground(new java.awt.Color(80, 98, 143));
        bSalir.setText("Salir");
        bSalir.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        bSalir.setPreferredSize(new java.awt.Dimension(100, 50));
        contenedorIzq.add(bSalir, new java.awt.GridBagConstraints());

        cabecera.add(contenedorIzq, java.awt.BorderLayout.WEST);

        contenedorCentral.setOpaque(false);
        contenedorCentral.setLayout(new java.awt.GridBagLayout());

        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/InterfazMetre/imagenes/LogoSagres.png"))); // NOI18N
        contenedorCentral.add(logo, new java.awt.GridBagConstraints());

        cabecera.add(contenedorCentral, java.awt.BorderLayout.CENTER);

        add(cabecera, java.awt.BorderLayout.PAGE_START);

        cuerpo.setMinimumSize(new java.awt.Dimension(800, 600));
        cuerpo.setOpaque(false);
        cuerpo.setLayout(new java.awt.GridBagLayout());

        bAnadirBebida.setFont(new java.awt.Font("Arial", 1, 14));
        bAnadirBebida.setForeground(new java.awt.Color(80, 98, 143));
        bAnadirBebida.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/InterfazMetre/imagenes/copa.png"))); // NOI18N
        bAnadirBebida.setText("Añadir Bebida");
        bAnadirBebida.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        bAnadirBebida.setMaximumSize(new java.awt.Dimension(300, 200));
        bAnadirBebida.setMinimumSize(new java.awt.Dimension(300, 200));
        bAnadirBebida.setPreferredSize(new java.awt.Dimension(300, 200));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(15, 15, 15, 15);
        cuerpo.add(bAnadirBebida, gridBagConstraints);

        bNotificcarIncidencia.setFont(new java.awt.Font("Arial", 1, 14));
        bNotificcarIncidencia.setForeground(new java.awt.Color(80, 98, 143));
        bNotificcarIncidencia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/InterfazMetre/imagenes/incidencia.png"))); // NOI18N
        bNotificcarIncidencia.setText("Notificar incidencia");
        bNotificcarIncidencia.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        bNotificcarIncidencia.setMaximumSize(new java.awt.Dimension(300, 200));
        bNotificcarIncidencia.setMinimumSize(new java.awt.Dimension(300, 200));
        bNotificcarIncidencia.setPreferredSize(new java.awt.Dimension(300, 200));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.insets = new java.awt.Insets(15, 15, 15, 15);
        cuerpo.add(bNotificcarIncidencia, gridBagConstraints);

        bEliminarBebida.setFont(new java.awt.Font("Arial", 1, 14));
        bEliminarBebida.setForeground(new java.awt.Color(80, 98, 143));
        bEliminarBebida.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/InterfazMetre/imagenes/PedirBebida.png"))); // NOI18N
        bEliminarBebida.setText("Eliminar Bebida");
        bEliminarBebida.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        bEliminarBebida.setMaximumSize(new java.awt.Dimension(300, 200));
        bEliminarBebida.setMinimumSize(new java.awt.Dimension(300, 200));
        bEliminarBebida.setPreferredSize(new java.awt.Dimension(300, 200));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(15, 15, 15, 15);
        cuerpo.add(bEliminarBebida, gridBagConstraints);

        bModificarBebida.setFont(new java.awt.Font("Arial", 1, 14));
        bModificarBebida.setForeground(new java.awt.Color(80, 98, 143));
        bModificarBebida.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/InterfazMetre/imagenes/ModificarBebida.png"))); // NOI18N
        bModificarBebida.setText("Modificar Bebida");
        bModificarBebida.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        bModificarBebida.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bModificarBebida.setMaximumSize(new java.awt.Dimension(300, 200));
        bModificarBebida.setMinimumSize(new java.awt.Dimension(300, 200));
        bModificarBebida.setPreferredSize(new java.awt.Dimension(300, 200));
        bModificarBebida.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(15, 15, 15, 15);
        cuerpo.add(bModificarBebida, gridBagConstraints);

        add(cuerpo, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    protected javax.swing.JButton bAnadirBebida;
    protected javax.swing.JButton bEliminarBebida;
    protected javax.swing.JButton bModificarBebida;
    protected javax.swing.JButton bNotificcarIncidencia;
    protected javax.swing.JButton bSalir;
    private javax.swing.JPanel cabecera;
    private javax.swing.JPanel contenedorCentral;
    private javax.swing.JPanel contenedorDer;
    private javax.swing.JPanel contenedorIzq;
    private javax.swing.JPanel cuerpo;
    private javax.swing.JLabel logo;
    // End of variables declaration//GEN-END:variables

}
