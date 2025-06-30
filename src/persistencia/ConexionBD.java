package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {
    private static final String URL = "jdbc:mysql://172.21.240.1:3306/sistema_crochet";
    private static final String USUARIO = "sistema_crochet_db";
    private static final String CONTRASENA = "cr0CH3!!!C";

    public static Connection obtenerConexion() throws SQLException {
        return DriverManager.getConnection(URL, USUARIO, CONTRASENA);
    }
}
