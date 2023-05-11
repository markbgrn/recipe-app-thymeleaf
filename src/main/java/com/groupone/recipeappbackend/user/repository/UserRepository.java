package com.groupone.recipeappbackend.user.repository;

import com.groupone.recipeappbackend.user.dto.UserDto;
import com.groupone.recipeappbackend.user.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;


public interface UserRepository extends JpaRepository<UserModel, Long> {

    UserModel findByVerificationId(String verificationId);

    UserModel findByEmail(String email);
//    UserModel findByUsername(String username);

    UserModel findFirstByEmail(String email);
}
