package com.soluquim.pedidos_epp.application.service;

import com.soluquim.pedidos_epp.application.dto.PedidoRequestDTO;
import com.soluquim.pedidos_epp.application.dto.PedidoResponseDTO;
import com.soluquim.pedidos_epp.domain.model.Empresa;
import com.soluquim.pedidos_epp.domain.model.Epp;
import com.soluquim.pedidos_epp.domain.model.Pedido;
import com.soluquim.pedidos_epp.domain.repository.EppRepositoryPort;
import com.soluquim.pedidos_epp.domain.repository.PedidoRepositoryPort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CrearPedidoService {

    private final PedidoRepositoryPort pedidoRepository;
    private final EppRepositoryPort eppRepository;

    public CrearPedidoService(PedidoRepositoryPort pedidoRepository, EppRepositoryPort eppRepository) {
        this.pedidoRepository = pedidoRepository;
        this.eppRepository = eppRepository;
    }

    public PedidoResponseDTO crearPedido(PedidoRequestDTO dto, Empresa empresa) {
        List<Epp> epps = eppRepository.listar().stream()
                .filter(e -> dto.getEppIds().contains(e.getId()))
                .collect(Collectors.toList());

        Pedido pedido = PedidoMapper.toDomain(dto, empresa, epps);
        pedidoRepository.guardar(pedido);
        return PedidoMapper.toResponseDTO(pedido);
    }
}