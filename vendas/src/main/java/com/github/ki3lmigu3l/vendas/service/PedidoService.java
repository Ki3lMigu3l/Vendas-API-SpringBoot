package com.github.ki3lmigu3l.vendas.service;

import com.github.ki3lmigu3l.vendas.dto.PedidoRecordDTO;
import com.github.ki3lmigu3l.vendas.model.Pedido;

import java.util.List;

public interface PedidoService {
    Pedido savePedido(PedidoRecordDTO dto);
    List<Pedido> findAll();
}
