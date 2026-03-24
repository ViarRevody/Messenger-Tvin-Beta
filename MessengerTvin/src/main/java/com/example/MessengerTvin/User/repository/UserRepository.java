package com.example.MessengerTvin.User.repository;

import com.example.MessengerTvin.User.entity.Status;
import com.example.MessengerTvin.User.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findAllByStatus(Status status);

    User findByUserName(String username);
}