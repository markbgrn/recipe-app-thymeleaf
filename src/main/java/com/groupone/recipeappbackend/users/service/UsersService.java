package com.groupone.recipeappbackend.users.service;

import com.groupone.recipeappbackend.users.dto.LoginFormDto;
import com.groupone.recipeappbackend.users.model.Users;

public interface UsersService {
    Users loginUser(LoginFormDto loginFormDto);

    Users findByEmail(String email);
}
