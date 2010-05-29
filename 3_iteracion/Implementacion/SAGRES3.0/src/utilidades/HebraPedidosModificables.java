/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package utilidades;

import Vista.InterfazCliente.PanelGeneralCliente;

/**
 *
 * @author Carlos
 */
public class HebraPedidosModificables extends Thread {
    
    PanelGeneralCliente panelGeneralCliente;

    public HebraPedidosModificables(PanelGeneralCliente panelGeneralCliente) {
        this.panelGeneralCliente = panelGeneralCliente;
    }

    @Override
    public void run() {
        try {
            while(true){
                HebraPedidosModificables.sleep(5000);
                this.panelGeneralCliente.comprobarPedidos();
                //System.out.println("Comprobado el estado de los pedidos");
            }
        } catch (InterruptedException ex) {
            System.err.println("Error, se interrumpio la hebra \"HebraPedidosModificables\" "+ex.getMessage());
        }
    }
}
