package com.example.product.dto;

import lombok.Data;

@Data
public class ChangePasswordAppUser {

    private String email;

    private String oldPassword;

    private String newPassword;

    private String confirmPassword;
}
