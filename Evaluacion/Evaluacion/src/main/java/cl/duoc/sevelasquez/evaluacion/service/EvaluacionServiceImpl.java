package cl.duoc.sevelasquez.evaluacion.service;

import cl.duoc.sevelasquez.evaluacion.entity.Evaluation;
import cl.duoc.sevelasquez.evaluacion.exception.RecursoNoEncontradoException;
import cl.duoc.sevelasquez.evaluacion.repository.EvaluacionRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EvaluacionServiceImpl implements EvaluacionService {

    private final EvaluacionRepository evaluacionRepository;

    public EvaluacionServiceImpl(EvaluacionRepository evaluacionRepository) {
        this.evaluacionRepository = evaluacionRepository;
    }

    @Override
    public Evaluation guardarEvaluacion(Evaluation evaluacion) {
        return evaluacionRepository.save(evaluacion);
    }

    @Override
    public List<Evaluation> obtenerEvaluacionesPorAsignatura(String asignatura) {
        List<Evaluation> evaluaciones = evaluacionRepository.findByAsignatura(asignatura);
        if (evaluaciones.isEmpty()) {
            throw new RecursoNoEncontradoException("No se encontraron evaluaciones para la asignatura: " + asignatura);
        }
        return evaluaciones;
    }


    @Override
    public Evaluation obtenerEvaluacionPorId(Long id) {
        return evaluacionRepository.findById(id)
                .orElseThrow(() -> new RecursoNoEncontradoException("Evaluación con ID " + id + " no fue encontrada."));
    }




    @Override
    public Evaluation actualizarEvaluacion(Long id, Evaluation evaluacion) {
        Evaluation evaluacionExistente = obtenerEvaluacionPorId(id);
        evaluacionExistente.setNombreAlumno(evaluacion.getNombreAlumno());
        evaluacionExistente.setAsignatura(evaluacion.getAsignatura());
        evaluacionExistente.setNota(evaluacion.getNota());
        return evaluacionRepository.save(evaluacionExistente);
    }


    @Override
    public void eliminarEvaluacion(Long id) {
        evaluacionRepository.deleteById(id);
    }

    @Override
    public List<Evaluation> obtenerTodasLasEvaluaciones() {
        return evaluacionRepository.findAll();
    }
}

