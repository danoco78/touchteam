package GestionStock.GestionIncidencias;

import GestionStock.GestionProductos.Producto;

/**
 *
 * @author Daniel
 */
public interface IIncidencia {
    /*
     * Añade al Sistema una nueva incidencia.
     * @param tipoIncidencia
     */
    public abstract void nuevaIncidencia(String tipoIncidencia,
            float cantidadAfectada, Producto producto);

}
