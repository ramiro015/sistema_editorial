package main.java.model;

import main.java.util.ConexionDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private int id; // ID del usuario
    private String email; // Correo electrónico del usuario
    private String password; // Contraseña del usuario
    private String nombre; // Nombre del usuario
    private String cuit; // CUIT (Clave Única de Identificación Tributaria) del usuario

    public Usuario(int id, String email, String password, String nombre, String cuit) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.nombre = nombre;
        this.cuit = cuit;
    }

    // Getters y setters

    /**
     * Obtiene el ID del usuario.
     * @return ID del usuario.
     */
    public int getId() {
        return id;
    }

    /**
     * Establece el ID del usuario.
     * @param id ID del usuario a establecer.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtiene el correo electrónico del usuario.
     * @return Correo electrónico del usuario.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Establece el correo electrónico del usuario.
     * @param email Correo electrónico del usuario a establecer.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Obtiene la contraseña del usuario.
     * @return Contraseña del usuario.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Establece la contraseña del usuario.
     * @param password Contraseña del usuario a establecer.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Obtiene el nombre del usuario.
     * @return Nombre del usuario.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del usuario.
     * @param nombre Nombre del usuario a establecer.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el CUIT (Clave Única de Identificación Tributaria) del usuario.
     * @return CUIT del usuario.
     */
    public String getCuit() {
        return cuit;
    }

    /**
     * Establece el CUIT (Clave Única de Identificación Tributaria) del usuario.
     * @param cuit CUIT del usuario a establecer.
     */
    public void setCuit(String cuit) {
        this.cuit = cuit;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", nombre='" + nombre + '\'' +
                ", cuit='" + cuit + '\'' +
                '}';
    }

    // Métodos para la manipulación de datos en la base de datos

    /**
     * Inserta un nuevo usuario en la base de datos.
     * @param connection Conexión a la base de datos.
     * @param email Correo electrónico del usuario.
     * @param password Contraseña del usuario.
     * @param nombre Nombre del usuario.
     * @param cuit CUIT del usuario.
     * @throws SQLException Si hay un error al ejecutar la consulta SQL.
     */
    public static void insertar(Connection connection, String email, String password, String nombre, String cuit) throws SQLException {
        String query = "INSERT INTO usuario (correo, contraseña, nombre, CUIT) VALUES (?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, email);
            statement.setString(2, password);
            statement.setString(3, nombre);
            statement.setString(4, cuit);
            statement.executeUpdate();
        }
    }

    /**
     * Elimina un usuario de la base de datos.
     * @param connection Conexión a la base de datos.
     * @param idUsuario ID del usuario a eliminar.
     * @throws SQLException Si hay un error al ejecutar la consulta SQL.
     */
    public static void eliminar(Connection connection, String idUsuario) throws SQLException {
        String query = "DELETE FROM usuario WHERE id_usuario = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, idUsuario);
            statement.executeUpdate();
        }
    }

    /**
     * Obtiene un usuario por su ID desde la base de datos.
     * @param connection Conexión a la base de datos.
     * @param id ID del usuario a obtener.
     * @return El usuario correspondiente al ID proporcionado, o null si no se encuentra.
     * @throws SQLException Si hay un error al ejecutar la consulta SQL.
     */
    public static Usuario obtenerPorId(Connection connection, int id) throws SQLException {
        String query = "SELECT * FROM usuario WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    String email = resultSet.getString("correo");
                    String password = resultSet.getString("contraseña");
                    String nombre = resultSet.getString("nombre");
                    String cuit = resultSet.getString("CUIT");
                    return new Usuario(id, email, password, nombre, cuit);
                } else {
                    return null;
                }
            }
        }
    }

    /**
     * Obtiene una lista de todos los usuarios almacenados en la base de datos.
     * @param connection Conexión a la base de datos.
     * @return Lista de todos los usuarios almacenados en la base de datos.
     * @throws SQLException Si hay un error al ejecutar la consulta SQL.
     */
    public static List<Usuario> listarTodos(Connection connection) throws SQLException {
        List<Usuario> usuarios = new ArrayList<>();
        String query = "SELECT * FROM usuario";
        try (PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                int id = resultSet.getInt("id_usuario");
                String email = resultSet.getString("correo");
                String password = resultSet.getString("contraseña");
                String nombre = resultSet.getString("nombre");
                String cuit = resultSet.getString("CUIT");
                usuarios.add(new Usuario(id, email, password, nombre, cuit));
            }
        }
        return usuarios;
    }

    /**
     * Busca usuarios por nombre en la base de datos.
     * @param nombre Nombre (o parte del nombre) a buscar.
     * @return Lista de usuarios encontrados que coinciden con el nombre proporcionado.
     * @throws SQLException Si hay un error al ejecutar la consulta SQL.
     */
    public static List<Usuario> buscarUsuarios(String nombre) throws SQLException {
        List<Usuario> usuariosEncontrados = new ArrayList<>();
        String query = "SELECT * FROM usuario WHERE nombre LIKE ?";
        try (Connection connection = ConexionDB.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, "%" + nombre + "%");
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    int id = resultSet.getInt("id_usuario");
                    String email = resultSet.getString("correo");
                    String password = resultSet.getString("contraseña");
                    String nombreUsuario = resultSet.getString("nombre");
                    String cuit = resultSet.getString("CUIT");
                    usuariosEncontrados.add(new Usuario(id, email, password, nombreUsuario, cuit));
                }
            }
        }
        return usuariosEncontrados;
    }
}