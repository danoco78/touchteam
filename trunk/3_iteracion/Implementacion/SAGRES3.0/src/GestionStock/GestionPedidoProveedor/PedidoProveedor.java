package GestionStock.GestionPedidoProveedor;



import GestionStock.GestionProductos.Producto;
import java.sql.Timestamp;
import java.util.HashMap;

/**
 * @author Daniel Guerrero Martinez
 */
public class PedidoProveedor {

    private int codigo;
    private Timestamp fechaPedido;
    private boolean recibido;
    HashMap<Producto, Float> listaProductos;


    public PedidoProveedor(HashMap<Producto, Float> informacionPedido) {
        listaProductos = informacionPedido;
        recibido = false;
        fechaPedido = new Timestamp(java.util.Calendar.getInstance().getTimeInMillis());
    }

    /**
     * Construye un objeto pedidoProveedor con el estado especificado con los parametros.
     * @param recibido booleano que indica si el pedido ha sido recibido.
     * @param fechaHoy
     */
    public PedidoProveedor(int codigo, HashMap<Producto, Float> informacionPedido, Timestamp fechaHoy, boolean recibido) {
        this.codigo = codigo;
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
     * @return Timestamp objeto tipo fecha que contiene la fecha del pedidoProveedor.
     */
    public Timestamp getFechaPedido() {
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
    public HashMap<Producto, Float> obtenerInfoPedido() {
        return this.listaProductos;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    
}
