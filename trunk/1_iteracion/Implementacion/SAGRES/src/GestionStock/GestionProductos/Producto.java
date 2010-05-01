package GestionStock.GestionProductos;


import javax.swing.ImageIcon;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jose David Dionisio Ruiz
 */
public class Producto {
    private float cantidad;
    private int codPro;
    private float maximo;
    private float minimo;
    private String nombre;
    private ImageIcon imagen;

    /**
     * Construye un objeto Producto con el estado especificado con los parametros.
     * @param imagen Imagen del producto que queremos añadir
     * @param nombre Nombre del producto
     * @param minimo Minimo de unidades que debe haber en stock del producto
     * @param maximo Maximo de unidades que debe haber en stock del producto
     * @param cantidad Cantidad inicial en stock
     * @param codPro Codigo identificador del producto POSIBLE CONFLICTO - AVISAR EQUIPO DE DISEÑO
     */
    public Producto(ImageIcon imagen, String nombre,float minimo, float maximo, float cantidad, int codPro) {
        this.cantidad = cantidad;
        this.maximo = maximo;
        this.minimo = minimo;
        this.nombre = nombre;
        this.imagen = imagen;
        this.codPro = codPro;
    }

    /*
     * Actualiza la cantidad de un producto determinado
     * @param cantidad Cantidad a aumentar o disminuir del stock del producto
     */
    public void actualizarCantidad(float cantidad){
        this.cantidad = cantidad;
    }

    /*
     * Devuelve la cantidad existente en stock de un producto
     */
    public float getCantidad(){
        return this.cantidad;
    }

    /*
     * Devuelve el maximo posible de un producto
     */
    public float getMaximo(){
        return this.maximo;
    }

    /*
     * Devuelve el minimo posible de un producto
     */
    public float getMinimo(){
        return this.minimo;
    }

    /*
     * Devuelve el nombre de un producto
     */
    public String getNombre(){
        return this.nombre;
    }

    /*
     * Devuelve el codigo de un producto POSIBLE CONFLICTO - AVISAR EQUIPO DE DISEÑO
     */
    public int getCodPro() {
        return codPro;
    }

    /*
     * Devuelve la imagen de un producto
     */
    public ImageIcon getImagen() {
        return imagen;
    }

    /*
     * Establece una nuevo codigo para un producto
     * @param foto Nuevo codigo del producto
     */
    public void setCodPro(int codPro){
        this.codPro = codPro;
    }

    /*
     * Establece una nueva imagen para un producto
     * @param foto Nueva imagen del producto
     */
    public void setFoto(ImageIcon foto){
        this.imagen = foto;
    }

    /*
     * Establece un nuevo maximo para un producto
     * @param maximo Nuevo maximo del producto
     */
    public void setMaximo(float maximo){
        this.maximo = maximo;
    }

    /*
     * Establece un nuevo minimo para un producto
     * @param minimo Nuevo minimo del producto
     */
    public void setMinimo(float minimo){
        this.minimo = minimo;
    }

    /*
     * Establece un nuevo nombre para un producto
     * @param nombre Nuevo nombre del producto
     */
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
}