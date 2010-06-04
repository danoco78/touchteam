<?php
if(!isset($_POST["confirmado"])) {
    include_once 'ControladorPrincipal.php';
    $sagres = new ControladorPrincipal();
    $secciones = $sagres->getSecciones();
    echo "<html>";
    echo "<head><link href=\"style.css\" type=\"text/css\" rel=\"stylesheet\"></head>";
    echo "<body>";
    echo "<div id=\"cabecera\">";
    echo "<img id=\"logo\" src=\"LogoSagres.png\">";
    echo "<h1 id=\"titulo\">HOTEL RESTAURANTE \"DUERME MUCHO\"</h1>";
    echo "</div>";
    echo "<div id=\"central\">";
    echo "<div id=\"cuerpo2\">";
    echo "<a href=\"index.php\">Cancelar Pedido</a>";
    echo "<h1>Confirmaci&oacute;n de su pedido</h1>";
    echo "<div class=\"linea\"></div>";
    echo "<h2>Si lo desea, puede avisar al restaurante de alg&uacute;n detalle de preparaci&oacute;n</h2>";
    echo "<form method=\"post\" action=\"realizaPedido.php\">";
    echo "<div class=\"seccion\">";
    for($i=0,$n=0; $i<count($secciones); $i++) { // Recorrido de las secciones
        $elems = $secciones[$i]->getElementos();
        for($j=0; $j<count($elems); $j++) { // Recorrido de los elementos
            for($l=0; $l<$_POST[(string)($elems[$j]->getId())]; $l++,$n++) { // Recorrido de las ocurrencias de cada elemento
                echo "<div class=\"platoelegido\">";
                $foto = $elems[$j]->getFoto(); // Obtener Imagen
                echo "<img class=\"fotoElemento2\" src=\"".$foto."\">";
                echo "<div class=\"info\">";
                echo "<h3 class=\"nombre\">".$elems[$j]->getNombre()."</h3>";
                echo "<h4 class=\"descripcion\">".$elems[$j]->getDescripcion()."</h4>";
                echo "<p class=\"precio\">Precio: ".$elems[$j]->getPrecio()." euros<p>";
                echo "</div>";
                echo '<input type="hidden" name="'.$elems[$j]->getId().'" value="'.$_POST[(string)($elems[$j]->getId())].'"/>';
                echo '<input type="hidden" name="confirmado" value="1"/>';
                echo "<div class=\"comentario\">";
                echo "<h4>Introducir aqu&iacute; comentario:<br></h4>";
                echo "<textarea name=\"comentario".$n."\" rows=\"5\" cols=\"50\"></textarea>";
                echo "</div></div>";
            }
        }
    }
    echo "</div>";
    echo "<input id=\"realizar\" type=\"submit\" value=\"Realizar Pedido\">";
    echo "</form>";
    echo "</div></div>";
    echo "</body>";
    echo "</html>";
}
else {
    include_once 'ControladorPrincipal.php';
    $sagres = new ControladorPrincipal();
    $codmesa = ip2long($_SERVER['REMOTE_ADDR']); // Quiero hacer un pedido para la mesa 1
    $secciones = $sagres->getSecciones();
    $elementos = array(); // Array que pasaremos como parametro
    for($i=0,$n=0; $i<count($secciones); $i++) { // Recorrido de las secciones
        $elems = $secciones[$i]->getElementos();
        for($j=0; $j<count($elems); $j++) { // Recorrido de los elementos
            for($l=0; $l<$_POST[(string)($elems[$j]->getId())]; $l++) { // Recorrido de las ocurrencias de cada elemento
                $elementos[$n][0] = $elems[$j];
                $elementos[$n][1] = $_POST["comentario".$n];
                $n++;
            }
        }
    }
    if(isset($_POST["codpedido"])) {
        $sagres->modificaPedido($_POST["codpedido"],$codmesa,$elementos);
    }
    else {
        $sagres->nuevoPedido($codmesa,$elementos);
    }
    echo "<html>";
    echo "<head><link href=\"style.css\" type=\"text/css\" rel=\"stylesheet\"></head>";
    echo "<body>";
    echo "<div id=\"cabecera\">";
    echo "<img id=\"logo\" src=\"LogoSagres.png\">";
    echo "<h1 id=\"titulo\">HOTEL RESTAURANTE \"DUERME MUCHO\"</h1>";
    echo "</div>";
    echo "<div id=\"central\">";
    echo "<div id=\"cuerpo2\">";
    echo "<a href=\"index.php\">Volver al inicio</a>";
    echo "<h1>Su pedido ha sido realizado con &eacute;xito</h1>";
    echo "<div class=\"linea\"></div>";
    echo "<h2>Su pedido se encuentra en proceso de elaboraci&oacute;n. En breve se enviar&aacute; a su habitaci&oacute;n.</h2>";
    echo "</div></div>";
}
?>