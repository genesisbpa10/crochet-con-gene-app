package controlador;

import modelo.Material;
import persistencia.RepositorioMaterial;

import java.util.List;

public class ControladorMaterial {
    private RepositorioMaterial repositorio;

    public ControladorMaterial() {
        this.repositorio = new RepositorioMaterial();
    }

    public void registrarMaterial(Material material) {
        repositorio.guardar(material);
    }

    public List<Material> obtenerMateriales() {
        return repositorio.listarTodos();
    }

    public Material buscarPorId(int id) {
        return repositorio.buscarPorId(id);
    }

    public void eliminarMaterial(int id) {
        repositorio.eliminar(id);
    }
}
