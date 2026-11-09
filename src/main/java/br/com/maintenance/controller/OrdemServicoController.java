package br.com.maintenance.controller;

import br.com.maintenance.model.OrdemServico;
import br.com.maintenance.service.OrdemServicoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/ordens-servico")
public class OrdemServicoController {
    private final OrdemServicoService service;
    public OrdemServicoController(OrdemServicoService service) { this.service = service; }

    @PostMapping
    public ResponseEntity<OrdemServico> criar(@RequestBody OrdemServico body) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.criar(body));
    }
    @GetMapping
    public List<OrdemServico> listar() { return service.listar(); }
    @GetMapping("/<built-in function id>")
    public OrdemServico buscar(@PathVariable String id) { return service.buscar(id); }
    @PutMapping("/<built-in function id>")
    public OrdemServico atualizar(@PathVariable String id, @RequestBody OrdemServico body) {
        return service.atualizar(id, body);
    }
    @DeleteMapping("/<built-in function id>")
    public ResponseEntity<Void> excluir(@PathVariable String id) {
        service.excluir(id);
        return ResponseEntity.noContent().build();
    }
}
