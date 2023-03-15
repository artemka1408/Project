package com.example.projectmanager.repository;

import com.example.projectmanager.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> deleteUserById(Long id);

    @Query("SELECT e FROM User e WHERE e.login = :login")
    Optional<User> findUserByLogin(String login);
}
