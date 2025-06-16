package persistencia;

import modelo.Material;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RepositorioMaterial {

    public void guardar(Material material) {
        String sql = "INSERT INTO Material (nombreMaterial, colorMaterial, pesoMaterial) VALUES (?, ?, ?)";
        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, material.getNombreMaterial());
            stmt.setString(2, material.getColorMaterial());
            stmt.setDouble(3, material.getPesoMaterial());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Material> listarTodos() {
        List<Material> materiales = new ArrayList<>();
        String sql = "SELECT * FROM Material";
        try (Connection conn = ConexionBD.obtenerConexion();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Material m = new Material(
                    rs.getInt("idMaterial"),
                    rs.getString("nombreMaterial"),
                    rs.getString("colorMaterial"),
                    rs.getDouble("pesoMaterial")
                );
                materiales.add(m);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return materiales;
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

    public void actualizar(Material material) {
        String sql = "UPDATE Material SET nombreMaterial = ?, colorMaterial = ?, pesoMaterial = ? WHERE idMaterial = ?";
        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, material.getNombreMaterial());
            stmt.setString(2, material.getColorMaterial());
            stmt.setDouble(3, material.getPesoMaterial());
            stmt.setInt(4, material.getIdMaterial());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public Material buscarPorId(int idMaterial) {
        Material material = null;
        String sql = "SELECT * FROM Material WHERE idMaterial = ?";
        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idMaterial);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                material = new Material(
                    rs.getInt("idMaterial"),
                    rs.getString("nombreMaterial"),
                    rs.getString("colorMaterial"),
                    rs.getDouble("pesoMaterial")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return material;
    }
}