package com.soluquim.pedidos_epp.infrastructure.entity;


import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.*;

@Data
@Entity
@Table(name = "empresa")
public class EmpresaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String nit;
    private String direccion;
    private String telefono;
    private String email;
    private LocalDateTime fechaRegistro;

    @OneToMany(mappedBy = "empresa")
    private List<PedidoEntity> pedidos;
}
