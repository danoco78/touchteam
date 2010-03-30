package GestionCarta;


import java.util.ArrayList;


/**
 * Tipo de sección. Organizar los elementos de la carta que son bebidas
 * @author Carlos Salas Morales
 */
public class SeccionBebida extends Seccion {
    ArrayList<ElementoBebida> listaElementoBebida;

    public SeccionBebida(String nombre, Carta carta) {
        super(nombre,carta);
    }

    @Override
    public void anadeElemento(Elemento elementoBebida) {
        listaElementoBebida.add((ElementoBebida) elementoBebida);
    }
}
