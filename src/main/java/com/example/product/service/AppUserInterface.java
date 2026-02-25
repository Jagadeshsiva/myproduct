package com.example.product.service;

import com.example.product.dto.AppUserDto;
import com.example.product.dto.ChangePasswordAppUser;
import com.example.product.dto.LoginRequestDto;
import com.example.product.entity.AppUser;

import java.util.List;

public interface AppUserInterface {
    List<AppUser> getAll();

    AppUser saveAppUser(AppUserDto user);

    AppUser login(LoginRequestDto loginRequestDto);

    String changePasswordAppUser(ChangePasswordAppUser changePasswordAppUser);
}
