package br.ufrn.event_service.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;

import java.time.LocalDateTime;

public record EventoRequest(
        @NotBlank(message = "O nome do evento é obrigatório.")
        String nomeEvento,

        @NotNull(message = "A quantidade de participantes é obrigatória.")
        @Min(value = 0, message = "A quantidade de participantes não pode ser negativa.")
        Long qtdParticipantes,

        @NotNull(message = "O número máximo de participantes é obrigatório.")
        @Min(value = 0, message = "O número máximo de participantes não pode ser negativo.")
        Long maxParticipantes,

        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm")
        LocalDateTime dataInicio,

        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm")
        LocalDateTime dataFim,

        Boolean podeInscrever
){}
