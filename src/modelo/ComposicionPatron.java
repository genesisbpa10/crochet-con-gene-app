package modelo;

/**
 * Representa la relación entre un Patrón y un Punto, indicando cuántas veces se usa ese punto en el patrón.
 * Compatible con la tabla Patron_Punto de la base de datos.
 */
public class ComposicionPatron {
    private Punto punto;
    private int cantidad;

    /**
     * Constructor principal.
     * @param punto Punto utilizado en el patrón.
     * @param cantidad Cantidad de veces que se usa el punto en el patrón.
     */
    public ComposicionPatron(Punto punto, int cantidad) {
        this.punto = punto;
        this.cantidad = cantidad;
    }

    public Punto getPunto() {
        return punto;
    }

    public void setPunto(Punto punto) {
        this.punto = punto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return punto.getNombrePunto() + " x" + cantidad;
    }
}