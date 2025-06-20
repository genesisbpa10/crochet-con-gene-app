package menu;

import controlador.ControladorUsuario;
import modelo.Usuario;

import java.util.Scanner;

public class Consola {
    private static final Scanner scanner = new Scanner(System.in);
    private static final ControladorUsuario controladorUsuario = new ControladorUsuario();

    public static void main(String[] args) {
        boolean salir = false;

        while (!salir) {
            System.out.println("\n--- Menu Inicial ---");
            System.out.println("1. Registrar nuevo usuario");
            System.out.println("2. Iniciar sesion");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opcion: ");
            String opcion = scanner.nextLine();

            switch (opcion) {
                case "1" -> registrarUsuario();
                case "2" -> {
                    Usuario usuario = iniciarSesion();
                    if (usuario != null) {
                        mostrarMenuPrincipal(usuario);
                    }
                }
                case "3" -> {
                    System.out.println("Saliendo del sistema...");
                    salir = true;
                }
                default -> System.out.println("Opcion invalida. Intente nuevamente.");
            }
        }

        scanner.close();
    }

    private static void registrarUsuario() {
        System.out.println("\n--- Registro de Usuario ---");
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Correo: ");
        String correo = scanner.nextLine();
        System.out.print("Contrasena: ");
        String contrasena = scanner.nextLine();
        System.out.print("Rol (estandar o administrador): ");
        String rol = scanner.nextLine().toLowerCase();

        Usuario nuevo = controladorUsuario.registrarUsuario(nombre, correo, contrasena, rol);
        if (nuevo != null) {
            System.out.println("Usuario registrado exitosamente.");
        } else {
            System.out.println("Error al registrar usuario.");
        }
    }

    private static Usuario iniciarSesion() {
        System.out.println("\n--- Inicio de Sesion ---");
        System.out.print("Correo: ");
        String correo = scanner.nextLine();
        System.out.print("Contrasena: ");
        String contrasena = scanner.nextLine();

        Usuario usuario = controladorUsuario.login(correo, contrasena);
        if (usuario != null) {
            System.out.println("Bienvenido/a " + usuario.getNombreUsuario() + " (" + usuario.getRolUsuario() + ")");
        } else {
            System.out.println("Credenciales incorrectas.");
        }
        return usuario;
    }

    private static void mostrarMenuPrincipal(Usuario usuario) {
        boolean cerrarSesion = false;

        while (!cerrarSesion) {
            System.out.println("\n--- Menu Principal del Sistema ---");
            System.out.println("1. Gestion de Patrones");
            System.out.println("2. Gestion de Puntos");
            System.out.println("3. Gestion de Materiales");
            System.out.println("4. Cerrar sesion");
            System.out.print("Seleccione una opcion: ");
            String opcion = scanner.nextLine();

            switch (opcion) {
                case "1" -> System.out.println("Funcionalidad de patrones (pendiente)");
                case "2" -> System.out.println("Funcionalidad de puntos (pendiente)");
                case "3" -> {
                    if (usuario.getRolUsuario().equalsIgnoreCase("administrador")) {
                        System.out.println("Funcionalidad de materiales (pendiente)");
                    } else {
                        System.out.println("Acceso denegado. Solo los administradores pueden gestionar materiales.");
                    }
                }
                case "4" -> {
                    System.out.println("Cerrando sesion...");
                    cerrarSesion = true;
                }
                default -> System.out.println("Opcion invalida. Intente nuevamente.");
            }
        }
    }
}
