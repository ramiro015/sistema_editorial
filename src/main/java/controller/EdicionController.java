package main.java.controller;

import main.java.model.Edicion;
import main.java.util.ConexionDB;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Controlador para manipular operaciones relacionadas con las ediciones.
 */
public class EdicionController {
    private List<Edicion> listaEdiciones;

    /**
     * Constructor de la clase EdicionController.
     * Inicializa la lista de ediciones.
     */
    public EdicionController() {
        this.listaEdiciones = new ArrayList<>();
    }

    /**
     * Lista todas las ediciones almacenadas en la base de datos.
     */
    public void listarTodas() {
        try (Connection connection = ConexionDB.getConnection()) {
            // Obtiene la lista de ediciones desde la base de datos
            List<Edicion> ediciones = Edicion.listarTodas(connection);
            if (ediciones.isEmpty()) {
                // Si no hay ediciones, muestra un mensaje indicándolo
                System.out.println("No hay ediciones registradas.");
            } else {
                // Si hay ediciones, muestra la lista de ediciones
                System.out.println("Lista de Ediciones:");
                for (Edicion edicion : ediciones) {
                    System.out.println(edicion);
                }
            }
        } catch (SQLException e) {
            // Manejo de excepciones en caso de error de conexión a la base de datos
            e.printStackTrace();
        }
    }
}
