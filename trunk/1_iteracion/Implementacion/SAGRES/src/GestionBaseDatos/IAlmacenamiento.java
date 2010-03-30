package GestionBaseDatos;

import javax.swing.table.TableModel;

/**
 *
 * @author Daniel
 */
public interface IAlmacenamiento {

    public abstract boolean consultaDeModificacion(String SQL);
    public abstract TableModel realizaConsulta( String SQL );

}
