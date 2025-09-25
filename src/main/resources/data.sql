INSERT IGNORE INTO Administradores (nombre, apellido, correo, contrasena, telefono)
VALUES ('Juan', 'Ramírez', 'juan.ramirez@example.com', '129620', '55443322');

INSERT IGNORE INTO Administradores (nombre, apellido, correo, contrasena, telefono)
VALUES ('María', 'González', 'maria.gonzalez@example.com', '154802', '44221133');

INSERT IGNORE INTO Administradores (nombre, apellido, correo, contrasena, telefono)
VALUES ('Carlos', 'Hernández', 'carlos.hernandez@example.com', '1548795', '66334455');

INSERT IGNORE INTO Administradores (nombre, apellido, correo, contrasena, telefono)
VALUES ('Ana', 'Pérez', 'ana.perez@example.com', '12161308', '77889900');

INSERT IGNORE INTO Administradores (nombre, apellido, correo, contrasena, telefono)
VALUES ('José', 'Martínez', 'jose.martinez@example.com', '12852156', '99001122');

-- Tuplas para Clientes
INSERT IGNORE INTO Clientes (nombre, apellido, apodo, contrasena, correo, telefono, direccion)
VALUES ('Carlos', 'Gómez', 'Carlitos', '12345678', 'carlos.gomez@example.com', '12345678', 'Av. Central 123');

INSERT IGNORE INTO Clientes (nombre, apellido, apodo, contrasena, correo, telefono, direccion)
VALUES ('Ana', 'Martínez', 'Anita', '12345678', 'ana.martinez@example.com', '87654321', 'Calle 5 #45');

INSERT IGNORE INTO Clientes (nombre, apellido, apodo, contrasena, correo, telefono, direccion)
VALUES ('Luis', 'Fernández', 'Lucho', '12345678', 'luis.fernandez@example.com', '11223344', 'Bulevar Principal 67');

-- Clientes adicionales
INSERT IGNORE INTO Clientes (nombre, apellido, apodo, contrasena, correo, telefono, direccion)
VALUES ('Patricia', 'Silva', 'Paty', '12345678', 'patricia.silva@example.com', '22334455', 'Av. Los Pinos 89');

INSERT IGNORE INTO Clientes (nombre, apellido, apodo, contrasena, correo, telefono, direccion)
VALUES ('Roberto', 'Vega', 'Rober', '12345678', 'roberto.vega@example.com', '33445566', 'Calle Norte 234');

INSERT IGNORE INTO Clientes (nombre, apellido, apodo, contrasena, correo, telefono, direccion)
VALUES ('Elena', 'Castro', 'Ele', '12345678', 'elena.castro@example.com', '44556677', 'Av. Sur 156');

INSERT IGNORE INTO Clientes (nombre, apellido, apodo, contrasena, correo, telefono, direccion)
VALUES ('Miguel', 'Ruiz', 'Migue', '12345678', 'miguel.ruiz@example.com', '55667788', 'Calle Este 78');

INSERT IGNORE INTO Clientes (nombre, apellido, apodo, contrasena, correo, telefono, direccion)
VALUES ('Sofía', 'Morales', 'Sofi', '12345678', 'sofia.morales@example.com', '66778899', 'Bulevar Oeste 321');

-- PrecioVehiculos (manteniendo los existentes)
INSERT IGNORE INTO precio_vehiculos (tipo_vehiculo, valor) VALUES
('Automóvil', 50.00),
('Motocicleta', 30.00),
('Camioneta', 70.00),
('Microbús', 90.00),
('Camión', 120.00);

-- PrecioVehiculos adicionales
INSERT IGNORE INTO precio_vehiculos (tipo_vehiculo, valor) VALUES
('SUV', 85.00),
('Pickup', 75.00),
('Furgoneta', 95.00);

-- Servicios (manteniendo los existentes)
INSERT IGNORE INTO servicios (nombre, descripcion, precio) VALUES
('Lavado Básico', 'Incluye lavado exterior con agua a presión y jabón especial para automóviles.', 40.00),
('Lavado Completo', 'Lavado interior y exterior, aspirado, limpieza de vidrios y aplicación de cera.', 80.00),
('Lavado Premium', 'Lavado completo más limpieza de motor, desinfección con vapor y encerado detallado.', 120.00),
('Encerado', 'Aplicación de cera protectora para mejorar el brillo y proteger la pintura.', 60.00),
('Aspirado Interior', 'Aspirado de alfombras, asientos y área de maletero.', 30.00);

-- Servicios adicionales
INSERT IGNORE INTO servicios (nombre, descripcion, precio) VALUES
('Limpieza de Motor', 'Limpieza profunda del compartimiento del motor con productos especializados.', 50.00),
('Pulido de Faros', 'Restauración y pulido de faros opacos para mejorar la visibilidad.', 35.00),
('Desinfección', 'Desinfección completa del interior del vehículo con productos antimicrobianos.', 25.00);

-- Proveedores (manteniendo los existentes)
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

-- Proveedores adicionales
INSERT IGNORE INTO Proveedores (nombre, numero, correo, direccion)
VALUES ('Distribuidora Central', '55510006', 'central@distribuidora.com', 'Av. Industrial 789');

INSERT IGNORE INTO Proveedores (nombre, numero, correo, direccion)
VALUES ('Químicos del Norte', '55510007', 'ventas@quimicos.com', 'Zona Industrial 456');

-- Empleados
INSERT IGNORE INTO Empleados (nombre, apellido, edad, disponibilidad, sueldo, fecha_contratacion, correo, telefono, cargo, codigo_administrador)
VALUES ('Fernando', 'García', 28, true, 1200.00, '2023-01-15', 'fernando.garcia@carwash.com', '11111111', 'Lavador Senior', 1);

INSERT IGNORE INTO Empleados (nombre, apellido, edad, disponibilidad, sueldo, fecha_contratacion, correo, telefono, cargo, codigo_administrador)
VALUES ('Carmen', 'López', 32, true, 1000.00, '2023-02-01', 'carmen.lopez@carwash.com', '22222222', 'Lavador', 1);

INSERT IGNORE INTO Empleados (nombre, apellido, edad, disponibilidad, sueldo, fecha_contratacion, correo, telefono, cargo, codigo_administrador)
VALUES ('Diego', 'Moreno', 25, true, 900.00, '2023-03-10', 'diego.moreno@carwash.com', '33333333', 'Asistente', 2);

INSERT IGNORE INTO Empleados (nombre, apellido, edad, disponibilidad, sueldo, fecha_contratacion, correo, telefono, cargo, codigo_administrador)
VALUES ('Isabella', 'Jiménez', 29, true, 1100.00, '2023-01-20', 'isabella.jimenez@carwash.com', '44444444', 'Lavador', 2);

INSERT IGNORE INTO Empleados (nombre, apellido, edad, disponibilidad, sueldo, fecha_contratacion, correo, telefono, cargo, codigo_administrador)
VALUES ('Andrés', 'Torres', 35, false, 1300.00, '2022-11-05', 'andres.torres@carwash.com', '55555555', 'Supervisor', 3);

INSERT IGNORE INTO Empleados (nombre, apellido, edad, disponibilidad, sueldo, fecha_contratacion, correo, telefono, cargo, codigo_administrador)
VALUES ('Valentina', 'Restrepo', 26, true, 950.00, '2023-04-12', 'valentina.restrepo@carwash.com', '66666666', 'Lavador', 3);

INSERT IGNORE INTO Empleados (nombre, apellido, edad, disponibilidad, sueldo, fecha_contratacion, correo, telefono, cargo, codigo_administrador)
VALUES ('Sebastián', 'Vargas', 31, true, 1050.00, '2023-02-18', 'sebastian.vargas@carwash.com', '77777777', 'Lavador', 4);

INSERT IGNORE INTO Empleados (nombre, apellido, edad, disponibilidad, sueldo, fecha_contratacion, correo, telefono, cargo, codigo_administrador)
VALUES ('Camila', 'Herrera', 24, true, 850.00, '2023-05-01', 'camila.herrera@carwash.com', '88888888', 'Asistente', 4);

-- Reservas
INSERT IGNORE INTO Reservas (codigo_empleado, codigo_cliente, codigo_vehiculo, metodo_pago, fecha, hora, descripcion)
VALUES (1, 1, 1, 'Efectivo', '2024-01-15', 9, 'Lavado completo para automóvil sedan');

INSERT IGNORE INTO Reservas (codigo_empleado, codigo_cliente, codigo_vehiculo, metodo_pago, fecha, hora, descripcion)
VALUES (2, 2, 3, 'Tarjeta', '2024-01-16', 10, 'Servicio premium para camioneta');

INSERT IGNORE INTO Reservas (codigo_empleado, codigo_cliente, codigo_vehiculo, metodo_pago, fecha, hora, descripcion)
VALUES (3, 3, 2, 'Transferencia', '2024-01-17', 11, 'Lavado básico para motocicleta');

INSERT IGNORE INTO Reservas (codigo_empleado, codigo_cliente, codigo_vehiculo, metodo_pago, fecha, hora, descripcion)
VALUES (4, 4, 1, 'Efectivo', '2024-01-18', 14, 'Encerado y lavado exterior');

INSERT IGNORE INTO Reservas (codigo_empleado, codigo_cliente, codigo_vehiculo, metodo_pago, fecha, hora, descripcion)
VALUES (1, 5, 6, 'Tarjeta', '2024-01-19', 15, 'Lavado completo para SUV');

INSERT IGNORE INTO Reservas (codigo_empleado, codigo_cliente, codigo_vehiculo, metodo_pago, fecha, hora, descripcion)
VALUES (6, 6, 4, 'Efectivo', '2024-01-20', 8, 'Servicio básico para microbús');

INSERT IGNORE INTO Reservas (codigo_empleado, codigo_cliente, codigo_vehiculo, metodo_pago, fecha, hora, descripcion)
VALUES (7, 7, 7, 'Transferencia', '2024-01-21', 12, 'Lavado premium para pickup');

INSERT IGNORE INTO Reservas (codigo_empleado, codigo_cliente, codigo_vehiculo, metodo_pago, fecha, hora, descripcion)
VALUES (8, 8, 5, 'Tarjeta', '2024-01-22', 13, 'Lavado exterior para camión');

INSERT IGNORE INTO Reservas (codigo_empleado, codigo_cliente, codigo_vehiculo, metodo_pago, fecha, hora, descripcion)
VALUES (2, 1, 8, 'Efectivo', '2024-01-23', 16, 'Servicio completo para furgoneta');

INSERT IGNORE INTO Reservas (codigo_empleado, codigo_cliente, codigo_vehiculo, metodo_pago, fecha, hora, descripcion)
VALUES (5, 3, 1, 'Tarjeta', '2024-01-24', 9, 'Lavado y aspirado interior');

INSERT IGNORE INTO Empleados
(nombre, apellido, edad, disponibilidad, sueldo, fecha_contratacion, correo, telefono, cargo, codigo_administrador)
VALUES
('Carlos', 'García', 28, TRUE, 3500.50, '2022-03-15', 'carlos.garcia@example.com', '55889977', 'Lavador', 1),

('María', 'López', 32, TRUE, 4200.75, '2021-06-10', 'maria.lopez@example.com', '55776655', 'Recepcionista', 1),

('Pedro', 'Martínez', 25, FALSE, 3100.00, '2023-01-05', 'pedro.martinez@example.com', '55667788', 'Lavador', 2),

('Ana', 'Hernández', 29, TRUE, 4800.20, '2020-11-20', 'ana.hernandez@example.com', '55443322', 'Supervisora', 2),

('Luis', 'Ramírez', 35, TRUE, 5200.00, '2019-09-12', 'luis.ramirez@example.com', '55998877', 'Encargado', 3);


-- Inventarios
INSERT IGNORE INTO Inventarios (costo, nombre, fecha_caducidad, stock, codigo_administrador, codigo_proveedor)
VALUES (150.00, 'Shampoo Automotriz', '2025-12-31', 50, 1, 1);

INSERT IGNORE INTO Inventarios (costo, nombre, fecha_caducidad, stock, codigo_administrador, codigo_proveedor)
VALUES (80.00, 'Cera Líquida', '2026-06-15', 30, 2, 2);

INSERT IGNORE INTO Inventarios (costo, nombre, fecha_caducidad, stock, codigo_administrador, codigo_proveedor)
VALUES (60.00, 'Paño Microfibra', NULL, 100, 3, 3);

INSERT IGNORE INTO Inventarios (costo, nombre, fecha_caducidad, stock, codigo_administrador, codigo_proveedor)
VALUES (200.00, 'Desinfectante', '2025-09-10', 25, 4, 4);

INSERT IGNORE INTO Inventarios (costo, nombre, fecha_caducidad, stock, codigo_administrador, codigo_proveedor)
VALUES (120.00, 'Limpiador de Vidrios', '2026-01-20', 40, 5, 5);
