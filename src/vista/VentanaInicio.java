package vista;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class VentanaInicio extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Sistema Crochet - Inicio");

        Button btnLogin = new Button("Iniciar sesión");
        btnLogin.setOnAction(e -> {
            VentanaLogin ventanaLogin = new VentanaLogin();
            try {
                ventanaLogin.start(new Stage());
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            primaryStage.close();
        });

        Button btnRegistro = new Button("Registrarse");
        btnRegistro.setOnAction(e -> {
            VentanaRegistro ventanaRegistro = new VentanaRegistro();
            try {
                ventanaRegistro.start(new Stage());
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            primaryStage.close();
        });

        Button btnSalir = new Button("Salir");
        btnSalir.setOnAction(e -> {
            System.exit(0);
        });

        VBox layout = new VBox(15, btnLogin, btnRegistro, btnSalir);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout, 300, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
