package com.eonix.CRUD.userservicetest.repository;

import com.eonix.CRUD.userservice.model.UserEntity;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;



@DataMongoTest
public class UserEntityRepositoryTest {
    // test du repository
    @Test
    void testGettersSetters() {
        //Arrange
        UserEntity user = new UserEntity();

        //Act
        user.setId("123e4567-e89b-12d3-a456-426614174000");
        user.setFirstName("Jeans");
        user.setLastName("Dupont");

        //Assert
        assertEquals("123e4567-e89b-12d3-a456-426614174000", user.getId());
        assertEquals("Jeans", user.getFirstName());
        assertEquals("Dupont", user.getLastName());

    }

    //test de la méthode getAll
    @Test
    void testGetAllUsers() {
        //Arrange avec 2 users
        UserEntity user1 = new UserEntity();
        user1.setId("123e4567-e89b-12d3-a456-426614174000");
        user1.setFirstName("Jeans");
        user1.setLastName("Dupont");

        UserEntity user2 = new UserEntity();
        user2.setId("123e4567-e89b-12d3-a456-426614174001");
        user2.setFirstName("Jeanne");
        user2.setLastName("Dupond");

        //Act pour getAll
        List<UserEntity> users = new ArrayList<>();
        users.add(user1);
        users.add(user2);

        //Assert
        assertEquals(2, users.size());
        assertEquals("123e4567-e89b-12d3-a456-426614174000", users.get(0).getId());
        assertEquals("Jeans", users.get(0).getFirstName());
        assertEquals("Dupont", users.get(0).getLastName());
        assertEquals("123e4567-e89b-12d3-a456-426614174001", users.get(1).getId());
        assertEquals("Jeanne", users.get(1).getFirstName());
        assertEquals("Dupond", users.get(1).getLastName());

    }
}
