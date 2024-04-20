package com.eonix.CRUD.userservice.controller;

import com.eonix.CRUD.userservice.dto.UserDto;
import com.eonix.CRUD.userservice.model.UserEntity;
import com.eonix.CRUD.userservice.repository.UserRepository;
import com.eonix.CRUD.userservice.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
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

    @PostMapping("users/create")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto) {
        return new ResponseEntity<>(userService.createUser(userDto), HttpStatus.CREATED);
    }

    //se référer au MongoRepository pour les méthodes
    @GetMapping("users/{id}")
    public ResponseEntity<UserEntity> getUserById(@PathVariable UUID id) {
        Optional<UserEntity> user = userRepository.findById(id);
        if (user.isPresent()) {
            return ResponseEntity.ok(user.get());
        } else {
            return ResponseEntity.notFound().build();
        }

    }

    @PutMapping("users/{id}/update")
    public ResponseEntity<UserEntity> updateUser(@PathVariable("id") UUID id, @Valid @RequestBody UserEntity userDetails) {
        //gérer la modification et l'enregistrement en BDD ou erreur
        return userRepository.findById(id)
                .map(user -> {
                    user.setFirstName(userDetails.getFirstName());
                    user.setLastName(userDetails.getLastName());
                    UserEntity updatedUser = userRepository.save(user);
                    return ResponseEntity.ok(updatedUser);
                }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("users/{id}/delete")
    public ResponseEntity<Void> deleteUser(@PathVariable UUID id ) {
        return userRepository.findById(id)
                .map(user -> {
                    userRepository.delete(user);
                    return ResponseEntity.ok().<Void>build();
                }).orElse(ResponseEntity.notFound().build());
    }


}
