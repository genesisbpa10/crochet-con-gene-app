package modelo;

public class Material {
    private int idMaterial;
    private String nombreMaterial;
    private String colorMaterial;
    private String tipoMaterial;
    private double pesoMaterial;
    private int idUsuario; // FK al usuario que registra

    public Material(String nombreMaterial, String colorMaterial, String tipoMaterial, double pesoMaterial, int idUsuario) {
        this.nombreMaterial = nombreMaterial;
        this.colorMaterial = colorMaterial;
        this.tipoMaterial = tipoMaterial;
        this.pesoMaterial = pesoMaterial;
        this.idUsuario = idUsuario;
    }

    public Material(int idMaterial, String nombreMaterial, String colorMaterial, String tipoMaterial, double pesoMaterial, int idUsuario) {
        this.idMaterial = idMaterial;
        this.nombreMaterial = nombreMaterial;
        this.tipoMaterial = tipoMaterial;
        this.colorMaterial = colorMaterial;
        this.pesoMaterial = pesoMaterial;
        this.idUsuario = idUsuario;
    }

    // Getters y setters
    public int getIdMaterial() { return idMaterial; }
    public void setIdMaterial(int idMaterial) { this.idMaterial = idMaterial; }

    public String getTipoMaterial() { return tipoMaterial; }
    public void setTipoMaterial(String tipoMaterial) { this.tipoMaterial = tipoMaterial; }

    public String getNombreMaterial() { return nombreMaterial; }
    public void setNombreMaterial(String nombreMaterial) { this.nombreMaterial = nombreMaterial; }

    public String getColorMaterial() { return colorMaterial; }
    public void setColorMaterial(String colorMaterial) { this.colorMaterial = colorMaterial; }

    public double getPesoMaterial() { return pesoMaterial; }
    public void setPesoMaterial(double pesoMaterial) { this.pesoMaterial = pesoMaterial; }

    public int getIdUsuario() { return idUsuario; }
    public void setIdUsuario(int idUsuario) { this.idUsuario = idUsuario; }
}
