package vista;

import controlador.ControladorPatron;
import controlador.ControladorPunto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import modelo.ComposicionPatron;
import modelo.Patron;
import modelo.Punto;
import modelo.Usuario;

import java.util.ArrayList;
import java.util.List;

public class VentanaPatrones {
    private final ControladorPunto controladorPunto = new ControladorPunto();
    private final ControladorPatron controladorPatron = new ControladorPatron();
    private final Usuario usuario;

    private final ObservableList<Patron> patrones = FXCollections.observableArrayList();
    private final ObservableList<String> composicionItems = FXCollections.observableArrayList();
    private final List<ComposicionPatron> composicion = new ArrayList<>();

    public VentanaPatrones(Usuario usuario) {
        this.usuario = usuario;
    }

    public void mostrarVentana() {
        Stage stage = new Stage();

        // Tabla de patrones existentes
        TableView<Patron> tabla = new TableView<>(patrones);
        TableColumn<Patron, String> nombreCol = new TableColumn<>("Nombre");
        nombreCol.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getNombre()));
        TableColumn<Patron, String> descCol = new TableColumn<>("Descripción");
        descCol.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getDescripcion()));
        TableColumn<Patron, String> tipoCol = new TableColumn<>("Tipo");
        tipoCol.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getTipoPatron()));
        tabla.getColumns().addAll(nombreCol, descCol, tipoCol);

        // Campos de edición/registro
        Label nombreLabel = new Label("Nombre del Patrón:");
        TextField nombreField = new TextField();

        Label descripcionLabel = new Label("Descripción:");
        TextField descripcionField = new TextField();

        Label tipoLabel = new Label("Tipo de Prenda:");
        TextField tipoField = new TextField();

        // Composición
        Label puntoLabel = new Label("Seleccionar Punto:");
        ComboBox<Punto> puntoCombo = new ComboBox<>(
            FXCollections.observableArrayList(controladorPunto.obtenerPuntos(usuario.getIdUsuario()))
        );
        puntoCombo.setCellFactory(lv -> new ListCell<>() {
            @Override protected void updateItem(Punto item, boolean empty) {
                super.updateItem(item, empty);
                setText(empty || item == null ? null : item.getNombrePunto());
            }
        });
        puntoCombo.setButtonCell(new ListCell<>() {
            @Override protected void updateItem(Punto item, boolean empty) {
                super.updateItem(item, empty);
                setText(empty || item == null ? null : item.getNombrePunto());
            }
        });

        Label cantidadLabel = new Label("Cantidad:");
        TextField cantidadField = new TextField();

        Button agregarBtn = new Button("Agregar a Composición");
        ListView<String> composicionList = new ListView<>(composicionItems);

        Label resultado = new Label();

        // Botones principales
        Button registrarBtn = new Button("Registrar Patrón");
        Button modificarBtn = new Button("Modificar");
        Button eliminarBtn = new Button("Eliminar");
        Button limpiarBtn = new Button("Limpiar");
        Button volverBtn = new Button("Volver");

        // Cargar patrones existentes
        cargarPatrones();

        // Selección de patrón en la tabla
        tabla.getSelectionModel().selectedItemProperty().addListener((obs, oldSel, newSel) -> {
            limpiarCampos(nombreField, descripcionField, tipoField, puntoCombo, cantidadField, composicion, composicionItems);
            if (newSel != null) {
                nombreField.setText(newSel.getNombre());
                descripcionField.setText(newSel.getDescripcion());
                tipoField.setText(newSel.getTipoPatron());
                if (newSel.getComposicion() != null) {
                    composicion.clear();
                    composicion.addAll(newSel.getComposicion());
                    composicionItems.clear();
                    for (ComposicionPatron cp : composicion) {
                        composicionItems.add(cp.getPunto().getNombrePunto() + " x" + cp.getCantidad());
                    }
                }
            }
        });

        // Agregar punto a composición
        agregarBtn.setOnAction(e -> {
            Punto sel = puntoCombo.getValue();
            try {
                int cant = Integer.parseInt(cantidadField.getText());
                if (sel != null && cant > 0) {
                    ComposicionPatron cp = new ComposicionPatron(sel, cant);
                    composicion.add(cp);
                    composicionItems.add(sel.getNombrePunto() + " x" + cant);
                    cantidadField.clear();
                    resultado.setText("");
                } else {
                    resultado.setText("Selección inválida.");
                }
            } catch (NumberFormatException ex) {
                resultado.setText("Cantidad inválida.");
            }
        });

        // Registrar patrón nuevo
        registrarBtn.setOnAction(e -> {
            String nom  = nombreField.getText().trim();
            String desc = descripcionField.getText().trim();
            String tipo = tipoField.getText().trim();
            if (nom.isEmpty() || desc.isEmpty() || tipo.isEmpty() || composicion.isEmpty()) {
                resultado.setText("Complete todos los campos y agregue al menos un punto.");
                return;
            }
            controladorPatron.registrarPatron(nom, desc, tipo, usuario.getIdUsuario(), new ArrayList<>(composicion));
            resultado.setText("¡Patrón registrado con éxito!");
            cargarPatrones();
            limpiarCampos(nombreField, descripcionField, tipoField, puntoCombo, cantidadField, composicion, composicionItems);
        });

        // Modificar patrón seleccionado
        modificarBtn.setOnAction(e -> {
            Patron seleccionado = tabla.getSelectionModel().getSelectedItem();
            if (seleccionado != null) {
                String nom  = nombreField.getText().trim();
                String desc = descripcionField.getText().trim();
                String tipo = tipoField.getText().trim();
                if (nom.isEmpty() || desc.isEmpty() || tipo.isEmpty() || composicion.isEmpty()) {
                    resultado.setText("Complete todos los campos y agregue al menos un punto.");
                    return;
                }
                seleccionado.setNombre(nom);
                seleccionado.setDescripcion(desc);
                seleccionado.setTipoPatron(tipo);
                seleccionado.setComposicion(new ArrayList<>(composicion));
                controladorPatron.actualizarPatron(seleccionado);
                resultado.setText("Patrón modificado.");
                cargarPatrones();
                limpiarCampos(nombreField, descripcionField, tipoField, puntoCombo, cantidadField, composicion, composicionItems);
            }
        });

        // Eliminar patrón seleccionado
        eliminarBtn.setOnAction(e -> {
            Patron seleccionado = tabla.getSelectionModel().getSelectedItem();
            if (seleccionado != null) {
                controladorPatron.eliminarPatronPorId(seleccionado.getIdPatron());
                resultado.setText("Patrón eliminado.");
                cargarPatrones();
                limpiarCampos(nombreField, descripcionField, tipoField, puntoCombo, cantidadField, composicion, composicionItems);
            }
        });

        // Limpiar campos
        limpiarBtn.setOnAction(e -> limpiarCampos(nombreField, descripcionField, tipoField, puntoCombo, cantidadField, composicion, composicionItems));

        volverBtn.setOnAction(e -> stage.close());

        VBox layout = new VBox(10,
            new Label("Patrones existentes:"), tabla,
            nombreLabel, nombreField,
            descripcionLabel, descripcionField,
            tipoLabel, tipoField,
            puntoLabel, puntoCombo,
            cantidadLabel, cantidadField, agregarBtn,
            new Label("Composición:"), composicionList,
            registrarBtn, modificarBtn, eliminarBtn, limpiarBtn, resultado, volverBtn
        );
        layout.setPadding(new Insets(20));

        Scene scene = new Scene(layout, 600, 800);
        stage.setScene(scene);
        stage.setTitle("Gestión de Patrones");
        stage.show();
    }

    private void cargarPatrones() {
        patrones.setAll(controladorPatron.obtenerPatrones());
    }

    private static void limpiarCampos(TextField nombre, TextField descripcion, TextField tipo, ComboBox<Punto> puntoCombo, TextField cantidad, List<ComposicionPatron> composicion, ObservableList<String> composicionItems) {
        nombre.clear();
        descripcion.clear();
        tipo.clear();
        puntoCombo.getSelectionModel().clearSelection();
        cantidad.clear();
        composicion.clear();
        composicionItems.clear();
    }
}