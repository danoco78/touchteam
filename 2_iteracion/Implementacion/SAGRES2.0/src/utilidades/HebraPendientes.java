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
public class HebraPendientes implements Runnable {
    Thread t;
    InterfazMetre mpadre;
    InterfazCocinero cpadre;
    boolean end;
    int numBebidas=-1,numPlatos=-1,aux;

    int filtro;

    public static final int COCINA = 0;
    public static final int BAR = 1;

    public HebraPendientes(InterfazMetre iMetre) {
        t = new Thread(this, "Hebra Actualizadora de las Bebidas pendientes");
        mpadre = iMetre;
        end = false;
        filtro = BAR;
        t.start();
    }

    public HebraPendientes(InterfazCocinero iCocinero) {
        t = new Thread(this, "Hebra Actualizadora de los Platos pendientes");
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
                        aux = mpadre.imetre.getNumBebidasEnCola();
                        if (aux!=numBebidas){
                            numBebidas = aux;
                            mpadre.panelColaBar.pmp.setPendientes(numBebidas);
                        }
                        else
                            Thread.sleep(5000);
                        break;
                    case COCINA:
                        aux = cpadre.icocinero.getNumPlatosEnCola();
                        if (aux!=numPlatos){
                            numPlatos = aux;
                            cpadre.panelColaCocinero.pmpizq.setPendientes(numPlatos);
                        }
                        else
                            Thread.sleep(5000);
                        break;
                }
            } catch (Exception ex) {
                end = true;
            }
        }
    }
}
