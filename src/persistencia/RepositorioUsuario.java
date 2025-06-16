package persistencia;

import modelo.Usuario;
import modelo.UsuarioAdministrador;
import modelo.UsuarioEstandar;

import java.sql.*;

public class RepositorioUsuario {

    public void guardar(Usuario usuario) {
        String sql = "INSERT INTO Usuario (nombreUsuario, correoUsuario, contrasenaUsuario, rolUsuario) VALUES (?, ?, ?, ?)";
        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, usuario.getNombreUsuario());
            stmt.setString(2, usuario.getCorreoUsuario());
            stmt.setString(3, usuario.getContrasenaUsuario());
            stmt.setString(4, usuario.getRolUsuario());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Usuario buscarPorCorreo(String correo) {
        String sql = "SELECT * FROM Usuario WHERE correoUsuario = ?";
        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, correo);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                String rol = rs.getString("rolUsuario");
                int id = rs.getInt("idUsuario");
                String nombre = rs.getString("nombreUsuario");
                String contrasena = rs.getString("contrasenaUsuario");
                String correoUsuario = rs.getString("correoUsuario");
                Timestamp fecha = rs.getTimestamp("fechaCreacionUsuario");

                if ("administrador".equalsIgnoreCase(rol)) {
                    return new UsuarioAdministrador(id, nombre, correoUsuario, contrasena, rol, fecha.toLocalDateTime());
                } else {
                    return new UsuarioEstandar(id, nombre, correoUsuario, contrasena, rol, fecha.toLocalDateTime());
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
