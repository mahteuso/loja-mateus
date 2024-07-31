package com.loja_mateus.mapper;

import com.loja_mateus.dto.ClienteDto;
import com.loja_mateus.model.Cliente;

public class ClienteMapper {

    public static Cliente fromDtoToEntity(ClienteDto dto){
        return Cliente.builder()
                .id(dto.getId())
                .nome(dto.getNome())
                .sobrenome(dto.getSobrenome())
                .cpf(dto.getCpf())
                .telefone(dto.getTelefone())
                .email(dto.getEmail())
                .build();
    }
}
