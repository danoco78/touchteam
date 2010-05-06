package GestionCarta;


import java.util.HashSet;


/**
 * Tipo de sección. Organizar los elementos de la carta que son bebidas
 * @author Carlos Salas Morales
 */
public class SeccionBebida extends Seccion {
    HashSet<ElementoBebida> listaElementoBebida;

    public SeccionBebida(int codigoSeccion, String nombre, Carta carta, HashSet<ElementoBebida> listaElementoBebida ) {
        super(codigoSeccion, nombre,carta);
        this.listaElementoBebida = listaElementoBebida;
    }

    //@Override
    public void anadeElemento(ElementoBebida elementoBebida) {
        listaElementoBebida.add(elementoBebida);
    }

    public HashSet<ElementoBebida> getListaElementoBebida() {
        return this.listaElementoBebida;
    }
}
