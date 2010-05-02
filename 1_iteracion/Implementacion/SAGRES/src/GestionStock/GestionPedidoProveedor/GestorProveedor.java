package GestionStock.GestionPedidoProveedor;

import ControladorImpresora.IImpresion;
import GestionBaseDatos.IStockBD;
import GestionStock.GestionProductos.Producto;
import java.util.HashMap;

/**
 *
 * @author Daniel Guerrero Martinez
 */
public class GestorProveedor implements IPedidoProveedor {
    private IImpresion impresora;
    private IStockBD istockBD;

    public GestorProveedor( IStockBD almacen, IImpresion Impresora) {
        this.impresora = Impresora;
        this.istockBD = almacen;
    }

    public void imprimeListaProductosPedido(HashMap<Producto, Float> listaProductosCantidad) {
        this.impresora.imprimePedido(listaProductosCantidad);
    }

    public void NuevoPedidoProveedor(HashMap<Producto, Float> listaProductosCantidad) {
        PedidoProveedor pd = new PedidoProveedor(listaProductosCantidad);
        this.istockBD.nuevoPedidoProveedor(pd);
    }

    public PedidoProveedor obtienePrimerPedidoPendiente() {
        return this.istockBD.obtienePrimerPedidoPendiente();
    }

    public void pedidoRecibido(PedidoProveedor pedProveedor) {
        pedProveedor.setRecibido(true);
        this.istockBD.pedidoRecibido(pedProveedor);
    }
}
