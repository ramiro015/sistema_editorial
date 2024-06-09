package main.java.controller;

import main.java.model.Usuario;
import main.java.util.ConexionDB;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

/**
 * Controlador para manejar operaciones relacionadas con los usuarios.
 */
public class UsuarioController {
    private List<Usuario> listaUsuarios; // Lista de usuarios

    /**
     * Constructor de la clase UsuarioController.
     * Inicializa la lista de usuarios.
     */
    public UsuarioController() {
        this.listaUsuarios = new ArrayList<>();
    }

    /**
     * Método para agregar un nuevo usuario a la base de datos.
     * @param email Correo electrónico del usuario.
     * @param password Contraseña del usuario.
     * @param nombre Nombre del usuario.
     * @param cuit CUIT del usuario.
     */
    public void agregarUsuario(String email, String password, String nombre, String cuit){
        try (Connection connection = ConexionDB.getConnection()) {
            Usuario.insertar(connection, email, password, nombre, cuit); // Insertar usuario en la base de datos
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Método para listar todos los usuarios almacenados en la base de datos.
     */
    public void listarTodos() {
        try (Connection connection = ConexionDB.getConnection()) {
            // Obtener la lista de usuarios desde la base de datos
            List<Usuario> usuarios = Usuario.listarTodos(connection);
            if (usuarios.isEmpty()) {
                // Si no hay usuarios, mostrar un mensaje indicándolo
                System.out.println("No hay usuarios registrados.");
            } else {
                // Si hay usuarios, mostrar la lista de usuarios
                System.out.println("Lista de Usuarios:");
                for (Usuario usuario : usuarios) {
                    System.out.println(usuario);
                }
            }
        } catch (SQLException e) {
            // Manejar excepciones en caso de error de conexión a la base de datos
            e.printStackTrace();
        }
    }

    /**
     * Método para buscar usuarios por nombre en la base de datos.
     * @param nombre Nombre del usuario a buscar.
     */
    public void buscarUsuario(String nombre) {
        try (Connection connection = ConexionDB.getConnection()) {
            // Buscar usuarios por nombre en la base de datos
            List<Usuario> usuarios = Usuario.buscarUsuarios(nombre);
            if (usuarios.isEmpty()) {
                // Si no se encuentra ningún usuario, mostrar un mensaje indicándolo
                System.out.println("No se encontraron usuarios con el nombre: " + nombre);
            } else {
                // Si se encuentran usuarios, mostrar la lista de usuarios encontrados
                System.out.println("Usuarios encontrados con el nombre '" + nombre + "':");
                for (Usuario usuario : usuarios) {
                    System.out.println(usuario);
                }
            }
        } catch (SQLException e) {
            // Manejar excepciones en caso de error de conexión a la base de datos
            e.printStackTrace();
        }
    }

    /**
     * Método para eliminar un usuario de la base de datos.
     * @param idUsuario ID del usuario a eliminar.
     */
    public void eliminarUsuario(String idUsuario) {
        try (Connection connection = ConexionDB.getConnection()) {
            Usuario.eliminar(connection, idUsuario); // Eliminar usuario de la base de datos
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}