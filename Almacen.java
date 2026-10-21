import java.util.Collections;
import java.util.LinkedList;

public class Almacen {

    private LinkedList<Producto> listaProductos;
    private Producto objetoProducto;

    public Almacen() {
        listaProductos = new LinkedList<Producto>();
    }

    public void agregarProducto(String nombre, double precio) {
        objetoProducto = new Producto(nombre, precio);
        listaProductos.addLast(objetoProducto);
        System.out.println("Producto agregado.");
    }

    public void ordenarListaProductos() {
        Collections.sort(listaProductos);
        System.out.println("Lista ordenada por precio.");
    }

    public void visualizarListaProductos() {
        if (listaProductos.size() == 0) {
            System.out.println("La lista esta vacia.");
        } else {
            for (int i = 0; i < listaProductos.size(); i++) {
                Producto p = listaProductos.get(i);
                System.out.println((i + 1) + ". " + p.getNombre() + " - $" + p.getPrecio());
            }
        }
    }

    public void buscarProducto(double precioBuscado) {
        if (listaProductos.size() == 0) {
            System.out.println("La lista esta vacia.");
        } else {
            Collections.sort(listaProductos);

            int inferior = 0;
            int superior = listaProductos.size() - 1;
            boolean encontrado = false;

            while (inferior <= superior && encontrado == false) {
                int central = (inferior + superior) / 2;
                Producto p = listaProductos.get(central);

                if (precioBuscado == p.getPrecio()) {
                    System.out.println("Producto encontrado: " + p.getNombre() + " - $" + p.getPrecio());
                    encontrado = true;
                } else if (precioBuscado < p.getPrecio()) {
                    superior = central - 1;
                } else {
                    inferior = central + 1;
                }
            }

            if (encontrado == false) {
                System.out.println("No hay un producto con ese precio.");
            }
        }
    }
}