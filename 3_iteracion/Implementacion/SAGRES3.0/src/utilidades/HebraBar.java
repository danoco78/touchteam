/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package utilidades;

import Vista.InterfazMetre.InterfazMetre;
import Vista.InterfazMetre.PanelColaFacturas;


/**
 *
 * @author Carlos
 */
public class HebraBar extends Thread {
    
    private PanelMesaPedido pEncola;
    private Thread t;
    private final PanelColaFacturas pCobrar;
    private final InterfazMetre iMetre;
    private final PanelColaFacturas pImprimir;

    /**
     * Hebra que actualiza las colas de cocina (De bebidas y facturas)
     * @param pEncola Panel de bebidas en cola
     * @param pImprimir Panel de Imprimir facturas
     * @param pCobrar Panel de cobrar facturas
     * @param iMetre Interfaz del metre
     */
    public HebraBar(PanelMesaPedido pEncola, PanelColaFacturas pImprimir,
            PanelColaFacturas pCobrar,InterfazMetre iMetre) {
        t = new Thread(this, "Hebra Actualizadora de las colas de bar");
        this.pEncola = pEncola;
        this.pCobrar = pCobrar;
        this.pImprimir = pImprimir;
        this.iMetre = iMetre;
        //this.pPreparandose = pPreparandose;
        t.start();
    }

    @Override
    public void run() {
        try {
            while(true){
                this.pEncola.actualizar();
                this.pImprimir.addMesas(iMetre.imetre.getFacturasEnCola());
                this.pCobrar.addMesas(iMetre.imetre.getFacturasImprimidas());
                HebraBar.sleep(5000);
            }
        } catch (InterruptedException ex) {
            System.err.println("Error, se interrumpio la hebra \"HebraCocina\" "+ex.getMessage());
        }
    }
}
