package modelo;

import java.util.HashMap;
import java.util.Map;

public class Patron {
    private String nombre;
    private String descripcion;
    private String tipoPrenda;
    private Map<Punto, Integer> composicionPuntos;

    public Patron(String nombre, String descripcion, String tipoPrenda) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.tipoPrenda = tipoPrenda;
        this.composicionPuntos = new HashMap<>();
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getTipoPrenda() {
        return tipoPrenda;
    }

    public Map<Punto, Integer> getComposicionPuntos() {
        return composicionPuntos;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setTipoPrenda(String tipoPrenda) {
        this.tipoPrenda = tipoPrenda;
    }

    public void agregarPunto(Punto punto, int cantidad) {
        this.composicionPuntos.put(punto, cantidad);
    }
}
