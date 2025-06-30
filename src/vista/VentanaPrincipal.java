package vista;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import modelo.Usuario;

public class VentanaPrincipal extends Application {

    private static Usuario usuarioLogueado;

    public VentanaPrincipal() {}

    public VentanaPrincipal(Usuario usuario) {
        usuarioLogueado = usuario;
    }

    @Override
    public void start(Stage primaryStage) {
        Label bienvenida = new Label("Bienvenido/a " + usuarioLogueado.getNombreUsuario());

        Button materialesBtn = new Button("Gestión de Materiales");
        materialesBtn.setOnAction(e ->
            new VentanaMateriales(usuarioLogueado).mostrarVentana()
        );

        Button puntosBtn = new Button("Gestión de Puntos");
        puntosBtn.setOnAction(e ->
            new VentanaPuntos(usuarioLogueado).mostrarVentana()
        );

        Button patronesBtn = new Button("Gestión de Patrones");
        // ← pasamos el usuarioLogueado aquí también
        patronesBtn.setOnAction(e ->
            new VentanaRegistrarPatron(usuarioLogueado).mostrarVentana()
        );

        Button logoutBtn = new Button("Cerrar sesión");
        logoutBtn.setOnAction(e -> {
            new VentanaLogin().start(new Stage());
            primaryStage.close();
        });

        VBox layout = new VBox(10, bienvenida);
        layout.setPadding(new Insets(20));

        if ("administrador".equalsIgnoreCase(usuarioLogueado.getRolUsuario())) {
            layout.getChildren().add(materialesBtn);
        } else {
            layout.getChildren().addAll(puntosBtn, patronesBtn);
        }

        layout.getChildren().add(logoutBtn);

        Scene scene = new Scene(layout, 300, 200);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Panel Principal - " + usuarioLogueado.getRolUsuario());
        primaryStage.show();
    }
}
