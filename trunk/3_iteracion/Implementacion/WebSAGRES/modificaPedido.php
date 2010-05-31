<?php

include_once 'ControladorPrincipal.php';
$sagres = new ControladorPrincipal();
$codpedido= 3; // Queremos modificar el pedido 3
$codmesa = 2; // Queremos hacer un pedido para la mesa 2
$secciones = $sagres->getSecciones(); // Todas las secciones
$elementosseccion = $secciones[1]->getElementos(); // Queremos hacer un pedido con CARNE de cada tipo
$elementos = array(); // Array que pasaremos como parametro
for($i=0; $i<count($elementosseccion); $i++) {
$elementos[$i][0] = $elementosseccion[$i];
$elementos[$i][1] = "Tengo Hambre!";
}
$sagres->modificaPedido($codpedido, $codmesa, $elementos);

?>
