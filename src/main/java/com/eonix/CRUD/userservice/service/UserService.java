package com.eonix.CRUD.userservice.service;

import com.eonix.CRUD.userservice.dto.UserDto;

import java.util.List;

public interface UserService {
    UserDto createUser(UserDto userDto);
    List<UserDto> getAllUsers();



}
