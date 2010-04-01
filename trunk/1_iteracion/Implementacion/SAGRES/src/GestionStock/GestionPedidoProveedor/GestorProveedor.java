

package GestionStock.GestionPedidoProveedor;

import ControladorImpresora.IImpresion;
import GestionBaseDatos.IAlmacenamiento;
import GestionCarta.Elemento;
import GestionCarta.ICarta;
import GestionStock.GestionProductos.IProducto;
import GestionStock.GestionProductos.Producto;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Pair;

/**
 *
 * @author Daniel
 */
public class GestorProveedor implements IPedidoProveedor {

    private IProducto gestionProductos;
    private ICarta gestionCarta;
    private IAlmacenamiento almacen;
    private IImpresion impresora;
    private ArrayList<PedidoProveedor> pedidos;


    /*FALTA CONSTRUCTO*/


    public HashMap<Producto, Float> imprimeListaProductosPedido() throws Exception {
        ArrayList<Producto> listaProductos = this.gestionProductos.obtenerProductosBajoMinimos();
        if( !(listaProductos.isEmpty()) ){
            HashMap<Producto, Float> informacionPedido = this.calculaCantidadesNecesarias(listaProductos);
            PedidoProveedor pedidoProveedor = new PedidoProveedor(informacionPedido);
            pedidos.add(pedidoProveedor);
            almacen.consultaDeModificacion("insert .....");
            impresora.imprimePedido(informacionPedido);
            return informacionPedido;
        }else{
            throw new Exception("No hay productos en stock por debajo de su limite minimo");
        }
    }

    public Pair<HashMap<Producto, Float>, ArrayList<Elemento>> notificaRecepcionPedido() {
        return null;
    }

    private HashMap<Producto, Float> calculaCantidadesNecesarias(ArrayList<Producto> listaProductos) {
        HashMap<Producto, Float> informacionPedido = new HashMap<Producto, Float>(listaProductos.size());
        for (int i = 0; i < listaProductos.size(); i++) {
            Producto producto = listaProductos.get(i);
            informacionPedido.put(producto, (float)(producto.getMaximo() - producto.getCantidad()) );
        }
        return informacionPedido;
    }

}
