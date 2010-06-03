<html>
    <head><link href="style.css" type="text/css" rel="stylesheet"></head>
    <script LANGUAGE="JavaScript">
    function incrementar(id){
        var elemento = document.getElementById(id);
        var cantidad = elemento.getAttribute("value");
        cantidad = parseInt(cantidad);
        cantidad = cantidad + 1;
        elemento.setAttribute("value",cantidad);
    }
    function decrementar(id){
        var elemento = document.getElementById(id);
        var cantidad = elemento.getAttribute("value");
        cantidad = parseInt(cantidad);
        if(cantidad > 0 ) cantidad = cantidad - 1;
        else cantidad = 0;
        elemento.setAttribute("value",cantidad);
    }
    </script>
    <body>
        <div id="cabecera" >
            <img id="logo" src="LogoSagres.png">
            <h1 id="titulo">HOTEL RESTAURANTE "DUERME MUCHO"</h1>
        </div>
        <div id="central" >
            <div id="infocliente" >
            <h1> Sus Pedidos </h1>
            <div class="linea"></div>
            <?php
            include_once 'ControladorPrincipal.php';
            $sagres = new ControladorPrincipal();
            $pedidos = $sagres->getPedidosModificablesMesa($codmesa = 1);
            for($i=0; $i<count($pedidos); $i++) {
                echo "<div class=\"elemento\">";
                echo "<h4>Habitacion: ".$pedidos[$i]->getMesa()."</h4>";

                $fecha = $pedidos[$i]->getFecha();

                echo "<h4>Fecha: ".$fecha."</h4>";
                echo "<form method=\"post\" action=\"modificaPedido.php\">";
                echo "<input name=\"codpedido\" type=\"hidden\" value=\"".$pedidos[$i]->getId()."\">";
                echo "<input class=\"boton\" type=\"submit\" value=\"Modificar Pedido\">";
                echo "</form>";
                echo "</div>";
            }
            ?>
            </div>
            <div id="cuerpo" >
                <h1> Nuestra Carta </h1>
                <div class="linea"></div>
                <?php
                $secciones = $sagres->getSecciones();
                echo "<form method=\"post\" action=\"realizaPedido.php\">";
                for($i=0; $i<count($secciones); $i++) {
                    echo "<h2>".$secciones[$i]->getNombre()."</h2>";
                    echo "<div class=\"seccion\">";
                    $elementos = $secciones[$i]->getElementos();
                    $numelems = count($elementos); // Numero de elementos de la seccion
                    for($j=0; $j<$numelems; $j++) {
                        if($elementos[$j]->getDisponible()==1) {
                            echo "<div class=\"plato\">";
                            $foto = $elementos[$j]->getFoto(); // Obtener Imagen
                            echo "<img class=\"fotoElemento\" src=\"".$foto."\">";
                            echo "<div class=\"info\">";
                            echo "<h3 class=\"nombre\">".$elementos[$j]->getNombre()."</h3>";
                            echo "<h4 class=\"descripcion\">".$elementos[$j]->getDescripcion()."</h4>";
                            echo "<p class=\"precio\">Precio: ".$elementos[$j]->getPrecio()." euros<p>";
                            echo "</div><div>";
                            echo '<img class="botones" id=add'.$elementos[$j]->getId().' src="add.jpg" onClick="incrementar('.$elementos[$j]->getId().')"/>';
                            echo '<input readonly="readonly" class="cantidad" id="'.$elementos[$j]->getId().'" type="text" name="'.$elementos[$j]->getId().'" value="0"/>';
                            echo '<img class="botones" id=del'.$elementos[$j]->getId().' src="delete.jpg" onClick="decrementar('.$elementos[$j]->getId().')"/>';
                            echo "</div></div>";
                        }
                    }
                    echo "</div>";
                }
                echo "<input id=\"realizar\" type=\"submit\" value=\"Realizar Pedido\">";
                echo "</form>"
                ?>
            </div>
        </div>
    </body>
</html>