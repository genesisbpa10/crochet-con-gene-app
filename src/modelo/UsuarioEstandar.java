package modelo;

public class UsuarioEstandar extends Usuario {

    public UsuarioEstandar(String nombre, String correo, String contrasena, String tipoUsuario) {
        super(nombre, correo, contrasena, tipoUsuario);
    }

    @Override
    public String getTipoUsuario() {
        return "Estandar";
    }
}
