package com.groupone.recipeappbackend.user.dto.validator;


import com.groupone.recipeappbackend.user.dto.UserDto;
import com.groupone.recipeappbackend.user.model.UserModel;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordMatchValidator implements ConstraintValidator<PasswordMatch, UserDto> {
    @Override
    public void initialize(PasswordMatch p) {

    }

    public boolean isValid(UserDto user, ConstraintValidatorContext c) {
        String password = user.getPassword();
        String confirmPassword = user.getConfirmPassword();

        if(password == null || !password.equals(confirmPassword)) {
            return false;
        }

        return true;
    }
}