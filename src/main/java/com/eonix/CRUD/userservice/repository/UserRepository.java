package com.eonix.CRUD.userservice.repository;

import com.eonix.CRUD.userservice.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
    //possibilité de rajouter des méthodes supplémentaires ici
    //toutes les méthodes du MongoRepository sont disponibles

}
