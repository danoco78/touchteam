/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package GestionPedidos;
import java.util.ArrayList;
import GestionCarta.*;

/**
 *
 * @author Gaspar
 */
public interface IGestorPedidos {

    public void confirmaPagoFactura(Integer codMesa);

    public ArrayList<String> getInfoRest();

    public Pedido getSiguientePedidoBar();

    public Pedido getSiguientePedidoCocinaEncola();

    public Pedido getSiguientePedidoCocinaPreparandose();

    public void imprimeFactura(Integer codMesa);

    public ArrayList<Pedido> iniciaModificaPedido(Integer codMesa);

    public boolean modificaPedido(Integer codPedido, ArrayList<ElementoPedido> elems);

    public boolean nuevoPedido(Integer codMesa, ArrayList<ElementoPedido> elems);

    public ArrayList<ElementoPedido> obtieneElementos(Integer codPedido);

    //TODO Preguntar por estas dos siguientes funciones
    public boolean seleccionaBebida(Pedido p, ElementoBebida bebida);

    public boolean seleccionaPlato(Pedido p, ElementoPlato plato);
}
