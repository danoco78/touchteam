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

import GestionCarta.Elemento;
import GestionPedidos.ElementoColaBar;
import GestionPedidos.ElementoColaCocina;
import GestionPedidos.ElementoPedido;
import GestionPedidos.Pedido;
import Vista.DialogoConfirmacion;
import Vista.InterfazCocinero.IntColaCocinero;
import Vista.InterfazMetre.IntColaBar;
import java.awt.Rectangle;
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

    Pedido pedActual = null;
    int filtro;
    int numPendientes;
    IntColaBar mpadre;
    IntColaCocinero cpadre;
    
    public static final int COCINA = 0;
    public static final int BAR = 1;

    
    /** Creates new form PanelMesaPedido */
    public PanelMesaPedido(IntColaBar i) {
        initComponents();
        filtro = BAR;
        mpadre = i;
    }

    public PanelMesaPedido(IntColaCocinero i) {
        initComponents();
        filtro = COCINA;
        cpadre = i;
    }

    public void actualizar(Pedido ped){
        pedActual = ped;

        panelInfoPedido.removeAll();
        //panelInfoPedido.repaint();
        if(ped == null){
            infoMesaPedido.setText("");
        }else{
            infoMesaPedido.setText("Mesa "+String.valueOf(pedActual.getCodMesa())+", pedido "+String.valueOf(pedActual.getCodPedido()));

            ArrayList<ElementoPedido> lista = pedActual.obtieneElementos();
            JButton boton;
            Elemento ele;

            numPendientes = 0;
            for (int i = 0; i < lista.size(); ++i) {
                if ((filtro == BAR && lista.get(i) instanceof ElementoColaBar && lista.get(i).getEstado() == ElementoColaBar.ENCOLA)
                        || (filtro == COCINA && lista.get(i) instanceof ElementoColaCocina && lista.get(i).getEstado() == ElementoColaCocina.ENCOLA)) {
                    boton = new JButton();
                    ele = lista.get(i).getElemento();

                    boton.setBackground(new java.awt.Color(211, 223, 253));
                    boton.setFont(new java.awt.Font("Arial", 0, 18));
                    boton.setForeground(new java.awt.Color(80, 98, 143));
                    String Datos = lista.get(i).getComentario();
                    int cols;
                    Rectangle rect = panelInfoPedido.getBounds();
                    cols = (int)rect.getWidth()/(boton.getFont().getSize());
                    String dats = "";
                    int count=1;
                    //if(Datos.length() > cols){
                    for(int j=0; j<Datos.length(); ++j){
                        dats = dats+String.valueOf(Datos.charAt(j));
                        if(count > cols && (Datos.charAt(j)==' ' || Datos.charAt(j)=='\n')){
                            dats = dats+"<br>";
                            count = 0;
                        }
                        ++count;
                    }
                    boton.setText("<html><body>" + ele.getNombre() + " <br><font color=\"#000000\">" + dats + "</font><br></body></html>");
                    boton.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
                    boton.setFocusPainted(false);
                    boton.setName(String.valueOf(i));
                    if (filtro == BAR)
                        boton.addActionListener(new ManejaEventos(boton));
                    else
                        boton.addActionListener(new ManejaEventos(boton));

                    panelInfoPedido.add(boton);
                    panelInfoPedido.add(new PanelEspacioVertical());
                    numPendientes++;
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

        infoMesaPedido.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
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

        pendientes.setFont(new java.awt.Font("Arial", 0, 18));
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
        boolean borrar;

        public ManejaEventos(JButton b){
            boton = b;
        }

        public void actionPerformed(ActionEvent e) {
            borrar = false;
            switch(filtro){
                case PanelMesaPedido.BAR:
                    // TODO Modificar seleccion de elemento
                    if (numPendientes == 1){
                        String texto = new String();
                        ArrayList<ElementoPedido> elems = pedActual.obtieneElementos();
                        for (int i=0;i<elems.size();i++){
                            if (elems.get(i) instanceof ElementoColaBar)
                                texto += elems.get(i).getElemento().getNombre()+"\n";
                        }
                        DialogoConfirmacion confirmar = new DialogoConfirmacion(mpadre.imetre,"Cerrar pedido de bebidas", "¿Está seguro de que desea cerrar las bebidas de este pedido?",texto);
                        confirmar.setLocationRelativeTo(mpadre);
                        confirmar.setVisible(true);
                        if(confirmar.isAceptado())
                            borrar = true;
                    }
                    else
                        borrar = true;
                    
                    try {
                        if (borrar){
                            ElementoColaBar eleB = (ElementoColaBar) pedActual.obtieneElementos().get(Integer.parseInt(boton.getName()));
                            mpadre.imetre.imetre.seleccionaBebida(pedActual, eleB);
                            //num = mpadre.imetre.getNumBebidasEnCola();
                            mpadre.imetre.hebra.actualizaBebidasPendientes();
                            numPendientes--;
                        }
                    } catch (Exception ex) {
                        Logger.getLogger(PanelMesaPedido.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
                case PanelMesaPedido.COCINA:
                    try {
                        // TODO Modificar seleccion de elemento
                        ElementoColaCocina eleC = (ElementoColaCocina) pedActual.obtieneElementos().get(Integer.parseInt(boton.getName()));
                        cpadre.icocinero.icocinero.seleccionaPlato(pedActual, eleC);
                        //num = cpadre.icocinero.getNumPlatosEnCola();
                        cpadre.icocinero.hebra.actualizaPlatosPendientes();
                        borrar = true;
                        cpadre.icocinero.panelColaCocinero.actualizarVista(pedActual,eleC);
                        numPendientes--;

                    } catch (Exception ex) {
                        Logger.getLogger(PanelMesaPedido.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
            }

            if (borrar){
                //panelInfoPedido.remove(boton);
                //panelInfoPedido.repaint();
                //panelInfoPedido.revalidate();
                //if (numPendientes == 0){
                //    infoMesaPedido.setText("");
                    if (filtro == PanelMesaPedido.BAR)
                        mpadre.imetre.hebra.actualizaColaBar();
                    else
                        cpadre.icocinero.hebra.actualizaColaCocina();
                //}
                //setPendientes(num);

            }
        }
    }
}
