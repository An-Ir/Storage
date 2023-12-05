package com.example.storage.business.profile;

import com.example.storage.business.profile.dto.UserInfo;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UsersController {

    @Resource
    private UsersService usersService;

    @PostMapping("/register")
    public void registerNewUser(@RequestBody UserInfo userInfo) {
        System.out.println("received new user info: " + userInfo);
        usersService.registerNewUser(userInfo);
    }
}
