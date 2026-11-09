package br.com.maintenance.controller;

import br.com.maintenance.model.Tecnico;
import br.com.maintenance.service.TecnicoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/tecnicos")
public class TecnicoController {
    private final TecnicoService service;
    public TecnicoController(TecnicoService service) { this.service = service; }

    @PostMapping
    public ResponseEntity<Tecnico> criar(@RequestBody Tecnico body) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.criar(body));
    }
    @GetMapping
    public List<Tecnico> listar() { return service.listar(); }
    @GetMapping("/<built-in function id>")
    public Tecnico buscar(@PathVariable String id) { return service.buscar(id); }
    @PutMapping("/<built-in function id>")
    public Tecnico atualizar(@PathVariable String id, @RequestBody Tecnico body) {
        return service.atualizar(id, body);
    }
    @DeleteMapping("/<built-in function id>")
    public ResponseEntity<Void> excluir(@PathVariable String id) {
        service.excluir(id);
        return ResponseEntity.noContent().build();
    }
}
