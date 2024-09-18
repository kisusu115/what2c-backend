package com.mop.what2c.user.controller;

import com.mop.what2c.user.domain.SignUpDto;
import com.mop.what2c.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/sign-up")
    public String signUpProcess(@RequestBody SignUpDto signUpDto) {

        System.out.println(signUpDto.getUsername());
        userService.joinProcess(signUpDto);

        return "ok";
    }
}
