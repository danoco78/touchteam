/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ControladorPrincipal;

import GestionCarta.Elemento;
import GestionCarta.ElementoPlato;
import GestionCarta.Seccion;
import GestionPedidos.ElementoColaCocina;
import GestionStock.GestionIncidencias.Incidencia;
import GestionStock.GestionPedidoProveedor.PedidoProveedor;
import GestionStock.GestionProductos.Ingrediente;
import GestionStock.GestionProductos.Producto;
import GestionPedidos.Pedido;
import GestionPedidos.ElementoPedido;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 *
 * @author Daniel
 */
public interface ICocinero {

    public abstract HashSet<Elemento> compruebaElementosInvalidos(HashMap<Producto,Float> lista);
    public abstract void eliminaElemento(Elemento e);
    public abstract void imprimeListaProductosaPedir();
    public abstract void modificaElemento(Elemento e);
    public abstract void notificaRecepcionPedido(PedidoProveedor ped);
    public abstract void nuevaIncidencia(Incidencia in);
    public abstract void nuevoElemento(Elemento e, Seccion sec);
    public abstract HashSet<Elemento> obtieneElementosConProducto(Producto pro);
    public abstract HashSet<Ingrediente> obtieneIngredientes();
    public abstract PedidoProveedor obtienePedidoProveedor();
    public abstract HashSet<Producto> obtieneProductosBajoMinimos();
    public abstract HashSet<Seccion> obtieneSecciones();
    public abstract Pedido getSiguientePedidoCocinaEnCola()throws Exception;
    public abstract Pedido getSiguientePedidoCocinaPreparandose();
    public abstract int getNumPlatosEnCola();
    public abstract ArrayList<Pedido> getPedidosCocinaPreparandose()throws Exception;
    public abstract boolean seleccionaPlato(Pedido p, ElementoColaCocina ele)throws Exception;
}
