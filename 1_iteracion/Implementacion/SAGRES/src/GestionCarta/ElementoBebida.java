package GestionCarta;

import GestionStock.GestionProductos.Bebida;
import GestionStock.GestionProductos.Producto;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.swing.ImageIcon;


/**
 *
 * @author Ángel Luis García
 */
public class ElementoBebida extends Elemento{
    public HashMap<Bebida, Float> listaBebidas;

    public ElementoBebida(int codigo, HashMap<Bebida, Float> listaBebidas, String nombre, String descripcion, ImageIcon foto, float precio, int divisionesMaximas) {
        super(codigo, descripcion, divisionesMaximas, foto, nombre, precio);
        this.listaBebidas = listaBebidas;
    }

     public void modifica(String nombre, String descripcion, ImageIcon foto, float precio, int divisionesMaximas){
        this.setNombre(nombre);
        this.setDescripcion(descripcion);
        this.setFoto(foto);
        this.setPrecio(precio);
        this.setDivisionesMaximas(divisionesMaximas);
    }

    public HashMap<Bebida, Float> getListaBebidas() {
        return listaBebidas;
    }

    /**
     * Comprueba si hay cantidades suficientes en stock de todos los productos que utiliza el elemento.
     *
     * @return true: Sí hay la suficiente cantidad de cada producto
     *         false: La cantidad de algún producto No es suficiente.
     */
    public boolean tieneProductosSuficientes(){
        Iterator iteradorProductos = this.getListaBebidas().entrySet().iterator();
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
}
