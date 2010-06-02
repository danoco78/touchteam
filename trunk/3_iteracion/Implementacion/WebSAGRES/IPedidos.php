<?php

/**
 * Define la funcionalidad ofrecida por el Subsistema de Gestion de Pedidos al Controlador Principal
 * @author Adrián Víctor Pérez Lopera
 */
interface IPedidos {
    function getPedidosModificablesMesa($codmesa);
    function getElementosPedido($codpedido);
    function nuevoPedido($codmesa, $elementospedido);
    function modificaPedido($codpedido, $codmesa, $elementospedido);
}

?>
