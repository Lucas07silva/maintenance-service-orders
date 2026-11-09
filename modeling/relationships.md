# Relacionamentos e decisões de modelagem

## Relacionamentos por referência

| Entidades | Cardinalidade | Implementação |
|---|---|---|
| Empresa — Setor | 1:N | `setor.companyId` referencia `empresa._id` |
| Setor — Equipamento | 1:N | `equipamento.sectorId` referencia `setor._id` |
| Equipamento — Ordem de serviço | 1:N | `ordem_servico.equipmentId` referencia `equipamento._id` |
| Técnico — Ordem de serviço | 1:N | `ordem_servico.technicianId` referencia `tecnico._id` |
| Fornecedor — Peça | 1:N | `peca.supplierId` referencia `fornecedor._id` |
| Equipamento — Inspeção | 1:N | `inspecao.equipmentId` referencia `equipamento._id` |
| Técnico — Inspeção | 1:N | `inspecao.technicianId` referencia `tecnico._id` |
| Equipamento — Plano de manutenção | 1:N no modelo demonstrativo | `plano_manutencao.equipmentId` referencia `equipamento._id` |
| Equipamento — Histórico | 1:N | `historico_manutencao.equipmentId` referencia `equipamento._id` |
| Ordem de serviço — Histórico | 1:0..1 no exemplo; pode ser 1:N conforme a regra de negócio | `historico_manutencao.serviceOrderId` referencia `ordem_servico._id` |
| Ordem de serviço — Peça | N:N | `ordem_servico.parts` incorpora itens com `partId` referenciando `peca._id` |

## Documentos incorporados

1. **Endereço da empresa:** endereço costuma ser consultado junto com a empresa e não precisa de vida independente neste exemplo.
2. **Endereço do fornecedor:** os dados de endereço são lidos junto com o fornecedor.
3. **Localização do setor:** os campos de galpão, andar e área são parte dos dados do setor.
4. **Falha da ordem de serviço:** categoria, sintoma e gravidade descrevem a falha específica daquela ordem.
5. **Atividades da ordem:** cada atividade tem descrição e indicador de conclusão, e pertence àquela ordem.
6. **Peças usadas na ordem:** a quantidade utilizada é específica para a ordem; por isso o item é incorporado, mas `partId` mantém referência à peça cadastrada.

## Justificativas

- **Incorporar** quando os dados são pequenos, pertencem a um documento pai e normalmente são consultados juntos.
- **Referenciar** quando a entidade tem existência independente, pode ser reutilizada em vários registros ou precisa ser atualizada separadamente.
- **Peças em ordens:** o relacionamento é N:N. O array incorporado registra a quantidade usada em cada ordem e a referência aponta para o cadastro central da peça.
- **Histórico separado:** permite consultar manutenções de um equipamento ao longo do tempo sem depender de manter todas as informações históricas dentro do documento do equipamento.
- **Identificadores:** o `_id` de cada documento é um `ObjectId`. Os campos de referência armazenam o mesmo tipo e o mesmo valor do `_id` de destino.

## Exemplos

Uma ordem de serviço armazena `equipmentId` e `technicianId` como `ObjectId`, e o pipeline do arquivo `mongodb/05_relationships.js` usa `$lookup` para recuperar os dados relacionados. O array `activities` incorpora tarefas; o array `parts` incorpora a quantidade usada e referencia a coleção `peca`.

As cardinalidades indicam o modelo proposto para o exercício. Regras reais, como permitir vários fornecedores por peça ou vários planos por equipamento, podem exigir ajustes.
