package controlador;

import modelo.Usuario;
import modelo.UsuarioAdministrador;
import modelo.UsuarioEstandar;
import persistencia.RepositorioUsuario;

public class ControladorUsuario {
    private RepositorioUsuario repositorio;

    public ControladorUsuario() {
        this.repositorio = new RepositorioUsuario();
    }

    public Usuario autenticar(String correo, String contrasena) {
        Usuario usuario = repositorio.buscarPorCorreo(correo);
        if (usuario != null && usuario.getContrasenaUsuario().equals(contrasena)) {
            return usuario;
        }
        return null;
    }

    public Usuario registrarUsuario(String nombre, String correo, String contrasena, String rol) {
        Usuario nuevo;
        if (rol.equalsIgnoreCase("administrador")) {
            nuevo = new UsuarioAdministrador(nombre, correo, contrasena);
        } else {
            nuevo = new UsuarioEstandar(nombre, correo, contrasena);
        }
        repositorio.guardar(nuevo);
        return nuevo;
    }

    public Usuario login(String correo, String contrasena) {
        return autenticar(correo, contrasena);
    }
}
