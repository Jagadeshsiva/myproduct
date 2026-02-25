package com.example.product.controller;

import com.example.product.dto.AppUserDto;
import com.example.product.dto.ChangePasswordAppUser;
import com.example.product.dto.LoginRequestDto;
import com.example.product.entity.AppUser;
import com.example.product.service.AppUserInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AppUserController {

    @Autowired
    private AppUserInterface appUserInterface;

    @GetMapping("getAll")
    public List<AppUser> getAll(){
        return appUserInterface.getAll();
    }

    @PostMapping("save")
    public AppUser saveAppUser(@RequestBody AppUserDto user){
        return appUserInterface.saveAppUser(user);
    }

    @PostMapping("login")
    public AppUser login(@RequestBody LoginRequestDto loginRequestDto){
        return appUserInterface.login(loginRequestDto);
    }

    @PostMapping("/changepassword")
    public String changePasswordAppUser(@RequestBody ChangePasswordAppUser changePasswordAppUser){
        return appUserInterface.changePasswordAppUser(changePasswordAppUser);
    }
}
