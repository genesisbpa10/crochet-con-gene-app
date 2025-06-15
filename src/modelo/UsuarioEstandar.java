package modelo;

public class UsuarioEstandar extends Usuario {

    public UsuarioEstandar(int idUsuario, String nombreUsuario, String correoUsuario, String contrasenaUsuario, String rolUsuario, java.time.LocalDateTime fechaCreacionUsuario) {
        super(idUsuario, nombreUsuario, correoUsuario, contrasenaUsuario, rolUsuario, fechaCreacionUsuario);
    }

    public UsuarioEstandar(String nombreUsuario, String correoUsuario, String contrasenaUsuario) {
        super(nombreUsuario, correoUsuario, contrasenaUsuario, "estandar");
    }
}
