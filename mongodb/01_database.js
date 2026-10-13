// Seleciona o banco usado no projeto.
// O MongoDB cria o banco fisicamente quando os primeiros dados são gravados.
db = db.getSiblingDB("industrial_maintenance");

print("Banco selecionado: " + db.getName());

