package com.laboratorio_fisica.service.impl;

import com.laboratorio_fisica.dto.EquipamentoDto;
import com.laboratorio_fisica.mapper.EquipamentoMapper;
import com.laboratorio_fisica.model.Equipamento;
import com.laboratorio_fisica.repository.EquipamentoRepository;
import com.laboratorio_fisica.service.EquipamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EquipamentoServiceImpl implements EquipamentoService {

    @Autowired
    private EquipamentoRepository equipamentoRepository;

    @Override
    public Equipamento save(EquipamentoDto dto) {
        return equipamentoRepository.save(EquipamentoMapper.FromDtoToEntity(dto));
    }

    @Override
    public List<Equipamento> findAll() {
        return equipamentoRepository.findAll();
    }

    @Override
    public Equipamento findById(Long id) {
        return null;
    }

    @Override
    public Equipamento update(EquipamentoDto dto, Long id) {
        return null;
    }

    @Override
    public Void delete(Long id) {
        return null;
    }
}
