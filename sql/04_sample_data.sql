USE sistema_crochet;

-- Insertar administrador
INSERT INTO Usuario (nombreUsuario, correoUsuario, contrasenaUsuario, rolUsuario)
VALUES ('Genesis Perez', 'genesisbetaly@gmail.com', '5.4.3.2.1!PsW', 'administrador');
SET @last_id = LAST_INSERT_ID();
INSERT INTO UsuarioAdministrador (idUsuario) VALUES (@last_id);

-- Insertar usuario estandar
INSERT INTO Usuario (nombreUsuario, correoUsuario, contrasenaUsuario, rolUsuario)
VALUES ('Genesis Pérez', 'genesisbetaly99@gmail.com', 'STD!.12.12.!!', 'estandar');
SET @ultimoId = LAST_INSERT_ID();
INSERT INTO UsuarioEstandar (idUsuario) VALUES (@ultimoId);

-- Material
INSERT INTO Material (idUsuario, nombreMaterial, tipoMaterial, colorMaterial, pesoMaterial)
VALUES (3, 'Lana Merino', 'Lana', 'Gris', 200.00);

-- Punto
INSERT INTO Punto (nombrePunto, descripcionPunto, caracteristicasPunto, pesoPunto, idUsuario)
VALUES ('Punto enano', 'Punto basico para uniones', 'Muy corto y compacto', 5.00, 4);

-- Patron
INSERT INTO Patron (nombrePatron, descripcionPatron, tipoPatron, idUsuario)
VALUES ('Bufanda de invierno', 'Patron para una bufanda tejida en punto vareta', 'Accesorio', 4);
