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
    private String tipoIncidencia;
    private Date fecha;
    public Producto producto;


    /**
     * Crea un objeto Incidencia a dia de hoy
     * La fecha es asignada conforme la fecha del systema.
     *
     * @param codigo Representación unica para objeto
     * @param cantidad Indica el numero de productos afectados
     * @param descripcion Descripción del motivo por el cual fueron desechados.
     * @param fecha Fecha de incidencia.
     */
    public Incidencia(int codigo, Producto producto, float cantidad, String tipoIncidencia) {
        this.codigo=codigo;
        this.cantidadAfectada=cantidad;
        this.producto = producto;
        this.tipoIncidencia = tipoIncidencia;
        this.fecha = java.util.Calendar.getInstance().getTime();
    }

     /**
     * Crea un objeto Incidencia
     * @param codigo Representación unica para objeto
     * @param cantidad Indica el numero de productos afectados
     * @param descripcion Descripción del motivo por el cual fueron desechados.
     * @param fecha Fecha de incidencia.
     */
    protected Incidencia(Integer codigo, Producto producto, Float cantidad, String tipoIncidencia, Date fecha) {
        this.codigo=codigo;
        this.cantidadAfectada=cantidad;
        this.producto = producto;
        this.tipoIncidencia = tipoIncidencia;
        this.fecha = fecha;
    }

}
