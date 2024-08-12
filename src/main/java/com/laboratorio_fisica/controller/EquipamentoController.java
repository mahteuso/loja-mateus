package com.laboratorio_fisica.controller;

import com.laboratorio_fisica.dto.EquipamentoDto;
import com.laboratorio_fisica.exception.handler.ResourceHandler;
import com.laboratorio_fisica.service.EquipamentoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Controller
@RequestMapping
public class EquipamentoController {

    @Autowired
    private EquipamentoService equipamentoService;
    ''

    @GetMapping({"", "/"})
    public String index(Model model) {
        model.addAttribute("equipamentos", equipamentoService.findAll());
        return "/index";
    }

    @GetMapping("/equipamentos-cadastro")
    public String cadastrar(Model model) {
        model.addAttribute("equipamentos", new EquipamentoDto());
        return "cadastro/cadastro_equipamento";
    }

    @PostMapping("/cadastrado")
    public ModelAndView save(@Valid EquipamentoDto dto, BindingResult bindingResult, ModelAndView mv) {
        LocalDate hoje = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String formatado = hoje.format(formatter);
        dto.setDataCriacao(formatado);
        equipamentoService.save(dto, bindingResult, mv);
        if (equipamentoService.save(dto, bindingResult, mv) == null) {
            mv.addObject("equipamentos", dto);
            mv.setViewName("cadastro/cadastro_equipamento");
            return mv;
        }
        mv.addObject("equipamentos", dto);
        mv.setViewName("cadastro/sucesso");
        return mv;
    }

    @PostMapping("/update/{id}")
    public String update(@Valid EquipamentoDto dto, @PathVariable("id") Long id, Model model) {
        LocalDate hoje = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String formatado = hoje.format(formatter);
        dto.setDataCriacao(formatado);
        equipamentoService.update(dto, id);
        model.addAttribute("equipamentos", dto);
        return "cadastro/sucesso";
    }

    @GetMapping("/deletar/{id}")
    public String delete(@PathVariable Long id, Model model) {
        equipamentoService.delete(id);
        model.addAttribute("equipamentos", equipamentoService.findAll());
        return "/index";
    }

    @GetMapping("/editar/{id}")
    public ModelAndView editar(@PathVariable("id") Long id) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("cadastro/editar");
        mv.addObject("equipamento", equipamentoService.findById(id));
        return mv;
    }

    @PostMapping("/pesquisar")
    public String findByName(@RequestParam("nomepesquisa") String nome, Model model) {
        model.addAttribute("equipamentos", equipamentoService.findByName(nome));
        return "cadastro/find";
    }

    @GetMapping("/dados/{id}")
    public String dadosEquipamento(@PathVariable("id") Long id, Model model) {
        model.addAttribute("equipamento", equipamentoService.findById(id));
        return "cadastro/dados_equipamentos";
    }
}
