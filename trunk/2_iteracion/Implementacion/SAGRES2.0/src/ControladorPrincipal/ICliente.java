/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ControladorPrincipal;

import GestionCarta.Elemento;
import GestionCarta.Seccion;
import java.util.ArrayList;
import GestionPedidos.ElementoPedido;
import GestionPedidos.Factura;
import GestionPedidos.Pedido;
import java.util.HashSet;
import utilidades.Pair;

/**
 * @author Gaspar
 */
public interface ICliente {

    public abstract boolean nuevoPedido(Integer codMesa, ArrayList<Pair<Elemento,String> > elems);

    public abstract ArrayList<ElementoPedido> obtieneElementos(Integer codPedido);
    
    public abstract HashSet<Seccion> obtieneSecciones();

    public abstract HashSet<Elemento> obtieneElementosDeSeccion(Seccion seccion);

    public abstract ArrayList<Pedido> getPedidosModificablesMesa(int codMesa);

    public abstract boolean eliminaPedido(int codPedido);

    public abstract boolean modificaPedido(Integer codPedido, Integer codMesa, ArrayList<Pair<Elemento, String> > elementosPedido);
    
    public abstract Factura pideFactura(int codMesa);

    public abstract ArrayList<Pedido> obtienePedidosMesa(int codMesa);
}
