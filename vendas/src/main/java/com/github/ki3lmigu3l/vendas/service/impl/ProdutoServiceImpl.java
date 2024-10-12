package com.github.ki3lmigu3l.vendas.service.impl;

import com.github.ki3lmigu3l.vendas.model.Produto;
import com.github.ki3lmigu3l.vendas.repository.ProdutoRepository;
import com.github.ki3lmigu3l.vendas.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoServiceImpl implements ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Override
    public Produto save(Produto produto) {
        return produtoRepository.save(produto);
    }

    @Override
    public List<Produto> findAll(Example example) {
        return produtoRepository.findAll(example);
    }

    @Override
    public Optional<Produto> findById(Integer id) {
        return produtoRepository.findById(id);
    }

    @Override
    public void delete(Produto produto) {
        produtoRepository.delete(produto);
    }
}