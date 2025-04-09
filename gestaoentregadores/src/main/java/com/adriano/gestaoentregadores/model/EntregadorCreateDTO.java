package com.adriano.gestaoentregadores.model;

import lombok.Data;


@Data
public class EntregadorCreateDTO {
    private String nome;
    private StatusEntregador status;
    private Double latitude;
    private Double longitude;
}
