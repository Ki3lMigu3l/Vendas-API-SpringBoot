# Vendas

Uma API de Vendas desenvolvida com Spring Boot, que permite o gerenciamento de pedidos, clientes e produtos. Inclui funcionalidades para criar, listar e buscar pedidos, além de calcular o total de cada venda. A API utiliza JPA para persistência de dados, e está integrada com bancos de dados.

<div align="center">
    <h3 align="center">Tecnologias e padrão de API utilizada</h3>
        <img width="50" src="https://user-images.githubusercontent.com/25181517/117201156-9a724800-adec-11eb-9a9d-3cd0f67da4bc.png" alt="Java" title="Java"/>
        <img width="50" src="https://user-images.githubusercontent.com/25181517/183891303-41f257f8-6b3d-487c-aa56-c497b880d0fb.png" alt="Spring Boot" title="Spring Boot"/>
        <img width="50" src="https://user-images.githubusercontent.com/25181517/186711335-a3729606-5a78-4496-9a36-06efcc74f800.png" alt="Swagger" title="Swagger"/>
        <img width="50" src="https://user-images.githubusercontent.com/25181517/192107858-fe19f043-c502-4009-8c47-476fc89718ad.png" alt="REST" title="REST"/>
        <img width="50" src="https://user-images.githubusercontent.com/25181517/117207242-07d5a700-adf4-11eb-975e-be04e62b984b.png" alt="Maven" title="Maven"/>
</div>

<br>

### Diagrama de Classes

```mermaid
classDiagram
    direction LR
    class Pedido {
        +Integer id
        +LocalDate dataPedido
        +BigDecimal valorTotal
        +List~ItemPedido~ itensPedidos
        +Cliente cliente
        +getters()
        +setters()
    }
    
    class Cliente {
        +Integer id
        +String nome
        +String cpf
        +getters()
        +setters()
    }

    class ItemPedido {
        +Integer id
        +Integer quantidadeDeItens
        +Produto produto
        +Pedido pedido
        +getters()
        +setters()
    }

    class Produto {
        +Integer id
        +String nome
        +BigDecimal preco
        +getters()
        +setters()
    }

    Pedido "1" --> "0..*" ItemPedido
    Cliente "1" --> "0..*" Pedido
    ItemPedido "1" --> "1" Produto
```
