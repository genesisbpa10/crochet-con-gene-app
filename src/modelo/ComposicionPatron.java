package modelo;

import java.util.Map;
import java.util.HashMap;

public class ComposicionPatron {
    private Punto punto;
    private int cantidad;                          // cuántas veces se repite ese punto
    private Map<Material, Double> materialesUsados; // material y gramos

    /** Constructor principal */
    public ComposicionPatron(Punto punto, int cantidad, Map<Material, Double> materialesUsados) {
        this.punto = punto;
        this.cantidad = cantidad;
        this.materialesUsados = materialesUsados;
    }

    /** Sobrecarga para crear una composición sin materiales definidos */
    public ComposicionPatron(Punto punto, int cantidad) {
        this(punto, cantidad, new HashMap<>());
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
