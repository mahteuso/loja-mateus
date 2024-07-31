package com.loja_mateus.service;

import com.loja_mateus.dto.ClienteDto;
import com.loja_mateus.model.Cliente;

import java.util.List;

public interface ClienteService {

    Cliente save(ClienteDto dto);

    List<Cliente> findAll();

    Cliente findById(Long id);
}
