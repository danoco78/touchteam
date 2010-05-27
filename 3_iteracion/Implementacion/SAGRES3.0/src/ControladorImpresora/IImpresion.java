package ControladorImpresora;

import GestionPedidos.Factura;
import GestionStock.GestionProductos.Producto;
import java.util.HashMap;

/**
 * Interfaz para la impresión.
 *
 * @author Ángel Luis García
 */
public interface IImpresion {
    /**
     * Imprime la lista de productos y su cantidad que se van a pedir al proveedor.
     *
     * @param informacionPedido HashMap con la lista de (producto,cantidad) del pedido
     */
    public abstract void imprimePedido(HashMap<Producto, Float> informacionPedido);


    /**
     * Imprime la factura f
     *
     * @param f Factura a imprimir
     */
    public abstract void imprimeFactura(Factura f);
}
