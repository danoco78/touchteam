
package GestionBaseDatos;

import GestionCarta.Carta;
import GestionCarta.Elemento;
import GestionCarta.ElementoBebida;
import GestionCarta.ElementoPlato;
import GestionCarta.Seccion;
import com.mysql.jdbc.Connection;
import java.util.HashSet;
import java.util.Iterator;
import javax.swing.table.TableModel;
import utilidades.Imagen;

/**
 *
 * @author Ángel Luis García, Carlos Salas, Daniel Guerrero y José David Dionisio
 */
public class GestorBaseDatos implements ICartaBD {

    Connection Conexion;
    IAlmacenamiento almacen;

    public GestorBaseDatos(IAlmacenamiento iAlmacenamiento) {
        this.almacen = iAlmacenamiento;
    }

    public void deshabilitaElementos(HashSet<Elemento> listaElementos) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void eliminaElemento(Elemento elemento) {
        this.almacen.consultaDeModificacion("DELETE FROM elemento WHERE elemento_id="+elemento.getCodigoElemento());
    }

    public void habilitaElementos(HashSet<Elemento> listaElementos) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void modificaElementoBebida(ElementoBebida elemento) {

        String consulta;

        if ( elemento != null){
            consulta = "UPDATE elemento SET nombre = '"+elemento.getNombre()+"', descripcion = '"+elemento.getDescripcion()+"', precio = "+elemento.getPrecio()+", divi_max="+elemento.getDivisionesMaximas()+" WHERE elemento.elemento_id = "+elemento.getCodigoElemento();
            this.almacen.consultaDeModificacion(consulta);
            consulta = "UPDATE elemento SET foto = ? WHERE elemento.elemento_id = "+elemento.getCodigoElemento();
            this.almacen.consultaDeModificacionBlob(consulta, Imagen.imageIconToByteArray(elemento.getFoto()));
        }
    }

    public void modificaElementoPlato(ElementoPlato elemento) {
        String consulta;

        if ( elemento != null){
            consulta = "UPDATE elemento SET nombre = '"+elemento.getNombre()+"', descripcion = '"+elemento.getDescripcion()+"', precio = "+elemento.getPrecio()+", divi_max="+elemento.getDivisionesMaximas()+" WHERE elemento.elemento_id = "+elemento.getCodigoElemento();
            this.almacen.consultaDeModificacion(consulta);
            consulta = "UPDATE elemento SET foto = ? WHERE elemento.elemento_id = "+elemento.getCodigoElemento();
            this.almacen.consultaDeModificacionBlob(consulta, Imagen.imageIconToByteArray(elemento.getFoto()));
            consulta = "UPDATE elementoplato SET tiempo_eleboracion = "+elemento.getTiempoElaboracion() + " WHERE elementoplato.elemento_elemento_id = "+elemento.getCodigoElemento();
        }
    }

    public void nuevoElementoBebida(ElementoBebida elemento) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void nuevoElementoPlato(ElementoPlato elemento) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public HashSet<Elemento> obtieneElementos() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public HashSet<Elemento> obtieneElementosInvalidados() {
        HashSet<Elemento> elementosInvalidos = new HashSet<Elemento>();

        String consulta;

        //Primero vemos las bebidas invalidadas
        //SELECT elemento_id, nombre, descripcion, foto, precio, divi_max FROM elemento, elementobebida WHERE elemento.elemento_id = elementobebida.elemento_elemento_id"
        consulta = "SELECT elemento_id, nombre, descripcion, disponible, foto, divi, divi_max, precio FROM elemento, elementobebida WHERE elemento.elemento_id = elementobebida.elemento_elemento_id AND elemento.disponible = 0";
        return elementosInvalidos;
    }

    public HashSet<Seccion> obtieneSecciones() {
        HashSet<Seccion> listaSecciones=null;
        TableModel tabla;
        // Construimos el objeto Carta necesario para crear una Seccion
        tabla = this.almacen.realizaConsulta("SELECT ultima_modificacion FROM carta");
        Carta carta = new Carta((java.sql.Date)tabla.getValueAt(0,0));
        // Obtenemos todas las secciones de la carta
        tabla = this.almacen.realizaConsulta("SELECT seccion_id, nombre FROM seccion");
        // Para cada seccion obtenida, creamos su objeto e insertamos en el HashSet
        for(int i=0;i<tabla.getRowCount();i++) {
            Seccion seccion = new Seccion((Integer)tabla.getValueAt(i, 0), (String)tabla.getValueAt(i, 1), carta);
            listaSecciones.add(seccion);
        }
        return listaSecciones;
    }

}