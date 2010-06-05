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
import GestionPedidos.ElementoColaBar;
import GestionPedidos.ElementoColaCocina;
import GestionPedidos.ElementoPedido;
import GestionPedidos.Factura;
import GestionPedidos.IGestorPedidos;
import GestionPedidos.Pedido;
import GestionStock.GestionIncidencias.IIncidencia;
import GestionStock.GestionIncidencias.Incidencia;
import GestionStock.GestionPedidoProveedor.IPedidoProveedor;
import GestionStock.GestionPedidoProveedor.PedidoProveedor;
import GestionStock.GestionProductos.IProducto;
import GestionStock.GestionProductos.Producto;
import Estadisticas.IGestorEstadisticas;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import org.jfree.data.category.DefaultCategoryDataset;
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
    IGestorEstadisticas iEstadisticas;

    public SAGRES(ICarta iCarta, IProducto iProducto, IIncidencia iIncidencia, IPedidoProveedor iPedido,
            IGestorPedidos gpedidos, IGestorEstadisticas iestadisticas){
        this.icarta = iCarta;
        this.iproducto = iProducto;
        this.iincidencia = iIncidencia;
        this.ipedidoproveedor = iPedido;
        this.ipedidos = gpedidos;
        this.iEstadisticas = iestadisticas;
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
        this.iproducto.restarCantidadProducto(prodCantidad.getFirst(),prodCantidad.getSecond());
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

    public void confirmaPagoFactura(int codMesa){
        this.ipedidos.confirmaPagoFactura(codMesa);
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

    public void imprimeFactura(int codMesa){
        this.ipedidos.imprimeFactura(codMesa);
    }

    public boolean modificaPedido(Integer codPedido, Integer codMesa, ArrayList<Pair<Elemento, String> > elementosPedido){
        return this.ipedidos.modificaPedido(codPedido, codMesa, elementosPedido);
    }

    public boolean nuevoPedido(Integer codMesa, ArrayList<Pair<Elemento,String> > elems){
        return this.ipedidos.nuevoPedido(codMesa, elems);
    }

    public ArrayList<ElementoPedido> obtieneElementos(Integer codPedido){
        return this.ipedidos.obtieneElementos(codPedido);
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

    public boolean seleccionaPlato(Pedido p, ElementoColaCocina ele) throws Exception{
        boolean exito = this.ipedidos.seleccionaPlato(p, ele);
        this.icarta.modificaElemento(ele.getElemento());
        return exito;
    }

    public boolean seleccionaBebida(Pedido pe, ElementoColaBar e) throws Exception{
        boolean exito = this.ipedidos.seleccionaBebida(pe, e);
        this.icarta.modificaElemento(e.getElemento());
        return exito;
    }

    public HashSet<Elemento> obtieneElementosDeSeccion(Seccion seccion) {
        return this.icarta.obtieneElementosDeSeccion(seccion);
    }

    public Factura getFactura(int codMesa){
        return this.ipedidos.getFactura(codMesa);
    }

    public ArrayList<Pedido> getPedidosModificablesMesa(int codMesa){
        return this.ipedidos.getPedidosModificablesMesa(codMesa);
    }
    
    public ArrayList<Integer> getFacturasEnCola(){
        return this.ipedidos.getFacturasEnCola();
    }

    public ArrayList<Integer> getFacturasImprimidas(){
        return this.ipedidos.getFacturasImprimidas();
    }

    public boolean eliminaPedido(int codPedido){
        return this.ipedidos.eliminaPedido(codPedido);
    }

    public Pedido getSiguientePedidoCocina() {
       return this.ipedidos.getSiguientePedidoCocina();
    }

    public Factura pideFactura(int codMesa){
        return this.ipedidos.pideFactura(codMesa);
    }

    public ArrayList<Pedido> obtienePedidosMesa(int codMesa){
        return this.ipedidos.obtienePedidosMesa(codMesa);
    }
     public DefaultCategoryDataset elementosAfectadosFaltaProductos(Timestamp i, Timestamp f){
        return this.iEstadisticas.elementosAfectadosFaltaProductos(i, f);
     }
     public DefaultCategoryDataset gananciasPorMes(Timestamp i, Timestamp f){
        return this.iEstadisticas.gananciasPorMes(i, f);
     }
     public DefaultCategoryDataset obtieneListaPlatoMasPedido(Timestamp i, Timestamp f, Seccion s){
        return this.iEstadisticas.obtieneListaPlatoMasPedido(i, f, s);
     }
     public DefaultCategoryDataset obtieneListaPlatoMenosPedido(Timestamp i, Timestamp f, Seccion s){
        return this.iEstadisticas.obtieneListaPlatoMasPedido(i, f, s);
     }

    public DefaultCategoryDataset obtieneListaPlatoMenosVendido(Timestamp i, Timestamp f, Seccion s) {
       return this.iEstadisticas.obtieneListaPlatoMenosPedido(i, f, s);
    }

}
