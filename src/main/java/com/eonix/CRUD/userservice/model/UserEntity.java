package com.eonix.CRUD.userservice.model;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class UserEntity {

    //ajout de la dépendance spring-boot-starter-validation pour les @notblank
    //ajout de la dépendance lombock pour le constructor, getter et setter

    @Id
    private String id;

    @NotBlank(message = "First Name must not be empty")
    private String firstName;

    @NotBlank(message = "Last Name must not be empty")
    private String lastName;

}
