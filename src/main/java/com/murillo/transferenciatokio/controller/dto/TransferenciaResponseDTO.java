package com.murillo.transferenciatokio.controller.dto;

import com.murillo.transferenciatokio.infrastructure.entities.Transferencia;

import java.util.Date;

public record TransferenciaResponseDTO(Long id, String contaOrigem, String contaDestino, Double valorTransferencia, Date dataTransferencia, Date dataAgendamento) {

    public TransferenciaResponseDTO(Transferencia transferencia) {
        this(transferencia.getId(),
                transferencia.getContaOrigem(),
                transferencia.getContaDestino(),
                transferencia.getValorTransferencia(),
                transferencia.getDataTransferencia(),
                transferencia.getDataAgendamento());
    }
}