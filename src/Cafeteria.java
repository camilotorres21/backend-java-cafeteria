
import java.util.ArrayList;
import java.util.List;

public class Cafeteria {

    private List<Producto> menuProductos;
    private List<Pedido> pedidos;
    private List<Cliente> clientes;
    private List<Empleado> empleados;

    public Cafeteria() {
        this.menuProductos = new ArrayList<>();
        this.pedidos = new ArrayList<>();
        this.clientes = new ArrayList<>();
        this.empleados = new ArrayList<>();
        menuProductos.add(new Producto("Café", 1.50));
        menuProductos.add(new Producto("Té", 1.20));
        menuProductos.add(new Producto("Pastel", 2.50));
        menuProductos.add(new Producto("Galleta", 0.80));
        empleados.add(new Empleado("Admon", "1234", "Administrador", "Camtor95*"));
    }

    // CRUD Empleados-----------------------------------------------------------------------------------
    public void crearEmpleado(String nombre, String identificacion, String cargo, String contraseña) {
        Empleado nuevoEmpleado = new Empleado(nombre, identificacion, cargo, contraseña);
        empleados.add(nuevoEmpleado);
        System.out.println("\nEmpleado creado con exito: " + nombre + " - Cargo: " + cargo);
    }

    public void mostrarEmpleados() {
        if (empleados.isEmpty()) {
            System.out.println("No hay empleados registrados.");
        } else {
            System.out.println("Lista de Empleados:");
            for (Empleado empleado : empleados) {
                System.out.println("- " + empleado.getNombre() + " - Cargo: " + empleado.getCargo());
            }
        }
    }

    public void buscarEmpleado(String nombreEmpleado) {
        for (Empleado empleado : empleados) {
            if (empleado.getNombre().equalsIgnoreCase(nombreEmpleado)) {
                System.out.println("Información Empleado: " + empleado.getNombre() + "\n-Cargo: " + empleado.getCargo() + "\n-Identificación: " + empleado.getIdentificacion());
                return;
            }
        }
        System.out.println("Empleado no encontrado: " + nombreEmpleado);
    }

    public void modificarEmpleado(String nombreEmpleado, String nuevoNombre, String nuevaIdentificacion, String nuevoCargo) {
        for (Empleado empleado : empleados) {
            if (empleado.getNombre().equalsIgnoreCase(nombreEmpleado)) {
                empleado.setNombre(nuevoNombre);
                empleado.setIdentificacion(nuevaIdentificacion);
                empleado.setCargo(nuevoCargo);
                System.out.println("Empleado modificado con exito: \n" + nuevoNombre + " -Cargo: " + nuevoCargo);
                return;
            }
        }
        System.out.println("Empleado no encontrado: " + nombreEmpleado);
    }

    public void eliminarEmpleado(String nombreEmpleado) {
        for (int i = 0; i < empleados.size(); i++) {
            if (empleados.get(i).getNombre().equalsIgnoreCase(nombreEmpleado)) {
                empleados.remove(i);
                System.out.println("Empleado eliminado: " + nombreEmpleado);
                return;
            }
        }
        System.out.println("Empleado no encontrado: " + nombreEmpleado);
    }

    public void cambiarContraseña(String nombreEmpleado, String contraseñaAntigua, String contraseñaNueva) {
        for (Empleado empleado : empleados) {
            if (empleado.getNombre().equalsIgnoreCase(nombreEmpleado)) {
                empleado.setContraseña(contraseñaAntigua, contraseñaNueva);
                return;
            }
        }
        System.out.println("Empleado no encontrado: " + nombreEmpleado);
    }

    // CRUD Productos-----------------------------------------------------------------------------------
    public void agregarProducto(String productoNuevo, double precioNuevo) {
        Producto nuevoProducto = new Producto(productoNuevo, precioNuevo);
        menuProductos.add(nuevoProducto);
        System.out.println("Producto agregado: " + productoNuevo + " - $" + precioNuevo);
    }

    public void mostrarMenu() {
        if (menuProductos.isEmpty()) {
            System.out.println("El menú está vacío.");
        } else {
            System.out.println("Menú de Productos:");
            for (Producto producto : menuProductos) {
                System.out.println("- " + producto.getNombre() + ": $" + producto.getPrecio());
            }
        }

    }

    public int buscarProducto(String nombreProducto) {
        for (int i = 0; i < menuProductos.size(); i++) {
            if (menuProductos.get(i).getNombre().equalsIgnoreCase(nombreProducto)) {
                return i; // Retorna la posición del producto encontrado
            }
        }
        return -1; // Retorna -1 si no se encuentra el producto
    }

    public void modificarProducto(String nombreProducto, String nuevoNombre, double nuevoPrecio) {
        for (Producto producto : menuProductos) {
            if (producto.getNombre().equalsIgnoreCase(nombreProducto)) {
                producto.setNombre(nuevoNombre);
                producto.setPrecio(nuevoPrecio);
                System.out.println("Producto modificado: " + nuevoNombre + " - $" + nuevoPrecio);
                return;
            }
        }
        System.out.println("Producto no encontrado: " + nombreProducto);
    }

    public void eliminarProducto(String nombreProducto) {
        for (int i = 0; i < menuProductos.size(); i++) {
            if (menuProductos.get(i).getNombre().equalsIgnoreCase(nombreProducto)) {
                menuProductos.remove(i);
                return; // Salir del método después de eliminar el producto
            }
        }
        System.out.println("Producto no encontrado: " + nombreProducto);
    }

    // CRUD Pedidos-----------------------------------------------------------------------------------
    public void agregarPedido(Cliente cliente) {
        int Codigo = pedidos.size() + 1; // Generar un código único para el pedido
        Pedido nuevoPedido = new Pedido(Codigo, cliente);
        pedidos.add(nuevoPedido);
        System.out.println("Pedido agregado: " + Codigo + ". Cliente: " + cliente.getNombre());
    }

    public void mostrarPedidos() {
        if (pedidos.isEmpty()) {
            System.out.println("No hay pedidos registrados.");
        } else {
            System.out.println("Lista de Pedidos:");
            for (Pedido pedido : pedidos) {
                pedido.mostrarPedido();
            }
        }

    }

    public void buscarPedido(int codigoPedido) {
        for (Pedido pedido : pedidos) {
            if (pedido.getCodigo() == codigoPedido) {
                pedido.mostrarPedido();
                return; // Salir del método después de mostrar el pedido
            }
        }
        System.out.println("Pedido no encontrado: " + codigoPedido);
    }

    public void eliminarPedido(int codigoPedido) {
        for (int i = 0; i < pedidos.size(); i++) {
            if (pedidos.get(i).getCodigo() == codigoPedido) {
                pedidos.remove(i);
                return; // Salir del método después de eliminar el pedido
            }
        }
        System.out.println("Pedido no encontrado: " + codigoPedido);
    }

    // CRUD Clientes-----------------------------------------------------------------------------------
    public void agregarCliente(String nombre, String telefono) {
        Cliente nuevoCliente = new Cliente(nombre, telefono);
        clientes.add(nuevoCliente);
        System.out.println("Cliente agregado: " + nombre);
    }

    public void mostrarClientes() {
        if (clientes.isEmpty()) {
            System.out.println("No hay clientes registrados.");
        } else {
            System.out.println("Lista de Clientes:");
            for (Cliente cliente : clientes) {
                System.out.println("- " + cliente.getNombre() + " - Teléfono: " + cliente.getTelefono());
            }
        }
    }

    public void buscarCliente(String nombreCliente) {
        for (Cliente cliente : clientes) {
            if (cliente.getNombre().equalsIgnoreCase(nombreCliente)) {
                System.out.println("Cliente encontrado: " + cliente.getNombre() + " - Teléfono: " + cliente.getTelefono());
                return;
            }
        }
        System.out.println("Cliente no encontrado: " + nombreCliente);
    }

    public void modificarCliente(String nombreCliente, String nuevoNombre, String nuevoTelefono) {
        for (Cliente cliente : clientes) {
            if (cliente.getNombre().equalsIgnoreCase(nombreCliente)) {
                cliente.setNombre(nuevoNombre);
                cliente.setTelefono(nuevoTelefono);
                System.out.println("Cliente modificado: " + nuevoNombre + " - Teléfono: " + nuevoTelefono);
                return;
            }
        }
        System.out.println("Cliente no encontrado: " + nombreCliente);
    }

    public void eliminarCliente(String nombreCliente) {
        for (int i = 0; i < clientes.size(); i++) {
            if (clientes.get(i).getNombre().equalsIgnoreCase(nombreCliente)) {
                clientes.remove(i);
                System.out.println("Cliente eliminado: " + nombreCliente);
                return;
            }
        }
        System.out.println("Cliente no encontrado: " + nombreCliente);
    }

    // Calcular total de ventas
    public double calcularTotalVentas() {
        double total = 0;
        for (Pedido pedido : pedidos) {
            total += pedido.calcularTotal();
        }
        return total;

    }

    // Getters
    public List<Producto> getMenuProductos() {
        return menuProductos;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public String getCargoLogin(String nombreEmpleado) {
        for (Empleado empleado : empleados) {
            if (empleado.getNombre().equalsIgnoreCase(nombreEmpleado)) {
                return empleado.getCargo(); // Retorna el cargo del empleado
            }
        }
        return null; // Retorna null si no se encuentra el empleado
    }

    // Métodos de autenticación de empleados
    /**
     * Método para iniciar sesión de un empleado.
     *
     * @param nombre Nombre del empleado.
     * @param contraseña Contraseña del empleado.
     */
    public boolean loginEmpleado(String nombre, String contraseña) {
        for (Empleado empleado : empleados) {
            if (empleado.getNombre().equalsIgnoreCase(nombre) && empleado.getContraseña().equals(contraseña)) {
                System.out.println("\nBienvenido " + empleado.getNombre() + " - Cargo: " + empleado.getCargo());
                return true; // Retorna true si las credenciales son correctas
            }
        }
        System.out.println("================================");
        System.out.println(" ...Credenciales incorrectas...");
        System.out.println("================================");
        return false; // Retorna false si las credenciales son incorrectas
    }

    public void logoutEmpleado() {
        System.out.println("      ...Sesión cerrada....");
    }

    // Format Menus de opciones
    public void mostrarMenuEmpleado(String nombreEmpleado, String esAdministrador) {

        System.out.println("\n     Seleccione una opción:");
        System.out.println("--------------------------------");
        System.out.println("1. Agregar producto al menú");
        System.out.println("2. Eliminar producto del menú");
        System.out.println("3. Modificar producto del menú");
        System.out.println("4. Ver menú de productos");
        System.out.println("5. Ver pedidos de la cafetería");
        System.out.println("6. Ver datos del empleado");
        System.out.println("7. Actualizar mis datos");
        System.out.println("8. Cambiar mi contraseña");
        System.out.println("9. Salir - Menú anterior");
        if (esAdministrador.equalsIgnoreCase("Administrador")) {
            System.out.println("10. Crear empleado");
            System.out.println("11. Ver empleados");
            System.out.println("12. Eliminar empleado");
        }
        System.out.println("--------------------------------");


    }

    public void mostrarMenuCliente() {
        System.out.println("\n     Seleccione una opción:");
        System.out.println("--------------------------------");
        System.out.println("1. Ver menú de productos");
        System.out.println("2. Realizar pedido");
        System.out.println("3. Ver pedidos realizados");
        System.out.println("4. Buscar cliente");
        System.out.println("5. Actualizar mis datos");
        System.out.println("6. Salir - Menú anterior");
        System.out.println("--------------------------------");

    }

}
