/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * PanelGeneralCliente.java
 *
 * Created on 04-may-2010, 16:38:03
 */

package Vista.InterfazCliente;

import ControladorPrincipal.ICliente;
import GestionCarta.Elemento;
import GestionCarta.ElementoPlato;
import GestionCarta.Seccion;
import GestionPedidos.ElementoPedido;
import GestionPedidos.Factura;
import GestionPedidos.Pedido;
import Vista.DialogoConfirmacion;
import java.awt.BasicStroke;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import utilidades.HebraPedidosModificables;
import utilidades.Pair;

/**
 *
 * @author Carlos, modificado por Sergio
 */
public class PanelGeneralCliente extends javax.swing.JPanel {

    protected ICliente icliente;

    private InterfazCliente interfazCliente;
    private int codMesa;

    private JPanel hojasSeccionEntrantes = new JPanel();
    private int i_entrantes;
    private JPanel hojasSeccionPescados = new JPanel();
    private int i_pescados;
    private JPanel hojasSeccionCarnes = new JPanel();
    private int i_carnes;
    private JPanel hojasSeccionBebidas = new JPanel();
    private int i_bebidas;
    private JPanel hojasSeccionPostres = new JPanel();
    private int i_postres;

    private PanelRealizarPedido panelRealizarPedido;
    private PanelPedidoRealizado panelPedidoRealizado;

    int seccion; //Seccion que se muestra actualmente
    boolean pedidoRealizado;
    int numPedidosHechos;
    private Elemento elementoMarcado;

    private PanelElementoCarta panelElementoCarta;

    private HebraPedidosModificables hebra = new HebraPedidosModificables(this);

    /** Creates new form PanelGeneralCliente */
    public PanelGeneralCliente(InterfazCliente interfazCliente, ICliente icliente) throws Exception {
        initComponents();
        this.interfazCliente=interfazCliente;
        this.icliente=icliente;
        this.codMesa = 1;
        this.setDoubleBuffered(true);
        cargarCarta();
        
        this.seccion=0; //Entrantes
        ((CardLayout) PanelHojas.getLayout()).show(PanelHojas, "Entrantes");
        this.PanelPaginaAnterior.setVisible(false);
        if(((CardLayout) hojasSeccionEntrantes.getLayout()).getHgap()<=1)
            this.PanelPaginaSiguiente.setVisible(false);
        
        this.i_entrantes=i_pescados=i_carnes=i_bebidas=i_postres=0;

        this.panelRealizarPedido = new PanelRealizarPedido(this);
        this.PanelGeneralEste.add(panelRealizarPedido,"RealizarPedido");
        this.panelPedidoRealizado = new PanelPedidoRealizado(this, codMesa);
        this.PanelGeneralEste.add(panelPedidoRealizado,"PedidoRealizado");

        if(panelPedidoRealizado.actualizar()==0){
            ((CardLayout) PanelGeneralEste.getLayout()).show(PanelGeneralEste, "RealizarPedido");
            this.pedidoRealizado=false;
        }else{
            ((CardLayout) PanelGeneralEste.getLayout()).show(PanelGeneralEste, "PedidoRealizado");
            this.BotonAnadir.setVisible(false);
            this.pedidoRealizado=true;
        }

        this.elementoMarcado = null;
        numPedidosHechos = 0;

        this.hebra.start();
    }

    @Override
    public void paint(Graphics g) {

        Graphics2D g2 = (Graphics2D) g.create();
        Rectangle clip = g2.getClipBounds();
        g2.setPaint(new GradientPaint(0.0f, 0.0f, new Color(30, 40, 90) ,getWidth() ,getHeight(), new Color(155, 155, 200) ));
        g2.fillRect(clip.x, clip.y, clip.width, clip.height);
        
        super.paint(g);

        g2.setStroke(new BasicStroke(3));
        g2.setColor(new Color(150, 172, 229));
        g2.drawLine(PanelCarta.getX()+10+(PanelCarta.getWidth()/2), PanelCarta.getY() +12,
                    PanelCarta.getX()+10+(PanelCarta.getWidth()/2), PanelCarta.getY()+10+PanelCarta.getHeight()-2);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        GrupoBotonesSecciones = new javax.swing.ButtonGroup();
        pCentral = new javax.swing.JPanel();
        PanelGeneralCentro = new javax.swing.JPanel();
        PanelComentarios = new javax.swing.JPanel();
        ScrollComentarios = new javax.swing.JScrollPane();
        TextoComentarios = new javax.swing.JEditorPane();
        BotonAnadir = new javax.swing.JButton();
        PanelCartaBotones = new javax.swing.JPanel();
        PanelCarta = new PanelHojasLibro();
        PanelHojas = new javax.swing.JPanel();
        PanelPasarPaginas = new javax.swing.JPanel();
        PanelPaginaAnterior = new javax.swing.JPanel();
        LabelPaginaAnterior = new javax.swing.JLabel();
        PanelPaginaSiguiente = new javax.swing.JPanel();
        LabelPaginaSiguiente = new javax.swing.JLabel();
        PanelBotones = new javax.swing.JPanel();
        BotonEntrantes = new javax.swing.JToggleButton();
        BotonPescados = new javax.swing.JToggleButton();
        BotonCarnes = new javax.swing.JToggleButton();
        BotonBebidas = new javax.swing.JToggleButton();
        BotonPostres = new javax.swing.JToggleButton();
        PanelGeneralEste = new javax.swing.JPanel();
        pSup = new javax.swing.JPanel();
        pInf = new javax.swing.JPanel();
        pDer = new javax.swing.JPanel();
        pIzq = new javax.swing.JPanel();

        setOpaque(false);
        setLayout(new java.awt.BorderLayout());

        pCentral.setOpaque(false);
        pCentral.setLayout(new java.awt.BorderLayout(10, 0));

        PanelGeneralCentro.setOpaque(false);
        PanelGeneralCentro.setLayout(new java.awt.BorderLayout(0, 5));

        PanelComentarios.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(150, 172, 229), 3));
        PanelComentarios.setMinimumSize(new java.awt.Dimension(80, 100));
        PanelComentarios.setPreferredSize(new java.awt.Dimension(201, 150));
        PanelComentarios.setLayout(new java.awt.BorderLayout());

        ScrollComentarios.setBorder(null);
        ScrollComentarios.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        ScrollComentarios.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        TextoComentarios.setFont(new java.awt.Font("Tahoma", 0, 24));
        TextoComentarios.setEnabled(false);
        TextoComentarios.setPreferredSize(new java.awt.Dimension(106, 50));
        TextoComentarios.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TextoComentariosKeyTyped(evt);
            }
        });
        ScrollComentarios.setViewportView(TextoComentarios);

        PanelComentarios.add(ScrollComentarios, java.awt.BorderLayout.CENTER);

        BotonAnadir.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        BotonAnadir.setForeground(new java.awt.Color(80, 98, 143));
        BotonAnadir.setText("Añadir");
        BotonAnadir.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(150, 172, 229), 1, true));
        BotonAnadir.setPreferredSize(new java.awt.Dimension(89, 50));
        BotonAnadir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                anadirElementoAPedido(evt);
            }
        });
        PanelComentarios.add(BotonAnadir, java.awt.BorderLayout.EAST);

        PanelGeneralCentro.add(PanelComentarios, java.awt.BorderLayout.PAGE_END);

        PanelCartaBotones.setOpaque(false);
        PanelCartaBotones.setLayout(new java.awt.BorderLayout(0, 5));

        PanelCarta.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(150, 172, 229), 3));
        PanelCarta.setOpaque(false);
        PanelCarta.setLayout(new java.awt.BorderLayout());

        PanelHojas.setBackground(new java.awt.Color(255, 255, 255));
        PanelHojas.setOpaque(false);
        PanelHojas.setLayout(new java.awt.CardLayout(1, 1));
        PanelCarta.add(PanelHojas, java.awt.BorderLayout.CENTER);

        PanelPasarPaginas.setBackground(new java.awt.Color(255, 255, 255));
        PanelPasarPaginas.setOpaque(false);
        PanelPasarPaginas.setPreferredSize(new java.awt.Dimension(100, 50));
        PanelPasarPaginas.setLayout(new java.awt.BorderLayout());

        PanelPaginaAnterior.setLayout(new java.awt.BorderLayout());

        LabelPaginaAnterior.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/InterfazCliente/imagenes/paginaAnterior.png"))); // NOI18N
        LabelPaginaAnterior.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                paginaAnterior(evt);
            }
        });
        PanelPaginaAnterior.add(LabelPaginaAnterior, java.awt.BorderLayout.CENTER);

        PanelPasarPaginas.add(PanelPaginaAnterior, java.awt.BorderLayout.WEST);

        PanelPaginaSiguiente.setLayout(new java.awt.BorderLayout());

        LabelPaginaSiguiente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/InterfazCliente/imagenes/paginaSiguiente.png"))); // NOI18N
        LabelPaginaSiguiente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                paginaSiguiente(evt);
            }
        });
        PanelPaginaSiguiente.add(LabelPaginaSiguiente, java.awt.BorderLayout.CENTER);

        PanelPasarPaginas.add(PanelPaginaSiguiente, java.awt.BorderLayout.EAST);

        PanelCarta.add(PanelPasarPaginas, java.awt.BorderLayout.SOUTH);

        PanelCartaBotones.add(PanelCarta, java.awt.BorderLayout.CENTER);

        PanelBotones.setOpaque(false);
        PanelBotones.setPreferredSize(new java.awt.Dimension(395, 50));
        PanelBotones.setLayout(new java.awt.GridLayout(0, 5));

        GrupoBotonesSecciones.add(BotonEntrantes);
        BotonEntrantes.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        BotonEntrantes.setForeground(new java.awt.Color(80, 98, 143));
        BotonEntrantes.setSelected(true);
        BotonEntrantes.setText("Entrantes");
        BotonEntrantes.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(150, 172, 229), 1, true));
        BotonEntrantes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mostrarEntrantes(evt);
            }
        });
        PanelBotones.add(BotonEntrantes);

        GrupoBotonesSecciones.add(BotonPescados);
        BotonPescados.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        BotonPescados.setForeground(new java.awt.Color(80, 98, 143));
        BotonPescados.setText("Pescados");
        BotonPescados.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(150, 172, 229), 1, true));
        BotonPescados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mostrarPescados(evt);
            }
        });
        PanelBotones.add(BotonPescados);

        GrupoBotonesSecciones.add(BotonCarnes);
        BotonCarnes.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        BotonCarnes.setForeground(new java.awt.Color(80, 98, 143));
        BotonCarnes.setText("Carnes");
        BotonCarnes.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(150, 172, 229), 1, true));
        BotonCarnes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mostrarCarnes(evt);
            }
        });
        PanelBotones.add(BotonCarnes);

        GrupoBotonesSecciones.add(BotonBebidas);
        BotonBebidas.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        BotonBebidas.setForeground(new java.awt.Color(80, 98, 143));
        BotonBebidas.setText("Bebidas");
        BotonBebidas.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(150, 172, 229), 1, true));
        BotonBebidas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mostrarBebidas(evt);
            }
        });
        PanelBotones.add(BotonBebidas);

        GrupoBotonesSecciones.add(BotonPostres);
        BotonPostres.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        BotonPostres.setForeground(new java.awt.Color(80, 98, 143));
        BotonPostres.setText("Postres");
        BotonPostres.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(150, 172, 229), 1, true));
        BotonPostres.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mostrarPostres(evt);
            }
        });
        PanelBotones.add(BotonPostres);

        PanelCartaBotones.add(PanelBotones, java.awt.BorderLayout.SOUTH);

        PanelGeneralCentro.add(PanelCartaBotones, java.awt.BorderLayout.CENTER);

        pCentral.add(PanelGeneralCentro, java.awt.BorderLayout.CENTER);

        PanelGeneralEste.setOpaque(false);
        PanelGeneralEste.setPreferredSize(new java.awt.Dimension(200, 200));
        PanelGeneralEste.setLayout(new java.awt.CardLayout(2, 1));
        pCentral.add(PanelGeneralEste, java.awt.BorderLayout.EAST);

        add(pCentral, java.awt.BorderLayout.CENTER);

        pSup.setOpaque(false);
        add(pSup, java.awt.BorderLayout.NORTH);

        pInf.setOpaque(false);
        add(pInf, java.awt.BorderLayout.SOUTH);

        pDer.setOpaque(false);
        add(pDer, java.awt.BorderLayout.EAST);

        pIzq.setOpaque(false);
        add(pIzq, java.awt.BorderLayout.WEST);
    }// </editor-fold>//GEN-END:initComponents

    private void paginaSiguiente(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_paginaSiguiente
        switch(seccion){
            case 0: //Entrantes
                ((CardLayout) hojasSeccionEntrantes.getLayout()).next(hojasSeccionEntrantes);
                ++i_entrantes;
                this.PanelPaginaAnterior.setVisible(true);
                if(i_entrantes<((CardLayout) hojasSeccionEntrantes.getLayout()).getHgap())
                    this.PanelPaginaSiguiente.setVisible(false);
                break;
            case 1: //Pescados
                ((CardLayout) hojasSeccionPescados.getLayout()).next(hojasSeccionPescados);
                ++i_pescados;
                this.PanelPaginaAnterior.setVisible(true);
                if(i_pescados<((CardLayout) hojasSeccionPescados.getLayout()).getHgap())
                    this.PanelPaginaSiguiente.setVisible(false);
                break;
            case 2: //Carnes
                ((CardLayout) hojasSeccionCarnes.getLayout()).next(hojasSeccionCarnes);
                ++i_carnes;
                this.PanelPaginaAnterior.setVisible(true);
                if(i_carnes<((CardLayout) hojasSeccionCarnes.getLayout()).getHgap())
                    this.PanelPaginaSiguiente.setVisible(false);
                break;
            case 3: //Bebidas
                ((CardLayout) hojasSeccionBebidas.getLayout()).next(hojasSeccionBebidas);
                ++i_bebidas;
                this.PanelPaginaAnterior.setVisible(true);
                if(i_bebidas<((CardLayout) hojasSeccionBebidas.getLayout()).getHgap())
                    this.PanelPaginaSiguiente.setVisible(false);
                break;
            case 4: //Postres
                ((CardLayout) hojasSeccionPostres.getLayout()).next(hojasSeccionPostres);
                ++i_postres;
                this.PanelPaginaAnterior.setVisible(true);
                if(i_postres<((CardLayout) hojasSeccionPostres.getLayout()).getHgap())
                    this.PanelPaginaSiguiente.setVisible(false);
                break;

        }

        this.repaint();
    }//GEN-LAST:event_paginaSiguiente

    private void mostrarEntrantes(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mostrarEntrantes
        if(seccion!=0){
            seccion=0;
            ((CardLayout) PanelHojas.getLayout()).show(PanelHojas, "Entrantes");
            ((CardLayout) hojasSeccionEntrantes.getLayout()).first(hojasSeccionEntrantes);
            this.PanelPaginaAnterior.setVisible(false);
            if(((CardLayout) hojasSeccionEntrantes.getLayout()).getHgap()>1)
                this.PanelPaginaSiguiente.setVisible(true);
            else
                this.PanelPaginaSiguiente.setVisible(false);

            i_entrantes=0;

            this.repaint();
        }
    }//GEN-LAST:event_mostrarEntrantes

    private void mostrarPescados(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mostrarPescados
        if(seccion!=1){
            seccion=1;
            ((CardLayout) PanelHojas.getLayout()).show(PanelHojas, "Pescados");
            ((CardLayout) hojasSeccionPescados.getLayout()).first(hojasSeccionPescados);
            this.PanelPaginaAnterior.setVisible(false);
            if(((CardLayout) hojasSeccionPescados.getLayout()).getHgap()>1)
                this.PanelPaginaSiguiente.setVisible(true);
            else
                this.PanelPaginaSiguiente.setVisible(false);

            i_pescados=0;

            this.repaint();
        }
    }//GEN-LAST:event_mostrarPescados

    private void mostrarCarnes(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mostrarCarnes
        if(seccion!=2){
            seccion=2;
            ((CardLayout) PanelHojas.getLayout()).show(PanelHojas, "Carnes");
            ((CardLayout) hojasSeccionCarnes.getLayout()).first(hojasSeccionCarnes);
            this.PanelPaginaAnterior.setVisible(false);
            if(((CardLayout) hojasSeccionCarnes.getLayout()).getHgap()>1)
                this.PanelPaginaSiguiente.setVisible(true);
            else
                this.PanelPaginaSiguiente.setVisible(false);

            i_carnes=0;

            this.repaint();
        }
    }//GEN-LAST:event_mostrarCarnes

    private void mostrarBebidas(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mostrarBebidas
        if(seccion!=3){
            seccion=3;
            ((CardLayout) PanelHojas.getLayout()).show(PanelHojas, "Bebidas");
            ((CardLayout) hojasSeccionBebidas.getLayout()).first(hojasSeccionBebidas);
            this.PanelPaginaAnterior.setVisible(false);
            if(((CardLayout) hojasSeccionBebidas.getLayout()).getHgap()>1)
                this.PanelPaginaSiguiente.setVisible(true);
            else
                this.PanelPaginaSiguiente.setVisible(false);

            i_bebidas=0;

            this.repaint();
        }
    }//GEN-LAST:event_mostrarBebidas

    private void mostrarPostres(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mostrarPostres
        if(seccion!=4){
            seccion=4;
            ((CardLayout) PanelHojas.getLayout()).show(PanelHojas, "Postres");
            ((CardLayout) hojasSeccionPostres.getLayout()).first(hojasSeccionPostres);
            this.PanelPaginaAnterior.setVisible(false);
            if(((CardLayout) hojasSeccionPostres.getLayout()).getHgap()>1)
                this.PanelPaginaSiguiente.setVisible(true);
            else
                this.PanelPaginaSiguiente.setVisible(false);

            i_postres=0;

            this.repaint();
        }
    }//GEN-LAST:event_mostrarPostres

    private void paginaAnterior(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_paginaAnterior
        Iterator it;
        int i=0;

        switch(seccion){
            case 0: //Entrantes
                ((CardLayout) hojasSeccionEntrantes.getLayout()).previous(hojasSeccionEntrantes);
                --i_entrantes;
                this.PanelPaginaSiguiente.setVisible(true);
                if(i_entrantes<=0)
                    this.PanelPaginaAnterior.setVisible(false);
                break;
            case 1: //Pescados
                ((CardLayout) hojasSeccionPescados.getLayout()).previous(hojasSeccionPescados);
                --i_pescados;
                this.PanelPaginaSiguiente.setVisible(true);
                if(i_pescados<=0)
                    this.PanelPaginaAnterior.setVisible(false);
                break;
            case 2: //Carnes
                ((CardLayout) hojasSeccionCarnes.getLayout()).previous(hojasSeccionCarnes);
                --i_carnes;
                this.PanelPaginaSiguiente.setVisible(true);
                if(i_carnes<=0)
                    this.PanelPaginaAnterior.setVisible(false);
                break;
            case 3: //Bebidas
                ((CardLayout) hojasSeccionBebidas.getLayout()).previous(hojasSeccionBebidas);
                --i_bebidas;
                this.PanelPaginaSiguiente.setVisible(true);
                if(i_bebidas<=0)
                    this.PanelPaginaAnterior.setVisible(false);
                break;
            case 4: //Postres
                ((CardLayout) hojasSeccionPostres.getLayout()).previous(hojasSeccionPostres);
                --i_postres;
                this.PanelPaginaSiguiente.setVisible(true);
                if(i_postres<=0)
                    this.PanelPaginaAnterior.setVisible(false);
                break;

        }

        this.repaint();
    }//GEN-LAST:event_paginaAnterior

    private void anadirElementoAPedido(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_anadirElementoAPedido
        if(elementoMarcado!=null){
            if(this.TextoComentarios.getText().length()<=45){
                this.panelRealizarPedido.anadirElementoPedido(elementoMarcado, this.TextoComentarios.getText());
                this.TextoComentarios.setEnabled(false);
                this.TextoComentarios.setText("");
                this.desmarcarElemento();
                this.panelRealizarPedido.revalidate();
                this.panelRealizarPedido.repaint();
            }else{
                JOptionPane.showMessageDialog(this,
                                          "Debe añadir un comentario menor de 45 caracteres.",
                                          "El elemento no se ha añadido",
                                          JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }//GEN-LAST:event_anadirElementoAPedido

    private void TextoComentariosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TextoComentariosKeyTyped
        if(evt.getKeyChar() == '\n'){
            if(TextoComentarios.getText().length() > 0)
                TextoComentarios.setText(TextoComentarios.getText().substring(0, TextoComentarios.getText().length()-1));
            this.anadirElementoAPedido(new java.awt.event.ActionEvent(new Object(), 0, new String()));
        }
        if(this.TextoComentarios.getText().length() >= 44){
            TextoComentarios.setText(TextoComentarios.getText().substring(0, 44));
        }
    }//GEN-LAST:event_TextoComentariosKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotonAnadir;
    private javax.swing.JToggleButton BotonBebidas;
    private javax.swing.JToggleButton BotonCarnes;
    private javax.swing.JToggleButton BotonEntrantes;
    private javax.swing.JToggleButton BotonPescados;
    private javax.swing.JToggleButton BotonPostres;
    private javax.swing.ButtonGroup GrupoBotonesSecciones;
    private javax.swing.JLabel LabelPaginaAnterior;
    private javax.swing.JLabel LabelPaginaSiguiente;
    private javax.swing.JPanel PanelBotones;
    private javax.swing.JPanel PanelCarta;
    private javax.swing.JPanel PanelCartaBotones;
    private javax.swing.JPanel PanelComentarios;
    private javax.swing.JPanel PanelGeneralCentro;
    private javax.swing.JPanel PanelGeneralEste;
    private javax.swing.JPanel PanelHojas;
    private javax.swing.JPanel PanelPaginaAnterior;
    private javax.swing.JPanel PanelPaginaSiguiente;
    private javax.swing.JPanel PanelPasarPaginas;
    private javax.swing.JScrollPane ScrollComentarios;
    private javax.swing.JEditorPane TextoComentarios;
    private javax.swing.JPanel pCentral;
    private javax.swing.JPanel pDer;
    private javax.swing.JPanel pInf;
    private javax.swing.JPanel pIzq;
    private javax.swing.JPanel pSup;
    // End of variables declaration//GEN-END:variables

    private void cargarCarta() throws Exception {
        
        //Cargamos las secciones
        ArrayList<Seccion> listaSecciones = new ArrayList<Seccion>(this.icliente.obtieneSecciones());

        Iterator itSecciones = listaSecciones.iterator();

        HashSet<Elemento> listaBebidas = new HashSet();

        while(itSecciones.hasNext()){
            Seccion s = (Seccion) itSecciones.next();
            HashSet<Elemento> listaElementos = this.icliente.obtieneElementosDeSeccion(s);

            if(s.getNombre().equals("Entrantes")){
                hojasSeccionEntrantes.setLayout(new CardLayout(1,(listaElementos.size()+1)/6));
                hojasSeccionEntrantes.setOpaque(false);
            }else if(s.getNombre().equals("Pescados")){
                hojasSeccionPescados.setLayout(new CardLayout(1,(listaElementos.size()+1)/6));
                hojasSeccionPescados.setOpaque(false);
            }else if(s.getNombre().equals("Carnes")){
                hojasSeccionCarnes.setLayout(new CardLayout(1,(listaElementos.size()+1)/6));
                hojasSeccionCarnes.setOpaque(false);
            }else if(s.getNombre().equals("Refrescos") || s.getNombre().equals("Vinos")){
                //Juntamos las bebidas
                if(listaBebidas.size()==0){
                    listaBebidas.addAll(listaElementos);
                }else{
                    listaBebidas.addAll(listaElementos);
                    hojasSeccionBebidas.setLayout(new CardLayout(1,(listaBebidas.size()+1)/6));
                    hojasSeccionBebidas.setOpaque(false);
                }
            }else if(s.getNombre().equals("Postres")){
                hojasSeccionPostres.setLayout(new CardLayout(1,(listaElementos.size()+1)/6));
                hojasSeccionPostres.setOpaque(false);
            }

            Iterator itElementos = listaElementos.iterator();

            while(itElementos.hasNext()){
                int j=0;
                HashSet<Elemento> seisElementos = new HashSet();
                for(int i=0; i<6 && itElementos.hasNext(); ++i){
                    seisElementos.add((Elemento) itElementos.next());
                }
                ++j;

                if(s.getNombre().equals("Entrantes")){
                    hojasSeccionEntrantes.add(new PanelHojasCarta(seisElementos,this),"Hoja"+Integer.toString(j));
                }else if(s.getNombre().equals("Pescados")){
                    hojasSeccionPescados.add(new PanelHojasCarta(seisElementos,this),"Hoja"+Integer.toString(j));
                }else if(s.getNombre().equals("Carnes")){
                    hojasSeccionCarnes.add(new PanelHojasCarta(seisElementos,this),"Hoja"+Integer.toString(j));
                }else if(s.getNombre().equals("Postres")){
                    hojasSeccionPostres.add(new PanelHojasCarta(seisElementos,this),"Hoja"+Integer.toString(j));
                }
            }
        }

        //Añadimos las bebidas
        Iterator itBebidas = listaBebidas.iterator();

        while(itBebidas.hasNext()){
            int j=0;
            HashSet<Elemento> seisElementos = new HashSet();
            for(int i=0; i<6 && itBebidas.hasNext(); ++i){
                seisElementos.add((Elemento) itBebidas.next());
            }
            ++j;

            hojasSeccionBebidas.add(new PanelHojasCarta(seisElementos,this),"Hoja"+Integer.toString(j));
        }

        
        if(((CardLayout) hojasSeccionEntrantes.getLayout()).getHgap()>0)
            PanelHojas.add(hojasSeccionEntrantes,"Entrantes");
        else
            PanelHojas.add(new JLabel("No existen entrantes disponibles en este momento", JLabel.CENTER),"Entrantes");

        if(((CardLayout) hojasSeccionPescados.getLayout()).getHgap()>0)
            PanelHojas.add(hojasSeccionPescados,"Pescados");
        else
            PanelHojas.add(new JLabel("No existen pescados disponibles en este momento", JLabel.CENTER),"Pescados");

        if(((CardLayout) hojasSeccionCarnes.getLayout()).getHgap()>0)
            PanelHojas.add(hojasSeccionCarnes,"Carnes");
        else
            PanelHojas.add(new JLabel("No existen carnes disponibles en este momento", JLabel.CENTER),"Carnes");

        if(((CardLayout) hojasSeccionBebidas.getLayout()).getHgap()>0)
            PanelHojas.add(hojasSeccionBebidas,"Bebidas");
        else{
            PanelHojas.add(new JLabel("No existen bebidas disponibles en este momento", JLabel.CENTER),"Bebidas");
        }

        if(((CardLayout) hojasSeccionPostres.getLayout()).getHgap()>0)
            PanelHojas.add(hojasSeccionPostres,"Postres");
        else
            PanelHojas.add(new JLabel("No existen postres disponibles en este momento", JLabel.CENTER),"Postres");
    }

    public void marcarElemento(PanelElementoCarta panelElementoCarta) {
        this.elementoMarcado = panelElementoCarta.getElemento();
        this.TextoComentarios.setEnabled(true);

        if(this.panelElementoCarta!=null){
            this.panelElementoCarta.desmarcar();
        }
        this.panelElementoCarta=panelElementoCarta;
        this.panelElementoCarta.marcar();
    }

    public void desmarcarElemento() {
        this.TextoComentarios.setEnabled(false);
        this.elementoMarcado=null;
        this.panelElementoCarta.desmarcar();
        this.panelElementoCarta=null;
        if(this.panelRealizarPedido.vacio()){
            this.pedidoRealizado=true;
            this.cambiarPanelEste();
        }
    }

    public void realizarPedido() {
        if(this.panelRealizarPedido.getNumElementos()>0){
            ArrayList<Pair<Elemento, String> > elementosComentarios = this.panelRealizarPedido.getElementosComentarios();
            String listaComida = "PLATOS:";
            String listaBebida = "BEBIDAS:";

            Iterator it = elementosComentarios.iterator();
            while(it.hasNext()){
                Pair<Elemento, String> par = (Pair<Elemento, String>) it.next();
                Elemento elemento = par.getFirst();

                if(elemento instanceof ElementoPlato){
                    listaComida=listaComida.concat("\n- "+elemento.getNombre());
                }else{
                    listaBebida=listaBebida.concat("\n- "+elemento.getNombre());
                }
            }

            String listaTotal = "¿Está seguro de que ha terminado de seleccionar los elementos de su pedido?\n\n"
                                +listaComida
                                +"\n\n"
                                +listaBebida
                                +"\n\nSiempre puede añadir nuevos pedidos más tarde";
            
            DialogoConfirmacion dialogo = new DialogoConfirmacion(interfazCliente,
                    "Realizar Pedido",
                    "",
                    listaTotal);

            dialogo.setLocationRelativeTo(interfazCliente);
            dialogo.setVisible(true);

            if(dialogo.isAceptado()){
                this.TextoComentarios.setText("");
                this.TextoComentarios.setEnabled(false);

                ArrayList<Elemento> listaElementos = new ArrayList();

                it = elementosComentarios.iterator();
                while(it.hasNext()){
                    Pair<Elemento, String> par = (Pair<Elemento, String>) it.next();
                    Elemento elemento = par.getFirst();
                    listaElementos.add(elemento);
                }

                int codPedidoActivo=this.panelRealizarPedido.getCodPedidoActivo();

                if(codPedidoActivo==-1){
                    this.icliente.nuevoPedido(this.codMesa, elementosComentarios);
                }else{
                    this.icliente.modificaPedido(codPedidoActivo, this.codMesa, elementosComentarios);
                }
                
                this.panelPedidoRealizado.actualizar();

                this.elementoMarcado=null;
                this.panelRealizarPedido.limpiar();
                this.pedidoRealizado=true;
                this.incrementarNumPedidos();
                
                this.cambiarPanelEste();
            }
        }else{
            JOptionPane.showMessageDialog(this,
                              "Debe añadir, al menos, un elemento.",
                              "El pedido no puede ser realizado",
                              JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void cambiarPanelEste() {
        ((CardLayout) PanelGeneralEste.getLayout()).next(PanelGeneralEste);
        this.BotonAnadir.setVisible(!this.BotonAnadir.isVisible());
    }

    public void iniciaModificaPedido(int codPedido) {
        DialogoConfirmacion dialogo = new DialogoConfirmacion(interfazCliente,
                    "Modificar Pedido",                    
                    "¿Está seguro de que desea modificar su pedido?"
                    ,"\nEsto lo anulará y cuando termine se enviará como uno nuevo.");

        dialogo.setLocationRelativeTo(interfazCliente);
        dialogo.setVisible(true);

        if(dialogo.isAceptado()){
            ArrayList<Pedido> listaPedidos = this.icliente.obtienePedidosMesa(codMesa);

            Pedido pedido = null;
            Iterator it = listaPedidos.iterator();
            while(it.hasNext() && pedido==null){
                Pedido aux = (Pedido) it.next();
                if(aux.getCodPedido()==codPedido){
                    pedido=aux;
                }
            }

            ArrayList<ElementoPedido> elementosPedido = pedido.obtieneElementos();
            it = elementosPedido.iterator();
            while(it.hasNext()){
                ElementoPedido elemPed = (ElementoPedido) it.next();
                elementoMarcado=elemPed.getElemento();
                this.panelRealizarPedido.anadirElementoPedido(elementoMarcado, elemPed.getComentario());
                this.TextoComentarios.setEnabled(false);
                this.TextoComentarios.setText("");
                this.panelRealizarPedido.repaint();
                this.panelRealizarPedido.revalidate();
            }

            this.elementoMarcado=null;
            //this.panelRealizarPedido.setPedidoActivo(codPedido);
            this.pedidoRealizado=false;
            this.cambiarPanelEste();
            this.icliente.eliminaPedido(codPedido);
        }
    }

    /**
     * Elimina un pedido del sistema
     * @param codPedido Pedido a eliminar
     */
    public void eliminarPedido(int codPedido) {
        //if(modificando){
        //DialogoConfirmacion dialogo = new DialogoConfirmacion(interfazCliente,
        //            "Eliminar Pedido",
        //            "¿Está seguro de que desea eliminar su pedido?",
        //            "Se borrará el pedido de su lista pedidos.\n" +
        //            "Recuerde que siempre podrá realizar otros despues.");

        //dialogo.setLocationRelativeTo(interfazCliente);
        //dialogo.setVisible(true);

        //if(dialogo.isAceptado()){
        this.icliente.eliminaPedido(codPedido);
        this.panelPedidoRealizado.actualizar();
        this.cambiarPanelEste();
        //}
        //}//else{
        //        this.icliente.eliminaPedido(codPedido);
        //        this.panelPedidoRealizado.actualizar();
        //        this.cambiarPanelEste();
        //}
    }

    public void verFactura() {
        Factura f = this.icliente.pideFactura(codMesa);
        ArrayList<Pedido> listaPedidos = f.getPedidos();

        String cuenta="";
        Double total = 0.0;
        int numPedido = 1;
        Iterator itPedidos = listaPedidos.iterator();
        while(itPedidos.hasNext()){
            Pedido pedido = (Pedido) itPedidos.next();
            cuenta=cuenta.concat("PEDIDO "+numPedido+"\n\n");
            ArrayList<ElementoPedido> listaElementosPedido = pedido.getElementos();
            Iterator itElementosPedido = listaElementosPedido.iterator();
            while(itElementosPedido.hasNext()){
                ElementoPedido elemPed = (ElementoPedido) itElementosPedido.next();
                cuenta = cuenta.concat(elemPed.getElemento().getNombre()+" "+elemPed.getElemento().getPrecio()+"€\n");
                total+=elemPed.getElemento().getPrecio();
            }
            cuenta=cuenta.concat("\n");
            numPedido++;
        }

        cuenta=cuenta.concat("\nTOTAL: "+total+"€");

        DialogoConfirmacion dialogo = new DialogoConfirmacion(interfazCliente,
                    "Ver Factura",
                    "Quedó registrada la siguiente factura:",
                    cuenta);

        dialogo.setLocationRelativeTo(interfazCliente);
        dialogo.setVisible(true);
    }

    public void comprobarPedidos() {
        this.panelPedidoRealizado.actualizar();
    }

    void marcarCampoDeTexto() {
        this.TextoComentarios.requestFocusInWindow();
    }

    /**
     * Obtiene el estado de un pedido de la mesa al que pertenece el panel general
     * @param codpedido Pedido del que obtiene el estado
     * @return int con el estado, -1 si el pedido no se ha encontrado
     */
    Integer obtieneEstadoPedido(int codpedido){
        ArrayList<Pedido> pedidosMesa = this.icliente.obtienePedidosMesa(codMesa);
        Iterator<Pedido> it = pedidosMesa.iterator();
        Pedido ped;
        boolean encontrado = false;
        Integer estado = -1;

        while(it.hasNext() && !encontrado){
            ped = it.next();
            if(ped.getCodPedido().equals(codpedido)){
                estado = ped.getEstado();
                encontrado = true;
            }
        }
        return estado;
    }
    void incrementarNumPedidos(){
        ++numPedidosHechos;
    }

    void decrementarNumPedidos(){
        --numPedidosHechos;
    }

    public void volverAlInicio(){
        if(numPedidosHechos > 0){
            this.interfazCliente.terminar();
        }
    }
}
