package cl.duoc.sevelasquez.microserviciosoporte.Controller.response;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MessageResponse {
    private String message;
}