
import ControladorImpresora.GestorImpresora;
import GestionBaseDatos.AdminJDBC;
import GestionCarta.GestorCarta;
import GestionStock.GestionIncidencias.GestorIncidencia;
import GestionStock.GestionPedidoProveedor.GestorProveedor;
import GestionStock.GestionProductos.GestorProducto;
import Vista.DialogoDeCarga;
import Vista.InterfazMetre.InterfazMetre;
import java.net.URISyntaxException;

/**
 *
 * @author Daniel
 */
public class Main {

    public static void main(String args[]) throws Exception {

        DialogoDeCarga dCarga = new DialogoDeCarga();
        dCarga.setLocationRelativeTo(null);
        dCarga.setVisible(true);
        /*Properties properties = new Properties();
        try {
            properties.load(new FileInputStream( );
        } catch (IOException e) {
            System.out.print("Problemas con el fichero de propiedades"+e.getMessage());
        }*/
        dCarga.Progreso(5);
        /*AdminJDBC baseDeDatos = new AdminJDBC(properties.getProperty("host"),
                properties.getProperty("user"),
                properties.getProperty("pass"));*/
        AdminJDBC baseDeDatos = new AdminJDBC("localhost/touchteam",
                "root",
                "arthurinz");
        baseDeDatos.conecta();
        dCarga.Progreso(20);
        GestorProducto producto = new GestorProducto(baseDeDatos);
        dCarga.Progreso(40);
        GestorCarta carta = new GestorCarta(baseDeDatos, producto);
        producto.setCarta(carta);
        dCarga.Progreso(60);
        GestorImpresora impresora = new GestorImpresora();
        dCarga.Progreso(80);
        GestorIncidencia incidencia = new GestorIncidencia(producto, carta, baseDeDatos, producto);
        dCarga.Progreso(90);
        GestorProveedor pedido = new GestorProveedor(producto, producto, carta, baseDeDatos, impresora );
        dCarga.Progreso(100);
        InterfazMetre interfaz = new InterfazMetre(incidencia, producto, producto);
        interfaz.setVisible(true);
    }
}
