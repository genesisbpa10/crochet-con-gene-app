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

public class VentanaRegistrarPatron {
    private final ControladorPunto controladorPunto = new ControladorPunto();
    private final ControladorPatron controladorPatron = new ControladorPatron();
    private final List<ComposicionPatron> composicion = new ArrayList<>();
    private final Usuario usuario;  // ← guardamos al usuario

    public VentanaRegistrarPatron(Usuario usuario) {
        this.usuario = usuario;
    }

    public void mostrarVentana() {
        Stage stage = new Stage();

        Label nombreLabel = new Label("Nombre del Patrón:");
        TextField nombreField = new TextField();

        Label descripcionLabel = new Label("Descripción:");
        TextField descripcionField = new TextField();

        Label tipoLabel = new Label("Tipo de Prenda:");
        TextField tipoField = new TextField();

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
        ListView<String> composicionList = new ListView<>();
        ObservableList<String> items = FXCollections.observableArrayList();
        composicionList.setItems(items);

        Label resultado = new Label();

        agregarBtn.setOnAction(e -> {
            Punto sel = puntoCombo.getValue();
            try {
                int cant = Integer.parseInt(cantidadField.getText());
                if (sel != null && cant > 0) {
                    ComposicionPatron cp = new ComposicionPatron(sel, cant);
                    composicion.add(cp);
                    items.add(sel.getNombrePunto() + " x" + cant);
                    cantidadField.clear();
                    resultado.setText("");
                } else {
                    resultado.setText("Selección inválida.");
                }
            } catch (NumberFormatException ex) {
                resultado.setText("Cantidad inválida.");
            }
        });
        
        Button registrarBtn = new Button("Registrar Patrón");
        Button volverButton = new Button("Volver");
        registrarBtn.setOnAction(e -> {
            String nom  = nombreField.getText().trim();
            String desc = descripcionField.getText().trim();
            String tipo = tipoField.getText().trim();
            if (nom.isEmpty() || desc.isEmpty() || tipo.isEmpty() || composicion.isEmpty()) {
                resultado.setText("Complete todos los campos y agregue al menos un punto.");
                return;
            }
            // ← pasamos idUsuario y la lista de composiciones
            controladorPatron.registrarPatron(nom, desc, tipo, usuario.getIdUsuario(), composicion);
            resultado.setText("¡Patrón registrado con éxito!");
            
            // —— AQUÍ LIMPIAMOS EL FORMULARIO ——
            nombreField.clear();
            descripcionField.clear();
            tipoField.clear();
            // limpiamos la lista de composiciones tanto visual como internamente
            composicion.clear();
            items.clear();
            puntoCombo.getSelectionModel().clearSelection();
            cantidadField.clear();
        });

        volverButton.setOnAction(e -> stage.close());
        
        VBox layout = new VBox(10,
        nombreLabel, nombreField,
            descripcionLabel, descripcionField,
            tipoLabel, tipoField,
            puntoLabel, puntoCombo,
            cantidadLabel, cantidadField, agregarBtn,
            new Label("Composición:"), composicionList,
            registrarBtn, resultado, volverButton
        );
        layout.setPadding(new Insets(20));

        Scene scene = new Scene(layout, 400, 600);
        stage.setScene(scene);
        stage.setTitle("Registrar Patrón");
        stage.show();

        
    }
}
