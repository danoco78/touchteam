<?php

/**
 * Description of ElementoPedido
 *
 * @author Adrián Víctor Pérez Lopera
 */
class elementoPedido {
    private $codElementoPedido, $comentario, $estado, $elemento;

    public function __construct($codElementoPedido, $comentario, $estado, $elemento) {
        $this->codElementoPedido = $codElementoPedido;
        $this->comentario = $comentario;
        $this->estado = $estado;
        $this->elemento = $elemento;
    }

    public function  getId() {
        return $this->codElementoPedido;
    }

    public function  getComentario() {
        return $this->comentario;
    }

    public function  getEstado() {
        return $this->estado;
    }

    public function  getElemento() {
        return $this->elemento;
    }
}

?>
