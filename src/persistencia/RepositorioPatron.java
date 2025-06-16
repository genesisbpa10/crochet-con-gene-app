package persistencia;

import modelo.Patron;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RepositorioPatron {

    public void guardar(Patron patron) {
        String sql = "INSERT INTO Patron (nombrePatron, descripcionPatron, tipoPatron, idUsuario) VALUES (?, ?, ?, ?)";
        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, patron.getNombrePatron());
            stmt.setString(2, patron.getDescripcionPatron());
            stmt.setString(3, patron.getTipoPatron());
            stmt.setInt(4, 4); // Reemplazá con el ID del usuario que lo creó
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Patron> listarTodos() {
        List<Patron> lista = new ArrayList<>();
        String sql = "SELECT * FROM Patron";
        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Patron p = new Patron(
                    rs.getInt("idPatron"),
                    rs.getString("nombrePatron"),
                    rs.getString("descripcionPatron"),
                    rs.getString("tipoPatron")
                );
                lista.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public void eliminar(int idPatron) {
        String sql = "DELETE FROM Patron WHERE idPatron = ?";
        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idPatron);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para buscar un patrón por nombre
    public Patron buscarPorNombre(String nombre) {
        String sql = "SELECT * FROM Patron WHERE nombrePatron = ?";
        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, nombre);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Patron(
                    rs.getInt("idPatron"),
                    rs.getString("nombrePatron"),
                    rs.getString("descripcionPatron"),
                    rs.getString("tipoPatron")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    // Método para actualizar un patrón existente
    public void actualizar(Patron patron) {
        String sql = "UPDATE Patron SET nombrePatron = ?, descripcionPatron = ?, tipoPatron = ? WHERE idPatron = ?";
        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, patron.getNombrePatron());
            stmt.setString(2, patron.getDescripcionPatron());
            stmt.setString(3, patron.getTipoPatron());
            stmt.setInt(4, patron.getIdPatron());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    // Método para buscar un patrón por ID
    public Patron buscarPorId(int idPatron) {
        String sql = "SELECT * FROM Patron WHERE idPatron = ?";
        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idPatron);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Patron(
                    rs.getInt("idPatron"),
                    rs.getString("nombrePatron"),
                    rs.getString("descripcionPatron"),
                    rs.getString("tipoPatron")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}