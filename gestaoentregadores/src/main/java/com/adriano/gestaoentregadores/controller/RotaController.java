package com.adriano.gestaoentregadores.controller;

import com.adriano.gestaoentregadores.dto.RotaDTO;
import com.adriano.gestaoentregadores.model.Rota;
import com.adriano.gestaoentregadores.service.RotaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rotas")
public class RotaController {

    private final RotaService service;

    public RotaController(RotaService service) {
        this.service = service;
    }

    @PostMapping
    public Rota cadastrar(@RequestBody RotaDTO dto) {
        return service.salvar(dto);
    }

    @GetMapping
    public List<Rota> listar() {
        return service.listarTodas();
    }
}
