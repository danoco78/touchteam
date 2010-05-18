/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package utilidades;

import GestionPedidos.Pedido;
import Vista.InterfazCocinero.InterfazCocinero;
import Vista.InterfazMetre.InterfazMetre;

/**
 *
 * @author Samuel Guirado Navarro
 */
public class HebraColaPedidos implements Runnable {
    Thread t;
    InterfazMetre mpadre;
    InterfazCocinero cpadre;
    boolean end;
    Pedido actual = null ,p = null;

    int filtro;

    public static final int COCINA = 0;
    public static final int BAR = 1;

    public HebraColaPedidos(InterfazMetre iMetre) {
        t = new Thread(this, "Hebra Actualizadora de la Cola de Pedidos de Bar");
        mpadre = iMetre;
        end = false;
        filtro = BAR;
        t.start();
    }

    public HebraColaPedidos(InterfazCocinero iCocinero) {
        t = new Thread(this, "Hebra Actualizadora de la Cola de Pedidos de Cocina");
        cpadre = iCocinero;
        end = false;
        filtro = COCINA;
        t.start();
    }

    public void run() {
        while (!end) {
            try {
                switch (filtro){
                    case BAR:
                        p = mpadre.imetre.getSiguientePedidoBar();
                        if (actual != null && p!=null && actual.equals(p)) {
                            Thread.sleep(5000); // 5 Segundos
                        } else {
                            actual = p;
                            if (actual != null)
                                mpadre.panelColaBar.pmp.addPedido(actual);
                        }
                        break;
                    case COCINA:
                        p = cpadre.icocinero.getSiguientePedidoCocina();
                        if (actual != null && p!= null && actual.equals(p)) {
                            Thread.sleep(5000); // 5 Segundos
                        } else {
                            actual = p;
                            if(actual != null)
                                cpadre.panelColaCocinero.pmpizq.addPedido(actual);
                        }
                        break;
                }
            } catch (Exception ex) {
                end = true;
            }
        }
    }
}
