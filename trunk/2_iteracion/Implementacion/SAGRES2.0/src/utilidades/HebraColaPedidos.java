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
    int numBebidas=-1,numPlatos=-1,aux;

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
                        System.out.println("Paso por aqui");
                        if (p == actual) {
                            Thread.sleep(5000); // 5 Segundos
                        } else {
                            actual = p;
                            mpadre.panelColaBar.pmp.addPedido(actual);
                        }

                        aux = mpadre.imetre.getNumBebidasEnCola();
                        if (aux!=numBebidas){
                            numBebidas = aux;
                            mpadre.panelColaBar.pmp.setPendientes(numBebidas);
                        }
                        break;
                    case COCINA:
                        p = cpadre.icocinero.getSiguientePedidoCocinaEnCola();
                        if (p == actual) {
                            Thread.sleep(5000); // 5 Segundos
                        } else {
                            actual = p;
                            cpadre.panelColaCocinero.pmpizq.addPedido(actual);
                            cpadre.panelColaCocinero.actualizarVista();
                        }

                        aux = cpadre.icocinero.getNumPlatosEnCola();
                        if (aux!=numPlatos){
                            numPlatos = aux;
                            cpadre.panelColaCocinero.pmpizq.setPendientes(numPlatos);
                        }
                        break;
                }
            } catch (Exception ex) {
                end = true;
            }
        }
    }
}
