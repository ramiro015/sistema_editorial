package main.java.view;

import main.java.controller.UsuarioController;

import java.util.Scanner;

public class UsuarioView {
    private Scanner scanner; // Scanner para entrada de datos desde la consola
    private UsuarioController usuarioController; // Controlador para manejar operaciones relacionadas con los usuarios

    /**
     * Constructor de la clase UsuarioView.
     * Inicializa el scanner para entrada de datos desde la consola y el controlador de usuarios.
     */
    public UsuarioView() {
        this.scanner = new Scanner(System.in); // Inicializa el scanner para entrada de datos desde la consola
        this.usuarioController = new UsuarioController(); // Inicializa el controlador de usuarios
    }

    /**
     * Método para agregar un nuevo usuario.
     * Solicita al usuario que ingrese los datos del nuevo usuario y llama al método correspondiente en el controlador de usuarios.
     */
    public void agregarUsuario() {
        System.out.println("Ingrese el correo electrónico del usuario:");
        String email = scanner.nextLine();

        System.out.println("Ingrese la contraseña del usuario:");
        String password = scanner.nextLine();

        System.out.println("Ingrese el nombre del usuario:");
        String nombre = scanner.nextLine();

        System.out.println("Ingrese el CUIT del usuario:");
        String cuit = scanner.nextLine();

        usuarioController.agregarUsuario(email, password, nombre, cuit); // Llama al método en el controlador para agregar un nuevo usuario
    }

    /**
     * Método para mostrar todos los usuarios.
     * Llama al método correspondiente en el controlador de usuarios para listar todos los usuarios.
     */
    public void verUsuarios() {
        usuarioController.listarTodos(); // Llama al método en el controlador para listar todos los usuarios
    }

    /**
     * Método para buscar un usuario por su nombre.
     * Solicita al usuario que ingrese el nombre del usuario que desea buscar y llama al método correspondiente en el controlador de usuarios.
     */
    public void buscarUsuario() {
        System.out.println("Ingrese el nombre del usuario que desea buscar:");
        String nombre = scanner.nextLine();
        usuarioController.buscarUsuario(nombre); // Llama al método en el controlador para buscar un usuario por su nombre
    }

    /**
     * Método para eliminar un usuario.
     * Solicita al usuario que ingrese el ID del usuario que desea eliminar y llama al método correspondiente en el controlador de usuarios.
     */
    public void eliminarUsuario() {
        System.out.println("Ingrese el ID del usuario que quiere eliminar:");
        String id = scanner.nextLine();
        usuarioController.eliminarUsuario(id); // Llama al método en el controlador para eliminar un usuario
    }
}