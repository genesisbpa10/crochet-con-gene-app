package persistencia;

import modelo.Punto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RepositorioPunto {

    public void guardar(Punto punto, int idUsuario) {
        String sql = "INSERT INTO Punto (nombrePunto, descripcionPunto, caracteristicasPunto, pesoPunto, idUsuario) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, punto.getNombrePunto());
            stmt.setString(2, punto.getDescripcionPunto());
            stmt.setString(3, punto.getCaracteristicasPunto());
            stmt.setString(4, punto.getPesoPunto());
            stmt.setInt(5, idUsuario);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // NUEVO: Listar puntos por usuario
    public List<Punto> obtenerPuntosPorUsuario(int idUsuario) {
        List<Punto> puntos = new ArrayList<>();
        String sql = "SELECT * FROM Punto WHERE idUsuario = ?";
        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idUsuario);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Punto p = new Punto(
                    rs.getInt("idPunto"),
                    rs.getString("nombrePunto"),
                    rs.getString("descripcionPunto"),
                    rs.getString("caracteristicasPunto"),
                    rs.getString("pesoPunto")
                );
                puntos.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return puntos;
    }

    public void eliminar(int idPunto) {
        String sql = "DELETE FROM Punto WHERE idPunto = ?";
        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idPunto);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // NUEVO: Actualizar punto por id
    public void actualizar(Punto punto, int idPunto) {
        String sql = "UPDATE Punto SET nombrePunto = ?, descripcionPunto = ?, caracteristicasPunto = ?, pesoPunto = ? WHERE idPunto = ?";
        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, punto.getNombrePunto());
            stmt.setString(2, punto.getDescripcionPunto());
            stmt.setString(3, punto.getCaracteristicasPunto());
            stmt.setString(4, punto.getPesoPunto());
            stmt.setInt(5, idPunto);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Punto buscarPorId(int idPunto) {
        Punto punto = null;
        String sql = "SELECT * FROM Punto WHERE idPunto = ?";
        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idPunto);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                punto = new Punto(
                    rs.getInt("idPunto"),
                    rs.getString("nombrePunto"),
                    rs.getString("descripcionPunto"),
                    rs.getString("caracteristicasPunto"),
                    rs.getString("pesoPunto")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return punto;
    }

    public Punto buscarPorNombre(String nombre) {
        Punto punto = null;
        String sql = "SELECT * FROM Punto WHERE nombrePunto = ?";
        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, nombre);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                punto = new Punto(
                    rs.getInt("idPunto"),
                    rs.getString("nombrePunto"),
                    rs.getString("descripcionPunto"),
                    rs.getString("caracteristicasPunto"),
                    rs.getString("pesoPunto")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return punto;
    }
}