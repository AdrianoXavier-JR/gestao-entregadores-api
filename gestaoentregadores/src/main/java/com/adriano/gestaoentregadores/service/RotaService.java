package com.adriano.gestaoentregadores.service;

import com.adriano.gestaoentregadores.dto.PontoRotaDTO;
import com.adriano.gestaoentregadores.dto.RotaDTO;
import com.adriano.gestaoentregadores.model.PontoRota;
import com.adriano.gestaoentregadores.model.Rota;
import com.adriano.gestaoentregadores.repository.RotaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RotaService {

    private final RotaRepository rotaRepository;

    public Rota salvar(RotaDTO dto) {
        Rota rota = new Rota();
        rota.setNome(dto.getNome());

        List<PontoRota> pontos = new ArrayList<>();
        for (int i = 0; i < dto.getPontos().size(); i++) {
            PontoRotaDTO pontoDTO = dto.getPontos().get(i);
            PontoRota ponto = new PontoRota();
            ponto.setLatitude(pontoDTO.getLatitude());
            ponto.setLongitude(pontoDTO.getLongitude());
            ponto.setOrdem(i); // Define a ordem automaticamente
            ponto.setRota(rota);
            pontos.add(ponto);
        }

        rota.setPontos(pontos);
        return rotaRepository.save(rota);
    }

    public List<Rota> listarTodas() {
        return rotaRepository.findAll();
    }
}
