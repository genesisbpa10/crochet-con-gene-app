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
            stmt.setString(1, patron.getNombre());
            stmt.setString(2, patron.getDescripcion());
            stmt.setString(3, patron.getTipoPatron());
            stmt.setInt(4, patron.getIdUsuario());
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
                int id       = rs.getInt("idPatron");
                String n     = rs.getString("nombrePatron");
                String d     = rs.getString("descripcionPatron");
                String t     = rs.getString("tipoPatron");
                int userId   = rs.getInt("idUsuario");       // ← lee el FK
                Patron p     = new Patron(id, n, d, t, userId);
                p.setComposicion(new ArrayList<>());         // de momento vacío
                lista.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public Patron buscarPorNombre(String nombre) {
        String sql = "SELECT * FROM Patron WHERE nombrePatron = ?";
        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, nombre);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                int id     = rs.getInt("idPatron");
                String n   = rs.getString("nombrePatron");
                String d   = rs.getString("descripcionPatron");
                String t   = rs.getString("tipoPatron");
                int userId = rs.getInt("idUsuario");
                Patron p   = new Patron(id, n, d, t, userId);
                p.setComposicion(new ArrayList<>());
                return p;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Patron buscarPorId(int idPatron) {
        String sql = "SELECT * FROM Patron WHERE idPatron = ?";
        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idPatron);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                int id     = rs.getInt("idPatron");
                String n   = rs.getString("nombrePatron");
                String d   = rs.getString("descripcionPatron");
                String t   = rs.getString("tipoPatron");
                int userId = rs.getInt("idUsuario");
                Patron p   = new Patron(id, n, d, t, userId);
                p.setComposicion(new ArrayList<>());
                return p;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
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

    public void actualizar(Patron patron) {
        String sql = "UPDATE Patron SET nombrePatron = ?, descripcionPatron = ?, tipoPatron = ? WHERE idPatron = ?";
        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, patron.getNombre());
            stmt.setString(2, patron.getDescripcion());
            stmt.setString(3, patron.getTipoPatron());
            stmt.setInt(4, patron.getIdPatron());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
