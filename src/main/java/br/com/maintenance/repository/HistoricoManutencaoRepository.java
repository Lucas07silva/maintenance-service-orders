package br.com.maintenance.repository;

import br.com.maintenance.model.HistoricoManutencao;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.Optional;

public interface HistoricoManutencaoRepository extends MongoRepository<HistoricoManutencao, String> {
}\n