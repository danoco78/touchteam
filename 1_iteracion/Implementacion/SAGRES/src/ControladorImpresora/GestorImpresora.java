package ControladorImpresora;

import GestionStock.GestionProductos.Producto;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


/**
 * Clase que implementa el interfaz de impresión.
 * 
 * @author Ángel Luis García
 */
public class GestorImpresora implements IImpresion{
    /**
     * Imprime la lista de productos y su cantidad que se van a pedir al proveedor.
     *
     * @param informacionPedido HashMap con la lista de (producto,cantidad) del pedido
     */
    public void imprimePedido(HashMap<Producto, Float> informacionPedido) {
        Iterator iterador = informacionPedido.entrySet().iterator();
        ArrayList<String> texto = new ArrayList<String>();
        String clave;
        String valor;
        String linea = new String();
	while (iterador.hasNext()) {
		Map.Entry entrada = (Map.Entry)iterador.next(); // Obtenemos cada par del Mapa.

                //Formateamos la linea para imprimirla luego
                clave = ((Producto)entrada.getKey()).getNombre();
                valor = ((Float)entrada.getValue()).toString();
                linea = clave;
                for (int i = 0; i < (45 - clave.length()); i++)
                    linea += "_";
                linea += valor;
                texto.add(linea);
	}
        Impresora.imprime(texto);
    }
}
