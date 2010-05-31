<?php

/**
 * Description of IPedidos
 *
 * @author Administrador
 */
interface IPedidos {
    function getPedidosModificablesMesa($codmesa);
    function getElementosPedido($codpedido);
    function nuevoPedido($codmesa, $elementospedido);
    function modificaPedido($codpedido, $codmesa, $elementospedido);
}

?>
