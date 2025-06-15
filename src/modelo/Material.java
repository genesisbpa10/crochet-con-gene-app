package modelo;

public class Material {
    private String tipo; // lana, hilo, algodón, etc.
    private String color;
    private double pesoPorMetro;

    public Material(String tipo, String color, double pesoPorMetro) {
        this.tipo = tipo;
        this.color = color;
        this.pesoPorMetro = pesoPorMetro;
    }

    public String getTipo() {
        return tipo;
    }

    public String getColor() {
        return color;
    }

    public double getPesoPorMetro() {
        return pesoPorMetro;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setPesoPorMetro(double pesoPorMetro) {
        this.pesoPorMetro = pesoPorMetro;
    }
}
