package com.adriano.gestaoentregadores.dto;

import lombok.Data;

import java.util.List;

@Data
public class RotaDTO {
    private String nome;
    private List<PontoRotaDTO> pontos;
}
