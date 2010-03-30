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

    public int getCodigoElemento() {
        return codigoElemento;
    }

    public void setCodigoElemento(int codigoElemento) {
        this.codigoElemento = codigoElemento;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getDivisiones() {
        return divisiones;
    }

    public void setDivisiones(int divisiones) {
        this.divisiones = divisiones;
    }

    public int getDivisionesMaximas() {
        return divisionesMaximas;
    }

    public void setDivisionesMaximas(int divisionesMaximas) {
        this.divisionesMaximas = divisionesMaximas;
    }

    public ImageIcon getFoto() {
        return foto;
    }

    public void setFoto(ImageIcon foto) {
        this.foto = foto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    
}