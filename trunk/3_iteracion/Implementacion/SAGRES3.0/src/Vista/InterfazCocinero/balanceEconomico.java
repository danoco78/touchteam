/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * balanceEconomico.java
 *
 * Created on 30-may-2010, 11:18:28
 */

package Vista.InterfazCocinero;

/**
 *
 * @author nabil
 */
public class balanceEconomico extends javax.swing.JPanel {

    /** Creates new form balanceEconomico */
    public balanceEconomico() {
        initComponents();
        this.setSize(800, 600);
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
        fechaI = new javax.swing.JLabel();
        fInicio = new javax.swing.JTextField();
        fechaF = new javax.swing.JLabel();
        fFin = new javax.swing.JTextField();
        Estadisticas = new javax.swing.JPanel();

        setLayout(new java.awt.BorderLayout());

        cabecera.setPreferredSize(new java.awt.Dimension(200, 133));

        bVolver.setFont(new java.awt.Font("Arial", 1, 14));
        bVolver.setForeground(new java.awt.Color(80, 98, 143));
        bVolver.setText("Volver");
        bVolver.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        bVolver.setPreferredSize(new java.awt.Dimension(100, 50));

        logo.setFont(new java.awt.Font("Arial", 1, 36));
        logo.setForeground(new java.awt.Color(80, 98, 143));
        logo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/InterfazCocinero/imagenes/LogoSagres.png"))); // NOI18N
        logo.setText("Balance Economico");
        logo.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/InterfazCocinero/imagenes/LogoSagres.png"))); // NOI18N
        logo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        org.jdesktop.layout.GroupLayout panel_volverLayout = new org.jdesktop.layout.GroupLayout(panel_volver);
        panel_volver.setLayout(panel_volverLayout);
        panel_volverLayout.setHorizontalGroup(
            panel_volverLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, panel_volverLayout.createSequentialGroup()
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(bVolver, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 196, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(113, 113, 113)
                .add(logo, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 389, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(22, 22, 22))
        );
        panel_volverLayout.setVerticalGroup(
            panel_volverLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(panel_volverLayout.createSequentialGroup()
                .addContainerGap()
                .add(panel_volverLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(panel_volverLayout.createSequentialGroup()
                        .add(bVolver, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
                        .addContainerGap())
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, panel_volverLayout.createSequentialGroup()
                        .add(logo)
                        .add(29, 29, 29))))
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

        fechaI.setFont(new java.awt.Font("Arial", 1, 24));
        fechaI.setForeground(new java.awt.Color(80, 98, 143));
        fechaI.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fechaI.setText("Fecha inicio:");

        fInicio.setFont(new java.awt.Font("Arial", 0, 12));
        fInicio.setForeground(new java.awt.Color(80, 98, 143));

        fechaF.setFont(new java.awt.Font("Arial", 1, 24));
        fechaF.setForeground(new java.awt.Color(80, 98, 143));
        fechaF.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fechaF.setText("Fecha fin:");

        fFin.setFont(new java.awt.Font("Arial", 0, 12));
        fFin.setForeground(new java.awt.Color(80, 98, 143));
        fFin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fFinActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout cuerpoFechaLayout = new org.jdesktop.layout.GroupLayout(cuerpoFecha);
        cuerpoFecha.setLayout(cuerpoFechaLayout);
        cuerpoFechaLayout.setHorizontalGroup(
            cuerpoFechaLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(cuerpoFechaLayout.createSequentialGroup()
                .add(27, 27, 27)
                .add(fechaI, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 154, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(35, 35, 35)
                .add(fInicio, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 164, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(18, 18, 18)
                .add(fechaF, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
                .add(37, 37, 37)
                .add(fFin, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 162, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(63, 63, 63))
        );
        cuerpoFechaLayout.setVerticalGroup(
            cuerpoFechaLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(cuerpoFechaLayout.createSequentialGroup()
                .addContainerGap(38, Short.MAX_VALUE)
                .add(cuerpoFechaLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(fFin, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 60, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(fechaF, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 63, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(fInicio, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 60, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(fechaI, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 54, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(31, 31, 31))
        );

        Estadisticas.setBackground(new java.awt.Color(255, 255, 255));

        org.jdesktop.layout.GroupLayout EstadisticasLayout = new org.jdesktop.layout.GroupLayout(Estadisticas);
        Estadisticas.setLayout(EstadisticasLayout);
        EstadisticasLayout.setHorizontalGroup(
            EstadisticasLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 711, Short.MAX_VALUE)
        );
        EstadisticasLayout.setVerticalGroup(
            EstadisticasLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 312, Short.MAX_VALUE)
        );

        org.jdesktop.layout.GroupLayout cuerpoLayout = new org.jdesktop.layout.GroupLayout(cuerpo);
        cuerpo.setLayout(cuerpoLayout);
        cuerpoLayout.setHorizontalGroup(
            cuerpoLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(cuerpoLayout.createSequentialGroup()
                .addContainerGap()
                .add(cuerpoLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(Estadisticas, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
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
                .add(Estadisticas, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        add(cuerpo, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void fFinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fFinActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fFinActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Estadisticas;
    protected javax.swing.JButton bVolver;
    private javax.swing.JPanel cabecera;
    private javax.swing.JPanel cuerpo;
    private javax.swing.JPanel cuerpoFecha;
    private javax.swing.JTextField fFin;
    private javax.swing.JTextField fInicio;
    private javax.swing.JLabel fechaF;
    private javax.swing.JLabel fechaI;
    private javax.swing.JLabel logo;
    private javax.swing.JPanel panel_volver;
    private javax.swing.JPanel reloj;
    // End of variables declaration//GEN-END:variables

}
