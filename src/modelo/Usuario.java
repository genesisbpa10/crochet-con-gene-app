package modelo;

import java.time.LocalDateTime;

public class Usuario {
    private int idUsuario;
    private String nombreUsuario;
    private String correoUsuario;
    private String contrasenaUsuario;
    private String rolUsuario; // "estandar" o "administrador"
    private LocalDateTime fechaCreacionUsuario;

    public Usuario(int idUsuario, String nombreUsuario, String correoUsuario, String contrasenaUsuario, String rolUsuario, LocalDateTime fechaCreacionUsuario) {
        this.idUsuario = idUsuario;
        this.nombreUsuario = nombreUsuario;
        this.correoUsuario = correoUsuario;
        this.contrasenaUsuario = contrasenaUsuario;
        this.rolUsuario = rolUsuario;
        this.fechaCreacionUsuario = fechaCreacionUsuario;
    }

    public Usuario(String nombreUsuario, String correoUsuario, String contrasenaUsuario, String rolUsuario) {
        this.nombreUsuario = nombreUsuario;
        this.correoUsuario = correoUsuario;
        this.contrasenaUsuario = contrasenaUsuario;
        this.rolUsuario = rolUsuario;
        this.fechaCreacionUsuario = LocalDateTime.now();
    }

    // Getters
    public int getIdUsuario() {
        return idUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public String getCorreoUsuario() {
        return correoUsuario;
    }

    public String getContrasenaUsuario() {
        return contrasenaUsuario;
    }

    public String getRolUsuario() {
        return rolUsuario;
    }

    public LocalDateTime getFechaCreacionUsuario() {
        return fechaCreacionUsuario;
    }

    // Setters
    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public void setCorreoUsuario(String correoUsuario) {
        this.correoUsuario = correoUsuario;
    }

    public void setContrasenaUsuario(String contrasenaUsuario) {
        this.contrasenaUsuario = contrasenaUsuario;
    }

    public void setRolUsuario(String rolUsuario) {
        this.rolUsuario = rolUsuario;
    }

    public void setFechaCreacionUsuario(LocalDateTime fechaCreacionUsuario) {
        this.fechaCreacionUsuario = fechaCreacionUsuario;
    }
}
