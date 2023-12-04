package com.example.storage.business.login;

import com.example.storage.business.login.dto.LoginResponse;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Resource
    private LoginService loginService;

    @GetMapping("/login")
    public LoginResponse login(@RequestParam String email, @RequestParam String password) {
        return loginService.login(email, password);

    }
}
