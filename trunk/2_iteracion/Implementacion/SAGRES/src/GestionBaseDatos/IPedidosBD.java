/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package GestionBaseDatos;

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
}
