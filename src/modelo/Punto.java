package modelo;

public class Punto {
    private String nombre;
    private String instrucciones;
    private String representacionSimbolica;
    private Material material;

    public Punto(String nombre, String instrucciones, String representacionSimbolica, Material material) {
        this.nombre = nombre;
        this.instrucciones = instrucciones;
        this.representacionSimbolica = representacionSimbolica;
        this.material = material;
    }

    public String getNombre() {
        return nombre;
    }

    public String getInstrucciones() {
        return instrucciones;
    }

    public String getRepresentacionSimbolica() {
        return representacionSimbolica;
    }

    public Material getMaterial() {
        return material;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setInstrucciones(String instrucciones) {
        this.instrucciones = instrucciones;
    }

    public void setRepresentacionSimbolica(String representacionSimbolica) {
        this.representacionSimbolica = representacionSimbolica;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }
}
