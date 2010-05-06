/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ControladorPrincipal;

import GestionCarta.Elemento;
import GestionCarta.ICarta;
import GestionCarta.Seccion;
import GestionCarta.SeccionBebida;
import GestionCarta.SeccionComida;
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

    public SAGRES(ICarta iCarta, IProducto iProducto, IIncidencia iIncidencia, IPedidoProveedor iPedido){
        this.icarta = iCarta;
        this.iproducto = iProducto;
        this.iincidencia = iIncidencia;
        this.ipedidoproveedor = iPedido;
    }


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
        this.icarta.actualizaDisponibilidadElementos();// compruebaElementosConProducto(prodCantidad.getFirst());
    }

    public HashSet<Producto> obtenerBebidas() {
        return this.iproducto.obtieneBebidas();
    }

    public HashSet<Elemento> compruebaElementosInvalidos(HashMap<Producto, Float> lista) {
        return this.icarta.compruebaElementosInvalidados(lista);
    }

    public void imprimeListaProductosaPedir() {
        HashMap<Producto, Float> listaProductosCantidades = this.iproducto.obtieneProductosBajoMinimos();
        this.ipedidoproveedor.NuevoPedidoProveedor(listaProductosCantidades);
        this.ipedidoproveedor.imprimeListaProductosPedido(listaProductosCantidades);
    }

    public void modificaElemento(Elemento e) {
        this.icarta.modificaElemento(e);
    }

    public void notificaRecepcionPedido(PedidoProveedor ped) {
        HashMap<Producto, Float> listaProductosCantidades = ped.obtenerInfoPedido();
        this.iproducto.actualizaCantidadesProductos(listaProductosCantidades);
        this.ipedidoproveedor.pedidoRecibido(ped);
        this.icarta.actualizaDisponibilidadElementos();
    }

    public void nuevoElemento(Elemento e, Seccion sec) {
        this.icarta.nuevoElemento(e, sec);
    }

    public HashSet<Elemento> obtieneElementosConProducto(Producto pro) {
        return this.icarta.obtieneElementosConProducto(pro);
    }

    /*public HashSet<Elemento> obtieneElementosDeSeccion(Seccion seccion) {
        return this.icarta.obtieneElementosDeSeccion(seccion);
    }*/

    public HashSet<Producto> obtieneIngredientes() {
        return this.iproducto.obtieneIngredientes();
    }

    public PedidoProveedor obtienePedidoProveedor() {
        return this.ipedidoproveedor.obtienePrimerPedidoPendiente();
    }

    public  HashMap<Producto, Float> obtieneProductosBajoMinimos() {
        return this.iproducto.obtieneProductosBajoMinimos();
    }

    public HashSet<Producto> obtieneProductosSeccion(Seccion seccion) {
        if (seccion instanceof SeccionBebida)
            return this.iproducto.obtieneBebidas();
        else if (seccion instanceof SeccionComida)
            return this.iproducto.obtieneIngredientes();

        return null;
    }

    public HashSet<Seccion> obtieneSecciones() {
       return this.icarta.obtieneSecciones();
    }

    public void eliminaElemento(Elemento e) {
        this.icarta.eliminaElemento(e);
    }

    public HashSet<Elemento> obtieneElementos() {
        return this.icarta.obtieneElementos();
    }

}
