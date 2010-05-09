/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * IntColaBar.java
 *
 * Created on 06-may-2010, 11:40:36
 */

package Vista.InterfazMetre;

import GestionCarta.Elemento;
import GestionPedidos.ElementoColaBar;
import GestionPedidos.Pedido;
import utilidades.PanelRelojFecha;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.ArrayList;
import javax.swing.JButton;
import utilidades.PanelMesaPedido;

/**
 *
 * @author Samuel Guirado Navarro
 */
public class IntColaBar extends javax.swing.JPanel {

    PanelMesaPedido pmp = new PanelMesaPedido(PanelMesaPedido.BAR);
    PanelColaFacturas colaIzq = new PanelColaFacturas();
    PanelColaFacturas colaDer = new PanelColaFacturas();

    
    /** Creates new form IntColaBar */
    public IntColaBar() {
        initComponents();

        pDer.add(new PanelRelojFecha(), new java.awt.GridBagConstraints());
        pIzq2.add(pmp,java.awt.BorderLayout.CENTER);
        this.actualizarVista();
        
        centroIzq.add(colaIzq, java.awt.BorderLayout.CENTER);
        centroDer.add(colaDer, java.awt.BorderLayout.CENTER);
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

        cabecera = new javax.swing.JPanel();
        pDer = new javax.swing.JPanel();
        pIzq = new javax.swing.JPanel();
        bGestBebidas = new javax.swing.JButton();
        pCentro = new javax.swing.JPanel();
        logo = new javax.swing.JLabel();
        cuerpo = new javax.swing.JPanel();
        pIzq2 = new javax.swing.JPanel();
        margenSup = new javax.swing.JPanel();
        margenInf = new javax.swing.JPanel();
        margenDer = new javax.swing.JPanel();
        margenIzq = new javax.swing.JPanel();
        pDer2 = new javax.swing.JPanel();
        margenInf1 = new javax.swing.JPanel();
        margenDer1 = new javax.swing.JPanel();
        margenIzq1 = new javax.swing.JPanel();
        centro = new javax.swing.JPanel();
        centroIzq = new javax.swing.JPanel();
        panelTextoIzq = new javax.swing.JPanel();
        textoIzq = new javax.swing.JLabel();
        centroDer = new javax.swing.JPanel();
        panelTextoDer = new javax.swing.JPanel();
        textoDer = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(800, 650));
        setOpaque(false);
        setPreferredSize(new java.awt.Dimension(800, 600));
        setLayout(new java.awt.BorderLayout());

        cabecera.setMinimumSize(new java.awt.Dimension(50, 50));
        cabecera.setOpaque(false);
        cabecera.setPreferredSize(new java.awt.Dimension(500, 100));
        cabecera.setLayout(new java.awt.BorderLayout());

        pDer.setMaximumSize(new java.awt.Dimension(230, 100));
        pDer.setMinimumSize(new java.awt.Dimension(230, 100));
        pDer.setOpaque(false);
        pDer.setPreferredSize(new java.awt.Dimension(230, 100));
        pDer.setLayout(new java.awt.GridBagLayout());
        cabecera.add(pDer, java.awt.BorderLayout.EAST);

        pIzq.setMinimumSize(new java.awt.Dimension(35, 21));
        pIzq.setOpaque(false);
        pIzq.setPreferredSize(new java.awt.Dimension(200, 100));
        pIzq.setLayout(new java.awt.GridBagLayout());

        bGestBebidas.setFont(new java.awt.Font("Arial", 1, 14));
        bGestBebidas.setForeground(new java.awt.Color(80, 98, 143));
        bGestBebidas.setText("Gestionar Bebidas");
        bGestBebidas.setActionCommand("GestProductos");
        bGestBebidas.setBorder(null);
        bGestBebidas.setMaximumSize(new java.awt.Dimension(170, 80));
        bGestBebidas.setMinimumSize(new java.awt.Dimension(170, 80));
        bGestBebidas.setPreferredSize(new java.awt.Dimension(170, 80));
        pIzq.add(bGestBebidas, new java.awt.GridBagConstraints());
        bGestBebidas.getAccessibleContext().setAccessibleName("");

        cabecera.add(pIzq, java.awt.BorderLayout.WEST);

        pCentro.setOpaque(false);
        pCentro.setLayout(new java.awt.GridBagLayout());

        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/InterfazMetre/imagenes/LogoSagres.png"))); // NOI18N
        pCentro.add(logo, new java.awt.GridBagConstraints());

        cabecera.add(pCentro, java.awt.BorderLayout.CENTER);

        add(cabecera, java.awt.BorderLayout.PAGE_START);

        cuerpo.setOpaque(false);
        cuerpo.setLayout(new java.awt.GridLayout(1, 2));

        pIzq2.setOpaque(false);
        pIzq2.setLayout(new java.awt.BorderLayout());

        margenSup.setOpaque(false);
        margenSup.setPreferredSize(new java.awt.Dimension(400, 20));

        javax.swing.GroupLayout margenSupLayout = new javax.swing.GroupLayout(margenSup);
        margenSup.setLayout(margenSupLayout);
        margenSupLayout.setHorizontalGroup(
            margenSupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        margenSupLayout.setVerticalGroup(
            margenSupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );

        pIzq2.add(margenSup, java.awt.BorderLayout.PAGE_START);

        margenInf.setOpaque(false);
        margenInf.setPreferredSize(new java.awt.Dimension(400, 30));

        javax.swing.GroupLayout margenInfLayout = new javax.swing.GroupLayout(margenInf);
        margenInf.setLayout(margenInfLayout);
        margenInfLayout.setHorizontalGroup(
            margenInfLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        margenInfLayout.setVerticalGroup(
            margenInfLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        pIzq2.add(margenInf, java.awt.BorderLayout.PAGE_END);

        margenDer.setOpaque(false);
        margenDer.setPreferredSize(new java.awt.Dimension(50, 500));

        javax.swing.GroupLayout margenDerLayout = new javax.swing.GroupLayout(margenDer);
        margenDer.setLayout(margenDerLayout);
        margenDerLayout.setHorizontalGroup(
            margenDerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );
        margenDerLayout.setVerticalGroup(
            margenDerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );

        pIzq2.add(margenDer, java.awt.BorderLayout.LINE_END);

        margenIzq.setOpaque(false);
        margenIzq.setPreferredSize(new java.awt.Dimension(20, 350));

        javax.swing.GroupLayout margenIzqLayout = new javax.swing.GroupLayout(margenIzq);
        margenIzq.setLayout(margenIzqLayout);
        margenIzqLayout.setHorizontalGroup(
            margenIzqLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );
        margenIzqLayout.setVerticalGroup(
            margenIzqLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );

        pIzq2.add(margenIzq, java.awt.BorderLayout.LINE_START);

        cuerpo.add(pIzq2);

        pDer2.setOpaque(false);
        pDer2.setLayout(new java.awt.BorderLayout());

        margenInf1.setOpaque(false);
        margenInf1.setPreferredSize(new java.awt.Dimension(400, 30));

        javax.swing.GroupLayout margenInf1Layout = new javax.swing.GroupLayout(margenInf1);
        margenInf1.setLayout(margenInf1Layout);
        margenInf1Layout.setHorizontalGroup(
            margenInf1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        margenInf1Layout.setVerticalGroup(
            margenInf1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        pDer2.add(margenInf1, java.awt.BorderLayout.PAGE_END);

        margenDer1.setOpaque(false);
        margenDer1.setPreferredSize(new java.awt.Dimension(20, 500));

        javax.swing.GroupLayout margenDer1Layout = new javax.swing.GroupLayout(margenDer1);
        margenDer1.setLayout(margenDer1Layout);
        margenDer1Layout.setHorizontalGroup(
            margenDer1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );
        margenDer1Layout.setVerticalGroup(
            margenDer1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 520, Short.MAX_VALUE)
        );

        pDer2.add(margenDer1, java.awt.BorderLayout.LINE_END);

        margenIzq1.setOpaque(false);
        margenIzq1.setPreferredSize(new java.awt.Dimension(20, 350));

        javax.swing.GroupLayout margenIzq1Layout = new javax.swing.GroupLayout(margenIzq1);
        margenIzq1.setLayout(margenIzq1Layout);
        margenIzq1Layout.setHorizontalGroup(
            margenIzq1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );
        margenIzq1Layout.setVerticalGroup(
            margenIzq1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 520, Short.MAX_VALUE)
        );

        pDer2.add(margenIzq1, java.awt.BorderLayout.LINE_START);

        centro.setOpaque(false);
        centro.setLayout(new java.awt.GridLayout(1, 2, 25, 0));

        centroIzq.setOpaque(false);
        centroIzq.setLayout(new java.awt.BorderLayout());

        panelTextoIzq.setOpaque(false);
        panelTextoIzq.setPreferredSize(new java.awt.Dimension(180, 20));
        panelTextoIzq.setLayout(new java.awt.BorderLayout());

        textoIzq.setFont(new java.awt.Font("Arial", 1, 12));
        textoIzq.setForeground(new java.awt.Color(80, 98, 143));
        textoIzq.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        textoIzq.setText("Facturas a imprimir");
        panelTextoIzq.add(textoIzq, java.awt.BorderLayout.CENTER);

        centroIzq.add(panelTextoIzq, java.awt.BorderLayout.NORTH);

        centro.add(centroIzq);

        centroDer.setOpaque(false);
        centroDer.setLayout(new java.awt.BorderLayout());

        panelTextoDer.setOpaque(false);
        panelTextoDer.setPreferredSize(new java.awt.Dimension(180, 20));
        panelTextoDer.setLayout(new java.awt.BorderLayout());

        textoDer.setFont(new java.awt.Font("Arial", 1, 12));
        textoDer.setForeground(new java.awt.Color(80, 98, 143));
        textoDer.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        textoDer.setText("Mesas por facturar");
        panelTextoDer.add(textoDer, java.awt.BorderLayout.CENTER);

        centroDer.add(panelTextoDer, java.awt.BorderLayout.NORTH);

        centro.add(centroDer);

        pDer2.add(centro, java.awt.BorderLayout.CENTER);

        cuerpo.add(pDer2);

        add(cuerpo, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    protected javax.swing.JButton bGestBebidas;
    private javax.swing.JPanel cabecera;
    private javax.swing.JPanel centro;
    private javax.swing.JPanel centroDer;
    private javax.swing.JPanel centroIzq;
    private javax.swing.JPanel cuerpo;
    private javax.swing.JLabel logo;
    private javax.swing.JPanel margenDer;
    private javax.swing.JPanel margenDer1;
    private javax.swing.JPanel margenInf;
    private javax.swing.JPanel margenInf1;
    private javax.swing.JPanel margenIzq;
    private javax.swing.JPanel margenIzq1;
    private javax.swing.JPanel margenSup;
    private javax.swing.JPanel pCentro;
    private javax.swing.JPanel pDer;
    private javax.swing.JPanel pDer2;
    private javax.swing.JPanel pIzq;
    private javax.swing.JPanel pIzq2;
    private javax.swing.JPanel panelTextoDer;
    private javax.swing.JPanel panelTextoIzq;
    private javax.swing.JLabel textoDer;
    private javax.swing.JLabel textoIzq;
    // End of variables declaration//GEN-END:variables

    private void actualizarVista(){
        // TODO obtener el numero de platos pendientes
        //this.setInfoPendientes(pendientes);

        // No es necesario obtener el numero de platos preparandose, lo actualiza
        // PreparandosePanel automaticamente
        //this.setInfoPreparandose(preparandose);

        // TODO this.pmpder.autoCompletar(getPedidosCocinaPreparandose());
        // Prueba para comprobar que funciona
        Pedido ped = new Pedido(5, 2, 0, null);
        ElementoColaBar ele = new ElementoColaBar(1, 1, "Del tiempo, por favor");
        ele.asocia(new Elemento(2, "Agua",
                "Agua embotellada marca Bezoya",
                true, null, 5, 5, 10));
            for(int j=0; j<4; ++j)
                ped.asocia(ele);
        
        // Se supone que ya hemos obtenido la lista de pedidos, lo siguiente si se ejecuta
        // independientemente de la prueba
        this.pmp.addPedido(ped);

    }

}
