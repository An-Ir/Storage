package com.example.storage.domain.user;


import com.example.storage.business.Status;
import com.example.storage.infrastructure.validation.ValidationService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Resource
    private UserRepository userRepository;


    public User findUserBy(String email, String password) {
        Optional<User> optionalUser = userRepository.findUserBy(email, password, Status.ACTIVE);
        return ValidationService.getValidUser(optionalUser);
    }

    public User createUser(User user) {

        return userRepository.save(user);
    }

    public boolean isExistByEmail(String email) {
        return userRepository.existByEmail(email);
    }
}
