package GestionBaseDatos;

import javax.swing.table.TableModel;

/**
 * Interfaz de comunicación con la Base de Datos.
 *
 * @author Daniel, Ángel Luis García
 */
public interface IAlmacenamiento {

    public abstract boolean consultaDeModificacion(String SQL);
    public abstract boolean consultaDeModificacionBlob(String SQL, byte[] bytes);
    public abstract TableModel realizaConsulta( String SQL );

}
