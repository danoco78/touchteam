/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package estadisticas;

import GestionCarta.Seccion;
import java.util.Date;
import org.jfree.data.category.DefaultCategoryDataset;
import GestionBaseDatos.IEstadisticasBD;

/**
 *
 * @author nabil
 */
public class GestorEstadisticas implements IGestorEstadisticas{

    IEstadisticasBD iEstadisticasBD;

    public GestorEstadisticas(IEstadisticasBD iEstadisticasBD){
        this.iEstadisticasBD = iEstadisticasBD;

    }
    public DefaultCategoryDataset elementosAfectadosFaltaProductos(Date i, Date f) {
        DefaultCategoryDataset elementosAfectados;
        elementosAfectados = this.iEstadisticasBD.elementosAfectadosFaltaProductos(i, f);
        return elementosAfectados;
    }

    public DefaultCategoryDataset gananciasPorMes(Date i, Date f) {
        DefaultCategoryDataset ganancias;
        ganancias = this.iEstadisticasBD.gananciasPorMes(i, f);
        return ganancias;
    }

    public DefaultCategoryDataset obtieneListaPlatoMasPedido(Date i, Date f, Seccion s) {
        DefaultCategoryDataset listaPlatos;
        listaPlatos = this.iEstadisticasBD.obtieneListaPlatoMasPedido(i, f, s);
        return listaPlatos;
    }

    public DefaultCategoryDataset obtieneListaPlatoMenosPedido(Date i, Date f, Seccion s) {
        DefaultCategoryDataset listaPlatos;
        listaPlatos = this.iEstadisticasBD.obtieneListaPlatoMenosPedido(i, f, s);
        return listaPlatos;
    }

 
}
