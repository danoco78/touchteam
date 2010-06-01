/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package estadisticas;
import GestionCarta.Seccion;
import org.jfree.data.category.DefaultCategoryDataset;
import java.util.Date;

/**
 *
 * @author nabil
 */
public interface IGestorEstadisticas {
    public     DefaultCategoryDataset elementosAfectadosFaltaProductos(Date i, Date f);
    public     DefaultCategoryDataset gananciasPorMes(Date i, Date f);
    public     DefaultCategoryDataset obtieneListaPlatoMasPedido(Date i, Date f, Seccion s);
    public     DefaultCategoryDataset obtieneListaPlatoMenosPedido(Date i, Date f, Seccion s);
}
