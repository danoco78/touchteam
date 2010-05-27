/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ControladorPrincipal;

import GestionCarta.Elemento;
import GestionPedidos.ElementoColaBar;
import GestionPedidos.Factura;
import GestionPedidos.Pedido;
import GestionStock.GestionIncidencias.Incidencia;
import GestionStock.GestionProductos.Producto;
import java.util.ArrayList;
import java.util.HashSet;

/**
 *
 * @author Daniel
 *
 */
public interface IMetre {

    public abstract void eliminaProducto(Producto pro);
    public abstract void modificarProducto(Producto pro);
    public abstract void nuevoProducto(Producto pro);
    public abstract void nuevaIncidencia(Incidencia in);
    public abstract HashSet<Producto> obtenerBebidas();
    public abstract HashSet<Elemento> obtieneElementosConProducto(Producto pro);

    public abstract int getNumBebidasEnCola();
    public abstract Pedido getSiguientePedidoBar()throws Exception;
    public abstract boolean seleccionaBebida(Pedido pe, ElementoColaBar e)throws Exception;

    public Factura getFactura(int codMesa);
    public ArrayList<Integer> getFacturasEnCola();
    public ArrayList<Integer> getFacturasImprimidas();
    public abstract void confirmaPagoFactura(int codMesa);
    public abstract void imprimeFactura(int codMesa);
    
}
