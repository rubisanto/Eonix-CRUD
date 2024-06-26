package com.eonix.CRUD.userservice.service.impl;

import com.eonix.CRUD.userservice.dto.UserDto;
import com.eonix.CRUD.userservice.exceptions.UserNotFoundException;
import com.eonix.CRUD.userservice.model.UserEntity;
import com.eonix.CRUD.userservice.repository.UserRepository;
import com.eonix.CRUD.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService{
    @Override
    public UserDto getUserById(UUID id) {
        UserEntity userEntity = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User could not be found"));
        return mapToDto(userEntity);
    }

    @Override
    public UserDto updateUser(UserDto userDto, UUID id) {
        //trouver le bon user
        UserEntity userEntity = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User could not be updated"));

        //mettre à jour avec les nouvelles data
        userEntity.setFirstName(userDto.getFirstName());
        userEntity.setLastName(userDto.getLastName());

        //return l'entity par le dto car sinon bug de type
        UserEntity updatedUser = userRepository.save(userEntity);

        return mapToDto(updatedUser);
    }

    @Override
    public void deleteUserId(UUID id) {
        UserEntity userEntity = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User could not be deleted"));
        userRepository.delete(userEntity);
    }

    @Override
    public List<UserDto> customSearch(String name) {
        List<UserEntity> userEntities = userRepository.customSearch(name);
        return userEntities.stream().map(userEntity -> mapToDto(userEntity)).collect(Collectors.toList());
    }

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

        return mapToDto(newUser);
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
        userDto.setFirstName(userEntity.getFirstName());
        userDto.setLastName(userEntity.getLastName());
        return userDto;
    }

    //mapper inverse
    private UserEntity mapToEntity(UserDto userDto) {
        UserEntity userEntity = new UserEntity();

        userEntity.setFirstName(userDto.getFirstName());
        userEntity.setLastName(userDto.getLastName());
        return userEntity;
    }
}
