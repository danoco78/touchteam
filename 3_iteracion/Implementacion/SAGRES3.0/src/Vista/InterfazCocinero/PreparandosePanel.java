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
import GestionPedidos.ElementoPedido;
import GestionPedidos.Pedido;
import java.awt.Component;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;
import utilidades.PanelEspacioVertical;
import utilidades.PanelPedidoPorMesa;

/**
 *
 * @author Samuel Guirado Navarro
 */
public class PreparandosePanel extends javax.swing.JPanel {

    private Vector<Vector<Integer> > pedidosMostrandose;
    private ArrayList<Long> tickElementos;
    public ICocinero icocinero;
    public InterfazCocinero ventana;
    public long tick;

    
    /** Creates new form PanelMesaPedido */
    public PreparandosePanel(ICocinero icocinero, InterfazCocinero ventana) {
        initComponents();
        this.icocinero = icocinero;
        this.ventana = ventana;
        pedidosMostrandose = null;
        tick = 0;
        tickElementos = new ArrayList<Long>();
        this.actualizar();
    }

    public void actualizar() {
        try {
            // Obtener los pedidos con elementos preparandose
            ArrayList<Pedido> pedidosCocinaPreparandose = this.icocinero.getPedidosCocinaPreparandose();
            // Si es necesario, actualizar
            if(hayQueActualizar(pedidosMostrandose, pedidosCocinaPreparandose)){
                this.autoCompletar(pedidosCocinaPreparandose);
            }else{
                System.gc();
            }
        } catch (Exception ex) {
            System.err.println("Error en preparandose panel, al obtener pedidos cocina preparandose: "+ex.getMessage());
        }
    }

    /**
     * Recibe una lista de pedidos con elementos preparandose, obtiene los platos necesarios
     * y los muestra en un panel. Sirve tambien para actualizar el panel.
     * @param listaPedidos Lista de pedidos a recibir
     */
    private void autoCompletar(ArrayList<Pedido> listaPedidos){

        if(this.pedidosMostrandose != null) pedidosMostrandose.clear();
        this.pedidosMostrandose = this.copiarPedido(listaPedidos);
        this.pPanelesPedido.removeAll();
        this.pPanelesPedido.add(new PanelEspacioVertical());

        //Actualizamos la etiqueta de platos preparándose
        for(int i=0; i<listaPedidos.size(); ++i){
            if (!listaPedidos.get(i).obtieneElementos().isEmpty()) {
                PanelPedidoPorMesa panelPedidoPorMesa = new PanelPedidoPorMesa(listaPedidos.get(i), this, this.tickElementos);
                this.pPanelesPedido.add(panelPedidoPorMesa);
                this.pPanelesPedido.add(new PanelEspacioVertical());
                panelPedidoPorMesa.repintar(tick);
            }
        }

        int totalPlatos = cuentaPlatos(listaPedidos);
        this.setMensaje(totalPlatos);
        
        this.revalidate();
        this.repaint();
    }

    /**
     * Copia un pedido y lo devuelve en forma de vector de codigos y estados. Además
     * completa los tiempos de los elementos de pedido.
     * @param ped Pedido a copiar
     * @return Nuevo pedido sin referencias a ped
     */
    private Vector<Vector<Integer> > copiarPedido(ArrayList<Pedido> peds){

        Vector<Vector<Integer> > copiaPeds = new Vector(peds.size());
        Iterator<Pedido> itPeds = peds.iterator();

        // Comenzamos eliminando todos los elementos que no se encuentran en los tiempos
        for(int i=0; i<tickElementos.size(); i+=2){
            boolean encontrado = false;
            while(itPeds.hasNext() && !encontrado){
                Iterator<ElementoPedido> itElem = itPeds.next().obtieneElementos().iterator();
                while(itElem.hasNext() && !encontrado){
                    if(itElem.next().getCodElementoPedido().intValue() == tickElementos.get(i).intValue()){
                        encontrado = true;
                    }
                }
            }
            if(!encontrado){
                tickElementos.remove(i);
                tickElementos.remove(i);
                i -= 2;
            }
            itPeds = peds.iterator();
        }

        // Añadimos ahora todos los que queremos
        while(itPeds.hasNext()){
            Pedido ped = itPeds.next();
            Vector<Integer> copia = new Vector<Integer>(ped.getElementos().size()*2 +2);
            copia.add(ped.getCodPedido());
            copia.add(ped.getEstado());

            // Lo introducimos en la copia
            Iterator<ElementoPedido> it = ped.getElementos().iterator();
            while(it.hasNext()){
                ElementoPedido next = it.next();
                if(next instanceof ElementoColaCocina){
                    copia.add(next.getCodElementoPedido());
                    copia.add(next.getEstado());
                    
                    // Lo buscamos en el vector de tiempos
                    boolean encontrado = false;
                    for(int i=0; i< tickElementos.size() && !encontrado; i+=2){
                        if(tickElementos.get(i).intValue() == next.getCodElementoPedido().intValue()){
                            encontrado = true;
                        }
                    }
                    if(!encontrado && next.getEstado() == ElementoColaCocina.PREPARANDOSE){
                        tickElementos.add(new Long(next.getCodElementoPedido().intValue()));
                        tickElementos.add(new Long(tick));
                    }
                }

            }
            copiaPeds.add(copia);
            
        }
        return copiaPeds;
    }


    public void setMensaje(int n){
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

        pendientes.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
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

    /**
     * Comprueba si es necesario actualizar
     * @param pedMostrandose Vector de &gt;CodPedido, EstadoPedido, CodElem, EstadoElem...&lt;
     * @param ped
     * @return
     */
    private boolean hayQueActualizar(Vector<Vector<Integer> > pedsMostrandose, ArrayList<Pedido> peds) {
        if((pedsMostrandose == null && peds != null) ||
                    (pedsMostrandose != null && peds == null))
                return true;
        if(pedsMostrandose == null && peds == null) return false;
        if((peds.isEmpty() && !pedsMostrandose.isEmpty()) ||
                (!peds.isEmpty() && pedsMostrandose.isEmpty())){
            return true;
        }
        if(peds.isEmpty() && pedsMostrandose.isEmpty()) return true;

        if(pedsMostrandose.size() != peds.size()) return true;
        Iterator<Vector<Integer> > itMostrandose = pedsMostrandose.iterator();
        while(itMostrandose.hasNext()){
            Vector<Integer> pedMostrandose = itMostrandose.next();
            Iterator<Pedido> itPeds = peds.iterator();
            Pedido ped = null;
            // Buscamos el pedido dentro de nuestra lista de pedidos mostrandose
            boolean encontrado = false;
            while(itPeds.hasNext() && !encontrado){
                ped = itPeds.next();
                if(ped.getCodPedido() == pedMostrandose.get(0)){
                    encontrado = true;
                }
            }
            if(!encontrado) return true;
            if(pedMostrandose.get(1) != ped.getEstado()) return true;
            ArrayList<ElementoPedido> elementos = ped.getElementos();
            // No se puede comparar los tamaños porque pedMostrandose solo guarda los que corresponde al filtro
            //if((pedMostrandose.size()-2)/2 != elementos.size()) return true;

            // Buscamos la correspondencia entre elementos
            Iterator<ElementoPedido> iterator = elementos.iterator();
            while(iterator.hasNext()){
                ElementoPedido elem = iterator.next();
                if(elem instanceof ElementoColaCocina){
                    encontrado = false;
                    for(int i=2; i< pedMostrandose.size() && !encontrado; i+=2){
                        if(pedMostrandose.get(i) == elem.getCodElementoPedido()){
                            encontrado = true;
                            if(pedMostrandose.get(i+1) != elem.getEstado()){
                                return true;
                            }
                        }
                    }
                }
            }
        }
        
        return false;
    }

    public void repintaBotones(long ticks) {
        Component[] components = this.pPanelesPedido.getComponents();
        for(int i=0; i<components.length; ++i){
            if(components[i] instanceof PanelPedidoPorMesa){
                ((PanelPedidoPorMesa)components[i]).repintar(ticks);
            }
        }
    }
}
