package com.laboratorio_fisica.controller;

import com.laboratorio_fisica.dto.UserDto;
import com.laboratorio_fisica.model.User;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("auth")
public class AuthenticationController {

    @PostMapping("/login")
    public String login(@Valid UserDto dto){
        return null;
    }
}
