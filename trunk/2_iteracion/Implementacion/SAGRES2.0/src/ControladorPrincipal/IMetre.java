/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ControladorPrincipal;

import GestionCarta.Elemento;
import GestionCarta.ElementoBebida;
import GestionPedidos.Pedido;
import GestionStock.GestionIncidencias.Incidencia;
import GestionStock.GestionProductos.Producto;
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
    public abstract HashSet<Producto> obtenerBebidas();
    public abstract HashSet<Elemento> obtieneElementosConProducto(Producto pro);


    public abstract Pedido getSiguientePedidoBar()throws Exception;
    public abstract boolean seleccionaBebida(Pedido p, ElementoBebida bebida);
    public abstract int getNumBebidasEnCola();

}
