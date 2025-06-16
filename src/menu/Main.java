package menu;

import controlador.ControladorUsuario;
import modelo.Usuario;

public class Main {
    public static void main(String[] args) {
        ControladorUsuario ctrl = new ControladorUsuario();

        // Registramos un usuario
        Usuario nuevo = ctrl.registrarUsuario("Juan Pérez", "juan@example.com", "123456", "estandar");
        System.out.println("Usuario registrado: " + nuevo.getNombreUsuario() + " (" + nuevo.getCorreoUsuario() + ")");

        // Autenticamos
        Usuario logueado = ctrl.login("juan@example.com", "123456");

        if (logueado != null) {
            System.out.println("Autenticación exitosa para: " + logueado.getNombreUsuario());
        } else {
            System.out.println("Error de autenticación");
        }
    }
}
