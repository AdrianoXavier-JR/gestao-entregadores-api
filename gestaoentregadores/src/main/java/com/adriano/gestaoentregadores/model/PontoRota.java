package com.adriano.gestaoentregadores.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PontoRota {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double latitude;
    private double longitude;
    private int ordem;

    @ManyToOne
    @JoinColumn(name = "rota_id")
    @JsonBackReference
    private Rota rota;
}
