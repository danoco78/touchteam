/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * PanelMesaPedido.java
 *
 * Created on 05-may-2010, 19:04:58
 */

package utilidades;

import ControladorPrincipal.ICocinero;
import ControladorPrincipal.IMetre;
import GestionPedidos.ElementoColaBar;
import GestionPedidos.ElementoColaCocina;
import GestionPedidos.ElementoPedido;
import GestionPedidos.Pedido;
import Vista.DialogoConfirmacion;
import Vista.InterfazCocinero.InterfazCocinero;
import Vista.InterfazMetre.IntColaBar;
import Vista.InterfazMetre.InterfazMetre;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;

/**
 *
 * @author Samuel Guirado Navarro
 */
public class PanelMesaPedido extends javax.swing.JPanel {

    Pedido pedActual;
    int filtro;
    int numElementosPendientes;
    IntColaBar mpadre;
    ICocinero icocinero;
    IMetre imetre;
    InterfazCocinero ventanaCocinero;
    InterfazMetre ventanaMetre;
    
    public static final int COCINA = 0;
    public static final int BAR = 1;

    
    /** Creates new form PanelMesaPedido */
    public PanelMesaPedido(IMetre imetre, InterfazMetre ventana) {
        initComponents();
        filtro = BAR;
        this.imetre = imetre;
        this.ventanaMetre = ventana;
        pedActual = null;
    }

    public PanelMesaPedido(ICocinero icocinero, InterfazCocinero ventana) {
        initComponents();
        filtro = COCINA;
        this.icocinero = icocinero;
        this.ventanaCocinero = ventana;
        pedActual = null;
    }

    /**
     * Limpia el panel y pone el pedido que corresponde, si es necesario
     */
    public void actualizar(){
        if(filtro == COCINA){
            try {
                Pedido siguientePedidoCocinaEnCola = icocinero.getSiguientePedidoCocinaEnCola();
                this.setPendientes(icocinero.getNumPlatosEnCola());
                this.centro.setVisible(true);

                // Comprobar si ha cambiado el pedido
                // O bien uno es nulo y otro no
                // o ninguno es nulo y sin distintos
                if((pedActual == null && siguientePedidoCocinaEnCola != null) ||
                        (siguientePedidoCocinaEnCola == null && pedActual != null) ||
                        (pedActual != null && siguientePedidoCocinaEnCola != null &&
                        true // TODO !pedActual.equals(siguientePedidoCocinaEnCola)
                        ) ){
                    this.cambiarPedido(siguientePedidoCocinaEnCola);
                }else{
                    System.gc();
                }
            } catch (Exception ex) {
                this.centro.setVisible(false);
                this.setPendientes(0);
            }
        }else if(filtro == BAR){
            try {
                Pedido siguientePedidoBar = this.imetre.getSiguientePedidoBar();
                this.setPendientes(imetre.getNumBebidasEnCola());
                this.centro.setVisible(true);

                // Comprobar si ha cambiado el pedido
                // Comprobar si ha cambiado el pedido
                // O bien uno es nulo y otro no
                // o ninguno es nulo y sin distintos
                if((pedActual == null && siguientePedidoBar != null) ||
                        (siguientePedidoBar == null && pedActual != null) ||
                        (pedActual != null && siguientePedidoBar != null &&
                        !pedActual.equals(siguientePedidoBar)) ){
                    this.cambiarPedido(siguientePedidoBar);
                }else
                    System.gc();
            } catch (Exception ex) {
                this.centro.setVisible(false);
                this.setPendientes(0);
            }
        }
    }

    /**
     * Cambia el pedido que se muestra en el panel
     * @param ped pedido que se muestra
     */
    private void cambiarPedido(Pedido ped){
        pedActual = ped;
        panelInfoPedido.removeAll();
        //panelInfoPedido.repaint();
        if(ped == null){
            infoMesaPedido.setText("");
            this.centro.setVisible(false);
        }else{
            infoMesaPedido.setText("Mesa "+String.valueOf(pedActual.getCodMesa())+", pedido "+String.valueOf(pedActual.getCodPedido()));

            ArrayList<ElementoPedido> lista = pedActual.obtieneElementos();
            BotonElementoPedidoComentario boton;

            for (int i = 0; i < lista.size(); ++i) {
                if ((filtro == BAR && lista.get(i) instanceof ElementoColaBar && lista.get(i).getEstado() == ElementoColaBar.ENCOLA)
                        || (filtro == COCINA && lista.get(i) instanceof ElementoColaCocina && lista.get(i).getEstado() == ElementoColaCocina.ENCOLA)) {
                    boton = new BotonElementoPedidoComentario(lista.get(i));
                    boton.setName(String.valueOf(i));
                    boton.addActionListener(new ManejaEventos(boton));

                    panelInfoPedido.add(boton);
                    panelInfoPedido.add(new PanelEspacioVertical());
                }
            }
        }
        panelInfoPedido.repaint();
        panelInfoPedido.revalidate();
    }

    /**
     * Elimina de la vista el pedido que se está mostrando
     */
    public void borrarPedido(){
        panelInfoPedido.removeAll();
        panelInfoPedido.repaint();
        panelInfoPedido.revalidate();
        pedActual = null;
    }

    /**
     * Modifica el mensaje de texto de la base. Es necesario decirle la cantidad por parametros,
     * puesto que se obtiene de una consulta
     * @param mensaje Texto a mostrar. <br>Siempre sigue el formato [num] platos pendientes, para el caso de platos.
     */
    public void setPendientes(int num){
        switch (filtro){
            case PanelMesaPedido.COCINA:
                 switch(num){
                    case 0:
                        pendientes.setText("No hay ningún plato pendiente");
                        break;
                    case 1:
                        pendientes.setText("Hay "+ num + " plato pendiente.");
                        break;
                    default:
                        pendientes.setText("Hay "+ num+ " platos pendientes.");
                        break;
                }
                break;
            case PanelMesaPedido.BAR:
                switch(num){
                    case 0:
                        pendientes.setText("No hay ninguna bebida pendiente");
                        break;
                    case 1:
                        pendientes.setText("Hay "+ num + " bebida pendiente.");
                        break;
                    default:
                        pendientes.setText("Hay "+ num+ " bebidas pendientes.");
                        break;
                }
                break;
        }
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
        centro = new javax.swing.JPanel();
        margenIzq2 = new javax.swing.JPanel();
        centro2 = new javax.swing.JPanel();
        infoMesaPedido = new javax.swing.JLabel();
        scroll = new javax.swing.JScrollPane();
        panelInfoPedido = new javax.swing.JPanel();
        margenDer2 = new javax.swing.JPanel();
        margenInf2 = new javax.swing.JPanel();
        pInf = new javax.swing.JPanel();
        pendientes = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, new java.awt.Color(150, 172, 229), new java.awt.Color(150, 172, 229), new java.awt.Color(150, 172, 229), new java.awt.Color(170, 172, 229)));
        setLayout(new java.awt.BorderLayout());

        pCentral.setBackground(new java.awt.Color(255, 255, 255));
        pCentral.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(150, 172, 229)));
        pCentral.setLayout(new java.awt.BorderLayout());

        margenSup.setOpaque(false);
        margenSup.setPreferredSize(new java.awt.Dimension(394, 5));

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
        margenInf.setPreferredSize(new java.awt.Dimension(394, 5));

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

        centro.setBackground(new java.awt.Color(235, 235, 255));
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
            .addGap(0, 225, Short.MAX_VALUE)
        );

        centro.add(margenIzq2, java.awt.BorderLayout.WEST);

        centro2.setBackground(new java.awt.Color(255, 255, 255));
        centro2.setOpaque(false);
        centro2.setLayout(new java.awt.BorderLayout());

        infoMesaPedido.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        infoMesaPedido.setForeground(new java.awt.Color(80, 98, 143));
        infoMesaPedido.setDoubleBuffered(true);
        infoMesaPedido.setPreferredSize(new java.awt.Dimension(96, 30));
        centro2.add(infoMesaPedido, java.awt.BorderLayout.NORTH);

        scroll.setBorder(null);
        scroll.setDoubleBuffered(true);
        scroll.setOpaque(false);

        panelInfoPedido.setBackground(new java.awt.Color(235, 235, 255));
        panelInfoPedido.setLayout(new javax.swing.BoxLayout(panelInfoPedido, javax.swing.BoxLayout.Y_AXIS));
        scroll.setViewportView(panelInfoPedido);

        centro2.add(scroll, java.awt.BorderLayout.CENTER);

        centro.add(centro2, java.awt.BorderLayout.CENTER);

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
            .addGap(0, 225, Short.MAX_VALUE)
        );

        centro.add(margenDer2, java.awt.BorderLayout.EAST);

        margenInf2.setOpaque(false);
        margenInf2.setPreferredSize(new java.awt.Dimension(378, 5));

        javax.swing.GroupLayout margenInf2Layout = new javax.swing.GroupLayout(margenInf2);
        margenInf2.setLayout(margenInf2Layout);
        margenInf2Layout.setHorizontalGroup(
            margenInf2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 380, Short.MAX_VALUE)
        );
        margenInf2Layout.setVerticalGroup(
            margenInf2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );

        centro.add(margenInf2, java.awt.BorderLayout.SOUTH);

        pCentral.add(centro, java.awt.BorderLayout.CENTER);

        add(pCentral, java.awt.BorderLayout.CENTER);

        pInf.setBackground(new java.awt.Color(255, 255, 255));
        pInf.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(150, 172, 229)));
        pInf.setPreferredSize(new java.awt.Dimension(396, 50));
        pInf.setLayout(new java.awt.BorderLayout());

        pendientes.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        pendientes.setForeground(new java.awt.Color(80, 98, 143));
        pendientes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pendientes.setDoubleBuffered(true);
        pInf.add(pendientes, java.awt.BorderLayout.CENTER);

        add(pInf, java.awt.BorderLayout.SOUTH);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel centro;
    private javax.swing.JPanel centro2;
    private javax.swing.JLabel infoMesaPedido;
    private javax.swing.JPanel margenDer;
    private javax.swing.JPanel margenDer2;
    private javax.swing.JPanel margenInf;
    private javax.swing.JPanel margenInf2;
    private javax.swing.JPanel margenIzq;
    private javax.swing.JPanel margenIzq2;
    private javax.swing.JPanel margenSup;
    private javax.swing.JPanel pCentral;
    private javax.swing.JPanel pInf;
    private javax.swing.JPanel panelInfoPedido;
    private javax.swing.JLabel pendientes;
    private javax.swing.JScrollPane scroll;
    // End of variables declaration//GEN-END:variables

    private class ManejaEventos implements ActionListener{

        JButton boton;
        int num;

        public ManejaEventos(JButton b){
            boton = b;
        }

        public void actionPerformed(ActionEvent e) {
            boolean borrar = false;
            switch(filtro){
                case PanelMesaPedido.BAR:
                    if (numElementosPendientes == 1){
                        String texto = "Elementos que va a confirmar:\n";
                        ArrayList<ElementoPedido> elems = pedActual.obtieneElementos();
                        for (int i=0;i<elems.size();i++){
                            if (elems.get(i) instanceof ElementoColaBar)
                                texto += "- "+elems.get(i).getElemento().getNombre()+"\n";
                        }
                        DialogoConfirmacion confirmar = new DialogoConfirmacion(ventanaMetre,"Cerrar pedido de bebidas", "¿Está seguro de que desea cerrar las bebidas de este pedido?",texto);
                        confirmar.setLocationRelativeTo(mpadre);
                        confirmar.setVisible(true);
                        if(confirmar.isAceptado())
                            borrar = true;
                    }else // No es el ultimo elemento pendiente
                        borrar = true;
                    
                    try {
                        if (borrar){
                            ElementoColaBar eleB = (ElementoColaBar) pedActual.obtieneElementos().get(Integer.parseInt(boton.getName()));
                            boolean seleccionaBebida = imetre.seleccionaBebida(pedActual, eleB);
                            if(!seleccionaBebida){
                                System.err.println("Se ha seleccionado una bebida erronea, bebida "+
                                        boton.getName()+ " del pedido "+pedActual.getCodPedido());
                            }else{
                                eleB.setEstado(ElementoColaBar.PREPARADO);
                            }
                            numElementosPendientes--;
                        }
                    } catch (Exception ex) {
                        Logger.getLogger(PanelMesaPedido.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    break;
                case PanelMesaPedido.COCINA:
                    try {
                        ElementoColaCocina eleC = (ElementoColaCocina) pedActual.obtieneElementos().get(Integer.parseInt(boton.getName()));
                        boolean seleccionaPlato = icocinero.seleccionaPlato(pedActual, eleC);
                        if(!seleccionaPlato){
                            System.err.println("Se ha seleccionado un plato erronea, plato "+
                                    boton.getName()+ " del pedido "+pedActual.getCodPedido());
                        }else{
                            eleC.setEstado(ElementoColaCocina.PREPARADO);
                        }
                        numElementosPendientes--;
                        borrar = true;
                    } catch (Exception ex) {
                        Logger.getLogger(PanelMesaPedido.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
            }

            if (borrar){
                actualizar();
            }
        }
    }
}
