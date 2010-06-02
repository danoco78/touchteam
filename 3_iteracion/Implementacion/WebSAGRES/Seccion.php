<?php

/**
 * Clase que gestiona las secciones de la carta
 * @author Adrián Víctor Pérez Lopera
 */
class Seccion {

    private $codSeccion, $nombre, $elementos = array();

    public function __construct($id, $nombre) {
        $this->codSeccion = $id;
        $this->nombre = $nombre;
    }

    public function getId() {
        return $this->codSeccion;
    }

    public function getNombre() {
        return $this->nombre;
    }

    public function getElementos() {
        return $this->elementos;
    }

    public function asociaElemento($elem) {
        array_push($this->elementos, $elem);
    }

}
?>
