package com.soluquim.pedidos_epp.infrastructure.impl;

import com.soluquim.pedidos_epp.application.service.EppMapper;
import com.soluquim.pedidos_epp.domain.model.Epp;
import com.soluquim.pedidos_epp.domain.repository.EppRepositoryPort;
import com.soluquim.pedidos_epp.infrastructure.entity.EppEntity;
import com.soluquim.pedidos_epp.infrastructure.reporsitory.SpringDataEppRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class EppRepositoryAdapter  implements EppRepositoryPort {
    private final SpringDataEppRepository repository;

    public EppRepositoryAdapter(SpringDataEppRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Epp> listar() {
        return repository.findAll()
                .stream()
                .map(EppMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Epp guardar(Epp epp) {
        EppEntity entity = EppMapper.toEntity(epp);
        EppEntity saved = repository.save(entity);
        return EppMapper.toDomain(saved);
    }


}
