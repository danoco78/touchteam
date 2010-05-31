<?php
include_once 'ControladorPrincipal.php';
$sagres = new ControladorPrincipal();
$secciones = $sagres->getSecciones();
for($i=0; $i<count($secciones); $i++) {
echo "- ".$secciones[$i]->getNombre()."<br>";
$elementos = $secciones[$i]->getElementos();
for($j=0; $j<count($elementos); $j++) {
echo "--- ".$elementos[$j]->getNombre()." ".$elementos[$j]->getDescripcion()."<br>";
}
}
?>
