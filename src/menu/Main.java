package menu;

import modelo.Material;
import modelo.Punto;
import modelo.Patron;
import modelo.ComposicionPatron;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        // Crear materiales
        Material lana = new Material("Lana Merino", "Gris", 200.0);
        Material algodon = new Material("Algodón", "Blanco", 150.0);

        // Crear punto
        Punto puntoVareta = new Punto("Punto Vareta", "Punto básico alto", "Estilo suelto y abierto", "3.5");

        // Asociar materiales al punto (en este patrón)
        Map<Material, Double> materialesParaVareta = new HashMap<>();
        materialesParaVareta.put(lana, 20.0); // 20g de lana
        materialesParaVareta.put(algodon, 10.0); // 10g de algodón

        // Crear la composición del patrón (punto + cantidad + materiales)
        ComposicionPatron compVareta = new ComposicionPatron(puntoVareta, 5, materialesParaVareta);

        // Crear patrón
        Patron bufanda = new Patron("Bufanda de Invierno", "Diseño grueso para clima frío", "Accesorio");

        // Agregar la composición al patrón
        bufanda.agregarComposicion(compVareta);

        // Mostrar información del patrón
        System.out.println("Nombre del Patrón: " + bufanda.getNombrePatron());
        System.out.println("Descripción: " + bufanda.getDescripcionPatron());
        System.out.println("Tipo: " + bufanda.getTipoPatron());
        System.out.println("Composición:");

        for (ComposicionPatron comp : bufanda.getComposicion()) {
            System.out.println("- Punto: " + comp.getPunto().getNombrePunto());
            System.out.println("  Cantidad: " + comp.getCantidad());
            System.out.println("  Materiales usados:");
            for (Map.Entry<Material, Double> entry : comp.getMaterialesUsados().entrySet()) {
                Material mat = entry.getKey();
                double gramos = entry.getValue();
                System.out.println("    • " + mat.getNombreMaterial() + " (" + mat.getColorMaterial() + "): " + gramos + "g");
            }
        }
    }
}
