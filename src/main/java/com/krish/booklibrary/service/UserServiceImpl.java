package com.krish.booklibrary.service;

import com.krish.booklibrary.model.User;
import com.krish.booklibrary.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository repository;
    public UserServiceImpl(UserRepository userRepository){
        this.repository=userRepository;
    }

    @Override
    public List<User> getUsers(){
        return repository.findAll();
    }

    @Override
    public Optional<User> getUser(String username ){
        return repository.findByUsername(username);
    }
}
