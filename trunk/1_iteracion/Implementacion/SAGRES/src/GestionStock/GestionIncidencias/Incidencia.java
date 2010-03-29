package GestionStock.GestionIncidencias;


import GestionStock.GestionProductos.Producto;
import java.util.Date;


/**
 *
 * @author Daniel
 */
public class Incidencia {

    private int cantidadAfectada;
    private int codigo;
    private String descripcion;
    private Date fecha;
    public Producto m_Producto;

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
    public Incidencia(int codigo, int cantidad, String descripcion, Date fecha) {
        this.codigo=codigo;
        this.cantidadAfectada=cantidad;
        this.descripcion = descripcion;
        this.fecha = fecha;
    }

    /**
     * Modifica la cantidad afectada.
     * @param cantidad
     */
    public void setCantidad(int cantidad) {
        this.cantidadAfectada=cantidad;
    }

    /**
     * Modifica la descripción de las causas
     * @param descripcion
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Modifica la fecha de la incidencia.
     * @param fecha
     */
    public void setFechaIncidencia(Date fecha) {
        this.fecha = fecha;
    }


}
