/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * panelPedido.java
 *
 * Created on 05-may-2010, 0:07:12
 */

package Vista.InterfazCocinero;

/**
 *
 * @author Gaspar
 */
public class panelPedido extends javax.swing.JPanel {

    /** Creates new form panelPedido */
    public panelPedido() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelElemento = new javax.swing.JLabel();
        labelObservacion = new javax.swing.JLabel();

        setBackground(new java.awt.Color(211, 223, 253));
        setLayout(new java.awt.GridLayout(3, 0));

        labelElemento.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        labelElemento.setForeground(new java.awt.Color(80, 98, 143));
        add(labelElemento);

        labelObservacion.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        add(labelObservacion);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel labelElemento;
    private javax.swing.JLabel labelObservacion;
    // End of variables declaration//GEN-END:variables

    public void setLabelElemento(String texto){
        labelElemento.setText(texto);
    }
    public void setLabelObservacion(String texto){
        labelObservacion.setText(texto);
    }
}
