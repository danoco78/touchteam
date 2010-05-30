/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * menuEstadisticas.java
 *
 * Created on 30-may-2010, 10:29:00
 */

package Vista.InterfazCocinero;

/**
 *
 * @author nabil
 */
public class menuEstadisticas extends javax.swing.JPanel {

    /** Creates new form menuEstadisticas */
    public menuEstadisticas() {
        initComponents();
       
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

        menuEstaditicas = new javax.swing.JPanel();
        cabecera = new javax.swing.JPanel();
        contenedorDer = new javax.swing.JPanel();
        contenedorIzq = new javax.swing.JPanel();
        bVolver = new javax.swing.JButton();
        contenedorCentral = new javax.swing.JPanel();
        logo = new javax.swing.JLabel();
        cuerpo = new javax.swing.JPanel();
        bBalance = new javax.swing.JButton();
        bPlatosMenosVendidos = new javax.swing.JButton();
        bPlatosMasVendidos = new javax.swing.JButton();
        bPlatosNoServidos = new javax.swing.JButton();

        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setName("menuEstadisticas"); // NOI18N

        menuEstaditicas.setBackground(new java.awt.Color(255, 255, 255));
        menuEstaditicas.setOpaque(false);
        menuEstaditicas.setLayout(new java.awt.BorderLayout());

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

        bVolver.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        bVolver.setForeground(new java.awt.Color(80, 98, 143));
        bVolver.setText("Volver");
        bVolver.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        bVolver.setPreferredSize(new java.awt.Dimension(100, 50));
        contenedorIzq.add(bVolver, new java.awt.GridBagConstraints());

        cabecera.add(contenedorIzq, java.awt.BorderLayout.WEST);

        contenedorCentral.setOpaque(false);
        contenedorCentral.setLayout(new java.awt.GridBagLayout());

        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/InterfazCocinero/imagenes/LogoSagres.png"))); // NOI18N
        logo.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/InterfazCocinero/imagenes/LogoSagres.png"))); // NOI18N
        contenedorCentral.add(logo, new java.awt.GridBagConstraints());

        cabecera.add(contenedorCentral, java.awt.BorderLayout.CENTER);

        menuEstaditicas.add(cabecera, java.awt.BorderLayout.PAGE_START);

        cuerpo.setMinimumSize(new java.awt.Dimension(800, 600));
        cuerpo.setOpaque(false);
        cuerpo.setLayout(new java.awt.GridBagLayout());

        bBalance.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        bBalance.setForeground(new java.awt.Color(80, 98, 143));
        bBalance.setText("Balance Económico");
        bBalance.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        bBalance.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bBalance.setMaximumSize(new java.awt.Dimension(300, 200));
        bBalance.setMinimumSize(new java.awt.Dimension(300, 200));
        bBalance.setPreferredSize(new java.awt.Dimension(300, 200));
        bBalance.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        bBalance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bBalanceActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(15, 15, 15, 15);
        cuerpo.add(bBalance, gridBagConstraints);
        bBalance.getAccessibleContext().setAccessibleName("Balance");

        bPlatosMenosVendidos.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        bPlatosMenosVendidos.setForeground(new java.awt.Color(80, 98, 143));
        bPlatosMenosVendidos.setText("Platos menos vendidos");
        bPlatosMenosVendidos.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        bPlatosMenosVendidos.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bPlatosMenosVendidos.setMaximumSize(new java.awt.Dimension(300, 200));
        bPlatosMenosVendidos.setMinimumSize(new java.awt.Dimension(300, 200));
        bPlatosMenosVendidos.setPreferredSize(new java.awt.Dimension(300, 200));
        bPlatosMenosVendidos.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.insets = new java.awt.Insets(15, 15, 15, 15);
        cuerpo.add(bPlatosMenosVendidos, gridBagConstraints);

        bPlatosMasVendidos.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        bPlatosMasVendidos.setForeground(new java.awt.Color(80, 98, 143));
        bPlatosMasVendidos.setText("Platos más vendidos");
        bPlatosMasVendidos.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        bPlatosMasVendidos.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bPlatosMasVendidos.setMaximumSize(new java.awt.Dimension(300, 200));
        bPlatosMasVendidos.setMinimumSize(new java.awt.Dimension(300, 200));
        bPlatosMasVendidos.setPreferredSize(new java.awt.Dimension(300, 200));
        bPlatosMasVendidos.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(15, 15, 15, 15);
        cuerpo.add(bPlatosMasVendidos, gridBagConstraints);

        bPlatosNoServidos.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        bPlatosNoServidos.setForeground(new java.awt.Color(80, 98, 143));
        bPlatosNoServidos.setText("<html>\n<body>\nPlatos no servidos por<br>\nfalta de ingredientes\n</body>\n</html>");
        bPlatosNoServidos.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        bPlatosNoServidos.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bPlatosNoServidos.setMaximumSize(new java.awt.Dimension(300, 200));
        bPlatosNoServidos.setMinimumSize(new java.awt.Dimension(300, 200));
        bPlatosNoServidos.setPreferredSize(new java.awt.Dimension(300, 200));
        bPlatosNoServidos.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(15, 15, 15, 15);
        cuerpo.add(bPlatosNoServidos, gridBagConstraints);

        menuEstaditicas.add(cuerpo, java.awt.BorderLayout.CENTER);

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(menuEstaditicas, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 1083, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(menuEstaditicas, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 650, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void bBalanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bBalanceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bBalanceActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    protected javax.swing.JButton bBalance;
    protected javax.swing.JButton bPlatosMasVendidos;
    protected javax.swing.JButton bPlatosMenosVendidos;
    protected javax.swing.JButton bPlatosNoServidos;
    protected javax.swing.JButton bVolver;
    private javax.swing.JPanel cabecera;
    private javax.swing.JPanel contenedorCentral;
    private javax.swing.JPanel contenedorDer;
    private javax.swing.JPanel contenedorIzq;
    private javax.swing.JPanel cuerpo;
    private javax.swing.JLabel logo;
    private javax.swing.JPanel menuEstaditicas;
    // End of variables declaration//GEN-END:variables

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                javax.swing.JFrame vent = new javax.swing.JFrame();
                vent.getContentPane().add(new menuEstadisticas(), java.awt.BorderLayout.CENTER);
                vent.setVisible(true);
                vent.setSize(1024,800);
            }
        });
    }
}
