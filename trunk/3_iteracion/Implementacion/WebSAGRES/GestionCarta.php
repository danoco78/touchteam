<?php

include_once 'ICarta.php';
include_once 'GestionBaseDatos.php';

/**
 * Description of GestionCarta
 *
 * @author Adrián Víctor Pérez Lopera
 */
class GestionCarta implements ICarta {
    function getSecciones() {
        $bd = new GestionBaseDatos();
        $secciones = $bd->getSecciones();
        return $secciones;
    }
}

?>