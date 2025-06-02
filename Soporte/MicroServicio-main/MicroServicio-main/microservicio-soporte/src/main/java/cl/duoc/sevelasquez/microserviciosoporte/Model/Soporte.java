package cl.duoc.sevelasquez.microserviciosoporte.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
public class Soporte {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "La descripción no puede estar vacía")
    private String descripcion;

    @NotBlank(message = "el estado no puede estar vacío")
    private String estado;
    @NotNull(message = "El usuarioId no puede estar vacío")
    private Long usuarioId;
    @NotBlank(message = "La prioridad no puede estar vacía")
    private String prioridad;
    @NotNull(message = "El correo no puede estar vacío")
    private LocalDateTime fechaCreacion;
}
