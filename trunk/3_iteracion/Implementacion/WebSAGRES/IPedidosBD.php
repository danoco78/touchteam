<?php

/**
 * Description of IPedidosBD
 *
 * @author Adrián Víctor Pérez Lopera
 */
interface IPedidosBD {
    function getPedidosModificablesMesa($codmesa);
    function getElementosPedido($codpedido);
    function insertaPedido($pedido);
    function eliminaPedido($pedido);
    function getCodigoPedido();
    function getCodigoElementoPedido();
}

?>
