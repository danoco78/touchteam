package GestionCarta;


import java.util.HashSet;


/**
 * Tipo de sección. Organizar los elementos de la carta que son comida.
 * @author Carlos Salas Morales
 */
public class SeccionComida extends Seccion implements Comparable {

    HashSet<ElementoPlato> listaElementoPlato;

    public SeccionComida(int codigoSeccion, String nombre, Carta carta, HashSet<ElementoPlato> listaElementoPlatos) {
        super(codigoSeccion, nombre, carta);
        this.listaElementoPlato = listaElementoPlatos;
    }

    //@Override
    public void anadeElemento(Elemento elementoPlato) {
        listaElementoPlato.add((ElementoPlato) elementoPlato);
    }

    public HashSet<ElementoPlato> getListaElementoPlato() {
        return this.listaElementoPlato;
    }

    public int compareTo(Object obj) {
        int codigoSeccion;
        if (obj instanceof SeccionComida)
            codigoSeccion = ((SeccionComida)obj).getCodigoSeccion();
        else
            codigoSeccion = ((SeccionBebida)obj).getCodigoSeccion();
        return this.codigoSeccion - codigoSeccion;
    }
}
