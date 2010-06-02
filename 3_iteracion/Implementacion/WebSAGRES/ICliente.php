<?php

/**
 * Define la funcionalidad del sistema accesible desde el cliente
 * @author Adrián Víctor Pérez Lopera
 */
interface ICliente {
    function getSecciones();
    function getPedidosModificablesMesa($codmesa);
    function getElementosPedido($codpedido);
    function nuevoPedido($codmesa, $elementospedido);
    function modificaPedido($codpedido, $codmesa, $elementospedido);
}

?>