/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Estadisticas;

import GestionCarta.Seccion;
import java.sql.Timestamp;
import org.jfree.data.category.DefaultCategoryDataset;
import GestionBaseDatos.IEstadisticasBD;
import java.util.ArrayList;
/**
 *
 * @author nabil
 */
public class GestorEstadisticas implements IGestorEstadisticas{
    IEstadisticasBD iEstadisticas;
    public GestorEstadisticas(IEstadisticasBD iestadisticas){
        this.iEstadisticas = iestadisticas;
    }
    public DefaultCategoryDataset elementosAfectadosFaltaProductos(Timestamp i, Timestamp f) {
        DefaultCategoryDataset elementosAfectados = iEstadisticas.elementosAfectadosFaltaProductos(i, f);
        return elementosAfectados;
    }

    public DefaultCategoryDataset gananciasPorMes(Timestamp i, Timestamp f) {
        DefaultCategoryDataset ganancias = iEstadisticas.gananciasPorMes(i, f);
        return ganancias;
    }

    public DefaultCategoryDataset obtieneListaPlatoMasPedido(Timestamp i, Timestamp f, Seccion s) {
        DefaultCategoryDataset listaPlatos = iEstadisticas.obtieneListaPlatoMasPedido(i, f, s);
        return listaPlatos;
    }

    public DefaultCategoryDataset obtieneListaPlatoMenosPedido(Timestamp i, Timestamp f, Seccion s) {
        DefaultCategoryDataset listaPlatos = iEstadisticas.obtieneListaPlatoMenosPedido(i, f, s);
        return listaPlatos;
    }

}
