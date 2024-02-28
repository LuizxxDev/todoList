# README - API TodoList

## Visão Geral

Esta é uma API simples de lista de tarefas construída usando o Spring Boot. Ela fornece endpoints para gerenciar categorias e notas, permitindo que os usuários organizem e acompanhem suas tarefas.

## Sumário

- [Começando](#começando)
- [Endpoints](#endpoints)
- [Categorias](#categorias)
- [Notas](#notas)
- [Exemplos](#exemplos)

## Começando

Para usar esta API, é necessário ter o [Java](https://www.java.com/pt-BR/download/) e o [Maven](https://maven.apache.org/download.cgi) instalados em sua máquina.

## Endpoints

### Categorias

- **Criar uma nova categoria**
  - Endpoint: `POST /categories`
  - Corpo da Requisição: JSON com o campo `name`.
  - Resposta: Retorna a categoria criada.
  - [Exemplo:](#criar-uma-nova-categoria)

- **Listar todas as categorias**
  - Endpoint: `GET /categories`
  - Resposta: Retorna uma lista de todas as categorias.

- **Encontrar categoria por ID**
  - Endpoint: `GET /categories/{id}`
  - Resposta: Retorna a categoria com o ID especificado.

- **Excluir categoria por ID**
  - Endpoint: `DELETE /categories/{id}`
  - Resposta: Sem conteúdo em caso de exclusão bem-sucedida.

### Notas

- **Criar uma nova nota**
  - Endpoint: `POST /notes`
  - Corpo da Requisição: JSON com os campos `title`, `description` e opcionalmente `category`.
  - Resposta: Retorna a nota criada.
  - [Exemplo:](#criar-uma-nova-nota)

- **Listar todas as notas**
  - Endpoint: `GET /notes`
  - Resposta: Retorna uma lista de todas as notas.

- **Encontrar nota por ID**
  - Endpoint: `GET /notes/{id}`
  - Resposta: Retorna a nota com o ID especificado.

- **Excluir nota por ID**
  - Endpoint: `DELETE /notes/{id}`
  - Resposta: Sem conteúdo em caso de exclusão bem-sucedida.

- **Excluir todas as notas**
  - Endpoint: `DELETE /notes`
  - Resposta: Sem conteúdo em caso de exclusão bem-sucedida.

## Exemplos

### Criar uma nova Categoria

```json
POST /categories
{
  "name": "Trabalho"
}
```

### Criar uma nova Nota
```json
  POST /notes
{
  "title": "Reunião",
  "description": "Discutir atualizações do projeto",
  "category": {
    "id": 1
  }
}
```










