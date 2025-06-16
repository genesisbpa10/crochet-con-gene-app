package controlador;

import modelo.Punto;
import persistencia.RepositorioPunto;

import java.util.List;

public class ControladorPunto {
    private RepositorioPunto repositorio;

    public ControladorPunto() {
        this.repositorio = new RepositorioPunto();
    }

    public void registrarPunto(Punto punto) {
        repositorio.guardar(punto);
    }

    public List<Punto> obtenerPuntos() {
        return repositorio.listarTodos();
    }

    public Punto buscarPorNombre(String nombre) {
        return repositorio.buscarPorNombre(nombre);
    }

    public void eliminarPunto(int id) {
        repositorio.eliminar(id);
    }
}
