package main.java.model;

import main.java.util.ConexionDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Titulo {
    private int id; // ID del título
    private String titulo; // Título
    private String subtitulo; // Subtítulo

    public Titulo(int id, String titulo, String subtitulo) {
        this.id = id;
        this.titulo = titulo;
        this.subtitulo = subtitulo;
    }

    // Getters y setters para la clase Titulo

    /**
     * Obtiene el ID del título.
     * @return ID del título.
     */
    public int getId() {
        return id;
    }

    /**
     * Establece el ID del título.
     * @param id ID del título a establecer.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtiene el título.
     * @return Título.
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * Establece el título.
     * @param titulo Título a establecer.
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * Obtiene el subtítulo.
     * @return Subtítulo.
     */
    public String getSubtitulo() {
        return subtitulo;
    }

    /**
     * Establece el subtítulo.
     * @param subtitulo Subtítulo a establecer.
     */
    public void setSubtitulo(String subtitulo) {
        this.subtitulo = subtitulo;
    }

    @Override
    public String toString() {
        return "Titulo{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", subtitulo='" + subtitulo + '\'' +
                '}';
    }

    /**
     * Obtiene un título por su ID desde la base de datos.
     * @param connection Conexión a la base de datos.
     * @param idTitulo ID del título a obtener.
     * @return El título correspondiente al ID proporcionado, o null si no se encuentra.
     * @throws SQLException Si hay un error al ejecutar la consulta SQL.
     */
    public static Titulo getTitulo(Connection connection, int idTitulo) throws SQLException {
        String query = "SELECT * FROM titulo WHERE id_titulo = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, idTitulo);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    String titulo = resultSet.getString("titulo");
                    String subtitulo = resultSet.getString("subtitulo");
                    return new Titulo(idTitulo, titulo, subtitulo);
                } else {
                    return null; // Título no encontrado
                }
            }
        }
    }

    /**
     * Obtiene una lista de todos los títulos almacenados en la base de datos.
     * @param connection Conexión a la base de datos.
     * @return Lista de todos los títulos almacenados en la base de datos.
     * @throws SQLException Si hay un error al ejecutar la consulta SQL.
     */
    public static List<Titulo> listarTodos(Connection connection) throws SQLException {
        List<Titulo> titulos = new ArrayList<>();
        String query = "SELECT * FROM titulo ORDER BY titulo";
        try (PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                int id = resultSet.getInt("id_titulo");
                String titulo = resultSet.getString("titulo");
                String subtitulo = resultSet.getString("subtitulo");
                titulos.add(new Titulo(id, titulo, subtitulo));
            }
        }
        return titulos;
    }
}
