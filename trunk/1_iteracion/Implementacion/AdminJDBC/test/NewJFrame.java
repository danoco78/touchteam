
import AdminJDBC.AdminJDBC;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;


/**
 *
 * @author Daniel Guerrero Martinez
 */
public class NewJFrame extends javax.swing.JFrame {

    /** Creates new form NewJFrame */
    public NewJFrame() {
        initComponents();
        jButton1.setEnabled(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        Host = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        User = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        pass = new javax.swing.JPasswordField();
        BConectar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        Consulta = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        log = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Prueba JDBC");

        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.LINE_AXIS));

        jLabel1.setText("Host");
        jPanel1.add(jLabel1);

        Host.setText("localhost/BaseDatos");
        jPanel1.add(Host);

        jLabel2.setText("Usuario");
        jPanel1.add(jLabel2);

        User.setText("Usuario");
        jPanel1.add(User);

        jLabel3.setText("Contraseña");
        jPanel1.add(jLabel3);
        jPanel1.add(pass);

        BConectar.setText("Conectar");
        BConectar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AConectar(evt);
            }
        });
        jPanel1.add(BConectar);

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_START);

        jPanel2.setLayout(new javax.swing.BoxLayout(jPanel2, javax.swing.BoxLayout.LINE_AXIS));

        jButton1.setText("Consulta");
        jButton1.setMaximumSize(new java.awt.Dimension(23, 23));
        jButton1.setMinimumSize(new java.awt.Dimension(23, 23));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RealizarConsulta(evt);
            }
        });
        jPanel2.add(jButton1);

        Consulta.setText("Introduce la consulta en SQL");
        jPanel2.add(Consulta);

        getContentPane().add(jPanel2, java.awt.BorderLayout.PAGE_END);

        jPanel3.setLayout(new java.awt.BorderLayout());

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jPanel3.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        log.setText("Control de estado: Contectar");
        log.setEnabled(false);
        jPanel3.add(log, java.awt.BorderLayout.PAGE_END);

        getContentPane().add(jPanel3, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AConectar(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AConectar
        try {
            conector = new AdminJDBC(Host.getText(), User.getText(),new String (pass.getPassword()) );
            conector.conectar();
            jButton1.setEnabled(true);
            log.setText("Conexión establecida");
        } catch (Exception ex) {
            log.setText("ERROR :"+ex.getMessage()+"\n");
        }
    }//GEN-LAST:event_AConectar

    private void RealizarConsulta(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RealizarConsulta
        if(conector.EstaConectado()){
            try {
                jTable1.setModel( conector.RealizarConsulta(Consulta.getText()) );
            } catch (SQLException ex) {
                log.setText("Error en la consulta : "+ex.getMessage());
            }
        }
    }//GEN-LAST:event_RealizarConsulta

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BConectar;
    private javax.swing.JTextField Consulta;
    private javax.swing.JTextField Host;
    private javax.swing.JTextField User;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField log;
    private javax.swing.JPasswordField pass;
    // End of variables declaration//GEN-END:variables
    private AdminJDBC conector;



}
