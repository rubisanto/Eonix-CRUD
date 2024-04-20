package com.eonix.CRUD.userservicetest.model;

import com.eonix.CRUD.userservice.model.UserEntity;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserEntityTest {

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
}
