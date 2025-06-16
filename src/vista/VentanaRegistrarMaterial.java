package vista;

import controlador.ControladorMaterial;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import modelo.Usuario;

public class VentanaRegistrarMaterial {

    private final ControladorMaterial controlador = new ControladorMaterial();
    private final Usuario usuarioLogueado;

    public VentanaRegistrarMaterial(Usuario usuario) {
        this.usuarioLogueado = usuario;
    }

    public void mostrarVentana() {
        Stage stage = new Stage();

        Label nombreLabel = new Label("Nombre:");
        TextField nombreField = new TextField();

        Label colorLabel = new Label("Color:");
        TextField colorField = new TextField();

        Label tipoLabel = new Label("Tipo:");
        TextField tipoField = new TextField();

        Label pesoLabel = new Label("Peso por metro:");
        TextField pesoField = new TextField();

        Button registrarButton = new Button("Registrar Material");
        Label resultado = new Label();

        Button volverButton = new Button("Volver");

        registrarButton.setOnAction(e -> {
            try {
                String nombre = nombreField.getText();
                String color = colorField.getText();
                String tipo = tipoField.getText();
                double peso = Double.parseDouble(pesoField.getText());

                controlador.registrarMaterial(nombre, color, tipo, peso, usuarioLogueado.getIdUsuario());
                resultado.setText("Material registrado exitosamente.");
            } catch (NumberFormatException ex) {
                resultado.setText("Peso inválido. Ingrese un número.");
            }
        });

        volverButton.setOnAction(e -> {
            try {
                new VentanaPrincipal(usuarioLogueado).start(new Stage());
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            stage.close();
        });

        VBox layout = new VBox(10, nombreLabel, nombreField, colorLabel, colorField, tipoLabel, tipoField, pesoLabel, pesoField, registrarButton, resultado, volverButton);
        layout.setPadding(new Insets(20));

        Scene scene = new Scene(layout, 300, 400);
        stage.setScene(scene);
        stage.setTitle("Registrar Material");
        stage.show();
    }
}
