package com.murillo.transferenciatokio.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.murillo.transferenciatokio.infrastructure.entities.Transferencia;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public record TransferenciaResponseDTO(Long id,
                                       String contaOrigem,
                                       String contaDestino,
                                       @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "0.00")
                                       Double valorTransferencia,
                                       @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", timezone = "America/Sao_Paulo")
                                       Date dataTransferencia,
                                       @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", timezone = "America/Sao_Paulo")
                                       Date dataAgendamento) {

    public TransferenciaResponseDTO(Transferencia transferencia) {
        this(transferencia.getId(),
                transferencia.getContaOrigem(),
                transferencia.getContaDestino(),
                transferencia.getValorTransferencia(),
                transferencia.getDataTransferencia(),
                transferencia.getDataAgendamento());
    }
}