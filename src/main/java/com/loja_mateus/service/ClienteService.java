package com.loja_mateus.service;

import com.loja_mateus.dto.ClienteDto;
import com.loja_mateus.model.Equipamento;

import java.util.List;

public interface ClienteService {

    Equipamento save(ClienteDto dto);

    List<Equipamento> findAll();

    Equipamento findById(Long id);

    Equipamento update(ClienteDto dto, Long id);
}
