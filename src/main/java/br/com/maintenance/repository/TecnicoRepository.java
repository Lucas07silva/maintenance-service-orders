package br.com.maintenance.repository;

import br.com.maintenance.model.Tecnico;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.Optional;

public interface TecnicoRepository extends MongoRepository<Tecnico, String> {
    Optional<Tecnico> findByRegistration(String registration);\n    Optional<Tecnico> findByEmail(String email);\n}\n