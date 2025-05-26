// Evaluation.java
package cl.duoc.sevelasquez.evaluacion.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Evaluation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El nombre del alumno es obligatorio")
    private String nombreAlumno;

    @NotBlank(message = "La asignatura es obligatoria")
    private String asignatura;

    @NotNull(message = "La nota no puede ser nula")
    @DecimalMin(value = "1.0", message = "La nota mínima es 1.0")
    @DecimalMax(value = "7.0", message = "La nota máxima es 7.0")
    private Double nota;
}
