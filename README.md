# Industrial Maintenance Management

Projeto acadêmico de modelagem de dados com MongoDB para gerenciamento de manutenção industrial.

## Funcionalidades representadas

- Cadastro de empresas e setores;
- Cadastro de equipamentos e técnicos;
- Abertura e acompanhamento de ordens de serviço;
- Cadastro de peças e fornecedores;
- Registro de inspeções;
- Planejamento de manutenções preventivas;
- Histórico de manutenções realizadas.

## Requisitos

- MongoDB em execução (local ou remoto);
- MongoDB Shell (`mongosh`).

## Estrutura

```text
maintenance-service-orders/
├── README.md
├── modeling/
│   ├── entities.md
│   └── relationships.md
└── mongodb/
    ├── 01_database.js
    ├── 02_collections.js
    ├── 03_insert_data.js
    ├── 04_queries.js
    └── 05_relationships.js
```

## Como executar

Abra um terminal na raiz do projeto. Para uma instalação local padrão do MongoDB, execute cada script na ordem:

```bash
mongosh mongodb/01_database.js
mongosh mongodb/02_collections.js
mongosh mongodb/03_insert_data.js
mongosh mongodb/04_queries.js
mongosh mongodb/05_relationships.js
```

Os scripts selecionam o banco `industrial_maintenance`. O script `03_insert_data.js` limpa as coleções utilizadas antes de inserir os dados de demonstração, portanto **não o execute em uma base com dados que deseja preservar**.

Para uma instância remota, informe a URI de conexão antes do caminho do arquivo, por exemplo:

```bash
mongosh "SUA_URI_DE_CONEXAO" mongodb/01_database.js
```

## Estratégia de modelagem

O projeto usa `ObjectId` como identificador dos documentos. Entidades que existem de forma independente, como equipamentos, técnicos, fornecedores e peças, ficam em coleções próprias e são referenciadas por ID. Informações que pertencem a um único contexto de leitura, como endereço, atividades executadas e falhas de uma ordem de serviço, são incorporadas ao documento.

Os arquivos de modelagem explicam as entidades, os relacionamentos, as cardinalidades e as justificativas de incorporação ou referência.

## Observação

Este é um projeto acadêmico demonstrativo. Os dados são fictícios e não representam uma aplicação industrial pronta para produção.
