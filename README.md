# Projeto Spring Boot — API de Clientes, Produtos e Pedidos

Projeto desenvolvido com o objetivo de **estudar e praticar o desenvolvimento de APIs REST utilizando Spring Boot**.

> ⚠️ Este projeto possui finalidade exclusivamente **educacional** e está sendo desenvolvido durante o processo de aprendizado da tecnologia.

## Objetivo

O projeto tem como objetivo colocar em prática conceitos fundamentais do ecossistema Spring, principalmente:

* Desenvolvimento de APIs REST;
* Criação de Controllers;
* Uso de `@GetMapping`, `@PostMapping`, `@PutMapping`, `@PatchMapping` e `@DeleteMapping`;
* Utilização de `ResponseEntity`;
* Recebimento de parâmetros através de `@RequestParam`, `@PathVariable` e `@RequestBody`;
* Persistência de dados utilizando Spring Data JPA;
* Criação e utilização de `JpaRepository`;
* Consultas derivadas a partir do nome dos métodos do Repository;
* Operações de criação, consulta, atualização e exclusão de dados (CRUD);
* Utilização de `Optional` para lidar com registros que podem não existir;
* Validação básica dos dados recebidos pela API.

## Tecnologias

* Java
* Spring Boot
* Spring Web
* Spring Data JPA
* Maven
* Banco de dados relacional

## Estrutura

O projeto está organizado de acordo com as principais responsabilidades de uma aplicação Spring Boot:

```text
src/
└── main/
    └── java/
        └── com.example.atividades
            ├── controller/
            ├── entity/
            └── repository/
```

### Controller

Responsável por receber as requisições HTTP e definir os endpoints da API.

Exemplos de operações praticadas:

```text
GET     /clientes
POST    /clientes
PATCH   /clientes/{id}
DELETE  /clientes/{id}

GET     /produtos
GET     /produtos/mais-baratos
POST    /produtos

GET     /pedidos
POST    /pedidos
```

### Repository

Os repositories são responsáveis pela comunicação com o banco de dados através do Spring Data JPA.

O projeto também utiliza **query methods**, permitindo criar consultas através do próprio nome dos métodos, sem a necessidade de escrever SQL manualmente em consultas simples.

Exemplo:

```java
findTop5ByOrderByPrecoAsc()
```

Esse método representa uma consulta para obter os cinco produtos com menor preço.

## Exemplos de funcionalidades

### Clientes

* Cadastro e consulta de clientes;
* Busca por e-mail;
* Atualização do e-mail de um cliente;
* Exclusão de clientes;

### Produtos

* Cadastro e consulta de produtos;
* Busca por nome;
* Busca por faixa de preço;
* Consulta dos cinco produtos mais baratos.

### Pedidos

* Cadastro de pedidos;
* Consulta de pedidos;
* Consulta por intervalo de datas;
* Validação para impedir o cadastro de pedidos com datas futuras.

## Finalidade

Este projeto não tem como objetivo ser uma aplicação comercial ou uma API pronta para produção.

Ele está sendo utilizado como um **ambiente de estudos**, permitindo experimentar e compreender na prática conceitos do Spring Boot e do desenvolvimento de APIs REST.

À medida que novos conceitos forem estudados, o projeto poderá ser expandido e refatorado para aplicar práticas mais avançadas de desenvolvimento.

## Status

**Em desenvolvimento / aprendizado**

Novas funcionalidades e melhorias poderão ser adicionadas conforme o aprendizado dos conceitos de Spring Boot, Spring Data JPA e desenvolvimento de APIs REST.
