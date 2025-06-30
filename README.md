# 🧶 crochet-con-gene-app

**crochet-con-gene-app** es un sistema de gestión de patrones de crochet, materiales e insumos. Permite registrar usuarios, iniciar sesión y acceder a funcionalidades específicas según el rol: administrador o estándar. Está desarrollado en **Java** aplicando **POO**, usa **JavaFX** para la interfaz gráfica y **MySQL** como sistema de persistencia.

## Estructura del proyecto

```
crochet-con-gene-app/
│
├── lib/                      # Librerías externas (JavaFX SDK y MySQL Connector)
│   ├── javafx-sdk-20.0.2/
│   └── mysql-connector-j-8.3.0/
│
├── sql/                     # Scripts SQL organizados por etapas
│   ├── 01_create_database.sql
│   ├── 02_schema_tables.sql
│   ├── 03_schema_triggers.sql
│   ├── 04_sample_data.sql
│   ├── 05_queries_examples.sql
│   ├── 06_cleanup_examples.sql
│   └── README.md
│
├── src/                     # Código fuente Java (organizado por paquetes)
│   ├── modelo/
│   ├── controlador/
│   ├── persistencia/
│   ├── vista/
│   └── menu/
│
├── out/                     # Archivos compilados (.class)
├── bin/                     # Directorio adicional para builds
├── README.md                # Este archivo
```

## Requisitos

- **Java JDK 17** o superior
- **MySQL Server** instalado y corriendo localmente (por ejemplo: en `localhost:3306`)
- **JavaFX SDK 20.0.2**
- **MySQL Connector/J 8.3.0**
- Sistema operativo: Windows, Linux (WSL) o macOS

## Configuración inicial

1. **Clonar el repositorio**

```bash
git clone https://github.com/genesisbpa10/crochet-con-gene-app.git
cd crochet-con-gene-app
```

2. **Crear la base de datos en MySQL**

Desde un cliente como Workbench o CLI, ejecutar en orden los siguientes archivos de la carpeta `sql/`:

```sql
01_create_database.sql
02_schema_tables.sql
03_schema_triggers.sql
04_sample_data.sql
```

3. **Verificar conexión a MySQL**

Asegúrate de que en tu archivo `ConexionBD.java` (ubicado en `src/persistencia/`) estén correctos:

```java
String url = "jdbc:mysql://localhost:3306/sistema_crochet";
String usuario = "root";
String contrasena = "su_contraseña_aqui";
```

## Compilación del proyecto

Compilar todos los `.java` con soporte JavaFX y el conector MySQL:

```bash
javac --module-path lib/javafx-sdk-20.0.2/lib \
      --add-modules javafx.controls,javafx.fxml \
      -cp "lib/mysql-connector-j-8.3.0/mysql-connector-j-8.3.0.jar" \
      -d out $(find src -name "*.java")
```

## Modo Gráfico (JavaFX)

### Ejecutar la interfaz gráfica:

```bash
java --module-path lib/javafx-sdk-20.0.2/lib \
     --add-modules javafx.controls,javafx.fxml \
     -cp "out:lib/mysql-connector-j-8.3.0/mysql-connector-j-8.3.0.jar" \
     vista.VentanaInicio
```

## Modo Consola

### Ejecutar la app en modo texto:

```bash
java --module-path lib/javafx-sdk-20.0.2/lib \
     --add-modules javafx.controls,javafx.fxml \
     -cp "out:lib/mysql-connector-j-8.3.0/mysql-connector-j-8.3.0.jar" \
     menu.Consola
```

## Nota para usuarios de Windows

### Si estás ejecutando los comandos directamente desde CMD o PowerShell en Windows (no WSL), reemplaza los dos puntos : del classpath (-cp) por punto y coma ;, ya que Windows utiliza ; como separador de rutas:

Por ejemplo:

```bash
java --module-path lib\javafx-sdk-20.0.2\lib ^
     --add-modules javafx.controls,javafx.fxml ^
     -cp "out;lib/mysql-connector-j-8.3.0\mysql-connector-j-8.3.0.jar" ^
     menu.Consola
```

### En cambio, si estás utilizando WSL o cualquier distribución Linux, los comandos con : como separador de rutas funcionan correctamente, como en los ejemplos originalmente especificados.

## Funcionalidades implementadas

- Registro y autenticación de usuarios (administrador y estándar)
- Gestión de materiales (solo para administradores)
- Interfaz en consola y en JavaFX
- Arquitectura modular (MVC)
- Uso de POO: encapsulamiento, herencia, polimorfismo y abstracción
- Persistencia en MySQL
- Validación de entradas y manejo de errores

## Consideraciones

- Se puede ejecutar tanto en WSL como en Windows, siempre que Java y MySQL estén correctamente configurados.
- Asegúrese de tener la base de datos corriendo y los drivers en las carpetas correctas (`lib/`).
- En caso de error al ejecutar alguna clase JavaFX, asegúrese de no invocar `VentanaPrincipal` directamente sin un usuario logueado.

## Limpieza de datos

Para borrar los datos creados y reiniciar el estado de la DB:

```sql
06_cleanup_examples.sql
```
