/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package GestionPedidos;

import GestionCarta.Elemento;

/**
 *
 * @author Gaspar
 */
public class ElementoPedido {

    private String comentario;
    private Integer estado;
    private Integer codElementoPedido;
    private Elemento elemento;

     /**
     * Constructor con parámetros de la clase ElementoPedido. L
     *
     * @param comentario El comentario del elemento pedido
     */
    public ElementoPedido(String comentario){
        this.comentario = comentario;
        //Las demás variables privadas se inicializan por defecto
        this.estado = 0;
        //TODO Como asignar el codigo del elementopedido
        //this.codElementoPedido = ;
    }
     /**
     * Otro constructor con parámetros. Necesario para crear el objeto sacando datos de la BD.
     * @param codElementoPedido el código del ElementoPedido. Es unívoco.
     * @param estado El estado del elementoPedido *Ver arriba posibles estados.
     * @param comentario El comentario del elemento pedido
     */
    public ElementoPedido(Integer codElementoPedido, Integer estado, String comentario){
        this.codElementoPedido = codElementoPedido;
        this.estado = estado;
        this.comentario = comentario;
    }
     /**
     * Consulta el codigo de un Elemento Pedido
     * @return Un entero indicando dicho código.
     */
    public Integer getCodElementoPedido() {
        return codElementoPedido;
    }
    /**
     * Consulta el comentario de un ElementoPedido
     * @return Una cadena String que contiene el comentario
     */
    public String getComentario() {
        return comentario;
    }
    /**
     * Consulta el estado actual de un ElementoPedido
     * @return un Entero indicando su estado. *Ver estados en clases herederas
     */
    public Integer getEstado() {
        return estado;
    }
     /**
     * Obtiene el elemento asociado al ElementoPedido
     * @return Un objeto de tipo elemento.
     */
    public Elemento getElemento(){
        return elemento;
    }
     /**
     * Asigna un comentario al ElementoPedido
     * @param comentario el comentario que queremos que tenga nuestro elemento.
     */
    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
     /**
     * Asigna un estado al ElementoPedido
     * @param estado Un entero indicando el estado en el que se encuentra. (*Ver estados*)
     */
    public void setEstado(Integer estado) {
        this.estado = estado;
    }
     /**
     * Asocia un elemento al ElementoPedido
     * @param ele Elemento que queremos asociarle
     */
    public void asocia(Elemento ele){
        elemento = ele;
    }
}
