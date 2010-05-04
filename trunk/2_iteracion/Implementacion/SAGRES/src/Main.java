
//import ControladorImpresora.GestorImpresora;
//import GestionBaseDatos.AdminJDBC;
import GestionCarta.GestorCarta;
//import GestionStock.GestionIncidencias.GestorIncidencia;
//import GestionStock.GestionPedidoProveedor.GestorProveedor;
//import GestionStock.GestionProductos.GestorProducto;
import Vista.DialogoDeCarga;
import Vista.InterfazCliente.InterfazCliente;
import Vista.InterfazCliente.PanelPrincipalCliente;
import Vista.InterfazCocinero.InterfazCocinero;
import Vista.InterfazMetre.InterfazMetre;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import javax.swing.JOptionPane;

/**
 *
 * @author Daniel
 */
public class Main {

    public static void main(String args[]) throws IOException {

        InterfazCliente interfaz = new InterfazCliente();
        interfaz.setVisible(true);

        /*DialogoDeCarga dCarga = new DialogoDeCarga();
        dCarga.setLocationRelativeTo(null);
        dCarga.setVisible(true);
        Properties properties = new Properties();
        FileInputStream ficheroConfiguracion;
        File fichero = new File("./DatosBD.properties");
        try {
            if (!fichero.exists()) {
                fichero.createNewFile();
                InputStream defecto = dCarga.getClass().getResource("/DatosBD.properties").openStream();
                byte datos[] = new byte[defecto.available()];
                dCarga.getClass().getResource("/DatosBD.properties").openStream().read(datos);
                FileOutputStream config = new FileOutputStream(fichero);
                config.write(datos);
                config.close();
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(dCarga, "No tiene permisos de escritura en esta carpeta"+
                    "le recomendamos cambiar la ubicación de su apliación");
        } finally {
            ficheroConfiguracion = new FileInputStream(fichero);
            properties.load(ficheroConfiguracion);
            dCarga.Progreso(5);
            AdminJDBC baseDeDatos = new AdminJDBC((String) properties.getProperty("host"),
                    (String) properties.getProperty("user"),
                    (String) properties.getProperty("pass"));
            try {
                baseDeDatos.conecta();
            } catch (Exception ex) {
                String texto = "Se Produjo un error al conectar con la base de datos"
                        + "\nError: " + ex.getMessage()
                        + "\nPara configurar el host, user o pass para el acceso a la base de datos"
                        + "\nmodificar el archivo DatosBD.properties.";
                JOptionPane.showMessageDialog(dCarga, texto);
                dCarga.setVisible(false);
                dCarga.dispose();
            }
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
            GestorProveedor pedido = new GestorProveedor(producto, producto, carta, baseDeDatos, impresora);
            dCarga.Progreso(100);
            InterfazMetre interfaz = new InterfazMetre(incidencia, producto, producto);
            //InterfazCocinero interfaz = new InterfazCocinero(incidencia, producto, producto, pedido, carta, carta);
            dCarga.setVisible(false);
            dCarga.dispose();
            interfaz.setVisible(true);
        }*/
    }
}
