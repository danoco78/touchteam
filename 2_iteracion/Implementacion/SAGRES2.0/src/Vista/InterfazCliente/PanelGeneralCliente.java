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
import GestionCarta.Seccion;
import java.awt.BasicStroke;
import java.awt.BorderLayout;
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
import javax.swing.JPanel;

/**
 *
 * @author Carlos
 */
public class PanelGeneralCliente extends javax.swing.JPanel {

    protected ICliente icliente;

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

    private PanelPedidoComida panelPedidoComida;

    int seccion; //Seccion que se muestra actualmente

    /** Creates new form PanelGeneralCliente */
    public PanelGeneralCliente() throws Exception {
        initComponents();
        this.setDoubleBuffered(true);
        cargarCarta();

        seccion=0; //Entrantes
        ((CardLayout) PanelHojas.getLayout()).show(PanelHojas, "Entrantes");
        this.PanelPaginaAnterior.setVisible(false);
        if(((CardLayout) hojasSeccionEntrantes.getLayout()).getHgap()<=1)
            this.PanelPaginaSiguiente.setVisible(false);
        
        i_entrantes=i_pescados=i_carnes=i_bebidas=i_postres=0;

        panelPedidoComida = new PanelPedidoComida();
        PanelPedido.add(panelPedidoComida, BorderLayout.CENTER);

    }

    @Override
    public void paint(Graphics g) {

        Graphics2D g2 = (Graphics2D) g.create();
        Rectangle clip = g2.getClipBounds();
        g2.setPaint(new GradientPaint(0.0f, 0.0f, new Color(170, 192, 249) ,getWidth() ,getHeight(), new Color(255, 255, 255) ));
        g2.fillRect(clip.x, clip.y, clip.width, clip.height);
        
        super.paint(g);

        g2.setStroke(new BasicStroke(3));
        g2.setColor(new Color(150, 172, 229));
        g2.drawLine(PanelCarta.getX()+(PanelCarta.getWidth()/2), PanelCarta.getY(),
                    PanelCarta.getX()+(PanelCarta.getWidth()/2), PanelCarta.getY()+PanelCarta.getHeight()-2);
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
        PanelGeneralEste = new javax.swing.JPanel();
        PanelPedido = new javax.swing.JPanel();
        PanelPedidoBebida = new javax.swing.JPanel();
        BotonVerFactura = new javax.swing.JButton();
        PanelGeneralCentro = new javax.swing.JPanel();
        PanelComentarios = new javax.swing.JPanel();
        ScrollComentarios = new javax.swing.JScrollPane();
        TextoComentarios = new javax.swing.JEditorPane();
        PanelCartaBotones = new javax.swing.JPanel();
        PanelCarta = new javax.swing.JPanel();
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

        setOpaque(false);
        setLayout(new java.awt.BorderLayout(10, 0));

        PanelGeneralEste.setOpaque(false);
        PanelGeneralEste.setPreferredSize(new java.awt.Dimension(200, 200));
        PanelGeneralEste.setLayout(new java.awt.BorderLayout(0, 5));

        PanelPedido.setOpaque(false);
        PanelPedido.setLayout(new java.awt.BorderLayout(0, 5));

        PanelPedidoBebida.setLayout(new java.awt.BorderLayout());
        PanelPedido.add(PanelPedidoBebida, java.awt.BorderLayout.PAGE_START);

        PanelGeneralEste.add(PanelPedido, java.awt.BorderLayout.CENTER);

        BotonVerFactura.setFont(new java.awt.Font("Arial", 1, 16));
        BotonVerFactura.setForeground(new java.awt.Color(80, 98, 143));
        BotonVerFactura.setText("Ver Factura");
        BotonVerFactura.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(150, 172, 229), 1, true));
        BotonVerFactura.setPreferredSize(new java.awt.Dimension(89, 50));
        PanelGeneralEste.add(BotonVerFactura, java.awt.BorderLayout.SOUTH);

        add(PanelGeneralEste, java.awt.BorderLayout.EAST);

        PanelGeneralCentro.setOpaque(false);
        PanelGeneralCentro.setLayout(new java.awt.BorderLayout(0, 5));

        PanelComentarios.setOpaque(false);
        PanelComentarios.setLayout(new java.awt.BorderLayout());

        TextoComentarios.setEnabled(false);
        TextoComentarios.setPreferredSize(new java.awt.Dimension(106, 50));
        ScrollComentarios.setViewportView(TextoComentarios);

        PanelComentarios.add(ScrollComentarios, java.awt.BorderLayout.CENTER);

        PanelGeneralCentro.add(PanelComentarios, java.awt.BorderLayout.PAGE_END);

        PanelCartaBotones.setOpaque(false);
        PanelCartaBotones.setLayout(new java.awt.BorderLayout(0, 5));

        PanelCarta.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(150, 172, 229), 3));
        PanelCarta.setOpaque(false);
        PanelCarta.setLayout(new java.awt.BorderLayout());

        PanelHojas.setBackground(new java.awt.Color(255, 255, 255));
        PanelHojas.setLayout(new java.awt.CardLayout(1, 1));
        PanelCarta.add(PanelHojas, java.awt.BorderLayout.CENTER);

        PanelPasarPaginas.setBackground(new java.awt.Color(255, 255, 255));
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
        PanelBotones.setLayout(new java.awt.GridLayout(0, 5));

        GrupoBotonesSecciones.add(BotonEntrantes);
        BotonEntrantes.setFont(new java.awt.Font("Arial", 1, 16));
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
        BotonPescados.setFont(new java.awt.Font("Arial", 1, 16));
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
        BotonCarnes.setFont(new java.awt.Font("Arial", 1, 16));
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
        BotonBebidas.setFont(new java.awt.Font("Arial", 1, 16));
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
        BotonPostres.setFont(new java.awt.Font("Arial", 1, 16));
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

        add(PanelGeneralCentro, java.awt.BorderLayout.CENTER);
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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton BotonBebidas;
    private javax.swing.JToggleButton BotonCarnes;
    private javax.swing.JToggleButton BotonEntrantes;
    private javax.swing.JToggleButton BotonPescados;
    private javax.swing.JToggleButton BotonPostres;
    private javax.swing.JButton BotonVerFactura;
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
    private javax.swing.JPanel PanelPedido;
    private javax.swing.JPanel PanelPedidoBebida;
    private javax.swing.JScrollPane ScrollComentarios;
    private javax.swing.JEditorPane TextoComentarios;
    // End of variables declaration//GEN-END:variables

    private void cargarCarta() throws Exception {
        
        //Cargamos las secciones
        //ArrayList<Seccion> listaSecciones = new ArrayList<Seccion>(this.icliente.obtieneSecciones());

        /*Iterator itSecciones = listaSecciones.iterator();

        while(itSecciones.hasNext()){
            Seccion s = (Seccion) itSecciones.next();
            HashSet<Elemento> listaElementos = icliente.obtieneElementosDeSeccion(s);
            Iterator it = listaElementos.iterator();
            HashSet<PanelHojasCarta> hojasSeccion = new HashSet();

            while(it.hasNext()){
                HashSet<Elemento> seisElementos = new HashSet();
                for(int i=0; i<6 && it.hasNext(); ++i){
                    seisElementos.add((Elemento) it.next());
                }
                hojasSeccion.add(new PanelHojasCarta(seisElementos));
            }

            /*if(s.getNombre().equals("Entrantes")){
                hojasSeccionEntrantes=hojasSeccion;
            }else if(s.getNombre().equals("Carnes")){
                hojasSeccionCarnes=hojasSeccion;
            }else if(s.getNombre().equals("Pescados")){
                hojasSeccionPescados=hojasSeccion;
            }else if(s.getNombre().equals("Bebidas")){
                hojasSeccionBebidas=hojasSeccion;
            }else if(s.getNombre().equals("Postres")){
                hojasSeccionPostres=hojasSeccion;
            }
        }*/
        
        HashSet<Elemento> listaElementos = new HashSet();
        listaElementos.add(new Elemento(10, "Descripcion 1", 4, null, "Entrante 1", (float) 23.00));
        listaElementos.add(new Elemento(20, "Descripcion 2", 4, null, "Entrante 2", (float) 43.00));
        listaElementos.add(new Elemento(30, "Descripcion 3", 4, null, "Entrante 3", (float) 30.50));
        listaElementos.add(new Elemento(40, "Descripcion 4", 4, null, "Entrante 4", (float) 50.50));
        listaElementos.add(new Elemento(50, "Descripcion 5", 4, null, "Entrante 5", (float) 30.50));
        listaElementos.add(new Elemento(60, "Descripcion 6", 4, null, "Entrante 6", (float) 23.50));
        listaElementos.add(new Elemento(70, "Descripcion 7", 4, null, "Entrante 7", (float) 30.50));
        listaElementos.add(new Elemento(80, "Descripcion 8", 4, null, "Entrante 8", (float) 23.50));


        //Inicializamos el JPanel correspondientes a la sección
        hojasSeccionEntrantes.setLayout(new CardLayout(listaElementos.size()+1/6,1));
        hojasSeccionEntrantes.setOpaque(false);
        
        Iterator it = listaElementos.iterator();

        while(it.hasNext()){
            int j=0;
            HashSet<Elemento> seisElementos = new HashSet();
            for(int i=0; i<6 && it.hasNext(); ++i){
                seisElementos.add((Elemento) it.next());
            }
            ++j;
            hojasSeccionEntrantes.add(new PanelHojasCarta(seisElementos,this),"Hoja"+Integer.toString(j));
        }


        listaElementos = new HashSet();
        listaElementos.add(new Elemento(10, "Descripcion 1", 4, null, "Pescado 1", (float) 23.00));
        listaElementos.add(new Elemento(20, "Descripcion 2", 4, null, "Pescado 2", (float) 43.00));


        //Inicializamos el JPanel correspondientes a la sección
        hojasSeccionPescados.setLayout(new CardLayout(listaElementos.size()/6+1,1));
        hojasSeccionPescados.setOpaque(false);

        it = listaElementos.iterator();

        while(it.hasNext()){
            int j=0;
            HashSet<Elemento> seisElementos = new HashSet();
            for(int i=0; i<6 && it.hasNext(); ++i){
                seisElementos.add((Elemento) it.next());
            }
            ++j;
            hojasSeccionPescados.add(new PanelHojasCarta(seisElementos,this),"Hoja"+Integer.toString(j));
        }

        listaElementos= new HashSet();

        //Inicializamos el JPanel correspondientes a la sección
        hojasSeccionCarnes.setLayout(new CardLayout(listaElementos.size()+1/6,1));
        hojasSeccionCarnes.setOpaque(false);
        //Inicializamos el JPanel correspondientes a la sección
        hojasSeccionBebidas.setLayout(new CardLayout(listaElementos.size()+1/6,1));
        hojasSeccionBebidas.setOpaque(false);
        //Inicializamos el JPanel correspondientes a la sección
        hojasSeccionPostres.setLayout(new CardLayout(listaElementos.size()+1/6,1));
        hojasSeccionPostres.setOpaque(false);

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

    public void anadirElementoAPedido(String nomElemento) {
        panelPedidoComida.anadirElemento(nomElemento);
    }

}
