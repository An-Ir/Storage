package com.example.storage.infrastructure.validation;


import com.example.storage.domain.storage.Storage;
import com.example.storage.domain.user.User;
import com.example.storage.infrastructure.exception.BusinessException;

import java.util.List;
import java.util.Optional;

import static com.example.storage.infrastructure.validation.Error.*;


public class ValidationService {


    public static User getValidUser(Optional<User> optionalUser) {
        if (optionalUser.isEmpty()) {
            throw new BusinessException(INCORRECT_CREDENTIALS.getMessage(), INCORRECT_CREDENTIALS.getErrorCode());
        }
        return optionalUser.get();
    }

    public static void isExistByEmail(boolean emailExist) {
        if (emailExist) {
            System.out.println("Email already exists");
            throw new BusinessException(CONFLICTING_CREDENTIALS.getMessage(), CONFLICTING_CREDENTIALS.getErrorCode());
        }

    }

    public static void validateStoragesFound(List<Storage> filteredStorages) {
        if (filteredStorages.isEmpty()) {
            throw new BusinessException(NO_LOCATION_FOUND.getMessage(), NO_LOCATION_FOUND.getErrorCode());
        }
    }
}
