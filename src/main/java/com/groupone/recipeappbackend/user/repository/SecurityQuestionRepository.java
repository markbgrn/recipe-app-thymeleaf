package com.groupone.recipeappbackend.user.repository;

import com.groupone.recipeappbackend.user.model.SecurityQuestion;
import org.springframework.data.jpa.repository.JpaRepository;
public interface SecurityQuestionRepository extends JpaRepository<SecurityQuestion, Long> {
}