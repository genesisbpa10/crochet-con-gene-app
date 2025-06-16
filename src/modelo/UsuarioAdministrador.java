package modelo;

public class UsuarioAdministrador extends Usuario {
    public UsuarioAdministrador(int idUsuario, String nombre, String correo, String contrasena, String rol, java.time.LocalDateTime fecha) {
        super(idUsuario, nombre, correo, contrasena, rol, fecha);
    }

    public UsuarioAdministrador(String nombre, String correo, String contrasena) {
        super(nombre, correo, contrasena, "administrador");
    }

    @Override
    public void mostrarMenu() {
        System.out.println("Menú administrador: [Gestionar materiales, Ver usuarios, etc.]");
    }
}
