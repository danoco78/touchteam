<?php

include_once 'ICartaBD.php';
include_once 'IPedidosBD.php';
include_once 'Seccion.php';
include_once 'Elemento.php';
include_once 'ElementoPedido.php';
include_once 'Pedido.php';

/**
 * Se ocupa de la gestion de la carta
 * @author Adrián Víctor Pérez Lopera
 */
class GestionBaseDatos implements ICartaBD, IPedidosBD {

    private $bd;

    public function  __construct() {
        $this->conectaMySQL();
    }

    private function conectaMySQL() {
        $this->bd = new mysqli("localhost", "root", "elpeluesendesa", "touchteam"); // Cambiar aqui usuario y contraseña
        if(mysqli_connect_errno()) {
            echo "Error. No se pudo conectar a la base de datos.";
            exit;
        }
    }

    private function getImagen($imagen) {
        $dir = getcwd()."/tmp";
	$foto = basename(tempnam($dir,'img'));
	$foto = "tmp/".$foto.".jpg";
	$ft = fopen($foto,"w");
	fwrite($ft, $imagen);
        fclose($ft);
	return $foto;
    }

    public function getSecciones() {
        $secciones = array();
        $sql = "SELECT *
                FROM seccion";
        $result = $this->bd->query($sql);
        $numfilas = $result->num_rows;
        
        for($i=0; $i < $numfilas ; $i++) {
            $row = $result->fetch_assoc();
            $seccion = new Seccion($row["seccion_id"], $row["nombre"]);
            $cod = $seccion->getId();

            $sql2 = "SELECT *
                     FROM incluyePlato ip, elementoPlato ep, elemento e
                     WHERE ip.elementoPlato_elemento_elemento_id = ep.elemento_elemento_id AND
                           ep.elemento_elemento_id = e.elemento_id AND
                           ip.seccionComida_seccion_seccion_id = $cod";
            $result2 = $this->bd->query($sql2);
            $numfilas2 = $result2->num_rows;

            if($numfilas2 > 0) { // Es una seccion de Platos
                for($j=0; $j < $numfilas2 ; $j++) {
                    $row2 = $result2->fetch_assoc();
                    $foto = $this->getImagen($row2["foto"]); // Obtener foto
                    $elemento = new ElementoPlato(
                        $row2["elemento_id"],
                        $row2["nombre"],
                        $row2["descripcion"],
                        $row2["disponible"],
                        $foto,
                        $row2["divi"],
                        $row2["divi_max"],
                        $row2["precio"],
                        $row2["tiempo_elaboracion"]
                    );
                    $seccion->asociaElemento($elemento);
                }
            }
            else { // Es una seccion de Bebidas
                $sql3 = "SELECT *
                         FROM incluyeBebida ip, elementoBebida ep, elemento e
                         WHERE ip.elementoBebida_elemento_elemento_id = ep.elemento_elemento_id AND
                               ep.elemento_elemento_id = e.elemento_id AND
                               ip.seccionBebida_seccion_seccion_id = $cod";
                $result3 = $this->bd->query($sql3);
                $numfilas3 = $result3->num_rows;

                if($numfilas3 > 0) {
                    for($j=0; $j < $numfilas3 ; $j++) {
                        $row3 = $result3->fetch_assoc();
                        $foto = $this->getImagen($row3["foto"]); // Obtener foto
                        $elemento = new ElementoBebida(
                            $row3["elemento_id"],
                            $row3["nombre"],
                            $row3["descripcion"],
                            $row3["disponible"],
                            $foto,
                            $row3["divi"],
                            $row3["divi_max"],
                            $row3["precio"]
                        );
                        $seccion->asociaElemento($elemento);
                    }
                }
            }
            array_push($secciones, $seccion);
        }
        
        return $secciones;
    }

    public function getPedidosModificablesMesa($codmesa) {
        $pedidos = array();
        $sql = "SELECT *
                FROM pedido
                WHERE mesa_id=$codmesa
                AND estado=0";
        $result = $this->bd->query($sql);
        $numfilas = $result->num_rows;

         for($i=0; $i < $numfilas ; $i++) {
            $row = $result->fetch_assoc();
            $cod = $row["pedido_id"];
            $elementos = $this->getElementosPedido($cod);
            $pedido = new Pedido($row["mesa_id"],$row["pedido_id"],$row["estado"],$row["fecha"],$elementos);
            array_push($pedidos, $pedido);
        }

        return $pedidos;
    }

    public function getElementosPedido($codpedido) {
        $elementos = array();
        /* Obtengo los elementos de un pedido */
        $sql = "SELECT *
                FROM elementoPedido ep, tieneElemento te
                WHERE ep.elementoPedido_id = te.elementoPedido_elementoPedido_id AND
                      te.pedido_pedido_id = $codpedido";
        $result = $this->bd->query($sql);
        $numfilas = $result->num_rows;
        /* Creo un objeto para cada elemento, con su elemento de carta asociado */
        for($i=0; $i < $numfilas ; $i++) {
            $row = $result->fetch_assoc();
            $cod = $row["elementoPedido_id"];
            /* Obtengo el elemento de carta asociado */
            $sql2 = "SELECT *
                     FROM elemento e
                     WHERE e.elemento_id IN (
                        SELECT elementoPlato_elemento_elemento_id
                        FROM asociaPlato
                        WHERE elementoColaCocina_elementoPedido_elementoPedido_id = $cod)";
            $result2 = $this->bd->query($sql2);
            $numfilas2 = $result2->num_rows;
            /* El elemento es un plato */
            if($numfilas2 == 1) {
                $row2 = $result2->fetch_assoc();
                $elementocarta = new ElementoPlato(
                    $row2["elemento_id"],
                    $row2["nombre"],
                    $row2["descripcion"],
                    $row2["disponible"],
                    $row2["foto"],
                    $row2["divi"],
                    $row2["divi_max"],
                    $row2["precio"],
                    $row2["tiempo"]
                );
                $elem = new ElementoPedido($cod, $row["comentario"], $row["estado"], $elementocarta);
            }
            /* El elemento NO es un plato */
            else {
                /* Obtengo el elemento de carta asociado */
                $sql2 = "SELECT *
                         FROM elemento e
                         WHERE e.elemento_id IN (
                            SELECT elementoBebida_elemento_elemento_id
                            FROM asociaBebida
                            WHERE elementoColaBar_elementoPedido_elementoPedido_id = $cod)";
                $result2 = $this->bd->query($sql2);
                $numfilas2 = $result2->num_rows;
                /* El elemento es una bebida */
                if($numfilas2 == 1) {
                    $row2 = $result2->fetch_assoc();
                    $elementocarta = new ElementoBebida(
                        $row2["elemento_id"],
                        $row2["nombre"],
                        $row2["descripcion"],
                        $row2["disponible"],
                        $row2["foto"],
                        $row2["divi"],
                        $row2["divi_max"],
                        $row2["precio"],
                        $row2["tiempo"]
                    );
                    $elem = new ElementoPedido($cod, $row["comentario"], $row["estado"], $elementocarta);
                }
                /* No es ni bebida ni comida --> Error */
                else {
                    echo "Error: Debe existir un elemento de la carta para todo elemento de un pedido.";
                    exit;
                }
            }
            array_push($elementos, $elem);
        }
        
        return $elementos;
    }

    public function insertaPedido($pedido) {
        /* Informacion del pedido */
        $codPedido = $pedido->getId();
        $mesa = $pedido->getMesa();
        $estado = $pedido->getEstado();
        $fecha = $pedido->getFecha();
        $elementos = $pedido->getElementos();

        /* Imprimir Datos */
//        echo "- Pedido: ".$codPedido."<br>";
//        echo "- Mesa: ".$mesa."<br>";
//        echo "- Estado: ".$estado."<br>";
//        echo "- Fecha: ".$fecha."<br>";
//        echo "- Numero de elementos: ".count($elementos)."<br><br>";

        /* Insercion de los datos del pedido */
        $sql1 = "INSERT INTO pedido VALUES($codPedido,$mesa,$estado,$fecha)";
        $result1 = $this->bd->query($sql1);

        /* Para cada pedido, inserto los datos de sus elementos */
        for($i=0 ; $i<count($elementos); $i++) {
            /* Informacion del elemento del pedido */
            $codElem = $elementos[$i]->getId();
            $comentario = $elementos[$i]->getComentario();
            $estadoElem = $elementos[$i]->getEstado();
            $elemCarta = $elementos[$i]->getElemento();
            $codElemCarta = $elemCarta->getId();

            /* Imprimir Datos */
//            echo "--- Elemento Pedido: ".$codElem."<br>";
//            echo "--- Comentario: ".$comentario."<br>";
//            echo "--- Estado: ".$estadoElem."<br>";
//            echo "--- Elemento Carta: ".$codElemCarta."<br><br>";

            /* Insercion de los datos del elemento del pedido */
            $sql2 = "INSERT INTO elementoPedido VALUES($codElem,$estadoElem,\"$comentario\")";
            $result2 = $this->bd->query($sql2);
            $sql3 = "INSERT INTO tieneElemento VALUES($codElem,$codPedido)";
            $result3 = $this->bd->query($sql3);
            
            /* Insercion de los datos del elemento de la carta*/
            if(get_class($elemCarta) == "ElementoPlato") {
                $sql4 = "INSERT INTO elementoColaCocina VALUES($codElem)";
                $result4 = $this->bd->query($sql4);
                $sql5 = "INSERT INTO asociaPlato VALUES($codElem,$codElemCarta)";
                $result5 = $this->bd->query($sql5);
            }
            else if(get_class($elemCarta) == "ElementoBebida") {
                $sql4 = "INSERT INTO elementoColaBar VALUES($codElem)";
                $result4 = $this->bd->query($sql4);
                $sql5 = "INSERT INTO asociaBebida VALUES($codElem,$codElemCarta)";
                $result5 = $this->bd->query($sql5);
            }
        }
    }

    public function eliminaPedido($codpedido) {
        /* Busco los elementos del pedido */
        $sql = "SELECT elementoPedido_elementoPedido_id
                FROM tieneElemento
                WHERE pedido_pedido_id = $codpedido";
        $result = $this->bd->query($sql);
        $numfilas = $result->num_rows;
        /* Elimino las asociaciones del pedido con sus elementos */
        $sql2 = "DELETE FROM tieneElemento
                 WHERE pedido_pedido_id = $codpedido";
        $result2 = $this->bd->query($sql2);
        /* Elimino los elementos del pedido, con sus elementos de cola y asociaciones */
        for($i=0; $i<$numfilas ; $i++) {
            $row = $result->fetch_assoc();
            $cod = $row["elementoPedido_elementoPedido_id"];
            $sql3 = "DELETE FROM asociaPlato
                     WHERE elementoColaCocina_elementoPedido_elementoPedido_id = $cod";
            $sql4 = "DELETE FROM asociaBebida
                     WHERE elementoColaBar_elementoPedido_elementoPedido_id = $cod";
            $sql5 = "DELETE FROM elementoColaCocina
                     WHERE elementoPedido_elementoPedido_id = $cod";
            $sql6 = "DELETE FROM elementoColaBar
                     WHERE elementoPedido_elementoPedido_id = $cod";
            $sql7 = "DELETE FROM elementoPedido
                     WHERE elementoPedido_id = $cod";
            $result3 = $this->bd->query($sql3);
            $result4 = $this->bd->query($sql4);
            $result5 = $this->bd->query($sql5);
            $result6 = $this->bd->query($sql6);
            $result7 = $this->bd->query($sql7);
        }
        /* Elimino el pedido y  */
        $sql8 = "DELETE FROM facturaPedido
                 WHERE pedido_pedido_id = $codpedido";
//        $sql9 = "DELETE FROM pedido
//                 WHERE pedido_id = $codpedido";

        $result8 = $this->bd->query($sql8);
//        $result9 = $this->bd->query($sql9);
    }

    public function getCodigoPedido() {
        $codPed = 1;
        $sql = "SELECT MAX(pedido_id) FROM pedido";
        $result = $this->bd->query($sql);
        $numfilas = $result->num_rows;
        if($numfilas > 0) {
            $row = $result->fetch_assoc();
            $codPed = $row["MAX(pedido_id)"] + 1;
        }
        return $codPed;
    }

    public function getCodigoElementoPedido() {
        $codElem = 1;
        $sql = "SELECT MAX(elementoPedido_id) FROM elementoPedido";
        $result = $this->bd->query($sql);
        $numfilas = $result->num_rows;
        if($numfilas > 0) {
            $row = $result->fetch_assoc();
            $codElem = $row["MAX(elementoPedido_id)"] + 1;
        }
        return $codElem;
    }

}

?>
