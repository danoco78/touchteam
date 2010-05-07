/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * PanelMesaPedido.java
 *
 * Created on 05-may-2010, 19:04:58
 */

package Vista.InterfazCocinero;

import utilidades.*;
import GestionCarta.Elemento;
import GestionPedidos.ElementoColaBar;
import GestionPedidos.ElementoColaCocina;
import GestionPedidos.ElementoPedido;
import GestionPedidos.Pedido;
import java.util.ArrayList;
import javax.swing.JButton;

/**
 *
 * @author Samuel Guirado Navarro
 */
public class PreparandosePanel extends javax.swing.JPanel {

    Pedido pedActual = null;
    java.awt.Dimension oldTama;
    
    /** Creates new form PanelMesaPedido */
    public PreparandosePanel() {
        initComponents();
        oldTama = this.getSize();
        jButton1.setBackground(new java.awt.Color(211, 223, 253));
        jButton1.setFont(new java.awt.Font("Arial", 0, 10));
        jButton1.setForeground(new java.awt.Color(80, 98, 143));
        jButton1.setText("<html>\n<body> \nHamburguesa con queso \n<br></br>\n<br></br>\n<font color=\"#000000\">La carne poco hecha, por favor...</font>\n</body>\n</html>\n");
        jButton1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        this.centro.setSize(this.centro.getSize().width,
                infoMesaPedido.getHeight()+1*65);
        this.centro.setPreferredSize(this.getSize());
        System.out.println(infoMesaPedido.getHeight()+1*65);
    }

    public void addPedidoBar(Pedido ped){
        pedActual = ped;

        panelInfoPedido.removeAll();
        infoMesaPedido.setText("Mesa "+String.valueOf(pedActual.getCodMesa())+", pedido "+String.valueOf(pedActual.getCodPedido()));

        ArrayList<ElementoPedido> elementos = pedActual.obtieneElementos();
        ElementoPedido elemP;
        JButton boton;
        Elemento ele;
        //int cont=0;
        
        for (int i=0;i<elementos.size();i++){
            elemP = elementos.get(i);
            if (elemP.getEstado() == 0 &&
                    elemP instanceof ElementoColaBar){
                //cont++;
                boton = new JButton();
                ele = elementos.get(i).getElemento();

                boton.setBackground(new java.awt.Color(211, 223, 253));
                boton.setMaximumSize(new java.awt.Dimension(734204, 60));
                boton.setFont(new java.awt.Font("Arial", 0, 10));
                boton.setForeground(new java.awt.Color(80, 98, 143));
                boton.setText("<html>\n<body> \n"+ele.getNombre()+" \n<br></br>\n<br></br>\n<font color=\"#000000\">"+elementos.get(i).getComentario()+"</font>\n</body>\n</html>\n");
                boton.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
                panelInfoPedido.add(boton);
            }
        }
        //this.centro.setMaximumSize(new java.awt.Dimension(this.centro.getMaximumSize().width,
        //        infoMesaPedido.getHeight()+cont*65));
        //System.out.println(infoMesaPedido.getHeight()+cont*65);
        //oldTama = this.getSize();

        //pendientes.setText(String.valueOf(cont)+" bebidas pendientes");
    }


    public void addPedidoCocina(Pedido ped){
        pedActual = ped;

        panelInfoPedido.removeAll();
        infoMesaPedido.setText("Mesa "+String.valueOf(pedActual.getCodMesa())+", pedido "+String.valueOf(pedActual.getCodPedido()));

        ArrayList<ElementoPedido> elementos = pedActual.obtieneElementos();
        ElementoPedido elemP;
        JButton boton;
        Elemento ele;
        //int cont=0;

        for (int i=0;i<elementos.size();i++){
            elemP = elementos.get(i);
            if (elemP.getEstado() == 0 &&
                    elemP instanceof ElementoColaCocina){
                //cont++;
                boton = new JButton();
                ele = elementos.get(i).getElemento();

                boton.setBackground(new java.awt.Color(211, 223, 253));
                boton.setFont(new java.awt.Font("Arial", 0, 10));
                boton.setForeground(new java.awt.Color(80, 98, 143));
                boton.setText("<html>\n<body> \n"+ele.getNombre()+" \n<br></br>\n<br></br>\n<font color=\"#000000\">"+elementos.get(i).getComentario()+"</font>\n</body>\n</html>\n");
                boton.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
                panelInfoPedido.add(boton);
            }
        }
        oldTama = this.getSize();

        //pendientes.setText(String.valueOf(cont)+" platos pendientes");
    }

    /**
     * Modifica el mensaje de texto de la base. Es necesario decirle la cantidad por parametros,
     * puesto que se obtiene de una consulta
     * @param mensaje Texto a mostrar. <br>Siempre sigue el formato [num] platos pendientes, para el caso de platos.
     */
    public void setMensaje(String mensaje){
        pendientes.setText(mensaje);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pCentral = new javax.swing.JPanel();
        margenSup = new javax.swing.JPanel();
        margenInf = new javax.swing.JPanel();
        margenDer = new javax.swing.JPanel();
        margenIzq = new javax.swing.JPanel();
        scroll = new javax.swing.JScrollPane();
        PanelScroll = new javax.swing.JPanel();
        centro = new javax.swing.JPanel();
        margenIzq2 = new javax.swing.JPanel();
        centro2 = new javax.swing.JPanel();
        infoMesaPedido = new javax.swing.JLabel();
        panelInfoPedido = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        margenDer2 = new javax.swing.JPanel();
        MargenInf2 = new javax.swing.JPanel();
        pInf = new javax.swing.JPanel();
        pendientes = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, new java.awt.Color(150, 172, 229), new java.awt.Color(150, 172, 229), new java.awt.Color(150, 172, 229), new java.awt.Color(170, 172, 229)));
        setLayout(new java.awt.BorderLayout());

        pCentral.setBackground(new java.awt.Color(255, 255, 255));
        pCentral.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(150, 172, 229)));
        pCentral.setLayout(new java.awt.BorderLayout());

        margenSup.setOpaque(false);
        margenSup.setPreferredSize(new java.awt.Dimension(4, 5));

        javax.swing.GroupLayout margenSupLayout = new javax.swing.GroupLayout(margenSup);
        margenSup.setLayout(margenSupLayout);
        margenSupLayout.setHorizontalGroup(
            margenSupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 394, Short.MAX_VALUE)
        );
        margenSupLayout.setVerticalGroup(
            margenSupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );

        pCentral.add(margenSup, java.awt.BorderLayout.PAGE_START);

        margenInf.setOpaque(false);
        margenInf.setPreferredSize(new java.awt.Dimension(4, 5));

        javax.swing.GroupLayout margenInfLayout = new javax.swing.GroupLayout(margenInf);
        margenInf.setLayout(margenInfLayout);
        margenInfLayout.setHorizontalGroup(
            margenInfLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 394, Short.MAX_VALUE)
        );
        margenInfLayout.setVerticalGroup(
            margenInfLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );

        pCentral.add(margenInf, java.awt.BorderLayout.PAGE_END);

        margenDer.setOpaque(false);
        margenDer.setPreferredSize(new java.awt.Dimension(5, 139));

        javax.swing.GroupLayout margenDerLayout = new javax.swing.GroupLayout(margenDer);
        margenDer.setLayout(margenDerLayout);
        margenDerLayout.setHorizontalGroup(
            margenDerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );
        margenDerLayout.setVerticalGroup(
            margenDerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 234, Short.MAX_VALUE)
        );

        pCentral.add(margenDer, java.awt.BorderLayout.LINE_END);

        margenIzq.setOpaque(false);
        margenIzq.setPreferredSize(new java.awt.Dimension(5, 139));

        javax.swing.GroupLayout margenIzqLayout = new javax.swing.GroupLayout(margenIzq);
        margenIzq.setLayout(margenIzqLayout);
        margenIzqLayout.setHorizontalGroup(
            margenIzqLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );
        margenIzqLayout.setVerticalGroup(
            margenIzqLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 234, Short.MAX_VALUE)
        );

        pCentral.add(margenIzq, java.awt.BorderLayout.LINE_START);

        scroll.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        PanelScroll.setLayout(new javax.swing.BoxLayout(PanelScroll, javax.swing.BoxLayout.Y_AXIS));

        centro.setBackground(new java.awt.Color(255, 255, 255));
        centro.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(150, 172, 229), 2));
        centro.setLayout(new java.awt.BorderLayout());

        margenIzq2.setOpaque(false);
        margenIzq2.setPreferredSize(new java.awt.Dimension(5, 198));

        javax.swing.GroupLayout margenIzq2Layout = new javax.swing.GroupLayout(margenIzq2);
        margenIzq2.setLayout(margenIzq2Layout);
        margenIzq2Layout.setHorizontalGroup(
            margenIzq2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );
        margenIzq2Layout.setVerticalGroup(
            margenIzq2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 223, Short.MAX_VALUE)
        );

        centro.add(margenIzq2, java.awt.BorderLayout.WEST);

        centro2.setOpaque(false);
        centro2.setLayout(new java.awt.BorderLayout());

        infoMesaPedido.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        infoMesaPedido.setForeground(new java.awt.Color(80, 98, 143));
        infoMesaPedido.setText("Mesa 2, pedido 3465");
        infoMesaPedido.setPreferredSize(new java.awt.Dimension(96, 30));
        centro2.add(infoMesaPedido, java.awt.BorderLayout.NORTH);

        panelInfoPedido.setOpaque(false);
        panelInfoPedido.setLayout(new javax.swing.BoxLayout(panelInfoPedido, javax.swing.BoxLayout.Y_AXIS));

        jButton1.setText("jButton1");
        jButton1.setMaximumSize(new java.awt.Dimension(9987, 60));
        jButton1.setMinimumSize(new java.awt.Dimension(73, 60));
        panelInfoPedido.add(jButton1);

        centro2.add(panelInfoPedido, java.awt.BorderLayout.CENTER);

        centro.add(centro2, java.awt.BorderLayout.CENTER);

        margenDer2.setMinimumSize(new java.awt.Dimension(5, 0));
        margenDer2.setOpaque(false);
        margenDer2.setPreferredSize(new java.awt.Dimension(5, 198));

        javax.swing.GroupLayout margenDer2Layout = new javax.swing.GroupLayout(margenDer2);
        margenDer2.setLayout(margenDer2Layout);
        margenDer2Layout.setHorizontalGroup(
            margenDer2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );
        margenDer2Layout.setVerticalGroup(
            margenDer2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 223, Short.MAX_VALUE)
        );

        centro.add(margenDer2, java.awt.BorderLayout.EAST);

        MargenInf2.setOpaque(false);
        MargenInf2.setPreferredSize(new java.awt.Dimension(378, 5));

        javax.swing.GroupLayout MargenInf2Layout = new javax.swing.GroupLayout(MargenInf2);
        MargenInf2.setLayout(MargenInf2Layout);
        MargenInf2Layout.setHorizontalGroup(
            MargenInf2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 378, Short.MAX_VALUE)
        );
        MargenInf2Layout.setVerticalGroup(
            MargenInf2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );

        centro.add(MargenInf2, java.awt.BorderLayout.SOUTH);

        PanelScroll.add(centro);

        scroll.setViewportView(PanelScroll);

        pCentral.add(scroll, java.awt.BorderLayout.CENTER);

        add(pCentral, java.awt.BorderLayout.CENTER);

        pInf.setBackground(new java.awt.Color(255, 255, 255));
        pInf.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(150, 172, 229)));
        pInf.setPreferredSize(new java.awt.Dimension(396, 50));
        pInf.setLayout(new java.awt.BorderLayout());

        pendientes.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        pendientes.setForeground(new java.awt.Color(80, 98, 143));
        pendientes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pendientes.setText("7 bebidas pendientes ");
        pInf.add(pendientes, java.awt.BorderLayout.CENTER);

        add(pInf, java.awt.BorderLayout.SOUTH);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel MargenInf2;
    private javax.swing.JPanel PanelScroll;
    private javax.swing.JPanel centro;
    private javax.swing.JPanel centro2;
    private javax.swing.JLabel infoMesaPedido;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel margenDer;
    private javax.swing.JPanel margenDer2;
    private javax.swing.JPanel margenInf;
    private javax.swing.JPanel margenIzq;
    private javax.swing.JPanel margenIzq2;
    private javax.swing.JPanel margenSup;
    private javax.swing.JPanel pCentral;
    private javax.swing.JPanel pInf;
    private javax.swing.JPanel panelInfoPedido;
    private javax.swing.JLabel pendientes;
    private javax.swing.JScrollPane scroll;
    // End of variables declaration//GEN-END:variables

}
