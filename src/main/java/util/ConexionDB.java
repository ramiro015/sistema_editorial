package main.java.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionDB {
    // URL de conexión a la base de datos MySQL
    private static final String URL = "jdbc:mysql://srv1202.hstgr.io:3306/u489541634_prueba";
    private static final String USER = "u489541634_prueba";
    private static final String PASSWORD = "?bz+|9dZ";

    // Método para obtener una conexión a la base de datos
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
