package modelo;

public class Usuario {
    private String nombre;
    private String correo;
    private String contrasena;
    private String tipoUsuario; // "Administrador" o "Estandar"

    public Usuario(String nombre, String correo, String contrasena, String tipoUsuario) {
        this.nombre = nombre;
        this.correo = correo;
        this.contrasena = contrasena;
        this.tipoUsuario = tipoUsuario;
    }  

    public String getNombre() {
        return nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public String getcontrasena() {
        return contrasena;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setcontrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }
}
