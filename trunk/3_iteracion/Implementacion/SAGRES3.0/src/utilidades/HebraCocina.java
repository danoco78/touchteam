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
    
    private PanelMesaPedido pEncola;
    private PreparandosePanel pPreparandose;
    private Thread t;
    private long ticks;

    /**
     * Hebra que se encarga de actualizar la cocina
     * @param pEncola
     * @param pPreparandose
     */
    public HebraCocina(PanelMesaPedido pEncola, PreparandosePanel pPreparandose) {
        t = new Thread(this, "Hebra Actualizadora de las colas de cocina");
        this.pEncola = pEncola;
        this.pPreparandose = pPreparandose;
        ticks = 0;
        t.start();
    }

    @Override
    public void run() {
        try {
            while(true){
                if(ticks%5 == 0){
                    this.pEncola.actualizar();
                    this.pPreparandose.actualizar();
                }
                ++ticks;
                this.pPreparandose.tick = ticks;
                this.pPreparandose.repintaBotones(ticks);
                //System.out.println("Comprobado el estado de los pedidos");
                HebraCocina.sleep(1000);
            }
        } catch (InterruptedException ex) {
            System.err.println("Error, se interrumpio la hebra \"HebraCocina\" "+ex.getMessage());
        }
    }
}
