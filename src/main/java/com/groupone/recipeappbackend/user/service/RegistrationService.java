package com.groupone.recipeappbackend.user.service;

import com.groupone.recipeappbackend.user.dto.UserDto;
import com.groupone.recipeappbackend.user.helper.PasswordHash;
import com.groupone.recipeappbackend.user.model.UserModel;
import com.groupone.recipeappbackend.user.repository.UserRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.List;

@Service
public class RegistrationService {
    @Autowired
    UserRepository userRepository;

    public void validateRegistrationForm(UserDto userDto, BindingResult result) {
        if(!userDto.getPassword().equals(userDto.getConfirmPassword())) {
            result.addError( new FieldError("user", "confirmPassword", "Passwords do not match"));
        }

        List<UserModel> users = userRepository.findByEmail(userDto.getEmail());
        int size = users.size();

        if(size > 0) {
            result.addError( new FieldError("user", "email", "Email already registered"));
        }
    }
}
