package com.groupone.recipeappbackend.user.dto;

import com.groupone.recipeappbackend.user.dto.validator.PasswordMatch;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.*;




@Getter
@Setter
@Data
@Builder
@PasswordMatch(message="Passwords must match")
public class UserDto {

    @NotBlank(message = "This field should not be blank")
    @Email(message = "Please enter a valid email address")
    private String email;
    @NotBlank(message = "This field should not be blank")
    @Length(min = 8, max = 64, message = "Password length should be between 8 and 64 characters")
    private String password;
    @NotBlank(message = "This field should not be blank")
    private String confirmPassword;
    @NotBlank(message = "This field should not be blank")
    private String firstname;
    @NotBlank(message = "This field should not be blank")
    private String lastname;
    private String verificationId;
    private Boolean isVerified;

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
