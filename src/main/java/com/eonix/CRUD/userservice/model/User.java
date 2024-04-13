package com.eonix.CRUD.userservice.model;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@NoArgsConstructor
@Document
public class User {

    //ajout de la dépendance spring-boot-starter-validation pour les @notblank
    //ajout de la dépendance lombock pour le constructor, getter et setter

    @Id
    private String id;

    @NotBlank(message = "First Name must not be empty")
    private String firstName;

    @NotBlank(message = "Last Name must not be empty")
    private String lastName;
}
