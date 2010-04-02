package GestionCarta;


import java.util.ArrayList;


/**
 * Tipo de sección. Organizar los elementos de la carta que son comida.
 * @author Carlos Salas Morales
 */
public class SeccionComida extends Seccion {

    ArrayList<ElementoPlato> listaElementoPlato;

    public SeccionComida(String nombre, Carta carta) {
        super(nombre, carta);
    }

    @Override
    public void anadeElemento(Elemento elementoPlato) {
        listaElementoPlato.add((ElementoPlato) elementoPlato);
    }

    public ArrayList<ElementoPlato> getListaElementoPlato() {
        return this.listaElementoPlato;
    }
}
