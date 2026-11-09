package br.com.maintenance.repository;

import br.com.maintenance.model.PlanoManutencao;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.Optional;

public interface PlanoManutencaoRepository extends MongoRepository<PlanoManutencao, String> {
}\n