package com.example.storage.business.profile;

import com.example.storage.business.profile.dto.UserInfo;
import com.example.storage.domain.profile.ProfileService;
import com.example.storage.domain.user.UserService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class UsersService {
    @Resource
    private UserService userService;
    @Resource
    private ProfileService profileService;

    public void registerNewUser(UserInfo userInfo) {
        userService.createNewUserProfile(userInfo);

    }
}
