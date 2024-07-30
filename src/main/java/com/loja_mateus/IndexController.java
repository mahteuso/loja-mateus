package com.loja_mateus;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class IndexController {

    @GetMapping("/cadastro-cliente")
    public String index(){
        return "cadastro/cadastro-cliente";
    }
}
