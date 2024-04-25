package com.eonix.CRUD.userservice.controller;

import com.eonix.CRUD.userservice.dto.UserDto;
import com.eonix.CRUD.userservice.repository.UserRepository;
import com.eonix.CRUD.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import java.util.UUID;


@RestController
@RequestMapping("/api/")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    private UserRepository userRepository;

    @GetMapping("users")
    public ResponseEntity<List<UserDto>> getAllUsers() {
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }

    @GetMapping("users/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable UUID id) {
        return ResponseEntity.ok(userService.getUserById(id));

    }

    @GetMapping("users/search={name}")
    public ResponseEntity<List<UserDto>> getCustomUsers(@PathVariable String name ) {
        return new ResponseEntity<>(userService.customSearch(name), HttpStatus.OK);
    }

    @PostMapping("users/create")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto) {
        return new ResponseEntity<>(userService.createUser(userDto), HttpStatus.CREATED);
    }


    @PutMapping("users/{id}/update")
    public ResponseEntity<UserDto> updateUser(@PathVariable("id") UUID id, @RequestBody UserDto userDto) {
        UserDto response = userService.updateUser(userDto, id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("users/{id}/delete")
    public ResponseEntity<String> deleteUser(@PathVariable UUID id ) {
        userService.deleteUserId(id);
        return new ResponseEntity<>("User deleted", HttpStatus.OK);
    }


}
