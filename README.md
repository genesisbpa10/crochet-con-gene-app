# crochet-con-gene-app

# Modo Consola

## Compilar la aplicación:
javac --module-path lib/javafx-sdk-20.0.2/lib \
      --add-modules javafx.controls,javafx.fxml \
      -cp "lib/mysql-connector-j-8.3.0/mysql-connector-j-8.3.0.jar" \
      -d out $(find src -name "*.java")

## Ejecutar la aplicación Main:
<!-- 
java --module-path lib/javafx-sdk-20.0.2/lib \
     --add-modules javafx.controls,javafx.fxml \
     -cp "out:lib/mysql-connector-j-8.3.0/mysql-connector-j-8.3.0.jar" \
     menu.Main -->

## Ejecutar Consola:
java --module-path lib/javafx-sdk-20.0.2/lib \
     --add-modules javafx.controls,javafx.fxml \
     -cp "out:lib/mysql-connector-j-8.3.0/mysql-connector-j-8.3.0.jar" \
     menu.Consola

# Modo Java FX

## Compilar la aplicación
javac --module-path lib/javafx-sdk-20.0.2/lib \
      --add-modules javafx.controls,javafx.fxml \
      -cp "lib/mysql-connector-j-8.3.0/mysql-connector-j-8.3.0.jar" \
      -d out $(find src -name "*.java")

## Ejecutar la aplicación Ventana Principal
java --module-path lib/javafx-sdk-20.0.2/lib \
     --add-modules javafx.controls,javafx.fxml \
     -cp "out:lib/mysql-connector-j-8.3.0/mysql-connector-j-8.3.0.jar" \
     vista.VentanaPrincipal

## Ejecutar la aplicación Ventana Login
java --module-path lib/javafx-sdk-20.0.2/lib \
     --add-modules javafx.controls,javafx.fxml \
     -cp "out:lib/mysql-connector-j-8.3.0/mysql-connector-j-8.3.0.jar" \
     vista.VentanaLogin