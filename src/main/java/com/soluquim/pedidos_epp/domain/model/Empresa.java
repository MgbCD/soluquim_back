package com.soluquim.pedidos_epp.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class Empresa {
    private Long id;
    private String nombre;
    private String nit;
    private String direccion;
    private String telefono;
    private String email;
    private LocalDateTime fechaRegistro;

    public Empresa() {}


}
