-- Administradores
INSERT IGNORE INTO Administradores (apellido, contrasena, correo, nombre, telefono)
VALUES ('Ramírez', 'password123', 'juan.ramirez@example.com', 'Juan', '55443322');

INSERT IGNORE INTO Administradores (apellido, contrasena, correo, nombre, telefono)
VALUES ('González', 'password123', 'maria.gonzalez@example.com', 'María', '44221133');

INSERT IGNORE INTO Administradores (apellido, contrasena, correo, nombre, telefono)
VALUES ('Hernández', 'password123', 'carlos.hernandez@example.com', 'Carlos', '66334455');

INSERT IGNORE INTO Administradores (apellido, contrasena, correo, nombre, telefono)
VALUES ('Pérez', 'password123', 'ana.perez@example.com', 'Ana', '77889900');

INSERT IGNORE INTO Administradores (apellido, contrasena, correo, nombre, telefono)
VALUES ('Martínez', 'password123', 'jose.martinez@example.com', 'José', '99001122');

-- Clientes
INSERT IGNORE INTO Clientes (apellido, apodo, contrasena, correo, direccion, nombre, telefono)
VALUES ('Gómez', 'Carlitos', 'password123', 'carlos.gomez@example.com', 'Av. Central 123', 'Carlos', '12345678');

INSERT IGNORE INTO Clientes (apellido, apodo, contrasena, correo, direccion, nombre, telefono)
VALUES ('Martínez', 'Anita', 'password123', 'ana.martinez@example.com', 'Calle 5 #45', 'Ana', '87654321');

INSERT IGNORE INTO Clientes (apellido, apodo, contrasena, correo, direccion, nombre, telefono)
VALUES ('Fernández', 'Lucho', 'password123', 'luis.fernandez@example.com', 'Bulevar Principal 67', 'Luis', '11223344');

INSERT IGNORE INTO Clientes (apellido, apodo, contrasena, correo, direccion, nombre, telefono)
VALUES ('Silva', 'Paty', 'password123', 'patricia.silva@example.com', 'Av. Los Pinos 89', 'Patricia', '22334455');

INSERT IGNORE INTO Clientes (apellido, apodo, contrasena, correo, direccion, nombre, telefono)
VALUES ('Vega', 'Rober', 'password123', 'roberto.vega@example.com', 'Calle Norte 234', 'Roberto', '33445566');

INSERT IGNORE INTO Clientes (apellido, apodo, contrasena, correo, direccion, nombre, telefono)
VALUES ('Castro', 'Ele', 'password123', 'elena.castro@example.com', 'Av. Sur 156', 'Elena', '44556677');

INSERT IGNORE INTO Clientes (apellido, apodo, contrasena, correo, direccion, nombre, telefono)
VALUES ('Ruiz', 'Migue', 'password123', 'miguel.ruiz@example.com', 'Calle Este 78', 'Miguel', '55667788');

INSERT IGNORE INTO Clientes (apellido, apodo, contrasena, correo, direccion, nombre, telefono)
VALUES ('Morales', 'Sofi', 'password123', 'sofia.morales@example.com', 'Bulevar Oeste 321', 'Sofía', '66778899');

-- Precio Vehículos
INSERT IGNORE INTO precio_vehiculos (tipo_vehiculo, valor) VALUES
('Automóvil', 50.00),
('Motocicleta', 30.00),
('Camioneta', 70.00),
('Microbús', 90.00),
('Camión', 120.00),
('SUV', 85.00),
('Pickup', 75.00),
('Furgoneta', 95.00);

-- Servicios
INSERT IGNORE INTO servicios (descripcion, nombre, precio) VALUES
('Incluye lavado exterior con agua a presión y jabón especial para automóviles.', 'Lavado Básico', 40.00),
('Lavado interior y exterior, aspirado, limpieza de vidrios y aplicación de cera.', 'Lavado Completo', 80.00),
('Lavado completo más limpieza de motor, desinfección con vapor y encerado detallado.', 'Lavado Premium', 120.00),
('Aplicación de cera protectora para mejorar el brillo y proteger la pintura.', 'Encerado', 60.00),
('Aspirado de alfombras, asientos y área de maletero.', 'Aspirado Interior', 30.00),
('Limpieza profunda del compartimiento del motor con productos especializados.', 'Limpieza de Motor', 50.00),
('Restauración y pulido de faros opacos para mejorar la visibilidad.', 'Pulido de Faros', 35.00),
('Desinfección completa del interior del vehículo con productos antimicrobianos.', 'Desinfección', 25.00);

-- Proveedores
INSERT IGNORE INTO Proveedores (correo, direccion, nombre, numero)
VALUES ('proveedor1@example.com', 'Calle 1 #101', 'Proveedor Uno', '55510001');

INSERT IGNORE INTO Proveedores (correo, direccion, nombre, numero)
VALUES ('proveedor2@example.com', 'Calle 2 #202', 'Proveedor Dos', '55510002');

INSERT IGNORE INTO Proveedores (correo, direccion, nombre, numero)
VALUES ('proveedor3@example.com', 'Calle 3 #303', 'Proveedor Tres', '55510003');

INSERT IGNORE INTO Proveedores (correo, direccion, nombre, numero)
VALUES ('proveedor4@example.com', 'Calle 4 #404', 'Proveedor Cuatro', '55510004');

INSERT IGNORE INTO Proveedores (correo, direccion, nombre, numero)
VALUES ('proveedor5@example.com', 'Calle 5 #505', 'Proveedor Cinco', '55510005');

INSERT IGNORE INTO Proveedores (correo, direccion, nombre, numero)
VALUES ('central@distribuidora.com', 'Av. Industrial 789', 'Distribuidora Central', '55510006');

INSERT IGNORE INTO Proveedores (correo, direccion, nombre, numero)
VALUES ('ventas@quimicos.com', 'Zona Industrial 456', 'Químicos del Norte', '55510007');

-- Empleados
INSERT IGNORE INTO Empleados (apellido, cargo, correo, disponibilidad, edad, fecha_contratacion, nombre, sueldo, telefono, codigo_administrador)
VALUES ('García', 'Lavador Senior', 'fernando.garcia@carwash.com', true, 28, '2023-01-15', 'Fernando', 1200.00, '11111111', 1);

INSERT IGNORE INTO Empleados (apellido, cargo, correo, disponibilidad, edad, fecha_contratacion, nombre, sueldo, telefono, codigo_administrador)
VALUES ('López', 'Lavador', 'carmen.lopez@carwash.com', true, 32, '2023-02-01', 'Carmen', 1000.00, '22222222', 1);

INSERT IGNORE INTO Empleados (apellido, cargo, correo, disponibilidad, edad, fecha_contratacion, nombre, sueldo, telefono, codigo_administrador)
VALUES ('Moreno', 'Asistente', 'diego.moreno@carwash.com', true, 25, '2023-03-10', 'Diego', 900.00, '33333333', 2);

INSERT IGNORE INTO Empleados (apellido, cargo, correo, disponibilidad, edad, fecha_contratacion, nombre, sueldo, telefono, codigo_administrador)
VALUES ('Jiménez', 'Lavador', 'isabella.jimenez@carwash.com', true, 29, '2023-01-20', 'Isabella', 1100.00, '44444444', 2);

INSERT IGNORE INTO Empleados (apellido, cargo, correo, disponibilidad, edad, fecha_contratacion, nombre, sueldo, telefono, codigo_administrador)
VALUES ('Torres', 'Supervisor', 'andres.torres@carwash.com', false, 35, '2022-11-05', 'Andrés', 1300.00, '55555555', 3);

INSERT IGNORE INTO Empleados (apellido, cargo, correo, disponibilidad, edad, fecha_contratacion, nombre, sueldo, telefono, codigo_administrador)
VALUES ('Restrepo', 'Lavador', 'valentina.restrepo@carwash.com', true, 26, '2023-04-12', 'Valentina', 950.00, '66666666', 3);

INSERT IGNORE INTO Empleados (apellido, cargo, correo, disponibilidad, edad, fecha_contratacion, nombre, sueldo, telefono, codigo_administrador)
VALUES ('Vargas', 'Lavador', 'sebastian.vargas@carwash.com', true, 31, '2023-02-18', 'Sebastián', 1050.00, '77777777', 4);

INSERT IGNORE INTO Empleados (apellido, cargo, correo, disponibilidad, edad, fecha_contratacion, nombre, sueldo, telefono, codigo_administrador)
VALUES ('Herrera', 'Asistente', 'camila.herrera@carwash.com', true, 24, '2023-05-01', 'Camila', 850.00, '88888888', 4);

INSERT IGNORE INTO Empleados (apellido, cargo, correo, disponibilidad, edad, fecha_contratacion, nombre, sueldo, telefono, codigo_administrador)
VALUES ('García', 'Lavador', 'carlos.garcia@example.com', true, 28, '2022-03-15', 'Carlos', 3500.50, '55889977', 1);

INSERT IGNORE INTO Empleados (apellido, cargo, correo, disponibilidad, edad, fecha_contratacion, nombre, sueldo, telefono, codigo_administrador)
VALUES ('López', 'Recepcionista', 'maria.lopez@example.com', true, 32, '2021-06-10', 'María', 4200.75, '55776655', 1);

INSERT IGNORE INTO Empleados (apellido, cargo, correo, disponibilidad, edad, fecha_contratacion, nombre, sueldo, telefono, codigo_administrador)
VALUES ('Martínez', 'Lavador', 'pedro.martinez@example.com', false, 25, '2023-01-05', 'Pedro', 3100.00, '55667788', 2);

INSERT IGNORE INTO Empleados (apellido, cargo, correo, disponibilidad, edad, fecha_contratacion, nombre, sueldo, telefono, codigo_administrador)
VALUES ('Hernández', 'Supervisora', 'ana.hernandez@example.com', true, 29, '2020-11-20', 'Ana', 4800.20, '55443322', 2);

INSERT IGNORE INTO Empleados (apellido, cargo, correo, disponibilidad, edad, fecha_contratacion, nombre, sueldo, telefono, codigo_administrador)
VALUES ('Ramírez', 'Encargado', 'luis.ramirez@example.com', true, 35, '2019-09-12', 'Luis', 5200.00, '55998877', 3);

-- Reservas
INSERT IGNORE INTO Reservas (descripcion, fecha, hora, metodo_pago, codigo_cliente, codigo_empleado, codigo_vehiculo)
VALUES ('Lavado completo para automóvil sedan', '2024-01-15', 9, 'Efectivo', 1, 1, 1);

INSERT IGNORE INTO Reservas (descripcion, fecha, hora, metodo_pago, codigo_cliente, codigo_empleado, codigo_vehiculo)
VALUES ('Servicio premium para camioneta', '2024-01-16', 10, 'Tarjeta', 2, 2, 3);

INSERT IGNORE INTO Reservas (descripcion, fecha, hora, metodo_pago, codigo_cliente, codigo_empleado, codigo_vehiculo)
VALUES ('Lavado básico para motocicleta', '2024-01-17', 11, 'Transferencia', 3, 3, 2);

INSERT IGNORE INTO Reservas (descripcion, fecha, hora, metodo_pago, codigo_cliente, codigo_empleado, codigo_vehiculo)
VALUES ('Encerado y lavado exterior', '2024-01-18', 14, 'Efectivo', 4, 4, 1);

INSERT IGNORE INTO Reservas (descripcion, fecha, hora, metodo_pago, codigo_cliente, codigo_empleado, codigo_vehiculo)
VALUES ('Lavado completo para SUV', '2024-01-19', 15, 'Tarjeta', 5, 1, 6);

INSERT IGNORE INTO Reservas (descripcion, fecha, hora, metodo_pago, codigo_cliente, codigo_empleado, codigo_vehiculo)
VALUES ('Servicio básico para microbús', '2024-01-20', 8, 'Efectivo', 6, 6, 4);

INSERT IGNORE INTO Reservas (descripcion, fecha, hora, metodo_pago, codigo_cliente, codigo_empleado, codigo_vehiculo)
VALUES ('Lavado premium para pickup', '2024-01-21', 12, 'Transferencia', 7, 7, 7);

INSERT IGNORE INTO Reservas (descripcion, fecha, hora, metodo_pago, codigo_cliente, codigo_empleado, codigo_vehiculo)
VALUES ('Lavado exterior para camión', '2024-01-22', 13, 'Tarjeta', 8, 8, 5);

INSERT IGNORE INTO Reservas (descripcion, fecha, hora, metodo_pago, codigo_cliente, codigo_empleado, codigo_vehiculo)
VALUES ('Servicio completo para furgoneta', '2024-01-23', 16, 'Efectivo', 1, 2, 8);

INSERT IGNORE INTO Reservas (descripcion, fecha, hora, metodo_pago, codigo_cliente, codigo_empleado, codigo_vehiculo)
VALUES ('Lavado y aspirado interior', '2024-01-24', 9, 'Tarjeta', 3, 5, 1);

-- Inventarios
INSERT IGNORE INTO Inventarios (costo, fecha_caducidad, nombre, stock, codigo_administrador, codigo_proveedor)
VALUES (150.00, '2025-12-31', 'Shampoo Automotriz', 50, 1, 1);

INSERT IGNORE INTO Inventarios (costo, fecha_caducidad, nombre, stock, codigo_administrador, codigo_proveedor)
VALUES (80.00, '2026-06-15', 'Cera Líquida', 30, 2, 2);

INSERT IGNORE INTO Inventarios (costo, fecha_caducidad, nombre, stock, codigo_administrador, codigo_proveedor)
VALUES (60.00, NULL, 'Paño Microfibra', 100, 3, 3);

INSERT IGNORE INTO Inventarios (costo, fecha_caducidad, nombre, stock, codigo_administrador, codigo_proveedor)
VALUES (200.00, '2025-09-10', 'Desinfectante', 25, 4, 4);

INSERT IGNORE INTO Inventarios (costo, fecha_caducidad, nombre, stock, codigo_administrador, codigo_proveedor)
VALUES (120.00, '2026-01-20', 'Limpiador de Vidrios', 40, 5, 5);