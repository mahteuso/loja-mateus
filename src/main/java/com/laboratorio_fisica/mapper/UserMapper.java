package com.laboratorio_fisica.mapper;

import com.laboratorio_fisica.dto.UserDto;
import com.laboratorio_fisica.model.User;

public class UserMapper {

    public static User fromDtoToEntity(UserDto dto){
        return User.builder()
                .id(dto.getId())
                .login(dto.getLogin())
                .password(dto.getPassword())
                .role(dto.getRole())
                .build();
    }
}
