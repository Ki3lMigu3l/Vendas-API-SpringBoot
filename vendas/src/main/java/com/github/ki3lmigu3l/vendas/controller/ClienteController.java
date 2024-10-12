package com.github.ki3lmigu3l.vendas.controller;

import com.github.ki3lmigu3l.vendas.model.Cliente;
import com.github.ki3lmigu3l.vendas.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente createCliente (@RequestBody Cliente cliente) {
        return clienteService.save(cliente);
    }

    @GetMapping("{id}")
    public Cliente getClienteById (@PathVariable Integer id) {
        return clienteService
                .getClienteById(id)
                .orElseThrow(() ->
                        new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não foi encontrado!"));
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete (@PathVariable Integer id) {
        clienteService
                .getClienteById(id)
                .map( c -> {
                    clienteService.delete(c);
                    return c;
                })
                .orElseThrow(() ->
                        new ResponseStatusException(HttpStatus.NOT_FOUND,
                                "Não foi possível excluir o cliente, cliente não encontrado."));
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update (@PathVariable Integer id, @RequestBody Cliente cliente) {
        clienteService
                .getClienteById(id)
                .map(c -> {
                    cliente.setId(c.getId());
                    clienteService.save(cliente);
                    return c;
                })
                .orElseThrow(() ->
                        new ResponseStatusException(HttpStatus.NOT_FOUND,
                                "Não foi possível atualizar o cliente, cliente não encontrado!"));
    }

    @GetMapping
    public List<Cliente> getClienteByFilter (Cliente filtro) {
        ExampleMatcher matcher = ExampleMatcher
                .matching()
                .withIgnoreCase()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);

        Example example = Example.of(filtro, matcher);
        return clienteService.findAll(example);
    }
}
