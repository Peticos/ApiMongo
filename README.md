# API Peticos - Spring Boot com MongoDB

## Índice
- [Descrição](#descrição)
-  [Tecnologias](#tecnologias)
-  [Uso da API](#uso-da-api)
   - [URLs](#urls)
   - [Instalação](#instalação)
   - [Documentação](#documentação)
-   [Equipe](#equipe)

## Descrição
Esta API foi desenvolvida utilizando Spring Boot e MongoDB, sendo uma parte crucial do sistema do aplicativo Peticos. Ela permite a execução de operações CRUD (Criar, Ler, Atualizar, Excluir) em diversas coleções no MongoDB, como:

- **Auth**: Realiza a autenticação e o gerenciamento de login de usuários.
- **KeepAlive**: Responsável por manter a conexão viva, evitando timeouts.
- **Personalization**: Gerencia os valores da personalização do icone de pet
- **Post**: Manipula os posts no sistema, incluindo a criação e a leitura de conteúdo.

A API serve como camada de backend para o aplicativo Peticos, interagindo diretamente com o front-end e garantindo a correta funcionalidade do sistema.

## Tecnologias
- Java 17
- Spring Boot
- MongoDB
- Maven
- Swagger (para documentação da API)

## Uso da API
### URLs

- Ambiente de Desenvolvimento: `https://apimongo-ghjh.onrender.com`
- Ambiente de Produção: `https://apimongodev.onrender.com`

### Instalação
#### Pré-requisitos
- Java 17.
- Maven.
- MongoDB 
Para rodar a API localmente, siga os passos abaixo:
#### Clone o repositório
```bash
git clone https://github.com/Peticos/ApiMongo.git
cd ApiMongo
```

### Documentação
A documentação da API, com todos os endpoints e detalhes de uso, está disponível via Swagger:

- **Desenvolvimento**: [Swagger Dev](https://apimongodev.onrender.com/swagger-ui/index.html#/)
- **Produção**: [Swagger Prod](https://apimongo-ghjh.onrender.com/swagger-ui/index.html#/)

## Equipe

- Bianca Machado - Desenvolvedora
