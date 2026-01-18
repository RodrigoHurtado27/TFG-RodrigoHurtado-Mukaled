CREATE DATABASE IF NOT EXISTS TFG_Muka_Rodrigo;
USE TFG_Muka_Rodrigo;

CREATE TABLE perfiles (
    id_perfil INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(250) NOT NULL
);

INSERT INTO perfiles (nombre) VALUES
('ROLE_ADMIN'),
('ROLE_CLIENTE'),
('ROLE_EMPLEADO');

CREATE TABLE usuarios (
    id_usuario INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(45) NOT NULL UNIQUE,
    password VARCHAR(250) NOT NULL,
    nombre VARCHAR(100),
    apellidos VARCHAR(200),
    enabled INT,
    fecha_registro DATE,
    fecha_nacimiento DATE,
    direccion VARCHAR(200),
    id_perfil INT,
    FOREIGN KEY (id_perfil) REFERENCES perfiles(id_perfil)
);

INSERT INTO usuarios (username, password, nombre, apellidos, enabled, fecha_registro, fecha_nacimiento, direccion, id_perfil) VALUES
('admin@tfg.com','{noop}admin','Admin','Sistema',1,'2025-01-10','1980-01-01','Madrid',1),
('empleado@tfg.com','{noop}empleado','Laura','López',1,'2025-01-10','1995-03-10','Sevilla',3),
('cliente@tfg.com','{noop}cliente','Carlos','Ruiz',1,'2025-01-10','2000-06-15','Valencia',2);

CREATE TABLE habitaciones (
    id_habitacion INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    descripcion VARCHAR(300),
    capacidad INT NOT NULL,
    precio_dia DECIMAL(10,2) NOT NULL,
    estado VARCHAR(50)
);

CREATE TABLE reservas (
    id_reserva INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    id_usuario INT NOT NULL,
    id_habitacion INT NOT NULL,
    fecha_inicio DATE NOT NULL,
    fecha_fin DATE NOT NULL,
    estado VARCHAR(50),
    total_precio DECIMAL(10,2),
    fecha_reserva DATE,
    FOREIGN KEY (id_usuario) REFERENCES usuarios(id_usuario),
    FOREIGN KEY (id_habitacion) REFERENCES habitaciones(id_habitacion)
);

CREATE TABLE valoraciones (
    id_valoracion INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    id_usuario INT NOT NULL,
    id_habitacion INT NOT NULL,
    puntuacion INT,
    comentario VARCHAR(300),
    fecha DATE,
    FOREIGN KEY (id_usuario) REFERENCES usuarios(id_usuario),
    FOREIGN KEY (id_habitacion) REFERENCES habitaciones(id_habitacion)
);

CREATE TABLE incidencias (
    id_incidencia INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    id_habitacion INT NOT NULL,
    id_usuario INT NOT NULL,
    descripcion VARCHAR(300),
    estado VARCHAR(50),
    fecha DATE,
    FOREIGN KEY (id_habitacion) REFERENCES habitaciones(id_habitacion),
    FOREIGN KEY (id_usuario) REFERENCES usuarios(id_usuario)
);
