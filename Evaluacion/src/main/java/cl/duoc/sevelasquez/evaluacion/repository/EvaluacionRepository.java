package cl.duoc.sevelasquez.evaluacion.repository;

import cl.duoc.sevelasquez.evaluacion.entity.Evaluation;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface EvaluacionRepository extends JpaRepository<Evaluation, Long> {
    List<Evaluation> findByAsignatura(String asignatura);
}
