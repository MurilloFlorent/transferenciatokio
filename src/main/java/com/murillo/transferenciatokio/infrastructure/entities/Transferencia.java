package com.murillo.transferenciatokio.infrastructure.entities;

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

}