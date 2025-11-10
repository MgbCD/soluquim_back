package com.soluquim.pedidos_epp.application.service;

import com.soluquim.pedidos_epp.application.dto.PedidoResponseDTO;
import com.soluquim.pedidos_epp.domain.exception.PedidoNotFoundException;
import com.soluquim.pedidos_epp.domain.model.Pedido;
import com.soluquim.pedidos_epp.domain.repository.PedidoRepositoryPort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ListarPedidosService {

    private final PedidoRepositoryPort pedidoRepository;

    public ListarPedidosService(PedidoRepositoryPort pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    public List<PedidoResponseDTO> listarPedidos(int pagina, int tamanio) {
        List<Pedido> pedidos = pedidoRepository.listar(pagina, tamanio);
        return pedidos.stream().map(PedidoMapper::toResponseDTO).collect(Collectors.toList());
    }

    public PedidoResponseDTO obtenerPedido(Long id) {
        Pedido pedido = pedidoRepository.obtenerPorId(id)
                .orElseThrow(() -> new PedidoNotFoundException("Pedido con ID " + id + " no encontrado"));
        return PedidoMapper.toResponseDTO(pedido);
    }
}