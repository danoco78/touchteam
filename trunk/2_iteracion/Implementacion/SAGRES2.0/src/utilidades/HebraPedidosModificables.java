/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package utilidades;

import Vista.InterfazCliente.InterfazCliente;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Carlos
 */
public class HebraPedidosModificables extends Thread {
    
    InterfazCliente interfazCliente;

    public HebraPedidosModificables(InterfazCliente interfazCliente) {
        this.interfazCliente = interfazCliente;
    }

    @Override
    public void run() {
        try {
            while(true){
                HebraPedidosModificables.sleep(5000);
                //System.out.println("HOLA");
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(HebraPedidosModificables.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
