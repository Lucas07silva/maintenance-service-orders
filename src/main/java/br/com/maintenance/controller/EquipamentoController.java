
package br.com.maintenance.controller;

import br.com.maintenance.model.Equipamento;
import br.com.maintenance.service.EquipamentoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/equipamentos")
public class EquipamentoController {
    private final EquipamentoService service;
    public EquipamentoController(EquipamentoService service) { this.service = service; }

    @PostMapping
    public ResponseEntity<Equipamento> criar(@RequestBody Equipamento body) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.criar(body));
    }
    @GetMapping
    public List<Equipamento> listar() { return service.listar(); }
    @GetMapping("/<built-in function id>")
    public Equipamento buscar(@PathVariable String id) { return service.buscar(id); }
    @PutMapping("/<built-in function id>")
    public Equipamento atualizar(@PathVariable String id, @RequestBody Equipamento body) {
        return service.atualizar(id, body);
    }
    @DeleteMapping("/<built-in function id>")
    public ResponseEntity<Void> excluir(@PathVariable String id) {
        service.excluir(id);
        return ResponseEntity.noContent().build();
    }
}
