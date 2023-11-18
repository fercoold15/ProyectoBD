package proyecto;

import proyecto.modelos.Producto;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class Query {
    String url = "jdbc:mysql://127.0.0.1:3306/IF1023";
    String usuario = "root";
    String contrasenia = "admin";


    public Map<String, Producto> getProductos() {
        Conexion conexion = new Conexion(url, usuario, contrasenia);
        String getProductos = "SELECT * FROM Productos";
        Statement statement = null;
        ResultSet resultSet = null;
        Map<String, Producto> listaProductos = new HashMap<>();
        try {
            Connection connection = conexion.getConnection();
            statement = connection.prepareStatement(getProductos);
            resultSet = statement.executeQuery(getProductos);
            while (resultSet.next()) {
                Producto productos = new Producto();
                productos.setNombre(resultSet.getString(2));
                productos.setDescripcion(resultSet.getString(3));
                listaProductos.put(productos.getNombre(), productos);
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            conexion.cerrarConexion();
        }
        return listaProductos;
    }

    public Producto getProducto(String nombreProducto) {
        Conexion conexion = new Conexion(url, usuario, contrasenia);
        Producto producto = new Producto();
        String getProducto = "SELECT * FROM Productos WHERE NOMBRE_PRODUCTO = ?";
        ResultSet resultSet = null;
        PreparedStatement pstm = null;
        try {
            Connection connection = conexion.getConnection();
            pstm = connection.prepareStatement(getProducto);
            pstm.setString(1, nombreProducto);
            resultSet = pstm.executeQuery();
            while (resultSet.next()) {
                producto.setNombre(resultSet.getString(2));
                producto.setDescripcion(resultSet.getString(3));
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            conexion.cerrarConexion();
        }
        return producto;
    }

    public void insertProducto(Producto producto) {
        Conexion conexion = new Conexion(url, usuario, contrasenia);
        String insertProducto = "INSERT INTO Productos (NOMBRE_PRODUCTO,DESCRIPCION_PRODUCTO) values (?,?)";
        PreparedStatement pstm = null;
        try {
            Connection connection = conexion.getConnection();
            pstm = connection.prepareStatement(insertProducto);
            pstm.setString(1, producto.getNombre());
            pstm.setString(2, producto.getDescripcion());
            pstm.executeUpdate();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }finally {
            conexion.cerrarConexion();
        }
    }

    public void updateProducto(Producto producto,int id) {
        Conexion conexion = new Conexion(url, usuario, contrasenia);
        String updateProducto = "UPDATE Productos SET NOMBRE_PRODUCTO=?,DESCRIPCION_PRODUCTO=? WHERE ID_PRODUCTO=?";
        PreparedStatement pstm = null;
        try {
            Connection connection = conexion.getConnection();
            pstm = connection.prepareStatement(updateProducto);
            pstm.setString(1, producto.getNombre());
            pstm.setString(2, producto.getDescripcion());
            pstm.setInt(3,id);
            pstm.executeUpdate();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }finally {
            conexion.cerrarConexion();
        }
    }

    public void deleteProducto(int id){
        Conexion conexion = new Conexion(url, usuario, contrasenia);
        String deleteProducto = "DELETE FROM Productos WHERE ID_PRODUCTO=?";
        PreparedStatement pstm = null;
        try {
            Connection connection = conexion.getConnection();
            pstm = connection.prepareStatement(deleteProducto);
            pstm.setInt(1,id);
            pstm.executeUpdate();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }finally {
            conexion.cerrarConexion();
        }
    }


}
