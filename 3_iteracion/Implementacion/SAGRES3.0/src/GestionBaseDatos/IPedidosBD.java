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
    public ArrayList<Pedido> obtienePedidosPreparandose();
    public int getNumPlatosEnCola();
    public int getNumBebidasEnCola();
    public void actualizaPedido(Pedido p);
    public Factura getFactura(int codMesa);
    public ArrayList<Pedido> getPedidosModificablesMesa(int codMesa);
    public void actualizaFactura(Factura f);
    public boolean nuevoPedido(Pedido pedido);
    public boolean eliminaPedido(int codPedido);

    public Pedido getSiguientePedidoBar();
    public Pedido getSiguientePedidoCocina();

    public int getCodigoPedido();

    public int getCodigoElementoPedido();
    
    public ArrayList<Integer> getFacturasEnCola();

    public ArrayList<Integer> getFacturasImprimidas();
    
    public Factura getFactNoPagada(int codMesa);

    public int getCodigoFactura();

    public ArrayList<Pedido> obtienePedidosMesa(int codMesa);

    public boolean nuevaFactura(Factura f);

    public boolean eliminaFactura(int codMesa);
}
