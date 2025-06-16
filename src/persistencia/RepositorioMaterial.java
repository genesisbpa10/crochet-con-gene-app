package persistencia;

import modelo.Material;
import java.sql.*;

public class RepositorioMaterial {

    public void guardar(Material material) {
        String sql = "INSERT INTO Material (nombreMaterial, colorMaterial, tipoMaterial, pesoMaterial, idUsuario) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, material.getNombreMaterial());
            stmt.setString(2, material.getColorMaterial());
            stmt.setString(3, material.getTipoMaterial());
            stmt.setDouble(4, material.getPesoMaterial());
            stmt.setInt(5, material.getIdUsuario());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Material buscarPorId(int idMaterial) {
        String sql = "SELECT * FROM Material WHERE idMaterial = ?";
        Material material = null;

        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idMaterial);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                material = new Material(
                    rs.getInt("idMaterial"),
                    rs.getString("nombreMaterial"),
                    rs.getString("colorMaterial"),
                    rs.getString("tipoMaterial"),
                    rs.getDouble("pesoMaterial"),
                    rs.getInt("idUsuario")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Error al buscar material por ID: " + e.getMessage());
        }
        return material;
    }

    public void actualizar(Material material) {
        String sql = "UPDATE Material SET nombreMaterial = ?, colorMaterial = ?, tipoMaterial = ?, pesoMaterial = ? WHERE idMaterial = ?";

        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, material.getNombreMaterial());
            stmt.setString(2, material.getColorMaterial());
            stmt.setString(3, material.getTipoMaterial());
            stmt.setDouble(4, material.getPesoMaterial());
            stmt.setInt(5, material.getIdMaterial());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void eliminar(int idMaterial) {
        String sql = "DELETE FROM Material WHERE idMaterial = ?";

        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idMaterial);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
