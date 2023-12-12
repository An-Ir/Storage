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
        ValidationService.isExistByEmail(existByEmail);
        User userEntity = createAndSaveUser(userInfo);
        createAndSaveProfile(userInfo, userEntity);
    }

    private User createAndSaveUser(UserInfo userInfo) {
        User userEntity = userMapper.toEntity(userInfo);
        userEntity.setStatus(ACTIVE);
        userService.createUser(userEntity);
        return userEntity;
    }

    private void createAndSaveProfile(UserInfo userInfo, User userEntity) {
        Profile profileEntity = profileMapper.toEntity(userInfo);
        profileEntity.setUser(userEntity);
        profileService.createProfile(profileEntity);
    }

    public UserInfo getUserInfo(Integer userId) {
        Profile profile = profileService.getProfile(userService.getUserBy(userId).getId());
        return profileMapper.toUserInfo(profile);
    }

}
