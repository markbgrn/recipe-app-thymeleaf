package com.groupone.recipeappbackend.users.repository;

import com.groupone.recipeappbackend.users.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users, Long> {
}
