CREATE TABLE IF NOT EXISTS PRODUCTO (
        id INT AUTO_INCREMENT PRIMARY KEY,
        nombre VARCHAR(25),
        precio INT,
        imagen VARCHAR(100)
    );

CREATE TABLE IF NOT EXISTS CARRITO (
        id INT AUTO_INCREMENT PRIMARY KEY,
        productos INT,
        total INT
    );

CREATE TABLE IF NOT EXISTS USUARIO (
        id INT AUTO_INCREMENT PRIMARY KEY,
        nombre VARCHAR(25),
        apellido VARCHAR(25),
        email VARCHAR(25),
        password VARCHAR(25)
    );