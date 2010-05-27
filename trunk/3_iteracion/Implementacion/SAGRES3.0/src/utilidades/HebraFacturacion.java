/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package utilidades;

import Vista.InterfazMetre.InterfazMetre;

/**
 *
 * @author Samuel Guirado Navarro
 */
public class HebraFacturacion implements Runnable {
    Thread t;
    InterfazMetre mpadre;
    boolean end;

    public HebraFacturacion(InterfazMetre iMetre) {
        t = new Thread(this, "Hebra Actualizadora de las colas de Facturacion");
        mpadre = iMetre;
        end = false;
        t.start();
    }

    public void run() {
        while (!end) {
            try {
                mpadre.panelColaBar.colaIzq.addMesas(mpadre.imetre.getFacturasEnCola());
                mpadre.panelColaBar.colaDer.addMesas(mpadre.imetre.getFacturasImprimidas());
                Thread.sleep(5000);
            } catch (Exception ex) {
                end = true;
            }
        }
    }
}
