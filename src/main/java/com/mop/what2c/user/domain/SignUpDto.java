package com.mop.what2c.user.domain;

import jakarta.persistence.Column;
import lombok.Getter;

@Getter
public class SignUpDto {
    private String username;
    private String password;
}
