package main.java.controller;

import main.java.view.InventarioView;
import main.java.view.MenuView;
import main.java.view.UsuarioView;

/**
 * Controlador para manejar las operaciones del menú principal.
 */
public class MenuController {
    private MenuView menuView; // Vista del menú principal
    private UsuarioView usuarioView; // Vista de gestión de usuarios
    private InventarioView inventarioView; // Vista de gestión de inventario

    /**
     * Constructor de la clase MenuController.
     * Inicializa las vistas del menú, usuarios e inventario.
     */
    public MenuController() {
        this.menuView = new MenuView();
        this.usuarioView = new UsuarioView();
        this.inventarioView = new InventarioView();
    }

    /**
     * Método para iniciar el menú principal.
     */
    public void iniciar() {
        int opcion;
        do {
            opcion = menuView.mostrarMenuPrincipal(); // Mostrar el menú principal y obtener la opción seleccionada
            switch (opcion) {
                case 1:
                    gestionarUsuarios(); // Llamar al método para gestionar usuarios
                    break;
                case 2:
                    gestionarInventario(); // Llamar al método para gestionar inventario
                    break;
                case 3:
                    System.out.println("Saliendo del sistema..."); // Salir del sistema
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, seleccione nuevamente."); // Mensaje para opciones no válidas
                    break;
            }
        } while (opcion != 3); // Repetir hasta que se seleccione la opción de salida
    }

    /**
     * Método para gestionar las operaciones relacionadas con los usuarios.
     */
    private void gestionarUsuarios() {
        int opcion;
        do {
            opcion = menuView.mostrarMenuUsuario(); // Mostrar el menú de gestión de usuarios y obtener la opción seleccionada
            switch (opcion) {
                case 1:
                    usuarioView.verUsuarios(); // Ver usuarios
                    break;
                case 2:
                    usuarioView.agregarUsuario(); // Agregar usuario
                    break;
                case 3:
                    usuarioView.buscarUsuario(); // Buscar usuario
                    break;
                case 4:
                    usuarioView.eliminarUsuario(); // Eliminar usuario
                    break;
                case 5:
                    System.out.println("Volviendo al menú principal..."); // Volver al menú principal
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, seleccione nuevamente."); // Mensaje para opciones no válidas
                    break;
            }
        } while (opcion != 5); // Repetir hasta que se seleccione la opción de volver al menú principal
    }

    /**
     * Método para gestionar las operaciones relacionadas con el inventario.
     */
    private void gestionarInventario() {
        int opcion;
        do {
            opcion = menuView.mostrarMenuInventario(); // Mostrar el menú de gestión de inventario y obtener la opción seleccionada
            switch (opcion) {
                case 1:
                    inventarioView.verTitulos(); // Ver títulos del inventario
                    break;
                case 2:
                    inventarioView.verEdiciones(); // Ver ediciones del inventario
                    break;
                case 3:
                    System.out.println("Volviendo al menú principal..."); // Volver al menú principal
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, seleccione nuevamente."); // Mensaje para opciones no válidas
                    break;
            }
        } while (opcion != 3); // Repetir hasta que se seleccione la opción de volver al menú principal
    }
}