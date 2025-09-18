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
INSERT IGNORE INTO precio_vehiculos (tipo_vehiculo, valor) VALUES
('Automóvil', 50.00),
('Motocicleta', 30.00),
('Camioneta', 70.00),
('Microbús', 90.00),
('Camión', 120.00);


-- Servicios
INSERT IGNORE INTO servicios (nombre, descripcion, precio) VALUES
('Lavado Básico', 'Incluye lavado exterior con agua a presión y jabón especial para automóviles.', 40.00),
('Lavado Completo', 'Lavado interior y exterior, aspirado, limpieza de vidrios y aplicación de cera.', 80.00),
('Lavado Premium', 'Lavado completo más limpieza de motor, desinfección con vapor y encerado detallado.', 120.00),
('Encerado', 'Aplicación de cera protectora para mejorar el brillo y proteger la pintura.', 60.00),
('Aspirado Interior', 'Aspirado de alfombras, asientos y área de maletero.', 30.00);

INSERT IGNORE INTO Proveedores (nombre, numero, correo, direccion)
VALUES ('Proveedor Uno', '55510001', 'proveedor1@example.com', 'Calle 1 #101');

INSERT IGNORE INTO Proveedores (nombre, numero, correo, direccion)
VALUES ('Proveedor Dos', '55510002', 'proveedor2@example.com', 'Calle 2 #202');

INSERT IGNORE INTO Proveedores (nombre, numero, correo, direccion)
VALUES ('Proveedor Tres', '55510003', 'proveedor3@example.com', 'Calle 3 #303');

INSERT IGNORE INTO Proveedores (nombre, numero, correo, direccion)
VALUES ('Proveedor Cuatro', '55510004', 'proveedor4@example.com', 'Calle 4 #404');

INSERT IGNORE INTO Proveedores (nombre, numero, correo, direccion)
VALUES ('Proveedor Cinco', '55510005', 'proveedor5@example.com', 'Calle 5 #505');

INSERT IGNORE INTO Empleados
(nombre, apellido, edad, disponibilidad, sueldo, fecha_contratacion, correo, telefono, cargo, codigo_administrador)
VALUES
('Carlos', 'García', 28, TRUE, 3500.50, '2022-03-15', 'carlos.garcia@example.com', '55889977', 'Lavador', 1),

('María', 'López', 32, TRUE, 4200.75, '2021-06-10', 'maria.lopez@example.com', '55776655', 'Recepcionista', 1),

('Pedro', 'Martínez', 25, FALSE, 3100.00, '2023-01-05', 'pedro.martinez@example.com', '55667788', 'Lavador', 2),

('Ana', 'Hernández', 29, TRUE, 4800.20, '2020-11-20', 'ana.hernandez@example.com', '55443322', 'Supervisora', 2),

('Luis', 'Ramírez', 35, TRUE, 5200.00, '2019-09-12', 'luis.ramirez@example.com', '55998877', 'Encargado', 3);
