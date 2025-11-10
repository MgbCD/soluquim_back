package com.soluquim.pedidos_epp.infrastructure.impl;

import com.soluquim.pedidos_epp.application.service.EmpresaMapper;
import com.soluquim.pedidos_epp.domain.model.Empresa;
import com.soluquim.pedidos_epp.domain.repository.EmpresaRepositoryPort;
import com.soluquim.pedidos_epp.infrastructure.reporsitory.SpringDataEmpresaRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class EmpresaRepositoryAdapter implements EmpresaRepositoryPort {
    private final SpringDataEmpresaRepository repository;

    public EmpresaRepositoryAdapter(SpringDataEmpresaRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Empresa> listar() {
        return repository.findAll()
                .stream()
                .map(EmpresaMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Empresa guardar(Empresa empresa) {
        var entity = EmpresaMapper.toEntity(empresa);
        var saved = repository.save(entity);
        return EmpresaMapper.toDomain(saved);
    }

    @Override
    public Optional<Empresa> buscarPorId(Long id) {
        return repository.findById(id).map(EmpresaMapper::toDomain);
    }
}