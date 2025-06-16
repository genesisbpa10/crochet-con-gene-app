USE sistema_crochet;

-- Tabla Usuario (base)
CREATE TABLE Usuario (
    idUsuario INT AUTO_INCREMENT PRIMARY KEY,
    nombreUsuario VARCHAR(100) NOT NULL,
    correoUsuario VARCHAR(150) NOT NULL UNIQUE,
    contrasenaUsuario VARCHAR(255) NOT NULL,
    rolUsuario ENUM('estandar', 'administrador') NOT NULL,
    fechaCreacionUsuario TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Tabla UsuarioEstandar (extiende Usuario)
CREATE TABLE UsuarioEstandar (
    idUsuario INT PRIMARY KEY,
    FOREIGN KEY (idUsuario) REFERENCES Usuario(idUsuario) ON DELETE CASCADE
);

-- Tabla UsuarioAdministrador (extiende Usuario)
CREATE TABLE UsuarioAdministrador (
    idUsuario INT PRIMARY KEY,
    FOREIGN KEY (idUsuario) REFERENCES Usuario(idUsuario) ON DELETE CASCADE
);

-- Tabla Material
CREATE TABLE Material (
    idMaterial INT AUTO_INCREMENT PRIMARY KEY,
    nombreMaterial VARCHAR(100) NOT NULL,
    tipoMaterial VARCHAR(50),
    colorMaterial VARCHAR(50),
    pesoMaterial DECIMAL(10,2),
    idUsuario INT NOT NULL,
    FOREIGN KEY (idUsuario) REFERENCES UsuarioAdministrador(idUsuario) ON DELETE CASCADE
);

-- Tabla Punto
CREATE TABLE Punto (
    idPunto INT AUTO_INCREMENT PRIMARY KEY,
    nombrePunto VARCHAR(100) NOT NULL,
    descripcionPunto TEXT,
    caracteristicasPunto TEXT,
    pesoPunto DECIMAL(10,2),
    idUsuario INT NOT NULL,
    FOREIGN KEY (idUsuario) REFERENCES UsuarioEstandar(idUsuario) ON DELETE CASCADE
);

-- Tabla Patron
CREATE TABLE Patron (
    idPatron INT AUTO_INCREMENT PRIMARY KEY,
    nombrePatron VARCHAR(100) NOT NULL,
    descripcionPatron TEXT,
    tipoPatron VARCHAR(50),
    idUsuario INT NOT NULL,
    FOREIGN KEY (idUsuario) REFERENCES UsuarioEstandar(idUsuario) ON DELETE CASCADE
);

-- Tabla intermedia Patron_Punto
CREATE TABLE Patron_Punto (
    idPatron INT,
    idPunto INT,
    cantidadPatronPunto INT DEFAULT 1,
    PRIMARY KEY (idPatron, idPunto),
    FOREIGN KEY (idPatron) REFERENCES Patron(idPatron) ON DELETE CASCADE,
    FOREIGN KEY (idPunto) REFERENCES Punto(idPunto) ON DELETE CASCADE
);

-- Tabla intermedia Punto_Material
CREATE TABLE Punto_Material (
    idPunto INT,
    idMaterial INT,
    cantidadPuntoMaterial DECIMAL(10,2),
    PRIMARY KEY (idPunto, idMaterial),
    FOREIGN KEY (idPunto) REFERENCES Punto(idPunto) ON DELETE CASCADE,
    FOREIGN KEY (idMaterial) REFERENCES Material(idMaterial) ON DELETE CASCADE
);
