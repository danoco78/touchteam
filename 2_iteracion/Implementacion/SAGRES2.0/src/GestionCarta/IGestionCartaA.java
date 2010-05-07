/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package GestionCarta;

import java.util.ArrayList;
import utilidades.Pair;
/**
 *
 * @author Gaspar
 */
public interface IGestionCartaA {
    public ArrayList<Pair<Seccion, ArrayList<Elemento> > > iniciaNuevoPedido();
}
