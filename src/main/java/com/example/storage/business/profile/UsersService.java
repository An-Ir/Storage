package com.example.storage.business.profile;

import com.example.storage.business.profile.dto.UserInfo;
import com.example.storage.domain.profile.Profile;
import com.example.storage.domain.profile.ProfileMapper;
import com.example.storage.domain.profile.ProfileService;
import com.example.storage.domain.user.User;
import com.example.storage.domain.user.UserMapper;
import com.example.storage.domain.user.UserService;
import com.example.storage.infrastructure.validation.ValidationService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import static com.example.storage.business.Status.ACTIVE;

@Service
public class UsersService {
    @Resource
    private UserService userService;
    @Resource
    private ProfileService profileService;
    @Resource
    private UserMapper userMapper;

    @Resource
    private ProfileMapper profileMapper;

    public void registerNewUser(UserInfo userInfo) {
        boolean existByEmail = userService.isExistByEmail(userInfo.getEmail());
        System.out.println("Check already exist");
        ValidationService.isExistByEmail(existByEmail);
        User userEntity = createAndSaveUser(userInfo);
        createAndSaveProfile(userInfo, userEntity);
    }

    private void createAndSaveProfile(UserInfo userInfo, User userEntity) {
        System.out.println("create new profile");
        Profile profileEntity = profileMapper.toEntity(userInfo);
        System.out.println("created new profile: " + profileEntity);
        profileEntity.setUser(userEntity);
        System.out.println("Profile before DB: " + profileEntity);
        profileService.createProfile(profileEntity);
        System.out.println("saved profile: " + profileEntity);
    }

    private User createAndSaveUser(UserInfo userInfo) {
        System.out.println("create new user");
        User userEntity = userMapper.toEntity(userInfo);
        userEntity.setStatus(ACTIVE);
        System.out.println("created new user: " + userEntity);
        userService.createUser(userEntity);
        System.out.println("saved user: " + userEntity);
        return userEntity;
    }


}
