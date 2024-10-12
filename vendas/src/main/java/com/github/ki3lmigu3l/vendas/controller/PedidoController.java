package com.github.ki3lmigu3l.vendas.controller;

import com.github.ki3lmigu3l.vendas.dto.PedidoRecordDTO;
import com.github.ki3lmigu3l.vendas.model.Pedido;
import com.github.ki3lmigu3l.vendas.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Integer createPedido (@RequestBody PedidoRecordDTO dto) {
        Pedido pedido = pedidoService.savePedido(dto);
        return pedido.getId();
    }

    @GetMapping
    public List<Pedido> getAllPedidos() {
        return pedidoService.findAll();
    }
}
