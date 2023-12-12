package com.example.storage.domain.profile;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class ProfileService {

    @Resource
    private ProfileRepository profileRepository;

    public Profile createProfile(Profile profile) {
        return profileRepository.save(profile);
    }

    public Profile getProfile(Integer userId) {
        return profileRepository.findByUserId(userId);
    }
}
