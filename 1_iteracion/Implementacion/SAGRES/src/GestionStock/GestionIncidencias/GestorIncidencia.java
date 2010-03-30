/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package GestionStock.GestionIncidencias;

import GestionCarta.ICarta;
import GestionStock.GestionProductos.IGestionarProducto;
import GestionStock.GestionProductos.Producto;

/**
 *
 * @author Daniel
 */
public class GestorIncidencia implements IIncidencia {

    IGestionarProducto gestorProductos;
    ICarta carta;


    public GestorIncidencia( IGestionarProducto iGestorProductos, ICarta Carta){
        this.gestorProductos = iGestorProductos;
        this.carta = Carta;
    }
    

    public void nuevaIncidencia(int tipoIncidencia, float cantidadAfectada, Producto producto) throws Exception {
        boolean datosCorrectos = comprobarCantidadIntroducida(cantidadAfectada);
        if(datosCorrectos){
            Incidencia incidencia = new Incidencia(producto, cantidadAfectada, tipoIncidencia );
            this.gestorProductos.actualizarCantidadProdcuto(producto,-cantidadAfectada);
        }else{
            throw new Exception("Los datos introducidos no son correctos");
        }
    }

    private boolean comprobarCantidadIntroducida(float cantidad){
        return true;
    }

    private int generarCodigoIncidencia(){
        return 0;
    }

}
