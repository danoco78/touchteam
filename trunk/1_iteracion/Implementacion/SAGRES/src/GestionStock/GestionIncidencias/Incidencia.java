package GestionStock.GestionIncidencias;


import GestionStock.GestionProductos.Producto;
import java.util.Date;


/**
 *
 * @author Daniel
 */
public class Incidencia {

    private float cantidadAfectada;
    private int codigo;
    private int tipoIncidencia;
    private Date fecha;
    public Producto producto;

    @Override
    public void finalize() throws Throwable {
    }

    /**
     * Crea un objeto Incidencia
     * @param codigo Representación unica para objeto
     * @param cantidad Indica el numero de productos afectados
     * @param descripcion Descripción del motivo por el cual fueron desechados.
     * @param fecha Fecha de incidencia.
     */
    public Incidencia(int codigo, Producto producto, float cantidad, int tipoIncidencia) {
        this.codigo=codigo;
        this.cantidadAfectada=cantidad;
        this.producto = producto;
        this.tipoIncidencia = tipoIncidencia;
        this.fecha = java.util.Calendar.getInstance().getTime();
    }


}
