package com.github.ki3lmigu3l.vendas.model;

import jakarta.persistence.*;

@Entity
@Table(name = "item_pedido")
public class ItemPedido {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "pedido_ID")
    private Pedido pedido;

    @ManyToOne
    @JoinColumn(name = "produto_ID")
    private Produto produto;

    @Column(name = "qtd_pedidos")
    private Integer quantidadeDePedidos;

    public ItemPedido() {
    }

    public ItemPedido(Integer id, Pedido pedido, Produto produto, Integer quantidadeDePedidos) {
        this.id = id;
        this.pedido = pedido;
        this.produto = produto;
        this.quantidadeDePedidos = quantidadeDePedidos;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Integer getQuantidadeDePedidos() {
        return quantidadeDePedidos;
    }

    public void setQuantidadeDePedidos(Integer quantidadeDePedidos) {
        this.quantidadeDePedidos = quantidadeDePedidos;
    }
}
