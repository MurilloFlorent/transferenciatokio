package com.murillo.transferenciatokio.repositories;

import com.murillo.transferenciatokio.infrastructure.entities.Transferencia;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransferenciaRepository extends JpaRepository<Transferencia, Long> {
}