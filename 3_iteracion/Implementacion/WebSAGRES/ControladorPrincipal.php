<?php

include_once 'ICliente.php';
include_once 'GestionCarta.php';
include_once 'GestionPedidos.php';

/**
 * Description of SAGRES
 *
 * @author Adrián Víctor Pérez Lopera
 */
class ControladorPrincipal implements ICliente {
    
    function getSecciones() {
        $carta = new GestionCarta();
        $secciones = $carta->getSecciones();
        return $secciones;
    }

    function getPedidosModificablesMesa($codmesa) {
        $pedidos = new GestionPedidos();
        $pedidosmodificables = $pedidos->getPedidosModificablesMesa($codmesa);
        return $pedidosmodificables;
    }

    function getElementosPedido($codpedido) {
        $pedidos = new GestionPedidos();
        $elementos = $pedidos->getElementosPedido($codpedido);
        return $elementos;
    }

    function nuevoPedido($codmesa, $elementospedido) {
        $pedidos = new GestionPedidos();
        $pedidos->nuevoPedido($codmesa, $elementospedido);
    }

    function modificaPedido($codpedido, $codmesa, $elementospedido) {
        $pedidos = new GestionPedidos();
        $pedidos->modificaPedido($codpedido, $codmesa, $elementospedido);
    }
}

?>