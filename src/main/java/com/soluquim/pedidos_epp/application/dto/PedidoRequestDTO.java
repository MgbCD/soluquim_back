package com.soluquim.pedidos_epp.application.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class PedidoRequestDTO {
    @NotNull
    private Long idEmpresa;

    @NotBlank
    private String estado;

    @NotNull
    @DecimalMin(value = "0.0", inclusive = false)
    private BigDecimal valorTotal;

    @NotEmpty
    private List<Long> eppIds;
}
