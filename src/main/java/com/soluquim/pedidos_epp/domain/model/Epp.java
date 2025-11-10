package com.soluquim.pedidos_epp.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Epp {
    private Long id;
    private String nombre;
    private String tipo;
    private String detalle;
    private LocalDateTime fechaRegistro;

}
