/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * PanelPedidoPorMesa.java
 *
 * Created on 08-may-2010, 18:11:19
 */

package utilidades;

import GestionPedidos.ElementoColaBar;
import GestionPedidos.ElementoColaCocina;
import GestionPedidos.ElementoPedido;
import GestionPedidos.Pedido;
import java.util.ArrayList;

/**
 *
 * @author redder
 */
public class PanelPedidoPorMesa extends javax.swing.JPanel {

    public static final int PLATO = 0;
    public static final int BEBIDA = 1;
    int filtro;
    Pedido ped;

    /** Creates new form PanelPedidoPorMesa */
    public PanelPedidoPorMesa(Pedido ped, int filtro) {
        initComponents();
        this.autoCompletar();
        this.ped = ped;
        this.tPedido.setText("    Mesa "+ped.getCodMesa()+", pedido "+ped.getCodPedido());
        this.filtro = filtro;
    }

    public void autoCompletar(){
        // TODO Autocompletar con el pedido que guarda la clase
        this.pPedidos.removeAll();
        
        //ElementoPedido ele = new ElementoPedido(1, 1, "La carne poco hecha por favor.");
        //ele.asocia(new Elemento(2, "Hamburguesa con queso", "Deliciosa carne de vacuno a la parrilla con queso fresco",
        //        true, null, 5, 5, 10));

        ArrayList<ElementoPedido> lista = ped.obtieneElementos();
        for(int i=0; i<lista.size(); ++i){
            if(filtro == PLATO){
                if(lista.get(i) instanceof ElementoColaCocina){
                    BotonElementoPedidoComentario b = new BotonElementoPedidoComentario(lista.get(i));
                    pPedidos.add(b);
                    this.pPedidos.add(new PanelEspacioVertical());
                }
            }else{
                if(lista.get(i) instanceof ElementoColaBar){
                    BotonElementoPedidoComentario b = new BotonElementoPedidoComentario(lista.get(i));
                    pPedidos.add(b);
                    this.pPedidos.add(new PanelEspacioVertical());
                }
            }
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

        pTexto = new javax.swing.JPanel();
        tPedido = new javax.swing.JLabel();
        pPedidos = new javax.swing.JPanel();
        pEspacioIzq = new javax.swing.JPanel();
        pEspacioDer = new javax.swing.JPanel();

        setBackground(new java.awt.Color(235, 235, 255));
        setLayout(new java.awt.BorderLayout());

        pTexto.setOpaque(false);
        pTexto.setLayout(new java.awt.BorderLayout());

        tPedido.setFont(new java.awt.Font("Arial", 1, 11));
        tPedido.setForeground(new java.awt.Color(80, 98, 143));
        tPedido.setText("     Mesa 5, Pedido 2");
        tPedido.setPreferredSize(new java.awt.Dimension(92, 35));
        pTexto.add(tPedido, java.awt.BorderLayout.CENTER);

        add(pTexto, java.awt.BorderLayout.NORTH);

        pPedidos.setOpaque(false);
        pPedidos.setLayout(new javax.swing.BoxLayout(pPedidos, javax.swing.BoxLayout.Y_AXIS));
        add(pPedidos, java.awt.BorderLayout.CENTER);

        pEspacioIzq.setMaximumSize(new java.awt.Dimension(5, 0));
        pEspacioIzq.setMinimumSize(new java.awt.Dimension(5, 0));
        pEspacioIzq.setOpaque(false);
        pEspacioIzq.setPreferredSize(new java.awt.Dimension(5, 0));

        javax.swing.GroupLayout pEspacioIzqLayout = new javax.swing.GroupLayout(pEspacioIzq);
        pEspacioIzq.setLayout(pEspacioIzqLayout);
        pEspacioIzqLayout.setHorizontalGroup(
            pEspacioIzqLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );
        pEspacioIzqLayout.setVerticalGroup(
            pEspacioIzqLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 265, Short.MAX_VALUE)
        );

        add(pEspacioIzq, java.awt.BorderLayout.WEST);

        pEspacioDer.setMaximumSize(new java.awt.Dimension(5, 0));
        pEspacioDer.setMinimumSize(new java.awt.Dimension(5, 0));
        pEspacioDer.setOpaque(false);
        pEspacioDer.setPreferredSize(new java.awt.Dimension(5, 0));

        javax.swing.GroupLayout pEspacioDerLayout = new javax.swing.GroupLayout(pEspacioDer);
        pEspacioDer.setLayout(pEspacioDerLayout);
        pEspacioDerLayout.setHorizontalGroup(
            pEspacioDerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );
        pEspacioDerLayout.setVerticalGroup(
            pEspacioDerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 265, Short.MAX_VALUE)
        );

        add(pEspacioDer, java.awt.BorderLayout.EAST);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel pEspacioDer;
    private javax.swing.JPanel pEspacioIzq;
    private javax.swing.JPanel pPedidos;
    private javax.swing.JPanel pTexto;
    private javax.swing.JLabel tPedido;
    // End of variables declaration//GEN-END:variables

}