package com.adriano.gestaoentregadores.service;

import com.adriano.gestaoentregadores.model.Entregador;
import com.adriano.gestaoentregadores.model.EntregadorCreateDTO;
import com.adriano.gestaoentregadores.model.Rota;
import com.adriano.gestaoentregadores.repository.EntregadorRepository;
import com.adriano.gestaoentregadores.repository.RotaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EntregadorService {

    private final EntregadorRepository repository;
    private final RotaRepository rotaRepository;

    public EntregadorService(EntregadorRepository repository, RotaRepository rotaRepository) {
        this.repository = repository;
        this.rotaRepository = rotaRepository;
    }

    public List<Entregador> listarTodos() {
        return repository.findAll();
    }

    public Entregador buscarPorId(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Entregador salvar(EntregadorCreateDTO dto) {
        Entregador entity = Entregador.builder()
                .nome(dto.getNome())
                .status(dto.getStatus())
                .latitude(dto.getLatitude())
                .longitude(dto.getLongitude())
                .build();
        return repository.save(entity);
    }

    public Entregador atualizar(Long id, EntregadorCreateDTO dto) {
        Entregador existente = repository.findById(id).orElse(null);
        if (existente == null) {
            return null;
        }
        existente.setNome(dto.getNome());
        existente.setStatus(dto.getStatus());
        existente.setLatitude(dto.getLatitude());
        existente.setLongitude(dto.getLongitude());
        return repository.save(existente);
    }

    public Entregador atualizarLocalizacao(Long id, Double latitude, Double longitude) {
        Entregador entregador = repository.findById(id).orElse(null);
        if (entregador == null) {
            return null;
        }
        entregador.setLatitude(latitude);
        entregador.setLongitude(longitude);
        return repository.save(entregador);
    }

    public List<Entregador> buscarAtivosMaisProximos(Double latitude, Double longitude) {
        return repository.findEntregadoresAtivosMaisProximos(latitude, longitude);
    }

    public Entregador associarRota(Long entregadorId, Rota rota) {
        Entregador entregador = repository.findById(entregadorId).orElse(null);
        if (entregador == null) return null;
        entregador.setRota(rota);
        return repository.save(entregador);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }

    public RotaRepository getRotaRepository() {
        return rotaRepository;
    }
}
