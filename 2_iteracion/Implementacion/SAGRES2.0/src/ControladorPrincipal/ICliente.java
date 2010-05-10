/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ControladorPrincipal;

import GestionCarta.Elemento;
import GestionCarta.Seccion;
import java.util.ArrayList;
import GestionPedidos.ElementoPedido;
import GestionPedidos.Pedido;
import java.util.HashSet;

/**
 * @author Gaspar
 */
public interface ICliente {

    public abstract ArrayList<Pedido> iniciaModificaPedido(Integer codMesa);

    public abstract boolean modificaPedido(Integer codPedido, ArrayList<ElementoPedido> elems);

    public abstract boolean nuevoPedido(Integer codMesa, ArrayList<ElementoPedido> elems);

    public abstract ArrayList<ElementoPedido> obtieneElementos(Integer codPedido);
    
    public abstract HashSet<Seccion> obtieneSecciones();

    public HashSet<Elemento> obtieneElementosDeSeccion(Seccion seccion);

    public HashSet<Elemento> obtieneElementos();
}
