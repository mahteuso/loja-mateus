package com.laboratorio_fisica.service;

import com.laboratorio_fisica.dto.EquipamentoDto;
import com.laboratorio_fisica.model.Equipamento;
import org.springframework.ui.Model;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

public interface EquipamentoService {

    Equipamento save(EquipamentoDto dto, BindingResult bindingResult, ModelAndView mv);

    List<Equipamento> findAll();

    Equipamento findById(Long id);

    Equipamento update(EquipamentoDto dto, Long id);


    List<Equipamento> findByName(String nome);
    void delete(Long id);
}
