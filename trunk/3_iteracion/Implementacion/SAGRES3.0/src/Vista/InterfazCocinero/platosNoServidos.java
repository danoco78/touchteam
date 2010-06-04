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
import utilidades.*;
import ControladorPrincipal.ICocinero;
import java.sql.Timestamp;
import org.jfree.data.category.DefaultCategoryDataset;
import java.io.IOException;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import javax.swing.ImageIcon;
import java.io.File;

/**
 *
 * @author nabil
 */
public class platosNoServidos extends javax.swing.JPanel {
    private ICocinero cocina;
    private int cont;
    /** Creates new form platoMasvendido */
    public platosNoServidos(ICocinero icocinero) {
        initComponents();
        this.cocina = icocinero;
        this.cont = 0;
        this.panelDER.add(new PanelRelojFecha(), java.awt.BorderLayout.CENTER);
        this.panelDER.setPreferredSize(panelDER.getComponent(0).getPreferredSize());
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
        panelIZQ = new javax.swing.JPanel();
        bVolver = new javax.swing.JButton();
        panelDER = new javax.swing.JPanel();
        panelCENTRO = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cuerpo = new javax.swing.JPanel();
        cabeceraCuerpo = new javax.swing.JPanel();
        FI = new javax.swing.JLabel();
        fechaI = new javax.swing.JTextField();
        FF = new javax.swing.JLabel();
        fechaF = new javax.swing.JTextField();
        bGenerar = new javax.swing.JButton();
        Estadisticas = new javax.swing.JPanel();
        imagen = new javax.swing.JLabel();

        setLayout(new java.awt.BorderLayout());

        cabecera.setLayout(new java.awt.BorderLayout());

        panelIZQ.setLayout(new java.awt.GridBagLayout());

        bVolver.setFont(new java.awt.Font("Arial", 1, 18));
        bVolver.setForeground(new java.awt.Color(80, 98, 143));
        bVolver.setText("Volver");
        bVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bVolverActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.ipadx = 27;
        gridBagConstraints.ipady = 28;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(0, 62, 0, 58);
        panelIZQ.add(bVolver, gridBagConstraints);

        cabecera.add(panelIZQ, java.awt.BorderLayout.LINE_START);

        panelDER.setLayout(new java.awt.BorderLayout());
        cabecera.add(panelDER, java.awt.BorderLayout.LINE_END);

        panelCENTRO.setLayout(new java.awt.GridBagLayout());

        jLabel1.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(80, 98, 143));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/InterfazCocinero/imagenes/LogoSagres.png"))); // NOI18N
        jLabel1.setText("<html>\n<body>\nEfecto de la falta<br>\nde ingredientes\n</html>\n</body>");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        panelCENTRO.add(jLabel1, gridBagConstraints);

        cabecera.add(panelCENTRO, java.awt.BorderLayout.CENTER);

        add(cabecera, java.awt.BorderLayout.PAGE_START);

        cuerpo.setLayout(new java.awt.BorderLayout());

        cabeceraCuerpo.setLayout(new java.awt.GridBagLayout());

        FI.setFont(new java.awt.Font("Arial", 1, 18));
        FI.setForeground(new java.awt.Color(80, 98, 143));
        FI.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        FI.setText("Fecha inicio:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.ipadx = 4;
        gridBagConstraints.ipady = 13;
        gridBagConstraints.insets = new java.awt.Insets(62, 19, 64, 14);
        cabeceraCuerpo.add(FI, gridBagConstraints);

        fechaI.setFont(new java.awt.Font("Arial", 0, 14));
        fechaI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fechaIActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.ipadx = 111;
        gridBagConstraints.ipady = 9;
        gridBagConstraints.insets = new java.awt.Insets(62, 0, 64, 35);
        cabeceraCuerpo.add(fechaI, gridBagConstraints);

        FF.setFont(new java.awt.Font("Arial", 1, 18));
        FF.setForeground(new java.awt.Color(80, 98, 143));
        FF.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        FF.setText("Fecha fin:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.ipadx = 25;
        gridBagConstraints.ipady = 7;
        gridBagConstraints.insets = new java.awt.Insets(62, 41, 64, 15);
        cabeceraCuerpo.add(FF, gridBagConstraints);

        fechaF.setFont(new java.awt.Font("Arial", 0, 14));
        fechaF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fechaFActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.ipadx = 105;
        gridBagConstraints.ipady = 7;
        gridBagConstraints.insets = new java.awt.Insets(62, 0, 64, 26);
        cabeceraCuerpo.add(fechaF, gridBagConstraints);

        bGenerar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        bGenerar.setForeground(new java.awt.Color(80, 98, 143));
        bGenerar.setText("Generar");
        bGenerar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bGenerarActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.ipadx = 34;
        gridBagConstraints.insets = new java.awt.Insets(62, 24, 64, 5);
        cabeceraCuerpo.add(bGenerar, gridBagConstraints);

        cuerpo.add(cabeceraCuerpo, java.awt.BorderLayout.PAGE_START);

        Estadisticas.setLayout(new java.awt.BorderLayout());

        imagen.setBackground(new java.awt.Color(0, 0, 0));
        imagen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        imagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/InterfazMetre/imagenes/LogoSagres.png"))); // NOI18N
        imagen.setMaximumSize(new java.awt.Dimension(800, 600));
        imagen.setPreferredSize(new java.awt.Dimension(500, 400));
        Estadisticas.add(imagen, java.awt.BorderLayout.CENTER);

        cuerpo.add(Estadisticas, java.awt.BorderLayout.CENTER);

        add(cuerpo, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void bVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bVolverActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_bVolverActionPerformed

    private void fechaIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fechaIActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_fechaIActionPerformed

    private void fechaFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fechaFActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_fechaFActionPerformed

    private void bGenerarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bGenerarActionPerformed
        repaint();
        String fecha;
        fecha = fechaI.getText();
        Timestamp i= Timestamp.valueOf(fecha+" 00:00:00");
        cont = cont +1;

        fecha = fechaF.getText();
         System.out.println(fecha+"\n");
        Timestamp f= Timestamp.valueOf(fecha+" 00:00:00");

        DefaultCategoryDataset dataset = cocina.elementosAfectadosFaltaProductos(i, f);

        JFreeChart chart = ChartFactory.createBarChart("platos No Servidos", "platos","productos", dataset, PlotOrientation.VERTICAL, true,
   true, false);
        try {
        ChartPanel panel = new ChartPanel(chart);
        String tmpDir = System.getProperty("java.io.tmpdir");


        ChartUtilities.saveChartAsJPEG(new File(tmpDir + "platosNoServidos"+cont+".jpeg"), chart, 500, 300);
        System.out.println("imagen guardada en "+tmpDir);
        ImageIcon foto = new ImageIcon(tmpDir + "platosNoServidos"+cont+".jpeg");
        imagen.setIcon(foto);

        imagen.validate();

        } catch (IOException e) {
            System.err.println("Error creando grafico.");
        }
        
    }//GEN-LAST:event_bGenerarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Estadisticas;
    private javax.swing.JLabel FF;
    private javax.swing.JLabel FI;
    private javax.swing.JButton bGenerar;
    public javax.swing.JButton bVolver;
    private javax.swing.JPanel cabecera;
    private javax.swing.JPanel cabeceraCuerpo;
    private javax.swing.JPanel cuerpo;
    private javax.swing.JTextField fechaF;
    private javax.swing.JTextField fechaI;
    private javax.swing.JLabel imagen;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel panelCENTRO;
    private javax.swing.JPanel panelDER;
    private javax.swing.JPanel panelIZQ;
    // End of variables declaration//GEN-END:variables

}
