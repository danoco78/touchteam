/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ControladorPrincipal;

import GestionCarta.Elemento;
import GestionCarta.ICarta;
import GestionCarta.Seccion;
import GestionStock.GestionIncidencias.IIncidencia;
import GestionStock.GestionIncidencias.Incidencia;
import GestionStock.GestionPedidoProveedor.IPedidoProveedor;
import GestionStock.GestionPedidoProveedor.PedidoProveedor;
import GestionStock.GestionProductos.Bebida;
import GestionStock.GestionProductos.IProducto;
import GestionStock.GestionProductos.Ingrediente;
import GestionStock.GestionProductos.Producto;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Daniel
 */
public class SAGRES implements IMetre, ICocinero {

    ICarta icarta;
    IProducto iproducto;
    IIncidencia iincidencia;
    IPedidoProveedor ipedidoproveedor;

    public void elimnaProducto(Producto pro) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void modificarProducto(Producto pro) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void nuevoProducto(Producto pro) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void nuevaIncidencia(Incidencia in) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public ArrayList<Bebida> obtenerBebidas() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public ArrayList<Elemento> obtieneElementosConProducto(Producto pro) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public ArrayList<Elemento> compruebaElementosInvalidos(HashMap<Producto, Float> lista) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void elimnaElemento(Elemento e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void imprimeListaProductosaPedir() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void modificaElemento(Elemento e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void notificaRecepcionPedido(PedidoProveedor ped) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void nuevoElemento(Elemento e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public ArrayList<Elemento> obtieneElementosConProdcuto(Producto pro) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public ArrayList<Elemento> obtieneElementosSeccion(Seccion seccion) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public ArrayList<Ingrediente> obtieneIngredientes() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public PedidoProveedor obtienePedidoProveedor() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public HashMap<Producto, Float> obtieneProductosBajoMinimos() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public ArrayList<Producto> obtieneProductosSeccion(Seccion seccion) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public ArrayList<Seccion> obtieneSecciones() {
        throw new UnsupportedOperationException("Not supported yet.");
    }



}
