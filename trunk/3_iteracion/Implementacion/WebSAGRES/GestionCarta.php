<?php

include_once 'ICarta.php';
include_once 'GestionBaseDatos.php';

/**
 * Se ocupa de la gestion de la carta
 * @author Adrián Víctor Pérez Lopera
 */
class GestionCarta implements ICarta {

    function getSecciones() {
        $bd = new GestionBaseDatos();
        return $bd->getSecciones();
    }

}

?>