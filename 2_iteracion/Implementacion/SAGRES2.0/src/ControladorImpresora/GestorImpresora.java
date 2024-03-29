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
        ArrayList<ElementoPedido> elementosPedido;
        String linea;
        String nombre;
        String hora;
        String fecha;
        Calendar calendario = Calendar.getInstance();

        if (calendario.get(Calendar.MINUTE) < 10)
            hora = calendario.get(Calendar.HOUR_OF_DAY)+":"+"0"+calendario.get(Calendar.MINUTE);
        else
            hora = calendario.get(Calendar.HOUR_OF_DAY)+":"+calendario.get(Calendar.MINUTE);
        fecha = this.getDiaSemana(calendario.get(Calendar.DAY_OF_WEEK))+", "+calendario.get(Calendar.DAY_OF_MONTH)+" de "+
                this.getMes(calendario.get(Calendar.MONTH))+" de "+calendario.get(Calendar.YEAR);
        
        texto.add("**BIENVENIDOS**");
        texto.add("Duerme Mucho -- Granada");

        linea = "-";
        for (int i=0;i<55;i++)
            linea += "-";
        texto.add(linea);

        float total = 0;
        for (int i=0;i<pedidos.size();i++){
            elementosPedido = pedidos.get(i).obtieneElementos();
            for (int j=0;j<elementosPedido.size();j++){
                linea = "";
                nombre = elementosPedido.get(j).getElemento().getNombre();
                linea += nombre;
                for (int z=0;z<50-nombre.length();z++)
                    linea += " ";
                linea += String.valueOf(elementosPedido.get(j).getElemento().getPrecio())+"€";
                total += elementosPedido.get(j).getElemento().getPrecio();
                texto.add(linea);
            }
        }

        linea = "*";
        for (int i=0;i<55;i++)
            linea += "*";
        texto.add(linea);

        linea = " ";
        for (int i=0;i<40;i++)
            linea += " ";
        linea += "Total: ";
        linea += String.valueOf(total);
        texto.add(linea);

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

        texto.add("Gracias por su visita");
        
        Impresora.imprime(texto);
    }

    private String getDiaSemana(int dia){
            switch(dia){
                case Calendar.MONDAY:
                    return "Lunes";
                case Calendar.TUESDAY:
                    return "Martes";
                case Calendar.WEDNESDAY:
                    return "Miercoles";
                case Calendar.THURSDAY:
                    return "Jueves";
                case Calendar.FRIDAY:
                    return "Viernes";
                case Calendar.SATURDAY:
                    return "Sabado";
                default:
                    return "Domingo";
            }
        }

        private String getMes(int mes){
            switch(mes){
                case Calendar.JANUARY:
                    return "Enero";
                case Calendar.FEBRUARY:
                    return "Febrero";
                case Calendar.MARCH:
                    return "Marzo";
                case Calendar.APRIL:
                    return "Abril";
                case Calendar.MAY:
                    return "Mayo";
                case Calendar.JUNE:
                    return "Junio";
                case Calendar.JULY:
                    return "Julio";
                case Calendar.AUGUST:
                    return "Agosto";
                case Calendar.SEPTEMBER:
                    return "Septiembre";
                case Calendar.OCTOBER:
                    return "Octubre";
                case Calendar.NOVEMBER:
                    return "Nombiembre";
                default:
                    return "Diciembre";
            }
        }
}
