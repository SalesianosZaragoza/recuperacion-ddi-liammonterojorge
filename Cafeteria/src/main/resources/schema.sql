CREATE TABLE IF NOT EXISTS PRODUCTO (
                                        id INT AUTO_INCREMENT PRIMARY KEY,
                                        nombre VARCHAR(25),
                                        precio INT,
                                        imagen VARCHAR(100)
);

CREATE TABLE IF NOT EXISTS CARRITO (
                                       id INT AUTO_INCREMENT PRIMARY KEY,
                                       total DOUBLE
);

CREATE TABLE IF NOT EXISTS CARRITO_PRODUCTO (
                                                id_carrito INT,
                                                id_producto INT,
                                                FOREIGN KEY (id_carrito) REFERENCES CARRITO(id),
                                                FOREIGN KEY (id_producto) REFERENCES PRODUCTO(id)
);

CREATE TABLE IF NOT EXISTS USUARIO (
                                       id INT AUTO_INCREMENT PRIMARY KEY,
                                       nombre VARCHAR(25),
                                       apellido VARCHAR(25),
                                       email VARCHAR(50),
                                       contrasena VARCHAR(25)
);