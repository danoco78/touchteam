<?php
include_once 'ControladorPrincipal.php';
$sagres = new ControladorPrincipal();
$codmesa = 1; // Quiero hacer un pedido para la mesa 1
$secciones = $sagres->getSecciones();
$elementos = array(); // Array que pasaremos como parametro

for($i=0,$n=0; $i<count($secciones); $i++) { // Recorrido de las secciones
    $elems = $secciones[$i]->getElementos();
    for($j=0; $j<count($elems); $j++) { // Recorrido de los elementos
        for($l=0; $l<$_POST[(string)($elems[$j]->getId())]; $l++) { // Recorrido de las ocurrencias de cada elemento
            $elementos[$n][0] = $elems[$j];
            $elementos[$n][1] = "Rapidito!";
            $n++;
        }
    }
}

$sagres->nuevoPedido($codmesa,$elementos); // Se realiza el pedido
?>
