package br.com.maintenance.repository;

import br.com.maintenance.model.Setor;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.Optional;

public interface SetorRepository extends MongoRepository<Setor, String> {
}\n