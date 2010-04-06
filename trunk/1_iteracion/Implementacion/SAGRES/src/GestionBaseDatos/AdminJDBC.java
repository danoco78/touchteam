package GestionBaseDatos;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Clase encargada de implementar el interfaz de comunicación con la Base de Datos.
 *
 * @author Daniel, Ángel Luis García
 */
public class AdminJDBC implements IAlmacenamiento{
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
      * con la descripción del problema.
      */
    public void conecta() throws Exception{
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
      * Cierra la conexion
      *
      * @throws Si tiene problemas con la conexion lo indicara con un objeto exception que incluira un mensaje
      * con la descripción del problema.
      */
    public void desconecta() throws Exception{
	try {
            conexion.close();
	} catch (SQLException ex) {
            throw ex;
        }
    }

    /**
    * Indica Si la instancia esta conectada con la base de datos.
    *
    * @return devuelve True si esta conectada, y false en caso contrario
    */
    public boolean estaConectado() {
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
      */
    public TableModel realizaConsulta( String SQL ){
        Statement consulta;//Objeto para las consultas
        ResultSet resultado;//Objeto para los resultados
        DefaultTableModel modelo = null;
        try{
            consulta = (Statement) this.conexion.createStatement(); // creamos una consulta asociada a la conexion
            resultado = consulta.executeQuery(SQL);// Ejecutamos la consulta
            modelo = new DefaultTableModel(); //Creamos la estructura para guardar los datos(UNA TABLA)
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
        }catch (SQLException ex){
            System.err.println("Error: " + ex.getMessage());
            return modelo;
        }
        
    }

    public boolean consultaDeModificacion(String SQL){
        Statement consulta;
        try{
            consulta = (Statement) this.conexion.createStatement();
            consulta.executeUpdate(SQL);
            return true;
        }catch (SQLException ex){
            System.err.println("Error: " + ex.getMessage());
            return false;
        }
    }


    public boolean consultaDeModificacionBlob(String SQL, byte[] bytes){
        PreparedStatement consulta;
        ImageIcon im;

        try{
            consulta = (PreparedStatement)this.conexion.prepareStatement(SQL);
            consulta.setBytes(1, bytes);
            consulta.executeUpdate();
            return true;
        }catch (SQLException ex){
            System.err.println("Error: " + ex.getMessage());
            return false;
        }
    }
}
