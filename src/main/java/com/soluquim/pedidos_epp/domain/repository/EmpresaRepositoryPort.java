package com.soluquim.pedidos_epp.domain.repository;

import com.soluquim.pedidos_epp.domain.model.Empresa;

import java.util.List;
import java.util.Optional;

public interface EmpresaRepositoryPort {
    List<Empresa> listar();
    Empresa guardar(Empresa empresa);
    Optional<Empresa> buscarPorId(Long id);
}
