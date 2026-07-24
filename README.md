# Produtos API

API REST para gerenciamento de produtos, desenvolvida com **Java 21** e **Spring Boot**.

O projeto implementa um CRUD completo de produtos, permitindo criar, consultar, atualizar, pesquisar e excluir produtos.

A aplicação utiliza **Spring Data JPA** para comunicação com o banco de dados, **Hibernate ORM** para o mapeamento entre objetos Java e tabelas do banco, e **H2 Database** para armazenamento dos dados.

Os endpoints foram testados utilizando o **Postman**.

---

# 🚀 Tecnologias utilizadas

## Java 21

Linguagem utilizada no desenvolvimento da aplicação.

O Java é responsável pela criação das classes, regras de negócio e estrutura principal da API.

---

## Spring Boot

Framework utilizado para criação da API REST.

O Spring Boot facilita a configuração da aplicação, gerenciamento de dependências e criação dos endpoints HTTP.

Neste projeto ele é responsável por:

- Inicializar a aplicação
- Gerenciar os componentes da API
- Criar os controllers
- Integrar as camadas da aplicação

---

## Spring Web

Biblioteca utilizada para criação dos endpoints REST.

Com ela foi possível criar rotas como:

- POST para criação
- GET para consultas
- PUT para atualização
- DELETE para exclusão

Utilizando anotações como:

```java
@RestController
@GetMapping
@PostMapping
@PutMapping
@DeleteMapping
```

---

## Spring Data JPA

Responsável pela comunicação entre a aplicação e o banco de dados.

Ele permite manipular dados sem a necessidade de escrever SQL manualmente.

Exemplo:

```java
produtoRepository.findByNomeContaining(nome);
```

O Spring Data JPA transforma esse método em uma consulta SQL automaticamente.

---

## Hibernate ORM

O Hibernate é o framework responsável pelo mapeamento objeto-relacional (ORM).

Ele transforma objetos Java em registros no banco de dados e vice-versa.

Exemplo:

Classe Java:

```java
@Entity
public class Produto {

    private String id;
    private String nome;
    private String descricao;
    private Double preco;

}
```

É representada como uma tabela:

```
PRODUTO

ID | NOME | DESCRICAO | PRECO
```

Dessa forma, a aplicação trabalha com objetos Java enquanto o Hibernate gerencia a comunicação com o banco.

---

## H2 Database

Banco de dados utilizado para desenvolvimento e testes.

O H2 é um banco leve e executado em memória, permitindo iniciar a aplicação sem a necessidade de instalar um banco externo.

Ele armazena os produtos cadastrados enquanto a aplicação está rodando.

---

## Maven

Gerenciador de dependências e construção do projeto.

Responsável por:

- Baixar bibliotecas
- Gerenciar versões
- Executar a aplicação

Arquivo principal:

```
pom.xml
```

---

## Postman

Ferramenta utilizada para testar os endpoints da API.

Foi utilizado para validar:

- Criação de produtos
- Consultas
- Atualizações
- Exclusões
- Pesquisa por nome

---

# 🏗️ Arquitetura do projeto

A aplicação segue uma organização em camadas:

```
Controller
     ↓
Repository
     ↓
JPA / Hibernate
     ↓
Banco H2
```

---

## Controller

Camada responsável por receber as requisições HTTP.

Exemplo:

```java
@GetMapping
public List<Produto> buscar()
```

O Controller recebe uma solicitação do cliente e encaminha para a camada responsável.

---

## Model

Representa as entidades da aplicação.

Neste projeto:

```
Produto.java
```

Representa um produto contendo:

- ID
- Nome
- Descrição
- Preço

A anotação:

```java
@Entity
```

informa ao Hibernate que essa classe representa uma tabela no banco.

---

## Repository

Camada responsável pelo acesso aos dados.

Exemplo:

```java
public interface ProdutoRepository 
        extends JpaRepository<Produto, String>
```

Ela fornece operações prontas como:

- Salvar
- Buscar
- Atualizar
- Excluir

Sem necessidade de escrever SQL.

---

# 📌 Endpoints

| Método | Endpoint | Função |
|---|---|---|
| POST | `/produtos` | Cria um produto |
| GET | `/produtos/{id}` | Busca produto pelo ID |
| GET | `/produtos?nome=` | Pesquisa pelo nome |
| PUT | `/produtos/{id}` | Atualiza produto |
| DELETE | `/produtos/{id}` | Remove produto |

---

# 🔎 Pesquisa por nome

A pesquisa utiliza:

```java
findByNomeContaining()
```

O `Containing` funciona como um `LIKE` no SQL.

Exemplo:

Pesquisa:

```
Mouse
```

Consulta equivalente:

```sql
WHERE nome LIKE '%Mouse%'
```

Permitindo encontrar produtos mesmo quando o termo está apenas dentro do nome.

---

# 🧪 Testes

Os endpoints foram testados utilizando o Postman.

Validações realizadas:

✅ Criar produto  
✅ Buscar produto  
✅ Pesquisar por nome  
✅ Atualizar produto  
✅ Excluir produto  

---

# 📸 Demonstração

## Criação de produto

![Criação de produto](images/criar-produto.png)

---

## Estrutura da API

![Estrutura da API](images/estrutura-api.png)

---

## Console H2

![Console H2](images/console-h2.png)

---

## Pesquisa de produtos

![Busca por nome](images/busca-mouse.png)

---

# 🔮 Melhorias futuras

- Implementar validações com Bean Validation
- Criar tratamento global de exceções
- Adicionar testes automatizados
- Implementar Swagger/OpenAPI
- Migrar H2 para PostgreSQL
- Adicionar autenticação com Spring Security

---

# 👨‍💻 Autor

André Magalhães
