# Sistema de Gerenciamento de Ordens de Serviço e Manutenção

![Java](https://img.shields.io/badge/Java-21-orange)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.x-brightgreen)
![MongoDB](https://img.shields.io/badge/Database-MongoDB-green)
![Maven](https://img.shields.io/badge/Build-Maven-blue)
![Status](https://img.shields.io/badge/Status-Desenvolvimento-yellow)

## 1. Sobre o projeto

O **Sistema de Gerenciamento de Ordens de Serviço e Manutenção** é um projeto acadêmico desenvolvido com Java, Spring Boot, Spring Data MongoDB e MongoDB.

O objetivo é desenvolver uma aplicação capaz de organizar e gerenciar informações relacionadas à manutenção de equipamentos industriais, permitindo controlar equipamentos, técnicos, peças, fornecedores, inspeções, planos de manutenção e ordens de serviço.

O sistema foi pensado para representar o funcionamento de um ambiente industrial, no qual é necessário registrar falhas, acompanhar manutenções, controlar peças utilizadas e manter um histórico das intervenções realizadas.

Além de aplicar conceitos de programação orientada a objetos, o projeto utiliza um banco de dados NoSQL, relacionamentos entre documentos, documentos embutidos e desenvolvimento de uma API REST.

## 2. Objetivos

- Desenvolver uma API REST utilizando Java e Spring Boot.
- Aplicar conceitos de orientação a objetos.
- Implementar persistência de dados utilizando MongoDB.
- Modelar entidades e seus relacionamentos.
- Utilizar documentos embutidos e referências entre coleções.
- Implementar operações CRUD.
- Aplicar validações e regras de negócio.
- Garantir maior integridade e consistência dos dados.
- Realizar testes utilizando Insomnia e testes automatizados.

## 3. Tecnologias utilizadas

| Tecnologia | Finalidade |
|---|---|
| Java 21 | Linguagem de programação |
| Spring Boot | Estrutura principal da aplicação |
| Spring Web | Criação dos endpoints REST |
| Spring Data MongoDB | Comunicação com o banco de dados |
| MongoDB | Banco de dados NoSQL |
| Maven | Gerenciamento de dependências |
| Jakarta Validation | Validação dos dados |
| JUnit | Testes automatizados |
| Mockito | Simulação de dependências nos testes |
| IntelliJ IDEA | Ambiente de desenvolvimento |
| Insomnia | Testes das requisições HTTP |
| Git e GitHub | Versionamento e hospedagem do código |

## 4. Arquitetura do sistema

O projeto utiliza uma arquitetura em camadas, separando as responsabilidades de cada parte da aplicação.

A comunicação entre as camadas acontece da seguinte maneira:

```text
             USUÁRIO / INSOMNIA
                     |
                     v
               API REST
                     |
                     v
                CONTROLLER
                     |
                     v
                 SERVICE
                     |
                     v
                REPOSITORY
                     |
                     v
                  MONGODB
```

### 4.1 Controller

O Controller é responsável por receber as requisições HTTP.

Ele identifica qual operação o usuário deseja realizar, recebe os dados enviados e encaminha a solicitação para a camada Service.

Exemplo de operações:

- Cadastrar um equipamento.
- Consultar um técnico.
- Atualizar uma ordem de serviço.
- Excluir um registro.

O Controller também define os códigos de resposta HTTP.

### 4.2 Service

O Service contém a lógica de negócio da aplicação.

É nessa camada que são realizadas as validações mais importantes antes de salvar ou modificar informações.

Exemplos:

- Verificar se um equipamento existe.
- Verificar se um técnico está cadastrado.
- Impedir uma ordem de serviço com dados inválidos.
- Verificar se uma operação pode ser realizada.

A separação dessa lógica permite manter os Controllers mais simples e organizados.

### 4.3 Repository

O Repository é responsável pela comunicação com o MongoDB.

Com o Spring Data MongoDB, podemos utilizar interfaces que herdam de `MongoRepository`.

Isso disponibiliza operações como:

- `save()` — salvar ou atualizar documentos.
- `findAll()` — consultar todos os registros.
- `findById()` — consultar por identificador.
- `deleteById()` — excluir por identificador.
- `existsById()` — verificar se um registro existe.

### 4.4 Model

A camada Model representa as entidades e estruturas de dados utilizadas no sistema.

Cada classe representa uma entidade ou um documento embutido.

As entidades principais são identificadas com `@Document`, enquanto os identificadores são representados por `@Id`.

Outras anotações importantes:

- `@Field`: permite definir o nome de um campo no MongoDB.
- `@DocumentReference`: representa uma referência entre documentos.
- `@NotBlank`: impede campos de texto vazios.
- `@NotNull`: exige que um campo seja informado.
- `@Valid`: ativa as validações dos objetos recebidos, quando utilizado no Controller.

## 5. Modelagem de dados

O sistema possui 10 entidades principais.

| Entidade | Responsabilidade |
|---|---|
| Empresa | Representa a empresa responsável pelo ambiente industrial. |
| Setor | Representa os setores existentes dentro da empresa. |
| Equipamento | Armazena os dados dos equipamentos industriais. |
| Técnico | Representa os profissionais responsáveis pelas manutenções. |
| Ordem de Serviço | Registra solicitações e atividades de manutenção. |
| Peça | Armazena informações sobre peças utilizadas nas manutenções. |
| Fornecedor | Representa os fornecedores de peças e materiais. |
| Inspeção | Registra inspeções realizadas nos equipamentos. |
| Plano de Manutenção | Define informações sobre manutenções planejadas. |
| Histórico de Manutenção | Armazena registros das intervenções realizadas. |

### 5.1 Documentos embutidos

Documentos embutidos são estruturas armazenadas dentro de outro documento no MongoDB.

Eles são úteis quando os dados fazem parte de uma entidade principal e normalmente são consultados junto com ela.

No projeto, alguns exemplos são:

**Endereco**

Representa informações de endereço que podem estar associadas a uma entidade.

**LocalizacaoSetor**

Representa informações relacionadas à localização de um setor.

**Falha**

Armazena informações sobre uma falha identificada em um equipamento.

**Atividade**

Representa uma atividade realizada durante uma manutenção.

**ItemPeca**

Representa uma peça utilizada dentro de uma ordem de serviço, incluindo informações como identificação, quantidade e outros dados definidos pelo modelo.

Exemplo conceitual:

```json
{
  "descricao": "Manutenção preventiva",
  "falha": {
    "descricao": "Falha no sistema de refrigeração",
    "gravidade": "MEDIA"
  }
}
```

Nesse exemplo, `falha` está dentro do documento principal, não sendo necessariamente uma coleção independente.

### 5.2 Referências entre documentos

Diferentemente dos documentos embutidos, as referências permitem que uma entidade esteja armazenada em uma coleção separada.

O documento principal mantém uma referência ao identificador de outro documento.

Exemplos de relacionamentos:

| Entidade de origem | Entidade relacionada | Relacionamento |
|---|---|---|
| Setor | Empresa | Um setor pertence a uma empresa. |
| Equipamento | Setor | Um equipamento pertence a um setor. |
| Ordem de Serviço | Equipamento | Uma ordem de serviço está associada a um equipamento. |
| Ordem de Serviço | Técnico | Uma ordem de serviço pode estar associada a um técnico. |
| Peça | Fornecedor | Uma peça está associada a um fornecedor. |
| Inspeção | Equipamento | Uma inspeção está associada a um equipamento. |
| Plano de Manutenção | Equipamento | Um plano está associado a um equipamento. |
| Histórico de Manutenção | Equipamento | Um histórico registra intervenções em um equipamento. |

**Por que utilizar referências?**

Porque algumas informações precisam existir independentemente e podem ser utilizadas por várias outras entidades.

Por exemplo, um equipamento pode possuir diversas ordens de serviço. Não seria interessante duplicar todos os dados do equipamento dentro de cada ordem.

Assim, armazenamos o equipamento separadamente e utilizamos seu identificador para estabelecer o relacionamento.

## 6. Funcionamento da lógica do sistema

Uma das principais funcionalidades do projeto é o gerenciamento das ordens de serviço.

Para entender a lógica, imagine o seguinte cenário:

Uma máquina industrial apresenta um problema e precisa passar por manutenção.

O funcionamento esperado é:

1. O equipamento já precisa estar cadastrado no sistema.
2. O técnico responsável deve estar cadastrado.
3. Uma ordem de serviço é criada.
4. A ordem recebe a identificação do equipamento e do técnico.
5. São registradas as informações da falha.
6. As atividades necessárias são adicionadas.
7. As peças utilizadas podem ser registradas.
8. A ordem pode ser atualizada durante a manutenção.
9. Após a conclusão, as informações ficam disponíveis para consulta e histórico.

### 6.1 Fluxo de criação de uma ordem de serviço

```text
        SOLICITAÇÃO DE MANUTENÇÃO
                   |
                   v
          RECEBER REQUISIÇÃO
                   |
                   v
       VALIDAR DADOS DA REQUISIÇÃO
                   |
                   v
      VERIFICAR EQUIPAMENTO NO BANCO
                   |
                   v
        VERIFICAR TÉCNICO CADASTRADO
                   |
                   v
       VALIDAR INFORMAÇÕES DA ORDEM
                   |
                   v
       SALVAR ORDEM NO MONGODB
                   |
                   v
          RETORNAR RESPOSTA HTTP
```

Se alguma validação falhar, a operação deve ser interrompida e uma resposta adequada deve ser retornada.

## 7. Regras de negócio e integridade dos dados

As regras de negócio são responsáveis por impedir operações inválidas e manter a consistência das informações.

As regras abaixo representam os controles que devem ser implementados e testados no sistema.

### Regra 1 — Validação de referências

Uma ordem de serviço não deve ser cadastrada com um equipamento ou técnico inexistente.

Antes de salvar a ordem, o Service deve consultar os respectivos Repositories.

Isso evita referências inválidas.

### Regra 2 — Validação de campos obrigatórios

O sistema não deve aceitar informações obrigatórias vazias ou nulas.

Exemplos:

- Nome do equipamento.
- Identificação do técnico.
- Descrição da ordem de serviço.
- Identificação do equipamento relacionado.

Podem ser utilizadas as anotações de validação do Jakarta Validation.

### Regra 3 — Controle de duplicidade

O sistema deve impedir cadastros duplicados quando existir uma regra de unicidade definida.

Por exemplo, o código de identificação de um equipamento não deve ser repetido.

Essa verificação deve acontecer na camada Service e, quando possível, também ser protegida por um índice único no MongoDB.

### Proteção da integridade

A integridade dos dados é protegida por diferentes mecanismos:

- Validação de campos recebidos pela API.
- Verificação de existência de documentos relacionados.
- Regras de negócio implementadas na camada Service.
- Restrições de unicidade quando aplicáveis.
- Tratamento centralizado de exceções.
- Respostas HTTP adequadas para operações inválidas.

## 8. Operações CRUD

CRUD representa as quatro operações fundamentais de manipulação de dados.

| Operação | Significado | Método HTTP |
|---|---|---|
| Create | Criar um registro | POST |
| Read | Consultar registros | GET |
| Update | Atualizar um registro | PUT |
| Delete | Excluir um registro | DELETE |

O sistema deve disponibilizar operações CRUD para pelo menos três entidades principais, conforme os requisitos da atividade.

As entidades escolhidas para esse conjunto de operações são:

- Equipamento.
- Técnico.
- Ordem de Serviço.

### 8.1 Códigos de resposta HTTP

| Código | Significado | Utilização |
|---|---|---|
| 200 | OK | Consulta ou atualização realizada. |
| 201 | Created | Registro criado com sucesso. |
| 204 | No Content | Exclusão realizada sem conteúdo de resposta. |
| 400 | Bad Request | Dados enviados inválidos. |
| 404 | Not Found | Registro não encontrado. |
| 409 | Conflict | Conflito de dados, como duplicidade. |

## 9. Como executar o projeto no computador

### 9.1 Pré-requisitos

Antes de executar o projeto, instale:

1. Java JDK 21.
2. IntelliJ IDEA.
3. MongoDB Community Server.
4. MongoDB Compass (opcional, mas recomendado).
5. Insomnia.

Verifique a instalação do Java:

```powershell
java -version
```

Verifique a instalação do Maven:

```powershell
mvn -version
```

Caso o comando `mvn` não seja reconhecido, verifique se o Maven está instalado e configurado no PATH. Se o projeto possuir Maven Wrapper, também poderá ser utilizado o `mvnw.cmd`.

### 9.2 Configuração do MongoDB

Após instalar o MongoDB, certifique-se de que o serviço esteja em execução.

O endereço local padrão é:

```text
mongodb://localhost:27017
```

O banco utilizado pelo projeto deve ser configurado no arquivo:

```text
src/main/resources/application.properties
```

Exemplo de configuração:

```properties
spring.application.name=maintenance-service-orders

spring.data.mongodb.uri=mongodb://localhost:27017/maintenance_service_orders
```

Caso o arquivo já possua outras configurações, preserve-as e ajuste somente os parâmetros necessários.

O nome do banco utilizado é:

```text
maintenance_service_orders
```

O MongoDB cria o banco e as coleções quando os documentos são inseridos, caso não tenham sido criados anteriormente.

### 9.3 Abrindo o projeto no IntelliJ IDEA

1. Abra o IntelliJ IDEA.
2. Selecione **Open**.
3. Localize a pasta `maintenance-service-orders`.
4. Selecione o arquivo `pom.xml` ou a pasta raiz do projeto.
5. Aguarde o Maven carregar as dependências.
6. Confira se o projeto está utilizando o JDK 21.
7. Aguarde a indexação terminar.

### 9.4 Executando a aplicação

Localize a classe principal:

```text
MaintenanceServiceOrdersApplication.java
```

Ela deve estar dentro do pacote principal do projeto.

Clique com o botão direito na classe e selecione:

```text
Run 'MaintenanceServiceOrdersApplication'
```

Também é possível executar pelo terminal, na pasta que contém o `pom.xml`:

```powershell
mvn spring-boot:run
```

Quando a aplicação iniciar corretamente, o console deverá indicar que o Spring Boot foi iniciado.

A porta padrão da aplicação Spring Boot é:

```text
8080
```

Se nenhuma porta diferente estiver configurada, a API estará disponível em:

```text
http://localhost:8080
```

## 10. Testando a API com Insomnia

O Insomnia permite realizar requisições HTTP e verificar o comportamento da API sem precisar desenvolver uma interface gráfica.

### 10.1 Criando um ambiente

1. Abra o Insomnia.
2. Crie um novo projeto ou Collection.
3. Crie um ambiente chamado `Local`.
4. Configure a variável:

```json
{
  "base_url": "http://localhost:8080"
}
```

A URL-base será utilizada nas requisições.

### 10.2 Exemplo de teste — Equipamentos

Os caminhos abaixo são exemplos de referência. Utilize os caminhos efetivamente definidos nas anotações `@RequestMapping` e nos métodos `@GetMapping`, `@PostMapping`, `@PutMapping` e `@DeleteMapping` do seu Controller.

**Cadastrar equipamento**

Método:

```http
POST
```

URL de referência:

```text
{{ _.base_url }}/api/equipamentos
```

Body → JSON:

```json
{
  "nome": "Compressor Industrial",
  "descricao": "Compressor de ar industrial",
  "codigo": "EQP001"
}
```

Os campos devem ser ajustados conforme os atributos obrigatórios da classe `Equipamento`.

Resposta esperada: HTTP 201 Created.

**Consultar todos os equipamentos**

```http
GET {{ _.base_url }}/api/equipamentos
```

Resposta esperada: HTTP 200 OK.

**Consultar equipamento por ID**

```http
GET {{ _.base_url }}/api/equipamentos/ID_DO_EQUIPAMENTO
```

**Atualizar equipamento**

```http
PUT {{ _.base_url }}/api/equipamentos/ID_DO_EQUIPAMENTO
```

Body → JSON:

```json
{
  "nome": "Compressor Industrial Atualizado",
  "descricao": "Compressor revisado",
  "codigo": "EQP001"
}
```

**Excluir equipamento**

```http
DELETE {{ _.base_url }}/api/equipamentos/ID_DO_EQUIPAMENTO
```

Resposta esperada: HTTP 204 No Content.

### 10.3 Exemplo de teste — Técnicos

**Cadastrar técnico**

```http
POST {{ _.base_url }}/api/tecnicos
```

Body de referência:

```json
{
  "nome": "Carlos Silva",
  "especialidade": "Mecânica"
}
```

**Consultar técnicos**

```http
GET {{ _.base_url }}/api/tecnicos
```

**Consultar técnico por ID**

```http
GET {{ _.base_url }}/api/tecnicos/ID_DO_TECNICO
```

**Atualizar técnico**

```http
PUT {{ _.base_url }}/api/tecnicos/ID_DO_TECNICO
```

**Excluir técnico**

```http
DELETE {{ _.base_url }}/api/tecnicos/ID_DO_TECNICO
```

### 10.4 Exemplo de teste — Ordens de Serviço

A ordem de serviço é a principal entidade de operação do sistema.

Ela relaciona informações do equipamento, técnico, atividades e peças utilizadas.

**Cadastrar ordem de serviço**

```http
POST {{ _.base_url }}/api/ordens-servico
```

Body conceitual:

```json
{
  "descricao": "Manutenção preventiva do compressor",
  "equipamentoId": "ID_DO_EQUIPAMENTO",
  "tecnicoId": "ID_DO_TECNICO"
}
```

Esse JSON é apenas ilustrativo. Os nomes dos campos e os demais atributos devem seguir a estrutura real da classe `OrdemServico`.

**Consultar todas as ordens**

```http
GET {{ _.base_url }}/api/ordens-servico
```

**Consultar uma ordem por ID**

```http
GET {{ _.base_url }}/api/ordens-servico/ID_DA_ORDEM
```

**Atualizar ordem**

```http
PUT {{ _.base_url }}/api/ordens-servico/ID_DA_ORDEM
```

**Excluir ordem**

```http
DELETE {{ _.base_url }}/api/ordens-servico/ID_DA_ORDEM
```

### 10.5 Testando erros e validações

Além de testar operações bem-sucedidas, é importante verificar o comportamento do sistema diante de dados inválidos.

Sugestões:

| Teste | Resultado esperado |
|---|---|
| Cadastrar equipamento sem nome | HTTP 400 |
| Consultar ID inexistente | HTTP 404 |
| Cadastrar código de equipamento duplicado | HTTP 409 |
| Criar ordem com equipamento inexistente | HTTP 400 ou 404, conforme a implementação |
| Atualizar registro inexistente | HTTP 404 |
| Excluir registro inexistente | HTTP 404 |

Os resultados reais dependem das regras implementadas no projeto.

## 11. Testes automatizados

Os testes automatizados ajudam a verificar se as funcionalidades continuam funcionando corretamente após alterações no código.

O projeto utiliza JUnit e Mockito para testar comportamentos da aplicação.

Exemplo de teste:

```java
@Test
void deveBuscarEquipamentoPorId() {
    // Preparar os dados do teste
    // Simular o retorno do Repository
    // Executar o método do Service
    // Verificar o resultado
}
```

Para executar os testes pelo terminal:

```powershell
mvn test
```

Para executar pelo IntelliJ:

1. Acesse `src/test/java`.
2. Localize a classe de teste.
3. Clique com o botão direito.
4. Selecione `Run`.

É importante testar tanto os cenários positivos quanto os cenários de erro.

## 12. Consultas e scripts MongoDB

O diretório `mongodb/` contém materiais relacionados à criação, manipulação e consulta dos dados no MongoDB.

Os arquivos JavaScript podem ser utilizados no MongoDB Shell (`mongosh`), desde que estejam compatíveis com a modelagem e a estrutura atual do projeto.

Exemplo de conexão:

```powershell
mongosh "mongodb://localhost:27017/maintenance_service_orders"
```

Para verificar os bancos:

```javascript
show dbs
```

Para selecionar o banco:

```javascript
use maintenance_service_orders
```

Para visualizar as coleções:

```javascript
show collections
```

Para consultar os documentos:

```javascript
db.equipamentos.find()
```

O nome da coleção deve corresponder ao nome efetivamente utilizado na configuração do projeto.

## 13. Estrutura do projeto

```text
maintenance-service-orders/
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── br/com/maintenance/
│   │   │       ├── controller/
│   │   │       ├── service/
│   │   │       ├── repository/
│   │   │       ├── model/
│   │   │       └── MaintenanceServiceOrdersApplication.java
│   │   │
│   │   └── resources/
│   │       └── application.properties
│   │
│   └── test/
│       └── java/
│
├── modeling/
│   ├── entities.md
│   └── relationships.md
│
├── mongodb/
│   ├── 01_database.js
│   ├── 02_collections.js
│   ├── 03_insert_data.js
│   ├── 04_queries
│   └── 05_relations
│
├── docs/
│   ├── api.md
│   ├── architecture.md
│   ├── implementation.md
│   └── TESTES-MANUAIS.md
│
├── pom.xml
├── .gitignore
└── README.md
```

A estrutura acima representa a organização planejada. Os diretórios e arquivos devem corresponder aos que realmente estão presentes na versão publicada.

## 14. Como explicar o projeto durante a apresentação

Esta seção funciona como um roteiro de revisão para compreender a lógica do sistema.

### 14.1 Como iniciar a apresentação

"Nosso projeto consiste em um sistema de gerenciamento de ordens de serviço e manutenção industrial. Desenvolvemos uma API REST utilizando Java e Spring Boot, com persistência de dados no MongoDB.

A ideia é organizar informações de equipamentos, técnicos, peças e manutenções, permitindo registrar e consultar ordens de serviço de maneira estruturada."

### 14.2 Por que escolhemos MongoDB?

"O MongoDB é um banco de dados NoSQL orientado a documentos. Diferentemente de bancos relacionais tradicionais, ele armazena informações em documentos BSON, que possuem uma estrutura semelhante ao JSON.

Essa característica permite trabalhar com documentos embutidos e referências entre coleções, possibilitando representar diferentes tipos de relacionamentos."

### 14.3 Qual é a função do Controller?

"O Controller recebe as requisições HTTP enviadas pelo usuário ou pelo Insomnia. Ele identifica a operação solicitada e encaminha os dados para o Service."

### 14.4 Qual é a função do Service?

"O Service concentra as regras de negócio. Antes de salvar ou atualizar alguma informação, ele pode verificar se os dados são válidos e se os documentos relacionados existem."

### 14.5 Qual é a função do Repository?

"O Repository faz a comunicação com o banco de dados. Utilizamos o Spring Data MongoDB para facilitar operações de consulta, inserção, atualização e exclusão."

### 14.6 Qual é a diferença entre documento embutido e referência?

"Um documento embutido fica armazenado dentro de outro documento. Ele é utilizado quando as informações pertencem diretamente à entidade principal.

Já uma referência aponta para outro documento armazenado separadamente. Isso evita duplicação de informações e permite reutilizar entidades."

### 14.7 Como funciona o cadastro de uma ordem de serviço?

"Primeiro, a aplicação recebe os dados enviados pelo usuário. O Controller encaminha a requisição para o Service, que verifica os dados e os relacionamentos necessários. Depois, o Repository realiza a persistência no MongoDB. Por fim, a API retorna uma resposta HTTP informando o resultado da operação."

### 14.8 Como testamos o sistema?

"Utilizamos o Insomnia para enviar requisições HTTP à API. Com ele conseguimos testar os métodos POST, GET, PUT e DELETE, além de verificar os códigos de resposta e o comportamento das validações."

## 15. Perguntas que podem aparecer na apresentação

**1. O que é uma API REST?**

É uma interface que permite a comunicação entre sistemas por meio de requisições HTTP, utilizando métodos como GET, POST, PUT e DELETE.

**2. O que é CRUD?**

É o conjunto de quatro operações fundamentais: criar, consultar, atualizar e excluir registros.

**3. O que é MongoDB?**

É um banco de dados NoSQL orientado a documentos, que armazena informações em estruturas BSON.

**4. O que é uma Collection?**

É um agrupamento de documentos no MongoDB, semelhante conceitualmente a uma tabela em bancos relacionais.

**5. O que é um documento?**

É uma estrutura que armazena os dados de um registro no MongoDB, organizada em campos e valores.

**6. O que é ObjectId?**

É um identificador utilizado pelo MongoDB para identificar documentos de maneira única.

**7. Por que utilizamos String para representar o ID no Java?**

Porque o identificador ObjectId do MongoDB pode ser representado como uma String na aplicação, facilitando sua utilização nos Controllers, Services e Repositories.

**8. O que significa `@Document`?**

É uma anotação do Spring Data MongoDB que identifica uma classe como documento persistido em uma coleção.

**9. O que significa `@Id`?**

Identifica o atributo que representa a chave de identificação do documento.

**10. Para que serve `MongoRepository`?**

Disponibiliza operações de persistência e consulta sem precisar implementar manualmente todas as operações básicas.

**11. Qual é a diferença entre Controller e Service?**

O Controller recebe as requisições. O Service executa a lógica de negócio.

**12. O que acontece quando o usuário envia informações inválidas?**

A aplicação deve validar os dados, interromper a operação quando necessário e retornar uma resposta HTTP adequada.

**13. Por que separar o sistema em camadas?**

Para organizar o código, separar responsabilidades, facilitar manutenção e permitir testes mais específicos.

**14. Como evitar referências para registros inexistentes?**

Consultando os documentos relacionados antes de salvar ou atualizar a entidade que depende deles.

**15. O que acontece quando uma ordem de serviço é cadastrada?**

O sistema recebe os dados, valida as informações, verifica os relacionamentos e salva o documento no MongoDB.

## 16. Evoluções futuras

Algumas melhorias que podem ser desenvolvidas posteriormente:

- Autenticação e autorização de usuários.
- Controle de permissões por perfil.
- Dashboard com indicadores de manutenção.
- Relatórios de ordens de serviço.
- Controle de estoque de peças.
- Notificações de manutenção preventiva.
- Histórico detalhado de alterações.
- Paginação e filtros avançados.
- Documentação interativa com Swagger/OpenAPI.
- Testes de integração com MongoDB.

## 17. Considerações finais

O projeto permite aplicar conhecimentos de Java, Spring Boot, MongoDB, modelagem de dados, orientação a objetos e desenvolvimento de APIs REST.

Além de atender a uma necessidade de organização de informações de manutenção industrial, sua estrutura possibilita evoluções futuras, mantendo separadas as responsabilidades de cada camada da aplicação.

O desenvolvimento também proporciona experiência prática com versionamento de código, documentação técnica, testes e integração entre diferentes tecnologias.

---

**Desenvolvido como projeto acadêmico — Sistemas de Informação.**

**Repositório:** [GitHub - maintenance-service-orders](https://github.com/Lucas07silva/maintenance-service-orders)
