<?php

include_once 'IPedidos.php';
include_once 'GestionBaseDatos.php';

/**
 * Se ocupa de la gestion de los pedidos
 * @author Adrián Víctor Pérez Lopera
 */
class GestionPedidos implements IPedidos {

    function getPedidosModificablesMesa($codmesa) {
        $bd = new GestionBaseDatos();
        return $bd->getPedidosModificablesMesa($codmesa);
    }

    function getElementosPedido($codpedido) {
        $bd = new GestionBaseDatos();
        return $bd->getElementosPedido($codpedido);
    }

    function nuevoPedido($codmesa, $elementospedido) {
        $bd = new GestionBaseDatos();
        $codPedido = $bd->getCodigoPedido();
        $elementos = array();
        for($i=0; $i<count($elementospedido); $i++) {
            $codElem = $bd->getCodigoElementoPedido() + $i;
            $elem = $elementospedido[$i][0];
            $elempedido = new elementoPedido($codElem, $elementospedido[$i][1], 0, $elem);
            array_push($elementos, $elempedido);
        }
        $fecha = new DateTime();
        $fecha = '"'.$fecha->format("Y-d-m H:i:s").'"';
        $pedido = new Pedido($codmesa, $codPedido, 0, $fecha  , $elementos);
        $bd->insertaPedido($pedido);
    }
 
    function modificaPedido($codpedido, $codmesa, $elementospedido) {
        $bd = new GestionBaseDatos();
        $bd->eliminaPedido($codpedido);
        $elementos = array();
        for($i=0; $i<count($elementospedido); $i++) {
            $codElem = $bd->getCodigoElementoPedido() + $i;
            $elem = $elementospedido[$i][0];
            $elempedido = new elementoPedido($codElem, $elementospedido[$i][1], 0, $elem);
            array_push($elementos, $elempedido);
        }
        $fecha = new DateTime();
        $fecha = '"'.$fecha->format("Y-d-m H:i:s").'"';//."T".$fecha->format("H:i:s");
        $pedido = new Pedido($codmesa, $codpedido, 0, $fecha, $elementos);
        $bd->insertaPedido($pedido);
    }

}

?>
