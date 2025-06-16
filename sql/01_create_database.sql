-- Crear usuario y base de datos para el sistema
CREATE USER 'sistema_crochet_db'@'%' IDENTIFIED BY 'XXXXXXXXXXX';
GRANT ALL PRIVILEGES ON sistema_crochet.* TO 'sistema_crochet_db'@'%';
FLUSH PRIVILEGES;

-- Crear base de datos
CREATE DATABASE IF NOT EXISTS sistema_crochet;
USE sistema_crochet;
