package controlador;

import modelo.Patron;
import persistencia.RepositorioPatron;
import java.util.List;

public class ControladorPatron {
    private RepositorioPatron repositorio;

    public ControladorPatron() {
        this.repositorio = new RepositorioPatron();
    }

    public void registrarPatron(Patron patron) {
        repositorio.guardar(patron);
    }

    public List<Patron> obtenerPatrones() {
        return repositorio.listarTodos();
    }

    public Patron buscarPorNombre(String nombre) {
        return repositorio.buscarPorNombre(nombre);
    }

    public void eliminarPatronPorId(int id) {
        repositorio.eliminar(id);
    }
}
