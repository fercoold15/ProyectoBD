package proyecto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    private Connection connection;

    public Conexion(String url,String usuario, String contrasenia){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.connection = DriverManager.getConnection(url,usuario,contrasenia);
        }catch (ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public void cerrarConexion(){
        try {
            if(this.connection!=null && !this.connection.isClosed()){
                this.connection.close();
            }
        }catch (SQLException e ){
            e.printStackTrace();
        }
    }
}
