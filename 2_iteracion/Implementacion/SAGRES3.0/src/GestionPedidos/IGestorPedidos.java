/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package GestionPedidos;
import java.util.ArrayList;
import GestionCarta.*;
import utilidades.Pair;

/**
 *
 * @author Gaspar
 */
public interface IGestorPedidos {

    public void confirmaPagoFactura(Integer codMesa);

    public ArrayList<String> getInfoRest();

    public Pedido getSiguientePedidoBar()throws Exception;

    public Pedido getSiguientePedidoCocinaEncola()throws Exception;

    public void imprimeFactura(Integer codMesa);

    public ArrayList<Pedido> iniciaModificaPedido(Integer codMesa);

    public boolean nuevoPedido(Integer codMesa, ArrayList<Pair<Elemento,String> > elems);

    public ArrayList<ElementoPedido> obtieneElementos(Integer codPedido);

    //TODO Preguntar por estas dos siguientes funciones
    public boolean seleccionaBebida(Pedido p, ElementoColaBar cola)throws Exception ;

    public int getNumPlatosEnCola();

    public int getNumBebidasEnCola();

    public ArrayList<Pedido> getPedidosCocinaPreparandose()throws Exception;

    public boolean seleccionaPlato(Pedido p, ElementoColaCocina ele)throws Exception;;

    public Factura getFactura(int codMesa);

    public ArrayList<Pedido> getPedidosModificablesMesa(int codMesa);
    
    public ArrayList<Integer> getFacturasEnCola();

    public boolean eliminaPedido(int codPedido);

    public boolean modificaPedido(Integer codPedido, Integer codMesa, ArrayList<Pair<Elemento, String> > elementosPedido);

    public ArrayList<Integer> getFacturasImprimidas();

    public Pedido getSiguientePedidoCocina();
    
    public Factura pideFactura(int codMesa);

    public ArrayList<Pedido> obtienePedidosMesa(int codMesa);
}
