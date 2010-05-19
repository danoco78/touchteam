/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package utilidades;

import Vista.InterfazCliente.InterfazCliente;
import Vista.InterfazCliente.PanelGeneralCliente;
import java.util.logging.Level;
import java.util.logging.Logger;

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
                System.out.println("Comprobado el estado de los pedidos");
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(HebraPedidosModificables.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
