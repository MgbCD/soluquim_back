package com.soluquim.pedidos_epp.infrastructure.config;

import com.soluquim.pedidos_epp.application.dto.PedidoRequestDTO;
import com.soluquim.pedidos_epp.application.service.CrearPedidoService;
import com.soluquim.pedidos_epp.domain.model.Empresa;
import com.soluquim.pedidos_epp.domain.model.Epp;
import com.soluquim.pedidos_epp.domain.repository.EmpresaRepositoryPort;
import com.soluquim.pedidos_epp.domain.repository.EppRepositoryPort;
import com.soluquim.pedidos_epp.domain.repository.PedidoRepositoryPort;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Component
public class DataSeeder implements CommandLineRunner {

    private final EppRepositoryPort eppRepository;
    private final PedidoRepositoryPort pedidoRepository;
    private final CrearPedidoService crearPedidoService;
    private final EmpresaRepositoryPort empresaRepository;

    public DataSeeder(EppRepositoryPort eppRepository,
                      EmpresaRepositoryPort empresaRepository,
                      PedidoRepositoryPort pedidoRepository,
                      CrearPedidoService crearPedidoService) {
        this.eppRepository = eppRepository;
        this.empresaRepository = empresaRepository;
        this.pedidoRepository = pedidoRepository;
        this.crearPedidoService = crearPedidoService;
    }

    @Override
    public void run(String... args) throws Exception {


        Epp epp1 = new Epp(null, "Guantes", "para primer uso", "Protección", LocalDateTime.now());
        Epp epp2 = new Epp(null, "Casco", "para primer uso", "Protección", LocalDateTime.now());
        Epp epp3 = new Epp(null, "chalecos", "para primer uso", "Protección", LocalDateTime.now());
        Epp epp4 = new Epp(null, "tapabocas", "para primer uso", "Proteccióna", LocalDateTime.now());
        Epp epp5 = new Epp(null, "Botas", "para primer uso", "Protección", LocalDateTime.now());


        List<Epp> eppsGuardados = Arrays.asList(epp1, epp2, epp3, epp4, epp5).stream()
                .map(eppRepository::guardar)
                .collect(Collectors.toList());


        Empresa empresa1 = new Empresa(null, "Empresa Gases", "123456789", "Calle", "3001112222", "prueba@empresa.com", LocalDateTime.now());
        Empresa empresa2 = new Empresa(null, "Empresa Quimicos", "987654321", "Calle", "3003334444", "prueba@empresa.com", LocalDateTime.now());
        Empresa empresa3 = new Empresa(null, "Empresa prueba", "343535", "Calle", "304353535", "prueba@empresa.com", LocalDateTime.now());
        Empresa empresa4 = new Empresa(null, "ProtecSegura", "1122", "Carrera", "3105556677", "prueba@protecsegura.com", LocalDateTime.now());
        Empresa empresa5 = new Empresa(null, "Distribuidora Industria", "55667", "Avenida", "3178889990", "prueba@industrialandina.com", LocalDateTime.now());

        empresa1 = empresaRepository.guardar(empresa1);
        empresa2 = empresaRepository.guardar(empresa2);
        empresa3 = empresaRepository.guardar(empresa3);
        empresa4 = empresaRepository.guardar(empresa4);
        empresa5 = empresaRepository.guardar(empresa5);

        Random random = new Random();


        for (int i = 1; i <= 10; i++) {
            PedidoRequestDTO dto = new PedidoRequestDTO();
            dto.setValorTotal(BigDecimal.valueOf(100 * i));
            dto.setEstado("PENDIENTE");

            Collections.shuffle(eppsGuardados);
            List<Long> eppIds = eppsGuardados.stream()
                    .limit(1 + random.nextInt(3))
                    .map(Epp::getId)
                    .collect(Collectors.toList());

            dto.setEppIds(eppIds);


            Empresa empresa = i % 2 == 0 ? empresa1 : empresa2;


            crearPedidoService.crearPedido(dto, empresa);
        }


    }
}