package main.java.view;

import java.util.Scanner;

public class MenuView {
    private Scanner scanner; // Scanner para entrada de datos desde la consola

    /**
     * Constructor de la clase MenuView.
     * Inicializa el scanner para entrada de datos desde la consola.
     */
    public MenuView() {
        scanner = new Scanner(System.in); // Inicializa el scanner para entrada de datos desde la consola
    }

    /**
     * Método para mostrar el menú principal del sistema.
     * Muestra las opciones disponibles y solicita al usuario que seleccione una.
     * @return La opción seleccionada por el usuario.
     */
    public int mostrarMenuPrincipal() {
        System.out.println("==================================================================");
        System.out.println("               SISTEMA DE GESTIÓN");
        System.out.println("==================================================================");
        System.out.println("1. Gestión de usuario");
        System.out.println("2. Gestión de inventario");
        System.out.println("3. Salir");
        System.out.print("Seleccione una opción: ");
        return scanner.nextInt(); // Retorna la opción seleccionada por el usuario
    }

    /**
     * Método para mostrar el menú de gestión de usuarios.
     * Muestra las opciones disponibles para gestionar usuarios y solicita al usuario que seleccione una.
     * @return La opción seleccionada por el usuario.
     */
    public int mostrarMenuUsuario() {
        System.out.println("==================================================================");
        System.out.println("               SISTEMA DE GESTIÓN: USUARIOS");
        System.out.println("==================================================================");
        System.out.println("1. Ver usuarios");
        System.out.println("2. Agregar usuario");
        System.out.println("3. Buscar usuario");
        System.out.println("4. Eliminar usuario");
        System.out.println("5. Volver al menú principal");
        return scanner.nextInt(); // Retorna la opción seleccionada por el usuario
    }

    /**
     * Método para mostrar el menú de gestión de inventario.
     * Muestra las opciones disponibles para gestionar el inventario y solicita al usuario que seleccione una.
     * @return La opción seleccionada por el usuario.
     */
    public int mostrarMenuInventario() {
        System.out.println("==================================================================");
        System.out.println("               SISTEMA DE GESTIÓN: INVENTARIO");
        System.out.println("==================================================================");
        System.out.println("1. Listar títulos ordenados");
        System.out.println("2. Listar ediciones");
        System.out.println("3. Volver al menú principal");
        System.out.print("Seleccione una opción: ");
        return scanner.nextInt(); // Retorna la opción seleccionada por el usuario
    }
}
