# Implementação

## Entidades
Foram mapeadas dez entidades conforme `modeling/entities.md`: Empresa, Setor, Equipamento, Tecnico, OrdemServico, Peca, Fornecedor, Inspecao, PlanoManutencao e HistoricoManutencao.

## Embedded Documents
`Endereco`, `LocalizacaoSetor`, `Falha`, `Atividade` e `ItemPeca` representam objetos incorporados ou itens de arrays dentro dos documentos principais.

## References
`@DocumentReference` foi utilizado para associar documentos independentes. A aplicação deve validar a existência dos documentos referenciados antes de persistir operações que dependam deles.

## CRUD
CRUD completo inicial disponível para Equipamento, Tecnico e OrdemServico.

## Regras de negócio implementadas
1. Não permitir duplicidade de código de patrimônio de equipamento.
2. Não permitir duplicidade de matrícula de técnico nem e-mail já cadastrado.
3. Não permitir código duplicado de ordem de serviço e exigir equipamento associado.

## Limitações para completar
- Acrescentar validação de existência de todas as referências (Setor, Empresa, Técnico, Peça etc.) nos services.
- Acrescentar regras de transição de status e controle de estoque das peças.
- Criar testes de integração com MongoDB e documentação de exemplos de requisição/resposta.
- Criar endpoints para as outras sete entidades se a equipe optar por CRUD para todas.
