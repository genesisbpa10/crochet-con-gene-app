USE sistema_crochet;

SELECT * FROM Usuario;

SELECT ua.idUsuario, u.nombreUsuario, u.correoUsuario, u.rolUsuario
FROM UsuarioAdministrador ua
JOIN Usuario u ON ua.idUsuario = u.idUsuario;

SELECT ue.idUsuario, u.nombreUsuario, u.correoUsuario, u.rolUsuario
FROM UsuarioEstandar ue
JOIN Usuario u ON ue.idUsuario = u.idUsuario;

SELECT * FROM Material;
SELECT * FROM Punto;
SELECT * FROM Patron;
