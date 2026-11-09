
{
  const database = db.getSiblingDB("maintenance_service_orders");

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

  collections.forEach(nome => database[nome].deleteMany({}));

  const ids = {
    empresa: ObjectId("650000000000000000000001"),
    setor: ObjectId("650000000000000000000002"),
    equipamento: ObjectId("650000000000000000000003"),
    tecnico: ObjectId("650000000000000000000004"),
    ordem: ObjectId("650000000000000000000005"),
    peca1: ObjectId("650000000000000000000006"),
    peca2: ObjectId("650000000000000000000007"),
    fornecedor: ObjectId("650000000000000000000008"),
    inspecao: ObjectId("650000000000000000000009"),
    plano: ObjectId("650000000000000000000010"),
    historico: ObjectId("650000000000000000000011"),
    setor2: ObjectId("650000000000000000000012"),
    equipamento2: ObjectId("650000000000000000000013"),
    tecnico2: ObjectId("650000000000000000000014"),
    ordem2: ObjectId("650000000000000000000015")
  };

  database.empresa.insertOne({
    _id: ids.empresa,
    name: "Indústria Modelo Ltda.",
    cnpj: "12345678000190",
    address: {
      street: "Rua das Indústrias",
      number: 100,
      city: "Feira de Santana",
      state: "BA",
      postalCode: "44000000"
    },
    active: true,
    createdAt: ISODate("2026-01-10T12:00:00Z")
  });

  database.fornecedor.insertOne({
    _id: ids.fornecedor,
    name: "Peças Industriais Bahia",
    cnpj: "98765432000110",
    address: {
      street: "Avenida Comercial",
      number: 250,
      city: "Feira de Santana",
      state: "BA"
    },
    active: true
  });

  database.setor.insertMany([
    {
      _id: ids.setor,
      name: "Produção",
      companyId: ids.empresa,
      location: {
        building: "Bloco A",
        floor: 1
      }
    },
    {
      _id: ids.setor2,
      name: "Utilidades",
      companyId: ids.empresa,
      location: {
        building: "Bloco B",
        floor: 1,
        accessNote: "Acesso autorizado"
      }
    }
  ]);

  database.equipamento.insertMany([
    {
      _id: ids.equipamento,
      name: "Bomba hidráulica",
      serialNumber: "BH-1001",
      sectorId: ids.setor,
      installedAt: ISODate("2024-05-10T12:00:00Z"),
      active: true,
      criticality: "high"
    },
    {
      _id: ids.equipamento2,
      name: "Compressor de ar",
      serialNumber: "CA-2001",
      sectorId: ids.setor2,
      installedAt: ISODate("2023-08-20T12:00:00Z"),
      active: true
    }
  ]);

  database.tecnico.insertMany([
    {
      _id: ids.tecnico,
      name: "Carlos Souza",
      specialty: "Mecânica industrial",
      yearsExperience: Int32(8),
      active: true
    },
    {
      _id: ids.tecnico2,
      name: "Mariana Lima",
      specialty: "Elétrica industrial",
      yearsExperience: Int32(5),
      active: true
    }
  ]);

  database.peca.insertMany([
    {
      _id: ids.peca1,
      name: "Rolamento industrial",
      stockQuantity: Int32(25),
      unitPrice: Decimal128("85.90"),
      supplierId: ids.fornecedor,
      active: true
    },
    {
      _id: ids.peca2,
      name: "Selo mecânico",
      stockQuantity: Int32(12),
      unitPrice: Decimal128("145.50"),
      supplierId: ids.fornecedor,
      active: true
    }
  ]);

  database.ordem_servico.insertMany([
    {
      _id: ids.ordem,
      code: "OS-2026-001",
      equipmentId: ids.equipamento,
      technicianId: ids.tecnico,
      status: "in_progress",
      priority: "high",
      openedAt: ISODate("2026-10-10T09:00:00Z"),
      estimatedCost: Decimal128("450.00"),
      failure: {
        description: "Vazamento de fluido",
        severity: "high",
        detectedAt: ISODate("2026-10-10T09:00:00Z")
      },
      activities: [
        {
          description: "Inspeção inicial",
          completed: true,
          hours: 1.5
        },
        {
          description: "Substituição de componente",
          completed: false,
          hours: 2.0
        }
      ],
      parts: [
        {
          partId: ids.peca1,
          quantity: Int32(2)
        },
        {
          partId: ids.peca2,
          quantity: Int32(1)
        }
      ]
    },
    {
      _id: ids.ordem2,
      code: "OS-2026-002",
      equipmentId: ids.equipamento2,
      technicianId: ids.tecnico2,
      status: "open",
      priority: "medium",
      openedAt: ISODate("2026-10-11T10:00:00Z"),
      estimatedCost: Decimal128("200.00"),
      failure: {
        description: "Ruído acima do normal",
        severity: "medium"
      },
      activities: [],
      parts: []
    }
  ]);

  database.inspecao.insertOne({
    _id: ids.inspecao,
    equipmentId: ids.equipamento,
    technicianId: ids.tecnico,
    inspectionDate: ISODate("2026-10-09T14:00:00Z"),
    result: "approved_with_observation",
    approved: true,
    observations: [
      "Verificar vedação",
      "Reavaliar em 30 dias"
    ]
  });

  database.plano_manutencao.insertOne({
    _id: ids.plano,
    equipmentId: ids.equipamento,
    frequencyDays: Int32(30),
    nextDate: ISODate("2026-11-09T12:00:00Z"),
    active: true,
    procedures: [
      "Verificar vedação",
      "Lubrificar componentes",
      "Conferir vibração"
    ]
  });

  database.historico_manutencao.insertOne({
    _id: ids.historico,
    equipmentId: ids.equipamento,
    serviceOrderId: ids.ordem,
    technicianId: ids.tecnico,
    performedAt: ISODate("2026-10-10T10:30:00Z"),
    description: "Inspeção e início da manutenção corretiva",
    durationHours: 1.5,
    result: "in_progress"
  });

  print("Dados inseridos com sucesso.");
}
