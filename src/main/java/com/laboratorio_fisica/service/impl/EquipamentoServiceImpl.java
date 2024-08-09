package com.laboratorio_fisica.service.impl;

import com.laboratorio_fisica.controller.EquipamentoController;
import com.laboratorio_fisica.dto.EquipamentoDto;
import com.laboratorio_fisica.exception.BadRequestException;
import com.laboratorio_fisica.exception.NotFoundException;
import com.laboratorio_fisica.exception.handler.ResourceHandler;
import com.laboratorio_fisica.mapper.EquipamentoMapper;
import com.laboratorio_fisica.model.Equipamento;
import com.laboratorio_fisica.repository.EquipamentoRepository;
import com.laboratorio_fisica.service.EquipamentoService;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class EquipamentoServiceImpl implements EquipamentoService {

    @Autowired
    private EntityManager entityManager;

    @Autowired
    private EquipamentoRepository equipamentoRepository;



    @Override
    public Equipamento save(EquipamentoDto dto, BindingResult bindingResult, ModelAndView mv) {
       if (ifErrors(bindingResult, mv)){
           return null;
       }
        return equipamentoRepository.save(EquipamentoMapper.FromDtoToEntity(dto));
    }

    @Override
    public Equipamento update(EquipamentoDto dto, Long id) {
        idIsValid(id);
        return equipamentoRepository.save(EquipamentoMapper.FromDtoToEntity(dto));
    }

    @Override
    public List<Equipamento> findAll() {
        return equipamentoRepository.findAll();
    }

    @Override
    public Equipamento findById(Long id) {
        return idIsValid(id);
    }

    public List<Equipamento> findByName(final String nome) {

        String jpql = "SELECT e FROM Equipamento e WHERE UPPER(e.nome) LIKE UPPER(:nome)";
        if (this.entityManager.createQuery(jpql, Equipamento.class).setParameter("nome", nome + "%").getResultList().isEmpty()) {
            throw new NotFoundException("Equipamento não encontrado!");
        }
        return this.entityManager.createQuery(jpql, Equipamento.class).setParameter("nome", nome + "%").getResultList();
    }



    @Override
    public void delete(Long id) {
        idIsValid(id);
        equipamentoRepository.deleteById(id);
    }

    public Equipamento idIsValid(Long id) {
        Optional<Equipamento> equipamentoOptional = equipamentoRepository.findById(id);
        if (equipamentoOptional.isEmpty()) {
            throw new BadRequestException("Usar somente o identificadir ID para deletar");
        }
        return equipamentoOptional.get();
    }

    public Boolean ifErrors(BindingResult bindingResult, ModelAndView mv){
        if (bindingResult.hasErrors()){
            System.out.println("tem erros");
            ResourceHandler.methodArgumentNotValidException(bindingResult, mv);
            return true;
        }
        return false;
    }


}
