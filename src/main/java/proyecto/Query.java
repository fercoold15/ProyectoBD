package proyecto;

import proyecto.modelos.Producto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

public class Query {
    String url="jdbc:mysql://127.0.0.1:3306/IF1023";
    String usuario="root";
    String contrasenia="admin";
    Conexion conexion = new Conexion(url,usuario,contrasenia);
    public Map<String, Producto> getProductos(){
        String getProductos="SELECT * FROM Productos";
        Statement statement = null;
        ResultSet resultSet =null;
        Map<String, Producto> listaProductos = new HashMap<>();
        try{
            Connection connection = conexion.getConnection();
            statement = connection.prepareStatement(getProductos);
            resultSet=statement.executeQuery(getProductos);
            while (resultSet.next()){
                Producto productos = new Producto();
                productos.setNombre(resultSet.getString(2));
                productos.setDescripcion(resultSet.getString(3));
                listaProductos.put(productos.getNombre(), productos);
            }
        }catch (Exception exception){
            exception.printStackTrace();
        }finally {
            conexion.cerrarConexion();
        }
       return  listaProductos;
    }
    public Producto getProducto(String nombreProducto){
        Producto producto = new Producto();
        String getProducto="SELECT * FROM Productos WHERE NOMBRE_PRODUCTO = ?";
        ResultSet resultSet =null;
        PreparedStatement pstm=null;
        try{
            Connection connection = conexion.getConnection();
            pstm=connection.prepareStatement(getProducto);
            pstm.setString(1,nombreProducto);
            resultSet=pstm.executeQuery();
            while (resultSet.next()){
              producto.setNombre(resultSet.getString(2));
              producto.setDescripcion(resultSet.getString(3));
            }
        }catch (Exception exception){
            exception.printStackTrace();
        }finally {
            conexion.cerrarConexion();
        }
        return producto;
    }
}
