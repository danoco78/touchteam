package GestionCarta;


/**
 * Divisiones en que se encuentra dividida la carta del restaurante.
 * @author Carlos Salas Morales
 */
public class Seccion implements Comparable {
    Carta carta;
    public String nombre;
    int codigoSeccion;


    public Seccion(int codigoSeccion, String nombre, Carta carta) {
        this.nombre = nombre;
        this.carta = carta;
        this.codigoSeccion = codigoSeccion;
    }

    /**
     * Método que devuelve el nombre de la sección.
     * @return Nombre de la sección.
     */
    public String getNombre() {
        return this.nombre;
    }

    public int getCodigoSeccion() {
        return this.codigoSeccion;
    }

    public int compareTo(Object obj) {
        Seccion seccion = (Seccion)obj;
        return this.codigoSeccion - seccion.getCodigoSeccion();
    }
}
