package com.adriano.gestaoentregadores.controller;

import com.adriano.gestaoentregadores.model.Entregador;
import com.adriano.gestaoentregadores.model.EntregadorCreateDTO;
import com.adriano.gestaoentregadores.service.EntregadorService;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/entregadores")
public class EntregadorController {


    private final EntregadorService service;

    public EntregadorController(EntregadorService service) {
        this.service = service;
    }

    @GetMapping
    public List<Entregador> listar() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public Entregador buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PostMapping
    public Entregador salvar(@RequestBody EntregadorCreateDTO entregador) {
            return service.salvar(entregador);

    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}

