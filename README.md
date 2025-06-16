# crochet-con-gene-app

# Modo Consola

## Compilar la aplicacion:
javac --module-path lib/javafx-sdk-20.0.2/lib \
      --add-modules javafx.controls,javafx.fxml \
      -cp "lib/mysql-connector-j-8.3.0/mysql-connector-j-8.3.0.jar" \
      -d out $(find src -name "*.java")

## Ejecutar la aplicacion Main:
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

## Compilar la aplicacion
javac --module-path lib/javafx-sdk-20.0.2/lib \
      --add-modules javafx.controls,javafx.fxml \
      -cp "lib/mysql-connector-j-8.3.0/mysql-connector-j-8.3.0.jar" \
      -d out $(find src -name "*.java")

## Ejecutar la aplicacion Ventana Inicio
java --module-path lib/javafx-sdk-20.0.2/lib \
     --add-modules javafx.controls,javafx.fxml \
     -cp "out:lib/mysql-connector-j-8.3.0/mysql-connector-j-8.3.0.jar" \
     vista.VentanaInicio
