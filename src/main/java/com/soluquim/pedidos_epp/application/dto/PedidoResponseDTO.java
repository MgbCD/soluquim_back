package com.soluquim.pedidos_epp.application.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
public class PedidoResponseDTO {
    private Long id;
    private String empresa;
    private LocalDateTime fechaRegistro;
    private String estado;
    private BigDecimal valorTotal;
    private List<String> items;

}
