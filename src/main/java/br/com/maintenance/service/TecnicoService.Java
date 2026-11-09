package br.com.maintenance.service;

import br.com.maintenance.model.Tecnico;
import br.com.maintenance.repository.TecnicoRepository;
import br.com.maintenance.exception.NotFoundException;
import br.com.maintenance.exception.ConflictException;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TecnicoService {
    private final TecnicoRepository repository;
    public TecnicoService(TecnicoRepository repository) { this.repository = repository; }

    public Tecnico criar(Tecnico item) {
        if (item.getRegistration() == null || item.getRegistration().isBlank())
            throw new IllegalArgumentException("O campo registration é obrigatório.");
        if (repository.findByRegistration(item.getRegistration()).isPresent())
            throw new ConflictException("Matrícula já cadastrada.");
        if (item.getEmail() != null && repository.findByEmail(item.getEmail()).isPresent())
            throw new ConflictException("E-mail já cadastrado.");
        return repository.save(item);
    }
    public List<Tecnico> listar() { return repository.findAll(); }
    public Tecnico buscar(String id) { return repository.findById(id).orElseThrow(() -> new NotFoundException("Tecnico não encontrado: " + id)); }
    public Tecnico atualizar(String id, Tecnico dados) {
        Tecnico atual = buscar(id);
        dados.setId(atual.getId());
        return repository.save(dados);
    }
    public void excluir(String id) {
        if (!repository.existsById(id)) throw new NotFoundException("Tecnico não encontrado: " + id);
        repository.deleteById(id);
    }
}
