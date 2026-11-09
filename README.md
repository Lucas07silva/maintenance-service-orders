# Maintenance Service Orders

Sistema acadêmico de gerenciamento de manutenção industrial com Java 21, Spring Boot, Spring Data MongoDB e MongoDB.

## Requisitos
- JDK 21
- Maven 3.9+ (ou Maven Wrapper)
- MongoDB local em `localhost:27017`, ou uma URI configurada em `MONGODB_URI`
- IntelliJ IDEA ou outra IDE Java

## Executar
1. Inicie o MongoDB.
2. Abra o projeto pelo `pom.xml` no IntelliJ.
3. Execute `MaintenanceServiceOrdersApplication`.
4. A API ficará disponível em `http://localhost:8080`.

No Windows PowerShell, também é possível executar:
```powershell
.\mvnw.cmd spring-boot:run
```
No Linux/macOS:
```bash
./mvnw spring-boot:run
```

## Configuração
A URI padrão está em `src/main/resources/application.properties`:
`mongodb://localhost:27017/maintenance_service_orders`

Para outro servidor, defina a variável de ambiente `MONGODB_URI`. Não publique credenciais no GitHub.

## Entidades
Empresa, Setor, Equipamento, Técnico, OrdemServico, Peça, Fornecedor, Inspeção, PlanoManutencao e HistoricoManutencao.

## Estratégias
Endereços, localização de setor, falha e atividades são documentos incorporados. Os relacionamentos entre entidades independentes usam `@DocumentReference`. Em `OrdemServico`, a lista de peças incorpora quantidade e mantém referência ao cadastro central da peça.

## Endpoints CRUD implementados
- `/api/equipamentos`
- `/api/tecnicos`
- `/api/ordens-servico`

Cada rota possui POST, GET, GET por id, PUT por id e DELETE por id.

## Observação acadêmica
Este projeto é uma base funcional inicial gerada a partir da modelagem existente. Antes da entrega, execute os testes, valide a conexão com o MongoDB, complemente regras de negócio e demonstre as chamadas no Insomnia/Postman. As demais entidades possuem mapeamento e repositories; seus endpoints CRUD podem ser adicionados conforme a evolução do trabalho.
