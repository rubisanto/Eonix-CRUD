package com.eonix.CRUD.userservice.repository;

import com.eonix.CRUD.userservice.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, UUID>{
    //possibilité de rajouter des méthodes supplémentaires ici
    //toutes les méthodes du JpaRepository sont disponibles

    //méthode pour la recherche par nom et prénom personnalisé
    //query slq
    @Query("SELECT u FROM UserEntity u WHERE " +
            "(LOWER(u.firstName) LIKE LOWER(CONCAT('%', :name, '%')) OR " +
            "LOWER(u.lastName) LIKE LOWER(CONCAT('%', :name, '%')))")
    List<UserEntity> customSearch(@Param("name") String name);

}
