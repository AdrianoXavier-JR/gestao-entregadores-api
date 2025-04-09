package com.adriano.gestaoentregadores.controller;

import com.adriano.gestaoentregadores.model.Entregador;
import com.adriano.gestaoentregadores.model.EntregadorCreateDTO;
import com.adriano.gestaoentregadores.service.EntregadorService;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Entregador> buscarPorId(@PathVariable Long id) {
        Entregador entregador = service.buscarPorId(id);
        return entregador != null ? ResponseEntity.ok(entregador) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public Entregador salvar(@RequestBody EntregadorCreateDTO dto) {
        return service.salvar(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Entregador> atualizar(@PathVariable Long id, @RequestBody EntregadorCreateDTO dto) {
        Entregador atualizado = service.atualizar(id, dto);
        return atualizado != null ? ResponseEntity.ok(atualizado) : ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}/localizacao")
    public ResponseEntity<Entregador> atualizarLocalizacao(@PathVariable Long id,
                                                           @RequestParam Double latitude,
                                                           @RequestParam Double longitude) {
        Entregador atualizado = service.atualizarLocalizacao(id, latitude, longitude);
        return atualizado != null ? ResponseEntity.ok(atualizado) : ResponseEntity.notFound().build();
    }

    @GetMapping("/ativos/proximos")
    public List<Entregador> listarAtivosMaisProximos(@RequestParam Double latitude,
                                                     @RequestParam Double longitude) {
        return service.buscarAtivosMaisProximos(latitude, longitude);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
