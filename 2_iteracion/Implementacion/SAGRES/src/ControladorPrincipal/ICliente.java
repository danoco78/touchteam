/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ControladorPrincipal;

import java.util.ArrayList;
import GestionPedidos.ElementoPedido;
import GestionPedidos.Pedido;

/**
 * @author Gaspar
 */
public interface ICliente {

    public abstract ArrayList<Pedido> iniciaModificaPedido(Integer codMesa);

    public abstract boolean modificaPedido(Integer codPedido, ArrayList<ElementoPedido> elems);

    public abstract boolean nuevoPedido(Integer codMesa, ArrayList<ElementoPedido> elems);

    public abstract ArrayList<ElementoPedido> obtieneElementos(Integer codPedido);
}