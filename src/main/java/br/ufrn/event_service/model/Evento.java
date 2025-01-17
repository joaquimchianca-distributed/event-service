package br.ufrn.event_service.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Entity(name = "eventos")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Evento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nomeEvento;

    @Column(nullable = false)
    private LocalDateTime dataInicio;

    @Column(nullable = false)
    private LocalDateTime dataFim;

    @Column(nullable = false)
    private Boolean podeInscrever;

    @Column(nullable = false)
    private Long qtdParticipantes;

    @Column(nullable = false)
    private Long maxParticipantes;

    @PrePersist
    public void prePersist() {
        if (dataInicio == null) {
            dataInicio = LocalDateTime.now();
        }
        if (dataFim == null) {
            dataFim = LocalDateTime.now();
        }
        if (podeInscrever == null) {
            podeInscrever = true;
        }
    }
}