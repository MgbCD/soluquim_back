package com.soluquim.pedidos_epp.infrastructure.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;


@Entity
@Table(name = "stock")
public class StockEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "id_epp")
    private EppEntity epp;

    private int cantidadDisponible;
    private LocalDateTime fechaActualizacion;
}
