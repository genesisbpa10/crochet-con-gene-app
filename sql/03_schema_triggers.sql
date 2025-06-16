USE sistema_crochet;

DELIMITER $$
CREATE TRIGGER trg_check_usuario_estandar BEFORE INSERT ON UsuarioEstandar
FOR EACH ROW
BEGIN
  DECLARE tipo varchar(20);
  SELECT rolUsuario INTO tipo FROM Usuario WHERE idUsuario = NEW.idUsuario;
  IF tipo <> 'estandar' THEN
    SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Error: usuario no es de tipo estandar';
  END IF;
END$$
DELIMITER ;

DELIMITER $$
CREATE TRIGGER trg_check_usuario_administrador BEFORE INSERT ON UsuarioAdministrador
FOR EACH ROW
BEGIN
  DECLARE tipo varchar(20);
  SELECT rolUsuario INTO tipo FROM Usuario WHERE idUsuario = NEW.idUsuario;
  IF tipo <> 'administrador' THEN
    SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Error: usuario no es de tipo administrador';
  END IF;
END$$
DELIMITER ;
