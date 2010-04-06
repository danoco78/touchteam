package GestionStock.GestionIncidencias;

import GestionStock.GestionProductos.Producto;

/**
 *
 * @author Daniel Guerrero Martinez
 */
public interface IIncidencia {

    public abstract void nuevaIncidencia(String tipoIncidencia,
            float cantidadAfectada, Producto producto);

}
