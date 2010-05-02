package GestionBaseDatos;

import GestionCarta.Elemento;
import GestionCarta.ElementoBebida;
import GestionCarta.ElementoPlato;
import GestionCarta.Seccion;
import GestionStock.GestionProductos.Producto;
import java.util.HashSet;

/**
 * Interfaz de comunicación de la Carta con la BD
 * @author Ángel Luis García y Carlos Salas
 */
public interface ICartaBD {

    public void deshabilitaElementos(HashSet<Elemento> listaElementos);

    public void eliminaElemento(Elemento elemento);

    public void habilitaElementos(HashSet<Elemento> listaElementos);

    public void modificaElementoBebida(ElementoBebida elemento);

    public void modificaElementoPlato(ElementoPlato elemento);

    public void nuevoElementoBebida(ElementoBebida elemento);

    public void nuevoElementoPlato(ElementoPlato elemento);

    public HashSet<Elemento> obtieneElementos();

    public HashSet<Elemento> obtieneElementosInvalidados();

    public HashSet<Seccion> obtieneSecciones();

    public HashSet<Elemento> obtieneElementosConProducto(Producto producto);
}
