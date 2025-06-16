package vista;

import controlador.ControladorUsuario;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import modelo.Usuario;

public class VentanaLogin extends Application {

    private final ControladorUsuario controladorUsuario = new ControladorUsuario();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Label correoLabel = new Label("Correo:");
        TextField correoField = new TextField();

        Label contrasenaLabel = new Label("Contrasena:");
        PasswordField contrasenaField = new PasswordField();

        Button loginButton = new Button("Iniciar sesion");
        Button volverButton = new Button("Volver");

        Label mensajeLabel = new Label();

        loginButton.setOnAction(e -> {
            String correo = correoField.getText();
            String contrasena = contrasenaField.getText();

            Usuario usuario = controladorUsuario.login(correo, contrasena);
            if (usuario != null) {
                mensajeLabel.setText("Bienvenido " + usuario.getNombreUsuario() + " (" + usuario.getRolUsuario() + ")");
                new VentanaPrincipal(usuario).start(new Stage());
                primaryStage.close();
            } else {
                mensajeLabel.setText("Credenciales incorrectas.");
            }
        });

        volverButton.setOnAction(e -> {
            try {
                new VentanaInicio().start(new Stage());
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            primaryStage.close();
        });

        VBox layout = new VBox(10, correoLabel, correoField, contrasenaLabel, contrasenaField, loginButton, volverButton, mensajeLabel);
        layout.setPadding(new Insets(20));

        Scene scene = new Scene(layout, 300, 280);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Login - Crochet con Gene");
        primaryStage.show();
    }
}
