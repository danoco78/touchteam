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
import java.util.HashSet;
import utilidades.Pair;

/**
 *
 * @author Daniel
 */
public class SAGRES implements IMetre, ICocinero {

    ICarta icarta;
    IProducto iproducto;
    IIncidencia iincidencia;
    IPedidoProveedor ipedidoproveedor;

    public void eliminaProducto(Producto pro) {
        this.iproducto.eliminaProducto(pro);
        HashSet<Elemento> listaElementos = this.icarta.obtieneElementosConProducto(pro);
        this.icarta.deshabilitaElementos(listaElementos);
    }

    public void modificarProducto(Producto pro) {
        this.iproducto.modificaProducto(pro);
    }

    public void nuevoProducto(Producto pro) {
        this.iproducto.nuevoProducto(pro);
    }

    public void nuevaIncidencia(Incidencia in) {
        this.iincidencia.nuevaIncidencia(in);
        Pair<Producto,Float> prodCantidad = in.getProductoCantidad();
        this.iproducto.restarCantidadProducto(prodCantidad);
        this.icarta.compruebaElementosConProducto(prodCantidad.getFirst());
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

    public void eliminaElemento(Elemento e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }



}
