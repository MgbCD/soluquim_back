package com.soluquim.pedidos_epp.infrastructure.reporsitory;

import com.soluquim.pedidos_epp.infrastructure.entity.PedidoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface  SpringDataPedidoRepository extends JpaRepository<PedidoEntity, Long> {

}
