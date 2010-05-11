/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * PanelColaFacturas.java
 *
 * Created on 06-may-2010, 14:24:16
 */

package Vista.InterfazMetre;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import utilidades.PanelEspacioVertical;


/**
 *
 * @author Samuel Guirado Navarro
 */
public class PanelColaFacturas extends javax.swing.JPanel {

    int filtro;
    InterfazMetre controlador;
    
    public static final int PARAIMPRIMIR = 0;
    public static final int PARAFACTURAR = 1;

    /** Creates new form PanelColaFacturas */
    public PanelColaFacturas(InterfazMetre im, int tipo) {
        initComponents();
        controlador = im;
        filtro = tipo;
        
        //TODO Borrar
        for (int i=0;i<20;i++){
            JButton boton = new JButton();
            PanelEspacioVertical pev = new PanelEspacioVertical();
            boton.setBackground(new java.awt.Color(211, 223, 253));
            boton.setForeground(new java.awt.Color(80, 98, 143));
            boton.setFont(new java.awt.Font("Arial", 0, 18));
            boton.setText("<html>\n<body>\n<br></br>\n<br></br>\nMesa "+(i+1)+"\n<br></br>\n<br></br>\n<br></br>\n</body>\n</html>\n");
            boton.setFocusPainted(false);
            boton.addActionListener(new ManejaEventos(boton,pev));
            boton.setName(String.valueOf(i+1));

            centro.add(boton);
            centro.add(pev);
        }
    }

    public void addMesa(int codigo){
        JButton boton = new JButton();
        PanelEspacioVertical pev = new PanelEspacioVertical();

        boton.setBackground(new java.awt.Color(211, 223, 253));
        boton.setForeground(new java.awt.Color(80, 98, 143));
        boton.setFont(new java.awt.Font("Arial", 0, 18));
        boton.setText("<html>\n<body>\n<br></br>\n<br></br>\nMesa "+String.valueOf(codigo)+"\n<br></br>\n<br></br>\n<br></br>\n</body>\n</html>\n");
        boton.setFocusPainted(false);
        boton.addActionListener(new ManejaEventos(boton,pev));
        boton.setName(String.valueOf(codigo));

        centro.add(boton);
        centro.add(pev);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scrollPane = new javax.swing.JScrollPane();
        centro = new javax.swing.JPanel();
        margenSup = new javax.swing.JPanel();
        margenInf = new javax.swing.JPanel();
        margenDer = new javax.swing.JPanel();
        margenIzq = new javax.swing.JPanel();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(150, 172, 229)));
        setLayout(new java.awt.BorderLayout());

        scrollPane.setBackground(new java.awt.Color(255, 255, 255));
        scrollPane.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setOpaque(false);

        centro.setBackground(new java.awt.Color(255, 255, 255));
        centro.setLayout(new javax.swing.BoxLayout(centro, javax.swing.BoxLayout.Y_AXIS));
        scrollPane.setViewportView(centro);

        add(scrollPane, java.awt.BorderLayout.CENTER);

        margenSup.setOpaque(false);
        margenSup.setPreferredSize(new java.awt.Dimension(10, 5));
        add(margenSup, java.awt.BorderLayout.PAGE_START);

        margenInf.setOpaque(false);
        margenInf.setPreferredSize(new java.awt.Dimension(10, 5));
        add(margenInf, java.awt.BorderLayout.PAGE_END);

        margenDer.setOpaque(false);
        margenDer.setPreferredSize(new java.awt.Dimension(5, 10));
        add(margenDer, java.awt.BorderLayout.LINE_END);

        margenIzq.setOpaque(false);
        margenIzq.setPreferredSize(new java.awt.Dimension(5, 10));
        add(margenIzq, java.awt.BorderLayout.LINE_START);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel centro;
    private javax.swing.JPanel margenDer;
    private javax.swing.JPanel margenInf;
    private javax.swing.JPanel margenIzq;
    private javax.swing.JPanel margenSup;
    private javax.swing.JScrollPane scrollPane;
    // End of variables declaration//GEN-END:variables

    private class ManejaEventos implements ActionListener{

        JButton boton;
        PanelEspacioVertical panel;
        boolean borrar;

        public ManejaEventos(JButton b,PanelEspacioVertical p){
            boton = b;
            panel = p;
        }

        public void actionPerformed(ActionEvent e) {
            borrar = false;
            switch(filtro){
                case PanelColaFacturas.PARAIMPRIMIR:
                    controlador.imetre.imprimeFactura(Integer.parseInt(boton.getName()));
                    borrar = true;
                    break;
                case PanelColaFacturas.PARAFACTURAR:
                    DialogoFacturacion confirmar = new DialogoFacturacion(controlador,Integer.parseInt(boton.getName()));
                    confirmar.setLocationRelativeTo(controlador);
                    confirmar.setVisible(true);
                    if(confirmar.isAceptado())
                        borrar = true;
                    break;
            }
            if (borrar){
                centro.remove(boton);
                centro.remove(panel);
                centro.repaint();
                centro.revalidate();
            }
        }
    }
}
