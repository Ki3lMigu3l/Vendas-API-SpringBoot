package com.github.ki3lmigu3l.vendas.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "pedido")
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "cliente_ID")
    private Cliente cliente;

    @Column(name = "pedido_Data")
    private LocalDate dataPedido;

    @Column(name = "total", precision = 20, scale = 2)
    private BigDecimal valorTotal;

    @OneToMany(mappedBy = "pedido")
    private List<ItemPedido> itensPedidos;

    public Pedido() {
    }

    public Pedido(Integer id, Cliente cliente, LocalDate dataPedido, BigDecimal valorTotal, List<ItemPedido> itensPedidos) {
        this.id = id;
        this.cliente = cliente;
        this.dataPedido = dataPedido;
        this.valorTotal = valorTotal;
        this.itensPedidos = itensPedidos;
    }

    public List<ItemPedido> getItensPedidos() {
        return itensPedidos;
    }

    public void setItensPedidos(List<ItemPedido> itensPedidos) {
        this.itensPedidos = itensPedidos;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public LocalDate getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(LocalDate dataPedido) {
        this.dataPedido = dataPedido;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }
}
