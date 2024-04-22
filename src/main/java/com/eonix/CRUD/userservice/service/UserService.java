package com.eonix.CRUD.userservice.service;

import com.eonix.CRUD.userservice.dto.UserDto;

import java.util.List;
import java.util.UUID;

public interface UserService {
    UserDto createUser(UserDto userDto);
    List<UserDto> getAllUsers();

    // trouver par l'id
    UserDto getUserById(UUID id);

    UserDto updateUser(UserDto userDto, UUID id);

    void deleteUserId(UUID id);



}
