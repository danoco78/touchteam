/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ControladorPrincipal;

import GestionCarta.Elemento;
import GestionCarta.Seccion;
import GestionStock.GestionIncidencias.Incidencia;
import GestionStock.GestionPedidoProveedor.PedidoProveedor;
import GestionStock.GestionProductos.Producto;
import java.util.HashMap;
import java.util.HashSet;

/**
 *
 * @author Daniel
 */
public interface ICocinero {

    public abstract HashSet<Elemento> compruebaElementosInvalidos(HashMap<Producto,Float> lista);
    public abstract void eliminaProducto(Producto pro);
    public abstract void modificarProducto(Producto pro);
    public abstract void nuevoProducto(Producto pro);
    public abstract void eliminaElemento(Elemento e);
    public abstract void imprimeListaProductosaPedir();
    public abstract void modificaElemento(Elemento e);
    public abstract void notificaRecepcionPedido(PedidoProveedor ped);
    public abstract void nuevaIncidencia(Incidencia in);
    public abstract void nuevoElemento(Elemento e, Seccion sec);
    public abstract HashSet<Elemento> obtieneElementosConProducto(Producto pro);
    public abstract HashSet<Producto> obtieneIngredientes();
    public abstract PedidoProveedor obtienePedidoProveedor();
    public abstract  HashMap<Producto, Float> obtieneProductosBajoMinimos();
    public abstract HashSet<Seccion> obtieneSecciones();
    public abstract HashSet<Producto> obtieneProductosSeccion(Seccion seccion);
    public abstract HashSet<Elemento> obtieneElementos();
    //public abstract HashSet<Elemento> obtieneElementosDeSeccion(Seccion seccion);
    
}
