package vista;

import controlador.ControladorPunto;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import modelo.Punto;
import modelo.Usuario;

public class VentanaRegistrarPunto {

    private final ControladorPunto controlador = new ControladorPunto();
    private final Usuario usuarioLogueado;

    public VentanaRegistrarPunto(Usuario usuario) {
        this.usuarioLogueado = usuario;
    }

    public void mostrarVentana() {
        Stage stage = new Stage();

        Label nombreLabel = new Label("Nombre del punto:");
        TextField nombreField = new TextField();

        Label descripcionLabel = new Label("Descripción:");
        TextArea descripcionArea = new TextArea();
        descripcionArea.setPrefRowCount(3);

        Label caracteristicasLabel = new Label("Características:");
        TextArea caracteristicasArea = new TextArea();
        caracteristicasArea.setPrefRowCount(3);

        Label pesoLabel = new Label("Peso (gr):");
        TextField pesoField = new TextField();

        Button registrarButton = new Button("Registrar Punto");
        Label resultado = new Label();

        Button cerrarButton = new Button("Cerrar");

        registrarButton.setOnAction(e -> {
            String nombre = nombreField.getText().trim();
            String descripcion = descripcionArea.getText().trim();
            String caracteristicas = caracteristicasArea.getText().trim();
            String peso = pesoField.getText().trim();

            if (nombre.isEmpty() || descripcion.isEmpty() || caracteristicas.isEmpty() || peso.isEmpty()) {
                resultado.setText("Por favor, complete todos los campos.");
                return;
            }

            try {
                // Validación simple de que peso es numérico
                Double.parseDouble(peso);

                Punto punto = new Punto(nombre, descripcion, caracteristicas, peso);
                controlador.registrarPunto(punto, usuarioLogueado.getIdUsuario());
                resultado.setText("Punto registrado exitosamente.");

                // Opcional: limpiar campos
                nombreField.clear();
                descripcionArea.clear();
                caracteristicasArea.clear();
                pesoField.clear();
            } catch (NumberFormatException ex) {
                resultado.setText("Peso inválido. Ingrese un número.");
            } catch (Exception ex) {
                ex.printStackTrace();
                resultado.setText("Error al registrar el punto.");
            }
        });

        cerrarButton.setOnAction(e -> stage.close());

        VBox layout = new VBox(10,
            nombreLabel, nombreField,
            descripcionLabel, descripcionArea,
            caracteristicasLabel, caracteristicasArea,
            pesoLabel, pesoField,
            registrarButton, resultado, cerrarButton
        );
        layout.setPadding(new Insets(20));

        Scene scene = new Scene(layout, 400, 500);
        stage.setScene(scene);
        stage.setTitle("Registrar Punto de Crochet");
        stage.show();
    }
}
