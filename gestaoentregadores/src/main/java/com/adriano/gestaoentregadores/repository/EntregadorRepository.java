package com.adriano.gestaoentregadores.repository;

import com.adriano.gestaoentregadores.model.Entregador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EntregadorRepository extends JpaRepository<Entregador, Long> {

    @Query(value = """
        SELECT *, (
            6371 * acos(
                cos(radians(:latitude)) * cos(radians(e.latitude)) *
                cos(radians(e.longitude) - radians(:longitude)) +
                sin(radians(:latitude)) * sin(radians(e.latitude))
            )
        ) AS distancia
        FROM entregador e
        WHERE e.status = 'ATIVO'
        ORDER BY distancia ASC
        """, nativeQuery = true)
    List<Entregador> findEntregadoresAtivosMaisProximos(
            @Param("latitude") Double latitude,
            @Param("longitude") Double longitude
    );
}
