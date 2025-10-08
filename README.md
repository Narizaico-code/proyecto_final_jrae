# Endpoints de la API

---

## Índice

- [Administradores](#administradores)
- [Clientes](#clientes)
- [Empleados](#empleados)
- [Inventarios](#inventarios)
- [PrecioVehiculos](#preciovehiculos)
- [Proveedores](#proveedores)
- [Reservas](#reservas)
- [Servicios](#servicios)

---

## Administradores

- **Listar todos**  
	(Método GET) `http://localhost:8083/carwashito/api/v1/administradores`

- **Listar por ID**  
	(Método GET) `http://localhost:8083/carwashito/api/v1/administradores/{ID}`

- **Guardar administrador**  
	(Método POST) `http://localhost:8083/carwashito/api/v1/administradores`  
	JSON:
	```json
	{
		"name": "string",
		"lastName": "string",
		"email": "string",
		"phoneNumber": "string"
	}
	```

- **Editar un administrador**  
	(Método PUT) `http://localhost:8083/carwashito/api/v1/administradores/{ID a editar}`  
	JSON:
	```json
	{
		"name": "string",
		"lastName": "string",
		"email": "string",
		"phoneNumber": "string"
	}
	```

- **Eliminar por ID**  
	(Método DELETE) `http://localhost:8083/carwashito/api/v1/administradores/{ID a eliminar}`

---

## Clientes

- **Listar todos**  
	(Método GET) `http://localhost:8083/carwashito/api/v1/clientes`

- **Listar por ID**  
	(Método GET) `http://localhost:8083/carwashito/api/v1/clientes/{ID}`

- **Guardar cliente**  
	(Método POST) `http://localhost:8083/carwashito/api/v1/clientes`  
	JSON:
	```json
	{
		"name": "string",
		"lastName": "string",
		"nickname": "string",
		"email": "string",
		"phoneNumber": "string",
		"address": "string"
	}
	```

- **Editar un cliente**  
	(Método PUT) `http://localhost:8083/carwashito/api/v1/clientes/{ID a editar}`  
	JSON:
	```json
	{
		"name": "string",
		"lastName": "string",
		"nickname": "string",
		"email": "string",
		"phoneNumber": "string",
		"address": "string"
	}
	```

- **Eliminar por ID**  
	(Método DELETE) `http://localhost:8083/carwashito/api/v1/clientes/{ID a eliminar}`

---

## Empleados

- **Listar todos**  
	(Método GET) `http://localhost:8083/carwashito/api/v1/empleados`

- **Listar por ID**  
	(Método GET) `http://localhost:8083/carwashito/api/v1/empleados/{ID}`

- **Guardar empleado**  
	(Método POST) `http://localhost:8083/carwashito/api/v1/empleados`  
	JSON:
	```json
	{
		"name": "string",
		"lastName": "string",
		"age": 18,
		"availability": true,
		"salary": 0.0,
		"hireDate": "2024-01-01",
		"email": "string",
		"phoneNumber": "string",
		"position": "string",
		"codigoAdministrador": 1
	}
	```

- **Editar un empleado**  
	(Método PUT) `http://localhost:8083/carwashito/api/v1/empleados/{ID a editar}`  
	JSON:
	```json
	{
		"name": "string",
		"lastName": "string",
		"age": 18,
		"availability": true,
		"salary": 0.0,
		"hireDate": "2024-01-01",
		"email": "string",
		"phoneNumber": "string",
		"position": "string",
		"codigoAdministrador": 1
	}
	```

- **Eliminar por ID**  
	(Método DELETE) `http://localhost:8083/carwashito/api/v1/empleados/{ID a eliminar}`

---

## Inventarios

- **Listar todos**  
	(Método GET) `http://localhost:8083/carwashito/api/v1/inventarios`

- **Listar por ID**  
	(Método GET) `http://localhost:8083/carwashito/api/v1/inventarios/{ID}`

- **Guardar inventario**  
	(Método POST) `http://localhost:8083/carwashito/api/v1/inventarios`  
	JSON:
	```json
	{
		"cost": 1.0,
		"name": "string",
		"expirationDate": "2024-01-01",
		"stock": 1,
		"administratorId": 1,
		"providerId": 1
	}
	```

- **Editar un inventario**  
	(Método PUT) `http://localhost:8083/carwashito/api/v1/inventarios/{ID a editar}`  
	JSON:
	```json
	{
		"cost": 1.0,
		"name": "string",
		"expirationDate": "2024-01-01",
		"stock": 1,
		"administratorId": 1,
		"providerId": 1
	}
	```

- **Eliminar por ID**  
	(Método DELETE) `http://localhost:8083/carwashito/api/v1/inventarios/{ID a eliminar}`

---

## PrecioVehiculos

- **Listar todos**  
	(Método GET) `http://localhost:8083/carwashito/api/v1/precioVehiculo`

- **Listar por ID**  
	(Método GET) `http://localhost:8083/carwashito/api/v1/precioVehiculo/{ID}`

- **Guardar PrecioVehiculo**  
	(Método POST) `http://localhost:8083/carwashito/api/v1/precioVehiculo`  
	JSON:
	```json
	{
		"typeVehicle": "string",
		"value": 1.0
	}
	```

- **Editar un PrecioVehiculo**  
	(Método PUT) `http://localhost:8083/carwashito/api/v1/precioVehiculo/{ID a editar}`  
	JSON:
	```json
	{
		"typeVehicle": "string",
		"value": 1.0
	}
	```

- **Eliminar por ID**  
	(Método DELETE) `http://localhost:8083/carwashito/api/v1/precioVehiculo/{ID a eliminar}`

---

## Proveedores

- **Listar todos**  
	(Método GET) `http://localhost:8083/carwashito/api/v1/proveedores`

- **Listar por ID**  
	(Método GET) `http://localhost:8083/carwashito/api/v1/proveedores/{ID}`

- **Guardar proveedor**  
	(Método POST) `http://localhost:8083/carwashito/api/v1/proveedores`  
	JSON:
	```json
	{
		"name": "string",
		"number": "string",
		"email": "string",
		"address": "string"
	}
	```

- **Editar un proveedor**  
	(Método PUT) `http://localhost:8083/carwashito/api/v1/proveedores/{ID a editar}`  
	JSON:
	```json
	{
		"number": "string",
		"email": "string"
	}
	```

- **Eliminar por ID**  
	(Método DELETE) `http://localhost:8083/carwashito/api/v1/proveedores/{ID a eliminar}`

---

## Reservas

- **Listar todas**  
	(Método GET) `http://localhost:8083/carwashito/api/v1/reservas`

- **Listar por ID**  
	(Método GET) `http://localhost:8083/carwashito/api/v1/reservas/{ID}`

- **Guardar reserva**  
	(Método POST) `http://localhost:8083/carwashito/api/v1/reservas`  
	JSON:
	```json
	{
		"vehicleId": 1,
		"clientId": 1,
		"employeeId": 1,
		"payMethod": "EFECTIVO",
		"date": "2024-12-31",
		"hour": 7,
		"description": "string (min 8 chars)"
	}
	```

- **Editar una reserva**  
	(Método PUT) `http://localhost:8083/carwashito/api/v1/reservas/{ID a editar}`  
	JSON:
	```json
	{
		"vehicleId": 1,
		"clientId": 1,
		"employeeId": 1,
		"payMethod": "EFECTIVO",
		"date": "2024-12-31",
		"hour": 7,
		"description": "string (min 8 chars)"
	}
	```

- **Eliminar por ID**  
	(Método DELETE) `http://localhost:8083/carwashito/api/v1/reservas/{ID a eliminar}`

---

## Servicios

- **Listar todos**  
	(Método GET) `http://localhost:8083/carwashito/api/v1/servicios`

- **Listar por ID**  
	(Método GET) `http://localhost:8083/carwashito/api/v1/servicios/{ID}`

- **Guardar servicio**  
	(Método POST) `http://localhost:8083/carwashito/api/v1/servicios`  
	JSON:
	```json
	{
		"name": "string",
		"description": "string",
		"price": 1.0
	}
	```

- **Editar un servicio**  
	(Método PUT) `http://localhost:8083/carwashito/api/v1/servicios/{ID a editar}`  
	JSON:
	```json
	{
		"name": "string",
		"description": "string",
		"price": 1.0
	}
	```

- **Eliminar por ID**  
	(Método DELETE) `http://localhost:8083/carwashito/api/v1/servicios/{ID a eliminar}`
# proyecto_final
