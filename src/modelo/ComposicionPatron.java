package modelo;

import java.util.Map;

public class ComposicionPatron {
    private Punto punto;
    private int cantidad; // cuantas veces se repite ese punto
    private Map<Material, Double> materialesUsados; // material y gramos

    public ComposicionPatron(Punto punto, int cantidad, Map<Material, Double> materialesUsados) {
        this.punto = punto;
        this.cantidad = cantidad;
        this.materialesUsados = materialesUsados;
    }

    public Punto getPunto() {
        return punto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public Map<Material, Double> getMaterialesUsados() {
        return materialesUsados;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
