<?php

/**
 * Description of Pedido
 *
 * @author Adrián Víctor Pérez Lopera
 */
class Pedido {
    private $codMesa, $codPedido, $estado, $fecha, $elementos;

    public function  __construct($codMesa, $codPedido, $estado, $fecha, $elementos) {
        $this->codMesa = $codMesa;
        $this->codPedido = $codPedido;
        $this->estado = $estado;
        $this->fecha = $fecha;
        $this->elementos = $elementos;
    }

    public function  getMesa() {
        return $this->codMesa;
    }
    
    public function  getId() {
        return $this->codPedido;
    }

    public function  getEstado() {
        return $this->estado;
    }

    public function  getFecha() {
        return $this->fecha;
    }

    public function  getElementos() {
        return $this->elementos;
    }

    public function asociaElementos($elementos) {
        $this->elementos = $elementos;
    }
}
?>
