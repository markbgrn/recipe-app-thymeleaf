package com.groupone.recipeappbackend.user.service;

import com.groupone.recipeappbackend.user.dto.LoginFormDto;
import com.groupone.recipeappbackend.user.dto.UserDto;
import com.groupone.recipeappbackend.user.model.UserModel;

public interface UserService {
    UserModel saveUser(UserDto userDto);
    void updateUser(UserDto userDto);
    void setUserVerified(String verificationId);

    UserModel loginUser(LoginFormDto loginFormDto);

    UserModel findByEmail(String email);
}
