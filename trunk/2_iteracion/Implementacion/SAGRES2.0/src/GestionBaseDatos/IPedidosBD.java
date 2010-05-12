/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package GestionBaseDatos;

import GestionCarta.Elemento;
import GestionPedidos.ElementoPedido;
import GestionPedidos.Factura;
import GestionPedidos.Pedido;
import java.util.ArrayList;
import utilidades.Pair;

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
    public ArrayList<Pedido> getPedidosModificablesMesa(int codMesa);
    public void actualizaFactura(Factura f);
    public boolean nuevoPedido(Pedido pedido);
    public boolean eliminaPedido(int codPedido);

    // TODO No esta reflejada en el diseño
    public Pedido getSiguientePedidoBar();
    public Pedido getSiguientePedidoCocina();

    public int getCodigoPedido();

    public int getCodigoElementoPedido();
    
    public ArrayList<Integer> getFacturasEnCola();

    public ArrayList<Integer> getFacturasImprimidas();
}
