package GestionCarta;


import java.util.ArrayList;


/**
 * Tipo de sección. Organizar los elementos de la carta que son bebidas
 * @author Carlos Salas Morales
 */
public class SeccionBebida extends Seccion {
    ArrayList<ElementoBebida> listaElementoBebida;

    public SeccionBebida(int codigoSeccion, String nombre, Carta carta) {
        super(codigoSeccion, nombre,carta);
        listaElementoBebida = new ArrayList<ElementoBebida>();
    }

    //@Override
    public void anadeElemento(ElementoBebida elementoBebida) {
        listaElementoBebida.add(elementoBebida);
    }

    public ArrayList<ElementoBebida> getListaElementoBebida() {
        return this.listaElementoBebida;
    }
}
