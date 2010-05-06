/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package GestionPedidos;

/**
 *
 * @author Gaspar
 */
public class ElementoPedido {

    private String comentario;
    private Integer estado;
    private Integer codElementoPedido;

    public ElementoPedido(String comentario){
        this.comentario = comentario;
        this.estado = 0;
        //TODO Como asignar el codigo del elementopedido
        //this.codElementoPedido = ;
    }
    public ElementoPedido(Integer codElementoPedido, Integer estado, String comentario){
        this.codElementoPedido = codElementoPedido;
        this.estado = estado;
        this.comentario = comentario;
    }
    public Integer getCodElementoPedido() {
        return codElementoPedido;
    }

    public String getComentario() {
        return comentario;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

}
