package com.github.ki3lmigu3l.vendas.service;

import com.github.ki3lmigu3l.vendas.model.Cliente;
import org.springframework.data.domain.Example;

import java.util.List;
import java.util.Optional;

public interface ClienteService {

    Optional<Cliente> getClienteById(Integer id);

    Cliente save(Cliente cliente);

    void delete(Cliente c);

    List<Cliente> findAll(Example example);

    Optional<Cliente> findById(Integer clienteId);
}
