package modelo;
public class UsuarioAdministrador extends Usuario {

    public UsuarioAdministrador(int idUsuario, String nombreUsuario, String correoUsuario, String contrasenaUsuario, String rolUsuario, java.time.LocalDateTime fechaCreacionUsuario) {
        super(idUsuario, nombreUsuario, correoUsuario, contrasenaUsuario, rolUsuario, fechaCreacionUsuario);
    }

    public UsuarioAdministrador(String nombreUsuario, String correoUsuario, String contrasenaUsuario) {
        super(nombreUsuario, correoUsuario, contrasenaUsuario, "administrador");
    }
}