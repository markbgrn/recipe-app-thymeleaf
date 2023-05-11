package com.groupone.recipeappbackend.user.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
@Data
@Builder
public class LoginFormDto {
    @NotBlank(message = "Email address should not be blank.")
    @Email
    private String email;
    @NotBlank
    private String password;
}
