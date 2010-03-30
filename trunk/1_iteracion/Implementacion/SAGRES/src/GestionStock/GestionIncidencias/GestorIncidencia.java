/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package GestionStock.GestionIncidencias;

import GestionBaseDatos.IAlmacenamiento;
import GestionCarta.ICarta;
import GestionStock.GestionProductos.IGestionarProducto;
import GestionStock.GestionProductos.Producto;
import java.util.ArrayList;

/**
 *
 * @author Daniel
 */
public class GestorIncidencia implements IIncidencia {

    IGestionarProducto gestorProductos;
    ICarta carta;
    IAlmacenamiento almacen;
    ArrayList<Incidencia> incidencias;


    public GestorIncidencia( IGestionarProducto iGestorProductos, ICarta Carta){
        this.gestorProductos = iGestorProductos;
        this.carta = Carta;
    }
    

    public void nuevaIncidencia(int tipoIncidencia, float cantidadAfectada, Producto producto) throws Exception {
        boolean datosCorrectos = comprobarCantidadIntroducida(cantidadAfectada);
        if(datosCorrectos){
            int codigo = this.generarCodigoIncidencia();
            Incidencia incidencia = new Incidencia(codigo, producto, cantidadAfectada, tipoIncidencia);
            this.gestorProductos.actualizaCantidadProdcuto(producto,-cantidadAfectada);
            this.almacen.consultaDeModificacion("insert ....");
            this.incidencias.add(incidencia);
        }else{
            throw new Exception("Los datos introducidos no son correctos");
        }
    }

    private boolean comprobarCantidadIntroducida(float cantidad){
        if( cantidad > 0 )
            return true;
        else
            return false;
    }

    private int generarCodigoIncidencia(){
        return 0;
    }

}
