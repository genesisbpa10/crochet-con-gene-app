package modelo;

public class Punto {
    private int idPunto;
    private String nombrePunto;
    private String descripcionPunto;
    private String caracteristicasPunto;
    private String pesoPunto;

    // Constructor con id (para cargar desde la BD)
    public Punto(int idPunto, String nombrePunto, String descripcionPunto, String caracteristicasPunto, String pesoPunto) {
        this.idPunto = idPunto;
        this.nombrePunto = nombrePunto;
        this.descripcionPunto = descripcionPunto;
        this.caracteristicasPunto = caracteristicasPunto;
        this.pesoPunto = pesoPunto;
    }

    // Constructor sin id (para crear nuevos puntos)
    public Punto(String nombrePunto, String descripcionPunto, String caracteristicasPunto, String pesoPunto) {
        this.nombrePunto = nombrePunto;
        this.descripcionPunto = descripcionPunto;
        this.caracteristicasPunto = caracteristicasPunto;
        this.pesoPunto = pesoPunto;
    }

    public int getIdPunto() {
        return idPunto;
    }

    public void setIdPunto(int idPunto) {
        this.idPunto = idPunto;
    }

    public String getNombrePunto() {
        return nombrePunto;
    }

    public void setNombrePunto(String nombrePunto) {
        this.nombrePunto = nombrePunto;
    }

    public String getDescripcionPunto() {
        return descripcionPunto;
    }

    public void setDescripcionPunto(String descripcionPunto) {
        this.descripcionPunto = descripcionPunto;
    }

    public String getCaracteristicasPunto() {
        return caracteristicasPunto;
    }

    public void setCaracteristicasPunto(String caracteristicasPunto) {
        this.caracteristicasPunto = caracteristicasPunto;
    }

    public String getPesoPunto() {
        return pesoPunto;
    }

    public void setPesoPunto(String pesoPunto) {
        this.pesoPunto = pesoPunto;
    }
}