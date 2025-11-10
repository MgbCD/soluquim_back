package com.soluquim.pedidos_epp.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pedido {
    private Long id;
    private Empresa empresa;
    private LocalDateTime fechaRegistro;
    private String estado;
    private BigDecimal valorTotal;
    private List<Epp> epps;
}
