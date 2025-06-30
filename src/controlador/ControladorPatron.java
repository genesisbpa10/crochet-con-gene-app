package controlador;

import modelo.Patron;
import modelo.ComposicionPatron;
import persistencia.RepositorioPatron;

import java.util.List;

public class ControladorPatron {
    private final RepositorioPatron repositorio;

    public ControladorPatron() {
        this.repositorio = new RepositorioPatron();
    }

    /** Inserta un objeto Patron ya construido */
    public void registrarPatron(Patron patron) {
        repositorio.guardar(patron);
    }

    /**
     * Construye e inserta un Patron a partir de sus datos, el id de usuario y la lista de composiciones
     */
    public void registrarPatron(String nombre,
                                String descripcion,
                                String tipoPatron,
                                int idUsuario,
                                List<ComposicionPatron> composicion) {
        // Usa el constructor que recibe el idUsuario
        Patron patron = new Patron(nombre, descripcion, tipoPatron, idUsuario);
        // y luego asigna la lista de composiciones
        patron.setComposicion(composicion);
        repositorio.guardar(patron);
    }

    public List<Patron> obtenerPatrones() {
        return repositorio.listarTodos();
    }

    public Patron buscarPorNombre(String nombre) {
        return repositorio.buscarPorNombre(nombre);
    }

    public Patron buscarPorId(int id) {
        return repositorio.buscarPorId(id);
    }

    public void actualizarPatron(Patron patron) {
        repositorio.actualizar(patron);
    }

    public void eliminarPatronPorId(int id) {
        repositorio.eliminar(id);
    }
}
