# Transferência Tokio

## Descrição

Este é um projeto Java utilizando Spring Boot para gerenciar transferências financeiras. Utilizando API REST para registrar e consultar transferências bancárias.

## Tecnologias Utilizadas

- Java 17
- Spring Boot
- Spring Data JPA
- H2 Database
- Maven

## Estrutura do Projeto

- `TransferenciatokioApplication.java` - Classe principal do projeto.
- `controller` - Controlador responsável por expor os endpoints.
- `services` - Contém a lógica de negócio.
- `dto` - Objetos de transferência para entrada e saída de dados.
- `entities` - Entidade JPA que representa uma transferência.
- `repositories` - Interface para acesso ao banco de dados.

## TransferenciaService

O `TransferenciaService.java` é responsável por implementar a lógica de negócio das transferências bancárias. Ele possui dois métodos principais: `calcularTaxa` e `verificarDatas`.

- `verificarDatas`: Verifica se a data inserida pelo usuário é menor que o dia da solicitação.
- `calcularTaxa`: Calcula a taxa devida com base no intervalo entre as datas e retorna o valor final com as taxas aplicadas.

## Endpoints Principais

- `POST /transferencias` - Criar uma nova transferência
    - Corpo da requisição:
      ```json
      {
        "contaOrigem": "0123456789",
        "contaDestino": "9876543210",
        "valor": 100.50,
        "dataTransferencia": "2025-02-21"
      }
      ```
- `GET /transferencias` - Listar todas as transferências

## DTOs

Para garantir a segurança na transferência de dados, foram criados dois DTOs: `TransferenciaDTO` para entrada de dados e `TransferenciaResponseDTO` para o retorno das informações.

