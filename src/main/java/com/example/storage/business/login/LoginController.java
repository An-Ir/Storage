package com.example.storage.business.login;

import com.example.storage.business.login.dto.LoginResponse;
import com.example.storage.infrastructure.error.ApiError;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Resource
    private LoginService loginService;

    @GetMapping("/login")
    @Operation(summary = "Sisse logimine. Tagastab userId ja roleName.",
            description = """
                        Süsteemist otsitakse email ja password abil aktiivse kontoga kasutajat.
                        kui vastet ei leita, visatakse viga errorCode'iga 111
                    """)
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "403", description = "Vale kasutajanimi või parool", content = @Content(schema = @Schema(implementation = ApiError.class)))
    })
    public LoginResponse login(@RequestParam String email, @RequestParam String password) {

        return loginService.login(email, password);

    }
}
