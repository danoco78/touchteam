/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package estadisticas;

import GestionCarta.Seccion;
import java.sql.Timestamp;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author nabil
 */
public class GestorEstadisticas implements IGestorEstadisticas{

    public DefaultCategoryDataset elementosAfectadosFaltaProductos(Timestamp i, Timestamp f) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public DefaultCategoryDataset gananciasPorMes(Timestamp i, Timestamp f) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public DefaultCategoryDataset obtieneListaPlatoMasPedido(Timestamp i, Timestamp f, Seccion s) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public DefaultCategoryDataset obtieneListaPlatoMenosPedido(Timestamp i, Timestamp f, Seccion s) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

 
}
