package com.github.ki3lmigu3l.vendas.service.impl;

import com.github.ki3lmigu3l.vendas.model.Cliente;
import com.github.ki3lmigu3l.vendas.repository.ClienteRepository;
import com.github.ki3lmigu3l.vendas.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public Optional<Cliente> getClienteById(Integer id) {
        return clienteRepository.findById(id);
    }

    @Override
    public Cliente save(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    public void delete(Cliente c) {
        clienteRepository.delete(c);
    }

    @Override
    public List<Cliente> findAll(Example example) {
        return clienteRepository.findAll(example);
    }

    @Override
    public Optional<Cliente> findById(Integer clienteId) {
        return clienteRepository.findById(clienteId);
    }
}
