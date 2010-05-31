
package Vista.InterfazCocinero;

import java.awt.*;
import java.util.ArrayList;
import utilidades.*;
import GestionPedidos.*;

/**
 *
 * @author Daniel Guerrero Martinez
 */
public class IntColaCocinero extends javax.swing.JPanel {

    PanelImagen panelImagen;
    public PanelMesaPedido pmpizq;
    public PreparandosePanel pmpder;
    public InterfazCocinero icocinero;
    ArrayList<Pedido> listaPedidos;
    
    /** Creates new form IntGestionCarta */
    public IntColaCocinero(InterfazCocinero i) {
        this.icocinero = i;
        initComponents();
        this.setDoubleBuffered(true);
        this.panelHora.add(new PanelRelojFecha(), java.awt.BorderLayout.CENTER);
        this.panelHora.setPreferredSize(panelHora.getComponent(0).getPreferredSize());

        pmpizq = new PanelMesaPedido(this);
        pmpizq.setPreferredSize(pmpizq.getComponent(0).getPreferredSize());
        panelIzquierda.add(pmpizq, java.awt.BorderLayout.CENTER);
        
        pmpder = new PreparandosePanel(this);
        pmpder.setPreferredSize(pmpder.getComponent(0).getPreferredSize());
        panelDerecha.add(pmpder, java.awt.BorderLayout.CENTER);

        this.listaPedidos = new ArrayList();
        try {
            listaPedidos = this.icocinero.icocinero.getPedidosCocinaPreparandose();
        } catch (Exception ex) {
            
        }
        if(!listaPedidos.isEmpty()){
            this.pmpder.autoCompletar(listaPedidos);
            this.pmpder.repaint();
            this.pmpder.revalidate();
        }

    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        Rectangle clip = g2.getClipBounds();
        g2.setPaint(new GradientPaint(0.0f, 0.0f, new Color(30, 40, 90) ,getWidth() ,getHeight(), new Color(155, 155, 200) ));
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
        bGestionProductos = new javax.swing.JButton();
        panelHora = new javax.swing.JPanel();
        panelCentroNorte = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        principalIzquierda = new javax.swing.JPanel();
        principalDerecha = new javax.swing.JPanel();
        principalSur = new javax.swing.JPanel();
        principalCentro = new javax.swing.JPanel();
        panelIzquierda = new javax.swing.JPanel();
        panelDerecha = new javax.swing.JPanel();

        setBackground(new java.awt.Color(255, 255, 255));
        setOpaque(false);
        setLayout(new java.awt.BorderLayout(15, 15));

        principalNorte.setOpaque(false);
        principalNorte.setLayout(new java.awt.BorderLayout());

        bGestionProductos.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        bGestionProductos.setForeground(new java.awt.Color(80, 98, 143));
        bGestionProductos.setText("<html>\n<body>\nGesti&oacute;n de<br>Productos\n</body>\n</html>");
        principalNorte.add(bGestionProductos, java.awt.BorderLayout.WEST);

        panelHora.setBackground(new java.awt.Color(255, 255, 255));
        panelHora.setOpaque(false);
        panelHora.setLayout(new java.awt.BorderLayout());
        principalNorte.add(panelHora, java.awt.BorderLayout.EAST);

        panelCentroNorte.setOpaque(false);
        panelCentroNorte.setLayout(new java.awt.BorderLayout());

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/InterfazCocinero/imagenes/LogoSagres.png"))); // NOI18N
        panelCentroNorte.add(jLabel1, java.awt.BorderLayout.CENTER);

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
        principalCentro.add(panelIzquierda);

        panelDerecha.setBackground(new java.awt.Color(245, 245, 255));
        panelDerecha.setLayout(new java.awt.BorderLayout());
        principalCentro.add(panelDerecha);

        add(principalCentro, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    protected javax.swing.JButton bGestionProductos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel panelCentroNorte;
    private javax.swing.JPanel panelDerecha;
    private javax.swing.JPanel panelHora;
    private javax.swing.JPanel panelIzquierda;
    private javax.swing.JPanel principalCentro;
    private javax.swing.JPanel principalDerecha;
    private javax.swing.JPanel principalIzquierda;
    private javax.swing.JPanel principalNorte;
    private javax.swing.JPanel principalSur;
    // End of variables declaration//GEN-END:variables

   

    public void actualizarVista(Pedido p, ElementoColaCocina ele){

        int codPed = p.getCodPedido(),pos = -1;
        boolean encontrado = false;
        for(int i=0;i<listaPedidos.size() && !encontrado ;i++){
            if(listaPedidos.get(i).getCodPedido() == codPed){
                encontrado = true;
                pos = i;
            }
        }
        if(!encontrado)
            listaPedidos.add(p);
        else{
            listaPedidos.remove(pos);
            listaPedidos.add(p);
        }

        this.pmpder.autoCompletar(listaPedidos);
        this.pmpder.repaint();
        this.pmpder.revalidate();

    }
}
