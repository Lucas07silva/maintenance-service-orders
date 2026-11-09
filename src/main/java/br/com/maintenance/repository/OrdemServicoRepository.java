package br.com.maintenance.repository;

import br.com.maintenance.model.OrdemServico;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.Optional;

public interface OrdemServicoRepository extends MongoRepository<OrdemServico, String> {
    Optional<OrdemServico> findByCode(String code);\n}\n