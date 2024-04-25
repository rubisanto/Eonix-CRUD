package com.eonix.CRUD.userservice.model;

import jakarta.persistence.*;
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
@Table(name = "user_entity")
public class UserEntity {

    //ajout de la dépendance spring-boot-starter-validation pour les @notblank
    //ajout de la dépendance lombock pour le constructor, getter et setter


    // suite au warn par rapport à Hibernate avec la modification de id en type UUID, application de la query :
    //ALTER TABLE user_entity ALTER COLUMN id SET DATA TYPE UUID USING id::UUID;
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

}
