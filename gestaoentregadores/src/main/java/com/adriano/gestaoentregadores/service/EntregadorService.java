package com.adriano.gestaoentregadores.service;

import com.adriano.gestaoentregadores.model.Entregador;
import com.adriano.gestaoentregadores.model.EntregadorCreateDTO;
import com.adriano.gestaoentregadores.repository.EntregadorRepository;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class EntregadorService {


    private final EntregadorRepository repository;

    public EntregadorService(EntregadorRepository repository) {
        this.repository = repository;
    }

    public List<Entregador> listarTodos() {
        return repository.findAll();
    }

    public Entregador buscarPorId(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Entregador salvar(EntregadorCreateDTO entregador) {
        Entregador entity = Entregador.builder()
                .nome(entregador.getNome())
                .status(entregador.getStatus())
                .latitude(entregador.getLatitude())
                .longitude(entregador.getLongitude())
                .build();

        return repository.save(entity);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}
