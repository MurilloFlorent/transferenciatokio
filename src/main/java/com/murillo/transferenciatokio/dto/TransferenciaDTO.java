package com.murillo.transferenciatokio.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;

public record TransferenciaDTO(String contaOrigem,
                               String contaDestino,
                               @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "0.00")
                               Double valorTransferencia,
                               @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "America/Sao_Paulo")
                               Date dataTransferencia) {
}