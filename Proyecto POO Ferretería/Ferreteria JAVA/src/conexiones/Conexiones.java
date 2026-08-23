
package conexiones;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexiones {
    private static final String url ="jdbc:mysql://localhost:3306/produccion";
    private static final String usuario = "root";
    private static final String pass = "admin";
    
    public static Connection conectar(){
        Connection conexion = null;
        try{
            conexion = DriverManager.getConnection(url, usuario, pass);
            System.out.println("Conexion correcta a Mysql");
        }catch(Exception e){
            System.out.println("Error de Conexion " + e);
        }
        return conexion;
    }
    public static void main(String[] args){
        Conexiones test = new Conexiones();
        test.conectar();
    }
}
