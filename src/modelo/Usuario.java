package modelo;

import java.time.LocalDateTime;

public abstract class Usuario {
    protected int idUsuario;
    protected String nombreUsuario;
    protected String correoUsuario;
    protected String contrasenaUsuario;
    protected String rolUsuario;
    protected LocalDateTime fechaCreacionUsuario;

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

    // Getters y setters
    public int getIdUsuario() { return idUsuario; }
    public String getNombreUsuario() { return nombreUsuario; }
    public String getCorreoUsuario() { return correoUsuario; }
    public String getContrasenaUsuario() { return contrasenaUsuario; }
    public String getRolUsuario() { return rolUsuario; }
    public LocalDateTime getFechaCreacionUsuario() { return fechaCreacionUsuario; }

    public void setIdUsuario(int idUsuario) { this.idUsuario = idUsuario; }
    public void setNombreUsuario(String nombreUsuario) { this.nombreUsuario = nombreUsuario; }
    public void setCorreoUsuario(String correoUsuario) { this.correoUsuario = correoUsuario; }
    public void setContrasenaUsuario(String contrasenaUsuario) { this.contrasenaUsuario = contrasenaUsuario; }
    public void setRolUsuario(String rolUsuario) { this.rolUsuario = rolUsuario; }
    public void setFechaCreacionUsuario(LocalDateTime fechaCreacionUsuario) { this.fechaCreacionUsuario = fechaCreacionUsuario; }

    // Método usando pPolimorfismo
    public abstract void mostrarMenu();
}
