package GestionStock.GestionIncidencias;


import GestionStock.GestionProductos.Producto;
import java.util.Date;
import utilidades.Pair;


/**
 *
 * @author Daniel Guerrero Martinez
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
    public Incidencia(Producto producto, float cantidad, String tipoIncidencia) {
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

    public Pair<Producto,Float> getProductoCantidad(){
         return new Pair<Producto,Float>(this.producto,this.cantidadAfectada);
     }

    public float getCantidadAfectada() {
        return cantidadAfectada;
    }

    public void setCantidadAfectada(float cantidadAfectada) {
        this.cantidadAfectada = cantidadAfectada;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public String getTipoIncidencia() {
        return tipoIncidencia;
    }

    public void setTipoIncidencia(String tipoIncidencia) {
        this.tipoIncidencia = tipoIncidencia;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }



}
