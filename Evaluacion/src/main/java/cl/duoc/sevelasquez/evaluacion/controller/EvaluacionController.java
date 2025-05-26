package cl.duoc.sevelasquez.evaluacion.controller;

import cl.duoc.sevelasquez.evaluacion.entity.Evaluation;
import cl.duoc.sevelasquez.evaluacion.service.EvaluacionService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/evaluaciones")
public class EvaluacionController {

    private final EvaluacionService evaluacionService;

    public EvaluacionController(EvaluacionService evaluacionService) {
        this.evaluacionService = evaluacionService;
    }

    @PostMapping
    public Evaluation crearEvaluacion(@Valid @RequestBody Evaluation evaluacion) {
        return evaluacionService.guardarEvaluacion(evaluacion);
    }

    @GetMapping("/asignatura/{asignatura}")
    public List<Evaluation> obtenerPorAsignatura(@PathVariable String asignatura) {
        return evaluacionService.obtenerEvaluacionesPorAsignatura(asignatura);
    }

    @GetMapping
    public List<Evaluation> obtenerTodas() {
        return evaluacionService.obtenerTodasLasEvaluaciones();
    }

    @GetMapping("/{id}")
    public Evaluation obtenerPorId(@PathVariable Long id) {
        return evaluacionService.obtenerEvaluacionPorId(id);
    }

    @PutMapping("/{id}")
    public Evaluation actualizar(@PathVariable Long id, @Valid @RequestBody Evaluation evaluacion) {
        return evaluacionService.actualizarEvaluacion(id, evaluacion);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        evaluacionService.eliminarEvaluacion(id);
    }

}
