package controlador;

import modelo.Punto;
import persistencia.RepositorioPunto;

import java.util.List;

public class ControladorPunto {
    private RepositorioPunto repositorio;

    public ControladorPunto() {
        this.repositorio = new RepositorioPunto();
    }

    public void registrarPunto(Punto punto, int idUsuario) {
        repositorio.guardar(punto, idUsuario);
    }

    // NUEVO: Listar puntos por usuario
    public List<Punto> obtenerPuntos(int idUsuario) {
        return repositorio.obtenerPuntosPorUsuario(idUsuario);
    }

    public Punto buscarPorNombre(String nombre) {
        return repositorio.buscarPorNombre(nombre);
    }

    public void eliminarPunto(int id) {
        repositorio.eliminar(id);
    }

    // NUEVO: Modificar punto
    public void modificarPunto(int idPunto, String nombre, String descripcion, String caracteristicas, String peso) {
        Punto punto = repositorio.buscarPorId(idPunto);
        if (punto != null) {
            punto.setNombrePunto(nombre);
            punto.setDescripcionPunto(descripcion);
            punto.setCaracteristicasPunto(caracteristicas);
            punto.setPesoPunto(peso);
            repositorio.actualizar(punto, idPunto);
        }
    }
}