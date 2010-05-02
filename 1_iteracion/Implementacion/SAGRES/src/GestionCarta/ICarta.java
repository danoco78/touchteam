
package GestionCarta;

import GestionStock.GestionProductos.Producto;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 *
 * @author Ángel Luis García y Carlos Salas
 */
public interface ICarta {

    public void actualizaDisponibilidadElementos();

    public HashSet<Elemento> compruebaElementosInvalidados(HashMap<Producto, Float> listaProductosCantidades);

    public void deshabilitaElementos(HashSet<Elemento> listaElementos);

    public void eliminaElemento(Elemento elemento);

    public void modificaElemento(Elemento elemento);

    public void nuevoElemento(Elemento elemento);

    public HashSet<Elemento> obtieneElementosConProducto(Producto producto);

    public HashSet<Seccion> obtieneSecciones();

    
    // ANTIGUOS MÉTODOS DE LA INTERFAZ

    /*
    public ArrayList<Elemento> corrigeElementosInvalidados();

    public ArrayList<Elemento> invalidaElementoCarta(Producto producto);

    public ArrayList<Elemento> obtenElementosDeSeccion(Seccion seccion);

    public ArrayList<Producto> obtenProductosDeElemento(Elemento elemento);

    public ArrayList<Producto> obtenProductosDeSeccion(Seccion seccion);

    public ArrayList<Seccion> obtenSecciones();*/

}
