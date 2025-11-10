package com.soluquim.pedidos_epp.application.service;

import com.soluquim.pedidos_epp.application.dto.EppResponseDTO;
import com.soluquim.pedidos_epp.domain.model.Epp;
import com.soluquim.pedidos_epp.infrastructure.entity.EppEntity;

public class EppMapper {

    public static Epp toDomain(EppEntity entity) {
        if (entity == null) return null;

        Epp epp = new Epp();
        epp.setId(entity.getId());
        epp.setNombre(entity.getNombre());
        epp.setTipo(entity.getTipo());
        epp.setDetalle(entity.getDetalle());
        epp.setFechaRegistro(entity.getFechaRegistro());
        return epp;
    }

    public static EppResponseDTO toDTO(Epp epp) {
        if (epp == null) return null;

        return EppResponseDTO.builder()
                .id(epp.getId())
                .nombre(epp.getNombre())
                .tipo(epp.getTipo())
                .detalle(epp.getDetalle())
                .build();
    }


    public static EppEntity toEntity(Epp epp) {
        if (epp == null) return null;

        EppEntity entity = new EppEntity();
        entity.setId(epp.getId());
        entity.setNombre(epp.getNombre());
        entity.setTipo(epp.getTipo());
        entity.setDetalle(epp.getDetalle());
        entity.setFechaRegistro(epp.getFechaRegistro());
        return entity;
    }
}
