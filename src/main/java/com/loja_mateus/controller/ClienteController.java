package com.loja_mateus.controller;

import com.loja_mateus.dto.ClienteDto;
import com.loja_mateus.model.Cliente;
import com.loja_mateus.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@RequestMapping
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping("/cadastro-cliente")
    public String paginaCadastro() {

        return "cadastro/cadastrocliente";
    }

    @PostMapping("/cadastro-cliente/cadastrado")
    public ModelAndView cadastrar(ClienteDto dto) {
        return findAll();
    }

    @GetMapping
    public ModelAndView findAll() {
        ModelAndView andView = new ModelAndView("/index");
        Iterable<Cliente> clienteIt = clienteService.findAll();
        andView.addObject("clientes", clienteIt);
        return andView;
    }

    @GetMapping("/editar-cliente/{idcliente}")
    public ModelAndView editar(@PathVariable("idcliente") Long id) {
        ModelAndView mv = new ModelAndView("cadastro/cadastrocliente");
        Cliente cliente = clienteService.findById(id);
        mv.addObject("clienteobj", cliente);
        return mv;
    }

}
