package br.ufrn.event_service.model.dto;

import br.ufrn.event_service.model.Evento;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public record EventoResponse(
        Long id,
        String nomeEvento,

        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm")
        LocalDateTime dataInicio,

        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm")
        LocalDateTime dataFim,

        Boolean podeInscrever,
        Long qtdParticipantes,
        Long maxParticipantes
) {

    public EventoResponse(Evento evento) {
        this(evento.getId(),
             evento.getNomeEvento(),
             evento.getDataInicio(),
             evento.getDataFim(),
             evento.getPodeInscrever(),
             evento.getQtdParticipantes(),
             evento.getMaxParticipantes());
    }
}
