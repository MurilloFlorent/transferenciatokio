package com.murillo.transferenciatokio.infrastructure.entities;

import com.murillo.transferenciatokio.dto.TransferenciaDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "tb_transferencia")
public class Transferencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name = "conta_origem")
    private String contaOrigem;

    @Column(name = "conta_destino")
    private String contaDestino;

    @Column(name = "valor_transferencia")
    private Double valorTransferencia;

    @Column(name = "data_transferencia")
    private Date dataTransferencia;

    @Column(name = "data_agendamento")
    private Date dataAgendamento;

    public Transferencia() {}

    public Transferencia(TransferenciaDTO dto) {
        this.contaOrigem = dto.contaOrigem();
        this.contaDestino = dto.contaDestino();
        this.valorTransferencia = dto.valorTransferencia();
        this.dataTransferencia = dto.dataTransferencia();
        this.dataAgendamento = new Date();
    }

    //ERRO NO LOMBOOK. TIVE QUE FAZER GETTERS E SETTERS

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContaOrigem() {
        return contaOrigem;
    }
    public void setContaOrigem(String contaOrigem) {
        this.contaOrigem = contaOrigem;
    }

    public String getContaDestino() {
        return contaDestino;
    }

    public void setContaDestino(String contaDestino) {
        this.contaDestino = contaDestino;
    }

    public Date getDataAgendamento() {
        return dataAgendamento;
    }

    public Date getDataTransferencia() {
        return dataTransferencia;
    }

    public double getValorTransferencia() {
        return valorTransferencia;
    }

    public void setValorTransferencia(double valorTransferencia) {
        this.valorTransferencia = valorTransferencia;
    }





}