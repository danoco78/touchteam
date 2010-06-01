/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package GestionBaseDatos;

import GestionCarta.Seccion;
import org.jfree.data.category.DefaultCategoryDataset;
import java.util.Date;

/**
 *
 * @author nabil
 */
public interface IEstadisticasBD {

     public abstract DefaultCategoryDataset elementosAfectadosFaltaProductos(Date i, Date f);

     public abstract DefaultCategoryDataset obtieneListaPlatoMenosPedido(Date i, Date f, Seccion s);

     public abstract DefaultCategoryDataset obtieneListaPlatoMasPedido(Date i, Date f, Seccion s);

     public abstract DefaultCategoryDataset gananciasPorMes(Date i, Date f);

}

