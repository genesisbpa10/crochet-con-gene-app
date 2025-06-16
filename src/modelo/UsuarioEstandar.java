package modelo;

public class UsuarioEstandar extends Usuario {
    public UsuarioEstandar(int idUsuario, String nombre, String correo, String contrasena, String rol, java.time.LocalDateTime fecha) {
        super(idUsuario, nombre, correo, contrasena, rol, fecha);
    }

    public UsuarioEstandar(String nombre, String correo, String contrasena) {
        super(nombre, correo, contrasena, "estandar");
    }

    @Override
    public void mostrarMenu() {
        System.out.println("Menú estandar: [Ver patrones, Crear puntos, etc.]");
    }
}
