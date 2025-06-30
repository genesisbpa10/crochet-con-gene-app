package persistencia;

import modelo.Patron;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import modelo.ComposicionPatron;
import modelo.Punto;

public class RepositorioPatron {

    public void guardar(Patron patron) {
        String sql = "INSERT INTO Patron (nombrePatron, descripcionPatron, tipoPatron, idUsuario) VALUES (?, ?, ?, ?)";
        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, patron.getNombre());
            stmt.setString(2, patron.getDescripcion());
            stmt.setString(3, patron.getTipoPatron());
            stmt.setInt(4, patron.getIdUsuario());
            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();
            int idPatron = -1;
            if (rs.next()) {
                idPatron = rs.getInt(1);
            }
            // Guardar la composición
            if (idPatron != -1 && patron.getComposicion() != null) {
                for (ComposicionPatron cp : patron.getComposicion()) {
                    guardarComposicionPatron(idPatron, cp);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void guardarComposicionPatron(int idPatron, ComposicionPatron cp) {
        String sql = "INSERT INTO Patron_Punto (idPatron, idPunto, cantidadPatronPunto) VALUES (?, ?, ?) " +
                     "ON DUPLICATE KEY UPDATE cantidadPatronPunto = VALUES(cantidadPatronPunto)";
        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idPatron);
            stmt.setInt(2, cp.getPunto().getIdPunto());
            stmt.setInt(3, cp.getCantidad());
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
                int userId   = rs.getInt("idUsuario");
                Patron p     = new Patron(id, n, d, t, userId);
                p.setComposicion(obtenerComposicionPorPatron(id));
                lista.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    private List<ComposicionPatron> obtenerComposicionPorPatron(int idPatron) {
        List<ComposicionPatron> composicion = new ArrayList<>();
        String sql = "SELECT c.*, p.nombrePunto, p.descripcionPunto, p.caracteristicasPunto, p.pesoPunto " +
                     "FROM Patron_Punto c JOIN Punto p ON c.idPunto = p.idPunto WHERE c.idPatron = ?";
        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idPatron);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Punto punto = new Punto(
                    rs.getInt("idPunto"),
                    rs.getString("nombrePunto"),
                    rs.getString("descripcionPunto"),
                    rs.getString("caracteristicasPunto"),
                    rs.getString("pesoPunto")
                );
                int cantidad = rs.getInt("cantidadPatronPunto");
                composicion.add(new ComposicionPatron(punto, cantidad));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return composicion;
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
                p.setComposicion(obtenerComposicionPorPatron(id));
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
                p.setComposicion(obtenerComposicionPorPatron(id));
                return p;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void eliminar(int idPatron) {
        // Elimina la composición primero (por FK)
        String sqlComp = "DELETE FROM Patron_Punto WHERE idPatron = ?";
        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sqlComp)) {
            stmt.setInt(1, idPatron);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // Luego elimina el patrón
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
        // Actualiza la composición: elimina y vuelve a insertar
        eliminarComposicionPatron(patron.getIdPatron());
        if (patron.getComposicion() != null) {
            for (ComposicionPatron cp : patron.getComposicion()) {
                guardarComposicionPatron(patron.getIdPatron(), cp);
            }
        }
    }

    private void eliminarComposicionPatron(int idPatron) {
        String sql = "DELETE FROM Patron_Punto WHERE idPatron = ?";
        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idPatron);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}