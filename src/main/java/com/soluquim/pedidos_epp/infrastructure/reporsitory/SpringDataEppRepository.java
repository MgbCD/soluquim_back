package com.soluquim.pedidos_epp.infrastructure.reporsitory;

import com.soluquim.pedidos_epp.infrastructure.entity.EppEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataEppRepository extends JpaRepository<EppEntity, Long> {

}