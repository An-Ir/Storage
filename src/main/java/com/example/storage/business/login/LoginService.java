package com.example.storage.business.login;

import com.example.storage.business.login.dto.LoginResponse;
import com.example.storage.domain.user.User;
import com.example.storage.domain.user.UserMapper;
import com.example.storage.domain.user.UserService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Resource
    private UserService userService;

    @Resource
    private UserMapper userMapper;


    public LoginResponse login(String email, String password) {
        User user = userService.findUserBy(email, password);
        return userMapper.toLoginResponse(user);
    }
}
