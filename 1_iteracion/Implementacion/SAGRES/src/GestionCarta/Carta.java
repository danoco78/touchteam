package GestionCarta;


import java.util.ArrayList;
import java.util.Calendar;

/**
 * Almacena, gestiona y controla la información referente a la carta del
 * restaurante.
 * @author Carlos Salas Morales
 */
public class Carta {
    //ArrayList<Seccion> seccion;
    private Calendar fechaUltimaModificacion;

    public Carta () {
        /* Creamos una instancia Calendario con la fecha actual, es decir,
         * cuando se crea la carta se asigna la fecha actual */
        this.fechaUltimaModificacion = Calendar.getInstance();
      //  seccion = new ArrayList<Seccion>();
    }

    /**
     * Método que devuelve la última modificación de la carta.
     * @return Última modificación de la carta
     */
    public Calendar ultimaModifacion() {
        return this.fechaUltimaModificacion;
    }
}
