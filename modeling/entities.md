# Entidades e campos

O projeto utiliza dez entidades principais. Os nomes de coleção estão em português e em `snake_case`.

| Entidade / coleção | Campos principais | Tipos e observações |
|---|---|---|
| Empresa (`empresa`) | `_id`, `name`, `cnpj`, `phone`, `email`, `address` | `_id`: ObjectId; `address`: documento incorporado |
| Setor (`setor`) | `_id`, `name`, `description`, `location`, `companyId` | `location`: documento incorporado; `companyId`: referência |
| Equipamento (`equipamento`) | `_id`, `name`, `assetCode`, `model`, `manufacturer`, `serialNumber`, `installationDate`, `status`, `sectorId` | `installationDate`: Date; `sectorId`: referência |
| Técnico (`tecnico`) | `_id`, `name`, `registration`, `phone`, `email`, `specialties`, `status` | `specialties`: array de strings |
| Ordem de serviço (`ordem_servico`) | `_id`, `code`, `equipmentId`, `technicianId`, `type`, `priority`, `status`, datas, `failure`, `activities`, `parts` | referências para equipamento/técnico/peças; `failure` e itens de `activities`/`parts` incorporados |
| Peça (`peca`) | `_id`, `name`, `code`, `manufacturer`, `unit`, `stockQuantity`, `minimumStock`, `supplierId` | quantidades Int32; `supplierId`: referência |
| Fornecedor (`fornecedor`) | `_id`, `name`, `cnpj`, `phone`, `email`, `address` | `address`: documento incorporado |
| Inspeção (`inspecao`) | `_id`, `equipmentId`, `technicianId`, `inspectionDate`, `status`, `findings`, `observations` | referências; `findings`: array |
| Plano de manutenção (`plano_manutencao`) | `_id`, `name`, `description`, `equipmentId`, `frequencyDays`, `nextMaintenance`, `activities`, `status` | frequência Int32; data Date; atividades em array |
| Histórico de manutenção (`historico_manutencao`) | `_id`, `equipmentId`, `serviceOrderId`, `maintenanceDate`, `maintenanceType`, `description`, `technicianId`, `observations` | referências para documentos independentes |

## Tipos de dados utilizados

- `ObjectId`: identificadores e referências.
- `String`: nomes, códigos, descrições, status e contatos.
- `Date`: datas de instalação, abertura, agendamento, inspeção e manutenção.
- `Boolean`: estado de conclusão das atividades.
- `Int32`: quantidades em estoque, quantidade de peças e frequência em dias.
- `Array`: especialidades, atividades, peças e achados de inspeção.
- Documento incorporado: endereço, localização do setor, falha e itens da ordem de serviço.

## Esquema flexível

Os dois documentos de equipamento têm os mesmos campos principais. O segundo também contém `notes`, demonstrando que documentos de uma mesma coleção podem ter campos opcionais diferentes. Essa flexibilidade é útil quando o campo realmente não se aplica a todos os documentos, mas pode prejudicar a consistência se for usada sem regras. Em um sistema real, seria recomendável validar os campos obrigatórios.
