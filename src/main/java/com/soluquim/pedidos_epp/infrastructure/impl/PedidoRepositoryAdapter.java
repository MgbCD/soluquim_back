package com.soluquim.pedidos_epp.infrastructure.impl;

import com.soluquim.pedidos_epp.application.service.PedidoMapper;
import com.soluquim.pedidos_epp.domain.model.Pedido;
import com.soluquim.pedidos_epp.domain.repository.PedidoRepositoryPort;
import com.soluquim.pedidos_epp.infrastructure.entity.PedidoEntity;
import org.springframework.data.domain.PageRequest;
import com.soluquim.pedidos_epp.infrastructure.reporsitory.SpringDataPedidoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class PedidoRepositoryAdapter implements PedidoRepositoryPort {

    private final SpringDataPedidoRepository repository;

    public PedidoRepositoryAdapter(SpringDataPedidoRepository repository) {
        this.repository = repository;
    }

    @Override
    public Pedido guardar(Pedido pedido){
        PedidoEntity entity = PedidoMapper.toEntity(pedido);
        return PedidoMapper.toDomain(repository.save(entity));
    }

    @Override
    public Optional<Pedido> obtenerPorId(Long id) {
        return repository.findById(id).map(PedidoMapper::toDomain);
    }

    @Override
    public List<Pedido> listar(int pagina, int tamanio) {
        return repository.findAll(PageRequest.of(pagina, tamanio))
                .stream()
                .map(PedidoMapper::toDomain)
                .collect(Collectors.toList());
    }
}
