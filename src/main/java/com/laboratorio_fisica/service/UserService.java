package com.laboratorio_fisica.service;

import com.laboratorio_fisica.dto.UserDto;
import com.laboratorio_fisica.model.User;

import java.util.List;

public interface UserService {

    User save(UserDto dto);
    List<User> findAll();

    User findById(Long id);

    User update(UserDto dto, Long id);

    void delete(Long id);
}
