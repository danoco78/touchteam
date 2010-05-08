package ControladorImpresora;

import GestionPedidos.ElementoPedido;
import GestionPedidos.Factura;
import GestionPedidos.Pedido;
import GestionStock.GestionProductos.Producto;
import java.util.ArrayList;
import java.util.Calendar;
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

    /**
     * Imprime la factura f
     *
     * @param f Factura a imprimir
     */
    public void imprimeFactura(Factura f){
        ArrayList<String> texto = new ArrayList();
        ArrayList<Pedido> pedidos = f.getPedidos();
        ArrayList<ElementoPedido> elementosPedido = new ArrayList();
        String linea;
        String nombre;
        String hora;
        String fecha;
        Calendar calendario = Calendar.getInstance();

        if (calendario.get(Calendar.MINUTE) < 10)
            hora = calendario.get(Calendar.HOUR_OF_DAY)+":"+"0"+calendario.get(Calendar.MINUTE);
        else
            hora = calendario.get(Calendar.HOUR_OF_DAY)+":"+calendario.get(Calendar.MINUTE);
        fecha = calendario.get(Calendar.DAY_OF_WEEK)+" "+calendario.get(Calendar.DAY_OF_MONTH)+", "+
                calendario.get(Calendar.MONTH)+" "+calendario.get(Calendar.YEAR);
        
        texto.add("**BIENVENIDOS**");
        texto.add("Duerme Mucho -- Granada");

        linea = "-";
        for (int i=0;i<55;i++)
            linea += "-";
        texto.add(linea);

        for (int i=0;i<pedidos.size();i++){
            elementosPedido = pedidos.get(i).obtieneElementos();
            for (int j=0;j<elementosPedido.size();j++){
                nombre = elementosPedido.get(j).getElemento().getNombre();
                linea = nombre;
                for (int z=0;z<50-nombre.length();z++)
                    linea += " ";
                linea += elementosPedido.get(j).getElemento().getPrecio();
            }
            texto.add(linea);
        }

        linea = "-";
        for (int i=0;i<55;i++)
            linea += "-";
        texto.add(linea);

        linea = fecha;
        linea += " , ";
        linea += hora;
        texto.add(linea);

        linea = "-";
        for (int i=0;i<55;i++)
            linea += "-";
        texto.add(linea);

        linea = "-";
        for (int i=0;i<55;i++)
            linea += "-";
        texto.add(linea);

        texto.add("Gracias por su visita");
        
        Impresora.imprime(texto);
    }
}
