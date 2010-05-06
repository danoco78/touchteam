
package Vista.InterfazCocinero;

import java.awt.*;
import java.util.ArrayList;
import utilidades.*;
import GestionPedidos.Pedido;
import GestionPedidos.IGestorPedidos;

/**
 *
 * @author Daniel Guerrero Martinez
 */
public class IntColaCocinero extends javax.swing.JPanel {

    Integer pendientes = 0, preparandose = 0;
    PanelImagen panelImagen;

    Pedido pendiente;
    ArrayList<Pedido> colaPreparandose;
    
    /** Creates new form IntGestionCarta */
    public IntColaCocinero() {
        initComponents();
        this.setDoubleBuffered(true);
        panelImagen = new PanelImagen("/Vista/InterfazCocinero/imagenes/LogoSagres_interfaz.png");
        this.panelCentroNorte.add(panelImagen);
        this.actualizarVista();
        this.panelHora.add(new PanelRelojFecha(), java.awt.BorderLayout.CENTER);
        this.panelHora.setPreferredSize(panelHora.getComponent(0).getPreferredSize());


        //Pruebas
        PanelMesaPedido mp = new PanelMesaPedido(new Pedido(),0);
        PanelMesaPedido mp2 = new PanelMesaPedido(new Pedido(),0);
        //System.out.println(this.panelIzquierda.getWidth());
        //TODO Obtener el ancho del panel padre y el alto segun el numero de elementos del pedido
        mp.setPreferredSize(new Dimension(340,2000));
        mp.setBackground(Color.BLACK);
        this.panelFlow.add(mp);

    }

    @Override
    public void paint(Graphics g) {
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

        principalNorte = new javax.swing.JPanel();
        botonGestionProductos = new javax.swing.JButton();
        panelHora = new javax.swing.JPanel();
        panelCentroNorte = new javax.swing.JPanel();
        principalIzquierda = new javax.swing.JPanel();
        principalDerecha = new javax.swing.JPanel();
        principalSur = new javax.swing.JPanel();
        principalCentro = new javax.swing.JPanel();
        panelIzquierda = new javax.swing.JPanel();
        infoPendientes = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        panelFlow = new javax.swing.JPanel();
        panelDerecha = new javax.swing.JPanel();
        infoPreparandose = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        panelBox2 = new javax.swing.JPanel();

        setBackground(new java.awt.Color(255, 255, 255));
        setOpaque(false);
        setLayout(new java.awt.BorderLayout(15, 15));

        principalNorte.setOpaque(false);
        principalNorte.setLayout(new java.awt.BorderLayout());

        botonGestionProductos.setFont(new java.awt.Font("Arial", 1, 18));
        botonGestionProductos.setForeground(new java.awt.Color(80, 98, 143));
        botonGestionProductos.setText("<html>\n<body>\nGesti&oacute;n de<br>Productos\n</body>\n</html>");
        botonGestionProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonGestionProductosActionPerformed(evt);
            }
        });
        principalNorte.add(botonGestionProductos, java.awt.BorderLayout.WEST);

        panelHora.setBackground(new java.awt.Color(255, 255, 255));
        panelHora.setOpaque(false);
        panelHora.setLayout(new java.awt.BorderLayout());
        principalNorte.add(panelHora, java.awt.BorderLayout.EAST);

        panelCentroNorte.setOpaque(false);
        principalNorte.add(panelCentroNorte, java.awt.BorderLayout.CENTER);

        add(principalNorte, java.awt.BorderLayout.PAGE_START);

        principalIzquierda.setOpaque(false);
        add(principalIzquierda, java.awt.BorderLayout.EAST);

        principalDerecha.setOpaque(false);
        add(principalDerecha, java.awt.BorderLayout.WEST);

        principalSur.setOpaque(false);
        principalSur.setPreferredSize(new java.awt.Dimension(1, 1));
        add(principalSur, java.awt.BorderLayout.SOUTH);

        principalCentro.setOpaque(false);
        principalCentro.setLayout(new java.awt.GridLayout(1, 0, 15, 0));

        panelIzquierda.setBackground(new java.awt.Color(245, 245, 255));
        panelIzquierda.setLayout(new java.awt.BorderLayout());

        infoPendientes.setFont(new java.awt.Font("Arial", 1, 16));
        infoPendientes.setForeground(new java.awt.Color(80, 98, 143));
        infoPendientes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        infoPendientes.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(150, 172, 229), 5));
        infoPendientes.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        panelIzquierda.add(infoPendientes, java.awt.BorderLayout.SOUTH);

        jScrollPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(150, 172, 229), 5));
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        panelFlow.setBackground(new java.awt.Color(245, 245, 255));
        panelFlow.setPreferredSize(new java.awt.Dimension(30, 30));
        jScrollPane1.setViewportView(panelFlow);

        panelIzquierda.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        principalCentro.add(panelIzquierda);

        panelDerecha.setBackground(new java.awt.Color(245, 245, 255));
        panelDerecha.setLayout(new java.awt.BorderLayout());

        infoPreparandose.setFont(new java.awt.Font("Arial", 1, 16));
        infoPreparandose.setForeground(new java.awt.Color(80, 98, 143));
        infoPreparandose.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        infoPreparandose.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(150, 172, 229), 5));
        panelDerecha.add(infoPreparandose, java.awt.BorderLayout.SOUTH);

        jScrollPane2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(150, 172, 229), 5));
        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        panelBox2.setBackground(new java.awt.Color(245, 245, 255));
        panelBox2.setLayout(new javax.swing.BoxLayout(panelBox2, javax.swing.BoxLayout.LINE_AXIS));
        jScrollPane2.setViewportView(panelBox2);

        panelDerecha.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        principalCentro.add(panelDerecha);

        add(principalCentro, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void botonGestionProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonGestionProductosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botonGestionProductosActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                javax.swing.JFrame dialog = new javax.swing.JFrame("Prueba ejecucion");
                dialog.setSize(800, 600);
                dialog.getContentPane().add(new IntColaCocinero(), java.awt.BorderLayout.CENTER);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonGestionProductos;
    private javax.swing.JLabel infoPendientes;
    private javax.swing.JLabel infoPreparandose;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel panelBox2;
    private javax.swing.JPanel panelCentroNorte;
    private javax.swing.JPanel panelDerecha;
    private javax.swing.JPanel panelFlow;
    private javax.swing.JPanel panelHora;
    private javax.swing.JPanel panelIzquierda;
    private javax.swing.JPanel principalCentro;
    private javax.swing.JPanel principalDerecha;
    private javax.swing.JPanel principalIzquierda;
    private javax.swing.JPanel principalNorte;
    private javax.swing.JPanel principalSur;
    // End of variables declaration//GEN-END:variables


    private void setInfoPendientes(int n){
        String text;
        if(n == 0)
            text = "Ningún plato pendiente.";
        else
            text = String.valueOf(n) + " platos pendientes";
        this.infoPendientes.setText(text);
    }
    private void setInfoPreparandose(int n){
        String text;
        if(n == 0)
            text = "Ningún plato preparándose.";
        else
            text = String.valueOf(n) + " platos preparándose";
        this.infoPreparandose.setText(text);
    }
    private void actualizarVista(){
        this.setInfoPendientes(pendientes);
        this.setInfoPreparandose(preparandose);
    }

    private void actualizarColaPreparandose(){
        
    }
    private void actualizarColaPendientes(){
        
    }
    /*
   while(!haypedido){
      try{
           pedido = getSiguientePedidoEnCola();
           haypedido = true;
       }catch(excepcion ex){
           // Si entra aqui es que no hay pedido aun
       }
    }

     */
}
