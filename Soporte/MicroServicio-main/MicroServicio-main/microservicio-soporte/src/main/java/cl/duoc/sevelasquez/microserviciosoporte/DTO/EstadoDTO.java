package cl.duoc.sevelasquez.microserviciosoporte.DTO;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class EstadoDTO {
    @NotEmpty(message = "el estado es obligatorio")
    private String estado;
}