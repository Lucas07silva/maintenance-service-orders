package br.com.maintenance.repository;

import br.com.maintenance.model.Inspecao;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.Optional;

public interface InspecaoRepository extends MongoRepository<Inspecao, String> {
}\n