/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * platoMasvendido.java
 *
 * Created on 30-may-2010, 11:33:04
 */

package Vista.InterfazCocinero;

/**
 *
 * @author nabil
 */
public class platosNoServidos extends javax.swing.JPanel {

    /** Creates new form platoMasvendido */
    public platosNoServidos() {
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

        cuerpo = new javax.swing.JPanel();
        cabecera = new javax.swing.JPanel();
        panel_volver = new javax.swing.JPanel();
        bVolver = new javax.swing.JButton();
        logo = new javax.swing.JLabel();
        reloj = new javax.swing.JPanel();
        cuerpoFecha = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();

        cabecera.setPreferredSize(new java.awt.Dimension(200, 133));

        bVolver.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        bVolver.setForeground(new java.awt.Color(80, 98, 143));
        bVolver.setText("Volver");
        bVolver.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        bVolver.setPreferredSize(new java.awt.Dimension(100, 50));

        logo.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        logo.setForeground(new java.awt.Color(80, 98, 143));
        logo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/InterfazCocinero/imagenes/LogoSagres.png"))); // NOI18N
        logo.setText("<html>\n<body>\nPlatos no vendidos por \n<br>\nfalta de ingredientes\n</html>\n</body>");
        logo.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/InterfazCocinero/imagenes/LogoSagres.png"))); // NOI18N
        logo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        org.jdesktop.layout.GroupLayout panel_volverLayout = new org.jdesktop.layout.GroupLayout(panel_volver);
        panel_volver.setLayout(panel_volverLayout);
        panel_volverLayout.setHorizontalGroup(
            panel_volverLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, panel_volverLayout.createSequentialGroup()
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(bVolver, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 196, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(71, 71, 71)
                .add(logo, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 457, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panel_volverLayout.setVerticalGroup(
            panel_volverLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(panel_volverLayout.createSequentialGroup()
                .add(panel_volverLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(panel_volverLayout.createSequentialGroup()
                        .addContainerGap()
                        .add(bVolver, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE))
                    .add(panel_volverLayout.createSequentialGroup()
                        .add(21, 21, 21)
                        .add(logo, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 110, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        org.jdesktop.layout.GroupLayout relojLayout = new org.jdesktop.layout.GroupLayout(reloj);
        reloj.setLayout(relojLayout);
        relojLayout.setHorizontalGroup(
            relojLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 0, Short.MAX_VALUE)
        );
        relojLayout.setVerticalGroup(
            relojLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 149, Short.MAX_VALUE)
        );

        org.jdesktop.layout.GroupLayout cabeceraLayout = new org.jdesktop.layout.GroupLayout(cabecera);
        cabecera.setLayout(cabeceraLayout);
        cabeceraLayout.setHorizontalGroup(
            cabeceraLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(cabeceraLayout.createSequentialGroup()
                .addContainerGap()
                .add(panel_volver, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(1441, 1441, 1441)
                .add(reloj, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        cabeceraLayout.setVerticalGroup(
            cabeceraLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(cabeceraLayout.createSequentialGroup()
                .addContainerGap()
                .add(cabeceraLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, panel_volver, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(cabeceraLayout.createSequentialGroup()
                        .add(reloj, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );

        jLabel1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(80, 98, 143));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Fecha inicio:");

        jTextField1.setFont(new java.awt.Font("Arial", 0, 12));
        jTextField1.setForeground(new java.awt.Color(80, 98, 143));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(80, 98, 143));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Fecha fin:");

        jTextField2.setFont(new java.awt.Font("Arial", 0, 12));
        jTextField2.setForeground(new java.awt.Color(80, 98, 143));

        org.jdesktop.layout.GroupLayout cuerpoFechaLayout = new org.jdesktop.layout.GroupLayout(cuerpoFecha);
        cuerpoFecha.setLayout(cuerpoFechaLayout);
        cuerpoFechaLayout.setHorizontalGroup(
            cuerpoFechaLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(cuerpoFechaLayout.createSequentialGroup()
                .add(27, 27, 27)
                .add(jLabel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 154, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(35, 35, 35)
                .add(jTextField1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 164, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(18, 18, 18)
                .add(jLabel2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
                .add(37, 37, 37)
                .add(jTextField2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 162, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(63, 63, 63))
        );
        cuerpoFechaLayout.setVerticalGroup(
            cuerpoFechaLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(cuerpoFechaLayout.createSequentialGroup()
                .addContainerGap(38, Short.MAX_VALUE)
                .add(cuerpoFechaLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jTextField2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 60, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 63, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jTextField1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 60, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 54, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(31, 31, 31))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        org.jdesktop.layout.GroupLayout jPanel3Layout = new org.jdesktop.layout.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 711, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 312, Short.MAX_VALUE)
        );

        org.jdesktop.layout.GroupLayout cuerpoLayout = new org.jdesktop.layout.GroupLayout(cuerpo);
        cuerpo.setLayout(cuerpoLayout);
        cuerpoLayout.setHorizontalGroup(
            cuerpoLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(cuerpoLayout.createSequentialGroup()
                .addContainerGap()
                .add(cuerpoLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(cuerpoFecha, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(cabecera, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 734, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        cuerpoLayout.setVerticalGroup(
            cuerpoLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(cuerpoLayout.createSequentialGroup()
                .addContainerGap()
                .add(cabecera, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 171, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(27, 27, 27)
                .add(cuerpoFecha, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(18, 18, 18)
                .add(jPanel3, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 807, Short.MAX_VALUE)
            .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                .add(layout.createSequentialGroup()
                    .add(0, 0, Short.MAX_VALUE)
                    .add(cuerpo, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 685, Short.MAX_VALUE)
            .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                .add(layout.createSequentialGroup()
                    .add(0, 0, Short.MAX_VALUE)
                    .add(cuerpo, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    protected javax.swing.JButton bVolver;
    private javax.swing.JPanel cabecera;
    private javax.swing.JPanel cuerpo;
    private javax.swing.JPanel cuerpoFecha;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JLabel logo;
    private javax.swing.JPanel panel_volver;
    private javax.swing.JPanel reloj;
    // End of variables declaration//GEN-END:variables

}
