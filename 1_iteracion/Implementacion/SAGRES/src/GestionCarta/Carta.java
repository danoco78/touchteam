package GestionCarta;


import java.util.Calendar;

/**
 * Almacena, gestiona y controla la información referente a la carta del
 * restaurante.
 * @author Carlos Salas Morales
 */
public class Carta {
    private Calendar fechaUltimaModificacion;

    public Carta (java.sql.Date fechaUltimaModificacion) {
        this.fechaUltimaModificacion.setTime(fechaUltimaModificacion);
    }

    /**
     * Método que devuelve la última modificación de la carta.
     * @return Última modificación de la carta
     */
    public Calendar ultimaModifacion() {
        return this.fechaUltimaModificacion;
    }
}
