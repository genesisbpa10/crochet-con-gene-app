package modelo;

import java.util.List;

public class Patron {
    private int idPatron;
    private String nombre;
    private String descripcion;
    private String tipoPatron;
    private int idUsuario;
    private List<ComposicionPatron> composicion;

    // Constructor para creación (sin idPatron aún)
    public Patron(String nombre, String descripcion, String tipoPatron, int idUsuario) {
        this.nombre      = nombre;
        this.descripcion = descripcion;
        this.tipoPatron  = tipoPatron;
        this.idUsuario   = idUsuario;
    }

    // Constructor completo (para leer de BD)
    public Patron(int idPatron, String nombre, String descripcion, String tipoPatron, int idUsuario) {
        this.idPatron    = idPatron;
        this.nombre      = nombre;
        this.descripcion = descripcion;
        this.tipoPatron  = tipoPatron;
        this.idUsuario   = idUsuario;
    }

    // Getters
    public int getIdPatron()       { return idPatron; }
    public String getNombre()      { return nombre; }
    public String getDescripcion() { return descripcion; }
    public String getTipoPatron()  { return tipoPatron; }
    public int getIdUsuario()      { return idUsuario; }
    public List<ComposicionPatron> getComposicion() { return composicion; }

    // Setters (el idPatron normalmente no se cambia)
    public void setNombre(String nombre)           { this.nombre = nombre; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    public void setTipoPatron(String tipoPatron)   { this.tipoPatron = tipoPatron; }
    public void setComposicion(List<ComposicionPatron> composicion) {
        this.composicion = composicion;
    }
    // Opcional:
    // public void setIdUsuario(int idUsuario) { this.idUsuario = idUsuario; }
}
