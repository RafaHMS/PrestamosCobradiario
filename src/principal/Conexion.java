package principal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    public String driver = "com.mysql.cj.jdbc.Driver";
    public String database = "prestamo";
    public String hostname = "Localhost";
    public String port = "3306";
    public String username = "root";
    public String password = "";

    public Connection conectarMySQL() {

        Connection conn = null;
        String url = "jdbc:mysql://" + hostname + ":" + port + "/" + database + "?useSSL=false&allowPublicKeyRetrieval=true";

        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url,username,password);
            System.out.println("Conectado!");
        }catch(ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }
        return conn;
    }
}
