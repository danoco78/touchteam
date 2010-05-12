
import ControladorImpresora.GestorImpresora;
import ControladorPrincipal.SAGRES;
import GestionBaseDatos.GestorBaseDatos;
import GestionCarta.GestorCarta;
import GestionPedidos.GestorPedidos;
import GestionStock.GestionIncidencias.GestorIncidencia;
import GestionStock.GestionPedidoProveedor.GestorProveedor;
import GestionStock.GestionProductos.GestorProducto;
import Vista.DialogoDeCarga;
import Vista.InterfazCliente.InterfazCliente;
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
public class MainCliente {

    public static void main(String args[]) throws IOException {

        DialogoDeCarga dCarga = new DialogoDeCarga();
        dCarga.setLocationRelativeTo(null);
        dCarga.setVisible(true);
        Properties properties = new Properties();
        FileInputStream ficheroConfiguracion;
        File fichero = new File("./DatosBD.properties");
        GestorBaseDatos baseDeDatos = null;
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
            try {
                baseDeDatos = new GestorBaseDatos((String) properties.getProperty("host"),
                    (String) properties.getProperty("user"),
                    (String) properties.getProperty("pass"));
            
            } catch (Exception ex) {
                String texto = "Se Produjo un error al conectar con la base de datos"
                        + "\nError: " + ex.getMessage()
                        + "\nPara configurar el host, user o pass para el acceso a la base de datos"
                        + "\nmodificar el archivo DatosBD.properties.";
                JOptionPane.showMessageDialog(dCarga, texto);
                dCarga.setVisible(false);
                dCarga.dispose();
            }
        }
            dCarga.Progreso(20);
            GestorProducto producto = new GestorProducto(baseDeDatos);
            dCarga.Progreso(40);
            GestorCarta carta = new GestorCarta(baseDeDatos, producto);
            //producto.setCarta(carta);
            dCarga.Progreso(50);
            GestorImpresora impresora = new GestorImpresora();
            dCarga.Progreso(60);
            GestorIncidencia incidencia = new GestorIncidencia(baseDeDatos);
            dCarga.Progreso(70);
            GestorProveedor pedido = new GestorProveedor(baseDeDatos, impresora);
            dCarga.Progreso(80);
            GestorPedidos gpedido = new GestorPedidos(baseDeDatos,producto,impresora);
            SAGRES controlador = new SAGRES(carta, producto, incidencia, pedido,gpedido);
            dCarga.Progreso(90);
            InterfazCliente interfaz = new InterfazCliente(controlador);
            dCarga.Progreso(100);
            dCarga.setVisible(false);
            dCarga.dispose();
            interfaz.setVisible(true);

    }
}
