# Arquitetura

A aplicação segue separação em camadas:
- `model`: documentos MongoDB e tipos incorporados.
- `repository`: interfaces `MongoRepository`.
- `service`: regras de negócio e operações de persistência.
- `controller`: endpoints REST.
- `exception`: respostas padronizadas de erro.

O MongoDB armazena documentos em `maintenance_service_orders`. A aplicação usa `@DocumentReference` para relacionamentos entre documentos independentes. Os tipos incorporados não recebem `@Document`, pois não são collections próprias.
