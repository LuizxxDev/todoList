# README - API TodoList

## Visão Geral

Esta é uma API simples de lista de tarefas construída usando o Spring Boot. Ela fornece endpoints para gerenciar categorias e notas, permitindo que os usuários organizem e acompanhem suas tarefas.

## Sumário

- [Começando](#começando)
- [Endpoints](#endpoints)
- [Categorias](#categorias)
- [Notas](#notas)
- [Tecnologias Usadas](#tecnologias-usadas)

## Começando

Para usar esta API, é necessário ter o [Java](https://www.java.com/pt-BR/download/) e o [Maven](https://maven.apache.org/download.cgi) instalados em sua máquina.

## Endpoints

## Categorias

- **Criar uma nova categoria**
  - Endpoint: `POST /categories`
  - Corpo da Requisição: JSON com o campo `name`.
```json
{
  "name": "Trabalho"
}
```
  - Resposta: Retorna a categoria criada.
```json
{
  "id": 1,
  "name": "Trabalho"
}
```

- **Listar todas as categorias**
  - Endpoint: `GET /categories`
  - Resposta: 
```json
[
  {
    "id": 1,
    "name": "Trabalho"
  },
  {
    "id": 2,
    "name": "Pessoal"
  }
]
```

- **Encontrar categoria por ID**
  - Endpoint: `GET /categories/{id}`
  - Resposta: Retorna a categoria com o ID especificado.
```json
{
  "id": 1,
  "name": "Trabalho"
}
```

- **Excluir categoria por ID**
  - Endpoint: `DELETE /categories/{id}`
  - Resposta: Sem conteúdo em caso de exclusão bem-sucedida.

## Notas

- **Criar uma nova nota**
  - Endpoint: `POST /notes`
  - Corpo da Requisição: JSON com os campos `title`, `description` e opcionalmente `category`.
```json
{
  "title": "Reunião",
  "description": "Preparar a pauta para a reunião da equipe",
  "category": {
    "id": 1
  }
}
```
  - Resposta: Retorna a nota criada.
```json
[
  {
    "id": 1,
    "title": "Reunião",
    "description": "Preparar a pauta para a reunião da equipe",
    "category": {
      "id": 1,
      "name": "Trabalho"
    }
  }
]
```

- **Listar todas as notas**
  - Endpoint: `GET /notes`
  - Resposta: Retorna uma lista de todas as notas.
```json
{
  "id": 1,
  "title": "Reunião",
  "description": "Preparar a pauta para a reunião da equipe",
  "category": {
    "id": 1,
    "name": "Trabalho"
  }
}
```

- **Encontrar nota por ID**
  - Endpoint: `GET /notes/{id}`
  - Resposta: Retorna a nota com o ID especificado.
```json
{
  "id": 1,
  "title": "Reunião",
  "description": "Preparar a pauta para a reunião da equipe",
  "category": {
    "id": 1,
    "name": "Trabalho"
  }
}
```

- **Excluir nota por ID**
  - Endpoint: `DELETE /notes/{id}`
  - Resposta: Sem conteúdo em caso de exclusão bem-sucedida.

- **Excluir todas as notas**
  - Endpoint: `DELETE /notes`
  - Resposta: Sem conteúdo em caso de exclusão bem-sucedida.

### Tecnologias Usadas
 - Spring Boot
 - Spring Data JPA
 - Banco de Dados H2 (para simplicidade de um banco de dados em memória)
 - Maven (ou Gradle) para gerenciamento e construção do projeto
