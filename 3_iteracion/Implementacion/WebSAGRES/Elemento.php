<?php

/**
 * Description of Elemento
 *
 * @author Adrián Víctor Pérez Lopera
 */
class Elemento {
    private $codElemento,$nombre,$descripcion,$disponible,$foto,$divi,$divi_max,$precio;

    public function  __construct($codElemento,$nombre,$descripcion,$disponible,$foto,$divi,$divi_max,$precio) {
        $this->codElemento = $codElemento;
        $this->nombre = $nombre;
        $this->descripcion = $descripcion;
        $this->disponible = $disponible;
        $this->foto = $foto;
        $this->divi = $divi;
        $this->divi_max = $divi_max;
        $this->precio = $precio;
    }

    public function getId() {
        return $this->codElemento;
    }
    
    public function getNombre() {
        return $this->nombre;
    }

    public function getDescripcion() {
        return $this->descripcion;
    }
}

/**
 * Description of ElementoPlato
 *
 * @author Adrián Víctor Pérez Lopera
 */
class ElementoPlato extends Elemento {
    private $tiempo_elaboracion;

    public function  __construct($codElemento,$nombre,$descripcion,$disponible,$foto,$divi,$divi_max,$precio,$tiempo) {
        parent::__construct($codElemento,$nombre,$descripcion,$disponible,$foto,$divi,$divi_max,$precio);
        $this->tiempo_elaboracion = $tiempo;
    }

    public function getTiempo() {
        return $this->tiempo_elaboracion;
    }
}

/**
 * Description of ElementoBebida
 *
 * @author Adrián Víctor Pérez Lopera
 */
class ElementoBebida extends Elemento {
}

?>
