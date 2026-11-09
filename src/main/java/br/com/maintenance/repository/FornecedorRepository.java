package br.com.maintenance.repository;

import br.com.maintenance.model.Fornecedor;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.Optional;

public interface FornecedorRepository extends MongoRepository<Fornecedor, String> {
}\n