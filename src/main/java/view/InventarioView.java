package main.java.view;

import main.java.controller.TituloController;
import main.java.controller.EdicionController;

import java.util.Scanner;

public class InventarioView {
    private Scanner scanner; // Scanner para entrada de datos desde la consola
    private TituloController tituloController; // Controlador para manejar operaciones relacionadas con los títulos
    private EdicionController edicionesController; // Controlador para manejar operaciones relacionadas con las ediciones

    /**
     * Constructor de la clase InventarioView.
     * Inicializa el scanner y los controladores de títulos y ediciones.
     */
    public InventarioView() {
        this.scanner = new Scanner(System.in); // Inicializa el scanner para entrada de datos desde la consola
        this.tituloController = new TituloController(); // Inicializa el controlador de títulos
        this.edicionesController = new EdicionController(); // Inicializa el controlador de ediciones
    }

    /**
     * Método para mostrar todos los títulos en el inventario.
     * Llama al método listarTodos del controlador de títulos.
     */
    public void verTitulos() {
        tituloController.listarTodos(); // Llama al método listarTodos del controlador de títulos
    }

    /**
     * Método para mostrar todas las ediciones en el inventario.
     * Llama al método listarTodas del controlador de ediciones.
     */
    public void verEdiciones() {
        edicionesController.listarTodas(); // Llama al método listarTodas del controlador de ediciones
    }
}
