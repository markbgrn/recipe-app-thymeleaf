package com.groupone.recipeappbackend.user.repository;

import com.groupone.recipeappbackend.user.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<UserModel, Long> {
    List<UserModel> findByEmail(String email);
}
