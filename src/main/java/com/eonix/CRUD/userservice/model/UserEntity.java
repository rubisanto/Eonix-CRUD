package com.eonix.CRUD.userservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class UserEntity {

    //ajout de la dépendance spring-boot-starter-validation pour les @notblank
    //ajout de la dépendance lombock pour le constructor, getter et setter


    // suite au warn par rapport à Hibernate avec la modification de id en type UUID, application de la query :
    //ALTER TABLE user_entity ALTER COLUMN id SET DATA TYPE UUID USING id::UUID;
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotBlank(message = "First Name must not be empty")
    private String firstName;

    @NotBlank(message = "Last Name must not be empty")
    private String lastName;

}
