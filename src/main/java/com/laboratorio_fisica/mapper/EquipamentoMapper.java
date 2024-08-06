package com.laboratorio_fisica.mapper;

import com.laboratorio_fisica.dto.EquipamentoDto;
import com.laboratorio_fisica.model.Equipamento;

public class EquipamentoMapper {

    public static Equipamento FromDtoToEntity(EquipamentoDto dto){
        return Equipamento.builder()
                .id(dto.getId())
                .nome(dto.getNome())
                .descricao(dto.getDescricao())
                .patrimonio(dto.getPatrimonio())
                .dataCriacao(dto.getDataCriacao())
                .ativo(dto.getAtivo())
                .build();
    }
}
