
import java.util.Scanner;

public class App {

    public static void main(String[] args) throws Exception {

        // Inicializar el scanner para la entrada de datos
        Scanner scanner = new Scanner(System.in);
        // Crear instancia de la cafetería
        Cafeteria cafeteria = new Cafeteria();

        // Crear lista de opciones para el usuario para interactuar con la cafetería
        int opcionUsuario;
        do {
            // Mostrar menú principal
            System.out.println("\n=================================");
            System.out.println("    Bienvenido a DevCafetería");
            System.out.println("=================================");
            System.out.println("Seleccione su tipo de usuario:");
            System.out.println("1. Empleado");
            System.out.println("2. Cliente");
            System.out.println("3. Finalizar Programa");
            System.out.println("---------------------------------");
            System.out.println("---");
            System.out.print("Ingrese una opción: ");
            while (true) {
                try {
                    opcionUsuario = Integer.parseInt(scanner.nextLine());
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Por favor, ingrese un número válido.");
                    System.out.print("Ingrese una opción: ");
                }
            }

            switch (opcionUsuario) {
                case 1 -> {
                    // Interacción con el empleado
                    System.out.println("\nIngrese su nombre de empleado:");
                    String nombreUsuario = scanner.nextLine();
                    System.out.println("Ingrese su contraseña:");
                    String contraseñaEmpleado = scanner.nextLine();
                    // Verificar credenciales del empleado
                    boolean loginExitoso = cafeteria.loginEmpleado(nombreUsuario, contraseñaEmpleado);
                    if (!loginExitoso) {
                        continue; // Volver al inicio del bucle para solicitar credenciales
                    }

                    // Mostrar menú de opciones para el empleado
                    int opcionEmpleado;
                    do {
                        String cargo = cafeteria.getCargoLogin(nombreUsuario);
                        cafeteria.mostrarMenuEmpleado(nombreUsuario, cargo);
                        System.out.print("Ingrese una opción: ");
                        opcionEmpleado = scanner.nextInt();
                        scanner.nextLine(); // Limpiar el buffer del scanner

                        switch (opcionEmpleado) {
                            case 1 -> {
                                // Agregar producto al menú
                                System.out.println("\n___________________________________");
                                System.out.println("  Ingrese el nombre del producto:");
                                String nombreProducto = scanner.nextLine();
                                System.out.println("  Ingrese el precio del producto:");
                                double precioProducto = scanner.nextDouble();
                                scanner.nextLine(); // Limpiar el buffer del scanner
                                System.out.println("-----------------------------------");
                                cafeteria.agregarProducto(nombreProducto, precioProducto);
                            }
                            case 2 -> {
                                // Eliminar producto del menú
                                System.out.println("\n____________________________________________");
                                System.out.println(" Ingrese el nombre del producto a eliminar:");
                                String nombreProducto = scanner.nextLine();
                                System.out.println("--------------------------------------------");
                                cafeteria.eliminarProducto(nombreProducto);
                            }
                            case 3 -> {
                                // Modificar producto del menú
                                System.out.println("\n_______________________________________________");
                                System.out.println("  Ingrese el nombre del producto a modificar:");
                                String nombreProducto = scanner.nextLine();
                                System.out.println("-----------------------------------------------");
                                if (cafeteria.buscarProducto(nombreProducto) == -1) {
                                    System.out.println("\n...Producto no encontrado en el menú...");
                                    continue; // Volver al menú sin modificar
                                }
                                System.out.println("\n___________________________________________");
                                System.out.println("   Ingrese el nuevo nombre del producto:");
                                String nuevoNombre = scanner.nextLine();
                                System.out.println("Ingrese el nuevo precio del producto:");
                                double nuevoPrecio = scanner.nextDouble();
                                scanner.nextLine(); // Limpiar el buffer del scanner
                                System.out.println("-------------------------------------------");
                                cafeteria.modificarProducto(nombreProducto, nuevoNombre, nuevoPrecio);
                            }
                            case 4 -> {
                                // Ver menú de productos
                                cafeteria.mostrarMenu();
                            }
                            case 5 -> {
                                // Ver pedidos de la cafetería
                                cafeteria.mostrarPedidos();
                            }
                            case 6 -> {
                                // Ver datos del empleado
                                cafeteria.buscarEmpleado(nombreUsuario);
                            }
                            case 7 -> {
                                // Actualizar datos del empleado
                                System.out.println("Ingrese su nuevo nombre de usuario:");
                                String nuevoNombreUsuario = scanner.nextLine();
                                System.out.println("Ingrese su nueva identificación:");
                                String nuevaIdentificacion = scanner.nextLine();
                                System.out.println("Ingrese su nuevo cargo:");
                                String nuevoCargo = scanner.nextLine();
                                cafeteria.modificarEmpleado(nombreUsuario, nuevoNombreUsuario, nuevaIdentificacion, nuevoCargo);
                                nombreUsuario = nuevoNombreUsuario; // Actualizar el nombre de usuario en caso de cambio
                            }
                            case 8 -> {
                                // Cambiar contraseña del empleado
                                System.out.println("\nIngrese su contraseña antigua:");
                                String contraseñaAntigua = scanner.nextLine();
                                System.out.println("Ingrese su nueva contraseña:");
                                String contraseñaNueva = scanner.nextLine();
                                cafeteria.cambiarContraseña(nombreUsuario, contraseñaAntigua, contraseñaNueva);
                            }
                            case 9 -> {
                                // Salir - Menú anterior
                                System.out.println("\n=================================");
                                System.out.println(" ...Saliendo al menú anterior...");
                                System.out.println("---------------------------------");
                                cafeteria.logoutEmpleado();
                            }
                            case 10 -> {
                                // Crear nuevo empleado
                                System.out.println("\nIngrese el nombre del nuevo empleado:");
                                String nombreEmpleado = scanner.nextLine();
                                System.out.println("Ingrese la identificación del nuevo empleado:");
                                String identificacionEmpleado = scanner.nextLine();
                                System.out.println("Ingrese el cargo del nuevo empleado:");
                                String cargoEmpleado = scanner.nextLine();
                                System.out.println("Ingrese la contraseña del nuevo empleado:");
                                String contraseñaEmpleadoNuevo = scanner.nextLine();
                                cafeteria.crearEmpleado(nombreEmpleado, identificacionEmpleado, cargoEmpleado, contraseñaEmpleadoNuevo);

                            }
                            case 11 -> {
                                // Ver empleados
                                cafeteria.mostrarEmpleados();
                            }
                            case 12 -> {
                                // Eliminar empleado
                                System.out.println("Ingrese el nombre del empleado a eliminar:");
                                String nombreEmpleado = scanner.nextLine();
                                cafeteria.eliminarEmpleado(nombreEmpleado);
                            }
                            default -> {
                                // Opción no válida
                                System.out.println("...Opción no válida...");
                            }
                        }

                    } while (opcionEmpleado != 9);

                }
                case 2 -> {
                    // Interacción con el cliente
                    System.out.println("\nIngrese su nombre de cliente:");
                }
            }

        } while (opcionUsuario != 3);
        // Cerrar el scanner al finalizar
        scanner.close();
        System.out.println("Gracias por visitar la Cafetería. ¡Hasta luego!");
    }
}
