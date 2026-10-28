<h1 align="center">🏙️ Urbaniza</h1>

<p align="center">
  Projeto AEP — 6° Semestre de Engenharia de Software
</p>

<hr>

<h2>📌 Sobre o projeto</h2>

<p>
O <strong>Urbaniza</strong> é uma aplicação desenvolvida para auxiliar na comunicação e no gerenciamento de problemas relacionados à infraestrutura urbana.
</p>

<p>
A aplicação permite cadastrar, consultar, atualizar e excluir ocorrências relacionadas a problemas encontrados nas cidades.
</p>

<h2>🎯 ODS escolhida</h2>

<p>
O projeto está relacionado à <strong>ODS 11 — Cidades e Comunidades Sustentáveis</strong>, da Organização das Nações Unidas (ONU).
</p>

<p>
A ODS 11 tem como objetivo tornar as cidades e os assentamentos humanos mais inclusivos, seguros, resilientes e sustentáveis.
</p>

<h2>❗ O problema</h2>

<p>
Problemas relacionados à infraestrutura urbana são comuns nas cidades, como:
</p>

<ul>
  <li>Buracos nas ruas;</li>
  <li>Problemas na iluminação pública;</li>
  <li>Acúmulo de lixo;</li>
  <li>Outras irregularidades urbanas.</li>
</ul>

<p>
O Urbaniza propõe uma aplicação simples para registrar essas ocorrências e permitir que elas sejam acompanhadas por meio de um sistema informatizado.
</p>

<h2>⚙️ Funcionalidades</h2>

<p>Atualmente, o sistema possui um CRUD de ocorrências:</p>

<ul>
  <li>✅ Cadastrar ocorrência;</li>
  <li>✅ Listar ocorrências;</li>
  <li>✅ Buscar ocorrência por ID;</li>
  <li>✅ Atualizar ocorrência;</li>
  <li>✅ Excluir ocorrência.</li>
</ul>

<h3>📋 Dados de uma ocorrência</h3>

<ul>
  <li><strong>ID</strong></li>
  <li><strong>Descrição</strong></li>
  <li><strong>Categoria</strong></li>
  <li><strong>Status</strong></li>
</ul>

<h2>🛠️ Tecnologias utilizadas</h2>

<ul>
  <li><strong>Java 21</strong></li>
  <li><strong>Spring Boot 4.1.1</strong></li>
  <li><strong>Spring Data MongoDB</strong></li>
  <li><strong>MongoDB Atlas</strong></li>
  <li><strong>Maven</strong></li>
  <li><strong>JUnit 5</strong></li>
  <li><strong>Mockito</strong></li>
  <li><strong>JaCoCo</strong></li>
  <li><strong>Git e GitHub</strong></li>
</ul>

<h2>📁 Estrutura do projeto</h2>

<pre>
src/
├── main/
│   ├── java/com/AEP/urbaniza/
│   │   ├── console/
│   │   ├── controller/
│   │   ├── model/
│   │   ├── repository/
│   │   ├── service/
│   │   └── UrbanizaApplication.java
│   │
│   └── resources/
│       └── application.properties
│
└── test/
    └── java/com/AEP/urbaniza/
        ├── console/
        ├── controller/
        ├── service/
        └── UrbanizaApplicationTests.java
</pre>

<h2>🗄️ Banco de dados</h2>

<p>
O projeto utiliza o <strong>MongoDB Atlas</strong> como banco de dados.
</p>

<p>
A aplicação utiliza uma única coleção:
</p>

<pre>
ocorrencias
</pre>

<p>
A conexão com o banco é configurada por meio da variável de ambiente
<strong>MONGODB_URI</strong>.
</p>

<h3>Exemplo</h3>

<pre>
MONGODB_URI=mongodb+srv://USUARIO:SENHA@SEU_CLUSTER.mongodb.net/urbaniza
</pre>

<p>
<strong>⚠️ Importante:</strong> as credenciais reais do MongoDB não devem ser adicionadas ao repositório.
</p>

<h2>▶️ Como executar</h2>

<h3>Pré-requisitos</h3>

<ul>
  <li>Java 21 instalado;</li>
  <li>Acesso ao MongoDB Atlas;</li>
  <li>Variável de ambiente <code>MONGODB_URI</code> configurada.</li>
</ul>

<h3>Executar a aplicação</h3>

<p>No diretório raiz do projeto, execute:</p>

<pre>
.\mvnw.cmd spring-boot:run
</pre>

<h2>⚠️ Problemas com arquivos temporários no Windows</h2>

<p>
Em alguns casos, o Windows pode manter arquivos da pasta <code>target</code> em uso,
impedindo que o Maven execute o comando <code>clean</code> corretamente.
</p>

<p>
Caso isso aconteça, remova manualmente a pasta <code>target</code> pelo terminal:
</p>

<pre>
rmdir /S /Q target
</pre>

<p>
Depois, execute novamente:
</p>

<pre>
.\mvnw.cmd verify
</pre>

<h2>💻 Menu do console</h2>

<p>
A aplicação possui um menu simples executado diretamente pelo terminal:
</p>

<pre>
===== URBANIZA =====
1 - Cadastrar ocorrência
2 - Listar ocorrências
0 - Sair
</pre>

<h3>1 — Cadastrar ocorrência</h3>

<p>
Ao escolher a opção <strong>1</strong>, o sistema solicita:
</p>

<ul>
  <li>Descrição;</li>
  <li>Categoria;</li>
  <li>Status.</li>
</ul>

<h3>2 — Listar ocorrências</h3>

<p>
Ao escolher a opção <strong>2</strong>, o sistema apresenta todas as ocorrências cadastradas.
</p>

<h3>0 — Sair</h3>

<p>
A opção <strong>0</strong> encerra a aplicação.
</p>

<h2>🌐 API REST</h2>

<table>
  <thead>
    <tr>
      <th>Método</th>
      <th>Endpoint</th>
      <th>Função</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td>POST</td>
      <td><code>/ocorrencias</code></td>
      <td>Cadastrar ocorrência</td>
    </tr>
    <tr>
      <td>GET</td>
      <td><code>/ocorrencias</code></td>
      <td>Listar ocorrências</td>
    </tr>
    <tr>
      <td>GET</td>
      <td><code>/ocorrencias/{id}</code></td>
      <td>Buscar ocorrência por ID</td>
    </tr>
    <tr>
      <td>PUT</td>
      <td><code>/ocorrencias/{id}</code></td>
      <td>Atualizar ocorrência</td>
    </tr>
    <tr>
      <td>DELETE</td>
      <td><code>/ocorrencias/{id}</code></td>
      <td>Excluir ocorrência</td>
    </tr>
  </tbody>
</table>

<h2>🧪 Testes automatizados</h2>

<p>
O projeto utiliza <strong>JUnit 5</strong> e <strong>Mockito</strong> para a realização dos testes automatizados.
</p>

<p>Para executar os testes e gerar o relatório de cobertura:</p>

<pre>
.\mvnw.cmd verify
</pre>

<p>Atualmente o projeto possui:</p>

<ul>
  <li>✅ 15 testes;</li>
  <li>✅ 15 testes aprovados;</li>
  <li>✅ 0 falhas;</li>
  <li>✅ 0 erros.</li>
</ul>

<h2>📊 Cobertura de testes</h2>

<p>
A cobertura do código é analisada utilizando o <strong>JaCoCo</strong>.
</p>

<table>
  <thead>
    <tr>
      <th>Métrica</th>
      <th>Cobertura</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td>Instruções</td>
      <td><strong>97,9%</strong></td>
    </tr>
    <tr>
      <td>Linhas</td>
      <td><strong>97,1%</strong></td>
    </tr>
    <tr>
      <td>Branches</td>
      <td><strong>100%</strong></td>
    </tr>
    <tr>
      <td>Métodos</td>
      <td><strong>100%</strong></td>
    </tr>
    <tr>
      <td>Complexidade</td>
      <td><strong>100%</strong></td>
    </tr>
  </tbody>
</table>

<p>
O relatório HTML do JaCoCo pode ser encontrado após a execução dos testes em:
</p>

<pre>
target/site/jacoco/index.html
</pre>

<h2>📦 Controle de versão</h2>

<p>
O projeto utiliza <strong>Git</strong> para controle de versão e está hospedado no GitHub.
</p>

<p>
<strong>Repositório:</strong>
<a href="https://github.com/Guilherme-Luvizutto/Projeto_AEP_6S_ESOFT">
Projeto_AEP_6S_ESOFT
</a>
</p>

<h2>📚 Desenvolvimento</h2>

<p>
Este projeto corresponde à primeira etapa da AEP do 6° semestre de Engenharia de Software.
</p>

<p>
A implementação inicial foi mantida de forma simples, priorizando o funcionamento do CRUD, a persistência dos dados no MongoDB, os testes automatizados e a cobertura de código.
</p>

<hr>

<p align="center">
  <strong>Projeto AEP — Engenharia de Software</strong>
</p>

