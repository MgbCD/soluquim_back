package com.soluquim.pedidos_epp.domain.repository;

import com.soluquim.pedidos_epp.domain.model.Pedido;
import java.util.List;
import java.util.Optional;


public interface PedidoRepositoryPort {
    Pedido guardar(Pedido pedido);
    Optional<Pedido> obtenerPorId(Long id);
    List<Pedido> listar(int pagina, int tamanio);
}