package com.eonix.CRUD.userservicetest.model;

import com.eonix.CRUD.userservice.model.User;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserTest {

    @Test
    void testGettersSetters() {
        //Arrange
        User user = new User();

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
