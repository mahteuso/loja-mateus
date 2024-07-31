package com.loja_mateus.service.impl;

import com.loja_mateus.dto.ClienteDto;
import com.loja_mateus.mapper.ClienteMapper;
import com.loja_mateus.model.Cliente;
import com.loja_mateus.repository.ClienteRepository;
import com.loja_mateus.service.ClienteService;
import org.aspectj.weaver.ast.Var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public Cliente save(ClienteDto dto) {
        return clienteRepository.save(ClienteMapper.fromDtoToEntity(dto));
    }

    @Override
    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente findById(Long id) {

        Optional<Cliente> clienteOpt = clienteRepository.findById(id);
        if (clienteOpt.isEmpty()){
            return null;
        }
        return clienteOpt.get();
    }


}
