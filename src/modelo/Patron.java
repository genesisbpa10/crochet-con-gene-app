package modelo;

import java.util.ArrayList;
import java.util.List;

public class Patron {
    private int idPatron;
    private String nombrePatron;
    private String descripcionPatron;
    private String tipoPatron;
    private List<ComposicionPatron> composicion; // Lista de puntos con sus materiales

    public Patron(String nombrePatron, String descripcionPatron, String tipoPatron) {
        this.nombrePatron = nombrePatron;
        this.descripcionPatron = descripcionPatron;
        this.tipoPatron = tipoPatron;
        this.composicion = new ArrayList<>();
    }

    public Patron(int idPatron, String nombrePatron, String descripcionPatron, String tipoPatron) {
        this(nombrePatron, descripcionPatron, tipoPatron);
        this.idPatron = idPatron;
    }

    public void agregarComposicion(ComposicionPatron cp) {
        this.composicion.add(cp);
    }

    public List<ComposicionPatron> getComposicion() {
        return composicion;
    }

    // Getters y setters restantes

    public int getIdPatron() {
        return idPatron;
    }

    public void setIdPatron(int idPatron) {
        this.idPatron = idPatron;
    }

    public String getNombrePatron() {
        return nombrePatron;
    }

    public void setNombrePatron(String nombrePatron) {
        this.nombrePatron = nombrePatron;
    }

    public String getDescripcionPatron() {
        return descripcionPatron;
    }

    public void setDescripcionPatron(String descripcionPatron) {
        this.descripcionPatron = descripcionPatron;
    }

    public String getTipoPatron() {
        return tipoPatron;
    }

    public void setTipoPatron(String tipoPatron) {
        this.tipoPatron = tipoPatron;
    }
}
