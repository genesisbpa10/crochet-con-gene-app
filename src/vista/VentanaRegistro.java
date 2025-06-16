package vista;

import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import controlador.ControladorUsuario;

public class VentanaRegistro {
    private ControladorUsuario controladorUsuario;

    // Constructor que recibe el controlador
    public VentanaRegistro(ControladorUsuario controladorUsuario) {
        this.controladorUsuario = controladorUsuario;
    }

    public void start(Stage primaryStage) {
        primaryStage.setTitle("Registro de Usuario");
        
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        
        Label labelNombre = new Label("Nombre:");
        TextField textFieldNombre = new TextField();
        Label labelCorreo = new Label("Correo:");
        TextField textFieldCorreo = new TextField();
        Label labelContrasena = new Label("contrasenaUsuario:");
        PasswordField passwordFieldContrasena = new PasswordField();
        Button buttonRegistrar = new Button("Registrar");
        
        grid.add(labelNombre, 0, 0);
        grid.add(textFieldNombre, 1, 0);
        grid.add(labelCorreo, 0, 1);
        grid.add(textFieldCorreo, 1, 1);
        grid.add(labelContrasena, 0, 2);
        grid.add(passwordFieldContrasena, 1, 2);
        grid.add(buttonRegistrar, 1, 3);
        
        buttonRegistrar.setOnAction(event -> {
            String nombre = textFieldNombre.getText();
            String correo = textFieldCorreo.getText();
            String contrasena = passwordFieldContrasena.getText();
            String rol = "estandar"; // Puedes pedirlo al usuario si lo deseas

            controladorUsuario.registrarUsuario(nombre, correo, contrasena, rol);
            System.out.println("Usuario registrado: " + nombre + ", " + correo);
            primaryStage.close();
        });
        
        Scene scene = new Scene(grid, 300, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}