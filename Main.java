
import java.util.Scanner;

public class Main {

    static Scanner entrada = new Scanner(System.in);
    static Almacen almacen = new Almacen();

    public static void main(String[] args) {
        int opcion = 0;

        while (opcion != 5) {
            opcion = mostrarMenu();
            pedirDatos(opcion);
        }
    }

    public static int mostrarMenu() {
        System.out.println("\nQue operacion desea realizar?: ");
        System.out.println("1. Agregar producto");
        System.out.println("2. Ordenar lista");
        System.out.println("3. Visualizar lista");
        System.out.println("4. Buscar producto");
        System.out.println("5. Salir");

        int opcion = entrada.nextInt();
        entrada.nextLine();

        return opcion;
    }

    public static void pedirDatos(int opcion) {
        switch (opcion) {
            case 1:
                System.out.print("Nombre: ");
                String nombre = entrada.nextLine();

                System.out.print("Precio: ");
                double precio = entrada.nextDouble();
                entrada.nextLine();

                almacen.agregarProducto(nombre, precio);
                break;

            case 2:
                almacen.ordenarListaProductos();
                break;

            case 3:
                almacen.visualizarListaProductos();
                break;

            case 4:
                System.out.print("Precio a buscar: ");
                double precioBuscado = entrada.nextDouble();
                entrada.nextLine();

                almacen.buscarProducto(precioBuscado);
                break;

            case 5:
                System.out.println("Fin del programa.");
                break;

            default:
                System.out.println("Opcion no valida.");
                break;
        }
    }
}
