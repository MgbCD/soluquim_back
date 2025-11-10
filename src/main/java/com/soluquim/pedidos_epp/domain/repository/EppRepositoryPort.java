package com.soluquim.pedidos_epp.domain.repository;

import com.soluquim.pedidos_epp.domain.model.Empresa;
import com.soluquim.pedidos_epp.domain.model.Epp;

import java.util.List;


public interface  EppRepositoryPort {
    List<Epp> listar();
    Epp guardar(Epp epp);
}
