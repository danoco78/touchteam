/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ControladorPrincipal;

import GestionCarta.Elemento;
import GestionCarta.Seccion;
import GestionStock.GestionIncidencias.Incidencia;
import GestionStock.GestionPedidoProveedor.PedidoProveedor;
import GestionStock.GestionProductos.Ingrediente;
import GestionStock.GestionProductos.Producto;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Daniel
 */
public interface ICocinero {

    public abstract ArrayList<Elemento> compruebaElementosInvalidos(HashMap<Producto,Float> lista);
    public abstract void elimnaElemento(Elemento e);
    public abstract void imprimeListaProductosaPedir();
    public abstract void modificaElemento(Elemento e);
    public abstract void notificaRecepcionPedido(PedidoProveedor ped);
    public abstract void nuevaIncidencia(Incidencia in);
    public abstract void nuevoElemento(Elemento e);
    public abstract ArrayList<Elemento> obtieneElementosConProdcuto(Producto pro);
    public abstract ArrayList<Elemento> obtieneElementosSeccion(Seccion seccion);
    public abstract ArrayList<Ingrediente> obtieneIngredientes();
    public abstract PedidoProveedor obtienePedidoProveedor();
    public abstract HashMap<Producto,Float> obtieneProductosBajoMinimos();
    public abstract ArrayList<Producto> obtieneProductosSeccion(Seccion seccion);
    public abstract ArrayList<Seccion> obtieneSecciones();
    
}
