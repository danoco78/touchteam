/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package utilidades;

import ControladorPrincipal.ICocinero;
import ControladorPrincipal.IMetre;
import GestionPedidos.Pedido;

/**
 *
 * @author Samuel Guirado Navarro
 */
public class HebraColaPedidos implements Runnable {
    Thread t;
    IMetre iMetre;
    ICocinero iCocinero;
    PanelMesaPedido pmp;
    boolean end;
    Pedido p;

    int filtro;

    public static final int COCINA = 0;
    public static final int BAR = 1;

    public HebraColaPedidos(IMetre iMetre, PanelMesaPedido panel) {
        t = new Thread(this, "Hebra Actualizadora de la Cola de Pedidos de Bar");
        this.iMetre = iMetre;
        this.pmp = panel;
        end = false;
        filtro = BAR;
        t.start();
    }

    public HebraColaPedidos(ICocinero iCocinero, PanelMesaPedido panel) {
        t = new Thread(this, "Hebra Actualizadora de la Cola de Pedidos de Cocina");
        this.iCocinero = iCocinero;
        this.pmp = panel;
        end = false;
        filtro = COCINA;
        t.start();
    }

    public void run() {
        while (!end) {
            try {
                switch (filtro){
                    case BAR:
                        p = iMetre.getSiguientePedidoBar();
                        break;
                    case COCINA:
                        p = iCocinero.getSiguientePedidoCocinaEnCola();
                        break;
                }
                
                if (p == null) {
                    Thread.sleep(5000); // 5 Segundos
                } else {
                    t.interrupt();
                    pmp.addPedido(p);
                }
            } catch (Exception ex) {
                end = true;
            }
        }
    }
}
