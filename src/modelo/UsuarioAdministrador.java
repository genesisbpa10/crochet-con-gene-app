package modelo;

public class UsuarioAdministrador extends Usuario {

    public UsuarioAdministrador(String nombre, String correo, String contrasena, String tipoUsuario) {
        super(nombre, correo, contrasena, tipoUsuario);
    }

    @Override
    public String getTipoUsuario() {
        return "Administrador";
    }
}
