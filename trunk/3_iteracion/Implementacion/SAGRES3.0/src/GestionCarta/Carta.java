package GestionCarta;

import java.sql.Timestamp;



/**
 * Almacena, gestiona y controla la información referente a la carta del
 * restaurante.
 * @author Carlos Salas Morales
 */
public class Carta {
    private Timestamp fechaUltimaModificacion;

    public Carta (Timestamp fechaUltimaModificacion) {
        this.fechaUltimaModificacion = fechaUltimaModificacion;
    }

    /**
     * Método que devuelve la última modificación de la carta.
     * @return Última modificación de la carta
     */
    public Timestamp ultimaModifacion() {
        return this.fechaUltimaModificacion;
    }
}
