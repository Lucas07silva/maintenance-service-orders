Collections:

db = db.getSiblingDB("industrial_maintenance");

const collections = [
  "empresa",
  "setor",
  "equipamento",
  "tecnico",
  "ordem_servico",
  "peca",
  "fornecedor",
  "inspecao",
  "plano_manutencao",
  "historico_manutencao"
];

collections.forEach((name) => {
  if (!db.getCollectionNames().includes(name)) {
    db.createCollection(name);
    print("Coleção criada: " + name);
  } else {
    print("Coleção já existe: " + name);
  }
});

// Criação de índices para evitar códigos repetidos.
db.equipamento.createIndex({ assetCode: 1 }, { unique: true });
db.tecnico.createIndex({ registration: 1 }, { unique: true });
db.ordem_servico.createIndex({ code: 1 }, { unique: true });
db.peca.createIndex({ code: 1 }, { unique: true });

print("Coleções e índices verificados.");
