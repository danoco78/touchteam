package GestionCarta;

import GestionStock.GestionProductos.Ingrediente;
import GestionStock.GestionProductos.Producto;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.swing.ImageIcon;

/**
 *
 * @author Ángel Luis García
 */
public class ElementoPlato extends Elemento {

    HashMap<Ingrediente,Float> listaIngredientes;
    int tiempoElaboracion;

    public ElementoPlato(int codigo, HashMap<Ingrediente, Float> listaIngredientes, String nombre, String descripcion, ImageIcon foto, int tiempoElaboracion, float precio, int divisionesMaximas) {
        super(codigo, descripcion, divisionesMaximas, foto, nombre, precio);
        this.listaIngredientes = listaIngredientes;
        this.tiempoElaboracion = tiempoElaboracion;
    }

    public void modifica(String nombre, String descripcion, ImageIcon foto, int tiempo, float precio, int divisionesMaximas){
        this.setNombre(nombre);
        this.setDescripcion(descripcion);
        this.setFoto(foto);
        this.setTiempoElaboracion(tiempo);
        this.setPrecio(precio);
        this.setDivisionesMaximas(divisionesMaximas);
    }

    public int getTiempoElaboracion() {
        return tiempoElaboracion;
    }

    public void setTiempoElaboracion(int tiempoElaboracion) {
        this.tiempoElaboracion = tiempoElaboracion;
    }

    public HashMap<Ingrediente, Float> getListaIngredientes() {
        return listaIngredientes;
    }

        /**
     * Comprueba si hay cantidades suficientes en stock de todos los productos que utiliza el elemento.
     *
     * @return true: Sí hay la suficiente cantidad de cada producto
     *         false: La cantidad de algún producto No es suficiente.
     */
    public boolean tieneProductosSuficientes(){
        Iterator iteradorProductos = this.getListaIngredientes().entrySet().iterator();
        Producto producto;
        float cantidadNecesaria;

        while(iteradorProductos.hasNext()){
            Map.Entry entry = (Map.Entry) iteradorProductos.next();
            producto = (Producto)entry.getKey();
            cantidadNecesaria = ((Float)entry.getValue()).floatValue();
            if (producto.getCantidad() < cantidadNecesaria)
                return false;
        }
        return true;
    }

    public void asocia(Ingrediente in, Float cantidad){
        this.listaIngredientes.put(in, cantidad);
    }
}
