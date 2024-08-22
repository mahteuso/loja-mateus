package com.laboratorio_fisica.service.impl;

import com.laboratorio_fisica.dto.UserDto;
import com.laboratorio_fisica.exception.BadRequestException;
import com.laboratorio_fisica.exception.NotFoundException;
import com.laboratorio_fisica.mapper.UserMapper;
import com.laboratorio_fisica.model.User;
import com.laboratorio_fisica.repository.UserRepository;
import com.laboratorio_fisica.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User save(UserDto dto) {
        return userRepository.save(UserMapper.fromDtoToEntity(dto));
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(Long id){
        Optional<User> opt = userRepository.findById(id);
        if (opt.isEmpty()){
            throw new NotFoundException("User not found!");
        }
        return opt.get();
    }

    @Override
    public User update(UserDto dto, Long id) {
        idIsValid(id);
        return userRepository.save(UserMapper.fromDtoToEntity(dto));
    }

    @Override
    public void delete(Long id) {
        idIsValid(id);
        userRepository.deleteById(id);
    }

    public boolean idIsValid(Long id){
        Optional<User> opt = userRepository.findById(id);
        if (opt.isEmpty()){
            throw new BadRequestException("Enter with id valid!");
        }
        return true;
    }
}
