package GestionCarta;


import java.util.Date;

/**
 * Almacena, gestiona y controla la información referente a la carta del
 * restaurante.
 * @author Carlos Salas Morales
 */
public class Carta {
    private Date fechaUltimaModificacion;

    public Carta (java.sql.Date fechaUltimaModificacion) {
        this.fechaUltimaModificacion = fechaUltimaModificacion;
    }

    /**
     * Método que devuelve la última modificación de la carta.
     * @return Última modificación de la carta
     */
    public Date ultimaModifacion() {
        return this.fechaUltimaModificacion;
    }
}
