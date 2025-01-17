package br.ufrn.event_service.controller;

import br.ufrn.event_service.model.dto.EventoRequest;
import br.ufrn.event_service.model.dto.EventoResponse;
import br.ufrn.event_service.service.EventoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/events")
public class EventoController {

    private final EventoService eventoService;

    public EventoController(EventoService eventoService) {
        this.eventoService = eventoService;
    }

    @PostMapping
    public ResponseEntity<EventoResponse> criaEvento(@RequestBody @Valid EventoRequest evento) {
        return new ResponseEntity<>(eventoService.criaEvento(evento), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<EventoResponse>> listarEventos() {
        return new ResponseEntity<>(eventoService.listarEventos(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EventoResponse> buscaEventoPorId(@PathVariable Long id) {
        return new ResponseEntity<>(eventoService.listaEventoUnico(id), HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<EventoResponse> fechaInscricao(@PathVariable Long id) {
        return new ResponseEntity<>(eventoService.fechaInscricao(id), HttpStatus.OK);
    }
}
