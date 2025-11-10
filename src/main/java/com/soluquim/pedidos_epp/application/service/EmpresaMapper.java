package com.soluquim.pedidos_epp.application.service;

import com.soluquim.pedidos_epp.application.dto.EmpresaResponseDTO;
import com.soluquim.pedidos_epp.domain.model.Empresa;
import com.soluquim.pedidos_epp.infrastructure.entity.EmpresaEntity;

public class EmpresaMapper {

    public static Empresa toDomain(EmpresaEntity entity) {
        if (entity == null) return null;

        Empresa emp = new Empresa();
        emp.setId(entity.getId());
        emp.setNombre(entity.getNombre());
        emp.setFechaRegistro(entity.getFechaRegistro());
        return emp;
    }

    public static EmpresaResponseDTO toDTO(Empresa empresa) {
        if (empresa == null) return null;

        return EmpresaResponseDTO.builder()
                .id(empresa.getId())
                .nombre(empresa.getNombre())
                .build();
    }


    public static EmpresaEntity toEntity(Empresa empresa) {
        if (empresa == null) return null;

        EmpresaEntity entity = new EmpresaEntity();
        entity.setId(empresa.getId());
        entity.setNombre(empresa.getNombre());
        entity.setFechaRegistro(empresa.getFechaRegistro());

        if (empresa.getNit() == null) {
            throw new IllegalArgumentException("El NIT no puede ser nulo");
        }
        entity.setNit(empresa.getNit());

        return entity;
    }
}

