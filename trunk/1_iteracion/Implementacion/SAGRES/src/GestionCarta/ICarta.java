
package GestionCarta;

/**
 *
 * @author Ángel Luis Garcia y Carlos Salas
 */
public interface ICarta {

    public ArrayList<Elemento> corrigeElementosInvalidados();

    public ArrayList<Elemento> invalidaElementoCarta(Producto producto);

    public ArrayList<Elemento> obtenElementosDeSeccion(Seccion seccion);

    public ArrayList<Producto> obtenProductosDeElemento(Elemento elemento);

    public ArrayList<Producto> obtenProductosDeSeccion(Seccion seccion);

    public ArrayList<Seccion> obtenSecciones();

}
