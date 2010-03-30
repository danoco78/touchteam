package GestionBaseDatos;

import javax.swing.table.TableModel;

/**
 *
 * @author Daniel
 */
public interface IAlmacenamiento {

    public abstract boolean ConsultarDeModificacion(String SQL);
    public abstract TableModel RealizarConsulta( String SQL );

}
