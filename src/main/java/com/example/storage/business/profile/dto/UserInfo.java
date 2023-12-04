package com.example.storage.business.profile.dto;

import lombok.Data;

@Data
public class UserInfo {
    private Integer roleId;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
}
