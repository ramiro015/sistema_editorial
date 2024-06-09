package main.java.controller;

import main.java.model.Titulo;
import main.java.util.ConexionDB;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Controlador para manejar operaciones relacionadas con los títulos.
 */
public class TituloController {
    private List<Titulo> listaTitulos; // Lista de títulos

    /**
     * Constructor de la clase TituloController.
     * Inicializa la lista de títulos.
     */
    public TituloController() {
        this.listaTitulos = new ArrayList<>();
    }

    /**
     * Método para listar todos los títulos almacenados en la base de datos.
     */
    public void listarTodos() {
        try (Connection connection = ConexionDB.getConnection()) {
            // Obtener la lista de títulos desde la base de datos
            List<Titulo> titulos = Titulo.listarTodos(connection);
            if (titulos.isEmpty()) {
                // Si no hay títulos, mostrar un mensaje indicándolo
                System.out.println("No hay títulos registrados.");
            } else {
                // Si hay títulos, mostrar la lista de títulos
                System.out.println("Lista de Títulos:");
                for (Titulo titulo : titulos) {
                    System.out.println(titulo);
                }
            }
        } catch (SQLException e) {
            // Manejar excepciones en caso de error de conexión a la base de datos
            e.printStackTrace();
        }
    }
}