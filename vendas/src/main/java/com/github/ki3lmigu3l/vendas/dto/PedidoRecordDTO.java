package com.github.ki3lmigu3l.vendas.dto;

import java.math.BigDecimal;
import java.util.List;

public record PedidoRecordDTO(
        Integer clienteId,
        BigDecimal total,
        List<ItemPedidoRecordDTO> itensPedidos
) {
}
