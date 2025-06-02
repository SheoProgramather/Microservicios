package cl.duoc.sevelasquez.microserviciosoporte.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class SoporteRequestDTO {

    @NotBlank(message = "La descripción no puede estar vacía")
    private String descripcion;

    @NotNull(message = "El usuarioId es obligatorio")
    private Long usuarioId;

    @NotBlank(message = "La prioridad no puede estar vacía")

    //agregar validación de si la prioridad es alta, media o baja con regex
    @Pattern(regexp = "^(alta|media|baja)$", message = "La prioridad debe ser alta, media o baja")
    @NotBlank(message = "El estado no puede estar vacío")
    private String prioridad;
}
