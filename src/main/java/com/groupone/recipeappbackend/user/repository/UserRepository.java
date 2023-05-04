package com.groupone.recipeappbackend.user.repository;

import com.groupone.recipeappbackend.user.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserModel, Long> {
}
