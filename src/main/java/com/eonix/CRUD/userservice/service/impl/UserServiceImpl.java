package com.eonix.CRUD.userservice.service.impl;

import com.eonix.CRUD.userservice.dto.UserDto;
import com.eonix.CRUD.userservice.model.UserEntity;
import com.eonix.CRUD.userservice.repository.UserRepository;
import com.eonix.CRUD.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService{
    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDto createUser(UserDto userDto) {
        UserEntity userEntity = new UserEntity();
        userEntity.setFirstName(userDto.getFirstName());
        userEntity.setLastName(userDto.getLastName());

        UserEntity newUser = userRepository.save(userEntity);
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<UserEntity> userEntities = userRepository.findAll();
        //map car retourne une nouvelle liste
        return userEntities.stream().map(userEntity -> mapToDto(userEntity)).collect(Collectors.toList());
    }

    //utiliser un mapper pour transformer l'object entity en dto
    private UserDto mapToDto(UserEntity userEntity) {
        UserDto userDto = new UserDto();
        userDto.setId(userEntity.getId());
        userDto.setFirstName(userDto.getFirstName());
        userDto.setLastName(userDto.getLastName());
        return userDto;
    }

    //mapper inverse
    private UserEntity mapToEntity(UserDto userDto) {
        UserEntity userEntity = new UserEntity();

        userEntity.setFirstName(userDto.getFirstName());
        userEntity.setLastName(userEntity.getLastName());
        return userEntity;
    }
}
