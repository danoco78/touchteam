/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ControladorPrincipal;

import GestionCarta.Elemento;
import GestionCarta.ElementoBebida;
import GestionCarta.ElementoPlato;
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
import GestionPedidos.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import utilidades.Pair;

/**
 *
 * @author Daniel
 */
public class SAGRES implements IMetre, ICocinero, ICliente {

    ICarta icarta;
    IProducto iproducto;
    IIncidencia iincidencia;
    IPedidoProveedor ipedidoproveedor;
    IGestorPedidos ipedidos;

    public SAGRES(ICarta iCarta, IProducto iProducto, IIncidencia iIncidencia, 
            IPedidoProveedor iPedido, IGestorPedidos iPedidos){
        this.icarta = iCarta;
        this.iproducto = iProducto;
        this.iincidencia = iIncidencia;
        this.ipedidoproveedor = iPedido;
        this.ipedidos = iPedidos;
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

    public HashSet<Bebida> obtenerBebidas() {
        return this.iproducto.obtieneBebidas();
    }

    public HashSet<Elemento> compruebaElementosInvalidos(HashMap<Producto, Float> lista) {
        return this.icarta.compruebaElementosInvalidados(lista);
    }

    public void imprimeListaProductosaPedir() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void modificaElemento(Elemento e) {
        this.icarta.modificaElemento(e);
    }

    public void notificaRecepcionPedido(PedidoProveedor ped) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void nuevoElemento(Elemento e, Seccion sec) {
        this.icarta.nuevoElemento(e, sec);
    }

    public HashSet<Elemento> obtieneElementosConProducto(Producto pro) {
        return this.icarta.obtieneElementosConProducto(pro);
    }

    public HashSet<Ingrediente> obtieneIngredientes() {
        return this.iproducto.obtieneIngredientes();
    }

    public PedidoProveedor obtienePedidoProveedor() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public HashSet<Producto> obtieneProductosBajoMinimos() {
        return this.iproducto.obtieneProductosBajoMinimos();
    }

    public HashSet<Producto> obtieneProductosSeccion(Seccion seccion) {
        /*if (seccion instanceof SeccionBebida)
            return this.iproducto.obtieneBebidas();
        else if (seccion instanceof SeccionComida)
            return this.iproducto.obtieneIngredientes();*/

        return null;
    }

    public HashSet<Seccion> obtieneSecciones() {
       return this.icarta.obtieneSecciones();
    }

    public void eliminaElemento(Elemento e) {
        this.icarta.eliminaElemento(e);
    }

    public void confirmaPagoFactura(Integer codMesa){

    }

    public ArrayList<String> getInfoRest(){
        return this.ipedidos.getInfoRest();
    }

    public Pedido getSiguientePedidoBar()throws Exception{
        return this.ipedidos.getSiguientePedidoBar();
    }

    public Pedido getSiguientePedidoCocinaEncola() throws Exception{
        return this.ipedidos.getSiguientePedidoCocinaEncola();
    }

    public Pedido getSiguientePedidoCocinaPreparandose(){
        return this.ipedidos.getSiguientePedidoCocinaPreparandose();
    }

    public void imprimeFactura(Integer codMesa){
        this.ipedidos.imprimeFactura(codMesa);
    }

    public void imprimeFacturas(){
        //this.ipedidos.imprimeFacturas();
    }

    public ArrayList<Pedido> iniciaModificaPedido(Integer codMesa){
        return this.ipedidos.iniciaModificaPedido(codMesa);
    }

    public boolean modificaPedido(Integer codPedido, ArrayList<ElementoPedido> elems){
        return this.ipedidos.modificaPedido(codPedido, elems);
    }

    public boolean nuevoPedido(Integer codMesa, ArrayList<ElementoPedido> elems){
        return this.ipedidos.nuevoPedido(codMesa, elems);
    }

    public ArrayList<ElementoPedido> obtieneElementos(Integer codPedido){
        return this.ipedidos.obtieneElementos(codPedido);
    }
    //TODO Preguntar por estas dos siguientes funciones
    public boolean seleccionaBebida(Pedido p, ElementoBebida bebida){
        return this.ipedidos.seleccionaBebida(p, bebida);
    }

    public boolean seleccionaPlato(Pedido p, ElementoPlato plato){
        return this.ipedidos.seleccionaPlato(p, plato);
    }

    public Pedido getSiguientePedidoCocinaEnCola()throws Exception {
        return this.ipedidos.getSiguientePedidoCocinaEncola();
    }

    public int getNumPlatosEnCola() {
        return this.ipedidos.getNumPlatosEnCola();
    }
    public int getNumBebidasEnCola(){
        return this.ipedidos.getNumBebidasEnCola();
    }

    public ArrayList<Pedido> getPedidosCocinaPreparandose() throws Exception{
        return this.ipedidos.getPedidosCocinaPreparandose();
    }
}
