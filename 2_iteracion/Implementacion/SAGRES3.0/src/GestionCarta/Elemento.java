package GestionCarta;

import GestionStock.GestionProductos.Bebida;
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

    public Elemento(int codigo, String nombre, String descripcion, boolean disponible, ImageIcon foto, int divi, int diviMax, float precio) {
        this.codigoElemento = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.disponible = disponible;
        this.foto = foto;
        this.divisiones = divi;
        this.divisionesMaximas = diviMax;
        this.precio = precio;
    }

    /**
     * Establece la disponibilidad del elemento.
     *
     * @param disponibilidad La nueva disponobilidad del elemento. true: está disponible, false: no está disponible.
     */
    public void setDisponible(boolean disponibilidad) {
        disponible = disponibilidad;
    }

    /**
     * Comprueba si hay cantidades suficientes en stock de todos los productos que utiliza el elemento.
     *
     * @return true: Sí hay la suficiente cantidad de cada producto, false: La cantidad de algún producto No es suficiente.
     */
    public boolean tieneDeTodo() {
        return false;
    }

    /**
     * Comprueba si el elemento necesita el producto especificado.
     *
     * @param producto El producto a comprobar.
     * @return true: El elemento Sí necesita el producto, false: El elemento no necesita el producto.
     */
    public boolean usaProducto(Producto producto) {
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

    public boolean getDisponible() {
        return this.disponible;
    }

        public HashMap<Producto,Float> getProductos(){
        HashMap<Producto,Float> result = new HashMap();
        if(this instanceof ElementoBebida){
            HashMap<Bebida,Float> bebidas = ((ElementoBebida)this).getListaBebidas();
            Iterator ite = bebidas.entrySet().iterator();
            Producto prod;
            Float cantidad;
            Map.Entry entrada;
            while (ite.hasNext()) {
                entrada = (Map.Entry)ite.next();
                prod = (Producto) entrada.getKey();
                cantidad = (Float)entrada.getValue();
                result.put(prod, cantidad);
            }
        }
        else{
            HashMap<Ingrediente,Float> ingredientes = ((ElementoPlato)this).getListaIngredientes();
            Iterator ite = ingredientes.entrySet().iterator();
            Producto prod;
            Float cantidad;
            Map.Entry entrada;
            while (ite.hasNext()) {
                entrada = (Map.Entry)ite.next();
                prod = (Producto) entrada.getKey();
                cantidad = (Float)entrada.getValue();
                result.put(prod, cantidad);
            }
        }
        return result;
    }
    /**
     * Método para comprobar si dos elementos son iguales
     * @param objeto El elemento con el que queremos comparar.
     * @return true Si los dos elementos son iguales
     *         false En caso contrario.
     */
    @Override
    public boolean equals(Object objeto) {
        if (objeto == null) {
            return false;
        }

        Elemento elemento = (Elemento) objeto;
        if (this.getCodigoElemento() == elemento.getCodigoElemento()) {
            return true;
        }

        return false;
    }

    /**
     * Método para generar el HashCode de un elemento.
     * @return Un entero indicando el HashCode.
     */
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + this.codigoElemento;
        return hash;
    }
}
