package vista;

import controlador.ControladorMaterial;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import modelo.Material;
import modelo.Usuario;

public class VentanaMateriales {

    private final ControladorMaterial controlador = new ControladorMaterial();
    private final Usuario usuarioLogueado;
    private final ObservableList<Material> materiales = FXCollections.observableArrayList();

    public VentanaMateriales(Usuario usuario) {
        this.usuarioLogueado = usuario;
    }

    public void mostrarVentana() {
        Stage stage = new Stage();

        TableView<Material> tabla = new TableView<>(materiales);
        TableColumn<Material, String> nombreCol = new TableColumn<>("Nombre");
        nombreCol.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getNombreMaterial()));
        TableColumn<Material, String> colorCol = new TableColumn<>("Color");
        colorCol.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getColorMaterial()));
        TableColumn<Material, String> tipoCol = new TableColumn<>("Tipo");
        tipoCol.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getTipoMaterial()));
        TableColumn<Material, Double> pesoCol = new TableColumn<>("Peso");
        pesoCol.setCellValueFactory(data -> new javafx.beans.property.SimpleObjectProperty<>(data.getValue().getPesoMaterial()));
        tabla.getColumns().addAll(nombreCol, colorCol, tipoCol, pesoCol);

        Label nombreLabel = new Label("Nombre:");
        TextField nombreField = new TextField();
        Label colorLabel = new Label("Color:");
        TextField colorField = new TextField();
        Label tipoLabel = new Label("Tipo:");
        TextField tipoField = new TextField();
        Label pesoLabel = new Label("Peso por metro:");
        TextField pesoField = new TextField();

        Button registrarButton = new Button("Registrar");
        Button modificarButton = new Button("Modificar");
        Button eliminarButton = new Button("Eliminar");
        Button limpiarButton = new Button("Limpiar");
        Button volverButton = new Button("Volver");
        Label resultado = new Label();

        // Cargar materiales existentes
        materiales.setAll(controlador.obtenerMateriales(usuarioLogueado.getIdUsuario()));

        // Selección en la tabla
        tabla.getSelectionModel().selectedItemProperty().addListener((obs, oldSel, newSel) -> {
            if (newSel != null) {
                nombreField.setText(newSel.getNombreMaterial());
                colorField.setText(newSel.getColorMaterial());
                tipoField.setText(newSel.getTipoMaterial());
                pesoField.setText(String.valueOf(newSel.getPesoMaterial()));
            }
        });

        registrarButton.setOnAction(e -> {
            try {
                String nombre = nombreField.getText();
                String color = colorField.getText();
                String tipo = tipoField.getText();
                double peso = Double.parseDouble(pesoField.getText());
                controlador.registrarMaterial(nombre, color, tipo, peso, usuarioLogueado.getIdUsuario());
                resultado.setText("Material registrado exitosamente.");
                materiales.setAll(controlador.obtenerMateriales(usuarioLogueado.getIdUsuario()));
                limpiarCampos(nombreField, colorField, tipoField, pesoField);
            } catch (NumberFormatException ex) {
                resultado.setText("Peso inválido. Ingrese un número.");
            }
        });

        modificarButton.setOnAction(e -> {
            Material seleccionado = tabla.getSelectionModel().getSelectedItem();
            if (seleccionado != null) {
                try {
                    String nombre = nombreField.getText();
                                     String color = colorField.getText();
                    String tipo = tipoField.getText();
                    double peso = Double.parseDouble(pesoField.getText());
                    controlador.modificarMaterial(seleccionado.getIdMaterial(), nombre, color, tipo, peso);
                    resultado.setText("Material modificado.");
                    materiales.setAll(controlador.obtenerMateriales(usuarioLogueado.getIdUsuario()));
                    limpiarCampos(nombreField, colorField, tipoField, pesoField);
                } catch (NumberFormatException ex) {
                    resultado.setText("Peso inválido.");
                }
            }
        });

        eliminarButton.setOnAction(e -> {
            Material seleccionado = tabla.getSelectionModel().getSelectedItem();
            if (seleccionado != null) {
                controlador.eliminarMaterial(seleccionado.getIdMaterial());
                resultado.setText("Material eliminado.");
                materiales.setAll(controlador.obtenerMateriales(usuarioLogueado.getIdUsuario()));
                limpiarCampos(nombreField, colorField, tipoField, pesoField);
            }
        });

        limpiarButton.setOnAction(e -> limpiarCampos(nombreField, colorField, tipoField, pesoField));

        volverButton.setOnAction(e -> {
            try {
                new VentanaPrincipal(usuarioLogueado).start(new Stage());
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            stage.close();
        });

        VBox layout = new VBox(10, tabla, nombreLabel, nombreField, colorLabel, colorField, tipoLabel, tipoField, pesoLabel, pesoField, registrarButton, modificarButton, eliminarButton, limpiarButton, resultado, volverButton);
        layout.setPadding(new Insets(20));

        Scene scene = new Scene(layout, 500, 600);
        stage.setScene(scene);
        stage.setTitle("Materiales");
        stage.show();
    }
        private static void limpiarCampos(TextField nombre, TextField color, TextField tipo, TextField peso) {
        nombre.clear();
        color.clear();
        tipo.clear();
        peso.clear();
    }
}
