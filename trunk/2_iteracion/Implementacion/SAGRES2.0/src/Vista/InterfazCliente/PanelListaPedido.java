/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * PanelListaPedido.java
 *
 * Created on 11-may-2010, 17:42:46
 */

package Vista.InterfazCliente;

import GestionCarta.Elemento;
import GestionCarta.ElementoPlato;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JOptionPane;

/**
 *
 * @author Carlos
 */
public class PanelListaPedido extends javax.swing.JPanel {

    PanelGeneralCliente PGC;
    private int codPedido;

    /** Creates new form PanelListaPedido */
    public PanelListaPedido(ArrayList<Elemento> listaElementos, PanelGeneralCliente PGC, int codPedido, int estado) {
        initComponents();

        this.PGC=PGC;
        this.codPedido=codPedido;

        this.TextoListaComida.setText("PLATOS:\n");
        this.TextoListaBebida.setText("BEBIDAS:\n");
        
        Iterator it = listaElementos.iterator();

        while(it.hasNext()){
            Elemento elemento = (Elemento) it.next();

            if(elemento instanceof ElementoPlato){
                this.TextoListaComida.setText(this.TextoListaComida.getText()+"\n- "+elemento.getNombre());
            }else{
                this.TextoListaBebida.setText(this.TextoListaBebida.getText()+"\n- "+elemento.getNombre());
            }
        }

        if(estado!=0){
            this.BotonModificar.setVisible(false);
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

        PanelListas = new javax.swing.JPanel();
        PanelListaComida = new javax.swing.JPanel();
        ScrollListaComida = new javax.swing.JScrollPane();
        TextoListaComida = new javax.swing.JTextPane();
        PanelListaBebida = new javax.swing.JPanel();
        ScrollBebida = new javax.swing.JScrollPane();
        TextoListaBebida = new javax.swing.JEditorPane();
        BotonModificar = new javax.swing.JButton();

        setLayout(new java.awt.BorderLayout());

        PanelListas.setLayout(new java.awt.BorderLayout());

        PanelListaComida.setLayout(new java.awt.BorderLayout());

        TextoListaComida.setEditable(false);
        ScrollListaComida.setViewportView(TextoListaComida);

        PanelListaComida.add(ScrollListaComida, java.awt.BorderLayout.CENTER);

        PanelListas.add(PanelListaComida, java.awt.BorderLayout.CENTER);

        PanelListaBebida.setLayout(new java.awt.BorderLayout());

        ScrollBebida.setViewportView(TextoListaBebida);

        PanelListaBebida.add(ScrollBebida, java.awt.BorderLayout.CENTER);

        PanelListas.add(PanelListaBebida, java.awt.BorderLayout.SOUTH);

        add(PanelListas, java.awt.BorderLayout.CENTER);

        BotonModificar.setFont(new java.awt.Font("Arial", 1, 16));
        BotonModificar.setForeground(new java.awt.Color(80, 98, 143));
        BotonModificar.setText("Modificar");
        BotonModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificarPedido(evt);
            }
        });
        add(BotonModificar, java.awt.BorderLayout.SOUTH);
    }// </editor-fold>//GEN-END:initComponents

    private void modificarPedido(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificarPedido
        if(this.BotonModificar.isEnabled()){
            this.PGC.iniciaModificaPedido(this.codPedido);
        }else{
            JOptionPane.showMessageDialog(this,
                              "El pedido ha empezado a prepararse.",
                              "El pedido no puede ser modificado",
                              JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_modificarPedido


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotonModificar;
    private javax.swing.JPanel PanelListaBebida;
    private javax.swing.JPanel PanelListaComida;
    private javax.swing.JPanel PanelListas;
    private javax.swing.JScrollPane ScrollBebida;
    private javax.swing.JScrollPane ScrollListaComida;
    private javax.swing.JEditorPane TextoListaBebida;
    private javax.swing.JTextPane TextoListaComida;
    // End of variables declaration//GEN-END:variables

}