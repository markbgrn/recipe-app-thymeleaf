package com.groupone.recipeappbackend.comment.repository;

import com.groupone.recipeappbackend.comment.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
