package com.adriano.gestaoentregadores.repository;

import com.adriano.gestaoentregadores.model.Entregador;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EntregadorRepository extends JpaRepository<Entregador, Long> {
}
