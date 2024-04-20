package com.eonix.CRUD.userservice.repository;

import com.eonix.CRUD.userservice.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, UUID>{
    //possibilité de rajouter des méthodes supplémentaires ici
    //toutes les méthodes du JpaRepository sont disponibles

}
