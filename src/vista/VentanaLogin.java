package vista;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import controlador.ControladorUsuario;
import modelo.Usuario;

public class VentanaLogin extends Application {
    private ControladorUsuario controladorUsuario;

    @Override
    public void start(Stage primaryStage) {
        controladorUsuario = new ControladorUsuario();

        primaryStage.setTitle("Login");

        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);

        Label labelUsername = new Label("Username:");
        TextField textFieldUsername = new TextField();
        Label labelPassword = new Label("Password:");
        PasswordField passwordField = new PasswordField();
        Button buttonLogin = new Button("Login");
        Button buttonRegister = new Button("Register");

        grid.add(labelUsername, 0, 0);
        grid.add(textFieldUsername, 1, 0);
        grid.add(labelPassword, 0, 1);
        grid.add(passwordField, 1, 1);
        grid.add(buttonLogin, 0, 2);
        grid.add(buttonRegister, 1, 2);

        buttonLogin.setOnAction(event -> {
            String username = textFieldUsername.getText();
            String password = passwordField.getText();
            Usuario usuario = controladorUsuario.login(username, password);
            if (usuario != null) {
                System.out.println("Login successful: " + usuario.getNombreUsuario());
                // Open main application window
            } else {
                System.out.println("Login failed");
                Alert alert = new Alert(Alert.AlertType.ERROR, "Invalid username or password", ButtonType.OK);
                alert.showAndWait();
            }
        });

        buttonRegister.setOnAction(event -> {
            // Open registration window
            VentanaRegistro ventanaRegistro = new VentanaRegistro(controladorUsuario);
            ventanaRegistro.start(new Stage());
            primaryStage.close();
        });

        Scene scene = new Scene(grid, 300, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}