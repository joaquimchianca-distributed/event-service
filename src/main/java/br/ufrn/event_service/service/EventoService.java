package br.ufrn.event_service.service;

import br.ufrn.event_service.model.Evento;
import br.ufrn.event_service.model.dto.EventoRequest;
import br.ufrn.event_service.model.dto.EventoResponse;
import br.ufrn.event_service.repository.EventoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventoService {

    private final EventoRepository eventoRepository;

    public EventoService(EventoRepository eventoRepository) {
        this.eventoRepository = eventoRepository;
    }

    public EventoResponse criaEvento(EventoRequest eventoRequest) {
        Evento novoEvento = Evento.builder()
                .nomeEvento(eventoRequest.nomeEvento())
                .maxParticipantes(eventoRequest.maxParticipantes())
                .qtdParticipantes(eventoRequest.qtdParticipantes())
                .dataInicio(eventoRequest.dataInicio())
                .dataFim(eventoRequest.dataFim())
                .podeInscrever(eventoRequest.podeInscrever())
                .build();
        Evento eventoSalvo = eventoRepository.save(novoEvento);
        return new EventoResponse(eventoSalvo);
    }

    public List<EventoResponse> listarEventos() {
        List<Evento> eventos = eventoRepository.findAll();
        List<EventoResponse> resposta = eventos
                .stream().map( evento -> new EventoResponse(evento))
                .toList();
        return resposta;
    }

    public EventoResponse listaEventoUnico(Long id) {
       Evento evento = eventoRepository.getReferenceById(id);
       return new EventoResponse(evento);
    }

    public EventoResponse fechaInscricao(Long id) {
        Evento evento = eventoRepository.getReferenceById(id);
        evento.setPodeInscrever(false);
        Evento eventoSalvo = eventoRepository.save(evento);
        return new EventoResponse(eventoSalvo);
    }
}
