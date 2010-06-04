/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Estadisticas;
import org.jfree.data.category.DefaultCategoryDataset;
import java.sql.Timestamp;
import GestionCarta.Seccion;
/**
 *
 * @author nabil
 */
public interface IGestorEstadisticas {
     public DefaultCategoryDataset elementosAfectadosFaltaProductos(Timestamp i, Timestamp f);
     public DefaultCategoryDataset gananciasPorMes(Timestamp i, Timestamp f);
     public DefaultCategoryDataset obtieneListaPlatoMasPedido(Timestamp i, Timestamp f, Seccion s);
     public DefaultCategoryDataset obtieneListaPlatoMenosPedido(Timestamp i, Timestamp f, Seccion s);
}
