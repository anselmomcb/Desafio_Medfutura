

# Desafio Medfutura

## Descrição

**Este é um projeto para gerenciar informações de pessoas.** A aplicação permite criar, ler, atualizar e deletar registros de pessoas no banco de dados. Utiliza Spring Boot para o backend e MySQL como banco de dados.

## Requisitos

Antes de começar, certifique-se de ter os seguintes itens instalados:

- **Java JDK 17+**
- **Maven** (para gerenciamento de dependências e build)
- **MySQL** (ou qualquer outra versão compatível)
- **Postman** (para testes de API)

## Configuração do Ambiente

### 1. Clonando o Repositório

Clone o repositório do projeto para sua máquina local:

```bash
git clone https://github.com/seu-usuario/desafio-medfutura.git
cd desafio-medfutura

2. Configurando o Banco de Dados
Crie um banco de dados no MySQL. Você pode nomear o banco de dados como db_medfutura ou qualquer outro nome desejado.

Configure as credenciais do banco de dados no arquivo src/main/resources/application.properties:

spring.datasource.url=jdbc:mysql://localhost:3306/db_medfutura
spring.datasource.username=root
spring.datasource.password=admin
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

3. Criando a Tabela
Se você ainda não criou a tabela, utilize a configuração de spring.jpa.hibernate.ddl-auto=update, que cria a tabela automaticamente com base na sua entidade Pessoa. Caso prefira criar a tabela manualmente, utilize os seguintes comandos SQL:

Tabela pessoa

CREATE TABLE pessoa (
    id BIGINT NOT NULL AUTO_INCREMENT,
    apelido VARCHAR(32) NOT NULL,
    nome VARCHAR(100) NOT NULL,
    nascimento DATE NOT NULL,
    PRIMARY KEY (id),
    UNIQUE KEY UK_apelido (apelido)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
Tabela pessoa_stack
Esta tabela é usada para armazenar a lista de stack da pessoa, já que stack é uma coleção de strings.

CREATE TABLE pessoa_stack (
    pessoa_id BIGINT NOT NULL,
    stack VARCHAR(32) NOT NULL,
    PRIMARY KEY (pessoa_id, stack),
    FOREIGN KEY (pessoa_id) REFERENCES pessoa(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

4. Executando a Aplicação
Compile e inicie a aplicação:

mvn clean install
mvn spring-boot:run
A aplicação será iniciada e estará disponível no endereço http://localhost:8080.

Endpoints da API

1. Criar uma Pessoa
Método: POST
URL: http://localhost:8080/pessoas
Headers:
Content-Type: application/json
Body:
{
    "apelido": "Selmin",
    "nome": "Anselmo Mendes",
    "nascimento": "1998-07-29",
    "stack": ["Java"]
}
Resposta:
Status 201 Created: Se a pessoa foi criada com sucesso.

2. Buscar Pessoa por ID
Método: GET
URL: http://localhost:8080/pessoas/{id}
Headers: Nenhum necessário.
Resposta:
Status 200 OK: Se a pessoa for encontrada.
Status 404 Not Found: Se a pessoa não for encontrada.

3. Atualizar Pessoa
Método: PUT
URL: http://localhost:8080/pessoas/{id}
Headers:
Content-Type: application/json
Body:
{
    "apelido": "Selmin",
    "nome": "Anselmo Mendes Atualizado",
    "nascimento": "1998-07-29",
    "stack": ["Java", "Spring Boot"]
}
Resposta:
Status 200 OK: Se a pessoa foi atualizada com sucesso.
Status 404 Not Found: Se a pessoa não for encontrada.

4. Excluir Pessoa
Método: DELETE
URL: http://localhost:8080/pessoas/{id}
Headers: Nenhum necessário.
Resposta:
Status 204 No Content: Se a pessoa foi excluída com sucesso.
Status 404 Not Found: Se a pessoa não for encontrada.

5. Buscar Pessoas por Termo
Método: GET
URL: http://localhost:8080/pessoas/buscar?termo={termo}
Headers: Nenhum necessário.
Resposta:
Status 200 OK: Retorna uma lista de pessoas que correspondem ao termo de busca.
Testando com Postman

Criar Pessoa: Use o método POST com o corpo JSON mostrado acima.

Buscar Pessoa por ID: Use o método GET com o ID da pessoa.

Atualizar Pessoa: Use o método PUT com o ID da pessoa e o corpo JSON atualizado.

Excluir Pessoa: Use o método DELETE com o ID da pessoa.

Buscar Pessoas por Termo: Use o método GET com um termo de busca.

Contribuindo
Sinta-se à vontade para fazer contribuições. Se você encontrar bugs ou tiver sugestões, por favor, abra um issue ou um pull request.
