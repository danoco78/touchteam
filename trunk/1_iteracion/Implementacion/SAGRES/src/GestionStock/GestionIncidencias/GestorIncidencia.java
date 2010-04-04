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
import java.util.Calendar;
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

    private static final String ULTIMOID =
            "select MAX(incidencia_id) from incidencia;";
    private static final String TABLAINCIDENCIAS =
            "select incidencia_id, descripcion, fecha, cantidad_afectada, producto_producto_id " +
            " from incidencia , tieneIncidencia " +
            " where incidencia_id = incidencia_incidencia_id";
    private static final String INI_INSERTAR_INCIDNECIA =
            "insert into incidencia(descripcion,fecha,cantidad_afectada) values (";
            /*"Caida",10/5/2011,10*/
    private static final String FIN_INSERTAR = ");";
    private static final String INI_INSERTAR_RELACION =
            "insert into tieneincidencia(incidencia_incidencia_id,producto_producto_id) values (";


    public GestorIncidencia( IGestionarProducto iGestorProductos, ICarta iCarta,
            IAlmacenamiento iAlmacenamiento, IProducto iProducto ){
        this.gestorProductos = iGestorProductos;
        this.carta = iCarta;
        this.almacen = iAlmacenamiento;
        this.almacenProductos = iProducto;
        TableModel datos = this.almacen.realizaConsulta(GestorIncidencia.TABLAINCIDENCIAS);
        this.incidencias = this.convertirTablaAIncidencia(datos);
    }
    

    public void nuevaIncidencia(String tipoIncidencia, float cantidadAfectada, Producto producto) {
            Calendar c = Calendar.getInstance();
            this.almacen.consultaDeModificacion(GestorIncidencia.INI_INSERTAR_INCIDNECIA
                    +tipoIncidencia+", '"
                    +c.get(Calendar.YEAR)+"/"+c.get(Calendar.MONTH)+"/"+c.get(Calendar.DAY_OF_MONTH)+"',"+
                    cantidadAfectada + GestorIncidencia.FIN_INSERTAR);
            TableModel datos = this.almacen.realizaConsulta(GestorIncidencia.ULTIMOID);
            Incidencia incidencia = new Incidencia((Integer)datos.getValueAt(0,0), producto,
                    cantidadAfectada, tipoIncidencia, null);
            this.incidencias.add(incidencia);
            this.almacen.consultaDeModificacion( GestorIncidencia.INI_INSERTAR_RELACION+
                    (Integer)datos.getValueAt(0,0)+", "+producto.getCodPro()+GestorIncidencia.FIN_INSERTAR );
    }

    private ArrayList<Incidencia> convertirTablaAIncidencia(TableModel tabla){
        ArrayList<Producto> listaProductos = this.almacenProductos.obtenerListaProductos();
        ArrayList<Incidencia> almacenIncidencias = new ArrayList<Incidencia>();
        for (int i = 0; i < tabla.getRowCount(); i++) {
            Producto producto = null;
            for (int j = 0; j < listaProductos.size(); j++) {
                if (listaProductos.get(j).getCodPro() == tabla.getValueAt(i, 4)) {
                    producto = listaProductos.get(j);
                }
            }
            Incidencia incidencia = new Incidencia((Integer) tabla.getValueAt(i, 0), producto,
                    (Float) tabla.getValueAt(i, 3), (String) tabla.getValueAt(i, 1), (Date) tabla.getValueAt(i, 2));
            almacenIncidencias.add(incidencia);
        }
        return almacenIncidencias;
    }

}
