package com.example.MessengerTvin.User.service;

import com.example.MessengerTvin.User.entity.Status;
import com.example.MessengerTvin.User.entity.User;
import com.example.MessengerTvin.User.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private  UserRepository userRepository;


    @Override
    public void saveUser(User user) {
        user.setStatus(Status.ONLINE);
        userRepository.save(user);
    }

    @Override
    public void disconnect(User user) {
        var storedUser =userRepository.findByUserName(user.getUsername());
        if(storedUser!=null && storedUser.getStatus() !=Status.ONLINE){
            storedUser.setStatus(Status.OFFLINE);
            userRepository.save(user);
        }
    }

    @Override
    public List<User> findAllByStatus() {

        return userRepository.findAllByStatus(Status.ONLINE);
    }

    @Override
    public User findByUsername(String username) {

        return userRepository.findByUserName(username);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user =userRepository.findByUserName(username);
        if(user==null){
            throw new UsernameNotFoundException(username);
        }
        return user;
    }
}
