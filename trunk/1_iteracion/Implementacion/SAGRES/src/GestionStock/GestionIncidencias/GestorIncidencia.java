/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package GestionStock.GestionIncidencias;

import GestionBaseDatos.IAlmacenamiento;
import GestionCarta.ICarta;
import GestionStock.GestionProductos.IGestionarProducto;
import GestionStock.GestionProductos.IProducto;
import GestionStock.GestionProductos.Producto;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.table.TableModel;

/**
 *
 * @author Daniel
 */
public class GestorIncidencia implements IIncidencia {

    IGestionarProducto gestorProductos;
    ICarta carta;
    IAlmacenamiento almacen;
    IProducto almacenProductos;
    ArrayList<Incidencia> incidencias;


    public GestorIncidencia( IGestionarProducto iGestorProductos, ICarta iCarta,
            IAlmacenamiento iAlmacenamiento, IProducto iProducto ){
        this.gestorProductos = iGestorProductos;
        this.carta = iCarta;
        this.almacen = iAlmacenamiento;
        this.almacenProductos = iProducto;
        TableModel datos = this.almacen.realizaConsulta("select incidencia_id, descripccion, fecha," +
                " cantidad_afectada, porducto_id from incidencia , tieneIncidencia  " +
                "where incidencia_id = incidencia_incidencia_id");
        ArrayList<Producto> listaProductos = this.almacenProductos.obtenListaProductos();
        for (int i = 0; i < datos.getRowCount(); i++) {
            Producto producto = null;
            for (int j = 0; j < listaProductos.size(); j++) {
                if( listaProductos.get(j).getCodPro() == datos.getValueAt(i, 4) )
                    producto = listaProductos.get(j);
            }
            Incidencia incidencia = new Incidencia((Integer)datos.getValueAt(i, 0), producto ,
                    (Float)datos.getValueAt(i, 3),(String)datos.getValueAt(i, 1),(Date)datos.getValueAt(i, 2));
            datos.getValueAt(i, 0);
        }
    }
    

    public void nuevaIncidencia(String tipoIncidencia, float cantidadAfectada, Producto producto) throws Exception {
            int codigo = this.generarCodigoIncidencia();
            Incidencia incidencia = new Incidencia(codigo, producto, cantidadAfectada, tipoIncidencia);
            this.gestorProductos.actualizaCantidadProdcuto(producto,-cantidadAfectada);
            this.almacen.consultaDeModificacion("insert ....");
            this.incidencias.add(incidencia);
    }

    private int generarCodigoIncidencia(){
        return 0;
    }

}
