package com.soluquim.pedidos_epp.application.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EppResponseDTO {
    private Long id;
    private String nombre;
    private String tipo;
    private String detalle;
}
