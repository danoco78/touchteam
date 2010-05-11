/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package GestionBaseDatos;

import GestionPedidos.Factura;
import GestionPedidos.Pedido;
import java.util.ArrayList;

/**
 *
 * @author Gaspar
 */
public interface IPedidosBD {
    public ArrayList<Pedido> obtienePedidosNoFacturados();
    public int getNumPlatosEnCola();
    public int getNumBebidasEnCola();
    public void actualizaPedido(Pedido p);
    public Factura getFactura(int codMesa);
    public ArrayList<Pedido> getPedidos(int codMesa);
    public void actualizaFactura(Factura f);

    // TODO No esta reflejada en el diseño
    public Pedido getSiguientePedidoBar();
}
