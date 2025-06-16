package persistencia;

import modelo.Usuario;

import java.sql.*;

public class RepositorioUsuario {

    public void guardar(Usuario usuario) {
        String sql = "INSERT INTO Usuario (nombreUsuario, correoElectronico, contraseña, rolUsuario) VALUES (?, ?, ?, ?)";
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
        String sql = "SELECT * FROM Usuario WHERE correoElectronico = ?";
        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, correo);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Usuario(
                    rs.getInt("idUsuario"),
                    rs.getString("nombreUsuario"),
                    rs.getString("correoElectronico"),
                    rs.getString("contraseña"),
                    rs.getString("rolUsuario"),
                    rs.getTimestamp("fechaCreacionUsuario").toLocalDateTime()
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
