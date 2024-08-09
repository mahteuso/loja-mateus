package com.laboratorio_fisica.exception.handler;

import com.laboratorio_fisica.controller.EquipamentoController;
import com.laboratorio_fisica.dto.EquipamentoDto;
import com.laboratorio_fisica.dto.error.ErrorResponseDto;
import com.laboratorio_fisica.exception.BadRequestException;
import com.laboratorio_fisica.exception.NotFoundException;
import com.laboratorio_fisica.service.EquipamentoService;
import com.laboratorio_fisica.service.impl.EquipamentoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ResourceHandler {


    @ExceptionHandler(NotFoundException.class)
    public ModelAndView notFoundException(NotFoundException n) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("cadastro/find");
        String messages = n.getMessage();
        mv.addObject("msg", messages);
        return mv;
    }

    @ExceptionHandler(BadRequestException.class)
    public ModelAndView badRequestException(BadRequestException b) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("cadastro/editar");
        String messages = b.getMessage();
        mv.addObject("msg", messages);
        return mv;
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public static ModelAndView methodArgumentNotValidException(BindingResult bindingResult, ModelAndView mv) {
        Map<String, String> msg = new HashMap<>();
        bindingResult.getAllErrors().forEach(error ->
        {
            String field = ((FieldError) error).getField();
            String message = error.getDefaultMessage();
            msg.put(field, message);
        });
        mv.addObject("msg", msg);
        return mv;
    }


    @ExceptionHandler(BindException.class)
    public static ModelAndView methodArgumentNotValidExceptionTwo(BindingResult bindingResult, ModelAndView mv) {
        Map<String, String> msg = new HashMap<>();
        bindingResult.getAllErrors().forEach(error ->
        {
            String field = ((FieldError) error).getField();
            String message = error.getDefaultMessage();
            msg.put(field, message);
        });
        mv.addObject("msg", msg);
        return mv;
    }


}
