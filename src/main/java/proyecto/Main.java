package proyecto;

import proyecto.modelos.Producto;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Query query = new Query();
        int opcion=0;
        do {
            Scanner opciones = new Scanner(System.in);
            opcion=opciones.nextInt();
            switch (opcion){
                case 1:
                    query.getProductos();
                    break;
                case 2:
                    query.getProducto("");
                    break;
                case 3:
                    Scanner scanner = new Scanner(System.in);
                    Producto producto = new Producto();
                    System.out.println("Ingresa el nombre del producto: ");
                    producto.setNombre(scanner.nextLine());
                    System.out.println("Ingresa la descripcion del producto: ");
                    producto.setDescripcion(scanner.nextLine());
                    query.insertProducto(producto);
                    break;
                case 4:
                    Scanner actualizacion = new Scanner(System.in);
                    Producto productoActualizado = new Producto();
                    System.out.println("Ingresa el nombre del producto: ");
                    productoActualizado.setNombre(actualizacion.nextLine());
                    System.out.println("Ingresa la descripcion del producto: ");
                    productoActualizado.setDescripcion(actualizacion.nextLine());
                    System.out.println("Ingresa el id del producto:");
                    int id=actualizacion.nextInt();
                    query.updateProducto(productoActualizado,id);
                    break;
                case 5:
                    Scanner delete = new Scanner(System.in);
                    System.out.println("Ingresa el id del producto:");
                    int idAEliminar=delete.nextInt();
                    query.deleteProducto(idAEliminar);
            }
        }while (opcion!=0);
    }
}