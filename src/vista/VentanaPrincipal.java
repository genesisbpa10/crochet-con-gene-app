package vista;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
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

        Button materialesBtn = new Button("Gestion de Materiales");
        materialesBtn.setOnAction(e -> {
            VentanaRegistrarMaterial ventana = new VentanaRegistrarMaterial(usuarioLogueado);
            ventana.mostrarVentana();
        });

        Button puntosBtn = new Button("Gestión de Puntos");
        puntosBtn.setOnAction(e -> {
            VentanaRegistrarPunto ventana = new VentanaRegistrarPunto(usuarioLogueado);
            ventana.mostrarVentana();
        });

        Button patronesBtn = new Button("Gestion de Patrones");
        Button logoutBtn = new Button("Cerrar sesion");

        VBox layout = new VBox(10, bienvenida);

        if (usuarioLogueado.getRolUsuario().equalsIgnoreCase("administrador")) {
            layout.getChildren().add(materialesBtn);
        }

        layout.getChildren().addAll(puntosBtn, patronesBtn, logoutBtn);
        layout.setPadding(new Insets(20));

        logoutBtn.setOnAction(e -> {
            new VentanaLogin().start(new Stage());
            primaryStage.close();
        });

        Scene scene = new Scene(layout, 300, 300);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Panel Principal - " + usuarioLogueado.getRolUsuario());
        primaryStage.show();
    }
}
