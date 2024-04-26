package com.eonix.CRUD.userservicetest.repository;

import com.eonix.CRUD.userservice.model.UserEntity;
import com.eonix.CRUD.userservice.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class UserEntityRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private UserRepository userRepository;

    private UserEntity user1;
    private UserEntity user2;

    @BeforeEach
    public void setUp() {
        user1 = new UserEntity();
        user1.setId(UUID.randomUUID());
        user1.setFirstName("John");
        user1.setLastName("Doe");
        entityManager.merge(user1);

        user2 = new UserEntity();
        user2.setId(UUID.randomUUID());
        user2.setFirstName("Jane");
        user2.setLastName("Doe");
        entityManager.merge(user2);
    }

    @Test
    public void customSearchReturnsUsersWithMatchingName() {
        List<UserEntity> users = userRepository.customSearch("Doe");
        assertThat(users).hasSize(2).extracting(UserEntity::getFirstName).containsOnly(user1.getFirstName(), user2.getFirstName());
    }

    @Test
    public void customSearchReturnsEmptyListWhenNoMatch() {
        List<UserEntity> users = userRepository.customSearch("Smith");
        assertThat(users).isEmpty();
    }

    @Test
    public void customSearchIsCaseInsensitive() {
        List<UserEntity> users = userRepository.customSearch("doe");
        assertThat(users).hasSize(2).extracting(UserEntity::getFirstName).containsOnly(user1.getFirstName(), user2.getFirstName());
    }
}