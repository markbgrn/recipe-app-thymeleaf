package com.groupone.recipeappbackend.users.repository;

import com.groupone.recipeappbackend.users.model.UsersDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersDetailsRepository extends JpaRepository<UsersDetails,Long> {
}
