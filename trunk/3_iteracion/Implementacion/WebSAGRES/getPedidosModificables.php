<?php

include_once 'ControladorPrincipal.php';
$sagres = new ControladorPrincipal();
$pedidos = $sagres->getPedidosModificablesMesa($codmesa = 1);
for($i=0; $i<count($pedidos); $i++) {
echo "- ".$pedidos[$i]->getId()." ".$pedidos[$i]->getMesa()." ".$pedidos[$i]->getFecha()."<br>";
$elementos = $pedidos[$i]->getElementos();
for($j=0; $j<count($elementos); $j++) {
echo "--- ".$elementos[$j]->getId()." ".$elementos[$j]->getComentario()." ".$elementos[$j]->getEstado()."<br>";
$elementocarta = $elementos[$j]->getElemento();
echo "------ ".$elementocarta->getNombre()." ".$elementocarta->getDescripcion()."<br>";
}
}

?>