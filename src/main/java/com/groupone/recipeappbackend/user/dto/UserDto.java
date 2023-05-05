package com.groupone.recipeappbackend.user.dto;

import com.groupone.recipeappbackend.user.dto.validator.PasswordMatch;
import com.groupone.recipeappbackend.user.helper.PasswordHash;
import com.groupone.recipeappbackend.user.model.SecurityQuestion;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.*;




@Getter
@Setter
@Data
@Builder
@PasswordMatch(message="Passwords must match")
public class UserDto {

    @NotBlank
    @Email
    private String email;
    @NotBlank
    @Length(min = 8, max = 64)
    private String password;
    @NotBlank
    private String confirmPassword;
    @NotBlank
    private String firstname;
    @NotBlank
    private String lastname;

//    @NotBlank
//    private SecurityQuestion securityQuestion1;
//    @NotBlank
//    private SecurityQuestion securityQuestion2;
//    @NotEmpty
//    private long security_question_1_id;
//    @NotEmpty
//    private long security_question_1_answer;
//    @NotEmpty
//    private long security_question_2_id;
//    @NotEmpty
//    private long security_question_2_answer;
}
