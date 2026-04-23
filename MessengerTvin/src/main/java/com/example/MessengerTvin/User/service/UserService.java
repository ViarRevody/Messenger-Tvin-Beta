package com.example.MessengerTvin.User.service;

import com.example.MessengerTvin.User.entity.Status;
import com.example.MessengerTvin.User.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService extends UserDetailsService {

    void saveUser(User user);

    void disconnect(User user);

    List<User> findAllByStatus();

    User findByUsername(String username);
}
