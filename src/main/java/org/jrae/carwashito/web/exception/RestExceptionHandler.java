package org.jrae.carwashito.web.exception;


import org.jrae.carwashito.dominio.exception.*;
import org.jrae.carwashito.dominio.exception.Error;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class RestExceptionHandler {
    @ExceptionHandler(AdministradorYaExisteException.class)
    public ResponseEntity<Error> handleException(AdministradorYaExisteException ex){
        Error error = new Error("administrador_ya_existe", ex.getMessage());
        return ResponseEntity.badRequest().body(error);
    }

    @ExceptionHandler(AdministradorNoExisteException.class)
    public ResponseEntity<Error> handleException(AdministradorNoExisteException ex){
        Error error = new Error("administrador_no_existe", ex.getMessage());
        return ResponseEntity.badRequest().body(error);
    }

    @ExceptionHandler(ClienteYaExisteException.class)
    public ResponseEntity<Error> handleException(ClienteYaExisteException ex){
        Error error = new Error("cliente_ya_existe", ex.getMessage());
        return ResponseEntity.badRequest().body(error);
    }

    @ExceptionHandler(ClienteNoExisteException.class)
    public ResponseEntity<Error> handleException(ClienteNoExisteException ex){
        Error error = new Error("cliente_no_existe", ex.getMessage());
        return ResponseEntity.badRequest().body(error);
    }

    @ExceptionHandler(EmpleadoYaExisteException.class)
    public ResponseEntity<Error> handleException(EmpleadoYaExisteException ex){
        Error error = new Error("empleado_ya_existe", ex.getMessage());
        return ResponseEntity.badRequest().body(error);
    }

    @ExceptionHandler(EmpleadoNoExisteException.class)
    public ResponseEntity<Error> handleException(EmpleadoNoExisteException ex){
        Error error = new Error("empleado_no_existe", ex.getMessage());
        return ResponseEntity.badRequest().body(error);
    }

    @ExceptionHandler(InventarioYaExisteException.class)
    public ResponseEntity<Error> handleException(InventarioYaExisteException ex){
        Error error = new Error("inventario_ya_existe", ex.getMessage());
        return ResponseEntity.badRequest().body(error);
    }

    @ExceptionHandler(InventarioNoExisteException.class)
    public ResponseEntity<Error> handleException(InventarioNoExisteException ex){
        Error error = new Error("inventario_no_existe", ex.getMessage());
        return ResponseEntity.badRequest().body(error);
    }

    @ExceptionHandler(PrecioYaExisteException.class)
    public ResponseEntity<Error> handleException(PrecioYaExisteException ex){
        Error error = new Error("precio_ya_existe", ex.getMessage());
        return ResponseEntity.badRequest().body(error);
    }

    @ExceptionHandler(PrecioVehiculoNoExisteException.class)
    public ResponseEntity<Error> handleException(PrecioVehiculoNoExisteException ex){
        Error error = new Error("precio_no_existe", ex.getMessage());
        return ResponseEntity.badRequest().body(error);
    }

    @ExceptionHandler(ProveedorYaExisteException.class)
    public ResponseEntity<Error> handleException(ProveedorYaExisteException ex){
        Error error = new Error("proveedor_ya_existe", ex.getMessage());
        return ResponseEntity.badRequest().body(error);
    }

    @ExceptionHandler(ProveedorNoExisteException.class)
    public ResponseEntity<Error> handleException(ProveedorNoExisteException ex){
        Error error = new Error("proveedor_no_existe", ex.getMessage());
        return ResponseEntity.badRequest().body(error);
    }

    @ExceptionHandler(ReservaYaExisteException.class)
    public ResponseEntity<Error> handleException(ReservaYaExisteException ex){
        Error error = new Error("reserva_ya_existe", ex.getMessage());
        return ResponseEntity.badRequest().body(error);
    }

    @ExceptionHandler(ReservaNoExisteException.class)
    public ResponseEntity<Error> handleException(ReservaNoExisteException ex){
        Error error = new Error("reserva_no_existe", ex.getMessage());
        return ResponseEntity.badRequest().body(error);
    }

    @ExceptionHandler(ServicioYaExisteException.class)
    public ResponseEntity<Error> handleException(ServicioYaExisteException ex){
        Error error = new Error("servicio_ya_existe", ex.getMessage());
        return ResponseEntity.badRequest().body(error);
    }

    @ExceptionHandler(ServicioNoExisteException.class)
    public ResponseEntity<Error> handleException(ServicioNoExisteException ex){
        Error error = new Error("servicio_no_existe", ex.getMessage());
        return ResponseEntity.badRequest().body(error);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<Error>> handleException(MethodArgumentNotValidException ex){
        List<Error> errores = new ArrayList<>();
        ex.getBindingResult().getFieldErrors().forEach(fieldError -> {
            errores.add(new Error(fieldError.getField(), fieldError.getDefaultMessage()));
        });
        return ResponseEntity.badRequest().body(errores);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Error> handleException(Exception ex){
        Error error = new Error("error-desconocido", ex.getMessage());
        return ResponseEntity.internalServerError().body(error);
    }
}
