package com.krish.booklibrary.service;

import com.krish.booklibrary.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> getUsers();

    Optional<User> getUser(String username);
}
