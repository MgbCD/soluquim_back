package com.soluquim.pedidos_epp.application.service;

import com.soluquim.pedidos_epp.application.dto.PedidoRequestDTO;
import com.soluquim.pedidos_epp.application.dto.PedidoResponseDTO;
import com.soluquim.pedidos_epp.domain.model.Empresa;
import com.soluquim.pedidos_epp.domain.model.Epp;
import com.soluquim.pedidos_epp.domain.model.Pedido;
import com.soluquim.pedidos_epp.infrastructure.entity.EmpresaEntity;
import com.soluquim.pedidos_epp.infrastructure.entity.EppEntity;
import com.soluquim.pedidos_epp.infrastructure.entity.PedidoEntity;
import com.soluquim.pedidos_epp.infrastructure.entity.PedidoEppEntity;

import java.util.List;
import java.util.stream.Collectors;

public class PedidoMapper {
    public static Pedido toDomain(PedidoRequestDTO dto, Empresa empresa) {
        Pedido pedido = new Pedido();
        pedido.setEmpresa(empresa);
        pedido.setEstado(dto.getEstado());
        pedido.setValorTotal(dto.getValorTotal());
        return pedido;
    }

    public static PedidoResponseDTO toResponseDTO(Pedido pedido) {
        return PedidoResponseDTO.builder()
                .id(pedido.getId())
                .empresa(pedido.getEmpresa().getNombre())
                .estado(pedido.getEstado())
                .valorTotal(pedido.getValorTotal())
                .fechaRegistro(pedido.getFechaRegistro())
                .items(pedido.getEpps() != null ?
                        pedido.getEpps().stream()
                                .map(Epp::getNombre)
                                .collect(Collectors.toList())
                        : null)
                .build();
    }
    public static Pedido toDomain(PedidoEntity entity) {
        if (entity == null) return null;

        Pedido pedido = new Pedido();
        pedido.setId(entity.getId());

        Empresa empresa = new Empresa();
        empresa.setId(entity.getEmpresa().getId());
        empresa.setNombre(entity.getEmpresa().getNombre());
        pedido.setEmpresa(empresa);
        pedido.setEstado(entity.getEstado());
        pedido.setValorTotal(entity.getValorTotal());
        pedido.setFechaRegistro(entity.getFechaRegistro());

        if (entity.getPedidoEpps() != null) {
            pedido.setEpps(
                    entity.getPedidoEpps().stream()
                            .map(pe -> {
                                Epp ep = new Epp();
                                ep.setId(pe.getEpp().getId());
                                ep.setNombre(pe.getEpp().getNombre());
                                return ep;
                            })
                            .collect(Collectors.toList())
            );
        }

        return pedido;
    }

    public static PedidoEntity toEntity(Pedido pedido) {
        if (pedido == null) return null;

        PedidoEntity entity = new PedidoEntity();
        entity.setId(pedido.getId());

        EmpresaEntity empresaEntity = new EmpresaEntity();
        empresaEntity.setId(pedido.getEmpresa().getId());
        empresaEntity.setNombre(pedido.getEmpresa().getNombre());
        entity.setEmpresa(empresaEntity);

        entity.setEstado(pedido.getEstado());
        entity.setValorTotal(pedido.getValorTotal());
        entity.setFechaRegistro(pedido.getFechaRegistro());

        if (pedido.getEpps() != null) {
            entity.setPedidoEpps(
                    pedido.getEpps().stream()
                            .map(ep -> {
                                PedidoEppEntity pe = new PedidoEppEntity();
                                EppEntity eppEntity = new EppEntity();
                                eppEntity.setId(ep.getId());
                                eppEntity.setNombre(ep.getNombre());
                                pe.setEpp(eppEntity);
                                pe.setPedido(entity);
                                pe.setCantidad(1);
                                return pe;
                            })
                            .collect(Collectors.toList())
            );
        }

        return entity;
    }

    public static Pedido toDomain(PedidoRequestDTO dto, Empresa empresa, List<Epp> epps) {
        Pedido pedido = new Pedido();
        pedido.setEmpresa(empresa);
        pedido.setEstado(dto.getEstado());
        pedido.setValorTotal(dto.getValorTotal());
        pedido.setEpps(epps);
        return pedido;
    }



}
