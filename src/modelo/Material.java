package modelo;

public class Material {
    private int idMaterial;
    private String nombreMaterial;
    private String colorMaterial;
    private double pesoMaterial;

    // Constructor sin ID (para nuevos materiales antes de ser guardados)
    public Material(String nombreMaterial, String colorMaterial, double pesoMaterial) {
        this.nombreMaterial = nombreMaterial;
        this.colorMaterial = colorMaterial;
        this.pesoMaterial = pesoMaterial;
    }

    // Constructor con ID (para materiales que ya existen en la base de datos)
    public Material(int idMaterial, String nombreMaterial, String colorMaterial, double pesoMaterial) {
        this.idMaterial = idMaterial;
        this.nombreMaterial = nombreMaterial;
        this.colorMaterial = colorMaterial;
        this.pesoMaterial = pesoMaterial;
    }

    public int getIdMaterial() {
        return idMaterial;
    }

    public void setIdMaterial(int idMaterial) {
        this.idMaterial = idMaterial;
    }

    public String getNombreMaterial() {
        return nombreMaterial;
    }

    public void setNombreMaterial(String nombreMaterial) {
        this.nombreMaterial = nombreMaterial;
    }

    public String getColorMaterial() {
        return colorMaterial;
    }

    public void setColorMaterial(String colorMaterial) {
        this.colorMaterial = colorMaterial;
    }

    public double getPesoMaterial() {
        return pesoMaterial;
    }

    public void setPesoMaterial(double pesoMaterial) {
        this.pesoMaterial = pesoMaterial;
    }
}
