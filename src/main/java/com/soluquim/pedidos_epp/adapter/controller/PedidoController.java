package com.soluquim.pedidos_epp.adapter.controller;

import com.soluquim.pedidos_epp.application.dto.PedidoRequestDTO;
import com.soluquim.pedidos_epp.application.dto.PedidoResponseDTO;
import com.soluquim.pedidos_epp.application.service.CrearPedidoService;
import com.soluquim.pedidos_epp.application.service.ListarPedidosService;
import com.soluquim.pedidos_epp.domain.model.Empresa;
import com.soluquim.pedidos_epp.domain.repository.EmpresaRepositoryPort;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {

    private final CrearPedidoService crearPedidoService;
    private final ListarPedidosService listarPedidosService;
    private final EmpresaRepositoryPort empresaRepository;

    public PedidoController(CrearPedidoService crearPedidoService,
                            ListarPedidosService listarPedidosService,
                            EmpresaRepositoryPort empresaRepository) {
        this.crearPedidoService = crearPedidoService;
        this.listarPedidosService = listarPedidosService;
        this.empresaRepository = empresaRepository;
    }


    @PostMapping
    public PedidoResponseDTO crearPedido(@Valid @RequestBody PedidoRequestDTO dto) {
        Empresa empresa = empresaRepository.buscarPorId(dto.getIdEmpresa())
                .orElseThrow(() -> new RuntimeException("Empresa no encontrada con ID: " + dto.getIdEmpresa()));

        return crearPedidoService.crearPedido(dto, empresa);
    }

    @GetMapping
    public List<PedidoResponseDTO> listarPedidos(@RequestParam(defaultValue = "0") int page,
                                                 @RequestParam(defaultValue = "10") int size) {
        return listarPedidosService.listarPedidos(page, size);
    }

    @GetMapping("/{id}")
    public PedidoResponseDTO obtenerPedido(@PathVariable Long id) {
        return listarPedidosService.obtenerPedido(id);
    }
}