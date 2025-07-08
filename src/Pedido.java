
import java.util.ArrayList;
import java.util.List;

public class Pedido {

    private int codigo;
    private Cliente cliente;
    private List<Producto> productosPedido;
    private double total;

    // Constructor
    public Pedido(int codigo, Cliente cliente) {
        this.codigo = codigo;
        this.cliente = cliente;
        this.productosPedido = new ArrayList<>();
        this.total = 0.0;
    }

    // Añadir productos al pedido
    public void addProducto(Producto producto) {
        productosPedido.add(producto);
    }

    // Eliminar productos del pedido
    public void eliminarProducto(String nombreProducto) {
        for (int i = 0; i < productosPedido.size(); i++) {
            if (productosPedido.get(i).getNombre().equals(nombreProducto)) {
                productosPedido.remove(i);
                break;
            } else {
                System.out.println("Producto no encontrado en el pedido: " + nombreProducto);
            }
        }
    }

    // Calcular total del pedido
    public double calcularTotal() {
        total = 0;
        for (Producto producto : productosPedido) {
            total += producto.getPrecio();
        }
        return total;
    }

    // Mostar pedido
    public void mostrarPedido() {
        System.out.println("Pedido Código: " + codigo);
        System.out.println("Cliente: " + cliente.getNombre());
        System.out.println("Productos:");
        for (Producto producto : productosPedido) {
            System.out.println("- " + producto.getNombre() + ": $" + producto.getPrecio());
        }
        System.out.println("Total: $" + calcularTotal());
    }

    public int getCodigo() {
        return codigo;
    }
}
