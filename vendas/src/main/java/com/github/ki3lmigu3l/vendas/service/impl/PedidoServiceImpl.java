package com.github.ki3lmigu3l.vendas.service.impl;

import com.github.ki3lmigu3l.vendas.dto.ItemPedidoRecordDTO;
import com.github.ki3lmigu3l.vendas.dto.PedidoRecordDTO;
import com.github.ki3lmigu3l.vendas.model.Cliente;
import com.github.ki3lmigu3l.vendas.model.ItemPedido;
import com.github.ki3lmigu3l.vendas.model.Pedido;
import com.github.ki3lmigu3l.vendas.model.Produto;
import com.github.ki3lmigu3l.vendas.repository.ItemPedidoRepository;
import com.github.ki3lmigu3l.vendas.repository.PedidoRepository;
import com.github.ki3lmigu3l.vendas.service.ClienteService;
import com.github.ki3lmigu3l.vendas.service.PedidoService;
import com.github.ki3lmigu3l.vendas.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PedidoServiceImpl implements PedidoService {

    private final PedidoRepository pedidoRepository;
    private final ClienteService clienteService;
    private final ProdutoService produtoService;
    private final ItemPedidoRepository itemPedidoRepository;

    @Autowired
    public PedidoServiceImpl(PedidoRepository pedidoRepository,
                             ClienteService clienteService,
                             ProdutoService produtoService,
                             ItemPedidoRepository itemPedidoRepository) {
        this.pedidoRepository = pedidoRepository;
        this.clienteService = clienteService;
        this.produtoService = produtoService;
        this.itemPedidoRepository = itemPedidoRepository;
    }


    @Override
    public Pedido savePedido(PedidoRecordDTO dto) {
        Integer clienteId = dto.clienteId();
        Cliente cliente = clienteService
                .findById(clienteId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Código de cliente invalido."));

        Pedido pedido = new Pedido();
        pedido.setValorTotal(dto.total());
        pedido.setDataPedido(LocalDate.now());
        pedido.setCliente(cliente);

        List<ItemPedido> itensPedidos = converterItens(pedido, dto.itensPedidos());
        pedidoRepository.save(pedido);
        itemPedidoRepository.saveAll(itensPedidos);
        pedido.setItensPedidos(itensPedidos);
        return pedido;
    }

    @Override
    public List<Pedido> findAll() {
        return pedidoRepository.findAll();
    }

    private List<ItemPedido> converterItens (Pedido pedido, List<ItemPedidoRecordDTO> itens) {
        if (itens.isEmpty()) {
            throw new RuntimeException("Não é possível realizar um pedido sem itens.");
        }

        return itens
                .stream()
                .map( dto -> {
                    Integer produtoId = dto.produto();
                    Produto produto = produtoService
                            .findById(produtoId)
                            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Código do protudo inválido: " + produtoId));

                    ItemPedido itemPedido = new ItemPedido();
                    itemPedido.setQuantidadeDeItens(dto.quantidadeDeProdutos());
                    itemPedido.setPedido(pedido);
                    itemPedido.setProduto(produto);
                    return itemPedido;
                }).collect(Collectors.toList());
    }
}
