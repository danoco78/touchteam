<?php

include_once 'ControladorPrincipal.php';
$sagres = new ControladorPrincipal();
$elementos = $sagres->getElementosPedido($codpedido = 1);
for($i=0; $i<count($elementos); $i++) {
echo "- ".$elementos[$i]->getId()." ".$elementos[$i]->getComentario()." ".$elementos[$i]->getEstado()."<br>";
$elementocarta = $elementos[$i]->getElemento();
echo "--- ".$elementocarta->getNombre()." ".$elementocarta->getDescripcion()."<br>";
}

?>
