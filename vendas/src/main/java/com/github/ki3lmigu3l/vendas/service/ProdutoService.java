package com.github.ki3lmigu3l.vendas.service;

import com.github.ki3lmigu3l.vendas.model.Produto;
import org.springframework.data.domain.Example;

import java.util.List;
import java.util.Optional;

public interface ProdutoService {

    Produto save(Produto produto);

    List<Produto> findAll(Example example);

    Optional<Produto> findById(Integer id);

    void delete(Produto produto);
}
