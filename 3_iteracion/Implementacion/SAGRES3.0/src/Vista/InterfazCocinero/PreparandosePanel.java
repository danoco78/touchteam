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

import ControladorPrincipal.ICocinero;
import GestionPedidos.ElementoColaCocina;
import GestionPedidos.Pedido;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import utilidades.PanelEspacioVertical;
import utilidades.PanelPedidoPorMesa;

/**
 *
 * @author Samuel Guirado Navarro
 */
public class PreparandosePanel extends javax.swing.JPanel {

    private int npreparandose = 0;
    public ICocinero icocinero;
    public InterfazCocinero ventana;
    
    /** Creates new form PanelMesaPedido */
    public PreparandosePanel(ICocinero icocinero, InterfazCocinero ventana) {
        initComponents();
        this.icocinero = icocinero;
        this.ventana = ventana;
    }

    /**
     * Recibe una lista de pedidos con elementos preparandose, obtiene los platos necesarios
     * y los muestra en un panel. Sirve tambien para actualizar el panel.
     * @param listaPedidos Lista de pedidos a recibir
     */
    private void autoCompletar(ArrayList<Pedido> listaPedidos){

        this.pPanelesPedido.removeAll();
        this.pPanelesPedido.add(new PanelEspacioVertical());

        //Actualizamos la etiqueta de platos preparándose
        for(int i=0; i<listaPedidos.size(); ++i){
            //totalPlatos += listaPedidos.get(i).obtieneElementos().size();
            if(!listaPedidos.get(i).obtieneElementos().isEmpty()){
               this.pPanelesPedido.add(new PanelPedidoPorMesa(listaPedidos.get(i),this));
               this.pPanelesPedido.add(new PanelEspacioVertical());
            }
        }

        int totalPlatos = cuentaPlatos(listaPedidos);
        this.setMensaje(totalPlatos);
        
        this.revalidate();
        this.repaint();
    }


    public void setMensaje(int n){
        this.npreparandose = n;
        switch(n){
            case 0:
                pendientes.setText("No hay ningún plato preparándose");
                break;
            case 1:
                pendientes.setText("Hay "+ n + " plato preparándose.");
                break;
            default:
                pendientes.setText("Hay "+ n + " platos preparándose.");
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

        pInf = new javax.swing.JPanel();
        pendientes = new javax.swing.JLabel();
        scroll = new javax.swing.JScrollPane();
        pCentral = new javax.swing.JPanel();
        margenDer = new javax.swing.JPanel();
        margenIzq = new javax.swing.JPanel();
        pPanelesPedido = new javax.swing.JPanel();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, new java.awt.Color(150, 172, 229), new java.awt.Color(150, 172, 229), new java.awt.Color(150, 172, 229), new java.awt.Color(170, 172, 229)));
        setLayout(new java.awt.BorderLayout());

        pInf.setBackground(new java.awt.Color(255, 255, 255));
        pInf.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(150, 172, 229)));
        pInf.setPreferredSize(new java.awt.Dimension(396, 50));
        pInf.setLayout(new java.awt.BorderLayout());

        pendientes.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        pendientes.setForeground(new java.awt.Color(80, 98, 143));
        pendientes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pInf.add(pendientes, java.awt.BorderLayout.CENTER);

        add(pInf, java.awt.BorderLayout.SOUTH);

        scroll.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        pCentral.setBackground(new java.awt.Color(255, 255, 255));
        pCentral.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(150, 172, 229)));
        pCentral.setLayout(new java.awt.BorderLayout());

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
            .addGap(0, 242, Short.MAX_VALUE)
        );

        pCentral.add(margenDer, java.awt.BorderLayout.EAST);

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
            .addGap(0, 242, Short.MAX_VALUE)
        );

        pCentral.add(margenIzq, java.awt.BorderLayout.WEST);

        pPanelesPedido.setOpaque(false);
        pPanelesPedido.setLayout(new javax.swing.BoxLayout(pPanelesPedido, javax.swing.BoxLayout.Y_AXIS));
        pCentral.add(pPanelesPedido, java.awt.BorderLayout.CENTER);

        scroll.setViewportView(pCentral);

        add(scroll, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel margenDer;
    private javax.swing.JPanel margenIzq;
    private javax.swing.JPanel pCentral;
    private javax.swing.JPanel pInf;
    private javax.swing.JPanel pPanelesPedido;
    private javax.swing.JLabel pendientes;
    private javax.swing.JScrollPane scroll;
    // End of variables declaration//GEN-END:variables


    private int cuentaPlatos(ArrayList<Pedido> listaPedidos) {
        int Total = 0;
        for (int i=0;i<listaPedidos.size();i++){
            for(int j=0;j<listaPedidos.get(i).obtieneElementos().size();j++){
                if(listaPedidos.get(i).obtieneElementos().get(j) instanceof ElementoColaCocina &&
                        listaPedidos.get(i).obtieneElementos().get(j).getEstado() == ElementoColaCocina.PREPARANDOSE)
                    Total++;
            }
        }
        return Total;
    }

    public void incPreparandose(){
       npreparandose++;
       setMensaje(npreparandose);
    }
    public void decPreparandose(){

       npreparandose--;
       setMensaje(npreparandose);
    }

    public void actualizar() {
        try {
            // Obtener los pedidos con elementos preparandose
            ArrayList<Pedido> pedidosCocinaPreparandose = this.icocinero.getPedidosCocinaPreparandose();
            // Si es necesario, actualizar
            // TODO Comparar si ha cambiado alguno de estado
            this.autoCompletar(pedidosCocinaPreparandose);
        } catch (Exception ex) {
            Logger.getLogger(PreparandosePanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
