package cl.duoc.sevelasquez.microserviciosoporte.ExceptionHandlerController;


public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String mensaje) {
        super(mensaje);
    }
}
