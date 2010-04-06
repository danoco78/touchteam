package GestionStock.GestionPedidoProveedor;

import ControladorImpresora.IImpresion;
import GestionBaseDatos.IAlmacenamiento;
import GestionCarta.Elemento;
import GestionCarta.ICarta;
import GestionStock.GestionProductos.IGestionarProducto;
import GestionStock.GestionProductos.IProducto;
import GestionStock.GestionProductos.Producto;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import utilidades.Pair;
import javax.swing.table.TableModel;

/**
 *
 * @author Daniel Guerrero Martinez
 */
public class GestorProveedor implements IPedidoProveedor {

    private IProducto intefazProductos;
    private IGestionarProducto gestionProducto;
    private ICarta gestionCarta;
    private IAlmacenamiento almacen;
    private IImpresion impresora;
    private ArrayList<PedidoProveedor> pedidos;
    private static final String ULTIMOID =
            "select MAX(pedido_proveedor_id) from pedidoproveedor;";
    private static final String TABLAPEIDDO =
            "select  pedido_proveedor_id ,fecha_pedido, recibido  from pedidoproveedor;";
    private static final String TABLAPRODUCTOSRELACIONADOS =
            "select producto_producto_id, cantidad from tienepedido where pedidoProveedor_pedido_proveedor_id = ";//+ID
    private static final String INI_INSERTAR_PEDIDO =
            "insert into pedidoproveedor(fecha_pedido,recibido) values (";//+DATOS
    private static final String FIN_INSERTAR = ");";
    private static final String INI_INSERTAR_RELACION =
            "insert into tienepedido values (";//+DATOS

    public GestorProveedor(IProducto IntefazProductos, IGestionarProducto GestionProducto, ICarta GestionCarta,
            IAlmacenamiento almacen, IImpresion Impresora) {
        this.pedidos = new ArrayList<PedidoProveedor>();
        this.almacen = almacen;
        this.gestionProducto = GestionProducto;
        this.gestionCarta = GestionCarta;
        this.intefazProductos = IntefazProductos;
        this.impresora = Impresora;
        TableModel datos = this.almacen.realizaConsulta(GestorProveedor.TABLAPEIDDO);
        ArrayList<Producto> listaProductos = this.intefazProductos.obtenerListaProductos();
        for (int i = 0; i < datos.getRowCount(); i++) {
            HashMap<Producto, Float> informacionPedido = new HashMap<Producto, Float>();
            TableModel codigosProductos =
                    this.almacen.realizaConsulta(GestorProveedor.TABLAPRODUCTOSRELACIONADOS
                    + (Integer) datos.getValueAt(i, 0));
            for (int j = 0; j < codigosProductos.getRowCount(); j++) {
                for (int k = 0; k < listaProductos.size(); k++) {
                    if ((Integer) codigosProductos.getValueAt(j, 0) == listaProductos.get(k).getCodPro()) {
                        informacionPedido.put(listaProductos.get(k), (Float) codigosProductos.getValueAt(j, 1));
                    }
                }
            }
            this.pedidos.add(new PedidoProveedor(informacionPedido,
                    (Date) datos.getValueAt(i, 1), (Boolean) datos.getValueAt(i, 2)));
        }

    }

    /**
     * Se encarga de obtener una lista de producto cuya cantidad disponible se inferior a la minima,
     * crea un objeto pedidoProveedor, haciendolo persistente en la base de datos, y
     * mandar el objeto al gestor de impresion.
     * @return Devuelve la lista con los producto que se han solicitado.
     * @throws Suelta una excepcion si no existen elementos para pedir.
     */
    public HashMap<Producto, Float> imprimeListaProductosPedido() throws Exception {
        ArrayList<Producto> listaProductos = this.intefazProductos.obtenerProductosBajoMinimos();
        if (!(listaProductos.isEmpty())) {
            HashMap<Producto, Float> informacionPedido = this.calculaCantidadesNecesarias(listaProductos);
            PedidoProveedor pedidoProveedor = new PedidoProveedor(informacionPedido);
            pedidos.add(pedidoProveedor);
            Calendar c = Calendar.getInstance();
            almacen.consultaDeModificacion(GestorProveedor.INI_INSERTAR_PEDIDO + " '"
                    + c.get(Calendar.YEAR) + "-" + c.get(Calendar.MONTH) + "-" + c.get(Calendar.DAY_OF_MONTH) + "',"
                    + "false" + GestorProveedor.FIN_INSERTAR);
            TableModel codigo = this.almacen.realizaConsulta(GestorProveedor.ULTIMOID);
            Iterator it = informacionPedido.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry aux = (Map.Entry) it.next();
                almacen.consultaDeModificacion(GestorProveedor.INI_INSERTAR_RELACION
                        + (Integer) codigo.getValueAt(0, 0) + ", " + ((Producto) aux.getKey()).getCodPro() + ", " + (Float) aux.getValue()
                        + GestorProveedor.FIN_INSERTAR);
            }
            impresora.imprimePedido(informacionPedido);
            return informacionPedido;
        } else {
            throw new Exception("No hay productos en stock por debajo de su limite minimo");
        }
    }

    /**
     * Se encarga de buscar el ultimo pedido realizado, habilitarlo como recibido, esto implica
     * un incremento de la cantidad del producto en el almacen y la activacion de platos cuyos ingredientes
     * antes estaban agotados.
     * @return Devuelve un par de elementos, El primero contiene la lista de productos y cantidad recibidos,
     * el segundo contiene una lista de elemento de la carta que han sido activados.
     * @throws Suelta una excepcion hay ningun pedido por recibir.
     */
    public Pair<HashMap<Producto, Float>, ArrayList<Elemento>> notificaRecepcionPedido() throws Exception {
        PedidoProveedor pedido = this.buscarSiguientePedido();
        if (pedido != null) {
            HashMap<Producto, Float> infoPedido = pedido.obtenerInfoPedido();
            Iterator it = infoPedido.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry aux = (Map.Entry) it.next();
                this.gestionProducto.actualizaCantidadProducto(((Producto) aux.getKey()), ((Float) aux.getValue()));
            }
            pedido.setRecibido(true);
            ArrayList<Elemento> listaHabilitados = this.gestionCarta.corrigeElementosInvalidados();
            return new Pair(infoPedido, listaHabilitados);
        } else {
            throw new Exception("No hay ningun pedido pendiente");
        }
    }

    /**
     * Dada una lista de productos calcula la cantidad necesaria para tener en el almacen el maximo de ese producto
     * @param listaProductos contiene la lista productos a la cual se le calculan las cantidades necesarias.
     * @return Devuelve un HashMap con los producto pasados por parametros y la cantidad a pedir.
     */
    private HashMap<Producto, Float> calculaCantidadesNecesarias(ArrayList<Producto> listaProductos) {
        HashMap<Producto, Float> informacionPedido = new HashMap<Producto, Float>(listaProductos.size());
        for (int i = 0; i < listaProductos.size(); i++) {
            Producto producto = listaProductos.get(i);
            informacionPedido.put(producto, (float) (producto.getMaximo() - producto.getCantidad()));
        }
        return informacionPedido;
    }

    /**
     * Recupera el Pedido mas antiguo no recibido.
     * @return objeto PedidoProveedor.
     */
    private PedidoProveedor buscarSiguientePedido() {
        for (int i = 0; i < this.pedidos.size(); i++) {
            if (this.pedidos.get(i).fueRecibido() == false) {
                return this.pedidos.get(i);
            }
        }
        return null;
    }
}
