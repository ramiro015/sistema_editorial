package main.java;

import main.java.controller.MenuController;

/**
 * Clase principal que inicia la aplicación.
 */
public class Main {
    /**
     * Método principal que inicia la aplicación.
     * Crea una instancia del controlador de menú y llama al método para iniciar el sistema.
     */
    public static void main(String[] args) {
        MenuController controller = new MenuController(); // Crea una instancia del controlador de menú
        controller.iniciar(); // Llama al método para iniciar el sistema
    }
}
