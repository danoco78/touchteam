/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ControladorPrincipal;

import GestionCarta.Elemento;
import GestionCarta.ElementoBebida;
import GestionStock.GestionIncidencias.Incidencia;
import GestionStock.GestionProductos.Bebida;
import GestionStock.GestionProductos.Producto;
import GestionPedidos.ElementoPedido;
import GestionPedidos.Pedido;
import java.util.ArrayList;
import java.util.HashSet;

/**
 *
 * @author Daniel
 */
public interface IMetre {

    public abstract void eliminaProducto(Producto pro);
    public abstract void modificarProducto(Producto pro);
    public abstract void nuevoProducto(Producto pro);
    public abstract void nuevaIncidencia(Incidencia in);
    public abstract HashSet<Bebida> obtenerBebidas();
    public abstract HashSet<Elemento> obtieneElementosConProducto(Producto pro);
    public abstract Pedido getSiguientePedidoBar()throws Exception;
    public abstract boolean seleccionaBebida(Pedido p, ElementoBebida bebida);
    public abstract int getNumBebidasEnCola();
}
