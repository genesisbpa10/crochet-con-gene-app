-- Ejemplo: eliminar usuario administrador con idUsuario = 1
DELETE FROM UsuarioAdministrador WHERE idUsuario = 1;

-- Ejemplo: eliminar usuario estandar con idUsuario = 2
DELETE FROM UsuarioEstandar WHERE idUsuario = 2;

-- IMPORTANTE: la eliminacion en las tablas específicas no borra automaticamente el Usuario base
DELETE FROM Usuario WHERE idUsuario = 1;
DELETE FROM Usuario WHERE idUsuario = 2;

-- Consultas post-eliminacion
SELECT * FROM Usuario;

SELECT ua.idUsuario, u.nombreUsuario, u.correoUsuario, u.rolUsuario
FROM UsuarioAdministrador ua
JOIN Usuario u ON ua.idUsuario = u.idUsuario;

SELECT ue.idUsuario, u.nombreUsuario, u.correoUsuario, u.rolUsuario
FROM UsuarioEstandar ue
JOIN Usuario u ON ue.idUsuario = u.idUsuario;
