package com.soluquim.pedidos_epp.infrastructure.reporsitory;

import com.soluquim.pedidos_epp.infrastructure.entity.EmpresaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataEmpresaRepository extends JpaRepository<EmpresaEntity, Long> {

}