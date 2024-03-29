/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * PanelPedidoRealizado.java
 *
 * Created on 09-may-2010, 17:33:28
 */

package Vista.InterfazCliente;

import GestionCarta.Elemento;
import GestionPedidos.ElementoPedido;
import GestionPedidos.Pedido;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/**
 *
 * @author Carlos
 */
public class PanelPedidoRealizado extends javax.swing.JPanel {

    PanelGeneralCliente panelGeneralCliente;
    private int codMesa;
    /** Creates new form PanelPedidoRealizado */
    public PanelPedidoRealizado(PanelGeneralCliente panelGeneralCliente, int codMesa) {
        initComponents();
        this.panelGeneralCliente=panelGeneralCliente;
        this.codMesa=codMesa;
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelPedido = new javax.swing.JPanel();
        BotonVerFactura = new javax.swing.JButton();

        setLayout(new java.awt.BorderLayout());

        PanelPedido.setOpaque(false);
        PanelPedido.setLayout(new java.awt.GridLayout(0, 1));
        add(PanelPedido, java.awt.BorderLayout.CENTER);

        BotonVerFactura.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        BotonVerFactura.setForeground(new java.awt.Color(80, 98, 143));
        BotonVerFactura.setText("Ver Factura");
        BotonVerFactura.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(150, 172, 229), 1, true));
        BotonVerFactura.setPreferredSize(new java.awt.Dimension(89, 50));
        BotonVerFactura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verFactura(evt);
            }
        });
        add(BotonVerFactura, java.awt.BorderLayout.SOUTH);
    }// </editor-fold>//GEN-END:initComponents

    private void verFactura(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verFactura
        this.panelGeneralCliente.verFactura();
    }//GEN-LAST:event_verFactura


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotonVerFactura;
    private javax.swing.JPanel PanelPedido;
    // End of variables declaration//GEN-END:variables

    public void anadirPedido(ArrayList<Elemento> listaElementos, int codPedido, int estado) {
        this.PanelPedido.add(new PanelListaPedido(listaElementos, panelGeneralCliente, codPedido, estado));
    }

    public int actualizar() {
        this.PanelPedido.removeAll();
        ArrayList<Pedido> pedidos = this.panelGeneralCliente.icliente.obtienePedidosMesa(codMesa);
        Iterator itPedidos = pedidos.iterator();
        while(itPedidos.hasNext()){
            Pedido pedido = (Pedido) itPedidos.next();
            ArrayList<ElementoPedido> listaElementosPedido = pedido.obtieneElementos();

            ArrayList<Elemento> listaElementos = new ArrayList();
            Iterator itElementos = listaElementosPedido.iterator();
            while(itElementos.hasNext()){
                ElementoPedido elementoPedido = (ElementoPedido) itElementos.next();
                listaElementos.add(elementoPedido.getElemento());
            }

            if(pedido.getEstado()!=2){
                this.anadirPedido(listaElementos,pedido.getCodPedido(), pedido.getEstado());
            }else{
                this.panelGeneralCliente.eliminarPedido(pedido.getCodPedido(), false);
            }
        }

        this.PanelPedido.repaint();
        this.PanelPedido.revalidate();

        if(pedidos.size()==0){
            this.BotonVerFactura.setEnabled(false);
        }else{
            this.BotonVerFactura.setEnabled(true);
        }

        return pedidos.size();
    }

}
