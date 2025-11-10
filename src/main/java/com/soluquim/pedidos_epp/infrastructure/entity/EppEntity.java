package com.soluquim.pedidos_epp.infrastructure.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "epp")
public class EppEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String tipo;
    private String detalle;
    private LocalDateTime fechaRegistro;

    @OneToOne(mappedBy = "epp")
    private StockEntity stock;
}
