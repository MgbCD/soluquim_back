package com.soluquim.pedidos_epp.application.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EmpresaResponseDTO {
    private Long id;
    private String nombre;
}
