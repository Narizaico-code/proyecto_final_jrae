INSERT IGNORE INTO Administradores (nombre, apellido, correo, telefono)
VALUES ('Juan', 'Ramírez', 'juan.ramirez@example.com', '55443322');

INSERT IGNORE INTO Administradores (nombre, apellido, correo, telefono)
VALUES ('María', 'González', 'maria.gonzalez@example.com', '44221133');

INSERT IGNORE INTO Administradores (nombre, apellido, correo, telefono)
VALUES ('Carlos', 'Hernández', 'carlos.hernandez@example.com', '66334455');

INSERT IGNORE INTO Administradores (nombre, apellido, correo, telefono)
VALUES ('Ana', 'Pérez', 'ana.perez@example.com', '77889900');

INSERT IGNORE INTO Administradores (nombre, apellido, correo, telefono)
VALUES ('José', 'Martínez', 'jose.martinez@example.com', '99001122');

-- Tuplas para Clientes
INSERT IGNORE INTO Clientes (nombre, apellido, apodo, correo, telefono, direccion)
VALUES ('Carlos', 'Gómez', 'Carlitos', 'carlos.gomez@example.com', '12345678', 'Av. Central 123');

INSERT IGNORE INTO Clientes (nombre, apellido, apodo, correo, telefono, direccion)
VALUES ('Ana', 'Martínez', 'Anita', 'ana.martinez@example.com', '87654321', 'Calle 5 #45');

INSERT IGNORE INTO Clientes (nombre, apellido, apodo, correo, telefono, direccion)
VALUES ('Luis', 'Fernández', 'Lucho', 'luis.fernandez@example.com', '11223344', 'Bulevar Principal 67');
-- precio_vehiculos
INSERT INTO precio_vehiculos (tipo_vehiculo, valor) VALUES
('Automóvil', 50.00),
('Motocicleta', 30.00),
('Camioneta', 70.00),
('Microbús', 90.00),
('Camión', 120.00);

INSERT IGNORE INTO Clientes (nombre, apellido, apodo, correo, telefono, direccion)
VALUES ('María', 'Pérez', 'Mari', 'maria.perez@example.com', '44332211', 'Calle del Sol 89');

INSERT IGNORE INTO Clientes (nombre, apellido, apodo, correo, telefono, direccion)
VALUES ('José', 'Ramírez', 'Pepe', 'jose.ramirez@example.com', '55667788', 'Av. Las Flores 101');
-- Servicios
INSERT INTO servicios (nombre, descripcion, precio) VALUES
('Lavado Básico', 'Incluye lavado exterior con agua a presión y jabón especial para automóviles.', 40.00),
('Lavado Completo', 'Lavado interior y exterior, aspirado, limpieza de vidrios y aplicación de cera.', 80.00),
('Lavado Premium', 'Lavado completo más limpieza de motor, desinfección con vapor y encerado detallado.', 120.00),
('Encerado', 'Aplicación de cera protectora para mejorar el brillo y proteger la pintura.', 60.00),
('Aspirado Interior', 'Aspirado de alfombras, asientos y área de maletero.', 30.00);