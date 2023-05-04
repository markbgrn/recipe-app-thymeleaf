package com.groupone.recipeappbackend.user.service;

import com.groupone.recipeappbackend.user.dto.UserDto;
import com.groupone.recipeappbackend.user.model.UserModel;

public interface UserService {
    UserModel saveUser(UserDto userDto);
}
