
package AdminJDBC;


import com.mysql.jdbc.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;



/**
 * AdminJDBC proporciona una capa de abstracion con el conector JDBC hacia una base de datos
 * MySQL. Propocionando direccion del host, usuario y contraseña conectaremos con la BD
 * y mediante Consultas SQL podremos obtener un TableModel con los datos requeridos.
 *
 * Esta capa sigue un proceso en dos pasos:
 * 1- Conexión
 * 2- Consultas
 *
 * @author Daniel Guerrero Martínez
 * @version 0.1
 */
public class AdminJDBC {
    private Connection conexion;
    private String host;
    private String user;
    private String pass;


     /**
      * Construye una instacian para conectar y realizar transacciones con la base de datos.
      *
      * @param host La dirección del host, con el formato: Dirección/nombreBaseDatos
      *        Ejemplo: dirección = "localhost", BaseDatos = "Touchteam"
      *                 Host = "localhost/Toucteam"
      * @param usuario Nombre del usuario con permisos para acceder a la base de datos.
      * @param contrasena Contraseña asociada al usuario anteriormente especificado.
      *
      */
    public AdminJDBC(String host,String usuario, String contrasena){
        this.host = "jdbc:mysql://"+host;
        this.user = usuario;
        this.pass = contrasena;
    }

     /**
      * Inicia el proceso de conexión
      *
      * @throws Si tiene problemas con la conexion lo indicara con un objeto exception que incluira un mensaje
      * con la descricción del problema.
      */
    public void conectar() throws Exception{
        try {
            conexion = DriverManager.getConnection(this.host, this.user, this.pass);
        } catch (SQLException ex) {
            switch(ex.getErrorCode()){
                case 1045 :
                    throw new Exception("Error de Conexion: Usuario o contraseña incorrecta");
                case 1049 :
                    throw new Exception("Error de Conexion: El host especificado no es correcto o la base de datos no esta");
                default:
                    throw ex;
            }
        }
    }

    /**
    * Inicia Si la instancia esta conectada con la base de datos.
    *
    * @return devuelve True si esta conectada, y false en caso contrario
    */
    public boolean EstaConectado() {
        try {
            return this.conexion.isValid(3);
        } catch (SQLException ex) {
            return false;
        }
    }

     /**
      * Esta Operación nos permite ejecutar CONSULTAS SQL contra la base de datos.
      * No olvidemos que para realizar la consulta debe haberse conectado antes con la base de datos.
      *
      * @throws Si la consulta fue erronea se devuelve la Excepcion SQL.
      */
    public TableModel RealizarConsulta( String SQL ) throws SQLException{
        Statement consulta;//Objeto para las consultas
        ResultSet resultado;//Objeto para los resultados
        consulta = (Statement) this.conexion.createStatement(); // creamos una consulta asociada a la conexion
        resultado = consulta.executeQuery(SQL);// Ejecutamos la consulta
        DefaultTableModel modelo = new DefaultTableModel(); //Creamos la estructura para guardar los datos(UNA TABLA)
        for (int i = 1; i <= resultado.getMetaData().getColumnCount(); i++) {//Relleneamos la cabecera de la tabla.
            modelo.addColumn(resultado.getMetaData().getColumnName(i));
        }
        while (resultado.next()){//introducimos los datos en la Tabla
           Object [] tupla = new Object[resultado.getMetaData().getColumnCount()];
           for (int i=0; i<resultado.getMetaData().getColumnCount();i++)
              tupla[i] = resultado.getObject(i+1);
           modelo.addRow(tupla);
        }
        return modelo;
    }

}
