package com.github.ki3lmigu3l.vendas.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "nome", length = 100)
    private String nome;

    @Column(name = "cpf", length = 11)
    private String cpf;

    @JsonIgnore
    @OneToMany(mappedBy = "cliente", fetch = FetchType.LAZY)
    private Set<Pedido> pedidoSet;

    public Cliente(){}

    public Cliente(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Cliente(Integer id, String nome, String cpf, Set<Pedido> pedidoSet) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.pedidoSet = pedidoSet;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Set<Pedido> getPedidoSet() {
        return pedidoSet;
    }

    public void setPedidoSet(Set<Pedido> pedidoSet) {
        this.pedidoSet = pedidoSet;
    }
}
