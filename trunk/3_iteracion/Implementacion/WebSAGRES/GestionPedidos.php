<?php

include_once 'IPedidos.php';
include_once 'GestionBaseDatos.php';

/**
 * Description of GestionPedidos
 *
 * @author Adrián Víctor Pérez Lopera
 */
class GestionPedidos implements IPedidos {
    function getPedidosModificablesMesa($codmesa) {
        $bd = new GestionBaseDatos();
        $pedidosmodificables = $bd->getPedidosModificablesMesa($codmesa);
        return $pedidosmodificables;
    }

    function getElementosPedido($codpedido) {
        $bd = new GestionBaseDatos();
        $elementos = $bd->getElementosPedido($codpedido);
        return $elementos;
    }

    function nuevoPedido($codmesa, $elementospedido) {
        $bd = new GestionBaseDatos();
        $codPedido = $bd->getCodigoPedido();
        $elementos = array();
        for($i=0; $i<count($elementospedido); $i++) {
            $codElem = $bd->getCodigoElementoPedido() + $i;
            $elem = $elementospedido[$i][0]; // Elemento de la carta
            $elempedido = new elementoPedido($codElem, $elementospedido[$i][1], 0, $elem); // Elemento del pedido
            array_push($elementos, $elempedido);
        }
        $pedido = new Pedido($codmesa, $codPedido, 0, time(), $elementos);
        $bd->insertaPedido($pedido);
    }
 
    function modificaPedido($codpedido, $codmesa, $elementospedido) {
        $bd = new GestionBaseDatos();
        $bd->eliminaPedido($codpedido);
        $elementos = array();
        for($i=0; $i<count($elementospedido); $i++) {
            $codElem = $bd->getCodigoElementoPedido() + $i;
            $elem = $elementospedido[$i][0]; // Elemento de la carta
            $elempedido = new elementoPedido($codElem, $elementospedido[$i][1], 0, $elem); // Elemento del pedido
            array_push($elementos, $elempedido);
        }
        $pedido = new Pedido($codmesa, $codpedido, 0, time(), $elementos);
        $bd->insertaPedido($pedido);
    }
}
?>
