package com.example.storage.business.profile;

import com.example.storage.business.profile.dto.UserInfo;
import com.example.storage.infrastructure.error.ApiError;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

@RestController
public class UsersController {

    @Resource
    private UsersService usersService;

    @PostMapping("/register")
    @Operation(summary = "Uue kasutaja registreerimine",
    description = "Uute objektide lisamine tabelitesse user ja profile")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "403", description = "Selline kasutaja on juba loodud", content = @Content(schema = @Schema(implementation = ApiError.class)))
    })
    public void registerNewUser(@RequestBody UserInfo userInfo) {

        usersService.registerNewUser(userInfo);
    }

    @GetMapping("/profile")
    @Operation(summary = "Tagastab kasutaja andmed profiilivaatesse")
    public UserInfo getUserInfo(@RequestParam Integer userId) {
        return usersService.getUserInfo(userId);

    }
}
