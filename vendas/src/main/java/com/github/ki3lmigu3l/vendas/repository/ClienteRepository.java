package com.github.ki3lmigu3l.vendas.repository;

import com.github.ki3lmigu3l.vendas.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
}
