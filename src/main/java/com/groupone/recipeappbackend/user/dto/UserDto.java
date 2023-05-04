package com.groupone.recipeappbackend.user.dto;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
@Builder
public class UserDto {
    @NotEmpty
    private String email;
    @NotEmpty
    private String password;
    @NotEmpty
    private String confirmPassword;
    @NotEmpty
    private String firstname;
    @NotEmpty
    private String lastname;
    @NotEmpty
    private long security_question_1_id;
    @NotEmpty
    private long security_question_1_answer;
    @NotEmpty
    private long security_question_2_id;
    @NotEmpty
    private long security_question_2_answer;
}
