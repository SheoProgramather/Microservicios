package cl.duoc.sevelasquez.microserviciosoporte.Service;

import cl.duoc.sevelasquez.microserviciosoporte.DTO.SoporteRequestDTO;
import cl.duoc.sevelasquez.microserviciosoporte.DTO.UsuarioDTO;
import cl.duoc.sevelasquez.microserviciosoporte.ExceptionHandlerController.ResourceNotFoundException;
import cl.duoc.sevelasquez.microserviciosoporte.Model.Soporte;
import cl.duoc.sevelasquez.microserviciosoporte.Repository.SoporteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SoporteService {


    private final SoporteRepository soporteRepository;

    public List<Soporte> obtenerTodas() {
        return soporteRepository.findAll();
    }

    public Soporte ObtenerSoportePorId(Long id) {
        Optional<Soporte> soporteOpt = soporteRepository.findById(id);
        if (soporteOpt.isEmpty()) {
            throw new ResourceNotFoundException("Ticket de soporte no encontrado");
        }
        return soporteOpt.get();
    }

    public Soporte crear(SoporteRequestDTO dto) {

        Soporte soporte = new Soporte();
        soporte.setDescripcion(dto.getDescripcion());
        soporte.setUsuarioId(dto.getUsuarioId());
        soporte.setPrioridad(dto.getPrioridad());
        soporte.setFechaCreacion(LocalDateTime.now());
        soporte.setEstado("PENDIENTE");

        return soporteRepository.save(soporte);
    }

    public void eliminar(Long id) {
        ObtenerSoportePorId(id);
        soporteRepository.deleteById(id);
    }

    public Soporte actualizarEstado(Long id, String nuevoEstado) {
        Soporte soporte = soporteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Soporte no encontrado"));
        if (nuevoEstado == null || nuevoEstado.isEmpty()) {
            throw new IllegalArgumentException("El nuevo estado no puede ser nulo o vacío");
        }

        soporte.setEstado(nuevoEstado);
        soporteRepository.save(soporte);
        return soporte;
    }
    @Autowired
    private RestTemplate restTemplate;

    public UsuarioDTO obtenerDatosUsuario(Long usuarioId) {
        String url = "http://localhost:8080/api/usuarios/" + usuarioId;
        return restTemplate.getForObject(url, UsuarioDTO.class);
    }




}
