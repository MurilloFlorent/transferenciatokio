package com.murillo.transferenciatokio.business.services;

import com.murillo.transferenciatokio.dto.TransferenciaDTO;
import com.murillo.transferenciatokio.dto.TransferenciaResponseDTO;
import com.murillo.transferenciatokio.infrastructure.entities.Transferencia;
import com.murillo.transferenciatokio.repositories.TransferenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class TransferenciaService {

    @Autowired
    private TransferenciaRepository transferenciaRepository;

    public TransferenciaResponseDTO agendarTransferencia(TransferenciaDTO transferenciaDTO) {
        Transferencia transferencia = new Transferencia(transferenciaDTO);
        verificaDatas(transferencia.getDataTransferencia(), transferencia.getDataAgendamento());
        Double valorTaxado = calcularTaxa(transferencia.getDataTransferencia(), transferencia.getDataAgendamento(), transferencia.getValorTransferencia());
        transferencia.setValorTransferencia(valorTaxado);

        transferenciaRepository.save(transferencia);

        return new TransferenciaResponseDTO(transferencia);
    }

    public List<TransferenciaResponseDTO> TodasTransferencias() {
        return transferenciaRepository.findAll().stream().map(TransferenciaResponseDTO::new).toList();
    }


    private Double calcularTaxa(Date dataTransferencia, Date dataAgendamento, Double valorTransferencia){
        long diffInMillies = Math.abs(dataTransferencia.getTime() - dataAgendamento.getTime());
        long dias = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);

        double taxaFixa = 0.0;
        double taxaVariavel = 0.0;

        if (dias == 0) {
            taxaFixa = 3.00;
            taxaVariavel = 0.025;
        } else if (dias >= 1 && dias <= 10) {
            taxaFixa = 12.00;
            taxaVariavel = 0.0;
        } else if (dias >= 11 && dias <= 20) {
            taxaVariavel = 0.082;
        } else if (dias >= 21 && dias <= 30) {
            taxaVariavel = 0.069;
        } else if (dias >= 31 && dias <= 40) {
            taxaVariavel = 0.047;
        } else if (dias >= 41 && dias <= 50) {
            taxaVariavel = 0.017;
        } else {
            throw new IllegalArgumentException(" Não há taxa aplicável para esse prazo de transferência.");
        }
        valorTransferencia = valorTransferencia + taxaFixa + (taxaVariavel * valorTransferencia);

        return valorTransferencia;
    };

    private void verificaDatas(Date dataTransferencia, Date dataAgendamento) {
        LocalDate localDataTransferencia = dataTransferencia.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        LocalDate localDataAgendamento = dataAgendamento.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        if (localDataTransferencia.isBefore(localDataAgendamento)) {
            throw new IllegalArgumentException(" A data da transferência não pode ser anterior à data de agendamento.");
        }
    }

}