/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package GestionPedidos;
import java.util.ArrayList;

/**
 *
 * @author Gaspar
 */
public class Restaurante{
    private Integer codRestaurante;
    private String direccion;
    private String NIF;
    private String nombre;
    private String telefono;
    private ArrayList<Factura> facturas;

    public void Inicializa(Integer codRestaurante, String direccion,String NIF,
            String nombre, String telefono){
        this.codRestaurante = codRestaurante;
        this.direccion = direccion;
        this.NIF = NIF;
        this.nombre = nombre;
        this.telefono = telefono;
    }



}
