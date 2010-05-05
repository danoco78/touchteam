/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package GestionPedidos;

/**
 *
 * @author Gaspar
 */
public class Restaurante {
    private String CIF;
    private Integer codRestaurante;
    private String direccion;
    private String nombre;
    private String telefono;

    public void setCIF(String CIF) {
        this.CIF = CIF;
    }

    public void setCodRestaurante(Integer codRestaurante) {
        this.codRestaurante = codRestaurante;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCIF() {
        return CIF;
    }

    public Integer getCodRestaurante() {
        return codRestaurante;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTelefono() {
        return telefono;
    }



}
