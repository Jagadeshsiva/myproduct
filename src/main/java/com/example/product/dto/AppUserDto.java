package com.example.product.dto;

import com.example.product.entity.Role;
import lombok.Data;

@Data
public class AppUserDto {

    private String name;

    private String email;

    private Role role;

    private String password;

}
