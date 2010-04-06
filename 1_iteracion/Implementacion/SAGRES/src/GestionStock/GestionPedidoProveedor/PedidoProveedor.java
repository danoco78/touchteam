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

    /*
     * Marca el estado del pedidoProveedor como recibido
     */
    public boolean fueRecibido() {
        return this.recibido;
    }

    /*
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

    HashMap<Producto, Float> obtenerInfoPedido() {
        return this.listaProductos;
    }
}