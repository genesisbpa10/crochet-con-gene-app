package modelo;

public class Punto {
    private String nombrePunto;
    private String descripcionPunto;
    private String caracteristicasPunto;
    private String pesoPunto;

    public Punto(String nombrePunto, String descripcionPunto, String caracteristicasPunto, String pesoPunto) {
        this.nombrePunto = nombrePunto;
        this.descripcionPunto = descripcionPunto;
        this.caracteristicasPunto = caracteristicasPunto;
        this.pesoPunto = pesoPunto;
    }

    public String getNombrePunto() {
        return nombrePunto;
    }

    public void setNombrePunto(String nombrePunto) {
        this.nombrePunto = nombrePunto;
    }

    public String descripcionPunto() {
        return descripcionPunto;
    }

    public void setDescripcionPunto(String descripcionPunto) {
        this.descripcionPunto = descripcionPunto;
    }

    public String caracteristicasPunto() {
        return caracteristicasPunto;
    }

    public void setCaracteristicasPunto(String caracteristicasPunto) {
        this.caracteristicasPunto = caracteristicasPunto;
    }
    public String pesoPunto() {
        return pesoPunto;
    }
    public void setPesoPunto(String pesoPunto) {
        this.pesoPunto = pesoPunto;
    }

}
