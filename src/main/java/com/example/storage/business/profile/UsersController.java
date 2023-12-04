package com.example.storage.business.profile;

import com.example.storage.business.profile.dto.UserInfo;
import com.example.storage.domain.user.UserService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsersController {

    @Resource
    private UsersService usersService;

    @PostMapping("/user")
    public void registerNewUser(@RequestBody UserInfo userInfo) {
        usersService.registerNewUser(userInfo);
    }
}
