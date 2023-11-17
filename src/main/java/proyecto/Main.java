package proyecto;

import proyecto.modelos.Producto;

public class Main {
    public static void main(String[] args) {
        Query query = new Query();
        Producto producto = new Producto();
        producto=query.getProducto("Aceite");
        System.out.println(producto.getNombre()+" Descripcion: "+producto.getDescripcion());
        ;
//        for (Producto productos :
//            query.getProductos().values()) {
//            System.out.println(productos.getNombre()+" "+ productos.getDescripcion());
//        }
    }
}