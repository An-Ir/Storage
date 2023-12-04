package com.example.storage.business.login.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * DTO for {@link com.example.storage.domain.user.User}
 */
@Data
public class LoginResponse implements Serializable {
    private Integer userId;
    private String roleName;
}