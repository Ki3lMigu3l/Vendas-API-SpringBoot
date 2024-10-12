package com.github.ki3lmigu3l.vendas.repository;

import com.github.ki3lmigu3l.vendas.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
}
