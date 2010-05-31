<?php

include_once 'ControladorPrincipal.php';
$sagres = new ControladorPrincipal();
$codmesa = 2; // Queremos hacer un pedido para la mesa 2
$secciones = $sagres->getSecciones(); // Todas las secciones
$elementosseccion = $secciones[0]->getElementos(); // Queremos hacer un pedido con un ENTRANTE de cada tipo
$elementos = array(); // Array que pasaremos como parametro
for($i=0; $i<count($elementosseccion); $i++) {
$elementos[$i][0] = $elementosseccion[$i];
$elementos[$i][1] = "Rapidito!";
}
$sagres->nuevoPedido($codmesa,$elementos);

?>
