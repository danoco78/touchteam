<?php

include_once 'ICliente.php';
include_once 'GestionCarta.php';
include_once 'GestionPedidos.php';

/**
 * Actua como fachada del sistema
 * @author Adrián Víctor Pérez Lopera
 */
class ControladorPrincipal implements ICliente {

    private $carta, $pedidos;

    public function __construct() {
        $this->carta = new GestionCarta();
        $this->pedidos = new GestionPedidos();
        $this->borradoRecursivo("tmp"); // Se borran los archivos temporales inutiles
    }
    
    private function borradoRecursivo($str) {
        if(is_file($str)) {
            return @unlink($str);
        }
        elseif(is_dir($str)) {
            $scan = glob(rtrim($str,'/').'/*');
            foreach($scan as $index=>$path) {
                $this->borradoRecursivo($path);
            }
        }
    }

    function getSecciones() {
        return $this->carta->getSecciones();
    }

    function getPedidosModificablesMesa($codmesa) {
        return $this->pedidos->getPedidosModificablesMesa($codmesa);
    }

    function getElementosPedido($codpedido) {
        return $this->pedidos->getElementosPedido($codpedido);
    }

    function nuevoPedido($codmesa, $elementospedido) {
        $this->pedidos->nuevoPedido($codmesa, $elementospedido);
    }

    function modificaPedido($codpedido, $codmesa, $elementospedido) {
        $this->pedidos->modificaPedido($codpedido, $codmesa, $elementospedido);
    }

}

?>