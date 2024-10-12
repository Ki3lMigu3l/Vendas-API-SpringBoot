package com.github.ki3lmigu3l.vendas.controller;

import com.github.ki3lmigu3l.vendas.model.Produto;
import com.github.ki3lmigu3l.vendas.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Produto createProduto (@RequestBody Produto produto) {
        return produtoService.save(produto);
    }

    @GetMapping
    public List<Produto> getProdutosByFilter (Produto filtro) {
        ExampleMatcher exampleMatcher = ExampleMatcher
                .matching()
                .withIgnoreCase()
                .withStringMatcher(
                        ExampleMatcher.StringMatcher.CONTAINING
                );

        Example example = Example.of(filtro, exampleMatcher);
        return produtoService.findAll(example);
    }

    @GetMapping("{id}")
    public Produto getProdutoById (@PathVariable Integer id) {
        return produtoService
                .findById(id)
                .orElseThrow(() ->
                        new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto não encontrado."));
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateProduto (@PathVariable Integer id, @RequestBody Produto produto) {
        produtoService
                .findById(id)
                .map(p -> {
                    produto.setId(p.getId());
                    produtoService.save(produto);
                    return produto;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto não foi encontrado"));
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProduto (@PathVariable Integer id) {
        produtoService
                .findById(id)
                .map(p -> {
                    produtoService.delete(p);
                    return Void.TYPE;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto não encontrado."));
    }
}
