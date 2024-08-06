package com.laboratorio_fisica.service;

import com.laboratorio_fisica.dto.EquipamentoDto;
import com.laboratorio_fisica.model.Equipamento;

import java.util.List;

public interface EquipamentoService {

    Equipamento save(EquipamentoDto dto);

    List<Equipamento> findAll();

    Equipamento findById(Long id);

    Equipamento update(EquipamentoDto dto, Long id);

    Void delete(Long id);
}
