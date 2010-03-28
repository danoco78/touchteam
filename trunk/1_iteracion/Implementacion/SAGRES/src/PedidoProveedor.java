

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Daniel Guerrero Martinez
 */
public class PedidoProveedor {

    private Date fechaPedido;
    private boolean recibido;
    List listaProductos;

    public PedidoProveedor() {
        fechaPedido = new Date();
        this.recibido = false;
        listaProductos = new ArrayList();
    }

    @Override
    public void finalize() throws Throwable {
    }

    /**
     * Construye un objeto pedidoProveedor con el estado especificado con los parametros.
     * @param recibido booleano que indica si el pedido ha sido recibido.
     * @param fechaHoy
     */
    public PedidoProveedor(boolean recibido, Date fechaHoy) {
        this.recibido = recibido;
        this.fechaPedido = fechaHoy;
    }

    /*
     * Marca el estado del pedidoProveedor como recibido
     */
    public void fueRecibido() {
        recibido = true;
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
}
