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
    private int cantidad;
    private int codPro;
    private int maximo;
    private int minimo;
    private String nombre;
    private ImageIcon imagen;

    public Producto(ImageIcon imagen, String nombre,int minimo, int maximo, int cantidad, int codPro) {
        this.cantidad = cantidad;
        //this.codPro = generarCodigoProducto();
        this.maximo = maximo;
        this.minimo = minimo;
        this.nombre = nombre;
        this.imagen = imagen;
    }

    public int getCantidad(){
        return this.cantidad;
    }

    public int getMaximo(){
        return this.maximo;
    }

    public int getMinimo(){
        return this.minimo;
    }

    public String getNombre(){
        return this.nombre;
    }

    public void restarCantidad(int resta){
        this.cantidad -= resta;
    }

    public void setFoto(ImageIcon foto){
        this.imagen = foto;
    }

    public void setMaximo(int maximo){
        this.maximo = maximo;
    }
    
    public void setMinimo(int minimo){
        this.minimo = minimo;
    }
    
    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public void sumarCantidad(int suma){
        this.cantidad += suma;
    }
}