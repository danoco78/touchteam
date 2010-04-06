package GestionStock.GestionPedidoProveedor;



import GestionStock.GestionProductos.Producto;
import java.util.Date;
import java.util.HashMap;

/**
 * @author Daniel Guerrero Martinez
 */
public class PedidoProveedor {

    private Date fechaPedido;
    private boolean recibido;
    HashMap<Producto, Float> listaProductos;


    public PedidoProveedor(HashMap<Producto, Float> informacionPedido) {
        listaProductos = informacionPedido;
        recibido = false;
        fechaPedido = java.util.Calendar.getInstance().getTime();
    }

    /**
     * Construye un objeto pedidoProveedor con el estado especificado con los parametros.
     * @param recibido booleano que indica si el pedido ha sido recibido.
     * @param fechaHoy
     */
    protected PedidoProveedor(HashMap<Producto, Float> informacionPedido, Date fechaHoy, boolean recibido) {
        listaProductos = informacionPedido;
        this.recibido = recibido;
        this.fechaPedido = fechaHoy;
    }

    /**
     * Indica si el pedido fue recibido
     * @return true si fue recibido, false en caso contrario.
     */
    public boolean fueRecibido() {
        return this.recibido;
    }

    /**
     * Obtiene el valor de la fecha que tiene el pedidoProveedor
     * @return Date objeto tipo fecha que contiene la fecha del pedidoProveedor.
     */
    public Date getFechaPedido() {
        return fechaPedido;
    }

    /**
     * Modifica el estado del pedido
     * @param recibido Valor que tomara el estado del pedido true = recibido false = no recibido;
     */
    public void setRecibido(boolean recibido) {
        this.recibido = recibido;
    }

     /**
     * Obtiene la lista de productos con la cantidad que fue pedida
     * @return Devuelve un HashMap de productos como key y la cantidad que se pidio como valor.
     */
    HashMap<Producto, Float> obtenerInfoPedido() {
        return this.listaProductos;
    }
}
