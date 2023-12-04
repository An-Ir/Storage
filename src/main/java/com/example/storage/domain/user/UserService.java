package com.example.storage.domain.user;


import com.example.storage.business.Status;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Resource
    private UserRepository userRepository;


    public User findUserBy(String email, String password) {
        return userRepository.findUserBy(email, password, Status.ACTIVE);
    }
}
