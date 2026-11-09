package br.com.maintenance.repository;

import br.com.maintenance.model.Empresa;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.Optional;

public interface EmpresaRepository extends MongoRepository<Empresa, String> {
}\n