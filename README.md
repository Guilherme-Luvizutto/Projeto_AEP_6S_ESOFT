# 🏙️ Urbaniza

### Sistema de Gerenciamento de Ocorrências Urbanas

<p align="center">
  <strong>Identificando problemas, contribuindo para cidades melhores.</strong>
</p>

<p align="center">
  <img src="https://img.shields.io/badge/Java-21-orange?logo=openjdk" />
  <img src="https://img.shields.io/badge/Spring%20Boot-4.1.1-6DB33F?logo=springboot" />
  <img src="https://img.shields.io/badge/MongoDB-Atlas-47A248?logo=mongodb" />
  <img src="https://img.shields.io/badge/Tests-45%20passing-success?logo=junit5" />
  <img src="https://img.shields.io/badge/Coverage-87%25-brightgreen" />
</p>

---

## 📌 Sobre o projeto

O **Urbaniza** é um sistema desenvolvido como parte da Atividade de Estudo Programada (AEP) do curso de Engenharia de Software.

Seu objetivo é facilitar o registro e o gerenciamento de ocorrências urbanas, como buracos em vias públicas, problemas de infraestrutura, postes danificados e outras situações que necessitam de atenção.

O projeto está alinhado ao **Objetivo de Desenvolvimento Sustentável 11 (ODS 11)**, que busca tornar as cidades e comunidades mais inclusivas, seguras, resilientes e sustentáveis.

## 🚀 Tecnologias utilizadas

| Tecnologia | Aplicação |
|---|---|
| Java 21 | Linguagem de programação |
| Spring Boot 4.1.1 | Estrutura da aplicação |
| Spring Data MongoDB | Integração com o banco de dados |
| MongoDB Atlas | Banco de dados NoSQL |
| Maven | Gerenciamento de dependências |
| JUnit 5 | Testes automatizados |
| Mockito | Simulação de dependências nos testes |
| JaCoCo | Análise de cobertura de testes |

## ⚙️ Funcionalidades

### 👤 Gerenciamento de usuários

- Cadastro de usuários.
- Listagem de usuários.
- Busca por ID.
- Atualização de dados.
- Exclusão de usuários.

> **Importante:** o gerenciamento de usuários é realizado exclusivamente pela API REST. O menu do console não possui funcionalidade para cadastrar usuários.

### 📍 Gerenciamento de ocorrências

- Cadastro de ocorrências.
- Listagem de ocorrências.
- Atualização de informações.
- Exclusão de registros.
- Associação de ocorrências a usuários cadastrados.
- Registro de localização detalhada.

O gerenciamento de ocorrências pode ser realizado tanto pela API REST quanto pelo menu interativo do console.

No console, o usuário responsável é identificado por meio do e-mail cadastrado previamente na coleção de usuários.

---

## 🗄️ Estrutura do banco de dados

O Urbaniza utiliza o **MongoDB Atlas**, um banco de dados NoSQL orientado a documentos.

A aplicação trabalha com duas coleções principais:

### Coleção `usuarios`

Armazena os dados dos usuários cadastrados.

| Campo | Descrição |
|---|---|
| `id` | Identificador do usuário |
| `nome` | Nome do usuário |
| `email` | E-mail do usuário |

### Coleção `ocorrencias`

Armazena os registros das ocorrências urbanas.

| Campo | Descrição |
|---|---|
| `id` | Identificador da ocorrência |
| `descricao` | Descrição do problema |
| `categoria` | Categoria da ocorrência |
| `status` | Situação atual |
| `usuarioId` | Identificador do usuário responsável |
| `localizacao` | Objeto incorporado com os dados do endereço |

### 🔗 Relacionamento entre coleções

O relacionamento entre usuários e ocorrências é realizado por meio do campo `usuarioId`, que armazena o identificador do usuário responsável pela ocorrência.

Essa associação é controlada pela própria aplicação, sem utilização de chaves estrangeiras automáticas.

### 📦 Objeto incorporado: `Localizacao`

A localização é armazenada diretamente dentro do documento de ocorrência, utilizando um objeto incorporado (*Embedded Document*).

Sua estrutura contém:

- `rua`
- `bairro`
- `numero`
- `cidade`

Essa abordagem permite armazenar os dados relacionados ao endereço junto à ocorrência, sem a necessidade de criar uma terceira coleção.

---

## 🌐 API REST

A API disponibiliza endpoints para o gerenciamento dos dados.

**Endereço local:** `http://localhost:8080`

### 👤 Endpoints de usuários

| Método | Endpoint | Operação |
|---|---|---|
| `POST` | `/usuarios` | Cadastrar usuário |
| `GET` | `/usuarios` | Listar usuários |
| `GET` | `/usuarios/{id}` | Buscar por ID |
| `PUT` | `/usuarios/{id}` | Atualizar usuário |
| `DELETE` | `/usuarios/{id}` | Excluir usuário |

### 📍 Endpoints de ocorrências

| Método | Endpoint | Operação |
|---|---|---|
| `POST` | `/ocorrencias` | Cadastrar ocorrência |
| `GET` | `/ocorrencias` | Listar ocorrências |
| `GET` | `/ocorrencias/{id}` | Buscar por ID |
| `PUT` | `/ocorrencias/{id}` | Atualizar ocorrência |
| `DELETE` | `/ocorrencias/{id}` | Excluir ocorrência |

---

## 💻 Menu interativo do console

Além da API REST, o sistema possui um menu interativo para o gerenciamento de ocorrências.

```text
          ===== URBANIZA =====

1 - Cadastrar ocorrência
2 - Listar ocorrências
3 - Atualizar ocorrência
4 - Deletar ocorrência
0 - Sair

Escolha:
```

**Atenção:** o menu do console permite somente operações relacionadas às ocorrências. O cadastro de usuários deve ser realizado pelo endpoint `POST /usuarios`.

Durante o cadastro de uma ocorrência pelo console, o sistema solicita o e-mail de um usuário existente para estabelecer o relacionamento automaticamente.

---

## 🛠️ Como executar o projeto

### 1. Pré-requisitos

Antes de iniciar, tenha instalado:

- [Java JDK 21](https://adoptium.net/)
- [MongoDB Atlas](https://www.mongodb.com/atlas)
- Git (opcional, para clonar o repositório)

### 2. Clonar o repositório

```bash
git clone URL_DO_REPOSITORIO
```

Entre na pasta do projeto:

```bash
cd Projeto_AEP_6S_ESOFT
```

### 3. Configurar o banco de dados

Configure a variável de ambiente `MONGODB_URI` com a URI de conexão do seu banco MongoDB Atlas.

Mantenha as credenciais protegidas e não publique informações de acesso ao banco no repositório.

### 4. Executar a aplicação

No terminal, execute:

```powershell
.\mvnw.cmd spring-boot:run
```

Após a inicialização, o menu do console estará disponível e a API REST poderá ser acessada pelo endereço local.

---

## 🧪 Testes automatizados

O projeto utiliza **JUnit 5** e **Mockito** para verificar o comportamento das classes, serviços, controladores e funcionalidades do sistema.

### Executar os testes

```powershell
.\mvnw.cmd clean test
```

### Executar os testes e gerar a cobertura

```powershell
.\mvnw.cmd clean verify
```

### 📊 Resultados dos testes

<details>
<summary><strong>Ver resultados da última execução</strong></summary>

| Resultado | Quantidade |
|---|---:|
| Testes executados | 45 |
| Falhas | 0 |
| Erros | 0 |
| Ignorados | 0 |

</details>

### 📈 Cobertura de código — JaCoCo

<p align="center">
  <img src="https://img.shields.io/badge/Instructions-87%25-brightgreen" />
  <img src="https://img.shields.io/badge/Branches-70%25-green" />
  <img src="https://img.shields.io/badge/Lines-90%25-brightgreen" />
  <img src="https://img.shields.io/badge/Methods-97%25-brightgreen" />
  <img src="https://img.shields.io/badge/Classes-100%25-success" />
</p>

| Métrica | Cobertura |
|---|---:|
| Instruções | **87%** |
| Branches | **70%** |
| Linhas | **90%** |
| Métodos | **97%** |
| Classes | **100%** |

A cobertura de instruções atende ao requisito mínimo de 70% estabelecido para o projeto.

O relatório detalhado é gerado em:

```text
target/site/jacoco/index.html
```

---

## ✅ Validação funcional

Além dos testes automatizados, foram realizados testes manuais utilizando a API REST e o menu do console.

Foram validadas as operações de cadastro, consulta, atualização e exclusão de usuários e ocorrências pela API.

Também foram testadas todas as operações de gerenciamento de ocorrências pelo console.

Os testes confirmaram:

- Funcionamento das operações CRUD.
- Persistência dos dados no MongoDB Atlas.
- Associação entre usuários e ocorrências.
- Armazenamento de localização como objeto incorporado.
- Identificação de usuários pelo e-mail durante o cadastro de ocorrências pelo console.

## 🎯 Objetivo de Desenvolvimento Sustentável

O Urbaniza está relacionado ao **ODS 11 — Cidades e Comunidades Sustentáveis**, especialmente à proposta de contribuir para a identificação e organização de problemas urbanos.

## 📝 Considerações finais

O desenvolvimento do Urbaniza proporcionou a aplicação prática de conceitos de programação orientada a objetos, desenvolvimento de APIs REST, persistência de dados com MongoDB e testes automatizados.

A utilização de referências entre documentos e objetos incorporados permitiu explorar diferentes estratégias de modelagem em bancos de dados NoSQL.

O projeto também contribuiu para o desenvolvimento de boas práticas de organização, qualidade, manutenção e validação de software.

---

<p align="center">
  <strong>Urbaniza — Tecnologia a serviço de cidades melhores. 🏙️</strong>
</p>
