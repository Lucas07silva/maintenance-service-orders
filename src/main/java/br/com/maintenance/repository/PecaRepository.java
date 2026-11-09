package br.com.maintenance.repository;

import br.com.maintenance.model.Peca;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.Optional;

public interface PecaRepository extends MongoRepository<Peca, String> {
}\n