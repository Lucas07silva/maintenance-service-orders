# API REST — exemplos

Base URL: `http://localhost:8080`

## Equipamentos
- `POST /api/equipamentos`
- `GET /api/equipamentos`
- `GET /api/equipamentos/{id}`
- `PUT /api/equipamentos/{id}`
- `DELETE /api/equipamentos/{id}`

Exemplo de corpo (os campos de referência devem usar a estrutura esperada pelo Spring Data):
```json
{
  "name": "Compressor industrial",
  "assetCode": "COMP-001",
  "model": "X200",
  "manufacturer": "Fabricante Exemplo",
  "serialNumber": "SN-1001",
  "installationDate": "2025-04-10",
  "status": "ATIVO",
  "notes": "Equipamento da linha principal"
}
```

## Técnicos
- `POST /api/tecnicos`
- `GET /api/tecnicos`
- `GET /api/tecnicos/{id}`
- `PUT /api/tecnicos/{id}`
- `DELETE /api/tecnicos/{id}`

## Ordens de serviço
- `POST /api/ordens-servico`
- `GET /api/ordens-servico`
- `GET /api/ordens-servico/{id}`
- `PUT /api/ordens-servico/{id}`
- `DELETE /api/ordens-servico/{id}`

## Códigos HTTP
201 criação, 200 consulta/atualização, 204 exclusão, 400 dados inválidos, 404 registro não encontrado, 409 duplicidade.
