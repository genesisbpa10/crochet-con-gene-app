package controlador;

import modelo.Material;
import persistencia.RepositorioMaterial;
import java.util.List;

public class ControladorMaterial {
    private RepositorioMaterial repositorio;

    public ControladorMaterial() {
        this.repositorio = new RepositorioMaterial();
    }

    public void registrarMaterial(String nombre, String color, String tipo, double peso, int idUsuario) {
        Material material = new Material(nombre, color, tipo, peso, idUsuario);
        repositorio.guardar(material);
    }

    public Material buscarPorId(int id) {
        return repositorio.buscarPorId(id);
    }

    public void eliminarMaterial(int id) {
        repositorio.eliminar(id);
    }

    // NUEVO: Obtener todos los materiales de un usuario
    public List<Material> obtenerMateriales(int idUsuario) {
        return repositorio.obtenerMaterialesPorUsuario(idUsuario);
    }

    // NUEVO: Modificar un material existente
    public void modificarMaterial(int idMaterial, String nombre, String color, String tipo, double peso) {
        Material material = repositorio.buscarPorId(idMaterial);
        if (material != null) {
            material.setNombreMaterial(nombre);
            material.setColorMaterial(color);
            material.setTipoMaterial(tipo);
            material.setPesoMaterial(peso);
            repositorio.actualizar(material);
        }
    }
}