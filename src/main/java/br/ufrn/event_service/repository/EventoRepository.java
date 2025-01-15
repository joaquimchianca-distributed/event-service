package br.ufrn.event_service.repository;

import br.ufrn.event_service.model.Evento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventoRepository extends JpaRepository<Evento, Long> {
}
