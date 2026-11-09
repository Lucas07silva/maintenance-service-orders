# Roteiro de testes manuais

1. Inicie o MongoDB.
2. Inicie a aplicação.
3. Cadastre um equipamento com `POST /api/equipamentos`.
4. Consulte a lista com `GET /api/equipamentos`.
5. Consulte o registro pelo id retornado.
6. Atualize o registro com PUT.
7. Exclua o registro com DELETE.
8. Repita para técnicos e ordens de serviço.
9. Tente cadastrar novamente o mesmo `assetCode`, `registration` ou `code` e confirme resposta 409.
10. Tente consultar um id inexistente e confirme resposta 404.

Importante: os testes devem ser executados em banco de desenvolvimento, nunca em dados de produção.
