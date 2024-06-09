package main.java.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Edicion {
    private int id;
    private Titulo titulo;
    private int numeroEdicion;
    private String fechaLanzamiento;
    private String isbn;
    private String portada;
    private Integer formato;

    public Edicion(int id, Titulo titulo, int numeroEdicion, String fechaLanzamiento, String isbn, String portada, Integer formato) {
        this.id = id;
        this.titulo = titulo;
        this.numeroEdicion = numeroEdicion;
        this.fechaLanzamiento = fechaLanzamiento;
        this.isbn = isbn;
        this.portada = portada;
        this.formato = formato;
    }

    // Getters y setters para la clase Edicion

    /**
     * Obtiene el número de edición.
     * @return Número de edición.
     */
    public int getNumeroEdicion() {
        return numeroEdicion;
    }

    /**
     * Establece el número de edición.
     * @param numeroEdicion Número de edición a establecer.
     */
    public void setNumeroEdicion(int numeroEdicion) {
        this.numeroEdicion = numeroEdicion;
    }

    /**
     * Obtiene la fecha de lanzamiento.
     * @return Fecha de lanzamiento.
     */
    public String getFechaLanzamiento() {
        return fechaLanzamiento;
    }

    /**
     * Establece la fecha de lanzamiento.
     * @param fechaLanzamiento Fecha de lanzamiento a establecer.
     */
    public void setFechaLanzamiento(String fechaLanzamiento) {
        this.fechaLanzamiento = fechaLanzamiento;
    }

    /**
     * Obtiene el ISBN.
     * @return ISBN.
     */
    public String getIsbn() {
        return isbn;
    }

    /**
     * Establece el ISBN.
     * @param isbn ISBN a establecer.
     */
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    /**
     * Obtiene la portada.
     * @return Portada.
     */
    public String getPortada() {
        return portada;
    }

    /**
     * Establece la portada.
     * @param portada Portada a establecer.
     */
    public void setPortada(String portada) {
        this.portada = portada;
    }

    /**
     * Obtiene el formato.
     * @return Formato.
     */
    public Integer getFormato() {
        return formato;
    }

    /**
     * Establece el formato.
     * @param formato Formato a establecer.
     */
    public void setFormato(Integer formato) {
        this.formato = formato;
    }

    @Override
    public String toString() {
        return "Edicion{" +
                "id=" + id +
                ", titulo=" + titulo +
                ", numeroEdicion=" + numeroEdicion +
                ", fechaLanzamiento='" + fechaLanzamiento + '\'' +
                ", isbn='" + isbn + '\'' +
                ", portada='" + portada + '\'' +
                ", formato=" + formato +
                '}';
    }

    public static List<Edicion> listarTodas(Connection connection) throws SQLException {
        List<Edicion> ediciones = new ArrayList<>();
        String query = "SELECT e.id_edicion, e.numero_edicion, e.ISBN, e.fecha_lanzamiento, e.portada, e.id_formato, " +
                "e.formato, e.drm, e.bytes, e.alto, e.ancho, e.peso, " +
                "t.id_titulo, t.titulo, t.subtitulo " +
                "FROM edicion e " +
                "JOIN titulo t ON e.id_titulo = t.id_titulo";
        try (PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                Edicion edicion;
                int id = resultSet.getInt("id_edicion");
                Integer numeroEdicion = resultSet.getInt("numero_edicion");
                String isbn = resultSet.getString("ISBN");
                String fechaLanzamiento = resultSet.getString("fecha_lanzamiento");
                String portada = resultSet.getString("portada");
                Integer idFormato = resultSet.getInt("id_formato");
                Integer idTitulo = resultSet.getInt("id_titulo");
                String titulo = resultSet.getString("titulo");
                String subtitulo = resultSet.getString("subtitulo");
                Titulo tituloObjeto = new Titulo(idTitulo, titulo, subtitulo);
                if (idFormato == 1){
                    // Crear instancia de EdicionFisica
                    int alto = resultSet.getInt("alto");
                    int ancho = resultSet.getInt("ancho");
                    int peso = resultSet.getInt("peso");
                    edicion = new EdicionFisica(id, tituloObjeto, numeroEdicion, fechaLanzamiento, isbn, portada, idFormato, alto, ancho, peso);
                } else {
                    // Crear instancia de EdicionDigital
                    boolean drm = resultSet.getBoolean("drm");
                    String formatoDigital = resultSet.getString("formato");
                    Integer tamañoBytes = resultSet.getInt("bytes");
                    edicion = new EdicionDigital(id, tituloObjeto, numeroEdicion, fechaLanzamiento, isbn, portada, idFormato, formatoDigital, drm, tamañoBytes);
                }
                ediciones.add(edicion);
            }
        }
        return ediciones;
    }
}
