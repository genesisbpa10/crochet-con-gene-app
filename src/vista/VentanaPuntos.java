package vista;

import controlador.ControladorPunto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import modelo.Punto;
import modelo.Usuario;

public class VentanaPuntos {

    private final ControladorPunto controlador = new ControladorPunto();
    private final Usuario usuarioLogueado;
    private final ObservableList<Punto> puntos = FXCollections.observableArrayList();

    public VentanaPuntos(Usuario usuario) {
        this.usuarioLogueado = usuario;
    }

    public void mostrarVentana() {
        Stage stage = new Stage();

        TableView<Punto> tabla = new TableView<>(puntos);
        TableColumn<Punto, String> nombreCol = new TableColumn<>("Nombre");
        nombreCol.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getNombrePunto()));
        TableColumn<Punto, String> descCol = new TableColumn<>("Descripción");
        descCol.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getDescripcionPunto()));
        TableColumn<Punto, String> caracCol = new TableColumn<>("Características");
        caracCol.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getCaracteristicasPunto()));
        TableColumn<Punto, Double> pesoCol = new TableColumn<>("Peso (gr)");
        pesoCol.setCellValueFactory(data -> new javafx.beans.property.SimpleObjectProperty<>(Double.parseDouble(data.getValue().getPesoPunto())));
        tabla.getColumns().addAll(nombreCol, descCol, caracCol, pesoCol);

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
        Button modificarButton = new Button("Modificar");
        Button eliminarButton = new Button("Eliminar");
        Button limpiarButton = new Button("Limpiar");
        Button cerrarButton = new Button("Cerrar");
        Label resultado = new Label();

        // Cargar puntos existentes
        puntos.setAll(controlador.obtenerPuntos(usuarioLogueado.getIdUsuario()));

        // Selección en la tabla
        tabla.getSelectionModel().selectedItemProperty().addListener((obs, oldSel, newSel) -> {
            if (newSel != null) {
                nombreField.setText(newSel.getNombrePunto());
                descripcionArea.setText(newSel.getDescripcionPunto());
                caracteristicasArea.setText(newSel.getCaracteristicasPunto());
                pesoField.setText(newSel.getPesoPunto());
            }
        });

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
                Double.parseDouble(peso);
                Punto punto = new Punto(nombre, descripcion, caracteristicas, peso);
                controlador.registrarPunto(punto, usuarioLogueado.getIdUsuario());
                resultado.setText("Punto registrado exitosamente.");
                puntos.setAll(controlador.obtenerPuntos(usuarioLogueado.getIdUsuario()));
                limpiarCampos(nombreField, descripcionArea, caracteristicasArea, pesoField);
            } catch (NumberFormatException ex) {
                resultado.setText("Peso inválido. Ingrese un número.");
            } catch (Exception ex) {
                ex.printStackTrace();
                resultado.setText("Error al registrar el punto.");
            }
        });

        modificarButton.setOnAction(e -> {
            Punto seleccionado = tabla.getSelectionModel().getSelectedItem();
            if (seleccionado != null) {
                try {
                    String nombre = nombreField.getText().trim();
                    String descripcion = descripcionArea.getText().trim();
                    String caracteristicas = caracteristicasArea.getText().trim();
                    String peso = pesoField.getText().trim();
                    Double.parseDouble(peso);
                    controlador.modificarPunto(seleccionado.getIdPunto(), nombre, descripcion, caracteristicas, peso);
                    resultado.setText("Punto modificado.");
                    puntos.setAll(controlador.obtenerPuntos(usuarioLogueado.getIdUsuario()));
                    limpiarCampos(nombreField, descripcionArea, caracteristicasArea, pesoField);
                } catch (NumberFormatException ex) {
                    resultado.setText("Peso inválido.");
                }
            }
        });

        eliminarButton.setOnAction(e -> {
            Punto seleccionado = tabla.getSelectionModel().getSelectedItem();
            if (seleccionado != null) {
                controlador.eliminarPunto(seleccionado.getIdPunto());
                resultado.setText("Punto eliminado.");
                puntos.setAll(controlador.obtenerPuntos(usuarioLogueado.getIdUsuario()));
                limpiarCampos(nombreField, descripcionArea, caracteristicasArea, pesoField);
            }
        });

        limpiarButton.setOnAction(e -> limpiarCampos(nombreField, descripcionArea, caracteristicasArea, pesoField));
        cerrarButton.setOnAction(e -> stage.close());

        VBox layout = new VBox(10,
            tabla,
            nombreLabel, nombreField,
            descripcionLabel, descripcionArea,
            caracteristicasLabel, caracteristicasArea,
            pesoLabel, pesoField,
            registrarButton, modificarButton, eliminarButton, limpiarButton, resultado, cerrarButton
        );
        layout.setPadding(new Insets(20));

        Scene scene = new Scene(layout, 700, 600);
        stage.setScene(scene);
        stage.setTitle("Gestión de Puntos de Crochet");
        stage.show();
    }

    private static void limpiarCampos(TextField nombre, TextArea descripcion, TextArea caracteristicas, TextField peso) {
        nombre.clear();
        descripcion.clear();
        caracteristicas.clear();
        peso.clear();
    }
}