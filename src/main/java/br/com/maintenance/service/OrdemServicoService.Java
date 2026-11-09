package br.com.maintenance.service;

import br.com.maintenance.model.OrdemServico;
import br.com.maintenance.repository.OrdemServicoRepository;
import br.com.maintenance.exception.NotFoundException;
import br.com.maintenance.exception.ConflictException;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class OrdemServicoService {
    private final OrdemServicoRepository repository;
    public OrdemServicoService(OrdemServicoRepository repository) { this.repository = repository; }

    public OrdemServico criar(OrdemServico item) {
        if (item.getCode() == null || item.getCode().isBlank())
            throw new IllegalArgumentException("O campo code é obrigatório.");
        if (repository.findByCode(item.getCode()).isPresent())
            throw new ConflictException("Código da ordem de serviço já cadastrado.");
        if (item.getEquipment() == null || item.getEquipment().getId() == null)
            throw new IllegalArgumentException("A ordem de serviço precisa informar um equipamento.");
        return repository.save(item);
    }
    public List<OrdemServico> listar() { return repository.findAll(); }
    public OrdemServico buscar(String id) { return repository.findById(id).orElseThrow(() -> new NotFoundException("OrdemServico não encontrado: " + id)); }
    public OrdemServico atualizar(String id, OrdemServico dados) {
        OrdemServico atual = buscar(id);
        dados.setId(atual.getId());
        return repository.save(dados);
    }
    public void excluir(String id) {
        if (!repository.existsById(id)) throw new NotFoundException("OrdemServico não encontrado: " + id);
        repository.deleteById(id);
    }
}
