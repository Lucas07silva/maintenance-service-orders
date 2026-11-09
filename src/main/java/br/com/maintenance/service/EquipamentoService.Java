package br.com.maintenance.service;

import br.com.maintenance.model.Equipamento;
import br.com.maintenance.repository.EquipamentoRepository;
import br.com.maintenance.exception.NotFoundException;
import br.com.maintenance.exception.ConflictException;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EquipamentoService {
    private final EquipamentoRepository repository;
    public EquipamentoService(EquipamentoRepository repository) { this.repository = repository; }

    public Equipamento criar(Equipamento item) {
        if (item.getAssetCode() == null || item.getAssetCode().isBlank())
            throw new IllegalArgumentException("O campo assetCode é obrigatório.");
        if (repository.findByAssetCode(item.getAssetCode()).isPresent())
            throw new ConflictException("Código de patrimônio já cadastrado.");
        return repository.save(item);
    }
    public List<Equipamento> listar() { return repository.findAll(); }
    public Equipamento buscar(String id) { return repository.findById(id).orElseThrow(() -> new NotFoundException("Equipamento não encontrado: " + id)); }
    public Equipamento atualizar(String id, Equipamento dados) {
        Equipamento atual = buscar(id);
        dados.setId(atual.getId());
        return repository.save(dados);
    }
    public void excluir(String id) {
        if (!repository.existsById(id)) throw new NotFoundException("Equipamento não encontrado: " + id);
        repository.deleteById(id);
    }
}
