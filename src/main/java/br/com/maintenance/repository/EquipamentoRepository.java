package br.com.maintenance.repository;

import br.com.maintenance.model.Equipamento;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.Optional;

public interface EquipamentoRepository extends MongoRepository<Equipamento, String> {
    Optional<Equipamento> findByAssetCode(String assetCode);\n}\n