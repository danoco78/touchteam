package GestionCarta;

import GestionStock.GestionProductos.Producto;
import javax.swing.ImageIcon;

/**
 *
 * @author Ángel Luis García
 */
public class Elemento {
    private int codigoElemento;
    private String descripcion;
    private boolean disponible;
    private int divisiones;
    private int divisionesMaximas;
    private ImageIcon foto;
    private String nombre;
    private float precio;

    
    
    public Elemento(int codigo, String descripcion, int divisionesMaximas, ImageIcon foto, String nombre, float precio) {
        this.codigoElemento = codigo;
        this.descripcion = descripcion;
        this.divisionesMaximas = divisionesMaximas;
        this.foto = foto;
        this.nombre = nombre;
        this.precio = precio;
        this.disponible = false; //Hasta que no se comprueben los productos no esta disponible
        this.divisiones = 1;
    }
    
    /**
     * Establece la disponibilidad del elemento.
     *
     * @param disponibilidad La nueva disponobilidad del elemento. true: está disponible, false: no está disponible.
     */
    public void setDisponible(boolean disponibilidad){
        disponible = disponibilidad;
    }

    /**
     * Comprueba si hay cantidades suficientes en stock de todos los productos que utiliza el elemento.
     *
     * @return true: Sí hay la suficiente cantidad de cada producto, false: La cantidad de algún producto No es suficiente.
     */
    public boolean tieneDeTodo(){
        return false;
    }


    /**
     * Comprueba si el elemento necesita el producto especificado.
     *
     * @param producto El producto a comprobar.
     * @return true: El elemento Sí necesita el producto, false: El elemento no necesita el producto.
     */
    public boolean usaProducto(Producto producto){
        return false;
    }

    public int getCodigoElemento(){
        return this.codigoElemento;
    }

    public void modifica(String nombre, String descripcion, ImageIcon foto, float precio, int divisionesMaximas){
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.foto = foto;
        this.precio = precio;
        this.divisionesMaximas = divisionesMaximas;
    }
}