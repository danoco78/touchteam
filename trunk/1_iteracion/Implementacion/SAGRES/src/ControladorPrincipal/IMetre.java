/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ControladorPrincipal;

import GestionCarta.Elemento;
import GestionStock.GestionIncidencias.Incidencia;
import GestionStock.GestionProductos.Bebida;
import GestionStock.GestionProductos.Producto;
import java.util.ArrayList;

/**
 *
 * @author Daniel
 */
public interface IMetre {

    public abstract void elimnaProducto(Producto pro);
    public abstract void modificarProducto(Producto pro);
    public abstract void nuevoProducto(Producto pro);
    public abstract void nuevaIncidencia(Incidencia in);
    public abstract ArrayList<Bebida> obtenerBebidas();
    public abstract ArrayList<Elemento> obtieneElementosConProducto(Producto pro);

}
