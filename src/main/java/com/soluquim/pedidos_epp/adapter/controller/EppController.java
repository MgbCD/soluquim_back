package com.soluquim.pedidos_epp.adapter.controller;
import com.soluquim.pedidos_epp.domain.model.Epp;
import com.soluquim.pedidos_epp.domain.repository.EppRepositoryPort;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/epp")
public class EppController {
    private final EppRepositoryPort eppRepository;

    public EppController(EppRepositoryPort eppRepository) {
        this.eppRepository = eppRepository;
    }

    @GetMapping
    public List<Epp> listarEpps() {
        return eppRepository.listar();
    }
}
