/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package utilidades;

import Vista.InterfazCocinero.PreparandosePanel;


/**
 *
 * @author Carlos
 */
public class HebraCocina extends Thread {
    
    PanelMesaPedido pEncola;
    PreparandosePanel pPreparandose;

    /**
     * Hebra que se encarga de actualizar la cocina
     * @param pEncola
     * @param pPreparandose
     */
    public HebraCocina(PanelMesaPedido pEncola, PreparandosePanel pPreparandose) {
        this.pEncola = pEncola;
        this.pPreparandose = pPreparandose;
    }

    @Override
    public void run() {
        try {
            while(true){
                HebraCocina.sleep(5000);
                this.pEncola.actualizar();
                this.pPreparandose.actualizar();
                //System.out.println("Comprobado el estado de los pedidos");
            }
        } catch (InterruptedException ex) {
            System.err.println("Error, se interrumpio la hebra \"HebraCocina\" "+ex.getMessage());
        }
    }
}
