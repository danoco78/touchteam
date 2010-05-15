
package Vista.InterfazCocinero;

import ControladorPrincipal.ICocinero;
import GestionCarta.Elemento;
import java.awt.*;
import java.util.ArrayList;
import utilidades.*;
import GestionPedidos.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Daniel Guerrero Martinez
 */
public class IntColaCocinero extends javax.swing.JPanel {

    PanelImagen panelImagen;
    public PanelMesaPedido pmpizq;
    public PreparandosePanel pmpder;
    public InterfazCocinero interfaz;
    ArrayList<Pedido> listaPedidos;
    
    /** Creates new form IntGestionCarta */
    public IntColaCocinero(InterfazCocinero i) {
        this.interfaz = i;
        initComponents();
        this.setDoubleBuffered(true);
        panelImagen = new PanelImagen("/Vista/InterfazCocinero/imagenes/LogoSagres_interfaz.png");
        this.panelCentroNorte.add(panelImagen);
        this.panelHora.add(new PanelRelojFecha(), java.awt.BorderLayout.CENTER);
        this.panelHora.setPreferredSize(panelHora.getComponent(0).getPreferredSize());

        pmpizq = new PanelMesaPedido(i);
        pmpizq.setPreferredSize(pmpizq.getComponent(0).getPreferredSize());
        panelIzquierda.add(pmpizq, java.awt.BorderLayout.CENTER);
        
        pmpder = new PreparandosePanel(this);
        pmpder.setPreferredSize(pmpder.getComponent(0).getPreferredSize());
        panelDerecha.add(pmpder, java.awt.BorderLayout.CENTER);

        this.listaPedidos = new ArrayList();
        try {
            listaPedidos = this.interfaz.icocinero.getPedidosCocinaPreparandose();
            System.out.println("Hay " + listaPedidos.size() + " pedidos preparandose.");
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
        bGestionProductos = new javax.swing.JButton();
        panelHora = new javax.swing.JPanel();
        panelCentroNorte = new javax.swing.JPanel();
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
        bGestionProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bGestionProductosActionPerformed(evt);
            }
        });
        principalNorte.add(bGestionProductos, java.awt.BorderLayout.WEST);

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
        principalCentro.add(panelIzquierda);

        panelDerecha.setBackground(new java.awt.Color(245, 245, 255));
        panelDerecha.setLayout(new java.awt.BorderLayout());
        principalCentro.add(panelDerecha);

        add(principalCentro, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void bGestionProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bGestionProductosActionPerformed
        // TODO Cambiar el panel por Gestion Productos
    }//GEN-LAST:event_bGestionProductosActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    protected javax.swing.JButton bGestionProductos;
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
        //Prueba para comprobar que funciona
        //ArrayList<Pedido> peds = new ArrayList<Pedido>();
        
        /*try {
            peds = this.interfaz.icocinero.getPedidosCocinaPreparandose();
            if(!peds.isEmpty()){
                this.pmpder.autoCompletar(peds);
                //this.pmpder.repaint();
                //this.pmpder.revalidate();
            }
            else{
                System.out.println("Pedidos está vacío.");
            }
        } catch (Exception ex) {
            Logger.getLogger(IntColaCocinero.class.getName()).log(Level.SEVERE, null, ex);
        }*/

        /*Pedido ped = new Pedido(5, 2, 0, null);
        ElementoColaCocina ele = new ElementoColaCocina(1, 0, "Del tiempo, por favor");
        ele.asocia(new Elemento(2, "Agua",
                "Agua embotellada marca Bezoya",
                true, null, 5, 5, 10));
        for(int j=0; j<4; ++j)
                ped.asocia(ele);

        // Se supone que ya hemos obtenido la lista de pedidos, lo siguiente si se ejecuta
        // independientemente de la prueba
        this.pmpizq.addPedido(ped);*/

       /* ElementoColaCocina ele = new ElementoColaCocina(1, ElementoColaCocina.ENCOLA, "La carne poco hecha por favor.");
        ElementoColaCocina ele2 = new ElementoColaCocina(1, ElementoColaCocina.PREPARANDOSE, "La carne poco hecha por favor.");
        ElementoColaCocina ele3 = new ElementoColaCocina(2, ElementoColaCocina.PREPARANDOSE, "La carne ");
        ElementoColaCocina ele4 = new ElementoColaCocina(3, ElementoColaCocina.PREPARANDOSE, "La carne poco hecha ");
        ElementoColaCocina ele5 = new ElementoColaCocina(1, ElementoColaCocina.PREPARANDOSE, "La carne poco hecha por favor.");
        ElementoColaCocina ele6 = new ElementoColaCocina(2, ElementoColaCocina.PREPARANDOSE, "La carne ");
        ElementoColaCocina ele7 = new ElementoColaCocina(3, ElementoColaCocina.PREPARANDOSE, "La carne poco hecha ");
        
        ele.asocia(new Elemento(2, "Hamburguesa con queso",
                "Deliciosa carne de vacuno a la parrilla con queso fresco",
                true, null, 5, 5, 10));
        ele2.asocia(new Elemento(2, "Hamburguesa sin queso",
                "Deliciosa carne de vacuno a la parrilla con queso fresco",
                true, null, 5, 5, 10));
        ele3.asocia(new Elemento(2, "Carne a la plancha",
                "Deliciosa carne de cerdo cocinada a su gusto",
                true, null, 5, 5, 10));
        ele4.asocia(new Elemento(2, "Sandwich Mixto",
                "Nuestro sandwich especial",
                true, null, 5, 5, 10));
                ele2.asocia(new Elemento(2, "Hamburguesa sin queso",
                "Deliciosa carne de vacuno a la parrilla con queso fresco",
                true, null, 5, 5, 10));
        ele5.asocia(new Elemento(2, "Carne a la plancha",
                "Deliciosa carne de cerdo cocinada a su gusto",
                true, null, 5, 5, 10));
        ele6.asocia(new Elemento(2, "Sandwich Mixto",
                "Nuestro sandwich especial",
                true, null, 5, 5, 10));
        ele7.asocia(new Elemento(2, "Sandwich Mixto",
                "Nuestro sandwich especial",
                true, null, 5, 5, 10));

        peds.add(new Pedido(5,0,0,null));
        peds.get(0).asocia(ele2);
        peds.get(0).asocia(ele3);
        peds.get(0).asocia(ele4);

        peds.add(new Pedido(5,1,0,null));
        peds.get(1).asocia(ele5);
        peds.get(1).asocia(ele6);
        peds.get(1).asocia(ele7);

        this.pmpder.autoCompletar(peds);
        Pedido aux = new Pedido(5, 30, 0, null);
        aux.asocia(ele);
        this.pmpizq.addPedido(aux);*/

    }
}
