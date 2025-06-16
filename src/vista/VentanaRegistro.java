package vista;

import controlador.ControladorUsuario;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import modelo.Usuario;

public class VentanaRegistro extends Application {

    private final ControladorUsuario controladorUsuario = new ControladorUsuario();

    @Override
    public void start(Stage stage) {
        stage.setTitle("Registro de Usuario");

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setVgap(10);
        grid.setHgap(10);
        grid.setPadding(new Insets(25));

        Label lblNombre = new Label("Nombre:");
        TextField txtNombre = new TextField();

        Label lblCorreo = new Label("Correo:");
        TextField txtCorreo = new TextField();

        Label lblContrasena = new Label("Contraseña:");
        PasswordField txtContrasena = new PasswordField();

        Label lblRol = new Label("Rol:");
        ComboBox<String> cbRol = new ComboBox<>();
        cbRol.getItems().addAll("estandar", "administrador");
        cbRol.setValue("estandar");

        Button btnRegistrar = new Button("Registrar");
        Button btnVolver = new Button("Volver");

        Label lblResultado = new Label();

        btnRegistrar.setOnAction(e -> {
            String nombre = txtNombre.getText();
            String correo = txtCorreo.getText();
            String contrasena = txtContrasena.getText();
            String rol = cbRol.getValue();

            if (nombre.isEmpty() || correo.isEmpty() || contrasena.isEmpty()) {
                lblResultado.setText("Todos los campos son obligatorios.");
                return;
            }

            Usuario nuevo = controladorUsuario.registrarUsuario(nombre, correo, contrasena, rol);
            if (nuevo != null) {
                lblResultado.setText("Usuario registrado exitosamente.");
            } else {
                lblResultado.setText("Error al registrar usuario.");
            }
        });

        btnVolver.setOnAction(e -> {
            try {
                new VentanaInicio().start(new Stage());
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            stage.close();
        });

        grid.add(lblNombre, 0, 0);
        grid.add(txtNombre, 1, 0);
        grid.add(lblCorreo, 0, 1);
        grid.add(txtCorreo, 1, 1);
        grid.add(lblContrasena, 0, 2);
        grid.add(txtContrasena, 1, 2);
        grid.add(lblRol, 0, 3);
        grid.add(cbRol, 1, 3);
        grid.add(btnRegistrar, 0, 4);
        grid.add(btnVolver, 1, 4);
        grid.add(lblResultado, 0, 5, 2, 1);

        Scene scene = new Scene(grid, 400, 300);
        stage.setScene(scene);
        stage.show();
    }
}
