package com.example.product.service;

import com.example.product.dto.AppUserDto;
import com.example.product.dto.ChangePasswordAppUser;
import com.example.product.dto.LoginRequestDto;
import com.example.product.entity.AppUser;
import com.example.product.repository.AppUserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class AppUserImpl implements AppUserInterface{
    @Autowired
    private AppUserRepository appUserRepository;

    @Override
    public List<AppUser> getAll() {
        return appUserRepository.findAll();
    }

    @Override
    public AppUser saveAppUser(AppUserDto user) {
        try {
            AppUser u = new AppUser();
            System.out.println(user);

            u.setName(user.getName());
            u.setEmail(user.getEmail());
            u.setPassword(user.getPassword());
            u.setRole(user.getRole());

            LocalDateTime date = LocalDateTime.now();

            u.setCrdTimes(date);
            return appUserRepository.save(u);
        }
        catch (Exception e){
            throw new RuntimeException("something invalid data");
        }
    }

    @Override
    public AppUser login(LoginRequestDto loginRequestDto) {
        Optional<AppUser> user = appUserRepository.findByEmail(loginRequestDto.getEmail());
        if(user.isEmpty()){
            throw new EntityNotFoundException("Invalid email");
        }

        if(!user.get().getPassword().equals(loginRequestDto.getPassword())){
          throw new EntityNotFoundException("wrong password");
        }
        return user.get();
    }

    @Override
    public String changePasswordAppUser(ChangePasswordAppUser changePasswordAppUser) {
        Optional<AppUser> user = appUserRepository.findByEmail(changePasswordAppUser.getEmail());
        System.out.println("hello user "+user);

        if(!user.get().getPassword().equals(changePasswordAppUser.getOldPassword())){
            throw new RuntimeException("old password is not matching to current user password");
        }

        if(!changePasswordAppUser.getNewPassword().equals(changePasswordAppUser.getConfirmPassword())){
            throw new RuntimeException("these password should be same");
        }

        AppUser u = user.get();

        u.setPassword(changePasswordAppUser.getNewPassword());

        appUserRepository.save(u);

        return "password changed successfully";
    }

//ydtrduyguigtydsrtdfyufrtd
}