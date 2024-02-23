package com.lemin.test.admin.controllers;
import com.lemin.test.admin.dtos.AuthDto;
import com.lemin.test.admin.dtos.UserDto;
import com.lemin.test.admin.dtos.UserRole;
import com.lemin.test.admin.services.AuthService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Auth")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping
    public UserDto logIn(@RequestBody AuthDto authDto) {
    return  authService.logIn(authDto);
}

    @PostMapping("loginrole")
    public UserRole log(@RequestBody AuthDto authDto) {
        return  authService.log(authDto);
    }
}
