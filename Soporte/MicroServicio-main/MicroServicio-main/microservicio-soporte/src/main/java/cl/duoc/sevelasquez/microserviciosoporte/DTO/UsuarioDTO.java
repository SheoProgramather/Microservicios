package cl.duoc.sevelasquez.microserviciosoporte.DTO;

import lombok.Data;

@Data
public class UsuarioDTO {
    private Long id;
    private String nombre;
    private String correo;
}
